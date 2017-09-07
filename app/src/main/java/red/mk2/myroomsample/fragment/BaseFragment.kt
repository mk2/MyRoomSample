package red.mk2.myroomsample.fragment

import com.trello.rxlifecycle2.components.support.RxFragment
import red.mk2.myroomsample.activity.BaseActivity

abstract class BaseFragment : RxFragment() {

    val db
        get() = (activity as BaseActivity).db
}