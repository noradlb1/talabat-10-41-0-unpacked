package lu;

import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class j implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SuggestionsViewModel f62288b;

    public /* synthetic */ j(SuggestionsViewModel suggestionsViewModel) {
        this.f62288b = suggestionsViewModel;
    }

    public final Object apply(Object obj) {
        return SuggestionsViewModel.m10849getSuggestionsDishes$lambda2(this.f62288b, (List) obj);
    }
}
