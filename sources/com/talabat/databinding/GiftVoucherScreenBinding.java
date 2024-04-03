package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;

public final class GiftVoucherScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final LinearLayout bottomLayout;
    @NonNull
    public final TalabatTextView buyVoucherMessage;
    @NonNull
    public final RelativeLayout giftVoucherContentAmount;
    @NonNull
    public final NestedScrollView giftVoucherContentView;
    @NonNull
    public final RelativeLayout loadingLayout;
    @NonNull
    public final LinearLayout middleLayout;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final LinearLayout topLayout;
    @NonNull
    public final ImageButton voucher1;
    @NonNull
    public final ImageButton voucher2;
    @NonNull
    public final ImageButton voucher3;
    @NonNull
    public final ImageButton voucher4;
    @NonNull
    public final ImageButton voucher5;
    @NonNull
    public final ImageButton voucher6;

    private GiftVoucherScreenBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout, @NonNull NestedScrollView nestedScrollView, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayout linearLayout3, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar, @NonNull LinearLayout linearLayout4, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull ImageButton imageButton3, @NonNull ImageButton imageButton4, @NonNull ImageButton imageButton5, @NonNull ImageButton imageButton6) {
        this.rootView = linearLayout;
        this.back = talabatToolBarImageButton;
        this.bottomLayout = linearLayout2;
        this.buyVoucherMessage = talabatTextView;
        this.giftVoucherContentAmount = relativeLayout;
        this.giftVoucherContentView = nestedScrollView;
        this.loadingLayout = relativeLayout2;
        this.middleLayout = linearLayout3;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
        this.topLayout = linearLayout4;
        this.voucher1 = imageButton;
        this.voucher2 = imageButton2;
        this.voucher3 = imageButton3;
        this.voucher4 = imageButton4;
        this.voucher5 = imageButton5;
        this.voucher6 = imageButton6;
    }

    @NonNull
    public static GiftVoucherScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.bottom_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.bottom_layout);
            if (linearLayout != null) {
                i11 = R.id.buy_voucher_message;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.buy_voucher_message);
                if (talabatTextView != null) {
                    i11 = R.id.gift_voucher_content_amount;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gift_voucher_content_amount);
                    if (relativeLayout != null) {
                        i11 = R.id.gift_voucher_content_view;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.gift_voucher_content_view);
                        if (nestedScrollView != null) {
                            i11 = R.id.loading_layout;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.loading_layout);
                            if (relativeLayout2 != null) {
                                i11 = R.id.middle_layout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.middle_layout);
                                if (linearLayout2 != null) {
                                    i11 = R.id.title;
                                    TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                    if (talabatToolBarTextView != null) {
                                        i11 = R.id.toolbar;
                                        TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                        if (talabatToolBar != null) {
                                            i11 = R.id.top_layout;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.top_layout);
                                            if (linearLayout3 != null) {
                                                i11 = R.id.voucher1;
                                                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.voucher1);
                                                if (imageButton != null) {
                                                    i11 = R.id.voucher2;
                                                    ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view2, R.id.voucher2);
                                                    if (imageButton2 != null) {
                                                        i11 = R.id.voucher3;
                                                        ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view2, R.id.voucher3);
                                                        if (imageButton3 != null) {
                                                            i11 = R.id.voucher4;
                                                            ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view2, R.id.voucher4);
                                                            if (imageButton4 != null) {
                                                                i11 = R.id.voucher5;
                                                                ImageButton imageButton5 = (ImageButton) ViewBindings.findChildViewById(view2, R.id.voucher5);
                                                                if (imageButton5 != null) {
                                                                    i11 = R.id.voucher6;
                                                                    ImageButton imageButton6 = (ImageButton) ViewBindings.findChildViewById(view2, R.id.voucher6);
                                                                    if (imageButton6 != null) {
                                                                        return new GiftVoucherScreenBinding((LinearLayout) view2, talabatToolBarImageButton, linearLayout, talabatTextView, relativeLayout, nestedScrollView, relativeLayout2, linearLayout2, talabatToolBarTextView, talabatToolBar, linearLayout3, imageButton, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6);
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
    public static GiftVoucherScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GiftVoucherScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.gift_voucher_screen, viewGroup, false);
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
