package com.deliveryhero.performance.core.tapresponse;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/performance/core/tapresponse/AndroidComponentViewContainer;", "", "()V", "ActivityContainer", "FragmentContainer", "Lcom/deliveryhero/performance/core/tapresponse/AndroidComponentViewContainer$ActivityContainer;", "Lcom/deliveryhero/performance/core/tapresponse/AndroidComponentViewContainer$FragmentContainer;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AndroidComponentViewContainer {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/performance/core/tapresponse/AndroidComponentViewContainer$ActivityContainer;", "Lcom/deliveryhero/performance/core/tapresponse/AndroidComponentViewContainer;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ActivityContainer extends AndroidComponentViewContainer {
        @NotNull
        private final Activity activity;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ActivityContainer(@NotNull Activity activity2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(activity2, "activity");
            this.activity = activity2;
        }

        @NotNull
        public final Activity getActivity() {
            return this.activity;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/performance/core/tapresponse/AndroidComponentViewContainer$FragmentContainer;", "Lcom/deliveryhero/performance/core/tapresponse/AndroidComponentViewContainer;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getFragment", "()Landroidx/fragment/app/Fragment;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FragmentContainer extends AndroidComponentViewContainer {
        @NotNull
        private final Fragment fragment;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FragmentContainer(@NotNull Fragment fragment2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(fragment2, "fragment");
            this.fragment = fragment2;
        }

        @NotNull
        public final Fragment getFragment() {
            return this.fragment;
        }
    }

    private AndroidComponentViewContainer() {
    }

    public /* synthetic */ AndroidComponentViewContainer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
