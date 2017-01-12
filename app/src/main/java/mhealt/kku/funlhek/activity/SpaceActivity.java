package mhealt.kku.funlhek.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

import mhealt.kku.funlhek.R;

public class SpaceActivity extends AppCompatActivity {

   /* private VideoView videoView;
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.MATCH_PARENT
    );
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space);

        Toast.makeText(SpaceActivity.this, "Alert", Toast.LENGTH_LONG).show();

/*
        try{
            videoView = new VideoView(this);
            setContentView(videoView);
            Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                    + R.raw.openningmov);
            videoView.setVideoURI(video);
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                public void onCompletion(MediaPlayer mp) {
                    //jump();
                }



            });
            videoView.start();
        } catch(Exception ex) {
            //jump();
        }*/

        // Auto Intend
        /*Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SpaceActivity.this, MapsActivity.class));
                finish();
            }
        }, 2000); // หน่วงเวลา*/
    }


}
