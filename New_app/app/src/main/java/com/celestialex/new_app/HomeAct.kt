package com.celestialex.new_app

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeAct : AppCompatActivity() {

    private val PERMISSION_CODE =1000
    private val IMAGE_CAPTURED_CODE = 1001
    var image_rui: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnLogout:Button = findViewById(R.id.btn_logout)
        btnLogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Successfully Logout", Toast.LENGTH_SHORT).show()
        }

        cam_id.setOnClickListener {
           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
               if (checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_DENIED ||
                   checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                    val permission = arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                   requestPermissions(permission, PERMISSION_CODE)
               }
               else{
                    openCamera()
               }
           }
            else{
                openCamera()
           }
        }

    }



    private fun openCamera(){
            val values = ContentValues()
            values.put(MediaStore.Images.Media.TITLE, "New Picture")
            values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
            image_rui = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values)

            val cameraInt = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            cameraInt.putExtra(MediaStore.EXTRA_OUTPUT, image_rui)
            startActivityForResult(cameraInt, IMAGE_CAPTURED_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.size>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    openCamera()
                }
                else{
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }

            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode==Activity.RESULT_OK){
            result_view.setImageURI(image_rui)
        }
    }

}


