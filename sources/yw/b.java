package yw;

import com.talabat.user.status.data.remote.api.IsUserRegisteredResult;
import com.talabat.user.status.data.remote.impl.IsUserRegisteredRemoteDataSourceImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IsUserRegisteredRemoteDataSourceImpl f24204b;

    public /* synthetic */ b(IsUserRegisteredRemoteDataSourceImpl isUserRegisteredRemoteDataSourceImpl) {
        this.f24204b = isUserRegisteredRemoteDataSourceImpl;
    }

    public final Object apply(Object obj) {
        return IsUserRegisteredRemoteDataSourceImpl.m5882isUserRegistered$lambda1(this.f24204b, (IsUserRegisteredResult) obj);
    }
}
