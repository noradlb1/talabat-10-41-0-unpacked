package com.deliveryhero.performance.core.screentracker;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/performance/core/screentracker/FragmentLifecyclePerformanceTracker;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "()V", "onFragmentActivityCreated", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "fragment", "Landroidx/fragment/app/Fragment;", "savedInstanceState", "Landroid/os/Bundle;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class FragmentLifecyclePerformanceTracker extends FragmentManager.FragmentLifecycleCallbacks {
    public void onFragmentActivityCreated(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        TrackScreenPerformance trackScreenPerformanceAnnotation = ExtensionsKt.getTrackScreenPerformanceAnnotation(fragment);
        if (trackScreenPerformanceAnnotation != null) {
            ScreenPerformanceTracker.start(trackScreenPerformanceAnnotation.trace(), trackScreenPerformanceAnnotation.screenName(), trackScreenPerformanceAnnotation.screenType());
        }
        super.onFragmentActivityCreated(fragmentManager, fragment, bundle);
    }
}
