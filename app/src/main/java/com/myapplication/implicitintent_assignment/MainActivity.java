package com.myapplication.implicitintent_assignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_VIDEO_CAPTURE = 1;

    Button btnCaptureVideo, btnPlayVideo;
    VideoView videoView;
    TextView tvNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnCaptureVideo = findViewById(R.id.btn_capture_video);
        btnCaptureVideo = findViewById(R.id.btn_play_video);
        videoView = findViewById(R.id.vv_videoView);
        tvNext = findViewById(R.id.tv_next);

      btnCaptureVideo.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              dispatchTakeVideoIntent(v);
          }
      });

       /* btnPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.start();
            }
        });*/

      tvNext.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

          }
      });


    }

    public void dispatchTakeVideoIntent(View v) {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = data.getData();
            videoView.setVideoURI(videoUri);
            videoView.start();
        }
    }
}
