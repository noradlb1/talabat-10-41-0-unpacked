package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;

@KeepForSdk
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
    private boolean zaa = false;
    private ArrayList zab;

    @KeepForSdk
    public EntityBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
    }

    private final void zab() {
        synchronized (this) {
            if (!this.zaa) {
                int count = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                ArrayList arrayList = new ArrayList();
                this.zab = arrayList;
                if (count > 0) {
                    arrayList.add(0);
                    String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                    String string = this.mDataHolder.getString(primaryDataMarkerColumn, 0, this.mDataHolder.getWindowIndex(0));
                    int i11 = 1;
                    while (i11 < count) {
                        int windowIndex = this.mDataHolder.getWindowIndex(i11);
                        String string2 = this.mDataHolder.getString(primaryDataMarkerColumn, i11, windowIndex);
                        if (string2 != null) {
                            if (!string2.equals(string)) {
                                this.zab.add(Integer.valueOf(i11));
                                string = string2;
                            }
                            i11++;
                        } else {
                            throw new NullPointerException("Missing value for markerColumn: " + primaryDataMarkerColumn + ", at row: " + i11 + ", for window: " + windowIndex);
                        }
                    }
                }
                this.zaa = true;
            }
        }
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public final T get(int i11) {
        int i12;
        int i13;
        zab();
        int zaa2 = zaa(i11);
        int i14 = 0;
        if (i11 >= 0 && i11 != this.zab.size()) {
            if (i11 == this.zab.size() - 1) {
                i13 = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                i12 = ((Integer) this.zab.get(i11)).intValue();
            } else {
                i13 = ((Integer) this.zab.get(i11 + 1)).intValue();
                i12 = ((Integer) this.zab.get(i11)).intValue();
            }
            int i15 = i13 - i12;
            if (i15 == 1) {
                int zaa3 = zaa(i11);
                int windowIndex = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getWindowIndex(zaa3);
                String childDataMarkerColumn = getChildDataMarkerColumn();
                if (childDataMarkerColumn == null || this.mDataHolder.getString(childDataMarkerColumn, zaa3, windowIndex) != null) {
                    i14 = 1;
                }
            } else {
                i14 = i15;
            }
        }
        return getEntry(zaa2, i14);
    }

    @KeepForSdk
    @Nullable
    public String getChildDataMarkerColumn() {
        return null;
    }

    @KeepForSdk
    public int getCount() {
        zab();
        return this.zab.size();
    }

    @NonNull
    @KeepForSdk
    public abstract T getEntry(int i11, int i12);

    @NonNull
    @KeepForSdk
    public abstract String getPrimaryDataMarkerColumn();

    public final int zaa(int i11) {
        if (i11 >= 0 && i11 < this.zab.size()) {
            return ((Integer) this.zab.get(i11)).intValue();
        }
        throw new IllegalArgumentException("Position " + i11 + " is out of bounds for this buffer");
    }
}
