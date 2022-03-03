package com.dicoding.ittelkom.githubuser

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListUser : AppCompatActivity() {

    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<DataUser>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_user)

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        list.addAll(listUseres)
        showRecyclerList()
    }
    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUser.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUser.layoutManager = LinearLayoutManager(this)
        }
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter
        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {

            override fun onItemClicked(data: DataUser) {
                showSelectedHero(data)
            }
        })

    }
    private val listUseres: ArrayList<DataUser>
    get() {
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val listUser = ArrayList<DataUser>()
            for (position in dataName.indices) {
                val user = DataUser(
                    dataAvatar.getResourceId(position,-1),
                    dataName[position],
                    dataUsername[position],
                    dataLocation[position],
                    dataCompany[position],
                    dataRepository[position],
                    dataFollowers[position],
                    dataFollowing[position]
                )
                listUser.add(user)
            }
            dataAvatar.recycle()
            return listUser
        }
    private fun showSelectedHero(hero: DataUser) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }

}