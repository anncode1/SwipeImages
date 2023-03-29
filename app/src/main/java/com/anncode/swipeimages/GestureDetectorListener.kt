package com.anncode.swipeimages

import android.view.GestureDetector
import android.view.MotionEvent
import kotlin.math.abs

class GestureDetectorListener: GestureDetector.SimpleOnGestureListener() {

    var movement: Movement? = null

    override fun onFling(
        e1: MotionEvent,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        // e1 - init
        // e2 - end

        val distanceX = abs(e2.x - e1.x)
        val distanceY = abs( e2.y - e1.y)

        // y = 2
        // x = 0, 1, 2, 3
        val isHorizontal = distanceX > distanceY
        val swipeMeasure = 50

        if (isHorizontal) {
            // left or right
            // ________ -> swipe(?)
            if (distanceX > swipeMeasure) {
                if (e2.x > e1.x) { // right
                    movement?.right()
                } else { // left
                    movement?.left()
                }
            }

            return true
        } else {
            // top or bottom

            if (distanceY > swipeMeasure) {
                if (e1.y > e2.y) { // top
                    movement?.top()
                } else { // bottom
                    movement?.bottom()
                }
            }
        }




        return false
    }

}

