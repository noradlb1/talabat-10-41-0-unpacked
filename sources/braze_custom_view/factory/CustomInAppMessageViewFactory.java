package braze_custom_view.factory;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import braze_custom_view.mapper.BrazeCustomInAppMessageExtrasMapper;
import braze_custom_view.view.BrazeCustomView;
import braze_custom_view.view.CustomIAViewWebClient;
import braze_custom_view.view.CustomIAWebViewClickListener;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.IInAppMessageViewFactory;
import com.instabug.library.model.NetworkLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.R;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lbraze_custom_view/factory/CustomInAppMessageViewFactory;", "Lcom/braze/ui/inappmessage/IInAppMessageViewFactory;", "()V", "mapper", "Lbraze_custom_view/mapper/BrazeCustomInAppMessageExtrasMapper;", "buildBrazeCustomView", "Lbraze_custom_view/view/BrazeCustomView;", "activity", "Landroid/app/Activity;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "buildBrazeDefaultView", "Landroid/view/View;", "createInAppMessageView", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomInAppMessageViewFactory implements IInAppMessageViewFactory {
    @NotNull
    private final BrazeCustomInAppMessageExtrasMapper mapper = new BrazeCustomInAppMessageExtrasMapper();

    private final BrazeCustomView buildBrazeCustomView(Activity activity, IInAppMessage iInAppMessage) {
        View inflate = activity.getLayoutInflater().inflate(R.layout.f26525braze_custom_view, (ViewGroup) null, false);
        if (inflate != null) {
            BrazeCustomView brazeCustomView = (BrazeCustomView) inflate;
            brazeCustomView.setBackgroundColor(0);
            brazeCustomView.setWebViewClient(new CustomIAViewWebClient(activity, iInAppMessage, new CustomIAWebViewClickListener()));
            String message = iInAppMessage.getMessage();
            if (message != null) {
                brazeCustomView.loadDataWithBaseURL((String) null, message, NetworkLog.HTML, "UTF-8", (String) null);
            }
            return brazeCustomView;
        }
        throw new NullPointerException("null cannot be cast to non-null type braze_custom_view.view.BrazeCustomView");
    }

    private final View buildBrazeDefaultView(IInAppMessage iInAppMessage, Activity activity) {
        IInAppMessageViewFactory defaultInAppMessageViewFactory = BrazeInAppMessageManager.Companion.getInstance().getDefaultInAppMessageViewFactory(iInAppMessage);
        Intrinsics.checkNotNull(defaultInAppMessageViewFactory);
        return defaultInAppMessageViewFactory.createInAppMessageView(activity, iInAppMessage);
    }

    @Nullable
    public View createInAppMessageView(@NotNull Activity activity, @NotNull IInAppMessage iInAppMessage) {
        boolean z11;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        if (!this.mapper.mapToCustomBehaviour(iInAppMessage.getExtras()) || iInAppMessage.getMessageType() == MessageType.SLIDEUP) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return buildBrazeCustomView(activity, iInAppMessage);
        }
        return buildBrazeDefaultView(iInAppMessage, activity);
    }
}
