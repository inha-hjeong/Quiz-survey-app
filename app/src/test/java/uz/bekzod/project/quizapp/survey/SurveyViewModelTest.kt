package uz.bekzod.project.quizapp.survey

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SurveyViewModelTest {

    private lateinit var viewModel: SurveyViewModel

    @Before
    fun setUp() {
        viewModel = SurveyViewModel(
            PhotoUriManager(ApplicationProvider.getApplicationContext())
        )
    }

    @Test
    fun onFreeTimeResponse() {
        val answerOne = 0
        val answerTwo = 99

        // Starts empty, next disabled
        Truth.assertThat(viewModel.freeTimeResponse).isEmpty()
        Truth.assertThat(viewModel.isNextEnabled).isFalse()

        // Add two arbitrary values
        viewModel.onFreeTimeResponse(true, answerOne)
        viewModel.onFreeTimeResponse(true, answerTwo)
        Truth.assertThat(viewModel.freeTimeResponse).containsExactly(answerOne, answerTwo)
        Truth.assertThat(viewModel.isNextEnabled).isTrue()

        // Remove one value
        viewModel.onFreeTimeResponse(false, answerTwo)
        Truth.assertThat(viewModel.freeTimeResponse).containsExactly(answerOne)
        Truth.assertThat(viewModel.isNextEnabled).isTrue()

        // Remove the last value
        viewModel.onFreeTimeResponse(false, answerOne)
        Truth.assertThat(viewModel.freeTimeResponse).isEmpty()
        Truth.assertThat(viewModel.isNextEnabled).isFalse()
    }
}
