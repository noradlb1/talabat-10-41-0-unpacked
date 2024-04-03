package r3;

import com.braze.brazeplugin.BrazePlugin;
import java.util.HashMap;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BrazePlugin f44389b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HashMap f44390c;

    public /* synthetic */ d(BrazePlugin brazePlugin, HashMap hashMap) {
        this.f44389b = brazePlugin;
        this.f44390c = hashMap;
    }

    public final void run() {
        BrazePlugin.Companion.m9198processInAppMessage$lambda0(this.f44389b, this.f44390c);
    }
}
