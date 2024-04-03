package com.talabat.talabatcommon.utils;

import com.google.android.exoplayer2.ExoPlayer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/utils/AnimationSpeed;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "FAST", "NORMAL", "SLOW", "VERY_SLOW", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum AnimationSpeed {
    FAST(200),
    NORMAL(400),
    SLOW(600),
    VERY_SLOW(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    
    private final long value;

    private AnimationSpeed(long j11) {
        this.value = j11;
    }

    public final long getValue() {
        return this.value;
    }
}
