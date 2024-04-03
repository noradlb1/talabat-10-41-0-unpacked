package oj;

import android.view.View;
import com.talabat.darkstores.data.SearchCategory;
import com.talabat.darkstores.feature.searchResults.SearchCategoriesAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchCategoriesAdapter f57079b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SearchCategory f57080c;

    public /* synthetic */ a(SearchCategoriesAdapter searchCategoriesAdapter, SearchCategory searchCategory) {
        this.f57079b = searchCategoriesAdapter;
        this.f57080c = searchCategory;
    }

    public final void onClick(View view) {
        SearchCategoriesAdapter.ViewHolder.m10079bind$lambda0(this.f57079b, this.f57080c, view);
    }
}
