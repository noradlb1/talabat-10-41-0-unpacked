package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class x implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f57951b;

    public /* synthetic */ x(Function1 function1) {
        this.f57951b = function1;
    }

    public final void accept(Object obj) {
        QuickFilterRestaurantsInteractor.m9567handleFilterSelection$lambda22(this.f57951b, (List) obj);
    }
}
