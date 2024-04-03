package com.example.permission

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.btnreqper


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnreqper.setOnClickListener(){
            requestPermission()
        }
    }
    private fun haswriteExternalstoragePermission()=
        ActivityCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    private fun hasLoctionForgroundPermission()=
        ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
    private fun hasLoctionBackgroundPermission()=
        ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun requestPermission(){
        var permissioonToRequest = mutableListOf<String>()
        if(!haswriteExternalstoragePermission()){
            permissioonToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if(!hasLoctionForgroundPermission()){
            permissioonToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if(!hasLoctionBackgroundPermission()){
            permissioonToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }
        if(permissioonToRequest.isNotEmpty()){
            ActivityCompat.requestPermissions(this,permissioonToRequest.toTypedArray(),0)
        }

    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==0 && grantResults.isNotEmpty()){
            for(i in grantResults.indices){
                if(grantResults[i]==PackageManager.PERMISSION_GRANTED){
                    Log.d("PermissionRequest","${permissions[i]} granted.")


                }
            }

        }
    }


}












































