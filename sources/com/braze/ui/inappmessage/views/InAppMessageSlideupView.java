package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.WindowInsetsCompat;
import com.appboy.ui.R;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.support.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H\u0016J\u0016\u0010&\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u0010'\u001a\u00020(R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012¨\u0006)"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageSlideupView;", "Lcom/braze/ui/inappmessage/views/InAppMessageBaseView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "inAppMessageImageView", "Lcom/braze/ui/inappmessage/views/InAppMessageImageView;", "messageBackgroundObject", "Landroid/view/View;", "getMessageBackgroundObject", "()Landroid/view/View;", "messageChevronView", "getMessageChevronView", "messageIconView", "Landroid/widget/TextView;", "getMessageIconView", "()Landroid/widget/TextView;", "messageImageView", "Landroid/widget/ImageView;", "getMessageImageView", "()Landroid/widget/ImageView;", "messageTextView", "getMessageTextView", "applyInAppMessageParameters", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "applyWindowInsets", "insets", "Landroidx/core/view/WindowInsetsCompat;", "resetMessageMargins", "imageRetrievalSuccessful", "", "setMessageBackgroundColor", "color", "", "setMessageChevron", "clickAction", "Lcom/braze/enums/inappmessage/ClickAction;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class InAppMessageSlideupView extends InAppMessageBaseView {
    @Nullable
    private InAppMessageImageView inAppMessageImageView;

    public InAppMessageSlideupView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private final View getMessageChevronView() {
        return findViewById(R.id.com_braze_inappmessage_slideup_chevron);
    }

    public final void applyInAppMessageParameters(@NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        InAppMessageImageView inAppMessageImageView2 = (InAppMessageImageView) findViewById(R.id.com_braze_inappmessage_slideup_imageview);
        this.inAppMessageImageView = inAppMessageImageView2;
        if (inAppMessageImageView2 != null) {
            inAppMessageImageView2.setInAppMessageImageCropType(iInAppMessage.getCropType());
        }
    }

    public void applyWindowInsets(@NotNull WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        super.applyWindowInsets(windowInsetsCompat);
        if (getLayoutParams() == null || !(getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) InAppMessageSlideupView$applyWindowInsets$1.INSTANCE, 7, (Object) null);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(ViewUtils.getMaxSafeLeftInset(windowInsetsCompat) + marginLayoutParams.leftMargin, ViewUtils.getMaxSafeTopInset(windowInsetsCompat) + marginLayoutParams.topMargin, ViewUtils.getMaxSafeRightInset(windowInsetsCompat) + marginLayoutParams.rightMargin, ViewUtils.getMaxSafeBottomInset(windowInsetsCompat) + marginLayoutParams.bottomMargin);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Nullable
    public TextView getMessageIconView() {
        return (TextView) findViewById(R.id.com_braze_inappmessage_slideup_icon);
    }

    @Nullable
    public ImageView getMessageImageView() {
        return this.inAppMessageImageView;
    }

    @Nullable
    public TextView getMessageTextView() {
        return (TextView) findViewById(R.id.com_braze_inappmessage_slideup_message);
    }

    public void resetMessageMargins(boolean z11) {
        ViewGroup.LayoutParams layoutParams;
        CharSequence text;
        boolean z12;
        super.resetMessageMargins(z11);
        TextView messageIconView = getMessageIconView();
        boolean z13 = false;
        if (!(messageIconView == null || (text = messageIconView.getText()) == null)) {
            if (text.length() == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                z13 = true;
            }
        }
        boolean z14 = !z13;
        if (!z11 && z14) {
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.com_braze_inappmessage_slideup_image_layout);
            if (relativeLayout != null) {
                ViewUtils.removeViewFromParent(relativeLayout);
            }
            TextView textView = (TextView) findViewById(R.id.com_braze_inappmessage_slideup_message);
            if (textView == null) {
                layoutParams = null;
            } else {
                layoutParams = textView.getLayoutParams();
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (layoutParams2 != null) {
                layoutParams2.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.com_braze_inappmessage_slideup_left_message_margin_no_image);
            }
            textView.setLayoutParams(layoutParams2);
        }
    }

    public void setMessageBackgroundColor(int i11) {
        Drawable drawable;
        View messageBackgroundObject = getMessageBackgroundObject();
        if (messageBackgroundObject == null) {
            drawable = null;
        } else {
            drawable = messageBackgroundObject.getBackground();
        }
        if (drawable instanceof GradientDrawable) {
            View messageBackgroundObject2 = getMessageBackgroundObject();
            if (messageBackgroundObject2 != null) {
                InAppMessageViewUtils.setViewBackgroundColorFilter(messageBackgroundObject2, i11);
                return;
            }
            return;
        }
        super.setMessageBackgroundColor(i11);
    }

    public final void setMessageChevron(int i11, @NotNull ClickAction clickAction) {
        Intrinsics.checkNotNullParameter(clickAction, "clickAction");
        if (clickAction == ClickAction.NONE) {
            View messageChevronView = getMessageChevronView();
            if (messageChevronView != null) {
                messageChevronView.setVisibility(8);
                return;
            }
            return;
        }
        View messageChevronView2 = getMessageChevronView();
        if (messageChevronView2 != null) {
            InAppMessageViewUtils.setViewBackgroundColorFilter(messageChevronView2, i11);
        }
    }

    @Nullable
    public View getMessageBackgroundObject() {
        return findViewById(R.id.com_braze_inappmessage_slideup_container);
    }
}
