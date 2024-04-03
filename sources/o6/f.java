package o6;

import com.facebook.appevents.codeless.ViewIndexer;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34612b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewIndexer f34613c;

    public /* synthetic */ f(String str, ViewIndexer viewIndexer) {
        this.f34612b = str;
        this.f34613c = viewIndexer;
    }

    public final void run() {
        ViewIndexer.m8909sendToServer$lambda1(this.f34612b, this.f34613c);
    }
}
