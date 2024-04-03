package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ActivityChooseSavedAddressBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView addressTitle;
    @NonNull
    public final RelativeLayout contentView;
    @NonNull
    public final ImageView deliverCurrentLocationArrow;
    @NonNull
    public final ImageView deliverCurrentLocationImg;
    @NonNull
    public final ProgressBar deliverCurrentLocationProgress;
    @NonNull
    public final RelativeLayout deliverDiffLocation;
    @NonNull
    public final RelativeLayout deliverHereContainer;
    @NonNull
    public final RelativeLayout deliverToCurrentLocation;
    @NonNull
    public final RelativeLayout headerContainer;
    @NonNull
    public final ImageView imageView11;
    @NonNull
    public final ImageView imageView12;
    @NonNull
    public final RelativeLayout mainContainer;
    @NonNull
    public final TalabatTextView outOfDeliveryTxt;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ImageView savedAddClose;
    @NonNull
    public final RecyclerView savedAddressList;
    @NonNull
    public final FrameLayout seperatorOne;
    @NonNull
    public final FrameLayout seperatorTwo;
    @NonNull
    public final TalabatTextView title;
    @NonNull
    public final TalabatTextView txtChooseMapTxt;
    @NonNull
    public final TalabatTextView txtDeliverToMyCurrentLoc;

    private ActivityChooseSavedAddressBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull RelativeLayout relativeLayout5, @NonNull RelativeLayout relativeLayout6, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull RelativeLayout relativeLayout7, @NonNull TalabatTextView talabatTextView2, @NonNull ImageView imageView5, @NonNull RecyclerView recyclerView, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5) {
        this.rootView = relativeLayout;
        this.addressTitle = talabatTextView;
        this.contentView = relativeLayout2;
        this.deliverCurrentLocationArrow = imageView;
        this.deliverCurrentLocationImg = imageView2;
        this.deliverCurrentLocationProgress = progressBar;
        this.deliverDiffLocation = relativeLayout3;
        this.deliverHereContainer = relativeLayout4;
        this.deliverToCurrentLocation = relativeLayout5;
        this.headerContainer = relativeLayout6;
        this.imageView11 = imageView3;
        this.imageView12 = imageView4;
        this.mainContainer = relativeLayout7;
        this.outOfDeliveryTxt = talabatTextView2;
        this.savedAddClose = imageView5;
        this.savedAddressList = recyclerView;
        this.seperatorOne = frameLayout;
        this.seperatorTwo = frameLayout2;
        this.title = talabatTextView3;
        this.txtChooseMapTxt = talabatTextView4;
        this.txtDeliverToMyCurrentLoc = talabatTextView5;
    }

    @NonNull
    public static ActivityChooseSavedAddressBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.address_title;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.address_title);
        if (talabatTextView != null) {
            i11 = R.id.content_view;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.content_view);
            if (relativeLayout != null) {
                i11 = R.id.deliver_current_location_arrow;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.deliver_current_location_arrow);
                if (imageView != null) {
                    i11 = R.id.deliver_current_location_img;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.deliver_current_location_img);
                    if (imageView2 != null) {
                        i11 = R.id.deliver_current_location_progress;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.deliver_current_location_progress);
                        if (progressBar != null) {
                            i11 = R.id.deliver_diff_location;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.deliver_diff_location);
                            if (relativeLayout2 != null) {
                                i11 = R.id.deliver_here_container;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.deliver_here_container);
                                if (relativeLayout3 != null) {
                                    i11 = R.id.deliver_to_current_location;
                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.deliver_to_current_location);
                                    if (relativeLayout4 != null) {
                                        i11 = R.id.header_container;
                                        RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.header_container);
                                        if (relativeLayout5 != null) {
                                            i11 = R.id.imageView11;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView11);
                                            if (imageView3 != null) {
                                                i11 = R.id.imageView12;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView12);
                                                if (imageView4 != null) {
                                                    RelativeLayout relativeLayout6 = (RelativeLayout) view2;
                                                    i11 = R.id.out_of_delivery_txt;
                                                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.out_of_delivery_txt);
                                                    if (talabatTextView2 != null) {
                                                        i11 = R.id.saved_add_close;
                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.saved_add_close);
                                                        if (imageView5 != null) {
                                                            i11 = R.id.saved_address_list;
                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.saved_address_list);
                                                            if (recyclerView != null) {
                                                                i11 = R.id.seperator_one;
                                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.seperator_one);
                                                                if (frameLayout != null) {
                                                                    i11 = R.id.seperator_two;
                                                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.seperator_two);
                                                                    if (frameLayout2 != null) {
                                                                        i11 = R.id.title;
                                                                        TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                        if (talabatTextView3 != null) {
                                                                            i11 = R.id.txt_choose_map_txt;
                                                                            TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txt_choose_map_txt);
                                                                            if (talabatTextView4 != null) {
                                                                                i11 = R.id.txt_deliver_to_my_current_loc;
                                                                                TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.txt_deliver_to_my_current_loc);
                                                                                if (talabatTextView5 != null) {
                                                                                    return new ActivityChooseSavedAddressBinding(relativeLayout6, talabatTextView, relativeLayout, imageView, imageView2, progressBar, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, imageView3, imageView4, relativeLayout6, talabatTextView2, imageView5, recyclerView, frameLayout, frameLayout2, talabatTextView3, talabatTextView4, talabatTextView5);
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
    public static ActivityChooseSavedAddressBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityChooseSavedAddressBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_choose_saved_address, viewGroup, false);
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
