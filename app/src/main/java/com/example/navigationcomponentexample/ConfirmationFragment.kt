package com.example.navigationcomponentexample

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf

class ConfirmationFragment : BaseFragment() {

    lateinit var recipient: String
    lateinit var money: Money

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments!!.getString("recipient")!!
        money = arguments!!.getParcelable("amount")!!
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_confirmation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.confirmation_message).setOnClickListener(this)
        val amount = money.amount
        val confirmationMessage = "You have sent $$amount to $recipient"
        view.findViewById<TextView>(R.id.confirmation_message).text = confirmationMessage
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.confirmation_message -> {
                Log.e("click","confirmation")
                val bundle = bundleOf("recipient" to recipient, "amount" to money) //make bundle
                navController.navigate(R.id.action_confirmationFragment_to_confirmationActivity, bundle)
            }
        }
    }

}
