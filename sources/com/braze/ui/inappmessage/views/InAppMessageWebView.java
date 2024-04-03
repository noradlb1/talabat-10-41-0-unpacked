package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageWebView;", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "onKeyDown", "keyCode", "", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class InAppMessageWebView extends WebView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InAppMessageWebView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public boolean dispatchKeyEvent(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (isInTouchMode() || keyEvent.getKeyCode() != 4 || !BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
        return true;
    }

    public boolean onKeyDown(int i11, @NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (i11 != 4 || !BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()) {
            return super.onKeyDown(i11, keyEvent);
        }
        InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
        return true;
    }
}
