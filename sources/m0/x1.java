package m0;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.TextToolbar;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class x1 {
    public static /* synthetic */ void a(TextToolbar textToolbar, Rect rect, Function0 function0, Function0 function02, Function0 function03, Function0 function04, int i11, Object obj) {
        if (obj == null) {
            textToolbar.showMenu(rect, (i11 & 2) != 0 ? null : function0, (i11 & 4) != 0 ? null : function02, (i11 & 8) != 0 ? null : function03, (i11 & 16) != 0 ? null : function04);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMenu");
    }
}
