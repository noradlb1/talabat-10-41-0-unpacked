package com.google.android.gms.vision.face;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzp;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.internal.client.zzb;
import com.google.android.gms.vision.face.internal.client.zzf;
import com.google.android.gms.vision.zzc;
import java.nio.ByteBuffer;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

public final class FaceDetector extends Detector<Face> {
    public static final int ACCURATE_MODE = 1;
    public static final int ALL_CLASSIFICATIONS = 1;
    public static final int ALL_LANDMARKS = 1;
    public static final int CONTOUR_LANDMARKS = 2;
    public static final int FAST_MODE = 0;
    public static final int NO_CLASSIFICATIONS = 0;
    public static final int NO_LANDMARKS = 0;
    public static final int SELFIE_MODE = 2;
    private final Object lock;
    private final zzc zzcj;
    @GuardedBy("lock")
    private final zzb zzck;
    @GuardedBy("lock")
    private boolean zzcl;

    public static class Builder {
        private int landmarkType = 0;
        private int mode = 0;
        private float proportionalMinFaceSize = -1.0f;
        private boolean trackingEnabled = true;
        private boolean zzcn = false;
        private int zzco = 0;
        private final Context zze;

        public Builder(Context context) {
            this.zze = context;
        }

        public FaceDetector build() {
            zzf zzf = new zzf();
            zzf.mode = this.mode;
            zzf.landmarkType = this.landmarkType;
            zzf.zzco = this.zzco;
            zzf.zzcn = this.zzcn;
            zzf.trackingEnabled = this.trackingEnabled;
            zzf.proportionalMinFaceSize = this.proportionalMinFaceSize;
            if (FaceDetector.zza(zzf)) {
                return new FaceDetector(new zzb(this.zze, zzf));
            }
            throw new IllegalArgumentException("Invalid build options");
        }

        public Builder setClassificationType(int i11) {
            if (i11 == 0 || i11 == 1) {
                this.zzco = i11;
                return this;
            }
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Invalid classification type: ");
            sb2.append(i11);
            throw new IllegalArgumentException(sb2.toString());
        }

        public Builder setLandmarkType(int i11) {
            if (i11 == 0 || i11 == 1 || i11 == 2) {
                this.landmarkType = i11;
                return this;
            }
            StringBuilder sb2 = new StringBuilder(34);
            sb2.append("Invalid landmark type: ");
            sb2.append(i11);
            throw new IllegalArgumentException(sb2.toString());
        }

        public Builder setMinFaceSize(float f11) {
            if (f11 < 0.0f || f11 > 1.0f) {
                StringBuilder sb2 = new StringBuilder(47);
                sb2.append("Invalid proportional face size: ");
                sb2.append(f11);
                throw new IllegalArgumentException(sb2.toString());
            }
            this.proportionalMinFaceSize = f11;
            return this;
        }

        public Builder setMode(int i11) {
            if (i11 == 0 || i11 == 1 || i11 == 2) {
                this.mode = i11;
                return this;
            }
            StringBuilder sb2 = new StringBuilder(25);
            sb2.append("Invalid mode: ");
            sb2.append(i11);
            throw new IllegalArgumentException(sb2.toString());
        }

        public Builder setProminentFaceOnly(boolean z11) {
            this.zzcn = z11;
            return this;
        }

        public Builder setTrackingEnabled(boolean z11) {
            this.trackingEnabled = z11;
            return this;
        }
    }

    private FaceDetector() {
        this.zzcj = new zzc();
        this.lock = new Object();
        this.zzcl = true;
        throw new IllegalStateException("Default constructor called");
    }

    /* access modifiers changed from: private */
    public static boolean zza(zzf zzf) {
        boolean z11;
        if (zzf.mode == 2 || zzf.landmarkType != 2) {
            z11 = true;
        } else {
            Log.e("FaceDetector", "Contour is not supported for non-SELFIE mode.");
            z11 = false;
        }
        if (zzf.landmarkType != 2 || zzf.zzco != 1) {
            return z11;
        }
        Log.e("FaceDetector", "Classification is not supported with contour.");
        return false;
    }

    public final SparseArray<Face> detect(Frame frame) {
        ByteBuffer byteBuffer;
        Face[] zzb;
        if (frame != null) {
            if (frame.getBitmap() != null) {
                Bitmap bitmap = frame.getBitmap();
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i11 = width * height;
                byteBuffer = ByteBuffer.allocateDirect(((((width + 1) / 2) * ((height + 1) / 2)) << 1) + i11);
                int i12 = i11;
                for (int i13 = 0; i13 < i11; i13++) {
                    int i14 = i13 % width;
                    int i15 = i13 / width;
                    int pixel = bitmap.getPixel(i14, i15);
                    float red = (float) Color.red(pixel);
                    float green = (float) Color.green(pixel);
                    float blue = (float) Color.blue(pixel);
                    byteBuffer.put(i13, (byte) ((int) ((0.299f * red) + (0.587f * green) + (0.114f * blue))));
                    if (i15 % 2 == 0 && i14 % 2 == 0) {
                        int i16 = i12 + 1;
                        byteBuffer.put(i12, (byte) ((int) ((-0.169f * red) + (-0.331f * green) + (blue * 0.5f) + 128.0f)));
                        i12 = i16 + 1;
                        byteBuffer.put(i16, (byte) ((int) ((red * 0.5f) + (green * -0.419f) + (blue * -0.081f) + 128.0f)));
                    }
                }
            } else {
                byteBuffer = frame.getGrayscaleImageData();
            }
            synchronized (this.lock) {
                if (this.zzcl) {
                    zzb = this.zzck.zzb(byteBuffer, zzp.zzc(frame));
                } else {
                    throw new RuntimeException("Cannot use detector after release()");
                }
            }
            HashSet hashSet = new HashSet();
            SparseArray<Face> sparseArray = new SparseArray<>(zzb.length);
            int i17 = 0;
            for (Face face : zzb) {
                int id2 = face.getId();
                i17 = Math.max(i17, id2);
                if (hashSet.contains(Integer.valueOf(id2))) {
                    id2 = i17 + 1;
                    i17 = id2;
                }
                hashSet.add(Integer.valueOf(id2));
                sparseArray.append(this.zzcj.zzb(id2), face);
            }
            return sparseArray;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    public final void finalize() throws Throwable {
        try {
            synchronized (this.lock) {
                if (this.zzcl) {
                    Log.w("FaceDetector", "FaceDetector was not released with FaceDetector.release()");
                    release();
                }
            }
            super.finalize();
        } catch (Throwable th2) {
            super.finalize();
            throw th2;
        }
    }

    public final boolean isOperational() {
        return this.zzck.isOperational();
    }

    public final void release() {
        super.release();
        synchronized (this.lock) {
            if (this.zzcl) {
                this.zzck.zzo();
                this.zzcl = false;
            }
        }
    }

    public final boolean setFocus(int i11) {
        boolean zzd;
        int zzc = this.zzcj.zzc(i11);
        synchronized (this.lock) {
            if (this.zzcl) {
                zzd = this.zzck.zzd(zzc);
            } else {
                throw new RuntimeException("Cannot use detector after release()");
            }
        }
        return zzd;
    }

    private FaceDetector(zzb zzb) {
        this.zzcj = new zzc();
        this.lock = new Object();
        this.zzcl = true;
        this.zzck = zzb;
    }
}
