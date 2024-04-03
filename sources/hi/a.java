package hi;

import com.talabat.darkstores.data.partialFulfillment.model.PreferencesResponse;
import com.talabat.darkstores.data.partialFulfillment.remote.PartialFulfillmentRepo;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return PartialFulfillmentRepo.m9725getPreferences$lambda0((PreferencesResponse) obj);
    }
}
