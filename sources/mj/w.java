package mj;

import android.view.View;
import com.talabat.darkstores.feature.search.SearchSuggestionsAdapter;
import com.talabat.darkstores.model.SearchSuggestion;

public final /* synthetic */ class w implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchSuggestionsAdapter f57053b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SearchSuggestion f57054c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f57055d;

    public /* synthetic */ w(SearchSuggestionsAdapter searchSuggestionsAdapter, SearchSuggestion searchSuggestion, int i11) {
        this.f57053b = searchSuggestionsAdapter;
        this.f57054c = searchSuggestion;
        this.f57055d = i11;
    }

    public final void onClick(View view) {
        SearchSuggestionsAdapter.m10077onBindViewHolder$lambda2$lambda1(this.f57053b, this.f57054c, this.f57055d, view);
    }
}
