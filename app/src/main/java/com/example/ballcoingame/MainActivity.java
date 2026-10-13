package com.example.ballcoingame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView());
    }

    class GameView extends View {
        Paint paint = new Paint();
        float ballX = 200, ballY = 300;
        int score = 0;

        public GameView() {
            super(MainActivity.this);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.rgb(20, 25, 45));

            paint.setColor(Color.WHITE);
            paint.setTextSize(50);
            canvas.drawText("Ball Coin Game", 40, 80, paint);

            paint.setColor(Color.YELLOW);
            canvas.drawCircle(150, 450, 25, paint);
            canvas.drawCircle(300, 600, 25, paint);

            paint.setColor(Color.CYAN);
            canvas.drawCircle(ballX, ballY, 35, paint);

            paint.setColor(Color.WHITE);
            paint.setTextSize(40);
            canvas.drawText("Score: " + score, 40, 150, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                ballX = event.getX();
                ballY = event.getY();
                score++;
                invalidate();
            }
            return true;
        }
    }
}
