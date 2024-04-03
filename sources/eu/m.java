package eu;

import com.talabat.sdsquad.ui.collections.CollectionsViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class m implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CollectionsViewModel f62030b;

    public /* synthetic */ m(CollectionsViewModel collectionsViewModel) {
        this.f62030b = collectionsViewModel;
    }

    public final Object apply(Object obj) {
        return CollectionsViewModel.m10809getVendors$lambda6(this.f62030b, (List) obj);
    }
}
