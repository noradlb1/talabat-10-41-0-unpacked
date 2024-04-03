package braze_custom_view.view;

import android.os.Bundle;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lbraze_custom_view/view/CustomIAWebViewClickListener;", "Lcom/braze/ui/inappmessage/listeners/DefaultInAppMessageWebViewClientListener;", "()V", "onCloseAction", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "url", "", "queryBundle", "Landroid/os/Bundle;", "onCustomEventAction", "onNewsfeedAction", "onOtherUrlAction", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomIAWebViewClickListener extends DefaultInAppMessageWebViewClientListener {
    public void onCloseAction(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        super.onCloseAction(iInAppMessage, str, bundle);
        BrazeInAppMessageManager.Companion companion = BrazeInAppMessageManager.Companion;
        companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
        companion.getInstance().getHtmlInAppMessageActionListener().onCloseClicked(iInAppMessage, str, bundle);
    }

    public void onCustomEventAction(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        super.onCustomEventAction(iInAppMessage, str, bundle);
        BrazeInAppMessageManager.Companion companion = BrazeInAppMessageManager.Companion;
        companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
        companion.getInstance().getHtmlInAppMessageActionListener().onCloseClicked(iInAppMessage, str, bundle);
    }

    public void onNewsfeedAction(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        super.onNewsfeedAction(iInAppMessage, str, bundle);
        BrazeInAppMessageManager.Companion companion = BrazeInAppMessageManager.Companion;
        companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
        companion.getInstance().getHtmlInAppMessageActionListener().onCloseClicked(iInAppMessage, str, bundle);
    }

    public void onOtherUrlAction(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        super.onOtherUrlAction(iInAppMessage, str, bundle);
        BrazeInAppMessageManager.Companion companion = BrazeInAppMessageManager.Companion;
        companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
        companion.getInstance().getHtmlInAppMessageActionListener().onCloseClicked(iInAppMessage, str, bundle);
    }
}
