package com.google.android.gms.common.data;

import androidx.annotation.NonNull;

public interface DataBufferObserver {

    public interface Observable {
        void addObserver(@NonNull DataBufferObserver dataBufferObserver);

        void removeObserver(@NonNull DataBufferObserver dataBufferObserver);
    }

    void onDataChanged();

    void onDataRangeChanged(int i11, int i12);

    void onDataRangeInserted(int i11, int i12);

    void onDataRangeMoved(int i11, int i12, int i13);

    void onDataRangeRemoved(int i11, int i12);
}
