package of;

import com.talabat.authentication.token.data.remote.api.SwapTokenResponse;
import com.talabat.authentication.token.data.remote.impl.LegacyTokenRemoteDataSourceImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {
    public final Object apply(Object obj) {
        return LegacyTokenRemoteDataSourceImpl.m9527swapToLegacyToken$lambda2$lambda0((SwapTokenResponse) obj);
    }
}
