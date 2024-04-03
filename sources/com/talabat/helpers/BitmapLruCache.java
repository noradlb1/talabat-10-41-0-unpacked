package com.talabat.helpers;

import android.graphics.Bitmap;
import androidx.collection.LruCache;
import com.android.volley.toolbox.ImageLoader;

public class BitmapLruCache extends LruCache<String, Bitmap> implements ImageLoader.ImageCache {
    public BitmapLruCache() {
        this(getDefaultLruCacheSize());
    }

    public static int getDefaultLruCacheSize() {
        return ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 8;
    }

    public Bitmap getBitmap(String str) {
        return (Bitmap) get(str);
    }

    public void putBitmap(String str, Bitmap bitmap) {
        put(str, bitmap);
    }

    public BitmapLruCache(int i11) {
        super(i11);
    }

    public int sizeOf(String str, Bitmap bitmap) {
        return (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
    }
}
