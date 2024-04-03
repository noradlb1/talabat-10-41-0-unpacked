package mj;

import com.talabat.darkstores.feature.search.SearchFragmentViewModel;
import io.reactivex.functions.Consumer;
import kotlin.Pair;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchFragmentViewModel f57045b;

    public /* synthetic */ p(SearchFragmentViewModel searchFragmentViewModel) {
        this.f57045b = searchFragmentViewModel;
    }

    public final void accept(Object obj) {
        SearchFragmentViewModel.m10075subscribeToQualityChange$lambda8(this.f57045b, (Pair) obj);
    }
}
