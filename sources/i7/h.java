package i7;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f35462b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f35463c;

    public /* synthetic */ h(AudioRendererEventListener.EventDispatcher eventDispatcher, long j11) {
        this.f35462b = eventDispatcher;
        this.f35463c = j11;
    }

    public final void run() {
        this.f35462b.lambda$positionAdvancing$3(this.f35463c);
    }
}
