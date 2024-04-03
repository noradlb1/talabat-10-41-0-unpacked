package androidx.compose.runtime;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposerImpl$insertMovableContentGuarded$1$1$4 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MovableContentState f9070g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ComposerImpl f9071h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MovableContentStateReference f9072i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MovableContentStateReference f9073j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerImpl$insertMovableContentGuarded$1$1$4(MovableContentState movableContentState, ComposerImpl composerImpl, MovableContentStateReference movableContentStateReference, MovableContentStateReference movableContentStateReference2) {
        super(3);
        this.f9070g = movableContentState;
        this.f9071h = composerImpl;
        this.f9072i = movableContentStateReference;
        this.f9073j = movableContentStateReference2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) (Applier) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(slotWriter, "slots");
        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
        MovableContentState movableContentState = this.f9070g;
        if (movableContentState == null && (movableContentState = this.f9071h.parentContext.movableContentStateResolve$runtime_release(this.f9072i)) == null) {
            ComposerKt.composeRuntimeError("Could not resolve state for movable content");
            throw new KotlinNothingValueException();
        }
        List<Anchor> moveIntoGroupFrom = slotWriter.moveIntoGroupFrom(1, movableContentState.getSlotTable$runtime_release(), 2);
        if (!moveIntoGroupFrom.isEmpty()) {
            ControlledComposition composition$runtime_release = this.f9073j.getComposition$runtime_release();
            Intrinsics.checkNotNull(composition$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
            CompositionImpl compositionImpl = (CompositionImpl) composition$runtime_release;
            int size = moveIntoGroupFrom.size();
            for (int i11 = 0; i11 < size; i11++) {
                Object slot = slotWriter.slot(moveIntoGroupFrom.get(i11), 0);
                RecomposeScopeImpl recomposeScopeImpl = slot instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) slot : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.adoptedBy(compositionImpl);
                }
            }
        }
    }
}
