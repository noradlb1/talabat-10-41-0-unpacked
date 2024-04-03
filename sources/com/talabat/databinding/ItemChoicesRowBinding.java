package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ItemChoicesRowBinding implements ViewBinding {
    @NonNull
    public final LinearLayout costLay;
    @NonNull
    public final TalabatTextView itemChoiceCostoldPrice;
    @NonNull
    public final TalabatTextView itemChoiceCosttextView1;
    @NonNull
    public final TalabatTextView itemChoiceNametextView1;
    @NonNull
    public final RelativeLayout relativeLayout1;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final CheckBox statuscheckimageView1;

    private ItemChoicesRowBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull RelativeLayout relativeLayout2, @NonNull CheckBox checkBox) {
        this.rootView = relativeLayout;
        this.costLay = linearLayout;
        this.itemChoiceCostoldPrice = talabatTextView;
        this.itemChoiceCosttextView1 = talabatTextView2;
        this.itemChoiceNametextView1 = talabatTextView3;
        this.relativeLayout1 = relativeLayout2;
        this.statuscheckimageView1 = checkBox;
    }

    @NonNull
    public static ItemChoicesRowBinding bind(@NonNull View view) {
        int i11 = R.id.costLay;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.costLay);
        if (linearLayout != null) {
            i11 = R.id.item_choice_costoldPrice;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.item_choice_costoldPrice);
            if (talabatTextView != null) {
                i11 = R.id.item_choice_costtextView1;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.item_choice_costtextView1);
                if (talabatTextView2 != null) {
                    i11 = R.id.itemChoice_nametextView1;
                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.itemChoice_nametextView1);
                    if (talabatTextView3 != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) view;
                        i11 = R.id.statuscheckimageView1;
                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.statuscheckimageView1);
                        if (checkBox != null) {
                            return new ItemChoicesRowBinding(relativeLayout, linearLayout, talabatTextView, talabatTextView2, talabatTextView3, relativeLayout, checkBox);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemChoicesRowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemChoicesRowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_choices_row, viewGroup, false);
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
