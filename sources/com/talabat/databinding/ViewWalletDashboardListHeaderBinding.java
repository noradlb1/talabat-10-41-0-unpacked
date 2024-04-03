package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ViewWalletDashboardListHeaderBinding implements ViewBinding {
    @NonNull
    public final TextView recentTransactionText;
    @NonNull
    private final RelativeLayout rootView;

    private ViewWalletDashboardListHeaderBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView) {
        this.rootView = relativeLayout;
        this.recentTransactionText = textView;
    }

    @NonNull
    public static ViewWalletDashboardListHeaderBinding bind(@NonNull View view) {
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.recent_transaction_text);
        if (textView != null) {
            return new ViewWalletDashboardListHeaderBinding((RelativeLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.recent_transaction_text)));
    }

    @NonNull
    public static ViewWalletDashboardListHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewWalletDashboardListHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_wallet_dashboard_list_header, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
