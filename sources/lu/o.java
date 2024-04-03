package lu;

import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class o implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f62296b;

    public /* synthetic */ o(int i11) {
        this.f62296b = i11;
    }

    public final Object apply(Object obj) {
        return SuggestionsViewModel.m10858searchVendorsLocally$lambda9(this.f62296b, (List) obj);
    }
}
