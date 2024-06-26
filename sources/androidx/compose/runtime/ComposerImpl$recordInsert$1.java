package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposerImpl$recordInsert$1 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SlotTable f9088g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Anchor f9089h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerImpl$recordInsert$1(SlotTable slotTable, Anchor anchor) {
        super(3);
        this.f9088g = slotTable;
        this.f9089h = anchor;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) (Applier) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(slotWriter, "slots");
        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
        slotWriter.beginInsert();
        SlotTable slotTable = this.f9088g;
        slotWriter.moveFrom(slotTable, this.f9089h.toIndexFor(slotTable));
        slotWriter.endInsert();
    }
}
