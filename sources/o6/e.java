package o6;

import com.facebook.appevents.codeless.ViewIndexer;
import java.util.TimerTask;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewIndexer f34610b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TimerTask f34611c;

    public /* synthetic */ e(ViewIndexer viewIndexer, TimerTask timerTask) {
        this.f34610b = viewIndexer;
        this.f34611c = timerTask;
    }

    public final void run() {
        ViewIndexer.m8908schedule$lambda0(this.f34610b, this.f34611c);
    }
}
