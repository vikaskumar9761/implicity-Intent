package com.example.implicityintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Telephony.Mms.Sent
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.implicityintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)


        binding.webpage.setOnClickListener {

            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://letesthtml99.blogspot.com/"))
            startActivity(intent)
        }
        binding.number.setOnClickListener {

            val intent=Intent(Intent.ACTION_DIAL)
            intent.data=Uri.parse("tel:9761747710")

            startActivity(intent)
        }

        binding.camera.setOnClickListener {

            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)

        }

        binding.share.setOnClickListener {
        val text=binding.editTextText.text.toString()
            val intent=Intent(Intent.ACTION_SEND)

            intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_TEXT,text)
            startActivity(Intent.createChooser(intent,"vivek bhai"))

            Toast.makeText(this, "Share the text", Toast.LENGTH_SHORT).show()
        }
    }
}