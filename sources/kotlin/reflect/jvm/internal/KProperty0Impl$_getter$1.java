package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KProperty0Impl;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "V", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KProperty0Impl$_getter$1 extends Lambda implements Function0<KProperty0Impl.Getter<? extends V>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KProperty0Impl<V> f24417g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KProperty0Impl$_getter$1(KProperty0Impl<? extends V> kProperty0Impl) {
        super(0);
        this.f24417g = kProperty0Impl;
    }

    public final KProperty0Impl.Getter<V> invoke() {
        return new KProperty0Impl.Getter<>(this.f24417g);
    }
}
