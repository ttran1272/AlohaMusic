package edu.orangecoastcollege.cs273.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import static edu.orangecoastcollege.cs273.alohamusic.R.raw.hula;

public class MusicActivity extends AppCompatActivity {

    // References to UI components
    Button ukuleleButton;
    Button ipuButton;
    Button hulaButton;

    VideoView hulaVideoView;

    MediaPlayer ukuleleMediaPlayer;
    MediaPlayer ipuMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        // Associate the components
        ukuleleButton = (Button) findViewById(R.id.ukuleleButton);
        ipuButton = (Button) findViewById(R.id.ipuButton);
        hulaButton = (Button) findViewById(R.id.hulaButton);
        hulaVideoView = (VideoView) findViewById(R.id.hulaVideoView);

        // Associate the Media Players
        ukuleleMediaPlayer = MediaPlayer.create(this, R.raw.ukulele);
        ipuMediaPlayer = MediaPlayer.create(this, R.raw.ipu);

        // Associate the Video View with its URI
        String uri = "android.resource://" + getPackageName() + "/" + hula;
        hulaVideoView.setVideoURI(Uri.parse(uri));

        // Create a MediaController for the VideoView
        // MediaController = controls (play/pause/forward/rewind)
        hulaVideoView.setMediaController(new MediaController(this));
    }


    // Method will handle all 3 button clicks
    // Use the button id to see which was clicked
    public void playMedia(View v){
        // Make a decision based on the id of the view
        switch (v.getId())
        {
            case R.id.ukuleleButton:
                // if it's playing, pause it
                // else, play it
                if (ukuleleMediaPlayer.isPlaying())
                {
                    ukuleleMediaPlayer.pause();
                    //Change the text
                    ukuleleButton.setText(R.string.ukulele_button_play_text);

                    //Show other two buttons:
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    ukuleleMediaPlayer.start();
                    //Change the text
                    ukuleleButton.setText(R.string.ukulele_button_pause_text);

                    //Hide other two buttons:
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.ipuButton:
                // if it's playing, pause it
                // else, play it
                if (ipuMediaPlayer.isPlaying())
                {
                    ipuMediaPlayer.pause();
                    //Change the text
                    ipuButton.setText(R.string.ipu_button_play_text);

                    //Show other two buttons:
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    ipuMediaPlayer.start();
                    //Change the text
                    ipuButton.setText(R.string.ipu_button_pause_text);

                    //Hide other two buttons:
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.hulaButton:
                // if it's playing, pause it
                // else, play it
                if (hulaVideoView.isPlaying())
                {
                    hulaVideoView.pause();
                    //Change the text
                    hulaButton.setText(R.string.hula_button_watch_text);

                    //Show other two buttons:
                    ipuButton.setVisibility(View.VISIBLE);
                    ukuleleButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    hulaVideoView.start();
                    //Change the text
                    hulaButton.setText(R.string.hula_button_pause_text);

                    //Hide other two buttons:
                    ipuButton.setVisibility(View.INVISIBLE);
                    ukuleleButton.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }

    // Override onStop method to release MediaPlayers
    // Prevent memory leaks


    @Override
    protected void onStop() {
        super.onStop();
        ukuleleMediaPlayer.release();
        ipuMediaPlayer.release();
    }
}
