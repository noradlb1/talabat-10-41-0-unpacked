package r3;

import com.braze.brazeplugin.BrazePlugin;
import com.braze.events.BrazeSdkAuthenticationErrorEvent;
import com.braze.events.IEventSubscriber;

public final /* synthetic */ class a implements IEventSubscriber {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BrazePlugin f44384a;

    public /* synthetic */ a(BrazePlugin brazePlugin) {
        this.f44384a = brazePlugin;
    }

    public final void trigger(Object obj) {
        BrazePlugin.m9196initPlugin$lambda0(this.f44384a, (BrazeSdkAuthenticationErrorEvent) obj);
    }
}
