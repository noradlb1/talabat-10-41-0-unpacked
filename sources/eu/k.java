package eu;

import com.talabat.sdsquad.ui.collections.CollectionsViewModel;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class k implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f62028b;

    public /* synthetic */ k(int i11) {
        this.f62028b = i11;
    }

    public final Object apply(Object obj) {
        return CollectionsViewModel.m10807getVendors$lambda4(this.f62028b, (List) obj);
    }
}
