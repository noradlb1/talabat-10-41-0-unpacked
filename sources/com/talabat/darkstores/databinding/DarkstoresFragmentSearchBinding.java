package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresFragmentSearchBinding implements ViewBinding {
    @NonNull
    public final LinearLayout container;
    @NonNull
    public final ImageView ivNoItems;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final SearchView searchView;
    @NonNull
    public final TextView textViewAllResults;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final LinearLayout tvEmpty;
    @NonNull
    public final TextView tvNoResultsTitle;
    @NonNull
    public final LinearLayout viewAllResults;

    private DarkstoresFragmentSearchBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull ProgressBar progressBar2, @NonNull RecyclerView recyclerView2, @NonNull SearchView searchView2, @NonNull TextView textView, @NonNull Toolbar toolbar2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView2, @NonNull LinearLayout linearLayout4) {
        this.rootView = linearLayout;
        this.container = linearLayout2;
        this.ivNoItems = imageView;
        this.progressBar = progressBar2;
        this.recyclerView = recyclerView2;
        this.searchView = searchView2;
        this.textViewAllResults = textView;
        this.toolbar = toolbar2;
        this.tvEmpty = linearLayout3;
        this.tvNoResultsTitle = textView2;
        this.viewAllResults = linearLayout4;
    }

    @NonNull
    public static DarkstoresFragmentSearchBinding bind(@NonNull View view) {
        int i11 = R.id.container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
        if (linearLayout != null) {
            i11 = R.id.iv_no_items;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.progressBar;
                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i11);
                if (progressBar2 != null) {
                    i11 = R.id.recyclerView;
                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                    if (recyclerView2 != null) {
                        i11 = R.id.searchView;
                        SearchView searchView2 = (SearchView) ViewBindings.findChildViewById(view, i11);
                        if (searchView2 != null) {
                            i11 = R.id.text_view_all_results;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView != null) {
                                i11 = R.id.toolbar;
                                Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, i11);
                                if (toolbar2 != null) {
                                    i11 = R.id.tvEmpty;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                                    if (linearLayout2 != null) {
                                        i11 = R.id.tvNoResultsTitle;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                                        if (textView2 != null) {
                                            i11 = R.id.view_all_results;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                                            if (linearLayout3 != null) {
                                                return new DarkstoresFragmentSearchBinding((LinearLayout) view, linearLayout, imageView, progressBar2, recyclerView2, searchView2, textView, toolbar2, linearLayout2, textView2, linearLayout3);
                                            }
                                        }
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
    public static DarkstoresFragmentSearchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentSearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_search, viewGroup, false);
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
