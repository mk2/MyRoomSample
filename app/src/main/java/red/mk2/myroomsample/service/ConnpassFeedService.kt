package red.mk2.myroomsample.service

import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.Request
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import red.mk2.myroomsample.entity.ConnpassFeedItem
import red.mk2.myroomsample.errorLog
import red.mk2.myroomsample.verboseLog

object ConnpassFeedService {

    private val client = OkHttpClient()

    private const val ConnpassFeedUrl = "https://connpass.com/explore/ja.atom"


    fun fetch(): Single<List<ConnpassFeedItem>> {
        return Single.create({ emitter ->
            val items = arrayListOf<ConnpassFeedItem>()
            try {
                val req = Request.Builder().url(ConnpassFeedUrl).build()
                val res = client.newCall(req).execute()
                val factory = XmlPullParserFactory.newInstance();
                factory.isNamespaceAware = true
                val parser = factory.newPullParser()
                parser.setInput(res.body()?.byteStream(), "UTF-8")
                var eventType = parser.eventType
                var item = ConnpassFeedItem()
                loop@ while (eventType != XmlPullParser.END_DOCUMENT) {
                    verboseLog { "Start loop" }
                    when (eventType) {
                        XmlPullParser.START_DOCUMENT -> {
                        }
                        XmlPullParser.START_TAG -> {
                            verboseLog { "Start: <${parser.name}>" }
                            when (parser.name) {
                                "id" -> item.feedId = parser.nextText()
                                "title" -> item.title = parser.nextText()
                                "link" -> item.link = parser.getAttributeValue(null, "href")
                                "published" -> item.published = parser.nextText()
                                "updated" -> item.updated = parser.nextText()
                                "summary" -> {
                                    item.summaryType = parser.getAttributeValue(null, "type")
                                    item.summary = parser.nextText()
                                }
                            }
                        }
                        XmlPullParser.END_TAG -> {
                            when (parser.name) {
                                "entry" -> {
                                    verboseLog { "End: <${parser.name}>" }
                                    items.add(item)
                                    item = ConnpassFeedItem()
                                }
                            }
                        }
                        else -> {
                        }
                    }
                    eventType = parser.next()
                }
                emitter.onSuccess(items)
            } catch (e: Throwable) {
                errorLog { e.toString() }
                if (items.size > 0) {
                    emitter.onSuccess(items)
                } else {
                    emitter.onError(e)
                }
            }
        })
    }

}