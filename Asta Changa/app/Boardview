package com.example.binarypuzzle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class SudokuBoardView extends View {


    private Paint thickLinePaint=new Paint();
    private Paint selectedPaint=new Paint();
    private Paint textPaint=new Paint();
    public static float width=0;
    public static float height=0;
    public static int size=Puzzle8x8.size;
    public static int sqrtSize=(int)Math.sqrt(size);
    public Map<String,String> allpos=new HashMap<String,String>();

    public float cellPixelSize=0F;

    public int selectedRow=0;
    public int selectedCol=0;

    public SudokuBoardView(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
        thickLinePaint.setColor(Color.BLACK);
        thickLinePaint.setStrokeWidth(4F);
        thickLinePaint.setStyle(Paint.Style.STROKE);

        selectedPaint.setColor(Color.GREEN);
        selectedPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(50F);
        allpos.put(" ","0");
        allpos.put("0","1");
        allpos.put("1"," ");

    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int sizePixel=Math.min(widthMeasureSpec,heightMeasureSpec);
        setMeasuredDimension(sizePixel,sizePixel);//for square board
    }

    @Override
    protected void onDraw(Canvas canvas) {

        cellPixelSize=(float)((float)getWidth()/size);
        System.out.println(cellPixelSize);
        drawLines(canvas);
        fillCells(canvas);
        drawText(canvas);
    }
    public void fillCells(Canvas canvas)
    {
        if(selectedRow==-1||selectedCol==-1)
            return;

        for(int r=0;r<size;r++)
        {

            for(int c=0;c<size;c++)
            {
                if(r==selectedRow&&c==selectedCol) {
                    //System.out.println("Row=" + r + ", Col=" + c);

                    fillCell(r,c,canvas);
                }

            }
        }
    }

    public void fillCell(int r,int c,Canvas canvas)
    {
        canvas.drawRect(c*cellPixelSize,r*cellPixelSize,(c+1)*cellPixelSize,(r+1)*cellPixelSize,selectedPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            handleTouchEvent(event.getX(),event.getY());
            return true;
        }
        return false;
    }

    public void customInvaldidate()
    {
        invalidate();
    }

    public void handleTouchEvent(float x,float y)
    {

        selectedRow=(int)(y/cellPixelSize);
        selectedCol=(int)(x/cellPixelSize);
        //Change current value accordingly
        Puzzle8x8.curgrid[selectedRow][selectedCol]=allpos.get(Puzzle8x8.curgrid[selectedRow][selectedCol]);
        invalidate();
    }
    public void drawText(Canvas canvas)
    {

        for(int r=0;r<size;r++) {

            for (int c = 0; c < size; c++) {

                String value = Puzzle8x8.curgrid[r][c];

                Rect textBound = new Rect();
                textPaint.getTextBounds(value, 0, 1, textBound);
                float textWidth = textPaint.measureText(value);
                float textHeight = textBound.height();

                canvas.drawText(value, (c * cellPixelSize) + cellPixelSize / 2,
                        (r * cellPixelSize) + cellPixelSize / 2 + 20, textPaint);
            }
        }

    }
    protected void drawLines(Canvas canvas)
    {

        canvas.drawRect(0F,0F,getWidth(),getHeight(),thickLinePaint);

        for(int i=1;i<=size;i++)
        {

            //Vertical Lines
            canvas.drawLine(
                    i*cellPixelSize,
                    0F,
                    i*cellPixelSize,
                    getHeight(),
                    thickLinePaint);
            //Horizontal Lines
            canvas.drawLine(
                    0F,
                    i*cellPixelSize,
                    getWidth(),
                    i*cellPixelSize,
                    thickLinePaint);
        }

    }


}
