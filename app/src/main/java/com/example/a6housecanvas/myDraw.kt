package com.example.a6housecanvas

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.View

class myDraw(context: Context?) : View(context) {
    var paint = Paint()
    var mainPaint = Paint()
    var drawGlass = Paint()
    var drawWall = Paint()
    var drawChimney = Paint()
    var drawSun = Paint()
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.style = Paint.Style.FILL
        paint.color = Color.rgb(135,206,235)
        //        @SuppressLint("DrawAllocation") Bitmap bitmap = Bitmap.createBitmap(400, 600, Bitmap.Config.ARGB_8888);
//        canvas = new Canvas(bitmap);
        canvas.drawPaint(paint)
        paint.isAntiAlias = true
        paint.textSize = 50f
        paint.color = Color.RED

        mainPaint.isAntiAlias = true
        mainPaint.textSize = 25f
        mainPaint.color = Color.RED

        drawSun.color = Color.YELLOW

        drawWall.color = Color.GRAY
        drawWall.style= Paint.Style.FILL_AND_STROKE

        drawChimney.color = Color.LTGRAY
        drawChimney.style= Paint.Style.FILL_AND_STROKE

        paint.isAntiAlias = true

        drawGlass.color = Color.GREEN
        //Main part
        canvas.drawRect(
            (width/4).toFloat(),
            (height/2).toFloat(),
            (width*3/4).toFloat(),
            (height*3/4).toFloat(),
            drawWall
        )
        //Дымовая труба
        canvas.drawRect(
            (width*9/16).toFloat(),
            (height*6/16).toFloat(),
            (width*11/16).toFloat(),
            (height/2).toFloat(),
            drawChimney
        )
        //Roof
        val roofPath = Path()
        roofPath.fillType = Path.FillType.EVEN_ODD
        roofPath.moveTo((width/4).toFloat(),(height/2).toFloat())
        roofPath.lineTo((width/2).toFloat(), (height*3/8).toFloat())
        roofPath.lineTo((width*3/4).toFloat(),(height/2).toFloat())
        roofPath.close()
        canvas.drawPath(roofPath,drawWall)
        mainPaint.color= Color.rgb(255,255,102)
        //Window
        canvas.drawRoundRect(
            (width*9/32).toFloat(),
            (height*17/32).toFloat(),
            (width*10/32).toFloat(),
            (height*18/32).toFloat(),
            12.0F, 12.0F,
            mainPaint
        )
        canvas.drawRoundRect(
            (width*10/32+width/64).toFloat(),
            (height*17/32).toFloat(),
            (width*11/32+width/64).toFloat(),
            (height*18/32).toFloat(),
            12.0F, 12.0F,
            mainPaint
        )
        canvas.drawRoundRect(
            (width*9/32).toFloat(),
            (height*18/32+height/64).toFloat(),
            (width*10/32).toFloat(),
            (height*19/32+height/64).toFloat(),
            12.0F, 12.0F,
            mainPaint
        )
        canvas.drawRoundRect(
            (width*10/32+width/64).toFloat(),
            (height*18/32+height/64).toFloat(),
            (width*11/32+width/64).toFloat(),
            (height*19/32+height/64).toFloat(),
            12.0F, 12.0F,
            mainPaint
        )
        //Door
        mainPaint.color= Color.rgb(155,103,60)
        canvas.drawRect(
            (width*7/16).toFloat(),
            (height*5/8).toFloat(),
            (width*9/16).toFloat(),
            (height * 3 / 4).toFloat(),
            mainPaint
        )
        canvas.drawRect(0F,(height*3/4).toFloat(), width.toFloat(), height.toFloat(),drawGlass)
        canvas.drawCircle(0F,0F,height.toFloat()/16,drawSun)
    }
}