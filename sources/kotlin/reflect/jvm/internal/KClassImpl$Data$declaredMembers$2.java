package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KClassImpl$Data$declaredMembers$2 extends Lambda implements Function0<List<? extends KCallableImpl<?>>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KClassImpl<T>.Data f24372g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$declaredMembers$2(KClassImpl<T>.Data data) {
        super(0);
        this.f24372g = data;
    }

    public final List<KCallableImpl<?>> invoke() {
        return CollectionsKt___CollectionsKt.plus(this.f24372g.getDeclaredNonStaticMembers(), this.f24372g.getDeclaredStaticMembers());
    }
}
