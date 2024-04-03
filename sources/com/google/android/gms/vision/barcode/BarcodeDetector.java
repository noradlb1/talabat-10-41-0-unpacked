package com.google.android.gms.vision.barcode;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzf;
import com.google.android.gms.internal.vision.zzh;
import com.google.android.gms.internal.vision.zzp;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;

public final class BarcodeDetector extends Detector<Barcode> {
    private final zzh zzbk;

    public static class Builder {
        private zzf zzbl = new zzf();
        private Context zze;

        public Builder(Context context) {
            this.zze = context;
        }

        public BarcodeDetector build() {
            return new BarcodeDetector(new zzh(this.zze, this.zzbl));
        }

        public Builder setBarcodeFormats(int i11) {
            this.zzbl.zzbm = i11;
            return this;
        }
    }

    private BarcodeDetector() {
        throw new IllegalStateException("Default constructor called");
    }

    public final SparseArray<Barcode> detect(Frame frame) {
        Barcode[] barcodeArr;
        if (frame != null) {
            zzp zzc = zzp.zzc(frame);
            if (frame.getBitmap() != null) {
                barcodeArr = this.zzbk.zza(frame.getBitmap(), zzc);
                if (barcodeArr == null) {
                    throw new IllegalArgumentException("Internal barcode detector error; check logcat output.");
                }
            } else {
                barcodeArr = this.zzbk.zza(frame.getGrayscaleImageData(), zzc);
            }
            SparseArray<Barcode> sparseArray = new SparseArray<>(barcodeArr.length);
            for (Barcode barcode : barcodeArr) {
                sparseArray.append(barcode.rawValue.hashCode(), barcode);
            }
            return sparseArray;
        }
        throw new IllegalArgumentException("No frame supplied.");
    }

    public final boolean isOperational() {
        return this.zzbk.isOperational();
    }

    public final void release() {
        super.release();
        this.zzbk.zzo();
    }

    private BarcodeDetector(zzh zzh) {
        this.zzbk = zzh;
    }
}
