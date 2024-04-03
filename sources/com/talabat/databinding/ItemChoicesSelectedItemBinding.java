package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ItemChoicesSelectedItemBinding implements ViewBinding {
    @NonNull
    public final ImageView deleteChoice;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TalabatTextView selectedItemName;

    private ItemChoicesSelectedItemBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView) {
        this.rootView = cardView;
        this.deleteChoice = imageView;
        this.selectedItemName = talabatTextView;
    }

    @NonNull
    public static ItemChoicesSelectedItemBinding bind(@NonNull View view) {
        int i11 = R.id.delete_choice;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.delete_choice);
        if (imageView != null) {
            i11 = R.id.selected_item_name;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.selected_item_name);
            if (talabatTextView != null) {
                return new ItemChoicesSelectedItemBinding((CardView) view, imageView, talabatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemChoicesSelectedItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemChoicesSelectedItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_choices_selected_item, viewGroup, false);
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
