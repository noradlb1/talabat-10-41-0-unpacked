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
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class OffersListBottomsheetDialogBinding implements ViewBinding {
    @NonNull
    public final ImageView closeOffersImage;
    @NonNull
    public final LinearLayout closeOffersView;
    @NonNull
    public final RelativeLayout contentView;
    @NonNull
    public final TalabatTextView offersBottomSheetTitle;
    @NonNull
    public final RecyclerView offersList;
    @NonNull
    private final RelativeLayout rootView;

    private OffersListBottomsheetDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView, @NonNull RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.closeOffersImage = imageView;
        this.closeOffersView = linearLayout;
        this.contentView = relativeLayout2;
        this.offersBottomSheetTitle = talabatTextView;
        this.offersList = recyclerView;
    }

    @NonNull
    public static OffersListBottomsheetDialogBinding bind(@NonNull View view) {
        int i11 = R.id.close_offers_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.close_offers_image);
        if (imageView != null) {
            i11 = R.id.close_offers_view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.close_offers_view);
            if (linearLayout != null) {
                RelativeLayout relativeLayout = (RelativeLayout) view;
                i11 = R.id.offers_bottom_sheet_title;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.offers_bottom_sheet_title);
                if (talabatTextView != null) {
                    i11 = R.id.offers_list;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.offers_list);
                    if (recyclerView != null) {
                        return new OffersListBottomsheetDialogBinding(relativeLayout, imageView, linearLayout, relativeLayout, talabatTextView, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static OffersListBottomsheetDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static OffersListBottomsheetDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.offers_list_bottomsheet_dialog, viewGroup, false);
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
