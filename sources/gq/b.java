package gq;

import JsonModels.Response.Darkstores.DarkStoresEntryPointResponse;
import com.talabat.flutter.groceryhome.data.repository.GroceryHomeVendorRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {
    public final Object apply(Object obj) {
        return GroceryHomeVendorRepositoryImpl.m10469getClosestDarkstoreInfo$lambda0((DarkStoresEntryPointResponse) obj);
    }
}
