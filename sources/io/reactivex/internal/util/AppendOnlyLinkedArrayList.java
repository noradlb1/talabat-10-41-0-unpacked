package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Predicate;
import org.reactivestreams.Subscriber;

public class AppendOnlyLinkedArrayList<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f18621a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f18622b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f18623c;

    /* renamed from: d  reason: collision with root package name */
    public int f18624d;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
        boolean test(T t11);
    }

    public AppendOnlyLinkedArrayList(int i11) {
        this.f18621a = i11;
        Object[] objArr = new Object[(i11 + 1)];
        this.f18622b = objArr;
        this.f18623c = objArr;
    }

    public <U> boolean accept(Subscriber<? super U> subscriber) {
        Object[] objArr = this.f18622b;
        int i11 = this.f18621a;
        while (true) {
            int i12 = 0;
            if (objArr == null) {
                return false;
            }
            while (i12 < i11) {
                Object[] objArr2 = objArr[i12];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (NotificationLite.acceptFull((Object) objArr2, subscriber)) {
                    return true;
                } else {
                    i12++;
                }
            }
            objArr = objArr[i11];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void add(T r4) {
        /*
            r3 = this;
            int r0 = r3.f18621a
            int r1 = r3.f18624d
            if (r1 != r0) goto L_0x0011
            int r1 = r0 + 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object[] r2 = r3.f18623c
            r2[r0] = r1
            r3.f18623c = r1
            r1 = 0
        L_0x0011:
            java.lang.Object[] r0 = r3.f18623c
            r0[r1] = r4
            int r1 = r1 + 1
            r3.f18624d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.AppendOnlyLinkedArrayList.add(java.lang.Object):void");
    }

    public void forEachWhile(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i11 = this.f18621a;
        for (Object[] objArr = this.f18622b; objArr != null; objArr = objArr[i11]) {
            int i12 = 0;
            while (i12 < i11) {
                Object[] objArr2 = objArr[i12];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (!nonThrowingPredicate.test(objArr2)) {
                    i12++;
                } else {
                    return;
                }
            }
        }
    }

    public void setFirst(T t11) {
        this.f18622b[0] = t11;
    }

    public <U> boolean accept(Observer<? super U> observer) {
        Object[] objArr = this.f18622b;
        int i11 = this.f18621a;
        while (true) {
            int i12 = 0;
            if (objArr == null) {
                return false;
            }
            while (i12 < i11) {
                Object[] objArr2 = objArr[i12];
                if (objArr2 == null) {
                    continue;
                    break;
                } else if (NotificationLite.acceptFull((Object) objArr2, observer)) {
                    return true;
                } else {
                    i12++;
                }
            }
            objArr = objArr[i11];
        }
    }

    public <S> void forEachWhile(S s11, BiPredicate<? super S, ? super T> biPredicate) throws Exception {
        Object[] objArr = this.f18622b;
        int i11 = this.f18621a;
        while (true) {
            int i12 = 0;
            while (i12 < i11) {
                Object[] objArr2 = objArr[i12];
                if (objArr2 != null && !biPredicate.test(s11, objArr2)) {
                    i12++;
                } else {
                    return;
                }
            }
            objArr = objArr[i11];
        }
    }
}
