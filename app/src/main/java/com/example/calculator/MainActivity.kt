package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ArithmeticException

var lastNumeric = false
var lastDot = false

var divOperation = false
var mulOperation = false
var subOperation = false
var addOperation = false


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun onDigit(view : View) {
     tvInput.append((view as Button).text)
        lastNumeric = true
//        onOperation()
//      if(tvInput.text.contains(!("/" && !""))) {

      }



    fun clearBtn (view : View) {
        tvInput.text = ""
        lastNumeric = false
        lastDot = false

//        divOperation = false
//        mulOperation = false
//        subOperation = false
//        addOperation = false

    }
     fun onDecimalPoint(view : View){
         if (lastNumeric && !lastDot) {
             tvInput.append(".")
             lastNumeric = false
             lastDot = true
         }
     }

    private fun isOperatorAdded(opt : String) : Boolean {
        return if (opt.startsWith("-")) {
             false
        } else {
            opt.contains("/") || opt.contains("*")
                    || opt.contains("+") || opt.contains("-")
        }
    }


    fun onEqual(view : View) {
        if (lastNumeric) {
            var tvValue = tvInput.text.toString()
            var prefix = ""
            try {
                if (tvValue.startsWith("-")) {
                    prefix = "-"
                    tvValue = tvValue.substring(1)
                }
                     if (tvValue.contains("-")) {
                    val splitValue = tvValue.split("-")
                    var firstV = splitValue[0]
                    var secondV = splitValue[1]

                    if(!prefix.isEmpty()) {
                        firstV = prefix + firstV
                    }
                        tvInput.text = removeZeroAfterDot ((firstV.toDouble() - secondV.toDouble()).toString())

                    } else if (tvValue.contains("+")) {
                            val splitValue = tvValue.split("+")
                            var firstV = splitValue[0]
                            var secondV = splitValue[1]

                            if(!prefix.isEmpty()){
                                firstV = prefix + firstV
                    }
                        tvInput.text = removeZeroAfterDot ((firstV.toDouble() + secondV.toDouble()).toString())

                } else if (tvValue.contains("*")) {
                         val splitValue = tvValue.split("*")
                         var firstV = splitValue[0]
                         var secondV = splitValue[1]

                         if(!prefix.isEmpty()){
                             firstV = prefix + firstV
                         }
                         tvInput.text = removeZeroAfterDot ((firstV.toDouble() * secondV.toDouble()).toString())

                     } else if (tvValue.contains("/")) {
                         val splitValue = tvValue.split("/")
                         var firstV = splitValue[0]
                         var secondV = splitValue[1]

                         if(!prefix.isEmpty()){
                             firstV = prefix + firstV
                         }
                         tvInput.text = removeZeroAfterDot ((firstV.toDouble() / secondV.toDouble()).toString())

                     }

            }catch (e : ArithmeticException) {
                print(e)
            }
        }
    }

    fun removeZeroAfterDot(result : String) : String {
        var value = result
        if (result.contains("0"))
            value = result.substring(0, result.length - 2)
        return  value
    }

   fun onOperator(view : View) {
      if (lastNumeric && !isOperatorAdded(tvInput.text.toString())) {
          tvInput.append((view as Button).text)
          lastNumeric = false
          lastDot = false
      }
        }


//    fun onOperation(view: View) {
//if (!addOperation) {
//    tvInput.append((view as Button).text)
//    subOperation = false
//    mulOperation = false
//    divOperation = false
//
//} else if (!subOperation) {
//    tvInput.append((view as Button).text)
//    addOperation = false
//    mulOperation = false
//    divOperation = false
//
//} else if (!divOperation) {
//    tvInput.append((view as Button).text)
//    addOperation = false
//    mulOperation = false
//    subOperation = false
//
//} else if (!mulOperation) {
//    tvInput.append((view as Button).text)
//    addOperation = false
//    divOperation = false
//    subOperation = false
//}
//    }

}