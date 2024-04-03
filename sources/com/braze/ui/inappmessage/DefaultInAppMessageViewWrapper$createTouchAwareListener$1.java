package com.braze.ui.inappmessage;

import com.braze.enums.inappmessage.DismissType;
import com.braze.ui.inappmessage.listeners.TouchAwareSwipeDismissTouchListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/braze/ui/inappmessage/DefaultInAppMessageViewWrapper$createTouchAwareListener$1", "Lcom/braze/ui/inappmessage/listeners/TouchAwareSwipeDismissTouchListener$ITouchListener;", "onTouchEnded", "", "onTouchStartedOrContinued", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultInAppMessageViewWrapper$createTouchAwareListener$1 implements TouchAwareSwipeDismissTouchListener.ITouchListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultInAppMessageViewWrapper f44086a;

    public DefaultInAppMessageViewWrapper$createTouchAwareListener$1(DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper) {
        this.f44086a = defaultInAppMessageViewWrapper;
    }

    public void onTouchEnded() {
        if (this.f44086a.getInAppMessage().getDismissType() == DismissType.AUTO_DISMISS) {
            this.f44086a.addDismissRunnable();
        }
    }

    public void onTouchStartedOrContinued() {
        this.f44086a.getInAppMessageView().removeCallbacks(this.f44086a.getDismissRunnable());
    }
}
