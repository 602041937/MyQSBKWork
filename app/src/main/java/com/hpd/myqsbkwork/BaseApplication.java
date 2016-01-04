package com.hpd.myqsbkwork;

import android.app.Application;
import android.graphics.Bitmap;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

/**
 * Created by jash
 * Date: 15-12-29
 * Time: 上午11:54
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Picasso picasso = new Picasso.Builder(this)
                .memoryCache(new LruCache(10 << 20))
                .downloader(new OkHttpDownloader(getCacheDir(), 30 << 20))
                .defaultBitmapConfig(Bitmap.Config.RGB_565)
                .build();
        Picasso.setSingletonInstance(picasso);


        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setBitmapMemoryCacheParamsSupplier(new Supplier<MemoryCacheParams>() {
                    @Override
                    public MemoryCacheParams get() {
//设置缓存的参数1.最多的图片的大小 2.图片的数量

                        return new MemoryCacheParams(20 << 20,
                                100,
                                Integer.MAX_VALUE,
                                Integer.MAX_VALUE,
                                Integer.MAX_VALUE
                        );
                    }
                })
//最大缓存大小，缓存的路径，和缓存的文件名， 和图片的配置565可以减少大小，默认大小是4个8

                .setMainDiskCacheConfig(DiskCacheConfig.newBuilder()
                        .setMaxCacheSize(50 << 20)
                        .setBaseDirectoryPath(getCacheDir())
                        .setBaseDirectoryName("fresco")
                        .build())
                .setBitmapsConfig(Bitmap.Config.RGB_565)
                .setProgressiveJpegConfig(new SimpleProgressiveJpegConfig())
                .build();
        Fresco.initialize(this, config);

    }
}
