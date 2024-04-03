package vt;

import com.talabat.sdsquad.data.darkstors.DarkStoreRepositoryImp;
import com.talabat.sdsquad.data.darkstors.responses.DarkStoreResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkStoreRepositoryImp f62987b;

    public /* synthetic */ a(DarkStoreRepositoryImp darkStoreRepositoryImp) {
        this.f62987b = darkStoreRepositoryImp;
    }

    public final void accept(Object obj) {
        DarkStoreRepositoryImp.m10773getDarkStore$lambda0(this.f62987b, (DarkStoreResponse) obj);
    }
}
