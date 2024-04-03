package com.talabat.feature.helpcenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.designsystem.ds_alert.DSAlert;
import com.talabat.feature.helpcenter.R;

public final class LayoutCancellationPolicyViewBinding implements ViewBinding {
    @NonNull
    public final DSAlert dsAlertCancellationPolicyNote;
    @NonNull
    private final DSAlert rootView;

    private LayoutCancellationPolicyViewBinding(@NonNull DSAlert dSAlert, @NonNull DSAlert dSAlert2) {
        this.rootView = dSAlert;
        this.dsAlertCancellationPolicyNote = dSAlert2;
    }

    @NonNull
    public static LayoutCancellationPolicyViewBinding bind(@NonNull View view) {
        if (view != null) {
            DSAlert dSAlert = (DSAlert) view;
            return new LayoutCancellationPolicyViewBinding(dSAlert, dSAlert);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static LayoutCancellationPolicyViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutCancellationPolicyViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_cancellation_policy_view, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public DSAlert getRoot() {
        return this.rootView;
    }
}
