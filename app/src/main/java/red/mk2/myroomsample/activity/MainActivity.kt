package red.mk2.myroomsample.activity

import android.os.Bundle
import red.mk2.myroomsample.R
import red.mk2.myroomsample.fragment.FeedFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fm.beginTransaction().replace(R.id.content, FeedFragment.newInstance(), FeedFragment.TAG).commit()
    }
}
