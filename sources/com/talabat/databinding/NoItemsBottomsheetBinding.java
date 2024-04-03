package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_button.DSPrimaryButton;
import com.designsystem.ds_empty_state.DSEmptyState;
import com.talabat.R;

public final class NoItemsBottomsheetBinding implements ViewBinding {
    @NonNull
    public final LinearLayout buttonView;
    @NonNull
    public final ImageView closeBottomsheet;
    @NonNull
    public final DSEmptyState designSystemEmptyState;
    @NonNull
    public final LinearLayout errorNotification;
    @NonNull
    public final DSPrimaryButton goToMenu;
    @NonNull
    public final RelativeLayout noItemsBottomSheet;
    @NonNull
    private final RelativeLayout rootView;

    private NoItemsBottomsheetBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull DSEmptyState dSEmptyState, @NonNull LinearLayout linearLayout2, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.buttonView = linearLayout;
        this.closeBottomsheet = imageView;
        this.designSystemEmptyState = dSEmptyState;
        this.errorNotification = linearLayout2;
        this.goToMenu = dSPrimaryButton;
        this.noItemsBottomSheet = relativeLayout2;
    }

    @NonNull
    public static NoItemsBottomsheetBinding bind(@NonNull View view) {
        int i11 = R.id.button_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_view);
        if (linearLayout != null) {
            i11 = R.id.close_bottomsheet;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.close_bottomsheet);
            if (imageView != null) {
                i11 = R.id.design_system_empty_state;
                DSEmptyState dSEmptyState = (DSEmptyState) ViewBindings.findChildViewById(view, R.id.design_system_empty_state);
                if (dSEmptyState != null) {
                    i11 = R.id.error_notification;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.error_notification);
                    if (linearLayout2 != null) {
                        i11 = R.id.go_to_menu;
                        DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view, R.id.go_to_menu);
                        if (dSPrimaryButton != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) view;
                            return new NoItemsBottomsheetBinding(relativeLayout, linearLayout, imageView, dSEmptyState, linearLayout2, dSPrimaryButton, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static NoItemsBottomsheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static NoItemsBottomsheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.no_items_bottomsheet, viewGroup, false);
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
