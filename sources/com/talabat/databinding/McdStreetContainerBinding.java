package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class McdStreetContainerBinding implements ViewBinding {
    @NonNull
    public final ImageView deliveringImg;
    @NonNull
    public final LinearLayout linearLayout3;
    @NonNull
    public final RelativeLayout mcdBlockContainerTitle;
    @NonNull
    public final TalabatTextView mcdBlockTitle;
    @NonNull
    public final TalabatTextView mcdInfoTxt;
    @NonNull
    public final Button mcdStreetEditLocationBtn;
    @NonNull
    public final MaterialEditText mcdStreetFld;
    @NonNull
    public final TalabatFillButton mcdStreetProceedOrder;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RelativeLayout streetSection;
    @NonNull
    public final TalabatTextView streetTxt;

    private McdStreetContainerBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull Button button, @NonNull MaterialEditText materialEditText, @NonNull TalabatFillButton talabatFillButton, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatTextView talabatTextView3) {
        this.rootView = relativeLayout;
        this.deliveringImg = imageView;
        this.linearLayout3 = linearLayout;
        this.mcdBlockContainerTitle = relativeLayout2;
        this.mcdBlockTitle = talabatTextView;
        this.mcdInfoTxt = talabatTextView2;
        this.mcdStreetEditLocationBtn = button;
        this.mcdStreetFld = materialEditText;
        this.mcdStreetProceedOrder = talabatFillButton;
        this.streetSection = relativeLayout3;
        this.streetTxt = talabatTextView3;
    }

    @NonNull
    public static McdStreetContainerBinding bind(@NonNull View view) {
        int i11 = R.id.delivering_img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.delivering_img);
        if (imageView != null) {
            i11 = R.id.linearLayout3;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout3);
            if (linearLayout != null) {
                i11 = R.id.mcd_block_container_title;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.mcd_block_container_title);
                if (relativeLayout != null) {
                    i11 = R.id.mcd_block_title;
                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.mcd_block_title);
                    if (talabatTextView != null) {
                        i11 = R.id.mcd_info_txt;
                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.mcd_info_txt);
                        if (talabatTextView2 != null) {
                            i11 = R.id.mcd_street_edit_location_btn;
                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.mcd_street_edit_location_btn);
                            if (button != null) {
                                i11 = R.id.mcd_street_fld;
                                MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.mcd_street_fld);
                                if (materialEditText != null) {
                                    i11 = R.id.mcd_street_proceed_order;
                                    TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.mcd_street_proceed_order);
                                    if (talabatFillButton != null) {
                                        i11 = R.id.street_section;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.street_section);
                                        if (relativeLayout2 != null) {
                                            i11 = R.id.street_txt;
                                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.street_txt);
                                            if (talabatTextView3 != null) {
                                                return new McdStreetContainerBinding((RelativeLayout) view, imageView, linearLayout, relativeLayout, talabatTextView, talabatTextView2, button, materialEditText, talabatFillButton, relativeLayout2, talabatTextView3);
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
    public static McdStreetContainerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static McdStreetContainerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.mcd_street_container, viewGroup, false);
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
