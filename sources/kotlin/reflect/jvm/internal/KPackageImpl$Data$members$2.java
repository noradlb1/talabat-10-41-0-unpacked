package kotlin.reflect.jvm.internal;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002 \u0003*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KPackageImpl$Data$members$2 extends Lambda implements Function0<Collection<? extends KCallableImpl<?>>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KPackageImpl f24407g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ KPackageImpl.Data f24408h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KPackageImpl$Data$members$2(KPackageImpl kPackageImpl, KPackageImpl.Data data) {
        super(0);
        this.f24407g = kPackageImpl;
        this.f24408h = data;
    }

    public final Collection<KCallableImpl<?>> invoke() {
        return this.f24407g.a(this.f24408h.getScope(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
    }
}
