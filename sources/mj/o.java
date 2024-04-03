package mj;

import com.talabat.darkstores.feature.search.SearchFragmentViewModel;
import io.reactivex.functions.BiFunction;
import java.util.List;

public final /* synthetic */ class o implements BiFunction {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchFragmentViewModel f57044b;

    public /* synthetic */ o(SearchFragmentViewModel searchFragmentViewModel) {
        this.f57044b = searchFragmentViewModel;
    }

    public final Object apply(Object obj, Object obj2) {
        return this.f57044b.combineItems((List) obj, (List) obj2);
    }
}
