package red.mk2.myroomsample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_feed.*
import red.mk2.myroomsample.R
import red.mk2.myroomsample.service.ConnpassFeedService
import red.mk2.myroomsample.view.ConnpassFeedRecyclerViewAdapter

class FeedFragment : BaseFragment() {

    lateinit var adapter: ConnpassFeedRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_feed, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ConnpassFeedRecyclerViewAdapter(context, arrayListOf())
        feed_view.setRecyclerViewAdapter(adapter)

        ConnpassFeedService.fetch()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe { items ->
                    db.feedDao().insertAll(items)
                }

        db.feedDao().all.compose(bindToLifecycle()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            adapter.dataset = it
            adapter.notifyDataSetChanged()
        }

    }

    companion object {

        const val TAG = "FeedFragment"

        fun newInstance(): FeedFragment {
            return FeedFragment()
        }

    }
}