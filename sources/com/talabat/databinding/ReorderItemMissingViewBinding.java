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

public final class ReorderItemMissingViewBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout closeReorderStatus;
    @NonNull
    public final TextView reorderItemMissingContent;
    @NonNull
    private final RelativeLayout rootView;

    private ReorderItemMissingViewBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView) {
        this.rootView = relativeLayout;
        this.closeReorderStatus = relativeLayout2;
        this.reorderItemMissingContent = textView;
    }

    @NonNull
    public static ReorderItemMissingViewBinding bind(@NonNull View view) {
        int i11 = R.id.close_reorder_status;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.close_reorder_status);
        if (relativeLayout != null) {
            i11 = R.id.reorder_item_missing_content;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.reorder_item_missing_content);
            if (textView != null) {
                return new ReorderItemMissingViewBinding((RelativeLayout) view, relativeLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ReorderItemMissingViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ReorderItemMissingViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.reorder_item_missing_view, viewGroup, false);
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
