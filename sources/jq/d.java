package jq;

import com.talabat.flutter.groceryhome.presentation.handler.GroceryHomeMethodHandlerImpl;
import datamodels.Restaurant;
import io.reactivex.functions.Function;

public final /* synthetic */ class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f62199b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62200c;

    public /* synthetic */ d(String str, String str2) {
        this.f62199b = str;
        this.f62200c = str2;
    }

    public final Object apply(Object obj) {
        return GroceryHomeMethodHandlerImpl.m10477navigateToLifestyleProductListing$lambda4$lambda3(this.f62199b, this.f62200c, (Restaurant) obj);
    }
}
