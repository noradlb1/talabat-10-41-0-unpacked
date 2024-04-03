package li;

import com.talabat.darkstores.data.search.SearchRepository;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchRepository f56990b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56991c;

    public /* synthetic */ a(SearchRepository searchRepository, String str) {
        this.f56990b = searchRepository;
        this.f56991c = str;
    }

    public final Object apply(Object obj) {
        return SearchRepository.m9737searchCategory$lambda7(this.f56990b, this.f56991c, (Vendor) obj);
    }
}
