package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterBEFiltrationInteractor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f57920b;

    public /* synthetic */ b(Function1 function1) {
        this.f57920b = function1;
    }

    public final void accept(Object obj) {
        QuickFilterBEFiltrationInteractor.m9547handleFiltering$lambda7(this.f57920b, (Throwable) obj);
    }
}
