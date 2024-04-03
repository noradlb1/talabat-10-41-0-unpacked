package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1 extends Lambda implements Function1<TypeConstructor, Iterable<? extends KotlinType>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AbstractTypeConstructor f24939g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.f24939g = abstractTypeConstructor;
    }

    @NotNull
    public final Iterable<KotlinType> invoke(@NotNull TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "it");
        return this.f24939g.computeNeighbours(typeConstructor, false);
    }
}
