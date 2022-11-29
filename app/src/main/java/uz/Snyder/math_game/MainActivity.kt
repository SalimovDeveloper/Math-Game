package uz.Snyder.math_game

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.widget.addTextChangedListener
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    private lateinit var myTextView1: TextView
    private lateinit var myEditText: EditText
    private lateinit var myTextView2: TextView

    var number1: Int = 0
    var number2: Int = 0


    var amal = 0
    var tjavob: Int = 0

    var totalScore = 0
    var correctScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myTextView1 = findViewById(R.id.txt1)
        myEditText = findViewById(R.id.id1)

        randomMisol()

        myEditText.addTextChangedListener {
            if (tjavob.toString().length == it?.length) {
                val javob = myEditText.text.toString().toInt()
                if (javob == tjavob) {
                    correctScore++
                    Toast.makeText(this, "To'g'ri javob", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Notog'ri javob", Toast.LENGTH_SHORT).show()
                }
                totalScore++
                myEditText.text.clear()
                randomMisol()
            }
        }

    }

    fun randomMisol() {

        number1 = java.util.Random().nextInt(20)
        number2 = java.util.Random().nextInt(20)

        if (number1 < number2){
            randomMisol()
            return
        }

        amal = java.util.Random().nextInt(5)

        when (amal){

            0 -> {
                tjavob = number1 + number2
                myTextView1.text = "$number1 + $number2 "
            }

            1 -> {
                tjavob = number1 - number2
                myTextView1.text = "$number1 - $number2 "
            }

            2 -> {
                tjavob = number1 * number2
                myTextView1.text = "$number1 * $number2 "
            }

            3 -> {

                try {
                    if (number1 % number2 != 0 ){
                        randomMisol()
                        return
                    }
                    tjavob = number1 / number2
                    myTextView1.text = "$number1 : $number2"

                }catch (e:Exception){
                    randomMisol()
                }
            }
        }
    }

}