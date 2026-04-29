package com.example.android_studio_test_exercice

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.android_studio_test_exercice.viewmodel.MainViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExampleUnitTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    @Test
    fun initialState_isCorrect() {
        assertTrue(viewModel.estatSwitch.value == true)
        assertFalse(viewModel.esVegetaria.value ?: true)
        assertFalse(viewModel.esVega.value ?: true)
        assertTrue(viewModel.esCarnivor.value == true)
        assertEquals("Messi", viewModel.selectedOption.value)
        assertEquals(0f, viewModel.sliderValue.value)
        assertFalse(viewModel.expanded.value ?: true)
        assertEquals("Opció A", viewModel.selectedItem.value)
        assertEquals("", viewModel.searchText.value)
        assertFalse(viewModel.showSnackbar.value ?: true)
        assertFalse(viewModel.toggleState.value ?: true)
    }

    @Test
    fun toggleEstatSwitch_invertsValue() {
        viewModel.toggleEstatSwitch()
        assertFalse(viewModel.estatSwitch.value ?: true)
        viewModel.toggleEstatSwitch()
        assertTrue(viewModel.estatSwitch.value ?: false)
    }

    @Test
    fun toggleEsCarnivor_invertsValue() {
        viewModel.toggleEsCarnivor()
        assertFalse(viewModel.esCarnivor.value ?: true)
    }

    @Test
    fun toggleEsVegetaria_invertsValue() {
        viewModel.toggleEsVegetaria()
        assertTrue(viewModel.esVegetaria.value ?: false)
    }

    @Test
    fun toggleEsVega_invertsValue() {
        viewModel.toggleEsVega()
        assertTrue(viewModel.esVega.value ?: false)
    }

    @Test
    fun setSelectedOption_updatesLiveData() {
        viewModel.setSelectedOption("Lamine Yamal")
        assertEquals("Lamine Yamal", viewModel.selectedOption.value)
    }

    @Test
    fun setSliderValue_updatesLiveData() {
        viewModel.setSliderValue(67f)
        assertEquals(67f, viewModel.sliderValue.value)
    }

    @Test
    fun setExpanded_updatesLiveData() {
        viewModel.setExpanded(true)
        assertTrue(viewModel.expanded.value ?: false)
        viewModel.setExpanded(false)
        assertFalse(viewModel.expanded.value ?: true)
    }

    @Test
    fun setSelectedItem_updatesLiveData() {
        viewModel.setSelectedItem("Opció C")
        assertEquals("Opció C", viewModel.selectedItem.value)
    }

    @Test
    fun setSearchText_updatesLiveData() {
        viewModel.setSearchText("Raphina")
        assertEquals("Raphina", viewModel.searchText.value)
    }

    @Test
    fun performSearch_setsSnackbarVisible() {
        viewModel.performSearch()
        assertTrue(viewModel.showSnackbar.value ?: false)
    }

    @Test
    fun toggle_invertsToggleState() {
        viewModel.toggle()
        assertTrue(viewModel.toggleState.value ?: false)
        viewModel.toggle()
        assertFalse(viewModel.toggleState.value ?: true)
    }
}