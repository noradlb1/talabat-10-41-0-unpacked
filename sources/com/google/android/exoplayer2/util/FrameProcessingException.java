package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.C;

public final class FrameProcessingException extends Exception {
    public final long presentationTimeUs;

    public FrameProcessingException(String str) {
        this(str, (long) C.TIME_UNSET);
    }

    public static FrameProcessingException from(Exception exc) {
        return from(exc, C.TIME_UNSET);
    }

    public FrameProcessingException(String str, long j11) {
        super(str);
        this.presentationTimeUs = j11;
    }

    public static FrameProcessingException from(Exception exc, long j11) {
        if (exc instanceof FrameProcessingException) {
            return (FrameProcessingException) exc;
        }
        return new FrameProcessingException((Throwable) exc, j11);
    }

    public FrameProcessingException(String str, Throwable th2) {
        this(str, th2, C.TIME_UNSET);
    }

    public FrameProcessingException(String str, Throwable th2, long j11) {
        super(str, th2);
        this.presentationTimeUs = j11;
    }

    public FrameProcessingException(Throwable th2) {
        this(th2, (long) C.TIME_UNSET);
    }

    public FrameProcessingException(Throwable th2, long j11) {
        super(th2);
        this.presentationTimeUs = j11;
    }
}
