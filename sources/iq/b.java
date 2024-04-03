package iq;

import com.talabat.flutter.groceryhome.domain.model.UserLocation;
import com.talabat.flutter.groceryhome.domain.repository.GroceryHomeVendorRepository;
import io.reactivex.functions.Function;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryHomeVendorRepository f62165b;

    public /* synthetic */ b(GroceryHomeVendorRepository groceryHomeVendorRepository) {
        this.f62165b = groceryHomeVendorRepository;
    }

    public final Object apply(Object obj) {
        return this.f62165b.getClosestDarkstoreInfo((UserLocation) obj);
    }
}
