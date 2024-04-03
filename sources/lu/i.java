package lu;

import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class i implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f62287b;

    public /* synthetic */ i(int i11) {
        this.f62287b = i11;
    }

    public final Object apply(Object obj) {
        return SuggestionsViewModel.m10848getSuggestionsDishes$lambda1(this.f62287b, (List) obj);
    }
}
