package red.mk2.myroomsample.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "connpass_feed_item")
public class ConnpassFeedItem {

    @PrimaryKey
    @ColumnInfo(name = "feed_id")
    public String feedId = "";

    @ColumnInfo(name = "title")
    public String title = "";

    @ColumnInfo(name = "link")
    public String link = "";

    @ColumnInfo(name = "published")
    public String published = "";

    @ColumnInfo(name = "updated")
    public String updated = "";

    @ColumnInfo(name = "summary")
    public String summary = "";

    @ColumnInfo(name = "summary_type")
    public String summaryType = "";
}
