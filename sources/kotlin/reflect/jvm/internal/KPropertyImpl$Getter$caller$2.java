package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.calls.Caller;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KPropertyImpl$Getter$caller$2 extends Lambda implements Function0<Caller<?>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KPropertyImpl.Getter<V> f24425g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KPropertyImpl$Getter$caller$2(KPropertyImpl.Getter<? extends V> getter) {
        super(0);
        this.f24425g = getter;
    }

    public final Caller<?> invoke() {
        return KPropertyImplKt.computeCallerForAccessor(this.f24425g, true);
    }
}
