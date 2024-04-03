package li;

import com.talabat.darkstores.data.search.SearchRepository;
import com.talabat.darkstores.data.search.model.SearchResultsResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchRepository f56998b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56999c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f57000d;

    public /* synthetic */ d(SearchRepository searchRepository, String str, String str2) {
        this.f56998b = searchRepository;
        this.f56999c = str;
        this.f57000d = str2;
    }

    public final void accept(Object obj) {
        SearchRepository.m9736search$lambda2$lambda1(this.f56998b, this.f56999c, this.f57000d, (SearchResultsResponse) obj);
    }
}
