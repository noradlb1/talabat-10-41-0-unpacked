package eu;

import com.talabat.sdsquad.ui.collections.CollectionsViewModel;
import io.reactivex.functions.Consumer;
import java.util.List;

public final /* synthetic */ class p implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CollectionsViewModel f62032b;

    public /* synthetic */ p(CollectionsViewModel collectionsViewModel) {
        this.f62032b = collectionsViewModel;
    }

    public final void accept(Object obj) {
        CollectionsViewModel.m10804getVendors$lambda10(this.f62032b, (List) obj);
    }
}
