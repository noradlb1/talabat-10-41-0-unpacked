package oj;

import com.talabat.darkstores.feature.searchResults.SearchResultsUseCase;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class l implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResultsUseCase f57092b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57093c;

    public /* synthetic */ l(SearchResultsUseCase searchResultsUseCase, String str) {
        this.f57092b = searchResultsUseCase;
        this.f57093c = str;
    }

    public final void accept(Object obj) {
        SearchResultsUseCase.m10091search$lambda7(this.f57092b, this.f57093c, (Throwable) obj);
    }
}
