package z3;

import com.braze.events.IEventSubscriber;
import com.braze.events.SdkDataWipeEvent;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;

public final /* synthetic */ class a implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BrazeInAppMessageManager f44452a;

    public /* synthetic */ a(BrazeInAppMessageManager brazeInAppMessageManager) {
        this.f44452a = brazeInAppMessageManager;
    }

    public final void trigger(Object obj) {
        BrazeInAppMessageManager.m9208ensureSubscribedToInAppMessageEvents$lambda1(this.f44452a, (SdkDataWipeEvent) obj);
    }
}
