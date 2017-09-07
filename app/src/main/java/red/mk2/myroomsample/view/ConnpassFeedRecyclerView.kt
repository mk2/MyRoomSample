package red.mk2.myroomsample.view

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet

class ConnpassFeedRecyclerView(context: Context, attrs: AttributeSet) : RecyclerView(context, attrs) {
    fun setRecyclerViewAdapter(adapter: ConnpassFeedRecyclerViewAdapter) {
        layoutManager = LinearLayoutManager(context)
        setAdapter(adapter)
    }
}