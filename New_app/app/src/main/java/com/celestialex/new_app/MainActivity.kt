package com.celestialex.new_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newLogin :Button= findViewById(R.id.btn_login)
        newLogin.setOnClickListener {
            val intent = Intent(this, HomeAct :: class.java)
            startActivity(intent)
            pass_main.setText("")
            user_main.setText("")
            Toast.makeText(this, "Successfully Login", Toast.LENGTH_SHORT ).show()
        }
        val newReg : Button= findViewById(R.id.register_id)
        newReg.setOnClickListener {
            val intent = Intent(this, Register_act ::class.java )
            startActivity(intent)
        }
        val newForReg : Button= findViewById(R.id.forgot_pass_id)
        newForReg.setOnClickListener {
            val intent=Intent(this, ForReg::class.java)
            startActivity(intent)
        }

    }
}
