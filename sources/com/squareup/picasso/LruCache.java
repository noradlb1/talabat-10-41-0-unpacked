package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class LruCache implements Cache {

    /* renamed from: a  reason: collision with root package name */
    public final android.util.LruCache<String, BitmapAndSize> f53418a;

    public static final class BitmapAndSize {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f53420a;

        /* renamed from: b  reason: collision with root package name */
        public final int f53421b;

        public BitmapAndSize(Bitmap bitmap, int i11) {
            this.f53420a = bitmap;
            this.f53421b = i11;
        }
    }

    public LruCache(@NonNull Context context) {
        this(Utils.b(context));
    }

    public void clear() {
        this.f53418a.evictAll();
    }

    public void clearKeyUri(String str) {
        for (String next : this.f53418a.snapshot().keySet()) {
            if (next.startsWith(str) && next.length() > str.length() && next.charAt(str.length()) == 10) {
                this.f53418a.remove(next);
            }
        }
    }

    public int evictionCount() {
        return this.f53418a.evictionCount();
    }

    @Nullable
    public Bitmap get(@NonNull String str) {
        BitmapAndSize bitmapAndSize = this.f53418a.get(str);
        if (bitmapAndSize != null) {
            return bitmapAndSize.f53420a;
        }
        return null;
    }

    public int hitCount() {
        return this.f53418a.hitCount();
    }

    public int maxSize() {
        return this.f53418a.maxSize();
    }

    public int missCount() {
        return this.f53418a.missCount();
    }

    public int putCount() {
        return this.f53418a.putCount();
    }

    public void set(@NonNull String str, @NonNull Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int j11 = Utils.j(bitmap);
        if (j11 > maxSize()) {
            this.f53418a.remove(str);
        } else {
            this.f53418a.put(str, new BitmapAndSize(bitmap, j11));
        }
    }

    public int size() {
        return this.f53418a.size();
    }

    public LruCache(int i11) {
        this.f53418a = new android.util.LruCache<String, BitmapAndSize>(i11) {
            /* renamed from: a */
            public int sizeOf(String str, BitmapAndSize bitmapAndSize) {
                return bitmapAndSize.f53421b;
            }
        };
    }
}
