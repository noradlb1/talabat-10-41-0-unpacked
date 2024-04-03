package o8;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f35567b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f35568c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f35569d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f35570e;

    public /* synthetic */ q(VideoRendererEventListener.EventDispatcher eventDispatcher, String str, long j11, long j12) {
        this.f35567b = eventDispatcher;
        this.f35568c = str;
        this.f35569d = j11;
        this.f35570e = j12;
    }

    public final void run() {
        this.f35567b.lambda$decoderInitialized$1(this.f35568c, this.f35569d, this.f35570e);
    }
}
