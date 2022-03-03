package com.dicoding.ittelkom.githubuser

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.ittelkom.githubuser.ListUserAdapter.ListViewHolder

class ListUserAdapter(private val listUser : ArrayList<DataUser>):
    RecyclerView.Adapter<ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun getItemCount(): Int = listUser.size
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvUsername: TextView = itemView.findViewById(R.id.tv_item_username)
        var container: CardView = itemView.findViewById(R.id.card_view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]
        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions().override(300, 300))
            .into(holder.imgAvatar)
        holder.tvName.text = user.name
        holder.tvUsername.text = user.username
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
        }
        holder.container.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailUser::class.java)
            intent.putExtra(DetailUser.DATA, user)
            holder.itemView.context.startActivity(intent)

        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataUser)
    }
}

