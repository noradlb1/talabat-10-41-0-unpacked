package n8;

import com.google.android.exoplayer2.util.ListenerSet;
import java.util.concurrent.CopyOnWriteArraySet;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CopyOnWriteArraySet f35530b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f35531c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ListenerSet.Event f35532d;

    public /* synthetic */ d(CopyOnWriteArraySet copyOnWriteArraySet, int i11, ListenerSet.Event event) {
        this.f35530b = copyOnWriteArraySet;
        this.f35531c = i11;
        this.f35532d = event;
    }

    public final void run() {
        ListenerSet.lambda$queueEvent$0(this.f35530b, this.f35531c, this.f35532d);
    }
}
