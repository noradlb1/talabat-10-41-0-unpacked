package t;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.ui.geometry.Rect;
import kotlin.coroutines.Continuation;

public final /* synthetic */ class a {
    public static /* synthetic */ Object a(BringIntoViewRequester bringIntoViewRequester, Rect rect, Continuation continuation, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                rect = null;
            }
            return bringIntoViewRequester.bringIntoView(rect, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bringIntoView");
    }
}
