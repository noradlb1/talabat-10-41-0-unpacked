package mj;

import com.talabat.darkstores.common.Result;
import com.talabat.darkstores.feature.search.SearchFragmentViewModel;
import io.reactivex.functions.BiFunction;

public final /* synthetic */ class r implements BiFunction {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchFragmentViewModel f57047b;

    public /* synthetic */ r(SearchFragmentViewModel searchFragmentViewModel) {
        this.f57047b = searchFragmentViewModel;
    }

    public final Object apply(Object obj, Object obj2) {
        return Boolean.valueOf(this.f57047b.calculateViewAllVisibility((String) obj, (Result) obj2));
    }
}
