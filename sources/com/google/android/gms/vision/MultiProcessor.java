package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import java.util.HashSet;

public class MultiProcessor<T> implements Detector.Processor<T> {
    /* access modifiers changed from: private */
    public int zzak;
    /* access modifiers changed from: private */
    public Factory<T> zzax;
    private SparseArray<zza> zzay;

    public static class Builder<T> {
        private MultiProcessor<T> zzba;

        public Builder(Factory<T> factory) {
            MultiProcessor<T> multiProcessor = new MultiProcessor<>();
            this.zzba = multiProcessor;
            if (factory != null) {
                Factory unused = multiProcessor.zzax = factory;
                return;
            }
            throw new IllegalArgumentException("No factory supplied.");
        }

        public MultiProcessor<T> build() {
            return this.zzba;
        }

        public Builder<T> setMaxGapFrames(int i11) {
            if (i11 >= 0) {
                int unused = this.zzba.zzak = i11;
                return this;
            }
            StringBuilder sb2 = new StringBuilder(28);
            sb2.append("Invalid max gap: ");
            sb2.append(i11);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public interface Factory<T> {
        Tracker<T> create(T t11);
    }

    public class zza {
        /* access modifiers changed from: private */
        public Tracker<T> zzaj;
        /* access modifiers changed from: private */
        public int zzan;

        private zza(MultiProcessor multiProcessor) {
            this.zzan = 0;
        }

        public static /* synthetic */ int zzb(zza zza) {
            int i11 = zza.zzan;
            zza.zzan = i11 + 1;
            return i11;
        }
    }

    private MultiProcessor() {
        this.zzay = new SparseArray<>();
        this.zzak = 3;
    }

    public void receiveDetections(Detector.Detections<T> detections) {
        SparseArray<T> detectedItems = detections.getDetectedItems();
        for (int i11 = 0; i11 < detectedItems.size(); i11++) {
            int keyAt = detectedItems.keyAt(i11);
            T valueAt = detectedItems.valueAt(i11);
            if (this.zzay.get(keyAt) == null) {
                zza zza2 = new zza();
                Tracker unused = zza2.zzaj = this.zzax.create(valueAt);
                zza2.zzaj.onNewItem(keyAt, valueAt);
                this.zzay.append(keyAt, zza2);
            }
        }
        SparseArray<T> detectedItems2 = detections.getDetectedItems();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i12 = 0; i12 < this.zzay.size(); i12++) {
            int keyAt2 = this.zzay.keyAt(i12);
            if (detectedItems2.get(keyAt2) == null) {
                zza valueAt2 = this.zzay.valueAt(i12);
                zza.zzb(valueAt2);
                if (valueAt2.zzan >= this.zzak) {
                    valueAt2.zzaj.onDone();
                    hashSet.add(Integer.valueOf(keyAt2));
                } else {
                    valueAt2.zzaj.onMissing(detections);
                }
            }
        }
        for (Integer intValue : hashSet) {
            this.zzay.delete(intValue.intValue());
        }
        SparseArray<T> detectedItems3 = detections.getDetectedItems();
        for (int i13 = 0; i13 < detectedItems3.size(); i13++) {
            int keyAt3 = detectedItems3.keyAt(i13);
            T valueAt3 = detectedItems3.valueAt(i13);
            zza zza3 = this.zzay.get(keyAt3);
            int unused2 = zza3.zzan = 0;
            zza3.zzaj.onUpdate(detections, valueAt3);
        }
    }

    public void release() {
        for (int i11 = 0; i11 < this.zzay.size(); i11++) {
            this.zzay.valueAt(i11).zzaj.onDone();
        }
        this.zzay.clear();
    }
}
