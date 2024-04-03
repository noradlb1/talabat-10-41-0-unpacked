package r3;

import com.braze.brazeplugin.BrazePlugin;
import java.util.HashMap;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BrazePlugin f44387b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HashMap f44388c;

    public /* synthetic */ c(BrazePlugin brazePlugin, HashMap hashMap) {
        this.f44387b = brazePlugin;
        this.f44388c = hashMap;
    }

    public final void run() {
        BrazePlugin.Companion.m9197processContentCards$lambda1(this.f44387b, this.f44388c);
    }
}
