package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_tag.DSTag;
import com.talabat.R;

public final class SideMenuBnplItemLayoutBinding implements ViewBinding {
    @NonNull
    public final DSTag bnplOverdueTag;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ImageView sideMenuHeaderIcon;
    @NonNull
    public final TextView sideMenuHeaderTitle;
    @NonNull
    public final ConstraintLayout sideMenuHeaderView;

    private SideMenuBnplItemLayoutBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSTag dSTag, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.bnplOverdueTag = dSTag;
        this.sideMenuHeaderIcon = imageView;
        this.sideMenuHeaderTitle = textView;
        this.sideMenuHeaderView = constraintLayout2;
    }

    @NonNull
    public static SideMenuBnplItemLayoutBinding bind(@NonNull View view) {
        int i11 = R.id.bnpl_overdue_tag;
        DSTag dSTag = (DSTag) ViewBindings.findChildViewById(view, R.id.bnpl_overdue_tag);
        if (dSTag != null) {
            i11 = R.id.side_menu_header_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.side_menu_header_icon);
            if (imageView != null) {
                i11 = R.id.side_menu_header_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.side_menu_header_title);
                if (textView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new SideMenuBnplItemLayoutBinding(constraintLayout, dSTag, imageView, textView, constraintLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static SideMenuBnplItemLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SideMenuBnplItemLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.side_menu_bnpl_item_layout, viewGroup, false);
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
