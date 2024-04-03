package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemRestaurant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class BusinessRulesKt$selectedRestaurantBranchIndex$1 extends FunctionReferenceImpl implements Function0<List<? extends GemRestaurant>> {
    public static final BusinessRulesKt$selectedRestaurantBranchIndex$1 INSTANCE = new BusinessRulesKt$selectedRestaurantBranchIndex$1();

    public BusinessRulesKt$selectedRestaurantBranchIndex$1() {
        super(0, BusinessRulesKt.class, "loadGemRestaurants", "loadGemRestaurants()Ljava/util/List;", 1);
    }

    public final List<GemRestaurant> invoke() {
        return BusinessRulesKt.loadGemRestaurants();
    }
}
