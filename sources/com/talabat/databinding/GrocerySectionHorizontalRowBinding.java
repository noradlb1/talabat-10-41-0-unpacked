package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class GrocerySectionHorizontalRowBinding implements ViewBinding {
    @NonNull
    public final CardView contentView;
    @NonNull
    public final RecyclerView menuItemsList;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TalabatTextView sectionTitle;
    @NonNull
    public final ImageButton showMore;

    private GrocerySectionHorizontalRowBinding(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull RecyclerView recyclerView, @NonNull TalabatTextView talabatTextView, @NonNull ImageButton imageButton) {
        this.rootView = cardView;
        this.contentView = cardView2;
        this.menuItemsList = recyclerView;
        this.sectionTitle = talabatTextView;
        this.showMore = imageButton;
    }

    @NonNull
    public static GrocerySectionHorizontalRowBinding bind(@NonNull View view) {
        CardView cardView = (CardView) view;
        int i11 = R.id.menu_items_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.menu_items_list);
        if (recyclerView != null) {
            i11 = R.id.section_title;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.section_title);
            if (talabatTextView != null) {
                i11 = R.id.show_more;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.show_more);
                if (imageButton != null) {
                    return new GrocerySectionHorizontalRowBinding(cardView, cardView, recyclerView, talabatTextView, imageButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static GrocerySectionHorizontalRowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GrocerySectionHorizontalRowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.grocery_section_horizontal_row, viewGroup, false);
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
