package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class ProductTagViewBinding implements ViewBinding {
    @NonNull
    public final TextView moreProductTag;
    @NonNull
    private final View rootView;
    @NonNull
    public final LinearLayout tagRoot;
    @NonNull
    public final TextView txtProductTag;

    private ProductTagViewBinding(@NonNull View view, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2) {
        this.rootView = view;
        this.moreProductTag = textView;
        this.tagRoot = linearLayout;
        this.txtProductTag = textView2;
    }

    @NonNull
    public static ProductTagViewBinding bind(@NonNull View view) {
        int i11 = R.id.more_product_tag;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.tag_root;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
            if (linearLayout != null) {
                i11 = R.id.txt_product_tag;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new ProductTagViewBinding(view, textView, linearLayout, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ProductTagViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.product_tag_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
