package red.mk2.myroomsample

import android.app.Application
import android.arch.persistence.room.Room
import android.util.Log

class App : Application() {

    lateinit var db: AppDatabase

    val context
        get() = applicationContext

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(context, AppDatabase::class.java, "room-sample").build()
    }
}

@Suppress("unused")
inline fun Any.verboseLog(thunk: () -> String) {
    if (BuildConfig.DEBUG) {
        Log.v(this.javaClass.name, thunk());
    }
}


@Suppress("unused")
inline fun Any.errorLog(thunk: () -> String) {
    if (BuildConfig.DEBUG) {
        Log.e(this.javaClass.name, thunk());
    }
}
