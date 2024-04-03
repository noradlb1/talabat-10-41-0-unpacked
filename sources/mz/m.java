package mz;

import com.uxcam.internals.ip;
import com.uxcam.internals.iq;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ip f23979b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f23980c;

    public /* synthetic */ m(ip ipVar, String str) {
        this.f23979b = ipVar;
        this.f23980c = str;
    }

    public final void run() {
        ((iq) this.f23979b).a(this.f23980c);
    }
}
