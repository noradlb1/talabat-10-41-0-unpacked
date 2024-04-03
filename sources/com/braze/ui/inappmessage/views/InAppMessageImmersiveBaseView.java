package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import com.appboy.ui.R;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.models.inappmessage.MessageButton;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.utils.InAppMessageButtonViewUtils;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.support.ViewUtils;
import d4.b;
import d4.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0016J\u0016\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0017H\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006/"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageImmersiveBaseView;", "Lcom/braze/ui/inappmessage/views/InAppMessageBaseView;", "Lcom/braze/ui/inappmessage/views/IInAppMessageImmersiveView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "frameView", "Landroid/view/View;", "getFrameView", "()Landroid/view/View;", "messageHeaderTextView", "Landroid/widget/TextView;", "getMessageHeaderTextView", "()Landroid/widget/TextView;", "messageTextView", "getMessageTextView", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "getMessageButtonViews", "", "numButtons", "", "onKeyDown", "keyCode", "resetMessageMargins", "", "imageRetrievalSuccessful", "setFrameColor", "color", "setLargerCloseButtonClickArea", "closeButtonView", "setMessageButtons", "messageButtons", "Lcom/braze/models/inappmessage/MessageButton;", "setMessageCloseButtonColor", "setMessageHeaderText", "text", "", "setMessageHeaderTextAlignment", "textAlign", "Lcom/braze/enums/inappmessage/TextAlign;", "setMessageHeaderTextColor", "setupDirectionalNavigation", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class InAppMessageImmersiveBaseView extends InAppMessageBaseView implements IInAppMessageImmersiveView {
    public InAppMessageImmersiveBaseView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    /* renamed from: setLargerCloseButtonClickArea$lambda-5  reason: not valid java name */
    public static final void m9219setLargerCloseButtonClickArea$lambda5(View view, InAppMessageImmersiveBaseView inAppMessageImmersiveBaseView, ViewParent viewParent) {
        Intrinsics.checkNotNullParameter(inAppMessageImmersiveBaseView, "this$0");
        Rect rect = new Rect();
        view.getHitRect(rect);
        int dimensionPixelSize = inAppMessageImmersiveBaseView.getContext().getResources().getDimensionPixelSize(R.dimen.com_braze_inappmessage_close_button_click_area_width);
        int dimensionPixelSize2 = inAppMessageImmersiveBaseView.getContext().getResources().getDimensionPixelSize(R.dimen.com_braze_inappmessage_close_button_click_area_height);
        int width = (dimensionPixelSize - rect.width()) / 2;
        int height = (dimensionPixelSize2 - rect.height()) / 2;
        rect.top -= height;
        rect.bottom += height;
        rect.left -= width;
        rect.right += width;
        ((View) viewParent).setTouchDelegate(new TouchDelegate(rect, view));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupDirectionalNavigation$lambda-0  reason: not valid java name */
    public static final void m9220setupDirectionalNavigation$lambda0(View view) {
        view.requestFocus();
    }

    public boolean dispatchKeyEvent(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (isInTouchMode() || keyEvent.getKeyCode() != 4 || !BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
        return true;
    }

    @Nullable
    public abstract View getFrameView();

    @NotNull
    public abstract List<View> getMessageButtonViews(int i11);

    @Nullable
    public abstract TextView getMessageHeaderTextView();

    @Nullable
    public abstract TextView getMessageTextView();

    public boolean onKeyDown(int i11, @NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (i11 != 4 || !BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()) {
            return super.onKeyDown(i11, keyEvent);
        }
        InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
        return true;
    }

    public void resetMessageMargins(boolean z11) {
        CharSequence charSequence;
        super.resetMessageMargins(z11);
        TextView messageTextView = getMessageTextView();
        CharSequence charSequence2 = null;
        if (messageTextView == null) {
            charSequence = null;
        } else {
            charSequence = messageTextView.getText();
        }
        if (StringsKt__StringsJVMKt.isBlank(String.valueOf(charSequence))) {
            ViewUtils.removeViewFromParent(getMessageTextView());
        }
        TextView messageHeaderTextView = getMessageHeaderTextView();
        if (messageHeaderTextView != null) {
            charSequence2 = messageHeaderTextView.getText();
        }
        if (StringsKt__StringsJVMKt.isBlank(String.valueOf(charSequence2))) {
            ViewUtils.removeViewFromParent(getMessageHeaderTextView());
        }
        InAppMessageViewUtils.resetMessageMarginsIfNecessary(getMessageTextView(), getMessageHeaderTextView());
    }

    public void setFrameColor(int i11) {
        View frameView = getFrameView();
        if (frameView != null) {
            InAppMessageViewUtils.setFrameColor(frameView, Integer.valueOf(i11));
        }
    }

    public void setLargerCloseButtonClickArea(@Nullable View view) {
        if (view == null || view.getParent() == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) InAppMessageImmersiveBaseView$setLargerCloseButtonClickArea$1.INSTANCE, 6, (Object) null);
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            ((View) parent).post(new c(view, this, parent));
        }
    }

    public void setMessageButtons(@NotNull List<? extends MessageButton> list) {
        Intrinsics.checkNotNullParameter(list, "messageButtons");
        InAppMessageButtonViewUtils.setButtons(getMessageButtonViews(list.size()), list);
    }

    public void setMessageCloseButtonColor(int i11) {
        View messageCloseButtonView = getMessageCloseButtonView();
        if (messageCloseButtonView != null) {
            InAppMessageViewUtils.setViewBackgroundColorFilter(messageCloseButtonView, i11);
        }
    }

    public void setMessageHeaderText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView messageHeaderTextView = getMessageHeaderTextView();
        if (messageHeaderTextView != null) {
            messageHeaderTextView.setText(str);
        }
    }

    public void setMessageHeaderTextAlignment(@NotNull TextAlign textAlign) {
        Intrinsics.checkNotNullParameter(textAlign, TtmlNode.ATTR_TTS_TEXT_ALIGN);
        TextView messageHeaderTextView = getMessageHeaderTextView();
        if (messageHeaderTextView != null) {
            InAppMessageViewUtils.setTextAlignment(messageHeaderTextView, textAlign);
        }
    }

    public void setMessageHeaderTextColor(int i11) {
        TextView messageHeaderTextView = getMessageHeaderTextView();
        if (messageHeaderTextView != null) {
            InAppMessageViewUtils.setTextViewColor(messageHeaderTextView, i11);
        }
    }

    public void setupDirectionalNavigation(int i11) {
        Integer num;
        List<View> messageButtonViews = getMessageButtonViews(i11);
        View messageCloseButtonView = getMessageCloseButtonView();
        if (messageCloseButtonView == null) {
            num = null;
        } else {
            num = Integer.valueOf(messageCloseButtonView.getId());
        }
        if (num == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) InAppMessageImmersiveBaseView$setupDirectionalNavigation$1.INSTANCE, 6, (Object) null);
            return;
        }
        if (i11 == 0) {
            messageCloseButtonView.setNextFocusUpId(num.intValue());
            messageCloseButtonView.setNextFocusDownId(num.intValue());
            messageCloseButtonView.setNextFocusRightId(num.intValue());
            messageCloseButtonView.setNextFocusLeftId(num.intValue());
        } else if (i11 == 1) {
            View view = messageButtonViews.get(0);
            Integer valueOf = Integer.valueOf(view.getId());
            view.setNextFocusLeftId(num.intValue());
            view.setNextFocusRightId(num.intValue());
            view.setNextFocusUpId(num.intValue());
            view.setNextFocusDownId(num.intValue());
            messageCloseButtonView.setNextFocusUpId(valueOf.intValue());
            messageCloseButtonView.setNextFocusDownId(valueOf.intValue());
            messageCloseButtonView.setNextFocusRightId(valueOf.intValue());
            messageCloseButtonView.setNextFocusLeftId(valueOf.intValue());
            messageCloseButtonView = view;
            num = valueOf;
        } else if (i11 != 2) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new InAppMessageImmersiveBaseView$setupDirectionalNavigation$2(i11), 6, (Object) null);
        } else {
            View view2 = messageButtonViews.get(1);
            View view3 = messageButtonViews.get(0);
            Integer valueOf2 = Integer.valueOf(view2.getId());
            Integer valueOf3 = Integer.valueOf(view3.getId());
            view2.setNextFocusLeftId(valueOf3.intValue());
            view2.setNextFocusRightId(valueOf3.intValue());
            view2.setNextFocusUpId(num.intValue());
            view2.setNextFocusDownId(num.intValue());
            view3.setNextFocusLeftId(valueOf2.intValue());
            view3.setNextFocusRightId(valueOf2.intValue());
            view3.setNextFocusUpId(num.intValue());
            view3.setNextFocusDownId(num.intValue());
            messageCloseButtonView.setNextFocusUpId(valueOf2.intValue());
            messageCloseButtonView.setNextFocusDownId(valueOf2.intValue());
            messageCloseButtonView.setNextFocusRightId(valueOf2.intValue());
            messageCloseButtonView.setNextFocusLeftId(valueOf3.intValue());
            messageCloseButtonView = view2;
            num = valueOf2;
        }
        setNextFocusUpId(num.intValue());
        setNextFocusDownId(num.intValue());
        setNextFocusRightId(num.intValue());
        setNextFocusLeftId(num.intValue());
        if (Build.VERSION.SDK_INT >= 26 && messageCloseButtonView != null) {
            messageCloseButtonView.setFocusedByDefault(true);
        }
        if (messageCloseButtonView != null) {
            messageCloseButtonView.post(new b(messageCloseButtonView));
        }
    }
}
