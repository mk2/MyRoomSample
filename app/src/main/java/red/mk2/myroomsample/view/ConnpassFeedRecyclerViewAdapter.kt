package red.mk2.myroomsample.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import red.mk2.myroomsample.R
import red.mk2.myroomsample.entity.ConnpassFeedItem

class ConnpassFeedRecyclerViewAdapter(val context: Context, var dataset: List<ConnpassFeedItem>) : RecyclerView.Adapter<ConnpassFeedRecyclerViewAdapter.Companion.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.let {
            val title = dataset[position].title
            it.title.setText(title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.feed_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    companion object {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            val title: TextView
                get() = itemView.findViewById(R.id.title)

        }

    }
}