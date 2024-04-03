package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsInteractor;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class u implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f57948b;

    public /* synthetic */ u(List list) {
        this.f57948b = list;
    }

    public final Object apply(Object obj) {
        return QuickFilterRestaurantsInteractor.m9564handleFilterSelection$lambda19(this.f57948b, (List) obj);
    }
}
