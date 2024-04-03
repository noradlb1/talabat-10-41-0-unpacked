package com.talabat.feature.helpcenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.helpcenter.R;

public final class LayoutCancellationPolicyBottomsheetBinding implements ViewBinding {
    @NonNull
    public final TextView cancelPolicyTitle;
    @NonNull
    public final RecyclerView cancellationPolicyList;
    @NonNull
    public final ImageView closeBottomSheet;
    @NonNull
    private final LinearLayout rootView;

    private LayoutCancellationPolicyBottomsheetBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull ImageView imageView) {
        this.rootView = linearLayout;
        this.cancelPolicyTitle = textView;
        this.cancellationPolicyList = recyclerView;
        this.closeBottomSheet = imageView;
    }

    @NonNull
    public static LayoutCancellationPolicyBottomsheetBinding bind(@NonNull View view) {
        int i11 = R.id.cancel_policy_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.cancellation_policy_list;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
            if (recyclerView != null) {
                i11 = R.id.close_bottom_sheet;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView != null) {
                    return new LayoutCancellationPolicyBottomsheetBinding((LinearLayout) view, textView, recyclerView, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LayoutCancellationPolicyBottomsheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutCancellationPolicyBottomsheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_cancellation_policy_bottomsheet, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
