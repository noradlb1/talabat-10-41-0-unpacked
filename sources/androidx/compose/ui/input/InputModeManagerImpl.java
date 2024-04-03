package androidx.compose.ui.input;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B$\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u001d\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R4\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038V@VX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/input/InputModeManagerImpl;", "Landroidx/compose/ui/input/InputModeManager;", "initialInputMode", "Landroidx/compose/ui/input/InputMode;", "onRequestInputModeChange", "Lkotlin/Function1;", "", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "<set-?>", "inputMode", "getInputMode-aOaMEAU", "()I", "setInputMode-iuPiT84", "(I)V", "inputMode$delegate", "Landroidx/compose/runtime/MutableState;", "requestInputMode", "requestInputMode-iuPiT84", "(I)Z", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputModeManagerImpl implements InputModeManager {
    @NotNull
    private final MutableState inputMode$delegate;
    @NotNull
    private final Function1<InputMode, Boolean> onRequestInputModeChange;

    private InputModeManagerImpl(int i11, Function1<? super InputMode, Boolean> function1) {
        this.onRequestInputModeChange = function1;
        this.inputMode$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputMode.m3571boximpl(i11), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public /* synthetic */ InputModeManagerImpl(int i11, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, function1);
    }

    /* renamed from: getInputMode-aOaMEAU  reason: not valid java name */
    public int m3582getInputModeaOaMEAU() {
        return ((InputMode) this.inputMode$delegate.getValue()).m3577unboximpl();
    }

    @ExperimentalComposeUiApi
    /* renamed from: requestInputMode-iuPiT84  reason: not valid java name */
    public boolean m3583requestInputModeiuPiT84(int i11) {
        return this.onRequestInputModeChange.invoke(InputMode.m3571boximpl(i11)).booleanValue();
    }

    /* renamed from: setInputMode-iuPiT84  reason: not valid java name */
    public void m3584setInputModeiuPiT84(int i11) {
        this.inputMode$delegate.setValue(InputMode.m3571boximpl(i11));
    }
}
