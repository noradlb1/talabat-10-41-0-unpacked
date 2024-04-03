package eu;

import com.talabat.sdsquad.ui.collections.CollectionsViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class n implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CollectionsViewModel f62031b;

    public /* synthetic */ n(CollectionsViewModel collectionsViewModel) {
        this.f62031b = collectionsViewModel;
    }

    public final Object apply(Object obj) {
        return CollectionsViewModel.m10810getVendors$lambda7(this.f62031b, (List) obj);
    }
}
