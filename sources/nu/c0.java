package nu;

import com.talabat.sdsquad.ui.vendorslist.VendorsListViewModel;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class c0 implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListViewModel f62371b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f62372c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f62373d;

    public /* synthetic */ c0(VendorsListViewModel vendorsListViewModel, Ref.ObjectRef objectRef, Ref.IntRef intRef) {
        this.f62371b = vendorsListViewModel;
        this.f62372c = objectRef;
        this.f62373d = intRef;
    }

    public final Object apply(Object obj) {
        return VendorsListViewModel.m10876getVendors$lambda2(this.f62371b, this.f62372c, this.f62373d, (List) obj);
    }
}
