package uz.usoft.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val signs = listOf("+", "-", "*", "/")
    private var right = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        nextStep()
    }

    fun onButtonClick(view: View) {
        val intent = Intent(this, GameOverActivity::class.java)
        if ((view as Button).text == right.toString()) {
            intent.putExtra("result", "Duris")
        } else {
            intent.putExtra("result", "Qate")
        }
        startActivity(intent)
    }

    private fun nextStep() {
        val a = Random.nextInt(10, 100)
        val b = Random.nextInt(10, 100)
        tvFirstNumber.text = a.toString()
        tvSecondNumber.text = b.toString()
        val c = Random.nextInt(4)
        tvSign.text = signs[c]
        generateAnswers(a, b, c)
    }

    private fun generateAnswers(a: Int, b: Int, c: Int) {
        right = when(c) {
            0 -> a+b
            1 -> a-b
            2 -> a*b
            else -> a/b
        }
        val answers = IntArray(4) {
            if (Random.nextBoolean()) {
                right + Random.nextInt(1, 10)
            } else {
                right - Random.nextInt(1, 10)
            }
        }
        val rightIndex = Random.nextInt(4)
        answers[rightIndex] = right
        buttonA.text = answers[0].toString()
        buttonB.text = answers[1].toString()
        buttonC.text = answers[2].toString()
        buttonD.text = answers[3].toString()
    }
}
