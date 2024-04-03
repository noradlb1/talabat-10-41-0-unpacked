package ot;

import com.talabat.restaurants.v2.domain.swimlane.GetDisplayFeatureProductsUseCase;
import io.reactivex.functions.BiFunction;
import java.util.List;

public final /* synthetic */ class a implements BiFunction {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GetDisplayFeatureProductsUseCase f62772b;

    public /* synthetic */ a(GetDisplayFeatureProductsUseCase getDisplayFeatureProductsUseCase) {
        this.f62772b = getDisplayFeatureProductsUseCase;
    }

    public final Object apply(Object obj, Object obj2) {
        return GetDisplayFeatureProductsUseCase.m10740invoke$lambda2(this.f62772b, (List) obj, (List) obj2);
    }
}
