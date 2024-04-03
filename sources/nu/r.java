package nu;

import com.talabat.sdsquad.ui.vendorslist.VendorsListViewModel;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class r implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListViewModel f62389b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f62390c;

    public /* synthetic */ r(VendorsListViewModel vendorsListViewModel, Ref.ObjectRef objectRef) {
        this.f62389b = vendorsListViewModel;
        this.f62390c = objectRef;
    }

    public final Object apply(Object obj) {
        return VendorsListViewModel.m10882getVendors$lambda9(this.f62389b, this.f62390c, (List) obj);
    }
}
