package androidx.compose.ui.text.input;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodManager;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J \u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J0\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/text/input/InputMethodManagerImpl;", "Landroidx/compose/ui/text/input/InputMethodManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "imm", "Landroid/view/inputmethod/InputMethodManager;", "getImm", "()Landroid/view/inputmethod/InputMethodManager;", "imm$delegate", "Lkotlin/Lazy;", "hideSoftInputFromWindow", "", "windowToken", "Landroid/os/IBinder;", "restartInput", "view", "Landroid/view/View;", "showSoftInput", "updateExtractedText", "token", "", "extractedText", "Landroid/view/inputmethod/ExtractedText;", "updateSelection", "selectionStart", "selectionEnd", "compositionStart", "compositionEnd", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputMethodManagerImpl implements InputMethodManager {
    @NotNull
    private final Lazy imm$delegate;

    public InputMethodManagerImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.imm$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new InputMethodManagerImpl$imm$2(context));
    }

    private final InputMethodManager getImm() {
        return (InputMethodManager) this.imm$delegate.getValue();
    }

    public void hideSoftInputFromWindow(@Nullable IBinder iBinder) {
        getImm().hideSoftInputFromWindow(iBinder, 0);
    }

    public void restartInput(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        getImm().restartInput(view);
    }

    public void showSoftInput(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        getImm().showSoftInput(view, 0);
    }

    public void updateExtractedText(@NotNull View view, int i11, @NotNull ExtractedText extractedText) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(extractedText, "extractedText");
        getImm().updateExtractedText(view, i11, extractedText);
    }

    public void updateSelection(@NotNull View view, int i11, int i12, int i13, int i14) {
        Intrinsics.checkNotNullParameter(view, "view");
        getImm().updateSelection(view, i11, i12, i13, i14);
    }
}
