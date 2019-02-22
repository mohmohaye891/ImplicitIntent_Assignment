package com.myapplication.implicitintent_assignment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.VideoView;

public class CaptureVideoActivity extends AppCompatActivity {

    Button btnCaptureVideo, btnCaptureVideoWithoutData, btnPlayVideo;

    VideoView videoView;

    public static int VIDEO_CAPTURED = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_video);

        btnCaptureVideo = findViewById(R.id.btn_captureVideoButton);
        btnCaptureVideoWithoutData = findViewById(R.id.btn_captureVideoWithoutData);
        btnPlayVideo = findViewById(R.id.btn_play_video);
        videoView = findViewById(R.id.vv_videoView);
    }
}
