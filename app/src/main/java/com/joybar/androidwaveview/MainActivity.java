package com.joybar.androidwaveview;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.joybar.androidwaveview.view.WaveBallView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {


    private int SENSITIVITY = 90;
    // 定义Sensor管理器
    private SensorManager sensorManager;

    private WaveBallView waveBallView1;
    private WaveBallView waveBallView2;
    private WaveBallView waveBallView3;

    private WaveBallView waveBallView4;
    private WaveBallView waveBallView5;
    private WaveBallView waveBallView6;

    private WaveBallView waveBallView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSensor();
        initWave();
    }

    @Override
    public void onResume() {
        super.onResume();
        // 注册/监听方向传感器
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        // 取消方向传感器的监听
        sensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    protected void onStop() {
        // 取消方向传感器的监听
        sensorManager.unregisterListener(this);
        super.onStop();
    }

    private void initSensor() {
        // 获取手机传感器管理服务
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    private void initWave() {
        waveBallView1 = (WaveBallView) this.findViewById(R.id.wave_ball_view1);
        waveBallView2 = (WaveBallView) this.findViewById(R.id.wave_ball_view2);
        waveBallView3 = (WaveBallView) this.findViewById(R.id.wave_ball_view3);

        waveBallView4 = (WaveBallView) this.findViewById(R.id.wave_ball_view4);
        waveBallView5 = (WaveBallView) this.findViewById(R.id.wave_ball_view5);
        waveBallView6 = (WaveBallView) this.findViewById(R.id.wave_ball_view6);
        waveBallView7 = (WaveBallView) this.findViewById(R.id.wave_ball_view7);


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {


        float[] values = sensorEvent.values;
        // 获取手机触发event的传感器的类型
        int sensorType = sensorEvent.sensor.getType();
        //定义气泡当前位置X Y坐标值
        int x = 0;
        int y = -0;
        int cx = 90;
        int cy = 90;


        switch (sensorType) {
            case Sensor.TYPE_ORIENTATION:
                int zAngle = (int) values[0];
                int yAngle = (int) values[1];
                int xAngle = (int) values[2];

                if (Math.abs(xAngle) <= SENSITIVITY) {
                    int deltaX = (int) (cx * xAngle / SENSITIVITY);
                    x += deltaX;
                } else if (xAngle > SENSITIVITY) {
                    x = 0;
                } else {
                    x = cx * 2;
                }
                if (Math.abs(yAngle) <= SENSITIVITY) {
                    int deltaY = (int) (cy * yAngle / SENSITIVITY);
                    y += deltaY;
                } else if (yAngle > SENSITIVITY) {
                    y = cy * 2;
                } else {
                    y = 0;
                }


                double angle = 0;
                if (y == 0) {
                    if (x < 0) {
                        angle = 90;
                    } else if (x == 0) {
                        angle = 0;
                    } else {
                        angle = -90;
                    }
                } else if (y < 0) {
                    if (x < 0) {
                        float v = ((float) (float) x / (float) y);
                        angle = Math.toDegrees(Math.atan(Math.abs(v)));
                    } else if (x == 0) {
                        //angle = 0;
                    } else {
                        float v = ((float) (float) x / (float) y);
                        angle = -Math.toDegrees(Math.atan(Math.abs(v)));
                    }
                } else {
                    if (x < 0) {
                        float v = ((float) (float) y / (float) x);
                        angle = Math.toDegrees(Math.atan(Math.abs(v)));
                        angle = angle + 90.0;

                    } else if (x == 0) {
                        //angle = -180;
                    } else {
                        float v = ((float) (float) y / (float) x);
                        angle = -Math.toDegrees(Math.atan(Math.abs(v)));
                        angle = angle - 90.0;
                    }
                }
                setWaveZOffset(waveBallView1, (float) -angle, 0.08f, 0.02f);
                setWaveZOffset(waveBallView2, (float) -angle, 0.08f, 0.25f);
                setWaveZOffset(waveBallView3, (float) -angle, 0.08f, 0.40f);
                setWaveZOffset(waveBallView4, (float) -angle, 0.08f, 0.50f);
                setWaveZOffset(waveBallView5, (float) -angle, 0.08f, 0.65f);
                setWaveZOffset(waveBallView6, (float) -angle, 0.08f, 0.80f);
                setWaveZOffset(waveBallView7, (float) -angle, 0.08f, 0.95f);
                break;
        }


    }


    private void setWaveZOffset(WaveBallView waveBallView, float orientationOffset,float heightPercent,float yPercent){
        waveBallView.setOrientationOffset(orientationOffset);
        waveBallView.setWaveYPercent(yPercent);
        waveBallView.setWaveHeightPercent(heightPercent);
        waveBallView.postInvalidate();
    }
}
