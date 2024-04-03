package j$.util.stream;

import j$.util.Map;
import j$.util.StringJoiner;
import j$.util.function.BiConsumer;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.util.Objects;
import java.util.Set;

/* renamed from: j$.util.stream.m  reason: case insensitive filesystem */
public final /* synthetic */ class C0254m implements Supplier, BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f29179a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f29180b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f29181c;

    public /* synthetic */ C0254m(Object obj, Object obj2, Object obj3) {
        this.f29179a = obj;
        this.f29180b = obj2;
        this.f29181c = obj3;
    }

    public final void accept(Object obj, Object obj2) {
        Set set = Collectors.f28907a;
        Object apply = ((Function) this.f29179a).apply(obj2);
        Objects.requireNonNull(apply, "element cannot be mapped to a null key");
        ((BiConsumer) this.f29181c).accept(Map.EL.computeIfAbsent((java.util.Map) obj, apply, new C0194a(2, (Supplier) this.f29180b)), obj2);
    }

    public final /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
        return BiConsumer.CC.$default$andThen(this, biConsumer);
    }

    public final Object get() {
        Set set = Collectors.f28907a;
        return new StringJoiner((CharSequence) this.f29179a, (CharSequence) this.f29180b, (CharSequence) this.f29181c);
    }
}
