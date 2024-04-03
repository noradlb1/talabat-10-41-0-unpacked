package j$.util.concurrent;

import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Consumer;
import j$.util.function.Function;

public final /* synthetic */ class S implements BiConsumer, BiFunction, Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f28672a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f28673b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f28674c;

    public /* synthetic */ S(int i11, Object obj, Object obj2) {
        this.f28672a = i11;
        this.f28673b = obj;
        this.f28674c = obj2;
    }

    public /* synthetic */ S(BiFunction biFunction, Function function) {
        this.f28672a = 2;
        this.f28674c = biFunction;
        this.f28673b = function;
    }

    public final void accept(Object obj) {
        ((Consumer) this.f28673b).accept(obj);
        ((Consumer) this.f28674c).accept(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000e A[LOOP:0: B:3:0x000e->B:6:0x001c, LOOP_START, PHI: r5 
      PHI: (r5v1 java.lang.Object) = (r5v0 java.lang.Object), (r5v3 java.lang.Object) binds: [B:2:0x000a, B:6:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void accept(java.lang.Object r4, java.lang.Object r5) {
        /*
            r3 = this;
            int r0 = r3.f28672a
            java.lang.Object r1 = r3.f28674c
            java.lang.Object r2 = r3.f28673b
            switch(r0) {
                case 0: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x001f
        L_0x000a:
            java.util.concurrent.ConcurrentMap r2 = (java.util.concurrent.ConcurrentMap) r2
            j$.util.function.BiFunction r1 = (j$.util.function.BiFunction) r1
        L_0x000e:
            java.lang.Object r0 = r1.apply(r4, r5)
            boolean r5 = r2.replace(r4, r5, r0)
            if (r5 != 0) goto L_0x001e
            java.lang.Object r5 = r2.get(r4)
            if (r5 != 0) goto L_0x000e
        L_0x001e:
            return
        L_0x001f:
            j$.util.function.BiConsumer r2 = (j$.util.function.BiConsumer) r2
            j$.util.function.BiConsumer r1 = (j$.util.function.BiConsumer) r1
            r2.accept(r4, r5)
            r1.accept(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.S.accept(java.lang.Object, java.lang.Object):void");
    }

    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        switch (this.f28672a) {
            case 0:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
            default:
                return BiConsumer.CC.$default$andThen(this, biConsumer);
        }
    }

    public final /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.$default$andThen(this, function);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public final Object apply(Object obj, Object obj2) {
        return ((Function) this.f28673b).apply(((BiFunction) this.f28674c).apply(obj, obj2));
    }
}
