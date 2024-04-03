package i7;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f35476b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f35477c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f35478d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f35479e;

    public /* synthetic */ n(AudioRendererEventListener.EventDispatcher eventDispatcher, String str, long j11, long j12) {
        this.f35476b = eventDispatcher;
        this.f35477c = str;
        this.f35478d = j11;
        this.f35479e = j12;
    }

    public final void run() {
        this.f35476b.lambda$decoderInitialized$1(this.f35477c, this.f35478d, this.f35479e);
    }
}
