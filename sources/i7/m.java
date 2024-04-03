package i7;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f35474b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f35475c;

    public /* synthetic */ m(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.f35474b = eventDispatcher;
        this.f35475c = exc;
    }

    public final void run() {
        this.f35474b.lambda$audioCodecError$9(this.f35475c);
    }
}
