package com.deliveryhero.performance.core.tapresponse;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.deliveryhero.performance.core.screenmetric.PerformanceExtensionKt;
import com.deliveryhero.performance.core.tapresponse.AndroidComponentViewContainer;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB=\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\u0002\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u001aH\u0002RA\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/deliveryhero/performance/core/tapresponse/GlobalNavHostDestinationChangedListener;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "destinationPage", "Lcom/deliveryhero/performance/core/tapresponse/AndroidComponentViewContainer;", "viewContainer", "", "(Lkotlin/jvm/functions/Function2;)V", "getListener", "()Lkotlin/jvm/functions/Function2;", "onActivityCreated", "activity", "Landroid/app/Activity;", "p1", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "registerFragmentCreation", "Landroidx/fragment/app/FragmentActivity;", "Companion", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalNavHostDestinationChangedListener implements Application.ActivityLifecycleCallbacks {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Function2<String, AndroidComponentViewContainer, Unit> listener;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000626\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\b¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/performance/core/tapresponse/GlobalNavHostDestinationChangedListener$Companion;", "", "()V", "install", "", "application", "Landroid/app/Application;", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "destinationPage", "Lcom/deliveryhero/performance/core/tapresponse/AndroidComponentViewContainer;", "viewContainer", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void install(@NotNull Application application, @NotNull Function2<? super String, ? super AndroidComponentViewContainer, Unit> function2) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            application.registerActivityLifecycleCallbacks(new GlobalNavHostDestinationChangedListener(function2));
        }
    }

    public GlobalNavHostDestinationChangedListener(@NotNull Function2<? super String, ? super AndroidComponentViewContainer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = function2;
    }

    private final void registerFragmentCreation(FragmentActivity fragmentActivity) {
        fragmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(new GlobalNavHostDestinationChangedListener$registerFragmentCreation$1(this), true);
    }

    @NotNull
    public final Function2<String, AndroidComponentViewContainer, Unit> getListener() {
        return this.listener;
    }

    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.listener.invoke(PerformanceExtensionKt.getScreenName(activity), new AndroidComponentViewContainer.ActivityContainer(activity));
        if (activity instanceof FragmentActivity) {
            registerFragmentCreation((FragmentActivity) activity);
        }
    }

    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "p1");
    }

    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}
