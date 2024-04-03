package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class CheckoutAddressWithMapBinding implements ViewBinding {
    @NonNull
    public final LinearLayout addressDetailsView;
    @NonNull
    public final ImageView addressIcon;
    @NonNull
    public final LinearLayout addressLayoutViewAb;
    @NonNull
    public final TalabatTextView changeAddress;
    @NonNull
    public final ImageView deliveryIcon;
    @NonNull
    public final ViewStub locationFarViewStub;
    @NonNull
    public final LinearLayout mobileContainer;
    @NonNull
    public final TextView pickupPreorder;
    @NonNull
    public final TextView pickupTime;
    @NonNull
    public final RelativeLayout pickupTimeContainer;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RelativeLayout topMapView;
    @NonNull
    public final TalabatTextView txtAdditionalDirectionsAb;
    @NonNull
    public final TalabatTextView txtAddresMobileCcode;
    @NonNull
    public final TalabatTextView txtAddresMobileLabel;
    @NonNull
    public final TalabatTextView txtAddresPhoneAb;
    @NonNull
    public final TalabatTextView txtAddressAreanameAb;
    @NonNull
    public final TalabatTextView txtAddressDescriptionAb;
    @NonNull
    public final TalabatTextView txtAddressProfileNameAb;
    @NonNull
    public final TalabatTextView txtmobileNumber;

    private CheckoutAddressWithMapBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView2, @NonNull ViewStub viewStub, @NonNull LinearLayout linearLayout3, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull TalabatTextView talabatTextView7, @NonNull TalabatTextView talabatTextView8, @NonNull TalabatTextView talabatTextView9) {
        this.rootView = relativeLayout;
        this.addressDetailsView = linearLayout;
        this.addressIcon = imageView;
        this.addressLayoutViewAb = linearLayout2;
        this.changeAddress = talabatTextView;
        this.deliveryIcon = imageView2;
        this.locationFarViewStub = viewStub;
        this.mobileContainer = linearLayout3;
        this.pickupPreorder = textView;
        this.pickupTime = textView2;
        this.pickupTimeContainer = relativeLayout2;
        this.topMapView = relativeLayout3;
        this.txtAdditionalDirectionsAb = talabatTextView2;
        this.txtAddresMobileCcode = talabatTextView3;
        this.txtAddresMobileLabel = talabatTextView4;
        this.txtAddresPhoneAb = talabatTextView5;
        this.txtAddressAreanameAb = talabatTextView6;
        this.txtAddressDescriptionAb = talabatTextView7;
        this.txtAddressProfileNameAb = talabatTextView8;
        this.txtmobileNumber = talabatTextView9;
    }

    @NonNull
    public static CheckoutAddressWithMapBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.address_details_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.address_details_view);
        if (linearLayout != null) {
            i11 = R.id.address_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.address_icon);
            if (imageView != null) {
                i11 = R.id.address_layout_view_ab;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.address_layout_view_ab);
                if (linearLayout2 != null) {
                    i11 = R.id.change_address;
                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.change_address);
                    if (talabatTextView != null) {
                        i11 = R.id.delivery_icon;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.delivery_icon);
                        if (imageView2 != null) {
                            i11 = R.id.location_far_view_stub;
                            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view2, R.id.location_far_view_stub);
                            if (viewStub != null) {
                                i11 = R.id.mobileContainer;
                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.mobileContainer);
                                if (linearLayout3 != null) {
                                    i11 = R.id.pickup_preorder;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.pickup_preorder);
                                    if (textView != null) {
                                        i11 = R.id.pickup_time;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.pickup_time);
                                        if (textView2 != null) {
                                            i11 = R.id.pickupTimeContainer;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.pickupTimeContainer);
                                            if (relativeLayout != null) {
                                                i11 = R.id.top_map_view;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.top_map_view);
                                                if (relativeLayout2 != null) {
                                                    i11 = R.id.txtAdditionalDirectionsAb;
                                                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAdditionalDirectionsAb);
                                                    if (talabatTextView2 != null) {
                                                        i11 = R.id.txtAddresMobileCcode;
                                                        TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddresMobileCcode);
                                                        if (talabatTextView3 != null) {
                                                            i11 = R.id.txtAddresMobileLabel;
                                                            TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddresMobileLabel);
                                                            if (talabatTextView4 != null) {
                                                                i11 = R.id.txtAddresPhoneAb;
                                                                TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddresPhoneAb);
                                                                if (talabatTextView5 != null) {
                                                                    i11 = R.id.txtAddressAreanameAb;
                                                                    TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddressAreanameAb);
                                                                    if (talabatTextView6 != null) {
                                                                        i11 = R.id.txtAddressDescriptionAb;
                                                                        TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddressDescriptionAb);
                                                                        if (talabatTextView7 != null) {
                                                                            i11 = R.id.txtAddressProfileNameAb;
                                                                            TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtAddressProfileNameAb);
                                                                            if (talabatTextView8 != null) {
                                                                                i11 = R.id.txtmobileNumber;
                                                                                TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txtmobileNumber);
                                                                                if (talabatTextView9 != null) {
                                                                                    return new CheckoutAddressWithMapBinding((RelativeLayout) view2, linearLayout, imageView, linearLayout2, talabatTextView, imageView2, viewStub, linearLayout3, textView, textView2, relativeLayout, relativeLayout2, talabatTextView2, talabatTextView3, talabatTextView4, talabatTextView5, talabatTextView6, talabatTextView7, talabatTextView8, talabatTextView9);
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
    public static CheckoutAddressWithMapBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CheckoutAddressWithMapBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.checkout_address_with_map, viewGroup, false);
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
