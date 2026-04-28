package com.example.android_studio_test_exercice

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performSemanticsAction
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.semantics.SemanticsActions
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.android_studio_test_exercice", appContext.packageName)
    }

    @Test
    fun initialComposableState_isCorrect() {
        composeTestRule.onNodeWithTag("wifiSwitch_id").assertIsOn()
        composeTestRule.onNodeWithTag("vegetariaCheckbox_id").assertIsOff()
        composeTestRule.onNodeWithTag("vegaCheckbox_id").assertIsOff()
        composeTestRule.onNodeWithTag("carnivorCheckbox_id").assertIsOn().assertIsNotEnabled()
        composeTestRule.onNodeWithTag("triStateCheckbox_id").assertIsDisplayed()
        composeTestRule.onNodeWithTag("radio_Vinicius").assertIsNotEnabled()
        composeTestRule.onNodeWithTag("radio_Lamine Yamal").assertIsDisplayed()
        composeTestRule.onNodeWithTag("radio_Raphina").assertIsDisplayed()
        composeTestRule.onNodeWithTag("sliderValueText_id").assertTextContains("Volum: 0%")
        composeTestRule.onNodeWithTag("dropdownTrigger_id").assertTextEquals("Opció A")
        composeTestRule.onNodeWithTag("searchField_id").assertIsDisplayed()
        composeTestRule.onNodeWithTag("searchButton_id").assertIsDisplayed()
        composeTestRule.onNodeWithTag("toggleButton_id").assertTextEquals("Desactivat")
    }

    @Test
    fun switchAndCheckboxes_reactToClicks() {
        composeTestRule.onNodeWithTag("wifiSwitch_id").performClick().assertIsOff()
        composeTestRule.onNodeWithTag("vegetariaCheckbox_id").performClick().assertIsOn()
        composeTestRule.onNodeWithTag("vegaCheckbox_id").performClick().assertIsOn()
    }

    @Test
    fun checkCheckboxMenu_likeExampleFlow() {
        composeTestRule.onNodeWithTag("vegetariaCheckbox_id").assertIsOff()
        composeTestRule.onNodeWithTag("vegaCheckbox_id").assertIsOff()

        composeTestRule.onNodeWithTag("vegetariaCheckbox_id").performClick()
        composeTestRule.onNodeWithTag("vegetariaCheckbox_id").assertIsOn()
        composeTestRule.onNodeWithTag("vegaCheckbox_id").assertIsOff()

        composeTestRule.onNodeWithTag("vegaCheckbox_id").performClick()
        composeTestRule.onNodeWithTag("vegetariaCheckbox_id").assertIsOn()
        composeTestRule.onNodeWithTag("vegaCheckbox_id").assertIsOn()

        composeTestRule.onNodeWithTag("vegetariaCheckbox_id").performClick()
        composeTestRule.onNodeWithTag("vegaCheckbox_id").performClick()
        composeTestRule.onNodeWithTag("vegetariaCheckbox_id").assertIsOff()
        composeTestRule.onNodeWithTag("vegaCheckbox_id").assertIsOff()
    }

    @Test
    fun radioButtons_work() {
        composeTestRule.onNodeWithTag("radio_Lamine Yamal").assertIsNotSelected()
        composeTestRule.onNodeWithTag("radio_Lamine Yamal").performClick()
        composeTestRule.onNodeWithTag("radio_Lamine Yamal").assertIsSelected()
        composeTestRule.onNodeWithTag("radio_Raphina").assertIsNotSelected()
        composeTestRule.onNodeWithTag("radio_Raphina").performClick()
        composeTestRule.onNodeWithTag("radio_Raphina").assertIsSelected()
    }

    @Test
    fun slider_updatesDisplayedValue() {
        composeTestRule.onNodeWithTag("sliderValueText_id").assertTextContains("Volum: 0%")

        composeTestRule.onNodeWithTag("volumeSlider_id").performSemanticsAction(SemanticsActions.SetProgress) {
            it(70f)
        }

        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("sliderValueText_id").assertTextContains("Volum: 70%")
    }

    @Test
    fun dropdownAndSearch_work() {
        composeTestRule.onNodeWithTag("dropdownTrigger_id").performClick()
        composeTestRule.onNodeWithTag("dropdown_Opció C").assertIsDisplayed().performClick()
        composeTestRule.onNodeWithTag("dropdownTrigger_id").assertTextEquals("Opció C")

        composeTestRule.onNodeWithTag("searchField_id").performTextInput("Barcelona")
        composeTestRule.onNodeWithTag("searchField_id").assertTextContains("Barcelona")
        composeTestRule.onNodeWithTag("searchButton_id").performClick()
        composeTestRule.onNodeWithTag("snackbarText_id").assertTextEquals("Acció completada!")
    }

    @Test
    fun toggleButton_changesLabelAndIsClickable() {
        composeTestRule.onNodeWithTag("toggleButton_id").assertHasClickAction()
        composeTestRule.onNodeWithTag("toggleButton_id").performClick()
        composeTestRule.onNodeWithTag("toggleButton_id").assertTextEquals("Activat")
        composeTestRule.onNodeWithTag("toggleButton_id").performClick()
        composeTestRule.onNodeWithTag("toggleButton_id").assertTextEquals("Desactivat")
    }
}