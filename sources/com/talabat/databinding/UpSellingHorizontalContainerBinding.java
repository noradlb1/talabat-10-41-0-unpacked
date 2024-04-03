package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class UpSellingHorizontalContainerBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView upSellingImg;
    @NonNull
    public final TalabatTextView upSellingTxt;
    @NonNull
    public final RecyclerView upSellingVerticalList;
    @NonNull
    public final LinearLayout upsellingContainer;

    private UpSellingHorizontalContainerBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.upSellingImg = imageView;
        this.upSellingTxt = talabatTextView;
        this.upSellingVerticalList = recyclerView;
        this.upsellingContainer = linearLayout2;
    }

    @NonNull
    public static UpSellingHorizontalContainerBinding bind(@NonNull View view) {
        int i11 = R.id.up_selling_img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.up_selling_img);
        if (imageView != null) {
            i11 = R.id.up_selling_txt;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.up_selling_txt);
            if (talabatTextView != null) {
                i11 = R.id.up_selling_vertical_list;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.up_selling_vertical_list);
                if (recyclerView != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    return new UpSellingHorizontalContainerBinding(linearLayout, imageView, talabatTextView, recyclerView, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static UpSellingHorizontalContainerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static UpSellingHorizontalContainerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.up_selling_horizontal_container, viewGroup, false);
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
