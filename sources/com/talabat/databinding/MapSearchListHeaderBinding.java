package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class MapSearchListHeaderBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout convertView;
    @NonNull
    public final ImageView expandbleArrow;
    @NonNull
    public final TalabatTextView header;
    @NonNull
    public final TalabatTextView headerSelectedTxt;
    @NonNull
    public final LinearLayout linearLayout2;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final FrameLayout seperatorBottomHeader;
    @NonNull
    public final FrameLayout seperatorTopHeader;

    private MapSearchListHeaderBinding(@NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull LinearLayout linearLayout3, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.rootView = linearLayout;
        this.convertView = relativeLayout;
        this.expandbleArrow = imageView;
        this.header = talabatTextView;
        this.headerSelectedTxt = talabatTextView2;
        this.linearLayout2 = linearLayout3;
        this.seperatorBottomHeader = frameLayout;
        this.seperatorTopHeader = frameLayout2;
    }

    @NonNull
    public static MapSearchListHeaderBinding bind(@NonNull View view) {
        int i11 = R.id.convertView;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.convertView);
        if (relativeLayout != null) {
            i11 = R.id.expandble_arrow;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.expandble_arrow);
            if (imageView != null) {
                i11 = R.id.header;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.header);
                if (talabatTextView != null) {
                    i11 = R.id.header_selected_txt;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.header_selected_txt);
                    if (talabatTextView2 != null) {
                        i11 = R.id.linearLayout2;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout2);
                        if (linearLayout != null) {
                            i11 = R.id.seperator_bottom_header;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.seperator_bottom_header);
                            if (frameLayout != null) {
                                i11 = R.id.seperator_top_header;
                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.seperator_top_header);
                                if (frameLayout2 != null) {
                                    return new MapSearchListHeaderBinding((LinearLayout) view, relativeLayout, imageView, talabatTextView, talabatTextView2, linearLayout, frameLayout, frameLayout2);
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
    public static MapSearchListHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static MapSearchListHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.map_search_list_header, viewGroup, false);
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
