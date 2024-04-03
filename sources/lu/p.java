package lu;

import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class p implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f62297b;

    public /* synthetic */ p(String str) {
        this.f62297b = str;
    }

    public final Object apply(Object obj) {
        return SuggestionsViewModel.m10854searchVendorsLocally$lambda11(this.f62297b, (List) obj);
    }
}
