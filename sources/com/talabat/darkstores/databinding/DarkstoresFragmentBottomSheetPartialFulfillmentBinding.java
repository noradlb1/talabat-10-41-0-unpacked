package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresFragmentBottomSheetPartialFulfillmentBinding implements ViewBinding {
    @NonNull
    public final TextView always;
    @NonNull
    public final LinearLayout guestActions;
    @NonNull
    public final TextView justOnce;
    @NonNull
    public final LinearLayout loggedActions;
    @NonNull
    public final AppCompatTextView partialFulfillmentBottomTitle;
    @NonNull
    public final ImageView partialFulfillmentClose;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView update;

    private DarkstoresFragmentBottomSheetPartialFulfillmentBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2, @NonNull LinearLayout linearLayout3, @NonNull AppCompatTextView appCompatTextView, @NonNull ImageView imageView, @NonNull RecyclerView recyclerView2, @NonNull TextView textView3) {
        this.rootView = linearLayout;
        this.always = textView;
        this.guestActions = linearLayout2;
        this.justOnce = textView2;
        this.loggedActions = linearLayout3;
        this.partialFulfillmentBottomTitle = appCompatTextView;
        this.partialFulfillmentClose = imageView;
        this.recyclerView = recyclerView2;
        this.update = textView3;
    }

    @NonNull
    public static DarkstoresFragmentBottomSheetPartialFulfillmentBinding bind(@NonNull View view) {
        int i11 = R.id.always;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.guest_actions;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
            if (linearLayout != null) {
                i11 = R.id.just_once;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.logged_actions;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                    if (linearLayout2 != null) {
                        i11 = R.id.partial_fulfillment_bottom_title;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R.id.partial_fulfillment_close;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                            if (imageView != null) {
                                i11 = R.id.recyclerView;
                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                                if (recyclerView2 != null) {
                                    i11 = R.id.update;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView3 != null) {
                                        return new DarkstoresFragmentBottomSheetPartialFulfillmentBinding((LinearLayout) view, textView, linearLayout, textView2, linearLayout2, appCompatTextView, imageView, recyclerView2, textView3);
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
    public static DarkstoresFragmentBottomSheetPartialFulfillmentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentBottomSheetPartialFulfillmentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_bottom_sheet_partial_fulfillment, viewGroup, false);
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
