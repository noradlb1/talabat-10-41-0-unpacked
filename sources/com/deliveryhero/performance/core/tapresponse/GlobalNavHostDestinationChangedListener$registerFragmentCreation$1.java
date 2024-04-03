package com.deliveryhero.performance.core.tapresponse;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.deliveryhero.performance.core.screenmetric.PerformanceExtensionKt;
import com.deliveryhero.performance.core.tapresponse.AndroidComponentViewContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/deliveryhero/performance/core/tapresponse/GlobalNavHostDestinationChangedListener$registerFragmentCreation$1", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "onFragmentCreated", "", "fm", "Landroidx/fragment/app/FragmentManager;", "fragment", "Landroidx/fragment/app/Fragment;", "savedInstanceState", "Landroid/os/Bundle;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalNavHostDestinationChangedListener$registerFragmentCreation$1 extends FragmentManager.FragmentLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlobalNavHostDestinationChangedListener f30382a;

    public GlobalNavHostDestinationChangedListener$registerFragmentCreation$1(GlobalNavHostDestinationChangedListener globalNavHostDestinationChangedListener) {
        this.f30382a = globalNavHostDestinationChangedListener;
    }

    public void onFragmentCreated(@NotNull FragmentManager fragmentManager, @NotNull Fragment fragment, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.f30382a.getListener().invoke(PerformanceExtensionKt.getScreenName(fragment), new AndroidComponentViewContainer.FragmentContainer(fragment));
    }
}
