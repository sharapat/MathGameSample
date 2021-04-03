package uz.usoft.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game_over.*

class GameOverActivity : AppCompatActivity() {

    private var currentResult = 0
    private var maxScore = 0
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
        preferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        maxScore = preferences.getInt("max_score", 0)
        currentResult = intent.getIntExtra("result", 0)
        tvResult.text = "Your score is $currentResult"
        if (currentResult > maxScore) {
            preferences.edit().putInt("max_score", currentResult).apply()
        }
        tvMaxScore.text = "Max Score is ${preferences.getInt("max_score", 0)}"
    }
}
