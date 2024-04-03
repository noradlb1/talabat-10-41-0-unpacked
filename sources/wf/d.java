package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterBEFiltrationInteractor;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterBEFiltrationInteractor f57923b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f57924c;

    public /* synthetic */ d(QuickFilterBEFiltrationInteractor quickFilterBEFiltrationInteractor, Function1 function1) {
        this.f57923b = quickFilterBEFiltrationInteractor;
        this.f57924c = function1;
    }

    public final void accept(Object obj) {
        QuickFilterBEFiltrationInteractor.m9544getRestaurantsForCollection$lambda3(this.f57923b, this.f57924c, (Pair) obj);
    }
}
