package mj;

import com.talabat.darkstores.feature.search.SearchFragmentViewModel;
import io.reactivex.functions.Consumer;
import kotlin.Triple;

public final /* synthetic */ class q implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchFragmentViewModel f57046b;

    public /* synthetic */ q(SearchFragmentViewModel searchFragmentViewModel) {
        this.f57046b = searchFragmentViewModel;
    }

    public final void accept(Object obj) {
        SearchFragmentViewModel.m10074subscribeToProductClicks$lambda7(this.f57046b, (Triple) obj);
    }
}
