package com.demo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.demo.R
import com.demo.ui.fragment.CurrencyFragment
import javax.inject.Inject

/**
 * Created by Musharib Ali on 13/1/21.
 * I.S.T Pvt. Ltd
 * musharib.ali@innobles.com
 */
class AppNavigator @Inject constructor(private val activity: FragmentActivity) :AppNavigatorInterface {
    override fun navigator(command: Command,b: Bundle?) {
        val fragment: Fragment = when (command) {
            Command.CURRENCY -> CurrencyFragment.newInstance()
        }
        fragment.let {
            activity.supportFragmentManager.beginTransaction()
                    .replace(R.id.main_container, it)
                    .addToBackStack(it::class.java.canonicalName)
                    .commit()
        }

    }



}


interface AppNavigatorInterface{
    fun navigator(command: Command,b:Bundle?=null)
}

 enum class Command {
   CURRENCY
}