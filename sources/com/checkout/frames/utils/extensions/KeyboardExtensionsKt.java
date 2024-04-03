package com.checkout.frames.utils.extensions;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.LocalSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"ResetFocus", "", "(Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KeyboardExtensionsKt {
    @Composable
    public static final void ResetFocus(@Nullable Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-1914575288);
        if (i11 != 0 || !startRestartGroup.getSkipping()) {
            SoftwareKeyboardController current = LocalSoftwareKeyboardController.INSTANCE.getCurrent(startRestartGroup, 8);
            if (current != null) {
                current.hide();
            }
            ((FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager())).clearFocus(true);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new KeyboardExtensionsKt$ResetFocus$1(i11));
        }
    }
}
