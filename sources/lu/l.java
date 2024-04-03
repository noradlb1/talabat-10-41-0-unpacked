package lu;

import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsViewModel;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class l implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SuggestionsViewModel f62295b;

    public /* synthetic */ l(SuggestionsViewModel suggestionsViewModel) {
        this.f62295b = suggestionsViewModel;
    }

    public final void accept(Object obj) {
        SuggestionsViewModel.m10851getSuggestionsDishes$lambda4(this.f62295b, (Flowable) obj);
    }
}
