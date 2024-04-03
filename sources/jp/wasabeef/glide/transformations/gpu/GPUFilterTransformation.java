package jp.wasabeef.glide.transformations.gpu;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilter;
import jp.wasabeef.glide.transformations.BitmapTransformation;

public class GPUFilterTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.GPUFilterTransformation.1";
    private static final byte[] ID_BYTES = ID.getBytes(Key.CHARSET);
    private static final int VERSION = 1;
    private final GPUImageFilter gpuImageFilter;

    public GPUFilterTransformation(GPUImageFilter gPUImageFilter) {
        this.gpuImageFilter = gPUImageFilter;
    }

    public Bitmap b(@NonNull Context context, @NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i11, int i12) {
        GPUImage gPUImage = new GPUImage(context);
        gPUImage.setImage(bitmap);
        gPUImage.setFilter(this.gpuImageFilter);
        return gPUImage.getBitmapWithFilterApplied();
    }

    public boolean equals(Object obj) {
        return obj instanceof GPUFilterTransformation;
    }

    public <T> T getFilter() {
        return this.gpuImageFilter;
    }

    public int hashCode() {
        return 1751294359;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
    }
}
