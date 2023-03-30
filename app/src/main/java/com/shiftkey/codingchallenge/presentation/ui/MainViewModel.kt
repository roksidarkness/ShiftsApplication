package com.shiftkey.codingchallenge.presentation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiftkey.codingchallenge.data.model.Shift
import com.shiftkey.codingchallenge.domain.usecase.ShiftsUseCases
import com.shiftkey.codingchallenge.utils.Constant.TAG
import com.shiftkey.codingchallenge.utils.getEndDate
import com.shiftkey.codingchallenge.utils.getStartDate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: ShiftsUseCases
) : ViewModel() {

    private val address = "Dallas, TX"
    private val type = "list"

    private var _shiftItems = MutableLiveData<List<Shift>>()
    val shiftItems: LiveData<List<Shift>> = _shiftItems

    private var _shiftItem = MutableLiveData<Shift>()
    val shiftItem: LiveData<Shift> = _shiftItem

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        viewModelScope.launch {
            try {
                val data = useCases.getAvailableShiftsRemotely.invoke(type,
                    getStartDate(), getEndDate(), address, null)
                    val list: MutableList<Shift> = mutableListOf()
                    data.data.forEach{
                        it.shifts.forEach{
                            list.add(it)
                        }
                    }
                    _shiftItems.value = list
                    _isLoading.value = false

            } catch (error: Exception) {
                error.localizedMessage?.let {
                    Log.d(TAG, it)
                    _isLoading.value = false
                }
            }
        }
    }

    fun getDetails(id: String) {
        _shiftItems.value?.let { it ->
                it.forEach {
                    if (it.shift_id == id){
                        _shiftItem.postValue(it)
                    }
                }
        }
    }
}