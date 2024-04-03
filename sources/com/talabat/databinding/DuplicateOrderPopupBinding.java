package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatRadioButton;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class DuplicateOrderPopupBinding implements ViewBinding {
    @NonNull
    public final ImageView closePopupButton;
    @NonNull
    public final TalabatFillButton confirm;
    @NonNull
    public final RelativeLayout continueOrder;
    @NonNull
    public final TalabatRadioButton continueRadio;
    @NonNull
    public final TalabatTextView duplicateMessage;
    @NonNull
    public final TalabatButton homeBtn;
    @NonNull
    public final RelativeLayout modifyOrderOption;
    @NonNull
    public final TalabatRadioButton modifyRadio;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final RelativeLayout viewOrder;
    @NonNull
    public final TalabatRadioButton viewOrderRadio;

    private DuplicateOrderPopupBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TalabatFillButton talabatFillButton, @NonNull RelativeLayout relativeLayout, @NonNull TalabatRadioButton talabatRadioButton, @NonNull TalabatTextView talabatTextView, @NonNull TalabatButton talabatButton, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatRadioButton talabatRadioButton2, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatRadioButton talabatRadioButton3) {
        this.rootView = linearLayout;
        this.closePopupButton = imageView;
        this.confirm = talabatFillButton;
        this.continueOrder = relativeLayout;
        this.continueRadio = talabatRadioButton;
        this.duplicateMessage = talabatTextView;
        this.homeBtn = talabatButton;
        this.modifyOrderOption = relativeLayout2;
        this.modifyRadio = talabatRadioButton2;
        this.viewOrder = relativeLayout3;
        this.viewOrderRadio = talabatRadioButton3;
    }

    @NonNull
    public static DuplicateOrderPopupBinding bind(@NonNull View view) {
        int i11 = R.id.close_popup_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.close_popup_button);
        if (imageView != null) {
            i11 = R.id.confirm;
            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.confirm);
            if (talabatFillButton != null) {
                i11 = R.id.continue_order;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.continue_order);
                if (relativeLayout != null) {
                    i11 = R.id.continue_radio;
                    TalabatRadioButton talabatRadioButton = (TalabatRadioButton) ViewBindings.findChildViewById(view, R.id.continue_radio);
                    if (talabatRadioButton != null) {
                        i11 = R.id.duplicate_message;
                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.duplicate_message);
                        if (talabatTextView != null) {
                            i11 = R.id.home_btn;
                            TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view, R.id.home_btn);
                            if (talabatButton != null) {
                                i11 = R.id.modify_order_option;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.modify_order_option);
                                if (relativeLayout2 != null) {
                                    i11 = R.id.modify_radio;
                                    TalabatRadioButton talabatRadioButton2 = (TalabatRadioButton) ViewBindings.findChildViewById(view, R.id.modify_radio);
                                    if (talabatRadioButton2 != null) {
                                        i11 = R.id.view_order;
                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.view_order);
                                        if (relativeLayout3 != null) {
                                            i11 = R.id.view_order_radio;
                                            TalabatRadioButton talabatRadioButton3 = (TalabatRadioButton) ViewBindings.findChildViewById(view, R.id.view_order_radio);
                                            if (talabatRadioButton3 != null) {
                                                return new DuplicateOrderPopupBinding((LinearLayout) view, imageView, talabatFillButton, relativeLayout, talabatRadioButton, talabatTextView, talabatButton, relativeLayout2, talabatRadioButton2, relativeLayout3, talabatRadioButton3);
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
    public static DuplicateOrderPopupBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DuplicateOrderPopupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.duplicate_order_popup, viewGroup, false);
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
