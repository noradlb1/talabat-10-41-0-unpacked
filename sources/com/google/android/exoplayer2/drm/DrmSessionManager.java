package com.google.android.exoplayer2.drm;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import k7.l;
import k7.m;

public interface DrmSessionManager {
    public static final DrmSessionManager DRM_UNSUPPORTED;
    @Deprecated
    public static final DrmSessionManager DUMMY;

    public interface DrmSessionReference {
        public static final DrmSessionReference EMPTY = new m();

        void release();
    }

    static {
        AnonymousClass1 r02 = new DrmSessionManager() {
            @Nullable
            public DrmSession acquireSession(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
                if (format.drmInitData == null) {
                    return null;
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), 6001));
            }

            public int getCryptoType(Format format) {
                return format.drmInitData != null ? 1 : 0;
            }

            public /* synthetic */ DrmSessionReference preacquireSession(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
                return l.a(this, eventDispatcher, format);
            }

            public /* synthetic */ void prepare() {
                l.b(this);
            }

            public /* synthetic */ void release() {
                l.c(this);
            }

            public void setPlayer(Looper looper, PlayerId playerId) {
            }
        };
        DRM_UNSUPPORTED = r02;
        DUMMY = r02;
    }

    @Nullable
    DrmSession acquireSession(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    int getCryptoType(Format format);

    DrmSessionReference preacquireSession(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    void prepare();

    void release();

    void setPlayer(Looper looper, PlayerId playerId);
}
