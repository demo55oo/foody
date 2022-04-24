package com.demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.repository.repository

class mainviewmodelfactory(private val repository: repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return mainviewmodel(repository) as T
    }

}