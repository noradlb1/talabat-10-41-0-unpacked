package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R$\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/input/pointer/ConsumedData;", "", "positionChange", "", "downChange", "(ZZ)V", "getDownChange$annotations", "()V", "getDownChange", "()Z", "setDownChange", "(Z)V", "getPositionChange$annotations", "getPositionChange", "setPositionChange", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(message = "Use PointerInputChange.isConsumed and PointerInputChange.consume() instead")
public final class ConsumedData {
    public static final int $stable = 8;
    private boolean downChange;
    private boolean positionChange;

    public ConsumedData() {
        this(false, false, 3, (DefaultConstructorMarker) null);
    }

    public ConsumedData(boolean z11, boolean z12) {
        this.positionChange = z11;
        this.downChange = z12;
    }

    @Deprecated(message = "Partial consumption was deprecated. Use PointerEvent.isConsumed and PointerEvent.consume() instead.")
    public static /* synthetic */ void getDownChange$annotations() {
    }

    @Deprecated(message = "Partial consumption was deprecated. Use PointerEvent.isConsumed and PointerEvent.consume() instead.")
    public static /* synthetic */ void getPositionChange$annotations() {
    }

    public final boolean getDownChange() {
        return this.downChange;
    }

    public final boolean getPositionChange() {
        return this.positionChange;
    }

    public final void setDownChange(boolean z11) {
        this.downChange = z11;
    }

    public final void setPositionChange(boolean z11) {
        this.positionChange = z11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsumedData(boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? false : z12);
    }
}
