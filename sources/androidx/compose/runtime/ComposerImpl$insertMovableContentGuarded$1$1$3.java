package androidx.compose.runtime;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "applier", "Landroidx/compose/runtime/Applier;", "<anonymous parameter 1>", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposerImpl$insertMovableContentGuarded$1$1$3 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f9068g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<Object> f9069h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerImpl$insertMovableContentGuarded$1$1$3(Ref.IntRef intRef, List<? extends Object> list) {
        super(3);
        this.f9068g = intRef;
        this.f9069h = list;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) (Applier) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        Intrinsics.checkNotNullParameter(slotWriter, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
        int i11 = this.f9068g.element;
        List<Object> list = this.f9069h;
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            Object obj = list.get(i12);
            int i13 = i11 + i12;
            applier.insertBottomUp(i13, obj);
            applier.insertTopDown(i13, obj);
        }
    }
}
