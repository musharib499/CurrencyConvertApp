package com.demo.utils

import android.R
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatSpinner
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.demo.api.LoadingState

/**
 * Created by Musharib Ali on 14/1/21.
 * I.S.T Pvt. Ltd
 * musharib.ali@innobles.com
 */

@BindingAdapter("isVisible")
fun View.setIsVisible(isVisible: Boolean) {
    this.visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}
@BindingAdapter("isLoading")
fun ProgressBar.progressVisibility(loadingState: LoadingState?) {
    loadingState?.let {
        isVisible = when(it.status) {
            LoadingState.Status.RUNNING -> true
            LoadingState.Status.SUCCESS -> false
            LoadingState.Status.FAILED -> false
        }
    }
}
@BindingAdapter("entries")
fun AppCompatSpinner.setEntries(entries: List<Any>?) {
    if (!entries.isNullOrEmpty()) {
        val arrayAdapter = ArrayAdapter(context, R.layout.simple_spinner_item, entries)
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        adapter = arrayAdapter
    }
}

@BindingAdapter("onItemSelected")
fun AppCompatSpinner.setItemSelectedListener(listener: ItemSelectedListener) {
    if (listener == null) {
        onItemSelectedListener = null
    } else {
        onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (tag != position) {
                        listener.onItemSelected(parent.getItemAtPosition(position))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}
@BindingAdapter("newValue")
fun AppCompatSpinner.setNewValue(newValue: String?) {
    setSpinnerValue(newValue)
}

fun AppCompatSpinner.setSpinnerValue(value: Any?) {
    if (adapter != null ) {
        val position = (adapter as ArrayAdapter<Any>).getPosition(value)
        setSelection(position, false)
        tag = position
    }
}
interface ItemSelectedListener {
    fun onItemSelected(item: Any)
}



