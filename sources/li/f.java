package li;

import com.talabat.darkstores.data.search.SearchRepository;
import io.reactivex.functions.Function;
import kotlin.Pair;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchRepository f57001b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57002c;

    public /* synthetic */ f(SearchRepository searchRepository, String str) {
        this.f57001b = searchRepository;
        this.f57002c = str;
    }

    public final Object apply(Object obj) {
        return SearchRepository.m9735search$lambda2(this.f57001b, this.f57002c, (Pair) obj);
    }
}
