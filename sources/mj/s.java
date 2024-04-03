package mj;

import com.talabat.darkstores.feature.search.SearchFragmentViewModel;
import io.reactivex.functions.Function;

public final /* synthetic */ class s implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchFragmentViewModel f57048b;

    public /* synthetic */ s(SearchFragmentViewModel searchFragmentViewModel) {
        this.f57048b = searchFragmentViewModel;
    }

    public final Object apply(Object obj) {
        return SearchFragmentViewModel.m10072subscribeToEmptySearchResults$lambda4(this.f57048b, (String) obj);
    }
}
