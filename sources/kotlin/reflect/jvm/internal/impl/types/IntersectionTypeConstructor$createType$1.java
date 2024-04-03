package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntersectionTypeConstructor$createType$1 extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ IntersectionTypeConstructor f24943g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntersectionTypeConstructor$createType$1(IntersectionTypeConstructor intersectionTypeConstructor) {
        super(1);
        this.f24943g = intersectionTypeConstructor;
    }

    @Nullable
    public final SimpleType invoke(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f24943g.refine(kotlinTypeRefiner).createType();
    }
}
