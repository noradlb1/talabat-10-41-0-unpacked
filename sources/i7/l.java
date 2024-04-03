package i7;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f35472b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f35473c;

    public /* synthetic */ l(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.f35472b = eventDispatcher;
        this.f35473c = exc;
    }

    public final void run() {
        this.f35472b.lambda$audioSinkError$8(this.f35473c);
    }
}
