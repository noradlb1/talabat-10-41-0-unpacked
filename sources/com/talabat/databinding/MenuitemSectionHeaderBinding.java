package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class MenuitemSectionHeaderBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout convertView;
    @NonNull
    public final LinearLayout linearLayout2;
    @NonNull
    public final ImageView listDiscount;
    @NonNull
    public final ImageView listSpecifier;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TalabatTextView sectionName;

    private MenuitemSectionHeaderBinding(@NonNull CardView cardView, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView) {
        this.rootView = cardView;
        this.convertView = relativeLayout;
        this.linearLayout2 = linearLayout;
        this.listDiscount = imageView;
        this.listSpecifier = imageView2;
        this.sectionName = talabatTextView;
    }

    @NonNull
    public static MenuitemSectionHeaderBinding bind(@NonNull View view) {
        int i11 = R.id.convertView;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.convertView);
        if (relativeLayout != null) {
            i11 = R.id.linearLayout2;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout2);
            if (linearLayout != null) {
                i11 = R.id.list_discount;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.list_discount);
                if (imageView != null) {
                    i11 = R.id.list_specifier;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.list_specifier);
                    if (imageView2 != null) {
                        i11 = R.id.section_name;
                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.section_name);
                        if (talabatTextView != null) {
                            return new MenuitemSectionHeaderBinding((CardView) view, relativeLayout, linearLayout, imageView, imageView2, talabatTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static MenuitemSectionHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static MenuitemSectionHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.menuitem_section_header, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CardView getRoot() {
        return this.rootView;
    }
}
