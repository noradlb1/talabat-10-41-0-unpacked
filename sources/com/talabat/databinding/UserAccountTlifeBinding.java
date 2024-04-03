package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.talabatlife.ui.tLifeWidget.TLifeView;

public final class UserAccountTlifeBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ConstraintLayout sideMenuTlifeHeaderView;
    @NonNull
    public final TLifeView tLifeSidemenuWidget;

    private UserAccountTlifeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TLifeView tLifeView) {
        this.rootView = constraintLayout;
        this.sideMenuTlifeHeaderView = constraintLayout2;
        this.tLifeSidemenuWidget = tLifeView;
    }

    @NonNull
    public static UserAccountTlifeBinding bind(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        TLifeView tLifeView = (TLifeView) ViewBindings.findChildViewById(view, R.id.t_life_sidemenu_widget);
        if (tLifeView != null) {
            return new UserAccountTlifeBinding(constraintLayout, constraintLayout, tLifeView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.t_life_sidemenu_widget)));
    }

    @NonNull
    public static UserAccountTlifeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static UserAccountTlifeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.user_account_tlife, viewGroup, false);
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
