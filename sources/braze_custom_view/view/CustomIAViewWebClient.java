package braze_custom_view.view;

import android.content.Context;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import com.braze.ui.inappmessage.utils.InAppMessageWebViewClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lbraze_custom_view/view/CustomIAViewWebClient;", "Lcom/braze/ui/inappmessage/utils/InAppMessageWebViewClient;", "context", "Landroid/content/Context;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "inAppMessageWebViewClientListener", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageWebViewClientListener;", "(Landroid/content/Context;Lcom/braze/models/inappmessage/IInAppMessage;Lcom/braze/ui/inappmessage/listeners/IInAppMessageWebViewClientListener;)V", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomIAViewWebClient extends InAppMessageWebViewClient {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomIAViewWebClient(@NotNull Context context, @NotNull IInAppMessage iInAppMessage, @Nullable IInAppMessageWebViewClientListener iInAppMessageWebViewClientListener) {
        super(context, iInAppMessage, iInAppMessageWebViewClientListener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
    }
}
