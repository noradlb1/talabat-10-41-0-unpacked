package oj;

import com.talabat.darkstores.data.search.model.SearchResultsResponse;
import com.talabat.darkstores.feature.searchResults.SearchResultsUseCase;
import io.reactivex.functions.Function3;
import java.util.Map;

public final /* synthetic */ class m implements Function3 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchResultsUseCase f57094a;

    public /* synthetic */ m(SearchResultsUseCase searchResultsUseCase) {
        this.f57094a = searchResultsUseCase;
    }

    public final Object apply(Object obj, Object obj2, Object obj3) {
        return SearchResultsUseCase.m10089search$lambda10(this.f57094a, (SearchResultsResponse) obj, (Map) obj2, (Map) obj3);
    }
}
