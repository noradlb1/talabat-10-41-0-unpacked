package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;

public final class AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$4 extends Lambda implements Function1<TypeCheckerState.ForkPointContext, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<SimpleTypeMarker> f24924g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TypeCheckerState f24925h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ TypeSystemContext f24926i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SimpleTypeMarker f24927j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$4(List<? extends SimpleTypeMarker> list, TypeCheckerState typeCheckerState, TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        super(1);
        this.f24924g = list;
        this.f24925h = typeCheckerState;
        this.f24926i = typeSystemContext;
        this.f24927j = simpleTypeMarker;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TypeCheckerState.ForkPointContext) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TypeCheckerState.ForkPointContext forkPointContext) {
        Intrinsics.checkNotNullParameter(forkPointContext, "$this$runForkingPoint");
        for (final SimpleTypeMarker next : this.f24924g) {
            final TypeCheckerState typeCheckerState = this.f24925h;
            final TypeSystemContext typeSystemContext = this.f24926i;
            final SimpleTypeMarker simpleTypeMarker = this.f24927j;
            forkPointContext.fork(new Function0<Boolean>() {
                @NotNull
                public final Boolean invoke() {
                    return Boolean.valueOf(AbstractTypeChecker.INSTANCE.isSubtypeForSameConstructor(typeCheckerState, typeSystemContext.asArgumentList(next), simpleTypeMarker));
                }
            });
        }
    }
}
