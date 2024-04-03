package com.facebook.appevents.suggestedevents;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.facebook.appevents.codeless.internal.SensitiveUserDataUtils;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.b;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewObserver;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "isTracking", "Ljava/util/concurrent/atomic/AtomicBoolean;", "uiThreadHandler", "Landroid/os/Handler;", "onGlobalLayout", "", "process", "startTracking", "stopTracking", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class ViewObserver implements ViewTreeObserver.OnGlobalLayoutListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_TEXT_LENGTH = 300;
    /* access modifiers changed from: private */
    @NotNull
    public static final Map<Integer, ViewObserver> observers = new HashMap();
    @NotNull
    private final WeakReference<Activity> activityWeakReference;
    @NotNull
    private final AtomicBoolean isTracking;
    @NotNull
    private final Handler uiThreadHandler;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/appevents/suggestedevents/ViewObserver$Companion;", "", "()V", "MAX_TEXT_LENGTH", "", "observers", "", "Lcom/facebook/appevents/suggestedevents/ViewObserver;", "startTrackingActivity", "", "activity", "Landroid/app/Activity;", "stopTrackingActivity", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void startTrackingActivity(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            int hashCode = activity.hashCode();
            Map access$getObservers$cp = ViewObserver.observers;
            Integer valueOf = Integer.valueOf(hashCode);
            Object obj = access$getObservers$cp.get(valueOf);
            if (obj == null) {
                obj = new ViewObserver(activity, (DefaultConstructorMarker) null);
                access$getObservers$cp.put(valueOf, obj);
            }
            ((ViewObserver) obj).startTracking();
        }

        @JvmStatic
        public final void stopTrackingActivity(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ViewObserver viewObserver = (ViewObserver) ViewObserver.observers.remove(Integer.valueOf(activity.hashCode()));
            if (viewObserver != null) {
                viewObserver.stopTracking();
            }
        }
    }

    private ViewObserver(Activity activity) {
        this.activityWeakReference = new WeakReference<>(activity);
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        this.isTracking = new AtomicBoolean(false);
    }

    public /* synthetic */ ViewObserver(Activity activity, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity);
    }

    private final void process() {
        b bVar = new b(this);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            bVar.run();
        } else {
            this.uiThreadHandler.post(bVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: process$lambda-0  reason: not valid java name */
    public static final void m8929process$lambda0(ViewObserver viewObserver) {
        boolean z11;
        Intrinsics.checkNotNullParameter(viewObserver, "this$0");
        try {
            AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
            View rootView = AppEventUtility.getRootView(viewObserver.activityWeakReference.get());
            Activity activity = viewObserver.activityWeakReference.get();
            if (rootView == null) {
                return;
            }
            if (activity != null) {
                for (View next : SuggestedEventViewHierarchy.getAllClickableViews(rootView)) {
                    if (!SensitiveUserDataUtils.isSensitiveUserData(next)) {
                        String textOfViewRecursively = SuggestedEventViewHierarchy.getTextOfViewRecursively(next);
                        if (textOfViewRecursively.length() > 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (z11 && textOfViewRecursively.length() <= 300) {
                            ViewOnClickListener.Companion companion = ViewOnClickListener.Companion;
                            String localClassName = activity.getLocalClassName();
                            Intrinsics.checkNotNullExpressionValue(localClassName, "activity.localClassName");
                            companion.attachListener$facebook_core_release(next, rootView, localClassName);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void startTracking() {
        if (!this.isTracking.getAndSet(true)) {
            AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
            View rootView = AppEventUtility.getRootView(this.activityWeakReference.get());
            if (rootView != null) {
                ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnGlobalLayoutListener(this);
                    process();
                }
            }
        }
    }

    @JvmStatic
    public static final void startTrackingActivity(@NotNull Activity activity) {
        Companion.startTrackingActivity(activity);
    }

    /* access modifiers changed from: private */
    public final void stopTracking() {
        if (this.isTracking.getAndSet(false)) {
            AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
            View rootView = AppEventUtility.getRootView(this.activityWeakReference.get());
            if (rootView != null) {
                ViewTreeObserver viewTreeObserver = rootView.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
        }
    }

    @JvmStatic
    public static final void stopTrackingActivity(@NotNull Activity activity) {
        Companion.stopTrackingActivity(activity);
    }

    public void onGlobalLayout() {
        process();
    }
}
