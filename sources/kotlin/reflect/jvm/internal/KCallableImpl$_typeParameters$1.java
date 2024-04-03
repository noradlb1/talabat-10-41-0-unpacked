package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KCallableImpl$_typeParameters$1 extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KCallableImpl<R> f24364g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KCallableImpl$_typeParameters$1(KCallableImpl<? extends R> kCallableImpl) {
        super(0);
        this.f24364g = kCallableImpl;
    }

    public final List<KTypeParameterImpl> invoke() {
        List<TypeParameterDescriptor> typeParameters = this.f24364g.getDescriptor().getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "descriptor.typeParameters");
        Iterable<TypeParameterDescriptor> iterable = typeParameters;
        KCallableImpl<R> kCallableImpl = this.f24364g;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : iterable) {
            Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "descriptor");
            arrayList.add(new KTypeParameterImpl(kCallableImpl, typeParameterDescriptor));
        }
        return arrayList;
    }
}
