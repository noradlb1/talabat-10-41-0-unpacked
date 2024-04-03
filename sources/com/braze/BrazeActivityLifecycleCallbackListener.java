package com.braze;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.braze.Braze;
import com.braze.push.NotificationTrampolineActivity;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B5\b\u0017\u0012\u0014\u0010\u0002\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006BK\b\u0007\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u0017\u001a\u00020\f2\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0003J\u001a\u0010\u0019\u001a\u00020\f2\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0003J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\bH\u0007R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00040\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/braze/BrazeActivityLifecycleCallbackListener;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "inAppMessagingRegistrationBlocklist", "", "Ljava/lang/Class;", "sessionHandlingBlocklist", "(Ljava/util/Set;Ljava/util/Set;)V", "sessionHandlingEnabled", "", "registerInAppMessageManager", "(ZZLjava/util/Set;Ljava/util/Set;)V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "setInAppMessagingRegistrationBlocklist", "blocklist", "setSessionHandlingBlocklist", "shouldHandleLifecycleMethodsInActivity", "forSessionHandling", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BrazeActivityLifecycleCallbackListener implements Application.ActivityLifecycleCallbacks {
    /* access modifiers changed from: private */
    @NotNull
    public Set<? extends Class<?>> inAppMessagingRegistrationBlocklist;
    private final boolean registerInAppMessageManager;
    /* access modifiers changed from: private */
    @NotNull
    public Set<? extends Class<?>> sessionHandlingBlocklist;
    private final boolean sessionHandlingEnabled;

    @JvmOverloads
    public BrazeActivityLifecycleCallbackListener() {
        this(false, false, (Set) null, (Set) null, 15, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public BrazeActivityLifecycleCallbackListener(@Nullable Set<? extends Class<?>> set) {
        this((Set) set, (Set) null, 2, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public BrazeActivityLifecycleCallbackListener(boolean z11) {
        this(z11, false, (Set) null, (Set) null, 14, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public BrazeActivityLifecycleCallbackListener(boolean z11, boolean z12) {
        this(z11, z12, (Set) null, (Set) null, 12, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public BrazeActivityLifecycleCallbackListener(boolean z11, boolean z12, @Nullable Set<? extends Class<?>> set) {
        this(z11, z12, set, (Set) null, 8, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public BrazeActivityLifecycleCallbackListener(boolean z11, boolean z12, @Nullable Set<? extends Class<?>> set, @Nullable Set<? extends Class<?>> set2) {
        this.sessionHandlingEnabled = z11;
        this.registerInAppMessageManager = z12;
        this.inAppMessagingRegistrationBlocklist = set == null ? SetsKt__SetsKt.emptySet() : set;
        this.sessionHandlingBlocklist = set2 == null ? SetsKt__SetsKt.emptySet() : set2;
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) new Function0<String>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ BrazeActivityLifecycleCallbackListener f43532g;

            {
                this.f43532g = r1;
            }

            @NotNull
            public final String invoke() {
                return Intrinsics.stringPlus("BrazeActivityLifecycleCallbackListener using in-app messaging blocklist: ", this.f43532g.inAppMessagingRegistrationBlocklist);
            }
        }, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, false, (Function0) new Function0<String>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ BrazeActivityLifecycleCallbackListener f43533g;

            {
                this.f43533g = r1;
            }

            @NotNull
            public final String invoke() {
                return Intrinsics.stringPlus("BrazeActivityLifecycleCallbackListener using session handling blocklist: ", this.f43533g.sessionHandlingBlocklist);
            }
        }, 6, (Object) null);
    }

    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.registerInAppMessageManager && shouldHandleLifecycleMethodsInActivity(activity, false)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeActivityLifecycleCallbackListener$onActivityCreated$1(activity), 6, (Object) null);
            BrazeInAppMessageManager instance = BrazeInAppMessageManager.Companion.getInstance();
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
            instance.ensureSubscribedToInAppMessageEvents(applicationContext);
        }
    }

    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.registerInAppMessageManager && shouldHandleLifecycleMethodsInActivity(activity, false)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeActivityLifecycleCallbackListener$onActivityPaused$1(activity), 6, (Object) null);
            BrazeInAppMessageManager.Companion.getInstance().unregisterInAppMessageManager(activity);
        }
    }

    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.registerInAppMessageManager && shouldHandleLifecycleMethodsInActivity(activity, false)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeActivityLifecycleCallbackListener$onActivityResumed$1(activity), 6, (Object) null);
            BrazeInAppMessageManager.Companion.getInstance().registerInAppMessageManager(activity);
        }
    }

    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.sessionHandlingEnabled && shouldHandleLifecycleMethodsInActivity(activity, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeActivityLifecycleCallbackListener$onActivityStarted$1(activity), 6, (Object) null);
            Braze.Companion companion = Braze.Companion;
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
            companion.getInstance(applicationContext).openSession(activity);
        }
    }

    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.sessionHandlingEnabled && shouldHandleLifecycleMethodsInActivity(activity, true)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeActivityLifecycleCallbackListener$onActivityStopped$1(activity), 6, (Object) null);
            Braze.Companion companion = Braze.Companion;
            Context applicationContext = activity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
            companion.getInstance(applicationContext).closeSession(activity);
        }
    }

    public final void setInAppMessagingRegistrationBlocklist(@NotNull Set<? extends Class<?>> set) {
        Intrinsics.checkNotNullParameter(set, "blocklist");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeActivityLifecycleCallbackListener$setInAppMessagingRegistrationBlocklist$1(set), 6, (Object) null);
        this.inAppMessagingRegistrationBlocklist = set;
    }

    public final void setSessionHandlingBlocklist(@NotNull Set<? extends Class<?>> set) {
        Intrinsics.checkNotNullParameter(set, "blocklist");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new BrazeActivityLifecycleCallbackListener$setSessionHandlingBlocklist$1(set), 6, (Object) null);
        this.sessionHandlingBlocklist = set;
    }

    @VisibleForTesting
    public final boolean shouldHandleLifecycleMethodsInActivity(@NotNull Activity activity, boolean z11) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Class<?> cls = activity.getClass();
        if (Intrinsics.areEqual((Object) cls, (Object) NotificationTrampolineActivity.class)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) BrazeActivityLifecycleCallbackListener$shouldHandleLifecycleMethodsInActivity$1.INSTANCE, 6, (Object) null);
            return false;
        }
        if (z11) {
            if (this.sessionHandlingBlocklist.contains(cls)) {
                return false;
            }
        } else if (this.inAppMessagingRegistrationBlocklist.contains(cls)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BrazeActivityLifecycleCallbackListener(boolean z11, boolean z12, Set set, Set set2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11, (i11 & 2) != 0 ? true : z12, (Set<? extends Class<?>>) (i11 & 4) != 0 ? SetsKt__SetsKt.emptySet() : set, (Set<? extends Class<?>>) (i11 & 8) != 0 ? SetsKt__SetsKt.emptySet() : set2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BrazeActivityLifecycleCallbackListener(Set set, Set set2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((Set<? extends Class<?>>) set, (Set<? extends Class<?>>) (i11 & 2) != 0 ? SetsKt__SetsKt.emptySet() : set2);
    }

    @JvmOverloads
    public BrazeActivityLifecycleCallbackListener(@Nullable Set<? extends Class<?>> set, @Nullable Set<? extends Class<?>> set2) {
        this(true, true, set, set2);
    }
}
