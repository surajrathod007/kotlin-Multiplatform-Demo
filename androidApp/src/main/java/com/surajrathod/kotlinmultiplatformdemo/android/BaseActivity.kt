package com.surajrathod.kotlinmultiplatformdemo.android

import android.app.ProgressDialog
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color

abstract class BaseActivity : AppCompatActivity() {


    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var template : FrameLayout
    lateinit var loading : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)
    }

    fun getViewFromLayout(id : Int) : View {
        return layoutInflater.inflate(id,null,false)
    }

    fun showProgress(){
        loading = ProgressDialog(this)
        loading.setTitle("Loading")
        loading.show()
    }

    fun hideProgress(){
        if(this::loading.isInitialized && loading.isShowing){
            loading.dismiss()
        }
    }

    fun putLayout(id : Int){
        try {
            template = findViewById(R.id.contentFrame)
            template.addView(getViewFromLayout(id),0)
        }catch (e : Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }

    }

    fun setToolBarTitle(title : String){
        toolbar = findViewById(R.id.toolbar)
        toolbar.title = title
        setSupportActionBar(toolbar)
    }

    fun enableBack(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun disableBack(){
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }
}