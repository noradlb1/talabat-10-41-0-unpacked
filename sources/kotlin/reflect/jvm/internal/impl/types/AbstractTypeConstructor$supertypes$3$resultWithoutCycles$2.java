package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2 extends Lambda implements Function1<KotlinType, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ AbstractTypeConstructor f24940g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.f24940g = abstractTypeConstructor;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KotlinType) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "it");
        this.f24940g.j(kotlinType);
    }
}
