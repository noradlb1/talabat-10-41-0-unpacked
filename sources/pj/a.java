package pj;

import androidx.paging.PagingSource;
import com.talabat.darkstores.domain.model.ProductsHolderWithPagination;
import com.talabat.darkstores.feature.searchResults.paging.PageNumberPagingSource;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PageNumberPagingSource f57176b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PagingSource.LoadParams f57177c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f57178d;

    public /* synthetic */ a(PageNumberPagingSource pageNumberPagingSource, PagingSource.LoadParams loadParams, int i11) {
        this.f57176b = pageNumberPagingSource;
        this.f57177c = loadParams;
        this.f57178d = i11;
    }

    public final Object apply(Object obj) {
        return PageNumberPagingSource.m10092loadSingle$lambda1(this.f57176b, this.f57177c, this.f57178d, (ProductsHolderWithPagination) obj);
    }
}
