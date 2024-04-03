package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Consumer;
import com.google.android.exoplayer2.util.CopyOnWriteMultiset;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import k7.a;
import k7.b;
import k7.c;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@RequiresApi(18)
class DefaultDrmSession implements DrmSession {
    private static final int MAX_LICENSE_DURATION_TO_RENEW_SECONDS = 60;
    private static final int MSG_KEYS = 1;
    private static final int MSG_PROVISION = 0;
    private static final String TAG = "DefaultDrmSession";
    /* access modifiers changed from: private */
    public final MediaDrmCallback callback;
    @Nullable
    private CryptoConfig cryptoConfig;
    @Nullable
    private ExoMediaDrm.KeyRequest currentKeyRequest;
    @Nullable
    private ExoMediaDrm.ProvisionRequest currentProvisionRequest;
    private final CopyOnWriteMultiset<DrmSessionEventListener.EventDispatcher> eventDispatchers;
    private final boolean isPlaceholderSession;
    private final HashMap<String, String> keyRequestParameters;
    @Nullable
    private DrmSession.DrmSessionException lastException;
    /* access modifiers changed from: private */
    public final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final ExoMediaDrm mediaDrm;
    private final int mode;
    private byte[] offlineLicenseKeySetId;
    private final boolean playClearSamplesWithoutKeys;
    private final Looper playbackLooper;
    private final PlayerId playerId;
    private final ProvisioningManager provisioningManager;
    private int referenceCount;
    private final ReferenceCountListener referenceCountListener;
    @Nullable
    private RequestHandler requestHandler;
    @Nullable
    private HandlerThread requestHandlerThread;
    /* access modifiers changed from: private */
    public final ResponseHandler responseHandler;
    @Nullable
    public final List<DrmInitData.SchemeData> schemeDatas;
    @Nullable
    private byte[] sessionId;
    private int state;
    /* access modifiers changed from: private */
    public final UUID uuid;

    public interface ProvisioningManager {
        void onProvisionCompleted();

        void onProvisionError(Exception exc, boolean z11);

        void provisionRequired(DefaultDrmSession defaultDrmSession);
    }

    public interface ReferenceCountListener {
        void onReferenceCountDecremented(DefaultDrmSession defaultDrmSession, int i11);

        void onReferenceCountIncremented(DefaultDrmSession defaultDrmSession, int i11);
    }

    @SuppressLint({"HandlerLeak"})
    public class RequestHandler extends Handler {
        @GuardedBy("this")
        private boolean isReleased;

        public RequestHandler(Looper looper) {
            super(looper);
        }

        private boolean maybeRetryRequest(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            IOException iOException;
            MediaDrmCallbackException mediaDrmCallbackException2 = mediaDrmCallbackException;
            RequestTask requestTask = (RequestTask) message.obj;
            if (!requestTask.allowRetry) {
                return false;
            }
            int i11 = requestTask.errorCount + 1;
            requestTask.errorCount = i11;
            if (i11 > DefaultDrmSession.this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(3)) {
                return false;
            }
            LoadEventInfo loadEventInfo = new LoadEventInfo(requestTask.taskId, mediaDrmCallbackException2.dataSpec, mediaDrmCallbackException2.uriAfterRedirects, mediaDrmCallbackException2.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - requestTask.startTimeMs, mediaDrmCallbackException2.bytesLoaded);
            MediaLoadData mediaLoadData = new MediaLoadData(3);
            if (mediaDrmCallbackException.getCause() instanceof IOException) {
                iOException = (IOException) mediaDrmCallbackException.getCause();
            } else {
                iOException = new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause());
            }
            long retryDelayMsFor = DefaultDrmSession.this.loadErrorHandlingPolicy.getRetryDelayMsFor(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, mediaLoadData, iOException, requestTask.errorCount));
            if (retryDelayMsFor == C.TIME_UNSET) {
                return false;
            }
            synchronized (this) {
                if (this.isReleased) {
                    return false;
                }
                sendMessageDelayed(Message.obtain(message), retryDelayMsFor);
                return true;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.android.exoplayer2.drm.MediaDrmCallbackException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.google.android.exoplayer2.drm.MediaDrmCallbackException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.google.android.exoplayer2.drm.MediaDrmCallbackException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: byte[]} */
        /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.Throwable, java.lang.Exception] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r6.obj
                com.google.android.exoplayer2.drm.DefaultDrmSession$RequestTask r0 = (com.google.android.exoplayer2.drm.DefaultDrmSession.RequestTask) r0
                int r1 = r6.what     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                if (r1 == 0) goto L_0x0026
                r2 = 1
                if (r1 != r2) goto L_0x0020
                com.google.android.exoplayer2.drm.DefaultDrmSession r1 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                com.google.android.exoplayer2.drm.MediaDrmCallback r1 = r1.callback     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                com.google.android.exoplayer2.drm.DefaultDrmSession r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                java.util.UUID r2 = r2.uuid     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                java.lang.Object r3 = r0.request     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                com.google.android.exoplayer2.drm.ExoMediaDrm$KeyRequest r3 = (com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest) r3     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                byte[] r1 = r1.executeKeyRequest(r2, r3)     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                goto L_0x004c
            L_0x0020:
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                r1.<init>()     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                throw r1     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
            L_0x0026:
                com.google.android.exoplayer2.drm.DefaultDrmSession r1 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                com.google.android.exoplayer2.drm.MediaDrmCallback r1 = r1.callback     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                com.google.android.exoplayer2.drm.DefaultDrmSession r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                java.util.UUID r2 = r2.uuid     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                java.lang.Object r3 = r0.request     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                com.google.android.exoplayer2.drm.ExoMediaDrm$ProvisionRequest r3 = (com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest) r3     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                byte[] r1 = r1.executeProvisionRequest(r2, r3)     // Catch:{ MediaDrmCallbackException -> 0x0044, Exception -> 0x003b }
                goto L_0x004c
            L_0x003b:
                r1 = move-exception
                java.lang.String r2 = "DefaultDrmSession"
                java.lang.String r3 = "Key/provisioning request produced an unexpected exception. Not retrying."
                com.google.android.exoplayer2.util.Log.w(r2, r3, r1)
                goto L_0x004c
            L_0x0044:
                r1 = move-exception
                boolean r2 = r5.maybeRetryRequest(r6, r1)
                if (r2 == 0) goto L_0x004c
                return
            L_0x004c:
                com.google.android.exoplayer2.drm.DefaultDrmSession r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this
                com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r2 = r2.loadErrorHandlingPolicy
                long r3 = r0.taskId
                r2.onLoadTaskConcluded(r3)
                monitor-enter(r5)
                boolean r2 = r5.isReleased     // Catch:{ all -> 0x0073 }
                if (r2 != 0) goto L_0x0071
                com.google.android.exoplayer2.drm.DefaultDrmSession r2 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ all -> 0x0073 }
                com.google.android.exoplayer2.drm.DefaultDrmSession$ResponseHandler r2 = r2.responseHandler     // Catch:{ all -> 0x0073 }
                int r6 = r6.what     // Catch:{ all -> 0x0073 }
                java.lang.Object r0 = r0.request     // Catch:{ all -> 0x0073 }
                android.util.Pair r0 = android.util.Pair.create(r0, r1)     // Catch:{ all -> 0x0073 }
                android.os.Message r6 = r2.obtainMessage(r6, r0)     // Catch:{ all -> 0x0073 }
                r6.sendToTarget()     // Catch:{ all -> 0x0073 }
            L_0x0071:
                monitor-exit(r5)     // Catch:{ all -> 0x0073 }
                return
            L_0x0073:
                r6 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0073 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.DefaultDrmSession.RequestHandler.handleMessage(android.os.Message):void");
        }

        public void post(int i11, Object obj, boolean z11) {
            obtainMessage(i11, new RequestTask(LoadEventInfo.getNewId(), z11, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void release() {
            removeCallbacksAndMessages((Object) null);
            this.isReleased = true;
        }
    }

    public static final class RequestTask {
        public final boolean allowRetry;
        public int errorCount;
        public final Object request;
        public final long startTimeMs;
        public final long taskId;

        public RequestTask(long j11, boolean z11, long j12, Object obj) {
            this.taskId = j11;
            this.allowRetry = z11;
            this.startTimeMs = j12;
            this.request = obj;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class ResponseHandler extends Handler {
        public ResponseHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i11 = message.what;
            if (i11 == 0) {
                DefaultDrmSession.this.onProvisionResponse(obj, obj2);
            } else if (i11 == 1) {
                DefaultDrmSession.this.onKeyResponse(obj, obj2);
            }
        }
    }

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@Nullable Throwable th2) {
            super(th2);
        }
    }

    public DefaultDrmSession(UUID uuid2, ExoMediaDrm exoMediaDrm, ProvisioningManager provisioningManager2, ReferenceCountListener referenceCountListener2, @Nullable List<DrmInitData.SchemeData> list, int i11, boolean z11, boolean z12, @Nullable byte[] bArr, HashMap<String, String> hashMap, MediaDrmCallback mediaDrmCallback, Looper looper, LoadErrorHandlingPolicy loadErrorHandlingPolicy2, PlayerId playerId2) {
        if (i11 == 1 || i11 == 3) {
            Assertions.checkNotNull(bArr);
        }
        this.uuid = uuid2;
        this.provisioningManager = provisioningManager2;
        this.referenceCountListener = referenceCountListener2;
        this.mediaDrm = exoMediaDrm;
        this.mode = i11;
        this.playClearSamplesWithoutKeys = z11;
        this.isPlaceholderSession = z12;
        if (bArr != null) {
            this.offlineLicenseKeySetId = bArr;
            this.schemeDatas = null;
        } else {
            this.schemeDatas = Collections.unmodifiableList((List) Assertions.checkNotNull(list));
        }
        this.keyRequestParameters = hashMap;
        this.callback = mediaDrmCallback;
        this.eventDispatchers = new CopyOnWriteMultiset<>();
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy2;
        this.playerId = playerId2;
        this.state = 2;
        this.playbackLooper = looper;
        this.responseHandler = new ResponseHandler(looper);
    }

    private void dispatchEvent(Consumer<DrmSessionEventListener.EventDispatcher> consumer) {
        for (DrmSessionEventListener.EventDispatcher accept : this.eventDispatchers.elementSet()) {
            consumer.accept(accept);
        }
    }

    @RequiresNonNull({"sessionId"})
    private void doLicense(boolean z11) {
        if (!this.isPlaceholderSession) {
            byte[] bArr = (byte[]) Util.castNonNull(this.sessionId);
            int i11 = this.mode;
            if (i11 == 0 || i11 == 1) {
                if (this.offlineLicenseKeySetId == null) {
                    postKeyRequest(bArr, 1, z11);
                } else if (this.state == 4 || restoreKeys()) {
                    long licenseDurationRemainingSec = getLicenseDurationRemainingSec();
                    if (this.mode == 0 && licenseDurationRemainingSec <= 60) {
                        Log.d(TAG, "Offline license has expired or will expire soon. Remaining seconds: " + licenseDurationRemainingSec);
                        postKeyRequest(bArr, 2, z11);
                    } else if (licenseDurationRemainingSec <= 0) {
                        onError(new KeysExpiredException(), 2);
                    } else {
                        this.state = 4;
                        dispatchEvent(new c());
                    }
                }
            } else if (i11 != 2) {
                if (i11 == 3) {
                    Assertions.checkNotNull(this.offlineLicenseKeySetId);
                    Assertions.checkNotNull(this.sessionId);
                    postKeyRequest(this.offlineLicenseKeySetId, 3, z11);
                }
            } else if (this.offlineLicenseKeySetId == null || restoreKeys()) {
                postKeyRequest(bArr, 2, z11);
            }
        }
    }

    private long getLicenseDurationRemainingSec() {
        if (!C.WIDEVINE_UUID.equals(this.uuid)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) Assertions.checkNotNull(WidevineUtil.getLicenseDurationRemainingSec(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean isOpen() {
        int i11 = this.state;
        return i11 == 3 || i11 == 4;
    }

    private void onError(Exception exc, int i11) {
        this.lastException = new DrmSession.DrmSessionException(exc, DrmUtil.getErrorCodeForMediaDrmException(exc, i11));
        Log.e(TAG, "DRM session error", exc);
        dispatchEvent(new b(exc));
        if (this.state != 4) {
            this.state = 1;
        }
    }

    /* access modifiers changed from: private */
    public void onKeyResponse(Object obj, Object obj2) {
        if (obj == this.currentKeyRequest && isOpen()) {
            this.currentKeyRequest = null;
            if (obj2 instanceof Exception) {
                onKeysError((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.mode == 3) {
                    this.mediaDrm.provideKeyResponse((byte[]) Util.castNonNull(this.offlineLicenseKeySetId), bArr);
                    dispatchEvent(new a());
                    return;
                }
                byte[] provideKeyResponse = this.mediaDrm.provideKeyResponse(this.sessionId, bArr);
                int i11 = this.mode;
                if (!((i11 != 2 && (i11 != 0 || this.offlineLicenseKeySetId == null)) || provideKeyResponse == null || provideKeyResponse.length == 0)) {
                    this.offlineLicenseKeySetId = provideKeyResponse;
                }
                this.state = 4;
                dispatchEvent(new b());
            } catch (Exception e11) {
                onKeysError(e11, true);
            }
        }
    }

    private void onKeysError(Exception exc, boolean z11) {
        int i11;
        if (exc instanceof NotProvisionedException) {
            this.provisioningManager.provisionRequired(this);
            return;
        }
        if (z11) {
            i11 = 1;
        } else {
            i11 = 2;
        }
        onError(exc, i11);
    }

    private void onKeysRequired() {
        if (this.mode == 0 && this.state == 4) {
            Util.castNonNull(this.sessionId);
            doLicense(false);
        }
    }

    /* access modifiers changed from: private */
    public void onProvisionResponse(Object obj, Object obj2) {
        if (obj != this.currentProvisionRequest) {
            return;
        }
        if (this.state == 2 || isOpen()) {
            this.currentProvisionRequest = null;
            if (obj2 instanceof Exception) {
                this.provisioningManager.onProvisionError((Exception) obj2, false);
                return;
            }
            try {
                this.mediaDrm.provideProvisionResponse((byte[]) obj2);
                this.provisioningManager.onProvisionCompleted();
            } catch (Exception e11) {
                this.provisioningManager.onProvisionError(e11, true);
            }
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean openInternal() {
        if (isOpen()) {
            return true;
        }
        try {
            byte[] openSession = this.mediaDrm.openSession();
            this.sessionId = openSession;
            this.mediaDrm.setPlayerIdForSession(openSession, this.playerId);
            this.cryptoConfig = this.mediaDrm.createCryptoConfig(this.sessionId);
            this.state = 3;
            dispatchEvent(new a(3));
            Assertions.checkNotNull(this.sessionId);
            return true;
        } catch (NotProvisionedException unused) {
            this.provisioningManager.provisionRequired(this);
            return false;
        } catch (Exception e11) {
            onError(e11, 1);
            return false;
        }
    }

    private void postKeyRequest(byte[] bArr, int i11, boolean z11) {
        try {
            this.currentKeyRequest = this.mediaDrm.getKeyRequest(bArr, this.schemeDatas, i11, this.keyRequestParameters);
            ((RequestHandler) Util.castNonNull(this.requestHandler)).post(1, Assertions.checkNotNull(this.currentKeyRequest), z11);
        } catch (Exception e11) {
            onKeysError(e11, true);
        }
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    private boolean restoreKeys() {
        try {
            this.mediaDrm.restoreKeys(this.sessionId, this.offlineLicenseKeySetId);
            return true;
        } catch (Exception e11) {
            onError(e11, 1);
            return false;
        }
    }

    private void verifyPlaybackThread() {
        if (Thread.currentThread() != this.playbackLooper.getThread()) {
            Log.w(TAG, "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.playbackLooper.getThread().getName(), new IllegalStateException());
        }
    }

    public void acquire(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
        verifyPlaybackThread();
        boolean z11 = false;
        if (this.referenceCount < 0) {
            Log.e(TAG, "Session reference count less than zero: " + this.referenceCount);
            this.referenceCount = 0;
        }
        if (eventDispatcher != null) {
            this.eventDispatchers.add(eventDispatcher);
        }
        int i11 = this.referenceCount + 1;
        this.referenceCount = i11;
        if (i11 == 1) {
            if (this.state == 2) {
                z11 = true;
            }
            Assertions.checkState(z11);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.requestHandlerThread = handlerThread;
            handlerThread.start();
            this.requestHandler = new RequestHandler(this.requestHandlerThread.getLooper());
            if (openInternal()) {
                doLicense(true);
            }
        } else if (eventDispatcher != null && isOpen() && this.eventDispatchers.count(eventDispatcher) == 1) {
            eventDispatcher.drmSessionAcquired(this.state);
        }
        this.referenceCountListener.onReferenceCountIncremented(this, this.referenceCount);
    }

    @Nullable
    public final CryptoConfig getCryptoConfig() {
        verifyPlaybackThread();
        return this.cryptoConfig;
    }

    @Nullable
    public final DrmSession.DrmSessionException getError() {
        verifyPlaybackThread();
        if (this.state == 1) {
            return this.lastException;
        }
        return null;
    }

    @Nullable
    public byte[] getOfflineLicenseKeySetId() {
        verifyPlaybackThread();
        return this.offlineLicenseKeySetId;
    }

    public final UUID getSchemeUuid() {
        verifyPlaybackThread();
        return this.uuid;
    }

    public final int getState() {
        verifyPlaybackThread();
        return this.state;
    }

    public boolean hasSessionId(byte[] bArr) {
        verifyPlaybackThread();
        return Arrays.equals(this.sessionId, bArr);
    }

    public void onMediaDrmEvent(int i11) {
        if (i11 == 2) {
            onKeysRequired();
        }
    }

    public void onProvisionCompleted() {
        if (openInternal()) {
            doLicense(true);
        }
    }

    public void onProvisionError(Exception exc, boolean z11) {
        onError(exc, z11 ? 1 : 3);
    }

    public boolean playClearSamplesWithoutKeys() {
        verifyPlaybackThread();
        return this.playClearSamplesWithoutKeys;
    }

    public void provision() {
        this.currentProvisionRequest = this.mediaDrm.getProvisionRequest();
        ((RequestHandler) Util.castNonNull(this.requestHandler)).post(0, Assertions.checkNotNull(this.currentProvisionRequest), true);
    }

    @Nullable
    public Map<String, String> queryKeyStatus() {
        verifyPlaybackThread();
        byte[] bArr = this.sessionId;
        if (bArr == null) {
            return null;
        }
        return this.mediaDrm.queryKeyStatus(bArr);
    }

    public void release(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
        verifyPlaybackThread();
        int i11 = this.referenceCount;
        if (i11 <= 0) {
            Log.e(TAG, "release() called on a session that's already fully released.");
            return;
        }
        int i12 = i11 - 1;
        this.referenceCount = i12;
        if (i12 == 0) {
            this.state = 0;
            ((ResponseHandler) Util.castNonNull(this.responseHandler)).removeCallbacksAndMessages((Object) null);
            ((RequestHandler) Util.castNonNull(this.requestHandler)).release();
            this.requestHandler = null;
            ((HandlerThread) Util.castNonNull(this.requestHandlerThread)).quit();
            this.requestHandlerThread = null;
            this.cryptoConfig = null;
            this.lastException = null;
            this.currentKeyRequest = null;
            this.currentProvisionRequest = null;
            byte[] bArr = this.sessionId;
            if (bArr != null) {
                this.mediaDrm.closeSession(bArr);
                this.sessionId = null;
            }
        }
        if (eventDispatcher != null) {
            this.eventDispatchers.remove(eventDispatcher);
            if (this.eventDispatchers.count(eventDispatcher) == 0) {
                eventDispatcher.drmSessionReleased();
            }
        }
        this.referenceCountListener.onReferenceCountDecremented(this, this.referenceCount);
    }

    public boolean requiresSecureDecoder(String str) {
        verifyPlaybackThread();
        return this.mediaDrm.requiresSecureDecoder((byte[]) Assertions.checkStateNotNull(this.sessionId), str);
    }
}
