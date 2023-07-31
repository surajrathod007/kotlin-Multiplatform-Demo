package com.surajrathod.kotlinmultiplatformdemo.android.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.surajrathod.kotlinmultiplatformdemo.Greeting
import com.surajrathod.kotlinmultiplatformdemo.android.BaseActivity
import com.surajrathod.kotlinmultiplatformdemo.android.R
import com.surajrathod.kotlinmultiplatformdemo.android.adapter.UserAdapter
import com.surajrathod.kotlinmultiplatformdemo.android.databinding.ActivityBasicViewBinding
import com.surajrathod.kotlinmultiplatformdemo.daysUntilNewYear
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BasicViewActivity : BaseActivity() {

    lateinit var rvUsers : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        putLayout(R.layout.activity_basic_view)
        rvUsers = findViewById(R.id.rvUsers)
        setToolBarTitle("Home")
        setupViews()
        loadData()
    }

    private fun loadData() {
        lifecycleScope.launch {
            withContext(Dispatchers.Main){
                showProgress()
            }
            val size = Greeting().loadData()
            withContext(Dispatchers.Main) {
                rvUsers.adapter = UserAdapter(size){
                    val user = Greeting().userToJson(it)
                    val i = Intent(this@BasicViewActivity,UserDetailsActivity::class.java)
                    i.putExtra("user",user)
                    startActivity(i)
                }
                hideProgress()
            }
        }
    }

    private fun setupViews() {

    }
}