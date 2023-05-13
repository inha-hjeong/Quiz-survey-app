package uz.bekzod.project.quizapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import uz.bekzod.project.quizapp.theme.JetsurveyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            JetsurveyTheme {
                JetsurveyNavHost()
            }
        }
    }
}
