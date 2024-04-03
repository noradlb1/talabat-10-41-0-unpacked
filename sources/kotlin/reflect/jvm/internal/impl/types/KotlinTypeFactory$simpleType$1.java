package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinTypeFactory$simpleType$1 extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TypeConstructor f24945g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<TypeProjection> f24946h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TypeAttributes f24947i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f24948j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinTypeFactory$simpleType$1(TypeConstructor typeConstructor, List<? extends TypeProjection> list, TypeAttributes typeAttributes, boolean z11) {
        super(1);
        this.f24945g = typeConstructor;
        this.f24946h = list;
        this.f24947i = typeAttributes;
        this.f24948j = z11;
    }

    @Nullable
    public final SimpleType invoke(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "refiner");
        KotlinTypeFactory.ExpandedTypeOrRefinedConstructor access$refineConstructor = KotlinTypeFactory.INSTANCE.refineConstructor(this.f24945g, kotlinTypeRefiner, this.f24946h);
        if (access$refineConstructor == null) {
            return null;
        }
        SimpleType expandedType = access$refineConstructor.getExpandedType();
        if (expandedType != null) {
            return expandedType;
        }
        TypeAttributes typeAttributes = this.f24947i;
        TypeConstructor refinedConstructor = access$refineConstructor.getRefinedConstructor();
        Intrinsics.checkNotNull(refinedConstructor);
        return KotlinTypeFactory.simpleType(typeAttributes, refinedConstructor, (List<? extends TypeProjection>) this.f24946h, this.f24948j, kotlinTypeRefiner);
    }
}
