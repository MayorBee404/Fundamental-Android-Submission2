package com.dicoding.ittelkom.githubuser
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class DetailUser : AppCompatActivity() {

    companion object {
        const val DATA = "data"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_user)
        val data : DataUser? = intent.getParcelableExtra(DATA)
        val tvAvatar : ImageView = this.findViewById(R.id.detail_avatar)
        val tvUsername: TextView = this.findViewById(R.id.detail_username)
        val tvname : TextView = this.findViewById(R.id.detail_name)
        val tvLocation : TextView = this.findViewById(R.id.detail_location)
        val tvFollowing : TextView = this.findViewById(R.id.detail_following)
        val tvFollower : TextView = this.findViewById(R.id.detail_followers)
        val tvRepository : TextView = this.findViewById(R.id.detail_repository)
        val tvCompany : TextView = this.findViewById(R.id.detail_company)

        tvname.text = data?.name
        if (data != null) {
            tvAvatar.setImageResource(data.avatar)
        }
        tvUsername.text = data?.username
        tvLocation.text = data?.location
        tvCompany.text = data?.company
        tvFollower.text = "Follower : ${data?.followers}"
        tvFollowing.text = "Following : ${data?.following}"
        tvRepository.text = "Repository : ${data?.repository}"
    }

}