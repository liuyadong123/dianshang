package com.example.day03.applicon;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.io.File;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DisplayImageOptions options =new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .displayer(new FadeInBitmapDisplayer(1000))
                .build();
        ImageLoaderConfiguration build =new ImageLoaderConfiguration.Builder(this)
                .memoryCacheSizePercentage(20)
                .diskCacheSize(50*1024*1024)
                .diskCache(new UnlimitedDiskCache(new File(Environment.getExternalStorageDirectory()+"/liu")))
                .defaultDisplayImageOptions(options)
                .build();
        ImageLoader.getInstance().init(build);
    }
}
