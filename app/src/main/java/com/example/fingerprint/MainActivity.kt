package com.example.fingerprint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import me.aflak.libraries.FingerprintCallback
import me.aflak.libraries.FingerprintDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnFinger.setOnClickListener {
            FingerprintDialog.initialize(this)
                .title("지문인증")
                .message("지문으로 인증합니다")
                .callback(object:FingerprintCallback{
                    override fun onAuthenticationSuccess() {
                        Toast.makeText(applicationContext,"인증성공",Toast.LENGTH_SHORT);
                    }

                    override fun onAuthenticationCancel() {
                        Toast.makeText(applicationContext,"인증실패",Toast.LENGTH_SHORT);                    }

                })
                .show()
        }
    }
}
