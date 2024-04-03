package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Asserts;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Instrumented
final class zaa implements Runnable {
    final /* synthetic */ ImageManager zaa;
    private final Uri zab;
    @Nullable
    private final ParcelFileDescriptor zac;

    public zaa(ImageManager imageManager, @Nullable Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.zaa = imageManager;
        this.zab = uri;
        this.zac = parcelFileDescriptor;
    }

    public final void run() {
        Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.zac;
        boolean z11 = false;
        Bitmap bitmap = null;
        if (parcelFileDescriptor != null) {
            try {
                bitmap = BitmapFactoryInstrumentation.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError e11) {
                Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(this.zab)), e11);
                z11 = true;
            }
            try {
                this.zac.close();
            } catch (IOException e12) {
                Log.e("ImageManager", "closed failed", e12);
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.zaa;
        imageManager.zae.post(new zac(imageManager, this.zab, bitmap, z11, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(this.zab)));
        }
    }
}
