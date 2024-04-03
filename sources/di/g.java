package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import com.talabat.darkstores.data.discovery.model.ProductListingResponse;
import io.reactivex.functions.Function;

public final /* synthetic */ class g implements Function {
    public final Object apply(Object obj) {
        return DarkstoresRepo.m9673getProductBySku$lambda8((ProductListingResponse) obj);
    }
}
