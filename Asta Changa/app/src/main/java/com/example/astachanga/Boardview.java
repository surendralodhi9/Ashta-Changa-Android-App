package com.example.astachanga;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boardview extends View {


    private Paint thickLinePaint=new Paint();
    private Paint selectedPaint=new Paint();
    private Paint selectedPaint2=new Paint();
    private Paint selectedPaint3=new Paint();
    private Paint selectedPaint4=new Paint();
    private Paint selectedPaintCenter=new Paint();
    private Paint textPaint=new Paint();
    public static float width=0;
    public static float height=0;
    public static int size=5;
    public static int sqrtSize=(int)Math.sqrt(size);
    public Map<String,String> allpos=new HashMap<String,String>();
    public List<Map<String,Integer>> getloc=new ArrayList<Map<String,Integer>>();
    public static int [][][]Moves=new int[4][25][2];

    public float cellPixelSize=0F;

    public int selectedRow=0;
    public int selectedCol=0;

    public Boardview(Context context, AttributeSet attributeSet)
    {
        super(context,attributeSet);
        thickLinePaint.setColor(Color.BLACK);
        thickLinePaint.setStrokeWidth(4F);
        thickLinePaint.setStyle(Paint.Style.STROKE);


        float []hsv=new float[3];
        Color.RGBToHSV(57,78,194,hsv);
        selectedPaint.setColor(Color.HSVToColor(hsv));
        selectedPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        Color.RGBToHSV(21,216,198,hsv);
        selectedPaint2.setColor(Color.HSVToColor(hsv));
        selectedPaint2.setStyle(Paint.Style.FILL_AND_STROKE);

        Color.RGBToHSV(255,140,0,hsv);
        selectedPaint3.setColor(Color.HSVToColor(hsv));
        selectedPaint3.setStyle(Paint.Style.FILL_AND_STROKE);

        Color.RGBToHSV(226,158,238,hsv);
        selectedPaint4.setColor(Color.HSVToColor(hsv));
        selectedPaint4.setStyle(Paint.Style.FILL_AND_STROKE);

        selectedPaintCenter.setColor(Color.YELLOW);
        selectedPaintCenter.setStyle(Paint.Style.FILL_AND_STROKE);

        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(50F);//50F
        allpos.put(" ","0");
        allpos.put("0","1");
        allpos.put("1"," ");
        //Player1
        Moves[0][0][0]=2;Moves[0][0][1]=0;
        Moves[0][1][0]=3;Moves[0][1][1]=0;
        Moves[0][2][0]=4;Moves[0][2][1]=0;
        Moves[0][3][0]=4;Moves[0][3][1]=1;
        Moves[0][4][0]=4;Moves[0][4][1]=2;
        Moves[0][5][0]=4;Moves[0][5][1]=3;
        Moves[0][6][0]=4;Moves[0][6][1]=4;
        Moves[0][7][0]=3;Moves[0][7][1]=4;
        Moves[0][8][0]=2;Moves[0][8][1]=4;
        Moves[0][9][0]=1;Moves[0][9][1]=4;
        Moves[0][10][0]=0;Moves[0][10][1]=4;
        Moves[0][11][0]=0;Moves[0][11][1]=3;
        Moves[0][12][0]=0;Moves[0][12][1]=2;
        Moves[0][13][0]=0;Moves[0][13][1]=1;
        Moves[0][14][0]=0;Moves[0][14][1]=0;
        Moves[0][15][0]=1;Moves[0][15][1]=0;
        Moves[0][16][0]=1;Moves[0][16][1]=1;
        Moves[0][17][0]=1;Moves[0][17][1]=2;
        Moves[0][18][0]=1;Moves[0][18][1]=3;
        Moves[0][19][0]=2;Moves[0][19][1]=3;
        Moves[0][20][0]=3;Moves[0][20][1]=3;
        Moves[0][21][0]=3;Moves[0][21][1]=2;
        Moves[0][22][0]=3;Moves[0][22][1]=1;
        Moves[0][23][0]=2;Moves[0][23][1]=1;
        Moves[0][24][0]=2;Moves[0][24][1]=2;

        //Player2
        Moves[1][0][0]=4;Moves[1][0][1]=2;
        Moves[1][1][0]=4;Moves[1][1][1]=3;
        Moves[1][2][0]=4;Moves[1][2][1]=4;
        Moves[1][3][0]=3;Moves[1][3][1]=4;
        Moves[1][4][0]=2;Moves[1][4][1]=4;
        Moves[1][5][0]=1;Moves[1][5][1]=4;
        Moves[1][6][0]=0;Moves[1][6][1]=4;
        Moves[1][7][0]=0;Moves[1][7][1]=3;
        Moves[1][8][0]=0;Moves[1][8][1]=2;
        Moves[1][9][0]=0;Moves[1][9][1]=1;
        Moves[1][10][0]=0;Moves[1][10][1]=0;
        Moves[1][11][0]=1;Moves[1][11][1]=0;
        Moves[1][12][0]=2;Moves[1][12][1]=0;
        Moves[1][13][0]=3;Moves[1][13][1]=0;
        Moves[1][14][0]=4;Moves[1][14][1]=0;
        Moves[1][15][0]=4;Moves[1][15][1]=1;
        Moves[1][16][0]=3;Moves[1][16][1]=1;
        Moves[1][17][0]=2;Moves[1][17][1]=1;
        Moves[1][18][0]=1;Moves[1][18][1]=1;
        Moves[1][19][0]=1;Moves[1][19][1]=2;
        Moves[1][20][0]=1;Moves[1][20][1]=3;
        Moves[1][21][0]=2;Moves[1][21][1]=3;
        Moves[1][22][0]=3;Moves[1][22][1]=3;
        Moves[1][23][0]=3;Moves[1][23][1]=2;
        Moves[1][24][0]=2;Moves[1][24][1]=2;

        //Player3
        Moves[2][0][0]=2;Moves[2][0][1]=4;
        Moves[2][1][0]=1;Moves[2][1][1]=4;
        Moves[2][2][0]=0;Moves[2][2][1]=4;
        Moves[2][3][0]=0;Moves[2][3][1]=3;
        Moves[2][4][0]=0;Moves[2][4][1]=2;
        Moves[2][5][0]=0;Moves[2][5][1]=1;
        Moves[2][6][0]=0;Moves[2][6][1]=0;
        Moves[2][7][0]=1;Moves[2][7][1]=0;
        Moves[2][8][0]=2;Moves[2][8][1]=0;
        Moves[2][9][0]=3;Moves[2][9][1]=0;
        Moves[2][10][0]=4;Moves[2][10][1]=0;
        Moves[2][11][0]=4;Moves[2][11][1]=1;
        Moves[2][12][0]=4;Moves[2][12][1]=2;
        Moves[2][13][0]=4;Moves[2][13][1]=3;
        Moves[2][14][0]=4;Moves[2][14][1]=4;
        Moves[2][15][0]=3;Moves[2][15][1]=4;
        Moves[2][16][0]=3;Moves[2][16][1]=3;
        Moves[2][17][0]=3;Moves[2][17][1]=2;
        Moves[2][18][0]=3;Moves[2][18][1]=1;
        Moves[2][19][0]=2;Moves[2][19][1]=1;
        Moves[2][20][0]=1;Moves[2][20][1]=1;
        Moves[2][21][0]=1;Moves[2][21][1]=2;
        Moves[2][22][0]=1;Moves[2][22][1]=3;
        Moves[2][23][0]=2;Moves[2][23][1]=3;
        Moves[2][24][0]=2;Moves[2][24][1]=2;

        //Player4
        Moves[3][0][0]=0;Moves[3][0][1]=2;
        Moves[3][1][0]=0;Moves[3][1][1]=1;
        Moves[3][2][0]=0;Moves[3][2][1]=0;
        Moves[3][3][0]=1;Moves[3][3][1]=0;
        Moves[3][4][0]=2;Moves[3][4][1]=0;
        Moves[3][5][0]=3;Moves[3][5][1]=0;
        Moves[3][6][0]=4;Moves[3][6][1]=0;
        Moves[3][7][0]=4;Moves[3][7][1]=1;
        Moves[3][8][0]=4;Moves[3][8][1]=2;
        Moves[3][9][0]=4;Moves[3][9][1]=3;
        Moves[3][10][0]=4;Moves[3][10][1]=4;
        Moves[3][11][0]=3;Moves[3][11][1]=4;
        Moves[3][12][0]=2;Moves[3][12][1]=4;
        Moves[3][13][0]=1;Moves[3][13][1]=4;
        Moves[3][14][0]=0;Moves[3][14][1]=4;
        Moves[3][15][0]=0;Moves[3][15][1]=3;
        Moves[3][16][0]=1;Moves[3][16][1]=3;
        Moves[3][17][0]=2;Moves[3][17][1]=3;
        Moves[3][18][0]=3;Moves[3][18][1]=3;
        Moves[3][19][0]=3;Moves[3][19][1]=2;
        Moves[3][20][0]=3;Moves[3][20][1]=1;
        Moves[3][21][0]=2;Moves[3][21][1]=1;
        Moves[3][22][0]=1;Moves[3][22][1]=1;
        Moves[3][23][0]=1;Moves[3][23][1]=2;
        Moves[3][24][0]=2;Moves[3][24][1]=2;
        for(int i=0;i<4;i++)
        {
            Map<String,Integer> mp=new HashMap<>();
            for(int j=0;j<25;j++)
            {
                mp.put(String.valueOf(Moves[i][j][0])+String.valueOf(Moves[i][j][1]),j);
            }
            getloc.add(mp);
        }





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
        fillCells(canvas);//For color

        drawText(canvas);
    }
    public void fillCells(Canvas canvas)
    {

        fillCell(2,0,canvas,selectedPaint);
        fillCell(4,2,canvas,selectedPaint2);
        fillCell(2,4,canvas,selectedPaint3);
        fillCell(0,2,canvas,selectedPaint4);

        canvas.drawRect(2*cellPixelSize,2*cellPixelSize,(2+1)*cellPixelSize,(2+1)*cellPixelSize,selectedPaintCenter);//Center
        //drawLinesInBox(canvas,4,2,2);//center

        /*
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
        }*/
    }

    public void fillCell(int r,int c,Canvas canvas,Paint paint)
    {

        canvas.drawRect(c*cellPixelSize,r*cellPixelSize,(c+1)*cellPixelSize,(r+1)*cellPixelSize,paint);
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


        int curToss=0;
        String allScore=MainActivity.currentScore.getText().toString();
        System.out.println("Score queue " +allScore);
        if(allScore.length()>0)
        curToss=takeAllBeforeComma(allScore);
        else
            return;
        System.out.println("Cure toss "+curToss+2);
        //System.out.println("y="+y);
        //System.out.println("x="+x);
        //System.out.println("cellPixelSize="+cellPixelSize);
        selectedRow=(int)(y/cellPixelSize);
        selectedCol=(int)(x/cellPixelSize);
        //Change current value accordingly
        //MainActivity.curgrid[selectedRow][selectedCol]=allpos.get(MainActivity.curgrid[selectedRow][selectedCol]);
        //Display all in
        String cur=MainActivity.curgrid[selectedRow][selectedCol];
        int ct=cur.length();
        int sqrsize=(int)Math.floor(Math.sqrt(ct));

        if((sqrsize*sqrsize)<ct)
            sqrsize++;

        int cellSize=(int)cellPixelSize/sqrsize;
        int selectedR=(int)(y-cellPixelSize*selectedRow)/cellSize;
        int selectedC=(int)(x-cellPixelSize*selectedCol)/cellSize;

        int loc=sqrsize*selectedR+selectedC;
        System.out.println("Loca "+loc);
        //Check if press any empty cell then what?
        if(loc<ct) {

            int playerIndex=(int)cur.charAt(loc)-'A';
            if(playerIndex!=MainActivity.previous)//If  player moves others goti
                return;


            String temp=String.valueOf(selectedRow)+String.valueOf(selectedCol);
            if(cur.charAt(0)==' ')
                return;
            int index=(getloc.get(playerIndex)).get(temp);

            allScore=deleteAllBeforeComma(allScore);
            System.out.println("After deleting "+allScore);

            MainActivity.countPrevious[curToss]--;


            MainActivity.currentScore.setText(allScore);

            if(index+curToss<25) {

                //delete as it is possible to move

                int curReachableR = Moves[playerIndex][index + curToss][0];
                int curReachableC = Moves[playerIndex][index + curToss][1];


                String curValue = MainActivity.curgrid[curReachableR][curReachableC];
                if (!homeOfPlayer(curReachableR, curReachableC) && curValue.length() == 1 && curValue.charAt(0) != ' ' && curValue.charAt(0) != cur.charAt(loc))
                {

                    int indexOfHome=curValue.charAt(0)-'A';
                    String curInHome=MainActivity.curgrid[Moves[indexOfHome][0][0]][Moves[indexOfHome][0][1]];
                    curInHome=currentAfterDeletingSpace(curInHome)+curValue;
                    MainActivity.curgrid[Moves[indexOfHome][0][0]][Moves[indexOfHome][0][1]]=curInHome;//Mar kar ghar mein rakhna
                    curValue = "";
                    //fl=1;

                    MainActivity.turn=MainActivity.previous;
                    MainActivity.currentPlayer.setText(MainActivity.Player[MainActivity.turn]);
                    MainActivity.previousPlayer.setText(MainActivity.Player[MainActivity.previous]);
                    /*if(MainActivity.turn==0)
                        MainActivity.turn=MainActivity.count-1;
                    else
                        MainActivity.turn--;*/
                }
                else
                {
                    //MainActivity.turn++;
                    //MainActivity.turn=MainActivity.turn%MainActivity.count;

                }

                if(curValue.length()==1&&curValue.charAt(0)==' ')
                    curValue="";
                curValue=curValue+String.valueOf(cur.charAt(loc));
                MainActivity.curgrid[curReachableR][curReachableC]=curValue;//Updating value in new cell
                String newValue="";
                    //System.out.println("Char is " + cur.charAt(loc));
                for(int i=0;i<ct;i++)
                {
                    if(i!=loc)
                      newValue=newValue+String.valueOf(cur.charAt(i));
                }
                if(newValue.length()==0)
                    newValue=" ";//Previously it was space

                MainActivity.curgrid[selectedRow][selectedCol] = newValue;//Updating deleted value
            }
            else
            {
                //System.out.println("Not Reachable");
                //MainActivity.turn++;
                //MainActivity.turn=MainActivity.turn%MainActivity.count;

            }
        }

        invalidate();
        //MainActivity ob=new MainActivity();
        MainActivity.btnSpin.setText("ROLL");

    }
    public String currentAfterDeletingSpace(String str)
    {
        if(str.length()>0&&str.charAt(0)==' ')
            return str.substring(1);
        return str;

    }
    public String deleteAllBeforeComma(String str)
    {
        for(int j=0;j<str.length();j++)
        {
            if(str.charAt(j)==',')
                return str.substring(j+1);
        }
        return "";
    }
    public int takeAllBeforeComma(String str)
    {

        String temp="";
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==',')
            {
                return Integer.parseInt(temp);
            }
            else
                temp=temp+String.valueOf(str.charAt(i));
        }
        return Integer.parseInt(temp);
    }

    public boolean homeOfPlayer(int r,int c)
    {

        if((r==2&&c==0)||(r==4&&c==2)||(r==2&&c==4)||(r==0&&c==2)||(r==2&&c==2))
         return  true;
        return false;

    }
    public void drawText(Canvas canvas)
    {

        for(int r=0;r<size;r++) {

            for (int c = 0; c < size; c++) {

                String value = MainActivity.curgrid[r][c];

                int ct=value.length();
                //System.out.println(value);
                Rect textBound = new Rect();
                textPaint.getTextBounds(value, 0, 1, textBound);
                float textWidth = textPaint.measureText(value);
                float textHeight = textBound.height();


                int loc=0;
                int sqrsize=(int)Math.floor(Math.sqrt(ct));

                if((sqrsize*sqrsize)<ct)
                    sqrsize++;


                int div=sqrsize*sqrsize;
                float cellSize=cellPixelSize/div;

                //System.out.println("cell "+cellSize);
                if(ct>1)
                {
                    drawLinesInBox(canvas,sqrsize,r,c);//center
                for(int i=0;i<sqrsize;i++)
                {
                    for(int j=0;j<sqrsize;j++) {

                        canvas.drawText(String.valueOf(value.charAt(loc++)), (c * cellPixelSize+10 + (j*sqrsize)*cellSize) + cellPixelSize / div,
                                (r * cellPixelSize+10+i*sqrsize*cellSize) + cellPixelSize / div + 20, textPaint);
                        if(loc>=ct)
                            break;
                    }
                    if(loc>=ct)
                        break;
                }
                }
                else {

                    canvas.drawText(value, (c * cellPixelSize) + cellPixelSize /2,
                            (r * cellPixelSize) + cellPixelSize / 2 + 20, textPaint);
                }


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

        //drawLinesInBox(canvas,2,2,0);//left
        //drawLinesInBox(canvas,2,2,4);//right
        //drawLinesInBox(canvas,3,0,2);//top
        //drawLinesInBox(canvas,2,4,2);//bottom

    }
    public void drawLinesInBox(Canvas canvas,int ct,int r,int c)
    {


        canvas.drawRect(r*cellPixelSize,c*cellPixelSize,c*cellPixelSize+cellPixelSize,r*cellPixelSize+cellPixelSize,thickLinePaint);


        float cellSize=cellPixelSize/ct;
        for(int i=1;i<=ct;i++)
        {

            //Vertical Lines
            canvas.drawLine(
                    c*cellPixelSize+i*cellSize,
                    r*cellPixelSize,
                    c*cellPixelSize+i*cellSize,
                    r*cellPixelSize+cellPixelSize,
                    thickLinePaint);
            //Horizontal Lines
            canvas.drawLine(
                    c*cellPixelSize,
                    r*cellPixelSize+i*cellSize,
                    c*cellPixelSize+cellPixelSize,
                    r*cellPixelSize+i*cellSize,
                    thickLinePaint);
        }


    }

}
