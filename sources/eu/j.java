package eu;

import com.talabat.sdsquad.ui.collections.CollectionsViewModel;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Ref;

public final /* synthetic */ class j implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CollectionsViewModel f62025b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f62026c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f62027d;

    public /* synthetic */ j(CollectionsViewModel collectionsViewModel, Ref.ObjectRef objectRef, Ref.IntRef intRef) {
        this.f62025b = collectionsViewModel;
        this.f62026c = objectRef;
        this.f62027d = intRef;
    }

    public final Object apply(Object obj) {
        return CollectionsViewModel.m10806getVendors$lambda2(this.f62025b, this.f62026c, this.f62027d, (List) obj);
    }
}
