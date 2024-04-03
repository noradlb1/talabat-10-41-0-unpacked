package braze_custom_view.factory;

import android.view.View;
import android.view.animation.Animation;
import braze_custom_view.mapper.BrazeCustomInAppMessageExtrasMapper;
import braze_custom_view.view.CustomIAViewWrapper;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper;
import com.braze.ui.inappmessage.IInAppMessageViewWrapper;
import com.braze.ui.inappmessage.IInAppMessageViewWrapperFactory;
import com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import com.google.android.exoplayer2.RendererCapabilities;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JF\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0016J`\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lbraze_custom_view/factory/CustomIAViewWrapperFactory;", "Lcom/braze/ui/inappmessage/IInAppMessageViewWrapperFactory;", "()V", "mapper", "Lbraze_custom_view/mapper/BrazeCustomInAppMessageExtrasMapper;", "createInAppMessageViewWrapper", "Lcom/braze/ui/inappmessage/IInAppMessageViewWrapper;", "inAppMessageView", "Landroid/view/View;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "inAppMessageViewLifecycleListener", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageViewLifecycleListener;", "configurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "openingAnimation", "Landroid/view/animation/Animation;", "closingAnimation", "clickableInAppMessageView", "buttons", "", "closeButton", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomIAViewWrapperFactory implements IInAppMessageViewWrapperFactory {
    @NotNull
    private final BrazeCustomInAppMessageExtrasMapper mapper = new BrazeCustomInAppMessageExtrasMapper();

    @NotNull
    public IInAppMessageViewWrapper createInAppMessageViewWrapper(@NotNull View view, @NotNull IInAppMessage iInAppMessage, @NotNull IInAppMessageViewLifecycleListener iInAppMessageViewLifecycleListener, @NotNull BrazeConfigurationProvider brazeConfigurationProvider, @Nullable Animation animation, @Nullable Animation animation2, @Nullable View view2) {
        View view3 = view;
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(iInAppMessageViewLifecycleListener, "inAppMessageViewLifecycleListener");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        if (this.mapper.mapToCustomBehaviour(iInAppMessage.getExtras()) || iInAppMessage.getMessageType() == MessageType.SLIDEUP) {
            return new CustomIAViewWrapper(view, iInAppMessage, iInAppMessageViewLifecycleListener, brazeConfigurationProvider, animation, animation2, view2, (List<? extends View>) null, (View) null);
        }
        return new DefaultInAppMessageViewWrapper(view, iInAppMessage, iInAppMessageViewLifecycleListener, brazeConfigurationProvider, animation, animation2, view2, (List) null, (View) null, RendererCapabilities.MODE_SUPPORT_MASK, (DefaultConstructorMarker) null);
    }

    @NotNull
    public IInAppMessageViewWrapper createInAppMessageViewWrapper(@NotNull View view, @NotNull IInAppMessage iInAppMessage, @NotNull IInAppMessageViewLifecycleListener iInAppMessageViewLifecycleListener, @NotNull BrazeConfigurationProvider brazeConfigurationProvider, @Nullable Animation animation, @Nullable Animation animation2, @Nullable View view2, @Nullable List<? extends View> list, @Nullable View view3) {
        View view4 = view;
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        IInAppMessage iInAppMessage2 = iInAppMessage;
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        IInAppMessageViewLifecycleListener iInAppMessageViewLifecycleListener2 = iInAppMessageViewLifecycleListener;
        Intrinsics.checkNotNullParameter(iInAppMessageViewLifecycleListener, "inAppMessageViewLifecycleListener");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        if (this.mapper.mapToCustomBehaviour(iInAppMessage.getExtras())) {
            return new CustomIAViewWrapper(view, iInAppMessage, iInAppMessageViewLifecycleListener, brazeConfigurationProvider, animation, animation2, view2, list, view3);
        }
        return new DefaultInAppMessageViewWrapper(view, iInAppMessage, iInAppMessageViewLifecycleListener, brazeConfigurationProvider, animation, animation2, view2, list, view3);
    }
}
