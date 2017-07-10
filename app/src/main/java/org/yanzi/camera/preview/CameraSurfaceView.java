package org.yanzi.camera.preview;

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import org.yanzi.camera.CameraInterface;

public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
	private static final String TAG = "YanZi";

	CameraInterface mCameraInterface;
	Context mContext;
	SurfaceHolder mSurfaceHolder;

	public CameraSurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mContext = context;
		mSurfaceHolder = getHolder();
		mSurfaceHolder.setFormat(PixelFormat.TRANSPARENT);//translucent��͸�� transparent͸��
		mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		mSurfaceHolder.addCallback(this);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		Log.i(TAG, "surfaceCreated...");

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		Log.i(TAG, "surfaceChanged...");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		Log.i(TAG, "surfaceDestroyed...");
		CameraInterface.getInstance().doStopCamera();
	}
	public SurfaceHolder getSurfaceHolder(){
		return mSurfaceHolder;
	}





}
