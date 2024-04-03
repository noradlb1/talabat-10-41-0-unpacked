package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;

public final class CityChoiceScreenBinding implements ViewBinding {
    @NonNull
    public final ImageButton back;
    @NonNull
    public final ImageButton cart;
    @NonNull
    public final TalabatTextView cartCount;
    @NonNull
    public final RelativeLayout cartHolder;
    @NonNull
    public final MaterialEditText citySearch;
    @NonNull
    public final ListView citylistView;
    @NonNull
    public final TalabatButton done;
    @NonNull
    public final ImageView noCityFound;
    @NonNull
    public final LinearLayout noCityView;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView searchForCity;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatTextView title;
    @NonNull
    public final Toolbar toolbar;

    private CityChoiceScreenBinding(@NonNull LinearLayout linearLayout, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout, @NonNull MaterialEditText materialEditText, @NonNull ListView listView, @NonNull TalabatButton talabatButton, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView2, @NonNull Toolbar toolbar2) {
        this.rootView = linearLayout;
        this.back = imageButton;
        this.cart = imageButton2;
        this.cartCount = talabatTextView;
        this.cartHolder = relativeLayout;
        this.citySearch = materialEditText;
        this.citylistView = listView;
        this.done = talabatButton;
        this.noCityFound = imageView;
        this.noCityView = linearLayout2;
        this.searchForCity = imageView2;
        this.talabatToolbar = relativeLayout2;
        this.title = talabatTextView2;
        this.toolbar = toolbar2;
    }

    @NonNull
    public static CityChoiceScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.back;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.back);
        if (imageButton != null) {
            i11 = R.id.cart;
            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view2, R.id.cart);
            if (imageButton2 != null) {
                i11 = R.id.cart_count;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.cart_count);
                if (talabatTextView != null) {
                    i11 = R.id.cart_holder;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.cart_holder);
                    if (relativeLayout != null) {
                        i11 = R.id.city_search;
                        MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.city_search);
                        if (materialEditText != null) {
                            i11 = R.id.citylistView;
                            ListView listView = (ListView) ViewBindings.findChildViewById(view2, R.id.citylistView);
                            if (listView != null) {
                                i11 = R.id.done;
                                TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.done);
                                if (talabatButton != null) {
                                    i11 = R.id.no_city_found;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.no_city_found);
                                    if (imageView != null) {
                                        i11 = R.id.no_city_view;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.no_city_view);
                                        if (linearLayout != null) {
                                            i11 = R.id.search_for_city;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.search_for_city);
                                            if (imageView2 != null) {
                                                i11 = R.id.talabat_toolbar;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_toolbar);
                                                if (relativeLayout2 != null) {
                                                    i11 = R.id.title;
                                                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                    if (talabatTextView2 != null) {
                                                        i11 = R.id.toolbar;
                                                        Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                        if (toolbar2 != null) {
                                                            return new CityChoiceScreenBinding((LinearLayout) view2, imageButton, imageButton2, talabatTextView, relativeLayout, materialEditText, listView, talabatButton, imageView, linearLayout, imageView2, relativeLayout2, talabatTextView2, toolbar2);
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
    public static CityChoiceScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CityChoiceScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.city_choice_screen, viewGroup, false);
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
