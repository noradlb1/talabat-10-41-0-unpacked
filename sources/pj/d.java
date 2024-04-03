package pj;

import androidx.paging.PagingSource;
import com.talabat.darkstores.data.SearchResultData;
import com.talabat.darkstores.feature.searchResults.paging.SearchPagingSource;
import io.reactivex.functions.Function;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f57182b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SearchPagingSource f57183c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ PagingSource.LoadParams f57184d;

    public /* synthetic */ d(int i11, SearchPagingSource searchPagingSource, PagingSource.LoadParams loadParams) {
        this.f57182b = i11;
        this.f57183c = searchPagingSource;
        this.f57184d = loadParams;
    }

    public final Object apply(Object obj) {
        return SearchPagingSource.m10095loadSingle$lambda1(this.f57182b, this.f57183c, this.f57184d, (SearchResultData) obj);
    }
}
