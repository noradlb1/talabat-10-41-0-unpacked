package com.braze.ui.inappmessage.listeners;

import android.os.Bundle;
import c4.a;
import com.braze.models.inappmessage.IInAppMessage;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/braze/ui/inappmessage/listeners/DefaultHtmlInAppMessageActionListener;", "Lcom/braze/ui/inappmessage/listeners/IHtmlInAppMessageActionListener;", "()V", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class DefaultHtmlInAppMessageActionListener implements IHtmlInAppMessageActionListener {
    public /* synthetic */ void onCloseClicked(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        a.a(this, iInAppMessage, str, bundle);
    }

    public /* synthetic */ boolean onCustomEventFired(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        return a.b(this, iInAppMessage, str, bundle);
    }

    public /* synthetic */ boolean onNewsfeedClicked(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        return a.c(this, iInAppMessage, str, bundle);
    }

    public /* synthetic */ boolean onOtherUrlAction(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        return a.d(this, iInAppMessage, str, bundle);
    }
}
