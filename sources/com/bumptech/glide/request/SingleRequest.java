package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final String GLIDE_TAG = "Glide";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);
    private static final String TAG = "Request";
    private final TransitionFactory<? super R> animationFactory;
    private final Executor callbackExecutor;
    private final Context context;
    private volatile Engine engine;
    @GuardedBy("requestLock")
    @Nullable
    private Drawable errorDrawable;
    @GuardedBy("requestLock")
    @Nullable
    private Drawable fallbackDrawable;
    private final GlideContext glideContext;
    @GuardedBy("requestLock")
    private int height;
    @GuardedBy("requestLock")
    private boolean isCallingCallbacks;
    @GuardedBy("requestLock")
    private Engine.LoadStatus loadStatus;
    @Nullable
    private final Object model;
    private final int overrideHeight;
    private final int overrideWidth;
    @GuardedBy("requestLock")
    @Nullable
    private Drawable placeholderDrawable;
    private final Priority priority;
    private final RequestCoordinator requestCoordinator;
    @Nullable
    private final List<RequestListener<R>> requestListeners;
    private final Object requestLock;
    private final BaseRequestOptions<?> requestOptions;
    @Nullable
    private RuntimeException requestOrigin;
    @GuardedBy("requestLock")
    private Resource<R> resource;
    @GuardedBy("requestLock")
    private long startTime;
    private final StateVerifier stateVerifier;
    @GuardedBy("requestLock")
    private Status status;
    @Nullable
    private final String tag;
    private final Target<R> target;
    @Nullable
    private final RequestListener<R> targetListener;
    private final Class<R> transcodeClass;
    @GuardedBy("requestLock")
    private int width;

    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context2, GlideContext glideContext2, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i11, int i12, Priority priority2, Target<R> target2, @Nullable RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
        this.requestLock = obj;
        this.context = context2;
        this.glideContext = glideContext2;
        this.model = obj2;
        this.transcodeClass = cls;
        this.requestOptions = baseRequestOptions;
        this.overrideWidth = i11;
        this.overrideHeight = i12;
        this.priority = priority2;
        this.target = target2;
        this.targetListener = requestListener;
        this.requestListeners = list;
        this.requestCoordinator = requestCoordinator2;
        this.engine = engine2;
        this.animationFactory = transitionFactory;
        this.callbackExecutor = executor;
        this.status = Status.PENDING;
        if (this.requestOrigin == null && glideContext2.getExperiments().isEnabled(GlideBuilder.LogRequestOrigins.class)) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
        }
    }

    @GuardedBy("requestLock")
    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    private boolean canNotifyCleared() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canNotifyCleared(this);
    }

    @GuardedBy("requestLock")
    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canNotifyStatusChanged(this);
    }

    @GuardedBy("requestLock")
    private boolean canSetResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canSetImage(this);
    }

    @GuardedBy("requestLock")
    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        Engine.LoadStatus loadStatus2 = this.loadStatus;
        if (loadStatus2 != null) {
            loadStatus2.cancel();
            this.loadStatus = null;
        }
    }

    @GuardedBy("requestLock")
    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    @GuardedBy("requestLock")
    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable2 = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable2;
            if (fallbackDrawable2 == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    @GuardedBy("requestLock")
    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable2 = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable2;
            if (placeholderDrawable2 == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    @GuardedBy("requestLock")
    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || !requestCoordinator2.getRoot().isAnyResourceSet();
    }

    @GuardedBy("requestLock")
    private Drawable loadDrawable(@DrawableRes int i11) {
        Resources.Theme theme;
        if (this.requestOptions.getTheme() != null) {
            theme = this.requestOptions.getTheme();
        } else {
            theme = this.context.getTheme();
        }
        return DrawableDecoderCompat.getDrawable((Context) this.glideContext, i11, theme);
    }

    private void logV(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" this: ");
        sb2.append(this.tag);
    }

    private static int maybeApplySizeMultiplier(int i11, float f11) {
        return i11 == Integer.MIN_VALUE ? i11 : Math.round(f11 * ((float) i11));
    }

    @GuardedBy("requestLock")
    private void notifyLoadFailed() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 != null) {
            requestCoordinator2.onRequestFailed(this);
        }
    }

    @GuardedBy("requestLock")
    private void notifyLoadSuccess() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 != null) {
            requestCoordinator2.onRequestSuccess(this);
        }
    }

    public static <R> SingleRequest<R> obtain(Context context2, GlideContext glideContext2, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i11, int i12, Priority priority2, Target<R> target2, RequestListener<R> requestListener, @Nullable List<RequestListener<R>> list, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest(context2, glideContext2, obj, obj2, cls, baseRequestOptions, i11, i12, priority2, target2, requestListener, list, requestCoordinator2, engine2, transitionFactory, executor);
    }

    @GuardedBy("requestLock")
    private void setErrorPlaceholder() {
        Drawable drawable;
        if (canNotifyStatusChanged()) {
            if (this.model == null) {
                drawable = getFallbackDrawable();
            } else {
                drawable = null;
            }
            if (drawable == null) {
                drawable = getErrorDrawable();
            }
            if (drawable == null) {
                drawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(drawable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void begin() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.requestLock
            monitor-enter(r0)
            r5.assertNotCallingCallbacks()     // Catch:{ all -> 0x00a8 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.stateVerifier     // Catch:{ all -> 0x00a8 }
            r1.throwIfRecycled()     // Catch:{ all -> 0x00a8 }
            long r1 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x00a8 }
            r5.startTime = r1     // Catch:{ all -> 0x00a8 }
            java.lang.Object r1 = r5.model     // Catch:{ all -> 0x00a8 }
            if (r1 != 0) goto L_0x003c
            int r1 = r5.overrideWidth     // Catch:{ all -> 0x00a8 }
            int r2 = r5.overrideHeight     // Catch:{ all -> 0x00a8 }
            boolean r1 = com.bumptech.glide.util.Util.isValidDimensions(r1, r2)     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x0027
            int r1 = r5.overrideWidth     // Catch:{ all -> 0x00a8 }
            r5.width = r1     // Catch:{ all -> 0x00a8 }
            int r1 = r5.overrideHeight     // Catch:{ all -> 0x00a8 }
            r5.height = r1     // Catch:{ all -> 0x00a8 }
        L_0x0027:
            android.graphics.drawable.Drawable r1 = r5.getFallbackDrawable()     // Catch:{ all -> 0x00a8 }
            if (r1 != 0) goto L_0x002f
            r1 = 5
            goto L_0x0030
        L_0x002f:
            r1 = 3
        L_0x0030:
            com.bumptech.glide.load.engine.GlideException r2 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00a8 }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x00a8 }
            r5.onLoadFailed(r2, r1)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            return
        L_0x003c:
            com.bumptech.glide.request.SingleRequest$Status r1 = r5.status     // Catch:{ all -> 0x00a8 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00a8 }
            if (r1 == r2) goto L_0x00a0
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x00a8 }
            if (r1 != r3) goto L_0x0050
            com.bumptech.glide.load.engine.Resource<R> r1 = r5.resource     // Catch:{ all -> 0x00a8 }
            com.bumptech.glide.load.DataSource r2 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x00a8 }
            r3 = 0
            r5.onResourceReady(r1, r2, r3)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            return
        L_0x0050:
            com.bumptech.glide.request.SingleRequest$Status r1 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00a8 }
            r5.status = r1     // Catch:{ all -> 0x00a8 }
            int r3 = r5.overrideWidth     // Catch:{ all -> 0x00a8 }
            int r4 = r5.overrideHeight     // Catch:{ all -> 0x00a8 }
            boolean r3 = com.bumptech.glide.util.Util.isValidDimensions(r3, r4)     // Catch:{ all -> 0x00a8 }
            if (r3 == 0) goto L_0x0066
            int r3 = r5.overrideWidth     // Catch:{ all -> 0x00a8 }
            int r4 = r5.overrideHeight     // Catch:{ all -> 0x00a8 }
            r5.onSizeReady(r3, r4)     // Catch:{ all -> 0x00a8 }
            goto L_0x006b
        L_0x0066:
            com.bumptech.glide.request.target.Target<R> r3 = r5.target     // Catch:{ all -> 0x00a8 }
            r3.getSize(r5)     // Catch:{ all -> 0x00a8 }
        L_0x006b:
            com.bumptech.glide.request.SingleRequest$Status r3 = r5.status     // Catch:{ all -> 0x00a8 }
            if (r3 == r2) goto L_0x0071
            if (r3 != r1) goto L_0x0080
        L_0x0071:
            boolean r1 = r5.canNotifyStatusChanged()     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x0080
            com.bumptech.glide.request.target.Target<R> r1 = r5.target     // Catch:{ all -> 0x00a8 }
            android.graphics.drawable.Drawable r2 = r5.getPlaceholderDrawable()     // Catch:{ all -> 0x00a8 }
            r1.onLoadStarted(r2)     // Catch:{ all -> 0x00a8 }
        L_0x0080:
            boolean r1 = IS_VERBOSE_LOGGABLE     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x009e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a8 }
            r1.<init>()     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "finished run method in "
            r1.append(r2)     // Catch:{ all -> 0x00a8 }
            long r2 = r5.startTime     // Catch:{ all -> 0x00a8 }
            double r2 = com.bumptech.glide.util.LogTime.getElapsedMillis(r2)     // Catch:{ all -> 0x00a8 }
            r1.append(r2)     // Catch:{ all -> 0x00a8 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a8 }
            r5.logV(r1)     // Catch:{ all -> 0x00a8 }
        L_0x009e:
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            return
        L_0x00a0:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x00a8 }
            throw r1     // Catch:{ all -> 0x00a8 }
        L_0x00a8:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.begin():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        r5.engine.release(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.requestLock
            monitor-enter(r0)
            r5.assertNotCallingCallbacks()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.util.pool.StateVerifier r1 = r5.stateVerifier     // Catch:{ all -> 0x0039 }
            r1.throwIfRecycled()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.request.SingleRequest$Status r1 = r5.status     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x0039 }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return
        L_0x0013:
            r5.cancel()     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.load.engine.Resource<R> r1 = r5.resource     // Catch:{ all -> 0x0039 }
            r3 = 0
            if (r1 == 0) goto L_0x001e
            r5.resource = r3     // Catch:{ all -> 0x0039 }
            goto L_0x001f
        L_0x001e:
            r1 = r3
        L_0x001f:
            boolean r3 = r5.canNotifyCleared()     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x002e
            com.bumptech.glide.request.target.Target<R> r3 = r5.target     // Catch:{ all -> 0x0039 }
            android.graphics.drawable.Drawable r4 = r5.getPlaceholderDrawable()     // Catch:{ all -> 0x0039 }
            r3.onLoadCleared(r4)     // Catch:{ all -> 0x0039 }
        L_0x002e:
            r5.status = r2     // Catch:{ all -> 0x0039 }
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0038
            com.bumptech.glide.load.engine.Engine r0 = r5.engine
            r0.release(r1)
        L_0x0038:
            return
        L_0x0039:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.clear():void");
    }

    public Object getLock() {
        this.stateVerifier.throwIfRecycled();
        return this.requestLock;
    }

    public boolean isAnyResourceSet() {
        boolean z11;
        synchronized (this.requestLock) {
            if (this.status == Status.COMPLETE) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z11;
    }

    public boolean isCleared() {
        boolean z11;
        synchronized (this.requestLock) {
            if (this.status == Status.CLEARED) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z11;
    }

    public boolean isComplete() {
        boolean z11;
        synchronized (this.requestLock) {
            if (this.status == Status.COMPLETE) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z11;
    }

    public boolean isEquivalentTo(Request request) {
        int i11;
        int i12;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority2;
        int i13;
        int i14;
        int i15;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority3;
        int i16;
        Request request2 = request;
        if (!(request2 instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.requestLock) {
            i11 = this.overrideWidth;
            i12 = this.overrideHeight;
            obj = this.model;
            cls = this.transcodeClass;
            baseRequestOptions = this.requestOptions;
            priority2 = this.priority;
            List<RequestListener<R>> list = this.requestListeners;
            if (list != null) {
                i13 = list.size();
            } else {
                i13 = 0;
            }
        }
        SingleRequest singleRequest = (SingleRequest) request2;
        synchronized (singleRequest.requestLock) {
            i14 = singleRequest.overrideWidth;
            i15 = singleRequest.overrideHeight;
            obj2 = singleRequest.model;
            cls2 = singleRequest.transcodeClass;
            baseRequestOptions2 = singleRequest.requestOptions;
            priority3 = singleRequest.priority;
            List<RequestListener<R>> list2 = singleRequest.requestListeners;
            if (list2 != null) {
                i16 = list2.size();
            } else {
                i16 = 0;
            }
        }
        if (i11 == i14 && i12 == i15 && Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority2 == priority3 && i13 == i16) {
            return true;
        }
        return false;
    }

    public boolean isRunning() {
        boolean z11;
        synchronized (this.requestLock) {
            Status status2 = this.status;
            if (status2 != Status.RUNNING) {
                if (status2 != Status.WAITING_FOR_SIZE) {
                    z11 = false;
                }
            }
            z11 = true;
        }
        return z11;
    }

    public void onLoadFailed(GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    public void onResourceReady(Resource<?> resource2, DataSource dataSource, boolean z11) {
        this.stateVerifier.throwIfRecycled();
        Resource<?> resource3 = null;
        try {
            synchronized (this.requestLock) {
                try {
                    this.loadStatus = null;
                    if (resource2 == null) {
                        onLoadFailed(new GlideException("Expected to receive a Resource<R> with an object of " + this.transcodeClass + " inside, but instead got null."));
                        return;
                    }
                    Object obj = resource2.get();
                    if (obj != null) {
                        if (this.transcodeClass.isAssignableFrom(obj.getClass())) {
                            if (!canSetResource()) {
                                try {
                                    this.resource = null;
                                    this.status = Status.COMPLETE;
                                    this.engine.release(resource2);
                                    return;
                                } catch (Throwable th2) {
                                    resource3 = resource2;
                                    th = th2;
                                    throw th;
                                }
                            } else {
                                onResourceReady(resource2, obj, dataSource, z11);
                                return;
                            }
                        }
                    }
                    this.resource = null;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Expected to receive an object of ");
                    sb2.append(this.transcodeClass);
                    sb2.append(" but instead got ");
                    sb2.append(obj != null ? obj.getClass() : "");
                    sb2.append("{");
                    sb2.append(obj);
                    sb2.append("} inside Resource{");
                    sb2.append(resource2);
                    sb2.append("}.");
                    sb2.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                    onLoadFailed(new GlideException(sb2.toString()));
                    this.engine.release(resource2);
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        } catch (Throwable th4) {
            if (resource3 != null) {
                this.engine.release(resource3);
            }
            throw th4;
        }
    }

    public void onSizeReady(int i11, int i12) {
        Object obj;
        this.stateVerifier.throwIfRecycled();
        Object obj2 = this.requestLock;
        synchronized (obj2) {
            try {
                boolean z11 = IS_VERBOSE_LOGGABLE;
                if (z11) {
                    logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                }
                if (this.status == Status.WAITING_FOR_SIZE) {
                    Status status2 = Status.RUNNING;
                    this.status = status2;
                    float sizeMultiplier = this.requestOptions.getSizeMultiplier();
                    this.width = maybeApplySizeMultiplier(i11, sizeMultiplier);
                    this.height = maybeApplySizeMultiplier(i12, sizeMultiplier);
                    if (z11) {
                        logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));
                    }
                    Status status3 = status2;
                    boolean z12 = z11;
                    Status status4 = status3;
                    obj = obj2;
                    try {
                        this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);
                        if (this.status != status4) {
                            this.loadStatus = null;
                        }
                        if (z12) {
                            logV("finished onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                obj = obj2;
                throw th;
            }
        }
    }

    public void pause() {
        synchronized (this.requestLock) {
            if (isRunning()) {
                clear();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    private void onLoadFailed(GlideException glideException, int i11) {
        boolean z11;
        this.stateVerifier.throwIfRecycled();
        synchronized (this.requestLock) {
            glideException.setOrigin(this.requestOrigin);
            int logLevel = this.glideContext.getLogLevel();
            if (logLevel <= i11) {
                Log.w(GLIDE_TAG, "Load failed for " + this.model + " with size [" + this.width + Param.X + this.height + "]", glideException);
                if (logLevel <= 4) {
                    glideException.logRootCauses(GLIDE_TAG);
                }
            }
            this.loadStatus = null;
            this.status = Status.FAILED;
            boolean z12 = true;
            this.isCallingCallbacks = true;
            try {
                List<RequestListener<R>> list = this.requestListeners;
                if (list != null) {
                    z11 = false;
                    for (RequestListener<R> onLoadFailed : list) {
                        z11 |= onLoadFailed.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource());
                    }
                } else {
                    z11 = false;
                }
                RequestListener<R> requestListener = this.targetListener;
                if (requestListener == null || !requestListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) {
                    z12 = false;
                }
                if (!z11 && !z12) {
                    setErrorPlaceholder();
                }
                this.isCallingCallbacks = false;
                notifyLoadFailed();
            } catch (Throwable th2) {
                this.isCallingCallbacks = false;
                throw th2;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009f A[Catch:{ all -> 0x00b0 }] */
    @androidx.annotation.GuardedBy("requestLock")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onResourceReady(com.bumptech.glide.load.engine.Resource<R> r10, R r11, com.bumptech.glide.load.DataSource r12, boolean r13) {
        /*
            r9 = this;
            boolean r13 = r9.isFirstReadyResource()
            com.bumptech.glide.request.SingleRequest$Status r0 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE
            r9.status = r0
            r9.resource = r10
            com.bumptech.glide.GlideContext r10 = r9.glideContext
            int r10 = r10.getLogLevel()
            r0 = 3
            if (r10 > r0) goto L_0x0062
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Finished loading "
            r10.append(r0)
            java.lang.Class r0 = r11.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r10.append(r0)
            java.lang.String r0 = " from "
            r10.append(r0)
            r10.append(r12)
            java.lang.String r0 = " for "
            r10.append(r0)
            java.lang.Object r0 = r9.model
            r10.append(r0)
            java.lang.String r0 = " with size ["
            r10.append(r0)
            int r0 = r9.width
            r10.append(r0)
            java.lang.String r0 = "x"
            r10.append(r0)
            int r0 = r9.height
            r10.append(r0)
            java.lang.String r0 = "] in "
            r10.append(r0)
            long r0 = r9.startTime
            double r0 = com.bumptech.glide.util.LogTime.getElapsedMillis(r0)
            r10.append(r0)
            java.lang.String r0 = " ms"
            r10.append(r0)
        L_0x0062:
            r10 = 1
            r9.isCallingCallbacks = r10
            r6 = 0
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r0 = r9.requestListeners     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x0088
            java.util.Iterator r7 = r0.iterator()     // Catch:{ all -> 0x00b0 }
            r8 = r6
        L_0x006f:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x0089
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x00b0 }
            com.bumptech.glide.request.RequestListener r0 = (com.bumptech.glide.request.RequestListener) r0     // Catch:{ all -> 0x00b0 }
            java.lang.Object r2 = r9.model     // Catch:{ all -> 0x00b0 }
            com.bumptech.glide.request.target.Target<R> r3 = r9.target     // Catch:{ all -> 0x00b0 }
            r1 = r11
            r4 = r12
            r5 = r13
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b0 }
            r8 = r8 | r0
            goto L_0x006f
        L_0x0088:
            r8 = r6
        L_0x0089:
            com.bumptech.glide.request.RequestListener<R> r0 = r9.targetListener     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x009b
            java.lang.Object r2 = r9.model     // Catch:{ all -> 0x00b0 }
            com.bumptech.glide.request.target.Target<R> r3 = r9.target     // Catch:{ all -> 0x00b0 }
            r1 = r11
            r4 = r12
            r5 = r13
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b0 }
            if (r0 == 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r10 = r6
        L_0x009c:
            r10 = r10 | r8
            if (r10 != 0) goto L_0x00aa
            com.bumptech.glide.request.transition.TransitionFactory<? super R> r10 = r9.animationFactory     // Catch:{ all -> 0x00b0 }
            com.bumptech.glide.request.transition.Transition r10 = r10.build(r12, r13)     // Catch:{ all -> 0x00b0 }
            com.bumptech.glide.request.target.Target<R> r12 = r9.target     // Catch:{ all -> 0x00b0 }
            r12.onResourceReady(r11, r10)     // Catch:{ all -> 0x00b0 }
        L_0x00aa:
            r9.isCallingCallbacks = r6
            r9.notifyLoadSuccess()
            return
        L_0x00b0:
            r10 = move-exception
            r9.isCallingCallbacks = r6
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.onResourceReady(com.bumptech.glide.load.engine.Resource, java.lang.Object, com.bumptech.glide.load.DataSource, boolean):void");
    }
}
