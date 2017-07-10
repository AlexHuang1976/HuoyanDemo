package org.yanzi.camera.preview;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Alex on 2017/7/9.
 */

public class SVDraw extends SurfaceView implements SurfaceHolder.Callback{

    protected SurfaceHolder sh;
    private int mWidth;
    private int mHeight;
    private MyThread thread;

    public SVDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
        sh = this.getHolder();
        sh.addCallback(this);
        sh.setFormat(PixelFormat.TRANSPARENT);
        setZOrderOnTop(true);
    }

    public void surfaceChanged(SurfaceHolder arg0, int arg1, int w, int h) {
        mWidth = w;
        mHeight = h;
    }

    public void surfaceCreated(SurfaceHolder arg0) {

    }

    public void surfaceDestroyed(SurfaceHolder arg0) {

    }
    void clearDraw()
    {
        Canvas canvas = sh.lockCanvas();
        canvas.drawColor(Color.BLUE);
        sh.unlockCanvasAndPost(canvas);
    }
    public void drawLine()
    {
        //预览视频的时候绘制图像
        /*Canvas canvas = sh.lockCanvas();
        canvas.drawColor(Color.TRANSPARENT);
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setColor(Color.RED);
        p.setStyle(Style.STROKE);
        //canvas.drawPoint(100.0f, 100.0f, p);
        canvas.drawLine(0,110, 500, 110, p);
        canvas.drawCircle(110, 110, 10.0f, p);
        sh.unlockCanvasAndPost(canvas);*/

        thread = new MyThread(sh);
        thread.setRun(true,mWidth ,mHeight);
        thread.start();
    }
}
