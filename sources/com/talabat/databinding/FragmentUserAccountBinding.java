package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_alert.DSAlert;
import com.talabat.R;

public final class FragmentUserAccountBinding implements ViewBinding {
    @NonNull
    public final DSAlert alertRenewalUpdateSuccess;
    @NonNull
    public final RecyclerView listSlidemenuHome;
    @NonNull
    private final ConstraintLayout rootView;

    private FragmentUserAccountBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSAlert dSAlert, @NonNull RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.alertRenewalUpdateSuccess = dSAlert;
        this.listSlidemenuHome = recyclerView;
    }

    @NonNull
    public static FragmentUserAccountBinding bind(@NonNull View view) {
        int i11 = R.id.alert_renewal_update_success;
        DSAlert dSAlert = (DSAlert) ViewBindings.findChildViewById(view, R.id.alert_renewal_update_success);
        if (dSAlert != null) {
            i11 = R.id.list_slidemenu_home;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.list_slidemenu_home);
            if (recyclerView != null) {
                return new FragmentUserAccountBinding((ConstraintLayout) view, dSAlert, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentUserAccountBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentUserAccountBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_user_account, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
