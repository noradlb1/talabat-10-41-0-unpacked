package li;

import com.talabat.darkstores.data.search.SearchRepository;
import com.talabat.darkstores.data.search.model.SearchCategoryRequest;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchRepository f56992b;

    public /* synthetic */ b(SearchRepository searchRepository) {
        this.f56992b = searchRepository;
    }

    public final Object apply(Object obj) {
        return SearchRepository.m9738searchCategory$lambda8(this.f56992b, (SearchCategoryRequest) obj);
    }
}
