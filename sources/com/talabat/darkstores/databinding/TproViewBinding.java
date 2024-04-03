package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class TproViewBinding implements ViewBinding {
    @NonNull
    public final TextView freeDeliveryText;
    @NonNull
    public final ImageView headerProTag;
    @NonNull
    public final ImageView imgArrow;
    @NonNull
    private final View rootView;
    @NonNull
    public final TextView txtSubscribe;

    private TproViewBinding(@NonNull View view, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView2) {
        this.rootView = view;
        this.freeDeliveryText = textView;
        this.headerProTag = imageView;
        this.imgArrow = imageView2;
        this.txtSubscribe = textView2;
    }

    @NonNull
    public static TproViewBinding bind(@NonNull View view) {
        int i11 = R.id.free_delivery_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.header_pro_tag;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.img_arrow;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView2 != null) {
                    i11 = R.id.txt_subscribe;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        return new TproViewBinding(view, textView, imageView, imageView2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static TproViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.tpro_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
