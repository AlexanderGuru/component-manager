package com.alexguru.feature_map

import android.content.Context
import androidx.fragment.app.Fragment
import com.alexguru.feature_map.di.MapComponent

class MapFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MapComponent.getOrCreate(this).inject(this)
    }
}