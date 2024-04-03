package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;
import com.talabat.helpers.MiniCartLayout;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarSearchLinearLayout;

public final class ActivityGroceryMenuSearchBinding implements ViewBinding {
    @NonNull
    public final TalabatButton clearSearchHistory;
    @NonNull
    public final MaterialEditText edSearch;
    @NonNull
    public final RelativeLayout footer;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final ImageView grocerySearchIcon;
    @NonNull
    public final TalabatTextView itemCount;
    @NonNull
    public final ImageView ivBack;
    @NonNull
    public final ImageView ivClear;
    @NonNull
    public final ImageView ivEmptySearch;
    @NonNull
    public final ImageView ivNoItems;
    @NonNull
    public final ProgressBar linearProgressBar;
    @NonNull
    public final MiniCartLayout miniCart;
    @NonNull
    public final RecyclerView rcvMenuItems;
    @NonNull
    public final RecyclerView recentSearchList;
    @NonNull
    public final LinearLayout recentSearchView;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RecyclerView tagsRecyclerview;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final RelativeLayout toolbarBackground;
    @NonNull
    public final LinearLayout viewEmptySearch;
    @NonNull
    public final LinearLayout viewNoItems;
    @NonNull
    public final TalabatToolBarSearchLinearLayout viewSearchContainer;

    private ActivityGroceryMenuSearchBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatButton talabatButton, @NonNull MaterialEditText materialEditText, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ProgressBar progressBar, @NonNull MiniCartLayout miniCartLayout, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView3, @NonNull TalabatToolBar talabatToolBar, @NonNull RelativeLayout relativeLayout4, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TalabatToolBarSearchLinearLayout talabatToolBarSearchLinearLayout) {
        this.rootView = relativeLayout;
        this.clearSearchHistory = talabatButton;
        this.edSearch = materialEditText;
        this.footer = relativeLayout2;
        this.gemFooterView = relativeLayout3;
        this.grocerySearchIcon = imageView;
        this.itemCount = talabatTextView;
        this.ivBack = imageView2;
        this.ivClear = imageView3;
        this.ivEmptySearch = imageView4;
        this.ivNoItems = imageView5;
        this.linearProgressBar = progressBar;
        this.miniCart = miniCartLayout;
        this.rcvMenuItems = recyclerView;
        this.recentSearchList = recyclerView2;
        this.recentSearchView = linearLayout;
        this.tagsRecyclerview = recyclerView3;
        this.toolbar = talabatToolBar;
        this.toolbarBackground = relativeLayout4;
        this.viewEmptySearch = linearLayout2;
        this.viewNoItems = linearLayout3;
        this.viewSearchContainer = talabatToolBarSearchLinearLayout;
    }

    @NonNull
    public static ActivityGroceryMenuSearchBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.clear_search_history;
        TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.clear_search_history);
        if (talabatButton != null) {
            i11 = R.id.ed_search;
            MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.ed_search);
            if (materialEditText != null) {
                i11 = R.id.footer;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.footer);
                if (relativeLayout != null) {
                    i11 = R.id.gem_footer_view;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view);
                    if (relativeLayout2 != null) {
                        i11 = R.id.grocery_search_icon;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.grocery_search_icon);
                        if (imageView != null) {
                            i11 = R.id.item_count;
                            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.item_count);
                            if (talabatTextView != null) {
                                i11 = R.id.iv_back;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_back);
                                if (imageView2 != null) {
                                    i11 = R.id.iv_clear;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_clear);
                                    if (imageView3 != null) {
                                        i11 = R.id.iv_empty_search;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_empty_search);
                                        if (imageView4 != null) {
                                            i11 = R.id.iv_no_items;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_no_items);
                                            if (imageView5 != null) {
                                                i11 = R.id.linear_progressBar;
                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.linear_progressBar);
                                                if (progressBar != null) {
                                                    i11 = R.id.miniCart;
                                                    MiniCartLayout miniCartLayout = (MiniCartLayout) ViewBindings.findChildViewById(view2, R.id.miniCart);
                                                    if (miniCartLayout != null) {
                                                        i11 = R.id.rcv_menu_items;
                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.rcv_menu_items);
                                                        if (recyclerView != null) {
                                                            i11 = R.id.recent_search_list;
                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.recent_search_list);
                                                            if (recyclerView2 != null) {
                                                                i11 = R.id.recent_search_view;
                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.recent_search_view);
                                                                if (linearLayout != null) {
                                                                    i11 = R.id.tags_recyclerview;
                                                                    RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.tags_recyclerview);
                                                                    if (recyclerView3 != null) {
                                                                        i11 = R.id.toolbar;
                                                                        TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                        if (talabatToolBar != null) {
                                                                            i11 = R.id.toolbar_background;
                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.toolbar_background);
                                                                            if (relativeLayout3 != null) {
                                                                                i11 = R.id.view_empty_search;
                                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.view_empty_search);
                                                                                if (linearLayout2 != null) {
                                                                                    i11 = R.id.view_no_items;
                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.view_no_items);
                                                                                    if (linearLayout3 != null) {
                                                                                        i11 = R.id.view_search_container;
                                                                                        TalabatToolBarSearchLinearLayout talabatToolBarSearchLinearLayout = (TalabatToolBarSearchLinearLayout) ViewBindings.findChildViewById(view2, R.id.view_search_container);
                                                                                        if (talabatToolBarSearchLinearLayout != null) {
                                                                                            return new ActivityGroceryMenuSearchBinding((RelativeLayout) view2, talabatButton, materialEditText, relativeLayout, relativeLayout2, imageView, talabatTextView, imageView2, imageView3, imageView4, imageView5, progressBar, miniCartLayout, recyclerView, recyclerView2, linearLayout, recyclerView3, talabatToolBar, relativeLayout3, linearLayout2, linearLayout3, talabatToolBarSearchLinearLayout);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityGroceryMenuSearchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityGroceryMenuSearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_grocery_menu_search, viewGroup, false);
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
