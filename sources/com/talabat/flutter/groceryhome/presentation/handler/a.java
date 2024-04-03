package com.talabat.flutter.groceryhome.presentation.handler;

import com.talabat.flutter.groceryhome.presentation.handler.GroceryHomeMethodHandlerImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GroceryHomeMethodHandlerImpl f59767b;

    public /* synthetic */ a(GroceryHomeMethodHandlerImpl groceryHomeMethodHandlerImpl) {
        this.f59767b = groceryHomeMethodHandlerImpl;
    }

    public final Object apply(Object obj) {
        return GroceryHomeMethodHandlerImpl.m10476navigateToLifestyleProductListing$lambda4(this.f59767b, (GroceryHomeMethodHandlerImpl.LifestyleProductsNavigationData) obj);
    }
}
