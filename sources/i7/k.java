package i7;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f35468b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f35469c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f35470d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f35471e;

    public /* synthetic */ k(AudioRendererEventListener.EventDispatcher eventDispatcher, int i11, long j11, long j12) {
        this.f35468b = eventDispatcher;
        this.f35469c = i11;
        this.f35470d = j11;
        this.f35471e = j12;
    }

    public final void run() {
        this.f35468b.lambda$underrun$4(this.f35469c, this.f35470d, this.f35471e);
    }
}
