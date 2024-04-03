package v7;

import android.media.MediaCodec;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter;

public final /* synthetic */ class l implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SynchronousMediaCodecAdapter f35577a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodecAdapter.OnFrameRenderedListener f35578b;

    public /* synthetic */ l(SynchronousMediaCodecAdapter synchronousMediaCodecAdapter, MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener) {
        this.f35577a = synchronousMediaCodecAdapter;
        this.f35578b = onFrameRenderedListener;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j11, long j12) {
        this.f35577a.lambda$setOnFrameRenderedListener$0(this.f35578b, mediaCodec, j11, j12);
    }
}
