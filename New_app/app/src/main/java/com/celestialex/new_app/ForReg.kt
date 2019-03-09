package com.celestialex.new_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_for_reg.*

class ForReg : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_for_reg)

        val saveReg :Button = findViewById(R.id.btn_save)
        saveReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            email_id_reg.setText("")
            user_reg.setText("")
            pass_reg.setText("")
            cnf_pass_reg.setText("")

            Toast.makeText(this, "Successfully Added", Toast.LENGTH_SHORT).show()

        }

    }
}
