package androidx.compose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00058V@VX\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR3\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b8W@VX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/WindowInfoImpl;", "Landroidx/compose/ui/platform/WindowInfo;", "()V", "_isWindowFocused", "Landroidx/compose/runtime/MutableState;", "", "value", "isWindowFocused", "()Z", "setWindowFocused", "(Z)V", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "keyboardModifiers", "getKeyboardModifiers-k7X9c1A$annotations", "getKeyboardModifiers-k7X9c1A", "()I", "setKeyboardModifiers-5xRPYO0", "(I)V", "Companion", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WindowInfoImpl implements WindowInfo {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final MutableState<PointerKeyboardModifiers> GlobalKeyboardModifiers = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PointerKeyboardModifiers.m4355boximpl(PointerEvent_androidKt.EmptyPointerKeyboardModifiers()), (SnapshotMutationPolicy) null, 2, (Object) null);
    @NotNull
    private final MutableState<Boolean> _isWindowFocused = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/WindowInfoImpl$Companion;", "", "()V", "GlobalKeyboardModifiers", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getGlobalKeyboardModifiers$ui_release", "()Landroidx/compose/runtime/MutableState;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MutableState<PointerKeyboardModifiers> getGlobalKeyboardModifiers$ui_release() {
            return WindowInfoImpl.GlobalKeyboardModifiers;
        }
    }

    /* renamed from: getKeyboardModifiers-k7X9c1A$annotations  reason: not valid java name */
    public static /* synthetic */ void m4891getKeyboardModifiersk7X9c1A$annotations() {
    }

    @ExperimentalComposeUiApi
    /* renamed from: getKeyboardModifiers-k7X9c1A  reason: not valid java name */
    public int m4892getKeyboardModifiersk7X9c1A() {
        return GlobalKeyboardModifiers.getValue().m4361unboximpl();
    }

    public boolean isWindowFocused() {
        return this._isWindowFocused.getValue().booleanValue();
    }

    /* renamed from: setKeyboardModifiers-5xRPYO0  reason: not valid java name */
    public void m4893setKeyboardModifiers5xRPYO0(int i11) {
        GlobalKeyboardModifiers.setValue(PointerKeyboardModifiers.m4355boximpl(i11));
    }

    public void setWindowFocused(boolean z11) {
        this._isWindowFocused.setValue(Boolean.valueOf(z11));
    }
}
