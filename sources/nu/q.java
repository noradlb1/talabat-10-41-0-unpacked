package nu;

import com.talabat.sdsquad.ui.vendorslist.VendorsListViewModel;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class q implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListViewModel f62387b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f62388c;

    public /* synthetic */ q(VendorsListViewModel vendorsListViewModel, Ref.ObjectRef objectRef) {
        this.f62387b = vendorsListViewModel;
        this.f62388c = objectRef;
    }

    public final Object apply(Object obj) {
        return VendorsListViewModel.m10881getVendors$lambda8(this.f62387b, this.f62388c, (List) obj);
    }
}
