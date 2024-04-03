package com.instabug.library.tracking;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class h extends FragmentManager.FragmentLifecycleCallbacks {
    public void onFragmentAttached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull Context context) {
        super.onFragmentAttached(fragmentManager, fragment, context);
        InstabugInternalTrackingDelegate.getInstance().h(fragment);
    }

    public void onFragmentDetached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        super.onFragmentDetached(fragmentManager, fragment);
        InstabugInternalTrackingDelegate.getInstance().i(fragment);
    }

    public void onFragmentPaused(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        super.onFragmentPaused(fragmentManager, fragment);
        InstabugInternalTrackingDelegate.getInstance().j(fragment);
    }

    public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        super.onFragmentResumed(fragmentManager, fragment);
        InstabugInternalTrackingDelegate.getInstance().k(fragment);
    }

    public void onFragmentStarted(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        super.onFragmentStarted(fragmentManager, fragment);
        InstabugInternalTrackingDelegate.getInstance().l(fragment);
    }

    public void onFragmentStopped(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        super.onFragmentStopped(fragmentManager, fragment);
        InstabugInternalTrackingDelegate.getInstance().m(fragment);
    }

    public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
        super.onFragmentViewCreated(fragmentManager, fragment, view, bundle);
        InstabugInternalTrackingDelegate.getInstance().n(fragment);
    }
}
