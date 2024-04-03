package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1 extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TypeConstructor f24949g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<TypeProjection> f24950h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TypeAttributes f24951i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f24952j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MemberScope f24953k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1(TypeConstructor typeConstructor, List<? extends TypeProjection> list, TypeAttributes typeAttributes, boolean z11, MemberScope memberScope) {
        super(1);
        this.f24949g = typeConstructor;
        this.f24950h = list;
        this.f24951i = typeAttributes;
        this.f24952j = z11;
        this.f24953k = memberScope;
    }

    @Nullable
    public final SimpleType invoke(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinTypeFactory.ExpandedTypeOrRefinedConstructor access$refineConstructor = KotlinTypeFactory.INSTANCE.refineConstructor(this.f24949g, kotlinTypeRefiner, this.f24950h);
        if (access$refineConstructor == null) {
            return null;
        }
        SimpleType expandedType = access$refineConstructor.getExpandedType();
        if (expandedType != null) {
            return expandedType;
        }
        TypeAttributes typeAttributes = this.f24951i;
        TypeConstructor refinedConstructor = access$refineConstructor.getRefinedConstructor();
        Intrinsics.checkNotNull(refinedConstructor);
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(typeAttributes, refinedConstructor, this.f24950h, this.f24952j, this.f24953k);
    }
}
