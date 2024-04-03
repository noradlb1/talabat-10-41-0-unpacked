package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.helpers.TalabatToolBar;

public final class ActivityMenuSearchBinding implements ViewBinding {
    @NonNull
    public final Button buttonCancelSearch;
    @NonNull
    public final MaterialEditText edSearch;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final ImageView ivClear;
    @NonNull
    public final ImageView ivNoItems;
    @NonNull
    public final RecyclerView rcvMenuItems;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final ImageView toolbarSearchIcon;
    @NonNull
    public final LinearLayout viewNoItems;
    @NonNull
    public final RelativeLayout viewSearchContainer;

    private ActivityMenuSearchBinding(@NonNull RelativeLayout relativeLayout, @NonNull Button button, @NonNull MaterialEditText materialEditText, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull RecyclerView recyclerView, @NonNull TalabatToolBar talabatToolBar, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout3) {
        this.rootView = relativeLayout;
        this.buttonCancelSearch = button;
        this.edSearch = materialEditText;
        this.gemFooterView = relativeLayout2;
        this.ivClear = imageView;
        this.ivNoItems = imageView2;
        this.rcvMenuItems = recyclerView;
        this.toolbar = talabatToolBar;
        this.toolbarSearchIcon = imageView3;
        this.viewNoItems = linearLayout;
        this.viewSearchContainer = relativeLayout3;
    }

    @NonNull
    public static ActivityMenuSearchBinding bind(@NonNull View view) {
        int i11 = R.id.button_cancel_search;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.button_cancel_search);
        if (button != null) {
            i11 = R.id.ed_search;
            MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.ed_search);
            if (materialEditText != null) {
                i11 = R.id.gem_footer_view;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.gem_footer_view);
                if (relativeLayout != null) {
                    i11 = R.id.iv_clear;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_clear);
                    if (imageView != null) {
                        i11 = R.id.iv_no_items;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_no_items);
                        if (imageView2 != null) {
                            i11 = R.id.rcv_menu_items;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rcv_menu_items);
                            if (recyclerView != null) {
                                i11 = R.id.toolbar;
                                TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                if (talabatToolBar != null) {
                                    i11 = R.id.toolbar_search_icon;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.toolbar_search_icon);
                                    if (imageView3 != null) {
                                        i11 = R.id.view_no_items;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.view_no_items);
                                        if (linearLayout != null) {
                                            i11 = R.id.view_search_container;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.view_search_container);
                                            if (relativeLayout2 != null) {
                                                return new ActivityMenuSearchBinding((RelativeLayout) view, button, materialEditText, relativeLayout, imageView, imageView2, recyclerView, talabatToolBar, imageView3, linearLayout, relativeLayout2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityMenuSearchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityMenuSearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_menu_search, viewGroup, false);
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
