package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KProperty0Impl$delegateValue$1 extends Lambda implements Function0<Object> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KProperty0Impl<V> f24418g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KProperty0Impl$delegateValue$1(KProperty0Impl<? extends V> kProperty0Impl) {
        super(0);
        this.f24418g = kProperty0Impl;
    }

    @Nullable
    public final Object invoke() {
        KProperty0Impl<V> kProperty0Impl = this.f24418g;
        return kProperty0Impl.c(kProperty0Impl.b(), (Object) null, (Object) null);
    }
}
