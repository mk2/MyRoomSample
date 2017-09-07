package red.mk2.myroomsample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import red.mk2.myroomsample.dao.ConnpassFeedDao;
import red.mk2.myroomsample.entity.ConnpassFeedItem;

@Database(entities = {ConnpassFeedItem.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ConnpassFeedDao feedDao();

}
