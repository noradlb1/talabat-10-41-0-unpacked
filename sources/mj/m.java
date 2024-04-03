package mj;

import com.talabat.darkstores.feature.search.SearchFragmentViewModel;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public final /* synthetic */ class m implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchFragmentViewModel f57042b;

    public /* synthetic */ m(SearchFragmentViewModel searchFragmentViewModel) {
        this.f57042b = searchFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return SearchFragmentViewModel.m10071loadSuggestions$lambda2$lambda1(this.f57042b, (Observable) obj);
    }
}
