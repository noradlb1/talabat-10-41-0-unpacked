package com.deliveryhero.performance.core.screenmetric.performance;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.ViewKt;
import com.deliveryhero.performance.core.analytics.Metric;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b/\u00100J'\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J*\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\f\u0010\u0013\u001a\u00020\t*\u00020\u0007H\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0014\u0010\u0016\u001a\u00020\u000b*\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\u00020\u0017H\u0010J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0002J\f\u0010\u001b\u001a\u00020\t*\u00020\tH\u0002J$\u0010\u001d\u001a\u0004\u0018\u00010\t*\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001c2\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u001d\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u0015\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000e0'8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R0\u0010-\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020+0*j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020+`,8\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/performance/RichContentLoadTimeRecorder;", "", "T", "", "", "percentile", "(Ljava/util/List;I)Ljava/lang/Object;", "Landroid/view/View;", "view", "", "model", "", "replaceNoScreenByRealScreenName", "newScreenName", "Lcom/deliveryhero/performance/core/analytics/Metric;", "metric", "keyWithNoScreenName", "replaceMetric", "clearAttachListeners", "findScreenName", "intoView", "screenName", "listenAttachStateChanged", "Landroid/content/Context;", "Landroid/app/Activity;", "findActivity", "buildKey", "toScreenName", "", "findKey", "start", "stop", "failed", "Lcom/deliveryhero/performance/core/screenmetric/performance/ImageMetric;", "imageLoadingMetrics", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "j$/util/concurrent/ConcurrentHashMap", "metrics", "Lj$/util/concurrent/ConcurrentHashMap;", "Ljava/util/HashMap;", "Landroid/view/View$OnAttachStateChangeListener;", "Lkotlin/collections/HashMap;", "viewListeners", "Ljava/util/HashMap;", "<init>", "()V", "Companion", "core_release"}, k = 1, mv = {1, 6, 0})
public final class RichContentLoadTimeRecorder {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String DELIMETER = "##";
    @NotNull
    @Deprecated
    public static final String NO_SCREEN = "N/A";
    @NotNull
    private final CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(ThreadPoolDispatcherKt.newSingleThreadContext("rclt"));
    /* access modifiers changed from: private */
    @NotNull
    public final ConcurrentHashMap<String, Metric> metrics = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    @NotNull
    public final HashMap<View, View.OnAttachStateChangeListener> viewListeners = new HashMap<>();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/performance/RichContentLoadTimeRecorder$Companion;", "", "()V", "DELIMETER", "", "NO_SCREEN", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final String buildKey(String str, String str2) {
        return str + DELIMETER + str2;
    }

    /* access modifiers changed from: private */
    public final void clearAttachListeners() {
        for (Map.Entry next : this.viewListeners.entrySet()) {
            ((View) next.getKey()).removeOnAttachStateChangeListener((View.OnAttachStateChangeListener) next.getValue());
        }
        this.viewListeners.clear();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK, PHI: r3 
      PHI: (r3v1 android.content.Context) = (r3v0 android.content.Context), (r3v3 android.content.Context) binds: [B:0:0x0000, B:11:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.app.Activity findActivity(android.content.Context r3) {
        /*
            r2 = this;
        L_0x0000:
            boolean r0 = r3 instanceof android.app.Activity
            r1 = 0
            if (r0 == 0) goto L_0x0009
            r0 = r3
            android.app.Activity r0 = (android.app.Activity) r0
            goto L_0x000a
        L_0x0009:
            r0 = r1
        L_0x000a:
            if (r0 != 0) goto L_0x001e
            boolean r0 = r3 instanceof android.content.ContextWrapper
            if (r0 == 0) goto L_0x0013
            android.content.ContextWrapper r3 = (android.content.ContextWrapper) r3
            goto L_0x0014
        L_0x0013:
            r3 = r1
        L_0x0014:
            if (r3 != 0) goto L_0x0017
            goto L_0x001f
        L_0x0017:
            android.content.Context r3 = r3.getBaseContext()
            if (r3 != 0) goto L_0x0000
            goto L_0x001f
        L_0x001e:
            r1 = r0
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder.findActivity(android.content.Context):android.app.Activity");
    }

    /* access modifiers changed from: private */
    public final String findKey(Map<String, Metric> map, String str) {
        T t11;
        Iterator<T> it = map.keySet().iterator();
        while (true) {
            t11 = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (StringsKt__StringsJVMKt.startsWith$default((String) next, str, false, 2, (Object) null)) {
                t11 = next;
                break;
            }
        }
        return (String) t11;
    }

    private final String findScreenName(View view) {
        String str;
        try {
            str = ViewKt.findFragment(view).getClass().getSimpleName();
        } catch (IllegalStateException unused) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Activity findActivity = findActivity(context);
            if (findActivity == null) {
                str = null;
            } else {
                str = findActivity.getClass().getSimpleName();
            }
        }
        if (str == null) {
            return "N/A";
        }
        return str;
    }

    private final void listenAttachStateChanged(View view, String str) {
        if (!this.viewListeners.containsKey(view)) {
            RichContentLoadTimeRecorder$listenAttachStateChanged$attachStateChangeListener$1 richContentLoadTimeRecorder$listenAttachStateChanged$attachStateChangeListener$1 = new RichContentLoadTimeRecorder$listenAttachStateChanged$attachStateChangeListener$1(this, str);
            view.addOnAttachStateChangeListener(richContentLoadTimeRecorder$listenAttachStateChanged$attachStateChangeListener$1);
            this.viewListeners.put(view, richContentLoadTimeRecorder$listenAttachStateChanged$attachStateChangeListener$1);
        }
    }

    /* access modifiers changed from: private */
    public final <T> T percentile(List<? extends T> list, int i11) {
        return list.get(((int) Math.ceil((((double) i11) / 100.0d) * ((double) list.size()))) - 1);
    }

    /* access modifiers changed from: private */
    public final void replaceMetric(String str, String str2, Metric metric, String str3) {
        this.metrics.put(buildKey(str, str2), metric);
        this.metrics.remove(str3);
    }

    /* access modifiers changed from: private */
    public final void replaceNoScreenByRealScreenName(View view, String str) {
        String findKey = findKey(this.metrics, str);
        if (findKey != null) {
            String screenName = toScreenName(findKey);
            Metric metric = this.metrics.get(findKey);
            if (Intrinsics.areEqual((Object) screenName, (Object) "N/A")) {
                replaceMetric(str, findScreenName(view), metric, findKey);
            }
        }
    }

    /* access modifiers changed from: private */
    public final String screenName(String str, View view) {
        if (view.isAttachedToWindow()) {
            return findScreenName(view);
        }
        listenAttachStateChanged(view, str);
        return "N/A";
    }

    /* access modifiers changed from: private */
    public final String toScreenName(String str) {
        return StringsKt__StringsKt.substringAfterLast$default(str, DELIMETER, (String) null, 2, (Object) null);
    }

    public final void failed(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new RichContentLoadTimeRecorder$failed$1(this, str, (Continuation<? super RichContentLoadTimeRecorder$failed$1>) null), 3, (Object) null);
    }

    @Nullable
    public final Object imageLoadingMetrics(@NotNull String str, @NotNull Continuation<? super ImageMetric> continuation) {
        return BuildersKt.withContext(this.coroutineScope.getCoroutineContext(), new RichContentLoadTimeRecorder$imageLoadingMetrics$2(this, str, (Continuation<? super RichContentLoadTimeRecorder$imageLoadingMetrics$2>) null), continuation);
    }

    public final void start(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new RichContentLoadTimeRecorder$start$1(this, str, (Continuation<? super RichContentLoadTimeRecorder$start$1>) null), 3, (Object) null);
    }

    public final void stop(@NotNull String str, @NotNull View view) {
        Intrinsics.checkNotNullParameter(str, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        Intrinsics.checkNotNullParameter(view, "intoView");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new RichContentLoadTimeRecorder$stop$1(this, str, view, (Continuation<? super RichContentLoadTimeRecorder$stop$1>) null), 3, (Object) null);
    }
}
