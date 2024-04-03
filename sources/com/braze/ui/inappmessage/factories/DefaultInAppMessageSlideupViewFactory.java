package com.braze.ui.inappmessage.factories;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.appboy.ui.R;
import com.braze.Braze;
import com.braze.enums.BrazeViewBounds;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageSlideup;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.IInAppMessageViewFactory;
import com.braze.ui.inappmessage.views.InAppMessageBaseView;
import com.braze.ui.inappmessage.views.InAppMessageSlideupView;
import com.braze.ui.support.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/braze/ui/inappmessage/factories/DefaultInAppMessageSlideupViewFactory;", "Lcom/braze/ui/inappmessage/IInAppMessageViewFactory;", "()V", "createInAppMessageView", "Lcom/braze/ui/inappmessage/views/InAppMessageSlideupView;", "activity", "Landroid/app/Activity;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class DefaultInAppMessageSlideupViewFactory implements IInAppMessageViewFactory {
    @Nullable
    public InAppMessageSlideupView createInAppMessageView(@NotNull Activity activity, @NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        View inflate = activity.getLayoutInflater().inflate(R.layout.com_braze_inappmessage_slideup, (ViewGroup) null);
        if (inflate != null) {
            InAppMessageSlideupView inAppMessageSlideupView = (InAppMessageSlideupView) inflate;
            if (ViewUtils.isDeviceNotInTouchMode(inAppMessageSlideupView)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) DefaultInAppMessageSlideupViewFactory$createInAppMessageView$1.INSTANCE, 6, (Object) null);
                return null;
            }
            InAppMessageSlideup inAppMessageSlideup = (InAppMessageSlideup) iInAppMessage;
            Context applicationContext = activity.getApplicationContext();
            inAppMessageSlideupView.applyInAppMessageParameters(iInAppMessage);
            String appropriateImageUrl = InAppMessageBaseView.Companion.getAppropriateImageUrl(inAppMessageSlideup);
            if (!(appropriateImageUrl == null || appropriateImageUrl.length() == 0)) {
                Braze.Companion companion = Braze.Companion;
                Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                IBrazeImageLoader imageLoader = companion.getInstance(applicationContext).getImageLoader();
                ImageView messageImageView = inAppMessageSlideupView.getMessageImageView();
                if (messageImageView != null) {
                    imageLoader.renderUrlIntoInAppMessageView(applicationContext, iInAppMessage, appropriateImageUrl, messageImageView, BrazeViewBounds.IN_APP_MESSAGE_SLIDEUP);
                }
            }
            inAppMessageSlideupView.setMessageBackgroundColor(inAppMessageSlideup.getBackgroundColor());
            String message = inAppMessageSlideup.getMessage();
            if (message != null) {
                inAppMessageSlideupView.setMessage(message);
            }
            inAppMessageSlideupView.setMessageTextColor(inAppMessageSlideup.getMessageTextColor());
            inAppMessageSlideupView.setMessageTextAlign(inAppMessageSlideup.getMessageTextAlign());
            String icon = inAppMessageSlideup.getIcon();
            if (icon != null) {
                inAppMessageSlideupView.setMessageIcon(icon, inAppMessageSlideup.getIconColor(), inAppMessageSlideup.getIconBackgroundColor());
            }
            inAppMessageSlideupView.setMessageChevron(inAppMessageSlideup.getChevronColor(), inAppMessageSlideup.getClickAction());
            inAppMessageSlideupView.resetMessageMargins(inAppMessageSlideup.getImageDownloadSuccessful());
            return inAppMessageSlideupView;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageSlideupView");
    }
}
