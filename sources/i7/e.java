package i7;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f35455b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f35456c;

    public /* synthetic */ e(AudioRendererEventListener.EventDispatcher eventDispatcher, String str) {
        this.f35455b = eventDispatcher;
        this.f35456c = str;
    }

    public final void run() {
        this.f35455b.lambda$decoderReleased$5(this.f35456c);
    }
}
