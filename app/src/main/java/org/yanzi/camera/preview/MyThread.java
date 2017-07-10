package org.yanzi.camera.preview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.SurfaceHolder;

/**
 * Created by Alex on 2017/7/9.
 */

// 绘制线程
public class MyThread extends Thread {
    private SurfaceHolder holder;
    private boolean run;
    private int pos_h=0;
    private int mWidth,mHight;

    public MyThread(SurfaceHolder holder) {
        this.holder = holder;
        run = true;
    }

    @Override
    public void run() {


        // 如果高度大于屏幕高度



        int screenWidth = mWidth; // 屏幕宽（像素，如：px）
        int screenHeight = mHight; // 屏幕高（像素，如：px）

        Canvas canvas = null;
        pos_h = screenHeight/2-200;
        while (run) {
            // 具体绘制工作
            try {
                pos_h += 5;
                if (pos_h >= screenHeight/2+200) {
                    pos_h = screenHeight/2-200;
                }
                // 获取Canvas对象，并锁定之
                canvas = holder.lockCanvas();
                // 设定Canvas对象的背景颜色
                canvas.drawColor(Color.TRANSPARENT);

                // 创建画笔
                Paint p = new Paint();
                p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                canvas.drawPaint(p);
                p.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
                // 设置画笔颜色
                p.setColor(Color.GREEN);
                // 设置文字大小
                p.setStrokeWidth(1);


                canvas.drawLine(screenWidth/2-200, pos_h, screenWidth/2+200, pos_h,p);
                holder.unlockCanvasAndPost(canvas);
                Thread.sleep(200);

               // Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null) {
                    // 解除锁定，并提交修改内容
                    //holder.unlockCanvasAndPost(canvas);


                }
            }
        }
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run,int mwidth,int mheight) {
        this.run = run;
        this.mHight=mheight;
        this.mWidth=mwidth;
    }
}