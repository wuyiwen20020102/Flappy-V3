package com.example.flappy;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Bird {
    private Bitmap[] bitmaps;
    private int ScreenW, ScreenH;
    private boolean isUp = false;//determine up/down of the bird
    private int x, y;
    private int state = 1;

    public Bird(Bitmap[] bitmaps, int screenW, int screenH) {
        this.bitmaps = bitmaps;
        this.ScreenW = screenW;
        this.ScreenH = screenH;
        x = screenW/6;
        y = screenH/2;
    }

    public void draw(Canvas canvas, Paint paint){canvas.drawBitmap(bitmaps[state], (float)x,y,paint);
    }

    public void logic() {
        if(y<=ScreenH-100){
            y+=35;
        }
    }

    public void toUpTouch() throws InterruptedException {
        if(y>=0){
            int upCount = 80;
            while(upCount > 0){
                y = y - 4;
                upCount--;
                Thread.sleep(1);
            }
        }
    }

    public void toUpVoice(int volume){
        if (volume >= 60) {
            if (y >= 0) {
                y -= 70; // Adjust this value to control the speed of ascent
            }
        }
    }

    public void reset() {
        x = ScreenW / 6; // Resetting the X position
        y = ScreenH / 2; // Resetting the Y position
        state = 1; // Resetting the state
        isUp = false; // Resetting the isUp flag
        // Reset any other variables if necessary
    }

    public void setState(int s){
        state = s;
    }

    public int getState(){
        return state;
    }

    public int getXCoordinate(){
        return x;
    }

    public float getYCoordinate(){
        return y;
    }

    public Bitmap getElementAtBitmap(int index){
        return bitmaps[index];
    }

}
