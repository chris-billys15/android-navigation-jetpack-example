package com.example.navigationcomponentexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_confirmation.*

class ConfirmationActivity : AppCompatActivity() {

    lateinit var recipient : String
    lateinit var money : Money
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)
        ButterKnife.bind(this)
        recipient = intent.getStringExtra("recipient")
        money = intent.getParcelableExtra("amount")

        val message = "You have sent $$money to $recipient in a Activity"
        confirmation_message2.text= message
    }
}
