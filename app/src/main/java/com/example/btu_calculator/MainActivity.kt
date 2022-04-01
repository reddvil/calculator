package com.example.btu_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var resultText: TextView
    private var operation: String = ""
    private var operand: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = findViewById(R.id.resultText)
    }

    public fun numberClick(view: View) {
        if(view is Button) {
            var result = resultText.text.toString()
            val number = view.text.toString()
            if(result == "0") {
                result = ""
            }
            val new_result = result + number
            resultText.text = new_result
        }
    }

    public fun pointClick(view: View) {
        var result = resultText.text.toString()
        if(result.length != 0 && !result.contains('.')) {
            val newResult = result + "."
            resultText.text = newResult
        }
    }

    public fun operationClick(view: View) {
        if (view is Button) {
            operation = view.text.toString();
            operand = resultText.text.toString().toDouble();
            resultText.text = ""
        }
    }

    public fun equalsClick(view: View) {
        val secondNumber = resultText.text.toString().toDouble()
        val result = when(operation){
            "+" -> operand + secondNumber
            "-" -> operand - secondNumber
            "*" -> operand * secondNumber
            "/" -> operand / secondNumber
            else -> {0.0}
        }
        resultText.text = result.toString()
        operand = result
        operation = ""
    }

    public fun clearCalculator(view: View) {
        resultText.text = "0"
        operand = 0.0
        operation = ""
    }
}


