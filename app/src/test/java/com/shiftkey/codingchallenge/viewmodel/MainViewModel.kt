package com.shiftkey.codingchallenge.viewmodel

import android.content.Context
import com.nhaarman.mockitokotlin2.mock
import com.shiftkey.codingchallenge.data.model.Shift
import com.shiftkey.codingchallenge.domain.repository.ShiftsRepository
import com.shiftkey.codingchallenge.domain.usecase.GetAvailableShiftsRemotely
import com.shiftkey.codingchallenge.domain.usecase.ShiftsUseCases
import com.shiftkey.codingchallenge.presentation.ui.MainViewModel
import com.shiftkey.codingchallenge.utils.MainDispatcherRule
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class MainViewModelShould {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val shiftsRemote: ShiftsRepository = mock()

    private val getShifts = GetAvailableShiftsRemotely(
        shiftsRemote
    )

    private val useCases = ShiftsUseCases(
        getAvailableShiftsRemotely = getShifts
    )

    private val contextMock: Context = mock()

    @Test
    fun test_mainViewModel_shouldExist() {

        var viewModel = MainViewModel(
            useCases
        )

        assert(viewModel != null)
    }

    @Test
    fun test_mainViewModel_shouldRunAnReturnLocationNull() {
        var viewModel = MainViewModel(
            useCases
        )
        val items = viewModel.shiftItems.value

        assertEquals(items, null)
    }

    @Test
    fun test_mainViewModel_shouldRunAnReturnDataItemsNull() {
        var viewModel = MainViewModel(
            useCases
        )
        val items = viewModel.shiftItem.value

        assertEquals(items, null)
    }
}