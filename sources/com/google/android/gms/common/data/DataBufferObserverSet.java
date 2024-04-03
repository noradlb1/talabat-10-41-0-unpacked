package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.data.DataBufferObserver;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {
    private final HashSet zaa = new HashSet();

    public void addObserver(@NonNull DataBufferObserver dataBufferObserver) {
        this.zaa.add(dataBufferObserver);
    }

    public void clear() {
        this.zaa.clear();
    }

    public boolean hasObservers() {
        return !this.zaa.isEmpty();
    }

    public void onDataChanged() {
        Iterator it = this.zaa.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataChanged();
        }
    }

    public void onDataRangeChanged(int i11, int i12) {
        Iterator it = this.zaa.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeChanged(i11, i12);
        }
    }

    public void onDataRangeInserted(int i11, int i12) {
        Iterator it = this.zaa.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeInserted(i11, i12);
        }
    }

    public void onDataRangeMoved(int i11, int i12, int i13) {
        Iterator it = this.zaa.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeMoved(i11, i12, i13);
        }
    }

    public void onDataRangeRemoved(int i11, int i12) {
        Iterator it = this.zaa.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeRemoved(i11, i12);
        }
    }

    public void removeObserver(@NonNull DataBufferObserver dataBufferObserver) {
        this.zaa.remove(dataBufferObserver);
    }
}
