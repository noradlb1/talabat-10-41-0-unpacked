package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KPackageImpl$Data$kotlinClass$2 extends Lambda implements Function0<ReflectKotlinClass> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KPackageImpl f24406g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KPackageImpl$Data$kotlinClass$2(KPackageImpl kPackageImpl) {
        super(0);
        this.f24406g = kPackageImpl;
    }

    @Nullable
    public final ReflectKotlinClass invoke() {
        return ReflectKotlinClass.Factory.create(this.f24406g.getJClass());
    }
}
