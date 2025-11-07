package com.example.wekk_4flashcard

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val questionField = findViewById<TextView>(R.id.editTextText)
        val answerField = findViewById<TextView>(R.id.editTextText2)
        val cancel = findViewById<ImageView>(R.id.imageView2)
        val modifier = findViewById<ImageView>(R.id.imageView)

        cancel.setOnClickListener {
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        modifier.setOnClickListener {
           val question = questionField.text.toString()
            val answer = answerField.text.toString()

            val data = Intent().apply {
                putExtra("question_key",question)
                putExtra("answer_key",answer)
            }

            setResult(RESULT_OK,data)
            finish()

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}