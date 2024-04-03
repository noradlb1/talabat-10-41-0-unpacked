package i7;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f35460b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f35461c;

    public /* synthetic */ g(AudioRendererEventListener.EventDispatcher eventDispatcher, boolean z11) {
        this.f35460b = eventDispatcher;
        this.f35461c = z11;
    }

    public final void run() {
        this.f35460b.lambda$skipSilenceEnabledChanged$7(this.f35461c);
    }
}
