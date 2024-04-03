package rj;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import com.talabat.darkstores.interactor.DarkstoresBridgeInteractor;
import io.reactivex.functions.BiFunction;
import java.util.List;

public final /* synthetic */ class g implements BiFunction {
    public final Object apply(Object obj, Object obj2) {
        return DarkstoresBridgeInteractor.m10101loadCustomerDetailsFromMicroservice$lambda1((CustomerAddressInfoJsonResult) obj, (List) obj2);
    }
}
