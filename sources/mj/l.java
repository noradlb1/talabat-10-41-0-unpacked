package mj;

import com.talabat.darkstores.feature.search.SearchFragmentViewModel;
import io.reactivex.functions.Function;

public final /* synthetic */ class l implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchFragmentViewModel f57040b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f57041c;

    public /* synthetic */ l(SearchFragmentViewModel searchFragmentViewModel, String str) {
        this.f57040b = searchFragmentViewModel;
        this.f57041c = str;
    }

    public final Object apply(Object obj) {
        return SearchFragmentViewModel.m10069loadSuggestions$lambda2(this.f57040b, this.f57041c, (Long) obj);
    }
}
