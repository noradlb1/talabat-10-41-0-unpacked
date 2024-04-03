package x00;

import io.reactivex.functions.Action;
import kotlin.jvm.functions.Function0;
import library.talabat.mvp.addressV2.AddressInteractor;

public final /* synthetic */ class b implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddressInteractor f28218b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function0 f28219c;

    public /* synthetic */ b(AddressInteractor addressInteractor, Function0 function0) {
        this.f28218b = addressInteractor;
        this.f28219c = function0;
    }

    public final void run() {
        this.f28218b.lambda$callDeleteAddressMicroservice$5(this.f28219c);
    }
}
