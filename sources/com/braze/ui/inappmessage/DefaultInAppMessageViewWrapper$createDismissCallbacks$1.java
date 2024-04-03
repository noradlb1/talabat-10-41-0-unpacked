package com.braze.ui.inappmessage;

import android.view.View;
import com.braze.ui.inappmessage.listeners.SwipeDismissTouchListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"com/braze/ui/inappmessage/DefaultInAppMessageViewWrapper$createDismissCallbacks$1", "Lcom/braze/ui/inappmessage/listeners/SwipeDismissTouchListener$DismissCallbacks;", "canDismiss", "", "token", "", "onDismiss", "", "view", "Landroid/view/View;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultInAppMessageViewWrapper$createDismissCallbacks$1 implements SwipeDismissTouchListener.DismissCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultInAppMessageViewWrapper f44085a;

    public DefaultInAppMessageViewWrapper$createDismissCallbacks$1(DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper) {
        this.f44085a = defaultInAppMessageViewWrapper;
    }

    public boolean canDismiss(@Nullable Object obj) {
        return true;
    }

    public void onDismiss(@NotNull View view, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f44085a.getInAppMessage().setAnimateOut(false);
        BrazeInAppMessageManager.Companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
    }
}
