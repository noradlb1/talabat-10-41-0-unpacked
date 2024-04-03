package gq;

import JsonModels.Response.MenuItemResponse;
import com.talabat.flutter.groceryhome.data.repository.GroceryHomeVendorRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return GroceryHomeVendorRepositoryImpl.m10470getMigratedVendorInfo$lambda1((MenuItemResponse) obj);
    }
}
