package androidx.compose.runtime;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposerImpl$insertMovableContentGuarded$1$1$2$2 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f9066g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> f9067h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerImpl$insertMovableContentGuarded$1$1$2$2(Ref.IntRef intRef, List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list) {
        super(3);
        this.f9066g = intRef;
        this.f9067h = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) (Applier) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        Intrinsics.checkNotNullParameter(slotWriter, "slots");
        Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
        int i11 = this.f9066g.element;
        if (i11 > 0) {
            applier = new OffsetApplier<>(applier, i11);
        }
        List<Function3<Applier<?>, SlotWriter, RememberManager, Unit>> list = this.f9067h;
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            list.get(i12).invoke(applier, slotWriter, rememberManager);
        }
    }
}
