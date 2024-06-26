package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SharedValues {
    public static final int UNSET = -1;
    private SparseIntArray mValues = new SparseIntArray();
    private HashMap<Integer, HashSet<WeakReference<SharedValuesListener>>> mValuesListeners = new HashMap<>();

    public interface SharedValuesListener {
        void onNewValue(int i11, int i12, int i13);
    }

    public void addListener(int i11, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = this.mValuesListeners.get(Integer.valueOf(i11));
        if (hashSet == null) {
            hashSet = new HashSet();
            this.mValuesListeners.put(Integer.valueOf(i11), hashSet);
        }
        hashSet.add(new WeakReference(sharedValuesListener));
    }

    public void clearListeners() {
        this.mValuesListeners.clear();
    }

    public void fireNewValue(int i11, int i12) {
        int i13 = this.mValues.get(i11, -1);
        if (i13 != i12) {
            this.mValues.put(i11, i12);
            HashSet hashSet = this.mValuesListeners.get(Integer.valueOf(i11));
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                boolean z11 = false;
                while (it.hasNext()) {
                    SharedValuesListener sharedValuesListener = (SharedValuesListener) ((WeakReference) it.next()).get();
                    if (sharedValuesListener != null) {
                        sharedValuesListener.onNewValue(i11, i12, i13);
                    } else {
                        z11 = true;
                    }
                }
                if (z11) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        WeakReference weakReference = (WeakReference) it2.next();
                        if (((SharedValuesListener) weakReference.get()) == null) {
                            arrayList.add(weakReference);
                        }
                    }
                    hashSet.removeAll(arrayList);
                }
            }
        }
    }

    public int getValue(int i11) {
        return this.mValues.get(i11, -1);
    }

    public void removeListener(int i11, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = this.mValuesListeners.get(Integer.valueOf(i11));
        if (hashSet != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                SharedValuesListener sharedValuesListener2 = (SharedValuesListener) weakReference.get();
                if (sharedValuesListener2 == null || sharedValuesListener2 == sharedValuesListener) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
    }

    public void removeListener(SharedValuesListener sharedValuesListener) {
        for (Integer intValue : this.mValuesListeners.keySet()) {
            removeListener(intValue.intValue(), sharedValuesListener);
        }
    }
}
