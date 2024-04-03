package ol;

import com.talabat.feature.bnplcore.data.remote.BnplOverduesResponse;
import com.talabat.feature.bnplcore.data.repository.BnplRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return BnplRepositoryImpl.m10141getOverdues$lambda0((BnplOverduesResponse) obj);
    }
}
