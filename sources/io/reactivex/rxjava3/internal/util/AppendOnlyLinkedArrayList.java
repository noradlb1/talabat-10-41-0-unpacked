package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Predicate;
import org.reactivestreams.Subscriber;

public class AppendOnlyLinkedArrayList<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f23182a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f23183b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f23184c;

    /* renamed from: d  reason: collision with root package name */
    public int f23185d;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
        boolean test(T t11);
    }

    public AppendOnlyLinkedArrayList(int i11) {
        this.f23182a = i11;
        Object[] objArr = new Object[(i11 + 1)];
        this.f23183b = objArr;
        this.f23184c = objArr;
    }

    public <U> boolean accept(Subscriber<? super U> subscriber) {
        Object[] objArr = this.f23183b;
        int i11 = this.f23182a;
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
            int r0 = r3.f23182a
            int r1 = r3.f23185d
            if (r1 != r0) goto L_0x0011
            int r1 = r0 + 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object[] r2 = r3.f23184c
            r2[r0] = r1
            r3.f23184c = r1
            r1 = 0
        L_0x0011:
            java.lang.Object[] r0 = r3.f23184c
            r0[r1] = r4
            int r1 = r1 + 1
            r3.f23185d = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList.add(java.lang.Object):void");
    }

    public void forEachWhile(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i11 = this.f23182a;
        for (Object[] objArr = this.f23183b; objArr != null; objArr = objArr[i11]) {
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
        this.f23183b[0] = t11;
    }

    public <U> boolean accept(Observer<? super U> observer) {
        Object[] objArr = this.f23183b;
        int i11 = this.f23182a;
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

    public <S> void forEachWhile(S s11, BiPredicate<? super S, ? super T> biPredicate) throws Throwable {
        Object[] objArr = this.f23183b;
        int i11 = this.f23182a;
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
