package com.surajrathod.kotlinmultiplatformdemo.android.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.surajrathod.kotlinmultiplatformdemo.Greeting
import com.surajrathod.kotlinmultiplatformdemo.android.BaseActivity
import com.surajrathod.kotlinmultiplatformdemo.android.R
import com.surajrathod.kotlinmultiplatformdemo.android.databinding.ActivityUserDetailsBinding
import com.surajrathod.kotlinmultiplatformdemo.model.UsersItem

class UserDetailsActivity : BaseActivity() {


    lateinit var txtUserName : TextView
    lateinit var txtUserAddress : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        putLayout(R.layout.activity_user_details)

        setToolBarTitle("Details")
        enableBack()
        txtUserName = findViewById(R.id.txtUserNameDetails)
        txtUserAddress = findViewById(R.id.txtUserAddress)
        val data = intent.getStringExtra("user") ?: ""
        val user = Greeting().jsonToUser(data = data)
        Toast.makeText(this,user.toString(),Toast.LENGTH_LONG).show()
        setUpUser(user)
    }

    private fun setUpUser(user: UsersItem) {
        txtUserName.text = user.name
        val adres = with(user.address){
            "\n$city\n$zipcode\n$street"
        }
        txtUserAddress.text = adres
    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        disableBack()
        return super.onSupportNavigateUp()
    }

}