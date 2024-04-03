package xt;

import com.talabat.sdsquad.data.swimlanes.SwimlanesRepositoryImp;
import com.talabat.sdsquad.data.swimlanes.responses.SwimlanesResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwimlanesRepositoryImp f63041b;

    public /* synthetic */ a(SwimlanesRepositoryImp swimlanesRepositoryImp) {
        this.f63041b = swimlanesRepositoryImp;
    }

    public final void accept(Object obj) {
        SwimlanesRepositoryImp.m10777loadSwimlanes$lambda0(this.f63041b, (SwimlanesResponse) obj);
    }
}
