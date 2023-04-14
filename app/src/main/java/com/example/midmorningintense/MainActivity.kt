package com.example.midmorningintense

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    lateinit var btnSms:Button
    lateinit var btnEmail:Button
    lateinit var btnCamera:Button
    lateinit var btnShare:Button
    lateinit var btnMpesa:Button
    lateinit var btnCall:Button
    lateinit var btnWebsite:Button
    lateinit var btnMap: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSms = findViewById(R.id.mBtnSms)
        btnCall = findViewById(R.id.mBtnCall)
        btnCamera = findViewById(R.id.mBtnCamera)
        btnEmail = findViewById(R.id.mBtnEmail)
        btnMpesa = findViewById(R.id.mBtnMpesa)
        btnShare = findViewById(R.id.mBtnShare)
        btnWebsite = findViewById(R.id.mBtnWebsite)
        btnMap = findViewById(R.id.mBtnMap)

        btnWebsite.setOnClickListener {
            val tembea = Intent(this@MainActivity, WebsiteActivity::class.java)
            startActivity(tembea)

        }
        btnSms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0792825570")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hello there..")
            startActivity(intent)

        }
        btnEmail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "titoedwin045@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Sir, following the job application...")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }
        btnMpesa.setOnClickListener {
            val simToolKitLaunchIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }

        }
        btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app! on https://")
            startActivity(shareIntent)

        }
        btnCamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)


        }
        btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0792825570"))
            if (ContextCompat.checkSelfPermission(this@MainActivity, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }
            btnMap.setOnClickListener {
                val ramani = Intent(this, MapsActivity::class.java)
                startActivity(ramani)

            }

        }
    }
}