package m0;

import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Deprecated;
import kotlin.ReplaceWith;

public final /* synthetic */ class w1 {
    @Deprecated(message = "Use hide instead.", replaceWith = @ReplaceWith(expression = "hide()", imports = {}))
    public static void a(SoftwareKeyboardController softwareKeyboardController) {
        softwareKeyboardController.hide();
    }

    @Deprecated(message = "Use show instead.", replaceWith = @ReplaceWith(expression = "show()", imports = {}))
    public static void b(SoftwareKeyboardController softwareKeyboardController) {
        softwareKeyboardController.show();
    }
}
