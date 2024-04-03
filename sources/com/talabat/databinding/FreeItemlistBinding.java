package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;

public final class FreeItemlistBinding implements ViewBinding {
    @NonNull
    public final ImageButton back;
    @NonNull
    public final ImageButton cart;
    @NonNull
    public final TalabatTextView cartCount;
    @NonNull
    public final RelativeLayout cartHolder;
    @NonNull
    public final TalabatButton done;
    @NonNull
    public final ListView freeItemList;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatTextView title;
    @NonNull
    public final Toolbar toolbar;

    private FreeItemlistBinding(@NonNull LinearLayout linearLayout, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout, @NonNull TalabatButton talabatButton, @NonNull ListView listView, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView2, @NonNull Toolbar toolbar2) {
        this.rootView = linearLayout;
        this.back = imageButton;
        this.cart = imageButton2;
        this.cartCount = talabatTextView;
        this.cartHolder = relativeLayout;
        this.done = talabatButton;
        this.freeItemList = listView;
        this.talabatToolbar = relativeLayout2;
        this.title = talabatTextView2;
        this.toolbar = toolbar2;
    }

    @NonNull
    public static FreeItemlistBinding bind(@NonNull View view) {
        int i11 = R.id.back;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.back);
        if (imageButton != null) {
            i11 = R.id.cart;
            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.cart);
            if (imageButton2 != null) {
                i11 = R.id.cart_count;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.cart_count);
                if (talabatTextView != null) {
                    i11 = R.id.cart_holder;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.cart_holder);
                    if (relativeLayout != null) {
                        i11 = R.id.done;
                        TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view, R.id.done);
                        if (talabatButton != null) {
                            i11 = R.id.free_item_list;
                            ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.free_item_list);
                            if (listView != null) {
                                i11 = R.id.talabat_toolbar;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.talabat_toolbar);
                                if (relativeLayout2 != null) {
                                    i11 = R.id.title;
                                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.title);
                                    if (talabatTextView2 != null) {
                                        i11 = R.id.toolbar;
                                        Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                        if (toolbar2 != null) {
                                            return new FreeItemlistBinding((LinearLayout) view, imageButton, imageButton2, talabatTextView, relativeLayout, talabatButton, listView, relativeLayout2, talabatTextView2, toolbar2);
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
    public static FreeItemlistBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FreeItemlistBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.free_itemlist, viewGroup, false);
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
