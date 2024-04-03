package c4;

import android.view.View;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.MessageButton;
import com.braze.support.BrazeFunctionNotImplemented;
import com.braze.ui.inappmessage.InAppMessageCloser;
import com.braze.ui.inappmessage.InAppMessageOperation;
import com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final /* synthetic */ class b {
    public static void a(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
    }

    public static void b(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull View view, @NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
    }

    @NotNull
    public static InAppMessageOperation c(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        return InAppMessageOperation.DISPLAY_NOW;
    }

    public static void d(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull View view, @NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
    }

    public static void e(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull View view, @NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
    }

    public static boolean f(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull IInAppMessage iInAppMessage, @NotNull MessageButton messageButton) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(messageButton, "button");
        return false;
    }

    @Deprecated(message = "InAppMessageCloser is deprecated", replaceWith = @ReplaceWith(expression = "onInAppMessageButtonClicked(inAppMessage, button)", imports = {}))
    public static boolean g(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull IInAppMessage iInAppMessage, @NotNull MessageButton messageButton, @Nullable InAppMessageCloser inAppMessageCloser) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(messageButton, "button");
        throw BrazeFunctionNotImplemented.INSTANCE;
    }

    public static boolean h(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        return false;
    }

    @Deprecated(message = "InAppMessageCloser is deprecated", replaceWith = @ReplaceWith(expression = "onInAppMessageClicked(inAppMessage)", imports = {}))
    public static boolean i(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull IInAppMessage iInAppMessage, @Nullable InAppMessageCloser inAppMessageCloser) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        throw BrazeFunctionNotImplemented.INSTANCE;
    }

    public static void j(IInAppMessageManagerListener iInAppMessageManagerListener, @NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
    }
}
