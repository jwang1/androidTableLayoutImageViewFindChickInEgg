package com.iexpress.hello.findegginshoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

  int[] imageIds = new int[] {R.drawable.no_check_in_egg, R.drawable.chick_in_egg,
      R.drawable.no_check_in_egg};

  private ImageView img1;
  private ImageView img2;
  private ImageView img3;
  private TextView result;

  boolean played;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    result = (TextView) findViewById(R.id.textViewTitle);

    img1 = (ImageView) findViewById(R.id.imageView);
    img2 = (ImageView) findViewById(R.id.imageView2);
    img3 = (ImageView) findViewById(R.id.imageView3);

    img1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        isRight(v, 0);
      }
    });

    img2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        isRight(v, 1);
      }
    });

    img3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        isRight(v, 2);
      }
    });

    Button btn = (Button) findViewById(R.id.playAgainButton);
    btn.setTextColor(Color.BLUE);
    btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startPlaying();

      }
    });


    // Ready to play
    startPlaying();

  }

  private void startPlaying() {
    reset();
    result.setTextColor(Color.BLACK);
    result.setText(R.string.title);
    img1.setImageAlpha(255);
    img2.setImageAlpha(255);
    img3.setImageAlpha(255);
    img1.setImageDrawable(getResources().getDrawable(R.drawable.no_check_in_egg));
    img2.setImageDrawable(getResources().getDrawable(R.drawable.no_check_in_egg));
    img3.setImageDrawable(getResources().getDrawable(R.drawable.no_check_in_egg));
  }

  private void isRight(View v, int i) {
    if (played) {
      result.setText(R.string.guidance);
      result.setTextColor(Color.MAGENTA);
      return;
    } else {
      played = true;
    }

    img1.setImageDrawable(getResources().getDrawable(imageIds[0]));
    img2.setImageDrawable(getResources().getDrawable(imageIds[1]));
    img3.setImageDrawable(getResources().getDrawable(imageIds[2]));

    img1.setImageAlpha(100);
    img2.setImageAlpha(100);
    img3.setImageAlpha(100);

    ImageView iv = (ImageView) v;
    iv.setImageAlpha(255);

    if (imageIds[i] == R.drawable.chick_in_egg) {
      result.setText(R.string.congrats);
      result.setTextColor(Color.BLUE);
    } else {
      result.setText(R.string.keep_trying);
      result.setTextColor(Color.RED);
    }

  }

  private void reset() {
    played = false;

    // for each position, swapping with another one randomly selected, can swap with itself
    for (int i=0; i < imageIds.length; i++) {
      int tmp = imageIds[i];
      // idx either 0, 1, or 2
      int idx = (int) (Math.random() * 3);
      Toast.makeText(this, "random idx is: " + idx, Toast.LENGTH_SHORT).show();
      imageIds[i] = imageIds[idx];
      imageIds[idx] = tmp;
    }
  }

}
