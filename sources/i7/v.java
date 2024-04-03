package i7;

import android.media.AudioTrack;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.util.ConditionVariable;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioTrack f35480b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ConditionVariable f35481c;

    public /* synthetic */ v(AudioTrack audioTrack, ConditionVariable conditionVariable) {
        this.f35480b = audioTrack;
        this.f35481c = conditionVariable;
    }

    public final void run() {
        DefaultAudioSink.lambda$releaseAudioTrackAsync$0(this.f35480b, this.f35481c);
    }
}
