package i9;

import java.util.concurrent.atomic.AtomicReferenceArray;

public final /* synthetic */ class o {
    public static /* synthetic */ boolean a(AtomicReferenceArray atomicReferenceArray, int i11, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i11, obj, obj2)) {
            if (atomicReferenceArray.get(i11) != obj) {
                return false;
            }
        }
        return true;
    }
}
