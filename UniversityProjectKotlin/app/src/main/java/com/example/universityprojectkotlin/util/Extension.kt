package com.example.universityprojectkotlin.util

import android.view.View
import androidx.navigation.Navigation

fun Navigation.gecis(it: View, id: Int){
    Navigation.findNavController(it).navigate(id)
}