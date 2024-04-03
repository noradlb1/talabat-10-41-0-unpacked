package yw;

import com.talabat.user.status.data.remote.api.IsUserRegisteredResponse;
import com.talabat.user.status.data.remote.impl.IsUserRegisteredRemoteDataSourceImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return IsUserRegisteredRemoteDataSourceImpl.m5881isUserRegistered$lambda0((IsUserRegisteredResponse) obj);
    }
}
