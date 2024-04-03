package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin.jvm.PlatformType", "V", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KPropertyImpl$_descriptor$1 extends Lambda implements Function0<PropertyDescriptor> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KPropertyImpl<V> f24430g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KPropertyImpl$_descriptor$1(KPropertyImpl<? extends V> kPropertyImpl) {
        super(0);
        this.f24430g = kPropertyImpl;
    }

    public final PropertyDescriptor invoke() {
        return this.f24430g.getContainer().findPropertyDescriptor(this.f24430g.getName(), this.f24430g.getSignature());
    }
}
