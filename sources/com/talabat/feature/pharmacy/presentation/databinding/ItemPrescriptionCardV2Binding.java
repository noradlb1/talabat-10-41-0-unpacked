package com.talabat.feature.pharmacy.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.pharmacy.presentation.R;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final class ItemPrescriptionCardV2Binding implements ViewBinding {
    @NonNull
    public final TextView btnPrescription;
    @NonNull
    public final ImageView ivMedicine;
    @NonNull
    public final TextView poweredBy;
    @NonNull
    public final LinearLayoutCompat prescriptionCardContainer;
    @NonNull
    private final LinearLayoutCompat rootView;
    @NonNull
    public final ShimmerLayout shimmerLayout;
    @NonNull
    public final TextView title;
    @NonNull
    public final TextView tvFirstSection;
    @NonNull
    public final TextView tvSecondSection;
    @NonNull
    public final TextView tvThirdSection;
    @NonNull
    public final CardView vPrescriptionCard;

    private ItemPrescriptionCardV2Binding(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull ShimmerLayout shimmerLayout2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull CardView cardView) {
        this.rootView = linearLayoutCompat;
        this.btnPrescription = textView;
        this.ivMedicine = imageView;
        this.poweredBy = textView2;
        this.prescriptionCardContainer = linearLayoutCompat2;
        this.shimmerLayout = shimmerLayout2;
        this.title = textView3;
        this.tvFirstSection = textView4;
        this.tvSecondSection = textView5;
        this.tvThirdSection = textView6;
        this.vPrescriptionCard = cardView;
    }

    @NonNull
    public static ItemPrescriptionCardV2Binding bind(@NonNull View view) {
        int i11 = R.id.btn_prescription;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.ivMedicine;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.poweredBy;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
                    i11 = R.id.shimmerLayout;
                    ShimmerLayout shimmerLayout2 = (ShimmerLayout) ViewBindings.findChildViewById(view, i11);
                    if (shimmerLayout2 != null) {
                        i11 = R.id.title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView3 != null) {
                            i11 = R.id.tvFirstSection;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView4 != null) {
                                i11 = R.id.tvSecondSection;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView5 != null) {
                                    i11 = R.id.tvThirdSection;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView6 != null) {
                                        i11 = R.id.vPrescriptionCard;
                                        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i11);
                                        if (cardView != null) {
                                            return new ItemPrescriptionCardV2Binding(linearLayoutCompat, textView, imageView, textView2, linearLayoutCompat, shimmerLayout2, textView3, textView4, textView5, textView6, cardView);
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
    public static ItemPrescriptionCardV2Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemPrescriptionCardV2Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_prescription_card_v2, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }
}
