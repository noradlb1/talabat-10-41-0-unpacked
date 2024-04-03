package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class b0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f57921b;

    public /* synthetic */ b0(Function1 function1) {
        this.f57921b = function1;
    }

    public final void accept(Object obj) {
        QuickFilterRestaurantsInteractor.m9561handleCuisineSelection$lambda26(this.f57921b, (List) obj);
    }
}
