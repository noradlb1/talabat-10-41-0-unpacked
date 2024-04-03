package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.talabat.darkstores.R;

public final class DarkstoresFragmentSearchResultsBinding implements ViewBinding {
    @NonNull
    public final TextView label;
    @NonNull
    public final DarkstoresNoResultsViewBinding noResultsView;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    private final LinearLayout rootView;

    private DarkstoresFragmentSearchResultsBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull DarkstoresNoResultsViewBinding darkstoresNoResultsViewBinding, @NonNull ProgressBar progressBar2, @NonNull RecyclerView recyclerView2) {
        this.rootView = linearLayout;
        this.label = textView;
        this.noResultsView = darkstoresNoResultsViewBinding;
        this.progressBar = progressBar2;
        this.recyclerView = recyclerView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.talabat.darkstores.R.id.noResultsView;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.talabat.darkstores.databinding.DarkstoresFragmentSearchResultsBinding bind(@androidx.annotation.NonNull android.view.View r8) {
        /*
            int r0 = com.talabat.darkstores.R.id.label
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0037
            int r0 = com.talabat.darkstores.R.id.noResultsView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r1 == 0) goto L_0x0037
            com.talabat.darkstores.databinding.DarkstoresNoResultsViewBinding r5 = com.talabat.darkstores.databinding.DarkstoresNoResultsViewBinding.bind(r1)
            int r0 = com.talabat.darkstores.R.id.progressBar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
            if (r6 == 0) goto L_0x0037
            int r0 = com.talabat.darkstores.R.id.recyclerView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x0037
            com.talabat.darkstores.databinding.DarkstoresFragmentSearchResultsBinding r0 = new com.talabat.darkstores.databinding.DarkstoresFragmentSearchResultsBinding
            r3 = r8
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x0037:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.databinding.DarkstoresFragmentSearchResultsBinding.bind(android.view.View):com.talabat.darkstores.databinding.DarkstoresFragmentSearchResultsBinding");
    }

    @NonNull
    public static DarkstoresFragmentSearchResultsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresFragmentSearchResultsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_fragment_search_results, viewGroup, false);
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
