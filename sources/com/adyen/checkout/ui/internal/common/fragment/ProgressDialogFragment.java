package com.adyen.checkout.ui.internal.common.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.util.ThemeUtil;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@Instrumented
public class ProgressDialogFragment extends AppCompatDialogFragment implements TraceFieldInterface {
    private static final int MINIMUM_SHOW_DURATION = 500;
    private static final int SHOW_DELAY = 250;
    private static final String TAG = "ProgressDialogFragment";
    public Trace _nr_trace;
    private long mShowTimestamp;

    private long getHideDelayMillis() {
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = this.mShowTimestamp;
        if (j11 <= currentTimeMillis) {
            return (j11 + 500) - currentTimeMillis;
        }
        return 0;
    }

    @NonNull
    private static Runnable getHideRunnable(@NonNull final WeakReference<FragmentManager> weakReference, @NonNull final WeakReference<Fragment> weakReference2) {
        return new Runnable() {
            public void run() {
                FragmentManager fragmentManager = (FragmentManager) weakReference.get();
                Fragment fragment = (Fragment) weakReference2.get();
                if (fragment != null) {
                    if (fragmentManager == null) {
                        fragmentManager = fragment.getFragmentManager();
                    }
                    if (fragmentManager != null) {
                        fragmentManager.beginTransaction().remove(fragment).commitAllowingStateLoss();
                        return;
                    }
                    throw new RuntimeException();
                }
            }
        };
    }

    public static void hide(@NonNull AppCompatActivity appCompatActivity) {
        hide(appCompatActivity.getSupportFragmentManager());
    }

    public static void show(@NonNull AppCompatActivity appCompatActivity) {
        show(appCompatActivity.getSupportFragmentManager());
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing(TAG);
        try {
            TraceMachine.enterMethod(this._nr_trace, "ProgressDialogFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ProgressDialogFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setCancelable(false);
        TraceMachine.exitMethod();
    }

    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.requestWindowFeature(1025);
        return onCreateDialog;
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        final View view = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "ProgressDialogFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ProgressDialogFragment#onCreateView", (ArrayList<String>) null);
        }
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            window.setWindowAnimations(R.style.ProgressDialogFragment_Window);
            view = window.getDecorView();
        }
        Context context = layoutInflater.getContext();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.progress_dialog_size);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.gravity = 17;
        ProgressBar progressBar = new ProgressBar(context);
        progressBar.setLayoutParams(layoutParams);
        progressBar.setIndeterminate(true);
        if (view != null) {
            this.mShowTimestamp = System.currentTimeMillis() + 250;
            view.setVisibility(8);
            view.postDelayed(new Runnable() {
                public void run() {
                    view.setVisibility(0);
                }
            }, 250);
        }
        ThemeUtil.applyPrimaryThemeColor(context, progressBar.getProgressDrawable(), progressBar.getIndeterminateDrawable());
        TraceMachine.exitMethod();
        return progressBar;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public static void hide(@NonNull Fragment fragment) {
        hide(fragment.getChildFragmentManager());
    }

    public static void show(@NonNull Fragment fragment) {
        show(fragment.getChildFragmentManager());
    }

    private static void hide(@NonNull FragmentManager fragmentManager) {
        if (!fragmentManager.isDestroyed()) {
            fragmentManager.executePendingTransactions();
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(TAG);
            if (findFragmentByTag instanceof ProgressDialogFragment) {
                long hideDelayMillis = ((ProgressDialogFragment) findFragmentByTag).getHideDelayMillis();
                Runnable hideRunnable = getHideRunnable(new WeakReference(fragmentManager), new WeakReference(findFragmentByTag));
                if (hideDelayMillis > 0) {
                    new Handler(Looper.getMainLooper()).postDelayed(hideRunnable, hideDelayMillis);
                } else {
                    hideRunnable.run();
                }
            }
        }
    }

    private static void show(@NonNull FragmentManager fragmentManager) {
        if (!fragmentManager.isDestroyed()) {
            fragmentManager.executePendingTransactions();
            String str = TAG;
            if (!(fragmentManager.findFragmentByTag(str) instanceof ProgressDialogFragment)) {
                fragmentManager.beginTransaction().add((Fragment) new ProgressDialogFragment(), str).commitAllowingStateLoss();
            }
        }
    }
}
