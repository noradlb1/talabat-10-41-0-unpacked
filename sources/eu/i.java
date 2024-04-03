package eu;

import com.talabat.sdsquad.data.darkstors.responses.DarkStoreResponse;
import com.talabat.sdsquad.ui.collections.CollectionsViewModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorInfo;
import io.reactivex.functions.Function3;
import java.util.List;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class i implements Function3 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f62023a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f62024b;

    public /* synthetic */ i(Ref.ObjectRef objectRef, Ref.IntRef intRef) {
        this.f62023a = objectRef;
        this.f62024b = intRef;
    }

    public final Object apply(Object obj, Object obj2, Object obj3) {
        return CollectionsViewModel.m10803getVendors$lambda1(this.f62023a, this.f62024b, (List) obj, (VendorInfo) obj2, (DarkStoreResponse) obj3);
    }
}
