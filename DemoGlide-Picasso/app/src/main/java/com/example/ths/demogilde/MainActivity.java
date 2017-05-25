package com.example.ths.demogilde;

import android.app.ProgressDialog;
import com.facebook.common.util.UriUtil;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btGlide, btPicasso, btImagesLoader, btFresco;
    private ImageView imageView;
    private SimpleDraweeView sdvImage;
    public static final String LINK_URL = "https://lh6.ggpht.com/9SZhHdv4URtBzRmXpnWxZcYhkgTQurFuuQ8OR7WZ3R7fyTmha77dYkVvcuqMu3DLvMQ=w300";
    ImageLoader imageLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        initView();

        imageLoader =ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btGilde:
                Glide.with(getApplicationContext()).load(LINK_URL).placeholder(R.drawable.androidify).into(imageView);
                break;
            case R.id.btPicasso:
                Picasso.with(getApplicationContext()).load(LINK_URL).placeholder(R.drawable.androidify).into(imageView);
                break;
            case R.id.btFresco:
               final Uri uri = Uri.parse(LINK_URL);
                sdvImage.setImageURI(uri);
                break;
            case R.id.btImageLoader:
                imageLoader.displayImage(LINK_URL,imageView);
                break;
            default:
                break;
        }
    }

    private void initView() {
        btGlide = (Button) findViewById(R.id.btGilde);
        btPicasso = (Button) findViewById(R.id.btPicasso);
        btFresco = (Button) findViewById(R.id.btFresco);
        btImagesLoader = (Button) findViewById(R.id.btImageLoader);
        imageView = (ImageView) findViewById(R.id.imageView);
        btGlide.setOnClickListener(this);
        btPicasso.setOnClickListener(this);
        btFresco.setOnClickListener(this);
        btImagesLoader.setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.imageView);
        sdvImage = (SimpleDraweeView) findViewById(R.id.sdv_image);
    }


}
