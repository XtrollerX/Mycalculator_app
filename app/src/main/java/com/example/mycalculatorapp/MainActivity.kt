package com.example.mycalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

var lastnumeric = false
var lastdot = false

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var tv_input = findViewById<TextView>(R.id.tv_input)

    fun onDigit(view: View) {


        tv_input.append((view as Button).text)
        lastnumeric = true
    }
    fun Onclear (view: View){

        tv_input.text = ""
        lastnumeric = false
        lastdot = false

    }

    fun ondecimalpoint(view: View){
        if(lastnumeric && !lastdot){

            tv_input.append(".")
            lastnumeric = false
            lastdot = true
        }
    }

    fun  onoperator(view: View){
        if(lastnumeric && !isoperatoraddded(tv_input.text.toString())){
            tv_input.append((view as Button).text)
            lastnumeric = false
            lastdot = true
        }

    }
    private fun isoperatoraddded(value:String):Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("/") || value.contains("*")
                    ||value.contains("+")|| value.contains("-")
        }
    }
}