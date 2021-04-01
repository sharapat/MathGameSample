package uz.usoft.myapplication

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game_over.*

class GameOverActivity : AppCompatActivity() {
    private lateinit var preferences: SharedPreferences
    private var maxScore = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)
        preferences = getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE)
        score = intent.getIntExtra("result", 0)
        maxScore = preferences.getInt("MaxScore", 0)
        tvMaxScore.text = maxScore.toString()
        if (maxScore < score) {
            Toast.makeText(this, "Urra, you have the best result", Toast.LENGTH_LONG).show()
            preferences.edit().putInt("MaxScore", score).apply()
        }
        tvResult.text = "${score}/${MainActivity.LEVEL_COUNT}"
    }
}