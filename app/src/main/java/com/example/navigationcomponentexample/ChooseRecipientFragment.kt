package com.example.navigationcomponentexample


import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.fragment_choose_recipient.*

class ChooseRecipientFragment : BaseFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
    }
    override fun onClick(view: View?) {
        when (view!!.id){
            R.id.next_btn -> {
                if(!TextUtils.isEmpty(input_recipient.text.toString())){
                    val bundle = bundleOf("recipient" to input_recipient.text.toString()) //make bundle
                    navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle) //pass bundle
                }
                else{
                    Toast.makeText(activity,"Enter a name!!",Toast.LENGTH_SHORT).show()
                }
            }
            R.id.cancel_btn -> activity!!.onBackPressed()
        }
    }

    override fun getLayoutResource(): Int {
        return R.layout.fragment_choose_recipient
    }
}
