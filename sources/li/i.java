package li;

import com.talabat.darkstores.data.search.SearchRepository;
import com.talabat.darkstores.data.search.model.SearchResultsResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchRepository f57006b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57007c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f57008d;

    public /* synthetic */ i(SearchRepository searchRepository, String str, String str2) {
        this.f57006b = searchRepository;
        this.f57007c = str;
        this.f57008d = str2;
    }

    public final void accept(Object obj) {
        SearchRepository.m9741searchProductsQCommerce$lambda5$lambda4(this.f57006b, this.f57007c, this.f57008d, (SearchResultsResponse) obj);
    }
}
