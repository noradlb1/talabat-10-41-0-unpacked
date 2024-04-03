package r3;

import com.braze.brazeplugin.BrazePlugin;
import java.util.HashMap;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BrazePlugin f44385b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HashMap f44386c;

    public /* synthetic */ b(BrazePlugin brazePlugin, HashMap hashMap) {
        this.f44385b = brazePlugin;
        this.f44386c = hashMap;
    }

    public final void run() {
        BrazePlugin.m9195handleSdkAuthenticationError$lambda2(this.f44385b, this.f44386c);
    }
}
