package com.google.android.exoplayer2.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import k7.a0;
import k7.b0;
import k7.e;
import k7.x;
import k7.y;
import k7.z;

@RequiresApi(18)
public final class OfflineLicenseHelper {
    private static final Format FORMAT_WITH_EMPTY_DRM_INIT_DATA = new Format.Builder().setDrmInitData(new DrmInitData(new DrmInitData.SchemeData[0])).build();
    /* access modifiers changed from: private */
    public final ConditionVariable drmListenerConditionVariable;
    private final DefaultDrmSessionManager drmSessionManager;
    private final DrmSessionEventListener.EventDispatcher eventDispatcher;
    private final Handler handler;
    private final HandlerThread handlerThread;

    @Deprecated
    public OfflineLicenseHelper(UUID uuid, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, @Nullable Map<String, String> map, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        this(new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(uuid, provider).setKeyRequestParameters(map).build(mediaDrmCallback), eventDispatcher2);
    }

    private DrmSession acquireFirstSessionOnHandlerThread(int i11, @Nullable byte[] bArr, Format format) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(format.drmInitData);
        SettableFuture create = SettableFuture.create();
        this.drmListenerConditionVariable.close();
        this.handler.post(new x(this, i11, bArr, create, format));
        try {
            DrmSession drmSession = (DrmSession) create.get();
            this.drmListenerConditionVariable.block();
            SettableFuture create2 = SettableFuture.create();
            this.handler.post(new y(this, drmSession, create2));
            try {
                DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) create2.get();
                if (drmSessionException == null) {
                    return drmSession;
                }
                throw drmSessionException;
            } catch (InterruptedException | ExecutionException e11) {
                throw new IllegalStateException(e11);
            }
        } catch (InterruptedException | ExecutionException e12) {
            throw new IllegalStateException(e12);
        }
    }

    private byte[] acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread(int i11, @Nullable byte[] bArr, Format format) throws DrmSession.DrmSessionException {
        DrmSession acquireFirstSessionOnHandlerThread = acquireFirstSessionOnHandlerThread(i11, bArr, format);
        SettableFuture create = SettableFuture.create();
        this.handler.post(new z(this, create, acquireFirstSessionOnHandlerThread));
        try {
            byte[] bArr2 = (byte[]) Assertions.checkNotNull((byte[]) create.get());
            releaseManagerOnHandlerThread();
            return bArr2;
        } catch (InterruptedException | ExecutionException e11) {
            throw new IllegalStateException(e11);
        } catch (Throwable th2) {
            releaseManagerOnHandlerThread();
            throw th2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$acquireFirstSessionOnHandlerThread$2(int i11, byte[] bArr, SettableFuture settableFuture, Format format) {
        try {
            this.drmSessionManager.setPlayer((Looper) Assertions.checkNotNull(Looper.myLooper()), PlayerId.UNSET);
            this.drmSessionManager.prepare();
            this.drmSessionManager.setMode(i11, bArr);
            settableFuture.set((DrmSession) Assertions.checkNotNull(this.drmSessionManager.acquireSession(this.eventDispatcher, format)));
        } catch (Throwable th2) {
            settableFuture.setException(th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$acquireFirstSessionOnHandlerThread$3(DrmSession drmSession, SettableFuture settableFuture) {
        try {
            DrmSession.DrmSessionException error = drmSession.getError();
            if (drmSession.getState() == 1) {
                drmSession.release(this.eventDispatcher);
                this.drmSessionManager.release();
            }
            settableFuture.set(error);
        } catch (Throwable th2) {
            settableFuture.setException(th2);
            drmSession.release(this.eventDispatcher);
            this.drmSessionManager.release();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread$1(SettableFuture settableFuture, DrmSession drmSession) {
        try {
            settableFuture.set(drmSession.getOfflineLicenseKeySetId());
        } catch (Throwable th2) {
            drmSession.release(this.eventDispatcher);
            throw th2;
        }
        drmSession.release(this.eventDispatcher);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getLicenseDurationRemainingSec$0(SettableFuture settableFuture, DrmSession drmSession) {
        try {
            settableFuture.set((Pair) Assertions.checkNotNull(WidevineUtil.getLicenseDurationRemainingSec(drmSession)));
        } catch (Throwable th2) {
            drmSession.release(this.eventDispatcher);
            throw th2;
        }
        drmSession.release(this.eventDispatcher);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$releaseManagerOnHandlerThread$4(SettableFuture settableFuture) {
        try {
            this.drmSessionManager.release();
            settableFuture.set(null);
        } catch (Throwable th2) {
            settableFuture.setException(th2);
        }
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, DataSource.Factory factory, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        return newWidevineInstance(str, false, factory, eventDispatcher2);
    }

    private void releaseManagerOnHandlerThread() {
        SettableFuture create = SettableFuture.create();
        this.handler.post(new b0(this, create));
        try {
            create.get();
        } catch (InterruptedException | ExecutionException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public synchronized byte[] downloadLicense(Format format) throws DrmSession.DrmSessionException {
        boolean z11;
        if (format.drmInitData != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        return acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread(2, (byte[]) null, format);
    }

    public synchronized Pair<Long, Long> getLicenseDurationRemainingSec(byte[] bArr) throws DrmSession.DrmSessionException {
        Pair<Long, Long> pair;
        Assertions.checkNotNull(bArr);
        try {
            DrmSession acquireFirstSessionOnHandlerThread = acquireFirstSessionOnHandlerThread(1, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
            SettableFuture create = SettableFuture.create();
            this.handler.post(new a0(this, create, acquireFirstSessionOnHandlerThread));
            pair = (Pair) create.get();
            releaseManagerOnHandlerThread();
        } catch (DrmSession.DrmSessionException e11) {
            if (e11.getCause() instanceof KeysExpiredException) {
                return Pair.create(0L, 0L);
            }
            throw e11;
        } catch (InterruptedException | ExecutionException e12) {
            throw new IllegalStateException(e12);
        } catch (Throwable th2) {
            releaseManagerOnHandlerThread();
            throw th2;
        }
        return pair;
    }

    public void release() {
        this.handlerThread.quit();
    }

    public synchronized void releaseLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread(3, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
    }

    public synchronized byte[] renewLicense(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.checkNotNull(bArr);
        return acquireSessionAndGetOfflineLicenseKeySetIdOnHandlerThread(2, bArr, FORMAT_WITH_EMPTY_DRM_INIT_DATA);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, boolean z11, DataSource.Factory factory, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        return newWidevineInstance(str, z11, factory, (Map<String, String>) null, eventDispatcher2);
    }

    public static OfflineLicenseHelper newWidevineInstance(String str, boolean z11, DataSource.Factory factory, @Nullable Map<String, String> map, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        return new OfflineLicenseHelper(new DefaultDrmSessionManager.Builder().setKeyRequestParameters(map).build(new HttpMediaDrmCallback(str, z11, factory)), eventDispatcher2);
    }

    public OfflineLicenseHelper(DefaultDrmSessionManager defaultDrmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher2) {
        this.drmSessionManager = defaultDrmSessionManager;
        this.eventDispatcher = eventDispatcher2;
        HandlerThread handlerThread2 = new HandlerThread("ExoPlayer:OfflineLicenseHelper");
        this.handlerThread = handlerThread2;
        handlerThread2.start();
        this.handler = new Handler(handlerThread2.getLooper());
        this.drmListenerConditionVariable = new ConditionVariable();
        eventDispatcher2.addEventListener(new Handler(handlerThread2.getLooper()), new DrmSessionEventListener() {
            public void onDrmKeysLoaded(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.drmListenerConditionVariable.open();
            }

            public void onDrmKeysRemoved(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.drmListenerConditionVariable.open();
            }

            public void onDrmKeysRestored(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.drmListenerConditionVariable.open();
            }

            public /* synthetic */ void onDrmSessionAcquired(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
                e.d(this, i11, mediaPeriodId);
            }

            public /* synthetic */ void onDrmSessionAcquired(int i11, MediaSource.MediaPeriodId mediaPeriodId, int i12) {
                e.e(this, i11, mediaPeriodId, i12);
            }

            public void onDrmSessionManagerError(int i11, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
                OfflineLicenseHelper.this.drmListenerConditionVariable.open();
            }

            public /* synthetic */ void onDrmSessionReleased(int i11, MediaSource.MediaPeriodId mediaPeriodId) {
                e.g(this, i11, mediaPeriodId);
            }
        });
    }
}
