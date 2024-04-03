package jq;

import com.talabat.flutter.groceryhome.presentation.handler.GroceryHomeMethodHandlerImpl;
import io.flutter.plugin.common.MethodChannel;
import io.reactivex.functions.Consumer;
import kotlin.Triple;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryHomeMethodHandlerImpl f62197b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f62198c;

    public /* synthetic */ c(GroceryHomeMethodHandlerImpl groceryHomeMethodHandlerImpl, MethodChannel.Result result) {
        this.f62197b = groceryHomeMethodHandlerImpl;
        this.f62198c = result;
    }

    public final void accept(Object obj) {
        GroceryHomeMethodHandlerImpl.m10478navigateToLifestyleProductListing$lambda5(this.f62197b, this.f62198c, (Triple) obj);
    }
}
