package nu;

import com.talabat.sdsquad.data.darkstors.responses.DarkStoreResponse;
import com.talabat.sdsquad.ui.vendorslist.VendorsListViewModel;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.VendorInfo;
import io.reactivex.functions.Function4;
import java.util.List;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class z implements Function4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f62394a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f62395b;

    public /* synthetic */ z(Ref.ObjectRef objectRef, Ref.IntRef intRef) {
        this.f62394a = objectRef;
        this.f62395b = intRef;
    }

    public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
        return VendorsListViewModel.m10871getVendors$lambda1(this.f62394a, this.f62395b, (List) obj, (VendorInfo) obj2, (List) obj3, (DarkStoreResponse) obj4);
    }
}
