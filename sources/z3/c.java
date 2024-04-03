package z3;

import com.braze.events.IEventSubscriber;
import com.braze.events.InAppMessageEvent;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;

public final /* synthetic */ class c implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BrazeInAppMessageManager f44456a;

    public /* synthetic */ c(BrazeInAppMessageManager brazeInAppMessageManager) {
        this.f44456a = brazeInAppMessageManager;
    }

    public final void trigger(Object obj) {
        BrazeInAppMessageManager.m9206createInAppMessageEventSubscriber$lambda8(this.f44456a, (InAppMessageEvent) obj);
    }
}
