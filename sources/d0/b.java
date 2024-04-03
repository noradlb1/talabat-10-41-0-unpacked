package d0;

import androidx.compose.ui.focus.FocusManager;

public final /* synthetic */ class b {
    public static /* synthetic */ void a(FocusManager focusManager, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            focusManager.clearFocus(z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clearFocus");
    }
}
