package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;

public final class CountryCodeChoiceScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final TalabatToolBarImageButton cart;
    @NonNull
    public final TalabatToolBarTextView cartCount;
    @NonNull
    public final RelativeLayout cartHolder;
    @NonNull
    public final ImageView clearSearch;
    @NonNull
    public final RecyclerView countryCodenormallistView;
    @NonNull
    public final TalabatButton done;
    @NonNull
    public final LinearLayout drawerLayout;
    @NonNull
    public final ImageView noCodeTxt;
    @NonNull
    public final RelativeLayout noCodeView;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final MaterialEditText searchCountryCode;
    @NonNull
    public final ImageView searchForCountryCode;
    @NonNull
    public final TalabatTextView talabatTextView15;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private CountryCodeChoiceScreenBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatToolBarImageButton talabatToolBarImageButton2, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull RecyclerView recyclerView, @NonNull TalabatButton talabatButton, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout2, @NonNull MaterialEditText materialEditText, @NonNull ImageView imageView3, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatToolBarTextView talabatToolBarTextView2, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = linearLayout;
        this.back = talabatToolBarImageButton;
        this.cart = talabatToolBarImageButton2;
        this.cartCount = talabatToolBarTextView;
        this.cartHolder = relativeLayout;
        this.clearSearch = imageView;
        this.countryCodenormallistView = recyclerView;
        this.done = talabatButton;
        this.drawerLayout = linearLayout2;
        this.noCodeTxt = imageView2;
        this.noCodeView = relativeLayout2;
        this.searchCountryCode = materialEditText;
        this.searchForCountryCode = imageView3;
        this.talabatTextView15 = talabatTextView;
        this.talabatToolbar = relativeLayout3;
        this.title = talabatToolBarTextView2;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static CountryCodeChoiceScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.cart;
            TalabatToolBarImageButton talabatToolBarImageButton2 = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.cart);
            if (talabatToolBarImageButton2 != null) {
                i11 = R.id.cart_count;
                TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.cart_count);
                if (talabatToolBarTextView != null) {
                    i11 = R.id.cart_holder;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.cart_holder);
                    if (relativeLayout != null) {
                        i11 = R.id.clearSearch;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.clearSearch);
                        if (imageView != null) {
                            i11 = R.id.country_codenormallistView;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.country_codenormallistView);
                            if (recyclerView != null) {
                                i11 = R.id.done;
                                TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.done);
                                if (talabatButton != null) {
                                    LinearLayout linearLayout = (LinearLayout) view2;
                                    i11 = R.id.no_code_txt;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.no_code_txt);
                                    if (imageView2 != null) {
                                        i11 = R.id.no_code_view;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.no_code_view);
                                        if (relativeLayout2 != null) {
                                            i11 = R.id.search_country_code;
                                            MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.search_country_code);
                                            if (materialEditText != null) {
                                                i11 = R.id.search_for_country_code;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.search_for_country_code);
                                                if (imageView3 != null) {
                                                    i11 = R.id.talabatTextView15;
                                                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabatTextView15);
                                                    if (talabatTextView != null) {
                                                        i11 = R.id.talabat_toolbar;
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_toolbar);
                                                        if (relativeLayout3 != null) {
                                                            i11 = R.id.title;
                                                            TalabatToolBarTextView talabatToolBarTextView2 = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                            if (talabatToolBarTextView2 != null) {
                                                                i11 = R.id.toolbar;
                                                                TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                if (talabatToolBar != null) {
                                                                    return new CountryCodeChoiceScreenBinding(linearLayout, talabatToolBarImageButton, talabatToolBarImageButton2, talabatToolBarTextView, relativeLayout, imageView, recyclerView, talabatButton, linearLayout, imageView2, relativeLayout2, materialEditText, imageView3, talabatTextView, relativeLayout3, talabatToolBarTextView2, talabatToolBar);
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
    public static CountryCodeChoiceScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CountryCodeChoiceScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.country_code_choice_screen, viewGroup, false);
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
