package red.mk2.myroomsample.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import io.reactivex.Flowable;
import red.mk2.myroomsample.entity.ConnpassFeedItem;

import java.util.List;

@Dao
public interface ConnpassFeedDao {

    @Query("SELECT * FROM connpass_feed_item")
    Flowable<List<ConnpassFeedItem>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ConnpassFeedItem... items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ConnpassFeedItem> items);
}
