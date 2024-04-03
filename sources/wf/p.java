package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsInteractor f57940b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f57941c;

    public /* synthetic */ p(QuickFilterRestaurantsInteractor quickFilterRestaurantsInteractor, Function1 function1) {
        this.f57940b = quickFilterRestaurantsInteractor;
        this.f57941c = function1;
    }

    public final void accept(Object obj) {
        QuickFilterRestaurantsInteractor.m9552getRestaurantsForCollection$lambda10(this.f57940b, this.f57941c, (Pair) obj);
    }
}
