package yt;

import com.talabat.sdsquad.data.vendorslist.VendorsInfoRepositoryImp;
import com.talabat.sdsquad.data.vendorslist.response.VendorsInfoResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsInfoRepositoryImp f63089b;

    public /* synthetic */ b(VendorsInfoRepositoryImp vendorsInfoRepositoryImp) {
        this.f63089b = vendorsInfoRepositoryImp;
    }

    public final void accept(Object obj) {
        VendorsInfoRepositoryImp.m10780loadVendorsInfo$lambda9(this.f63089b, (VendorsInfoResponse) obj);
    }
}
