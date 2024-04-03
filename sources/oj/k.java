package oj;

import com.talabat.darkstores.data.search.model.SearchResultsResponse;
import com.talabat.darkstores.feature.searchResults.SearchResultsUseCase;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class k implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResultsUseCase f57090b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57091c;

    public /* synthetic */ k(SearchResultsUseCase searchResultsUseCase, String str) {
        this.f57090b = searchResultsUseCase;
        this.f57091c = str;
    }

    public final void accept(Object obj) {
        SearchResultsUseCase.m10090search$lambda6(this.f57090b, this.f57091c, (SearchResultsResponse) obj);
    }
}
