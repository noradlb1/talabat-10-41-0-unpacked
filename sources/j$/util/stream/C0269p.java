package j$.util.stream;

import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.BiConsumer;
import j$.util.function.C0164l0;
import j$.util.function.C0174s;
import j$.util.function.Consumer;
import j$.util.function.IntPredicate;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: j$.util.stream.p  reason: case insensitive filesystem */
public final /* synthetic */ class C0269p implements Consumer, Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f29191a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f29192b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f29193c;

    public /* synthetic */ C0269p(int i11, Object obj, Object obj2) {
        this.f29191a = i11;
        this.f29192b = obj;
        this.f29193c = obj2;
    }

    public final void accept(Object obj) {
        int i11 = this.f29191a;
        Object obj2 = this.f29193c;
        Object obj3 = this.f29192b;
        switch (i11) {
            case 0:
                AtomicBoolean atomicBoolean = (AtomicBoolean) obj3;
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) obj2;
                if (obj == null) {
                    atomicBoolean.set(true);
                    return;
                } else {
                    concurrentHashMap.putIfAbsent(obj, Boolean.TRUE);
                    return;
                }
            case 5:
                ((BiConsumer) obj3).accept(obj2, obj);
                return;
            default:
                ((C0282r3) obj3).i((Consumer) obj2, obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f29191a) {
            case 0:
                return Consumer.CC.$default$andThen(this, consumer);
            case 5:
                return Consumer.CC.$default$andThen(this, consumer);
            default:
                return Consumer.CC.$default$andThen(this, consumer);
        }
    }

    public final Object get() {
        int i11 = this.f29191a;
        Object obj = this.f29193c;
        Object obj2 = this.f29192b;
        switch (i11) {
            case 1:
                return new C0279r0((IntPredicate) obj, (C0299v0) obj2);
            case 2:
                return new C0275q0((Predicate) obj, (C0299v0) obj2);
            case 3:
                return new C0289t0((C0174s) obj, (C0299v0) obj2);
            default:
                return new C0284s0((C0164l0) obj, (C0299v0) obj2);
        }
    }
}
