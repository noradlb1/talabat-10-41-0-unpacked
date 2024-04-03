package com.instabug.library.screenshot;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import android.media.ImageReader;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.instabug.library.core.eventbus.ScreenCaptureEventBus;
import com.instabug.library.model.i;
import com.instabug.library.util.InstabugSDKLogger;
import java.nio.ByteBuffer;

@RequiresApi(21)
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private int f51732a;

    /* renamed from: b  reason: collision with root package name */
    private int f51733b;

    /* renamed from: c  reason: collision with root package name */
    private ImageReader f51734c;

    public a(@IntRange(from = 1) int i11, @IntRange(from = 1) int i12, @NonNull ImageReader imageReader) {
        this.f51732a = i11;
        this.f51733b = i12;
        this.f51734c = imageReader;
    }

    public void run() {
        ImageReader imageReader;
        if (this.f51732a != 0 && this.f51733b != 0 && (imageReader = this.f51734c) != null) {
            Bitmap bitmap = null;
            try {
                Image acquireLatestImage = imageReader.acquireLatestImage();
                Image.Plane[] planes = acquireLatestImage.getPlanes();
                ByteBuffer buffer = planes[0].getBuffer();
                int pixelStride = planes[0].getPixelStride();
                int rowStride = planes[0].getRowStride();
                int i11 = this.f51732a;
                Bitmap createBitmap = Bitmap.createBitmap(i11 + ((rowStride - (pixelStride * i11)) / pixelStride), this.f51733b, Bitmap.Config.ARGB_8888);
                createBitmap.copyPixelsFromBuffer(buffer);
                Rect cropRect = acquireLatestImage.getCropRect();
                Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, cropRect.left, cropRect.top, cropRect.width(), cropRect.height());
                if (createBitmap2 != null) {
                    ScreenCaptureEventBus.getInstance().post(new i(0, createBitmap2));
                } else {
                    ScreenCaptureEventBus.getInstance().post(new i(1, (Throwable) new Exception("Failed to capture screenshot using media projection ")));
                }
            } catch (Exception e11) {
                if (bitmap != null) {
                    bitmap.recycle();
                }
                InstabugSDKLogger.e("IBG-Core", "Error occurred while processing the taken screenshot ", e11);
            } finally {
                this.f51734c.close();
            }
        }
    }
}
