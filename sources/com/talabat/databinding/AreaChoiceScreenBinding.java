package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarButton;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarSearchRelativeLayout;
import com.talabat.helpers.TalabatToolBarTextView;

public final class AreaChoiceScreenBinding implements ViewBinding {
    @NonNull
    public final LinearLayout areaListView;
    @NonNull
    public final ExpandableListView arealistView;
    @NonNull
    public final ListView areanormallistView;
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final TalabatToolBarImageButton cart;
    @NonNull
    public final TalabatToolBarTextView cartCount;
    @NonNull
    public final RelativeLayout cartHolder;
    @NonNull
    public final ImageView clearButton;
    @NonNull
    public final TalabatToolBarButton done;
    @NonNull
    public final LinearLayout drawerLayout;
    @NonNull
    public final RelativeLayout mainContainer;
    @NonNull
    public final ImageView noAreaFound;
    @NonNull
    public final LinearLayout noAreaView;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final MaterialEditText searchArea;
    @NonNull
    public final ImageView searchClear;
    @NonNull
    public final ImageView searchForArea;
    @NonNull
    public final TalabatToolBarSearchRelativeLayout searchLayout;
    @NonNull
    public final CardView searchLayoutCard;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private AreaChoiceScreenBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ExpandableListView expandableListView, @NonNull ListView listView, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatToolBarImageButton talabatToolBarImageButton2, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TalabatToolBarButton talabatToolBarButton, @NonNull LinearLayout linearLayout3, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout4, @NonNull MaterialEditText materialEditText, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull TalabatToolBarSearchRelativeLayout talabatToolBarSearchRelativeLayout, @NonNull CardView cardView, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatToolBarTextView talabatToolBarTextView2, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = linearLayout;
        this.areaListView = linearLayout2;
        this.arealistView = expandableListView;
        this.areanormallistView = listView;
        this.back = talabatToolBarImageButton;
        this.cart = talabatToolBarImageButton2;
        this.cartCount = talabatToolBarTextView;
        this.cartHolder = relativeLayout;
        this.clearButton = imageView;
        this.done = talabatToolBarButton;
        this.drawerLayout = linearLayout3;
        this.mainContainer = relativeLayout2;
        this.noAreaFound = imageView2;
        this.noAreaView = linearLayout4;
        this.searchArea = materialEditText;
        this.searchClear = imageView3;
        this.searchForArea = imageView4;
        this.searchLayout = talabatToolBarSearchRelativeLayout;
        this.searchLayoutCard = cardView;
        this.talabatToolbar = relativeLayout3;
        this.title = talabatToolBarTextView2;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static AreaChoiceScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.area_list_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.area_list_view);
        if (linearLayout != null) {
            i11 = R.id.arealistView;
            ExpandableListView expandableListView = (ExpandableListView) ViewBindings.findChildViewById(view2, R.id.arealistView);
            if (expandableListView != null) {
                i11 = R.id.areanormallistView;
                ListView listView = (ListView) ViewBindings.findChildViewById(view2, R.id.areanormallistView);
                if (listView != null) {
                    i11 = R.id.back;
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
                                    i11 = R.id.clear_button;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.clear_button);
                                    if (imageView != null) {
                                        i11 = R.id.done;
                                        TalabatToolBarButton talabatToolBarButton = (TalabatToolBarButton) ViewBindings.findChildViewById(view2, R.id.done);
                                        if (talabatToolBarButton != null) {
                                            LinearLayout linearLayout2 = (LinearLayout) view2;
                                            i11 = R.id.main_container;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.main_container);
                                            if (relativeLayout2 != null) {
                                                i11 = R.id.no_area_found;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.no_area_found);
                                                if (imageView2 != null) {
                                                    i11 = R.id.no_area_view;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.no_area_view);
                                                    if (linearLayout3 != null) {
                                                        i11 = R.id.search_area;
                                                        MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.search_area);
                                                        if (materialEditText != null) {
                                                            i11 = R.id.search_clear;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.search_clear);
                                                            if (imageView3 != null) {
                                                                i11 = R.id.search_for_area;
                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.search_for_area);
                                                                if (imageView4 != null) {
                                                                    i11 = R.id.search_layout;
                                                                    TalabatToolBarSearchRelativeLayout talabatToolBarSearchRelativeLayout = (TalabatToolBarSearchRelativeLayout) ViewBindings.findChildViewById(view2, R.id.search_layout);
                                                                    if (talabatToolBarSearchRelativeLayout != null) {
                                                                        i11 = R.id.search_layout_card;
                                                                        CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.search_layout_card);
                                                                        if (cardView != null) {
                                                                            i11 = R.id.talabat_toolbar;
                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_toolbar);
                                                                            if (relativeLayout3 != null) {
                                                                                i11 = R.id.title;
                                                                                TalabatToolBarTextView talabatToolBarTextView2 = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                                if (talabatToolBarTextView2 != null) {
                                                                                    i11 = R.id.toolbar;
                                                                                    TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                    if (talabatToolBar != null) {
                                                                                        return new AreaChoiceScreenBinding(linearLayout2, linearLayout, expandableListView, listView, talabatToolBarImageButton, talabatToolBarImageButton2, talabatToolBarTextView, relativeLayout, imageView, talabatToolBarButton, linearLayout2, relativeLayout2, imageView2, linearLayout3, materialEditText, imageView3, imageView4, talabatToolBarSearchRelativeLayout, cardView, relativeLayout3, talabatToolBarTextView2, talabatToolBar);
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
    public static AreaChoiceScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static AreaChoiceScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.area_choice_screen, viewGroup, false);
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
