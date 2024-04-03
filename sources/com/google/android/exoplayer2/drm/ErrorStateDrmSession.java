package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Map;
import java.util.UUID;

public final class ErrorStateDrmSession implements DrmSession {
    private final DrmSession.DrmSessionException error;

    public ErrorStateDrmSession(DrmSession.DrmSessionException drmSessionException) {
        this.error = (DrmSession.DrmSessionException) Assertions.checkNotNull(drmSessionException);
    }

    public void acquire(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }

    @Nullable
    public CryptoConfig getCryptoConfig() {
        return null;
    }

    @Nullable
    public DrmSession.DrmSessionException getError() {
        return this.error;
    }

    @Nullable
    public byte[] getOfflineLicenseKeySetId() {
        return null;
    }

    public final UUID getSchemeUuid() {
        return C.UUID_NIL;
    }

    public int getState() {
        return 1;
    }

    public boolean playClearSamplesWithoutKeys() {
        return false;
    }

    @Nullable
    public Map<String, String> queryKeyStatus() {
        return null;
    }

    public void release(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }

    public boolean requiresSecureDecoder(String str) {
        return false;
    }
}
