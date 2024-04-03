package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "T", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ComposerImpl$createNode$2 extends Lambda implements Function3<Applier<?>, SlotWriter, RememberManager, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function0<T> f9040g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Anchor f9041h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f9042i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposerImpl$createNode$2(Function0<? extends T> function0, Anchor anchor, int i11) {
        super(3);
        this.f9040g = function0;
        this.f9041h = anchor;
        this.f9042i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((Applier<?>) (Applier) obj, (SlotWriter) obj2, (RememberManager) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Applier<?> applier, @NotNull SlotWriter slotWriter, @NotNull RememberManager rememberManager) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        Intrinsics.checkNotNullParameter(slotWriter, "slots");
        Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
        T invoke = this.f9040g.invoke();
        slotWriter.updateNode(this.f9041h, invoke);
        applier.insertTopDown(this.f9042i, invoke);
        applier.down(invoke);
    }
}
