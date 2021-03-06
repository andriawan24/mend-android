package com.andriawan.divergent_mobile_apps.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.viewbinding.ViewBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.shashank.sony.fancytoastlib.FancyToast

abstract class BaseFragment<VB: ViewBinding, VM: AndroidViewModel>: Fragment() {
    abstract val viewModel: VM
    abstract val binding: VB
    private var hasInitialized = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!hasInitialized) {
            onInitViews()
            onInitObservers()
        }
    }

    protected open fun onInitViews() = Unit
    protected open fun onInitObservers() = Unit

    fun showToast(text: String, type: Int) {
        FancyToast.makeText(context, text, FancyToast.LENGTH_SHORT, type, false).show()
    }

    override fun onPause() {
        super.onPause()
        hasInitialized = true
    }
}