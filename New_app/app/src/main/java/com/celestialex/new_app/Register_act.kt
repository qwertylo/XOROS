package com.celestialex.new_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_for_reg.*
import kotlinx.android.synthetic.main.activity_register_act.*

class Register_act : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_act)

        val saveHomeReg:Button = findViewById(R.id.btn_save_register)
       saveHomeReg.setOnClickListener {
            val intent = Intent(this, MainActivity ::class.java)
            startActivity(intent)

            surname_register.setText("")
            firstname_register.setText("")
            pass_register.setText("")
            middle_register.setText("")
            user_register.setText("")

            Toast.makeText(this, "Successfully Added", Toast.LENGTH_SHORT).show()



        }
    }
}
