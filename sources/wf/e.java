package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterBEFiltrationInteractor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class e implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f57926b;

    public /* synthetic */ e(Function1 function1) {
        this.f57926b = function1;
    }

    public final void accept(Object obj) {
        QuickFilterBEFiltrationInteractor.m9545getRestaurantsForCollection$lambda4(this.f57926b, (Throwable) obj);
    }
}
