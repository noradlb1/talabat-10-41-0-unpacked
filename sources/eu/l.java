package eu;

import com.talabat.sdsquad.ui.collections.CollectionsViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class l implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CollectionsViewModel f62029b;

    public /* synthetic */ l(CollectionsViewModel collectionsViewModel) {
        this.f62029b = collectionsViewModel;
    }

    public final Object apply(Object obj) {
        return CollectionsViewModel.m10808getVendors$lambda5(this.f62029b, (List) obj);
    }
}
