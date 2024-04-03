package androidx.compose.ui.platform;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.input.pointer.AndroidPointerIcon;
import androidx.compose.ui.input.pointer.AndroidPointerIconType;
import androidx.compose.ui.input.pointer.PointerIcon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(24)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewVerificationHelperMethodsN;", "", "()V", "setPointerIcon", "", "view", "Landroid/view/View;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class AndroidComposeViewVerificationHelperMethodsN {
    @NotNull
    public static final AndroidComposeViewVerificationHelperMethodsN INSTANCE = new AndroidComposeViewVerificationHelperMethodsN();

    private AndroidComposeViewVerificationHelperMethodsN() {
    }

    @RequiresApi(24)
    @DoNotInline
    public final void setPointerIcon(@NotNull View view, @Nullable PointerIcon pointerIcon) {
        android.view.PointerIcon pointerIcon2;
        Intrinsics.checkNotNullParameter(view, "view");
        if (pointerIcon instanceof AndroidPointerIcon) {
            pointerIcon2 = ((AndroidPointerIcon) pointerIcon).getPointerIcon();
        } else if (pointerIcon instanceof AndroidPointerIconType) {
            pointerIcon2 = android.view.PointerIcon.getSystemIcon(view.getContext(), ((AndroidPointerIconType) pointerIcon).getType());
            Intrinsics.checkNotNullExpressionValue(pointerIcon2, "getSystemIcon(view.context, icon.type)");
        } else {
            pointerIcon2 = android.view.PointerIcon.getSystemIcon(view.getContext(), 1000);
            Intrinsics.checkNotNullExpressionValue(pointerIcon2, "getSystemIcon(\n         …DEFAULT\n                )");
        }
        if (!Intrinsics.areEqual((Object) view.getPointerIcon(), (Object) pointerIcon2)) {
            view.setPointerIcon(pointerIcon2);
        }
    }
}
