package jp.wasabeef.glide.transformations.gpu;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import jp.co.cyberagent.android.gpuimage.filter.GPUImageSwirlFilter;

public class SwirlFilterTransformation extends GPUFilterTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.gpu.SwirlFilterTransformation.1";
    private static final int VERSION = 1;
    private final float angle;
    private final PointF center;
    private final float radius;

    public SwirlFilterTransformation() {
        this(0.5f, 1.0f, new PointF(0.5f, 0.5f));
    }

    public boolean equals(Object obj) {
        if (obj instanceof SwirlFilterTransformation) {
            SwirlFilterTransformation swirlFilterTransformation = (SwirlFilterTransformation) obj;
            float f11 = swirlFilterTransformation.radius;
            float f12 = this.radius;
            if (f11 == f12 && swirlFilterTransformation.angle == f12) {
                PointF pointF = swirlFilterTransformation.center;
                PointF pointF2 = this.center;
                if (pointF.equals(pointF2.x, pointF2.y)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return -981084566 + ((int) (this.radius * 1000.0f)) + ((int) (this.angle * 10.0f)) + this.center.hashCode();
    }

    public String toString() {
        return "SwirlFilterTransformation(radius=" + this.radius + ",angle=" + this.angle + ",center=" + this.center.toString() + ")";
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((ID + this.radius + this.angle + this.center.hashCode()).getBytes(Key.CHARSET));
    }

    public SwirlFilterTransformation(float f11, float f12, PointF pointF) {
        super(new GPUImageSwirlFilter());
        this.radius = f11;
        this.angle = f12;
        this.center = pointF;
        GPUImageSwirlFilter gPUImageSwirlFilter = (GPUImageSwirlFilter) getFilter();
        gPUImageSwirlFilter.setRadius(f11);
        gPUImageSwirlFilter.setAngle(f12);
        gPUImageSwirlFilter.setCenter(pointF);
    }
}
