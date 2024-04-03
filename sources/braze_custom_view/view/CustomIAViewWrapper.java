package braze_custom_view.view;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import braze_custom_view.mapper.BrazeCustomInAppMessageExtrasMapper;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.inappmessage.SlideFrom;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageSlideup;
import com.braze.ui.inappmessage.DefaultInAppMessageViewWrapper;
import com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J&\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0002J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0012\u0010\u001e\u001a\u00020 2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J&\u0010\"\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0002¨\u0006%"}, d2 = {"Lbraze_custom_view/view/CustomIAViewWrapper;", "Lcom/braze/ui/inappmessage/DefaultInAppMessageViewWrapper;", "inAppMessageView", "Landroid/view/View;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "inAppMessageViewLifecycleListener", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageViewLifecycleListener;", "configurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "openingAnimation", "Landroid/view/animation/Animation;", "closingAnimation", "clickableInAppMessageView", "buttonViews", "", "closeButton", "(Landroid/view/View;Lcom/braze/models/inappmessage/IInAppMessage;Lcom/braze/ui/inappmessage/listeners/IInAppMessageViewLifecycleListener;Lcom/braze/configuration/BrazeConfigurationProvider;Landroid/view/animation/Animation;Landroid/view/animation/Animation;Landroid/view/View;Ljava/util/List;Landroid/view/View;)V", "dip2pix", "", "context", "Landroid/content/Context;", "dip", "getGravity", "mapper", "Lbraze_custom_view/mapper/BrazeCustomInAppMessageExtrasMapper;", "extras", "", "", "getLayoutHeightInPix", "getLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "Landroid/view/ViewGroup$LayoutParams;", "getLayoutWidthInPix", "isCustomBehaviourEnabled", "", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomIAViewWrapper extends DefaultInAppMessageViewWrapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int SLIDE_UP_OFFSET = 56;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lbraze_custom_view/view/CustomIAViewWrapper$Companion;", "", "()V", "SLIDE_UP_OFFSET", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomIAViewWrapper(@NotNull View view, @NotNull IInAppMessage iInAppMessage, @NotNull IInAppMessageViewLifecycleListener iInAppMessageViewLifecycleListener, @NotNull BrazeConfigurationProvider brazeConfigurationProvider, @Nullable Animation animation, @Nullable Animation animation2, @Nullable View view2, @Nullable List<? extends View> list, @Nullable View view3) {
        super(view, iInAppMessage, iInAppMessageViewLifecycleListener, brazeConfigurationProvider, animation, animation2, view2, list, view3);
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(iInAppMessageViewLifecycleListener, "inAppMessageViewLifecycleListener");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
    }

    private final int dip2pix(Context context, int i11) {
        return (int) TypedValue.applyDimension(1, (float) i11, context.getResources().getDisplayMetrics());
    }

    private final int getGravity(BrazeCustomInAppMessageExtrasMapper brazeCustomInAppMessageExtrasMapper, Map<String, String> map) {
        return brazeCustomInAppMessageExtrasMapper.mapTOLayoutGravity(map);
    }

    private final int getLayoutHeightInPix(BrazeCustomInAppMessageExtrasMapper brazeCustomInAppMessageExtrasMapper, IInAppMessage iInAppMessage) {
        Context context = getInAppMessageView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inAppMessageView.context");
        return dip2pix(context, brazeCustomInAppMessageExtrasMapper.mapToHeightInDP(iInAppMessage.getExtras()));
    }

    private final int getLayoutWidthInPix(BrazeCustomInAppMessageExtrasMapper brazeCustomInAppMessageExtrasMapper, IInAppMessage iInAppMessage) {
        Context context = getInAppMessageView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inAppMessageView.context");
        return dip2pix(context, brazeCustomInAppMessageExtrasMapper.mapToWidthInDP(iInAppMessage.getExtras()));
    }

    private final boolean isCustomBehaviourEnabled(BrazeCustomInAppMessageExtrasMapper brazeCustomInAppMessageExtrasMapper, Map<String, String> map) {
        return brazeCustomInAppMessageExtrasMapper.mapToCustomBehaviour(map);
    }

    @NotNull
    public ViewGroup.LayoutParams getLayoutParams(@Nullable IInAppMessage iInAppMessage) {
        if (iInAppMessage instanceof InAppMessageSlideup) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = ((InAppMessageSlideup) iInAppMessage).getSlideFrom() == SlideFrom.TOP ? 48 : 80;
            Context context = getInAppMessageView().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "inAppMessageView.context");
            layoutParams.bottomMargin = dip2pix(context, 56);
            return layoutParams;
        }
        BrazeCustomInAppMessageExtrasMapper brazeCustomInAppMessageExtrasMapper = new BrazeCustomInAppMessageExtrasMapper();
        Intrinsics.checkNotNull(iInAppMessage);
        if (!isCustomBehaviourEnabled(brazeCustomInAppMessageExtrasMapper, iInAppMessage.getExtras())) {
            return super.getLayoutParams(iInAppMessage);
        }
        FrameLayout.LayoutParams layoutParams2 = getLayoutParams(brazeCustomInAppMessageExtrasMapper, iInAppMessage);
        layoutParams2.gravity = 0;
        layoutParams2.gravity = getGravity(brazeCustomInAppMessageExtrasMapper, iInAppMessage.getExtras());
        return layoutParams2;
    }

    private final FrameLayout.LayoutParams getLayoutParams(BrazeCustomInAppMessageExtrasMapper brazeCustomInAppMessageExtrasMapper, IInAppMessage iInAppMessage) {
        return new FrameLayout.LayoutParams(getLayoutWidthInPix(brazeCustomInAppMessageExtrasMapper, iInAppMessage), getLayoutHeightInPix(brazeCustomInAppMessageExtrasMapper, iInAppMessage));
    }
}
