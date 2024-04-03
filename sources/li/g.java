package li;

import com.talabat.darkstores.data.search.SearchRepository;
import io.reactivex.functions.Function;
import kotlin.Pair;

public final /* synthetic */ class g implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchRepository f57003b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57004c;

    public /* synthetic */ g(SearchRepository searchRepository, String str) {
        this.f57003b = searchRepository;
        this.f57004c = str;
    }

    public final Object apply(Object obj) {
        return SearchRepository.m9739searchProductsQCommerce$lambda5(this.f57003b, this.f57004c, (Pair) obj);
    }
}
