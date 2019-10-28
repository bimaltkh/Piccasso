package com.example.piccasso;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideContext;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.squareup.picasso.Picasso.with;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        imageView=findViewById(R.id.imageView);


        Glide.with(MainActivity.this).load("https://3.bp.blogspot.com/-T6a7NIdxu7Q/XHGC8i1WZYI/AAAAAAAAKZk/_LwKrTiW4l8SY40h5j4FtckBha4B6-rmgCHMYCw/s1600/mahendra-singh-dhoni-wallpapers-hd-download-free-1080p-ms-dhoni.jpg").into(imageView);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                BitmapDrawable draw = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap = draw.getBitmap();

                FileOutputStream outStream = null;
                File sdCard = Environment.getExternalStorageDirectory();
                File dir = new File(sdCard.getAbsolutePath() + "/fdsgfjgjrwrewjjbgejegke");
                dir.mkdirs();
                String fileName = String.format("%d.jpg", System.currentTimeMillis());
                File outFile = new File(dir, fileName);
                Toast.makeText(MainActivity.this,"Downloading",Toast.LENGTH_SHORT).show();
                try {
                    outStream = new FileOutputStream(outFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
                try {
                    outStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    outStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



        });
    }
}
