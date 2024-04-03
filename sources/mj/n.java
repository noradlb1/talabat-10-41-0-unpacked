package mj;

import com.talabat.darkstores.feature.search.SearchFragmentViewModel;
import io.reactivex.functions.Function;

public final /* synthetic */ class n implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchFragmentViewModel f57043b;

    public /* synthetic */ n(SearchFragmentViewModel searchFragmentViewModel) {
        this.f57043b = searchFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return SearchFragmentViewModel.m10068createSuggestionsObservable$lambda9(this.f57043b, (String) obj);
    }
}
