package com.google.android.gms.vision.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzac;
import com.google.android.gms.internal.vision.zzae;
import com.google.android.gms.internal.vision.zzah;
import com.google.android.gms.internal.vision.zzai;
import com.google.android.gms.internal.vision.zzp;
import com.google.android.gms.internal.vision.zzq;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

@Instrumented
public final class TextRecognizer extends Detector<TextBlock> {
    private final zzai zzee;

    public static class Builder {
        private Context zze;
        private zzah zzef = new zzah();

        public Builder(Context context) {
            this.zze = context;
        }

        public TextRecognizer build() {
            return new TextRecognizer(new zzai(this.zze, this.zzef));
        }
    }

    private TextRecognizer() {
        throw new IllegalStateException("Default constructor called");
    }

    public final SparseArray<TextBlock> detect(Frame frame) {
        Bitmap bitmap;
        byte[] bArr;
        zzae zzae = new zzae(new Rect());
        if (frame != null) {
            zzp zzc = zzp.zzc(frame);
            if (frame.getBitmap() != null) {
                bitmap = frame.getBitmap();
            } else {
                Frame.Metadata metadata = frame.getMetadata();
                ByteBuffer grayscaleImageData = frame.getGrayscaleImageData();
                int format = metadata.getFormat();
                int i11 = zzc.width;
                int i12 = zzc.height;
                if (!grayscaleImageData.hasArray() || grayscaleImageData.arrayOffset() != 0) {
                    byte[] bArr2 = new byte[grayscaleImageData.capacity()];
                    grayscaleImageData.get(bArr2);
                    bArr = bArr2;
                } else {
                    bArr = grayscaleImageData.array();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new YuvImage(bArr, format, i11, i12, (int[]) null).compressToJpeg(new Rect(0, 0, i11, i12), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bitmap = BitmapFactoryInstrumentation.decodeByteArray(byteArray, 0, byteArray.length);
            }
            Bitmap zzb = zzq.zzb(bitmap, zzc);
            if (!zzae.zzeq.isEmpty()) {
                Rect rect = zzae.zzeq;
                int width = frame.getMetadata().getWidth();
                int height = frame.getMetadata().getHeight();
                int i13 = zzc.rotation;
                if (i13 == 1) {
                    rect = new Rect(height - rect.bottom, rect.left, height - rect.top, rect.right);
                } else if (i13 == 2) {
                    rect = new Rect(width - rect.right, height - rect.bottom, width - rect.left, height - rect.top);
                } else if (i13 == 3) {
                    rect = new Rect(rect.top, width - rect.right, rect.bottom, width - rect.left);
                }
                zzae.zzeq.set(rect);
            }
            zzc.rotation = 0;
            zzac[] zza = this.zzee.zza(zzb, zzc, zzae);
            SparseArray sparseArray = new SparseArray();
            for (zzac zzac : zza) {
                SparseArray sparseArray2 = (SparseArray) sparseArray.get(zzac.zzeo);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    sparseArray.append(zzac.zzeo, sparseArray2);
                }
                sparseArray2.append(zzac.zzep, zzac);
            }
            SparseArray<TextBlock> sparseArray3 = new SparseArray<>(sparseArray.size());
            for (int i14 = 0; i14 < sparseArray.size(); i14++) {
                sparseArray3.append(sparseArray.keyAt(i14), new TextBlock((SparseArray) sparseArray.valueAt(i14)));
            }
            return sparseArray3;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    public final boolean isOperational() {
        return this.zzee.isOperational();
    }

    public final void release() {
        super.release();
        this.zzee.zzo();
    }

    private TextRecognizer(zzai zzai) {
        this.zzee = zzai;
    }
}
