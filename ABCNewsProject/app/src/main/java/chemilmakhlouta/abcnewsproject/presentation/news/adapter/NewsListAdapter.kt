package chemilmakhlouta.abcnewsproject.presentation.news.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import chemilmakhlouta.abcnewsproject.R
import chemilmakhlouta.abcnewsproject.domain.news.model.NewsObject
import kotlinx.android.synthetic.main.item_news.view.*
import java.lang.IllegalArgumentException

/**
 * Created by Chemil Makhlouta on 24/6/18.
 */
class NewsListAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var newsList: List<NewsObject> = listOf()

    private companion object {
        const val TOP_NEWS_ITEM = 0
    }

    private lateinit var listItemClickListener: OnNewsListItemClickListener
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)


    override fun getItemViewType(position: Int): Int = position

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val newsItem = newsList[position]
        with(holder.itemView) {
            title.text = newsItem.title
        }
    }

    override fun getItemCount(): Int = newsList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 0) {
            return TopNewsListItemViewHolder(layoutInflater.inflate(R.layout.item_top_news, parent, false))
        } else {
            return NormalNewsListItemViewHolder(layoutInflater.inflate(R.layout.item_news, parent, false))
        }
    }

    fun setNewsListItemClickListener(listener: OnNewsListItemClickListener) {
        listItemClickListener = listener
    }

    private class TopNewsListItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    private class NormalNewsListItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    interface OnNewsListItemClickListener {
        fun onNewsItemClicked()
    }

    fun setNewsList(news: MutableList<NewsObject>) {
        newsList = news
        notifyDataSetChanged()
    }

}
