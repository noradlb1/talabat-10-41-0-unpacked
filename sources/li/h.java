package li;

import com.talabat.darkstores.data.search.SearchRepository;
import com.talabat.darkstores.data.search.model.QCommerceSearchResultsResponse;
import io.reactivex.functions.Function;
import kotlin.reflect.KProperty1;

public final /* synthetic */ class h implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KProperty1 f57005b;

    public /* synthetic */ h(KProperty1 kProperty1) {
        this.f57005b = kProperty1;
    }

    public final Object apply(Object obj) {
        return SearchRepository.m9740searchProductsQCommerce$lambda5$lambda3(this.f57005b, (QCommerceSearchResultsResponse) obj);
    }
}
