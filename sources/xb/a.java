package xb;

import android.content.Context;
import com.instabug.bug.BugPlugin;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BugPlugin f47260b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f47261c;

    public /* synthetic */ a(BugPlugin bugPlugin, Context context) {
        this.f47260b = bugPlugin;
        this.f47261c = context;
    }

    public final void run() {
        this.f47260b.lambda$start$0(this.f47261c);
    }
}
