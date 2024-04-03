package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;

public final class ItemChoicesScreenBinding implements ViewBinding {
    @NonNull
    public final ImageButton back;
    @NonNull
    public final ImageButton cart;
    @NonNull
    public final TalabatTextView cartCount;
    @NonNull
    public final RelativeLayout cartHolder;
    @NonNull
    public final TalabatTextView choiceSectionHeader;
    @NonNull
    public final TalabatTextView choiceSelectionText;
    @NonNull
    public final RecyclerView choicelist;
    @NonNull
    public final TalabatButton done;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final RelativeLayout gemRemainderView;
    @NonNull
    public final TalabatTextView gemRemainderViewTxt;
    @NonNull
    public final LinearLayout headerView;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RecyclerView selectedChoices;
    @NonNull
    public final TalabatTextView selectedChoicesNames;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatTextView title;
    @NonNull
    public final Toolbar toolbar;

    private ItemChoicesScreenBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull RecyclerView recyclerView, @NonNull TalabatButton talabatButton, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull TalabatTextView talabatTextView4, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView2, @NonNull TalabatTextView talabatTextView5, @NonNull RelativeLayout relativeLayout5, @NonNull TalabatTextView talabatTextView6, @NonNull Toolbar toolbar2) {
        this.rootView = relativeLayout;
        this.back = imageButton;
        this.cart = imageButton2;
        this.cartCount = talabatTextView;
        this.cartHolder = relativeLayout2;
        this.choiceSectionHeader = talabatTextView2;
        this.choiceSelectionText = talabatTextView3;
        this.choicelist = recyclerView;
        this.done = talabatButton;
        this.gemFooterView = relativeLayout3;
        this.gemRemainderView = relativeLayout4;
        this.gemRemainderViewTxt = talabatTextView4;
        this.headerView = linearLayout;
        this.selectedChoices = recyclerView2;
        this.selectedChoicesNames = talabatTextView5;
        this.talabatToolbar = relativeLayout5;
        this.title = talabatTextView6;
        this.toolbar = toolbar2;
    }

    @NonNull
    public static ItemChoicesScreenBinding bind(@NonNull View view) {
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
                        i11 = R.id.choice_section_header;
                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.choice_section_header);
                        if (talabatTextView2 != null) {
                            i11 = R.id.choice_selection_text;
                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.choice_selection_text);
                            if (talabatTextView3 != null) {
                                i11 = R.id.choicelist;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.choicelist);
                                if (recyclerView != null) {
                                    i11 = R.id.done;
                                    TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.done);
                                    if (talabatButton != null) {
                                        i11 = R.id.gem_footer_view;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view);
                                        if (relativeLayout2 != null) {
                                            i11 = R.id.gem_remainder_view;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_remainder_view);
                                            if (relativeLayout3 != null) {
                                                i11 = R.id.gem_remainder_view_txt;
                                                TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.gem_remainder_view_txt);
                                                if (talabatTextView4 != null) {
                                                    i11 = R.id.header_view;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.header_view);
                                                    if (linearLayout != null) {
                                                        i11 = R.id.selectedChoices;
                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.selectedChoices);
                                                        if (recyclerView2 != null) {
                                                            i11 = R.id.selected_choices_names;
                                                            TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.selected_choices_names);
                                                            if (talabatTextView5 != null) {
                                                                i11 = R.id.talabat_toolbar;
                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_toolbar);
                                                                if (relativeLayout4 != null) {
                                                                    i11 = R.id.title;
                                                                    TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                    if (talabatTextView6 != null) {
                                                                        i11 = R.id.toolbar;
                                                                        Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                        if (toolbar2 != null) {
                                                                            return new ItemChoicesScreenBinding((RelativeLayout) view2, imageButton, imageButton2, talabatTextView, relativeLayout, talabatTextView2, talabatTextView3, recyclerView, talabatButton, relativeLayout2, relativeLayout3, talabatTextView4, linearLayout, recyclerView2, talabatTextView5, relativeLayout4, talabatTextView6, toolbar2);
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
    public static ItemChoicesScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemChoicesScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_choices_screen, viewGroup, false);
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
