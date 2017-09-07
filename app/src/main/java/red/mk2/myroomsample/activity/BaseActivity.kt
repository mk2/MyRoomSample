package red.mk2.myroomsample.activity

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import red.mk2.myroomsample.App

abstract class BaseActivity : RxAppCompatActivity() {

    val db
        get() = (application as App).db

    val fm
        get() = supportFragmentManager
}