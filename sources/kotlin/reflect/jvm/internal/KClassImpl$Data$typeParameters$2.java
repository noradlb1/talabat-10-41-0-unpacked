package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KClassImpl$Data$typeParameters$2 extends Lambda implements Function0<List<? extends KTypeParameterImpl>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KClassImpl<T>.Data f24390g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ KClassImpl<T> f24391h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$typeParameters$2(KClassImpl<T>.Data data, KClassImpl<T> kClassImpl) {
        super(0);
        this.f24390g = data;
        this.f24391h = kClassImpl;
    }

    public final List<KTypeParameterImpl> invoke() {
        List<TypeParameterDescriptor> declaredTypeParameters = this.f24390g.getDescriptor().getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "descriptor.declaredTypeParameters");
        Iterable<TypeParameterDescriptor> iterable = declaredTypeParameters;
        KClassImpl<T> kClassImpl = this.f24391h;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : iterable) {
            Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "descriptor");
            arrayList.add(new KTypeParameterImpl(kClassImpl, typeParameterDescriptor));
        }
        return arrayList;
    }
}
