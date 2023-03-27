package com.anncode.swipeimages

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image1 = findViewById<ImageView>(R.id.imageView1)
        /*val image2 = findViewById<ImageView>(R.id.imageView3)
        val image3 = findViewById<ImageView>(R.id.imageView4)
        val image4 = findViewById<ImageView>(R.id.imageView5)
        */
        val gestureListener = GestureDetectorListener()
        gestureListener.movement = object : Movement {
            override fun right() {
                Toast.makeText(this@MainActivity, "Right Moving", Toast.LENGTH_SHORT).show()
                image1.animate().translationXBy(100.0f).start()
            }

            override fun left() {
                Toast.makeText(this@MainActivity, "Left Moving", Toast.LENGTH_SHORT).show()
                image1.animate().translationXBy(-100.0f).start()
            }

            override fun top() {
                Toast.makeText(this@MainActivity, "Top Moving", Toast.LENGTH_SHORT).show()
                image1.animate().translationYBy(-100.0f).start()
            }

            override fun bottom() {
                Toast.makeText(this@MainActivity, "Bottom Moving", Toast.LENGTH_SHORT).show()
                image1.animate().translationYBy(100.0f).start()
            }
        }

        val gesture = GestureDetector(this, gestureListener)
        image1.setOnTouchListener { v, event ->
            gesture.onTouchEvent(event)
        }


    }

}