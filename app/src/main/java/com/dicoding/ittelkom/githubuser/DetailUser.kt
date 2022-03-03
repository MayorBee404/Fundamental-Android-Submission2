package com.dicoding.ittelkom.githubuser
import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

class DetailUser : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_user)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Detail User"

        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



    }
}