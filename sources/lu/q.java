package lu;

import com.talabat.sdsquad.ui.restaurantssearch.suggestionsearch.SuggestionsViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class q implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SuggestionsViewModel f62298b;

    public /* synthetic */ q(SuggestionsViewModel suggestionsViewModel) {
        this.f62298b = suggestionsViewModel;
    }

    public final void accept(Object obj) {
        SuggestionsViewModel.m10855searchVendorsLocally$lambda12(this.f62298b, (List) obj);
    }
}
