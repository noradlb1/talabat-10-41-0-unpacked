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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarButton;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class AddressListScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarButton addAddress;
    @NonNull
    public final RelativeLayout addressAvailableView;
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final RelativeLayout gemRemainderView;
    @NonNull
    public final TalabatTextView gemRemainderViewTxt;
    @NonNull
    public final ListView lstAddresses;
    @NonNull
    public final TalabatFillButton noAddressAddAddress;
    @NonNull
    public final LinearLayout noAddressView;
    @NonNull
    public final ImageButton noItemImg;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;

    private AddressListScreenBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatToolBarButton talabatToolBarButton, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull TalabatTextView talabatTextView, @NonNull ListView listView, @NonNull TalabatFillButton talabatFillButton, @NonNull LinearLayout linearLayout, @NonNull ImageButton imageButton, @NonNull RelativeLayout relativeLayout5, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = relativeLayout;
        this.addAddress = talabatToolBarButton;
        this.addressAvailableView = relativeLayout2;
        this.back = talabatToolBarImageButton;
        this.gemFooterView = relativeLayout3;
        this.gemRemainderView = relativeLayout4;
        this.gemRemainderViewTxt = talabatTextView;
        this.lstAddresses = listView;
        this.noAddressAddAddress = talabatFillButton;
        this.noAddressView = linearLayout;
        this.noItemImg = imageButton;
        this.talabatToolbar = relativeLayout5;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static AddressListScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.add_address;
        TalabatToolBarButton talabatToolBarButton = (TalabatToolBarButton) ViewBindings.findChildViewById(view2, R.id.add_address);
        if (talabatToolBarButton != null) {
            i11 = R.id.address_available_view;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.address_available_view);
            if (relativeLayout != null) {
                i11 = R.id.back;
                TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
                if (talabatToolBarImageButton != null) {
                    i11 = R.id.gem_footer_view;
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view);
                    if (relativeLayout2 != null) {
                        i11 = R.id.gem_remainder_view;
                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_remainder_view);
                        if (relativeLayout3 != null) {
                            i11 = R.id.gem_remainder_view_txt;
                            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.gem_remainder_view_txt);
                            if (talabatTextView != null) {
                                i11 = R.id.lstAddresses;
                                ListView listView = (ListView) ViewBindings.findChildViewById(view2, R.id.lstAddresses);
                                if (listView != null) {
                                    i11 = R.id.no_address_add_address;
                                    TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.no_address_add_address);
                                    if (talabatFillButton != null) {
                                        i11 = R.id.no_address_view;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.no_address_view);
                                        if (linearLayout != null) {
                                            i11 = R.id.no_item_img;
                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.no_item_img);
                                            if (imageButton != null) {
                                                i11 = R.id.talabat_toolbar;
                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_toolbar);
                                                if (relativeLayout4 != null) {
                                                    i11 = R.id.title;
                                                    TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                    if (talabatToolBarTextView != null) {
                                                        i11 = R.id.toolbar;
                                                        TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                        if (talabatToolBar != null) {
                                                            return new AddressListScreenBinding((RelativeLayout) view2, talabatToolBarButton, relativeLayout, talabatToolBarImageButton, relativeLayout2, relativeLayout3, talabatTextView, listView, talabatFillButton, linearLayout, imageButton, relativeLayout4, talabatToolBarTextView, talabatToolBar);
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
    public static AddressListScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static AddressListScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.address_list_screen, viewGroup, false);
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
