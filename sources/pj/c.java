package pj;

import com.talabat.darkstores.feature.searchResults.SearchResultsType;
import com.talabat.darkstores.feature.searchResults.paging.PageNumberPagingSource;
import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResultsType f57179b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PageNumberPagingSource f57180c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f57181d;

    public /* synthetic */ c(SearchResultsType searchResultsType, PageNumberPagingSource pageNumberPagingSource, int i11) {
        this.f57179b = searchResultsType;
        this.f57180c = pageNumberPagingSource;
        this.f57181d = i11;
    }

    public final Object call() {
        return PageNumberPagingSource.m10094prepareRequest$lambda4(this.f57179b, this.f57180c, this.f57181d);
    }
}
