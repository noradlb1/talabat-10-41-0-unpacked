package mj;

import com.talabat.darkstores.feature.search.SearchFragmentViewModel;
import io.reactivex.functions.Function;

public final /* synthetic */ class u implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchFragmentViewModel f57050b;

    public /* synthetic */ u(SearchFragmentViewModel searchFragmentViewModel) {
        this.f57050b = searchFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return SearchFragmentViewModel.m10076subscribeToSearchClosed$lambda5(this.f57050b, (String) obj);
    }
}
