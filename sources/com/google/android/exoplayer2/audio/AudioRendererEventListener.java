package com.google.android.exoplayer2.audio;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import i7.e;
import i7.f;
import i7.g;
import i7.h;
import i7.i;
import i7.j;
import i7.k;
import i7.l;
import i7.m;
import i7.n;

public interface AudioRendererEventListener {

    public static final class EventDispatcher {
        @Nullable
        private final Handler handler;
        @Nullable
        private final AudioRendererEventListener listener;

        public EventDispatcher(@Nullable Handler handler2, @Nullable AudioRendererEventListener audioRendererEventListener) {
            Handler handler3;
            if (audioRendererEventListener != null) {
                handler3 = (Handler) Assertions.checkNotNull(handler2);
            } else {
                handler3 = null;
            }
            this.handler = handler3;
            this.listener = audioRendererEventListener;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$audioCodecError$9(Exception exc) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioCodecError(exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$audioSinkError$8(Exception exc) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioSinkError(exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$decoderInitialized$1(String str, long j11, long j12) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDecoderInitialized(str, j11, j12);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$decoderReleased$5(String str) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDecoderReleased(str);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$disabled$6(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioDisabled(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$enabled$0(DecoderCounters decoderCounters) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioEnabled(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$inputFormatChanged$2(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioInputFormatChanged(format);
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioInputFormatChanged(format, decoderReuseEvaluation);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$positionAdvancing$3(long j11) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioPositionAdvancing(j11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$skipSilenceEnabledChanged$7(boolean z11) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onSkipSilenceEnabledChanged(z11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$underrun$4(int i11, long j11, long j12) {
            ((AudioRendererEventListener) Util.castNonNull(this.listener)).onAudioUnderrun(i11, j11, j12);
        }

        public void audioCodecError(Exception exc) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new m(this, exc));
            }
        }

        public void audioSinkError(Exception exc) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new l(this, exc));
            }
        }

        public void decoderInitialized(String str, long j11, long j12) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new n(this, str, j11, j12));
            }
        }

        public void decoderReleased(String str) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new e(this, str));
            }
        }

        public void disabled(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new i(this, decoderCounters));
            }
        }

        public void enabled(DecoderCounters decoderCounters) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new j(this, decoderCounters));
            }
        }

        public void inputFormatChanged(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new f(this, format, decoderReuseEvaluation));
            }
        }

        public void positionAdvancing(long j11) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new h(this, j11));
            }
        }

        public void skipSilenceEnabledChanged(boolean z11) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new g(this, z11));
            }
        }

        public void underrun(int i11, long j11, long j12) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new k(this, i11, j11, j12));
            }
        }
    }

    void onAudioCodecError(Exception exc);

    void onAudioDecoderInitialized(String str, long j11, long j12);

    void onAudioDecoderReleased(String str);

    void onAudioDisabled(DecoderCounters decoderCounters);

    void onAudioEnabled(DecoderCounters decoderCounters);

    @Deprecated
    void onAudioInputFormatChanged(Format format);

    void onAudioInputFormatChanged(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    void onAudioPositionAdvancing(long j11);

    void onAudioSinkError(Exception exc);

    void onAudioUnderrun(int i11, long j11, long j12);

    void onSkipSilenceEnabledChanged(boolean z11);
}
