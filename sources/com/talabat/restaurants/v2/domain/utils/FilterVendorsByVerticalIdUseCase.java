package com.talabat.restaurants.v2.domain.utils;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import datamodels.Restaurant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00060\u0001j\u0002`\u0007B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ6\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00032\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/restaurants/v2/domain/utils/FilterVendorsByVerticalIdUseCase;", "Lkotlin/Function3;", "", "", "", "Ldatamodels/Restaurant;", "Ljava/util/ArrayList;", "Lcom/talabat/restaurants/v2/domain/utils/FilterVendorsByVerticalIdUseCaseInterface;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "invoke", "segregateNonFoodVerticals", "verticalId", "restaurantList", "(ZI[Ldatamodels/Restaurant;)Ljava/util/ArrayList;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FilterVendorsByVerticalIdUseCase implements Function3<Boolean, Integer, Restaurant[], ArrayList<Restaurant>> {
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public FilterVendorsByVerticalIdUseCase(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Boolean) obj).booleanValue(), ((Number) obj2).intValue(), (Restaurant[]) obj3);
    }

    @NotNull
    public ArrayList<Restaurant> invoke(boolean z11, int i11, @Nullable Restaurant[] restaurantArr) {
        ArrayList<Restaurant> arrayList = new ArrayList<>();
        if (restaurantArr == null) {
            return arrayList;
        }
        arrayList.addAll(VendorFilterByVertical.INSTANCE.filter(ArraysKt___ArraysKt.toList((T[]) restaurantArr), z11, i11, this.talabatFeatureFlag));
        return arrayList;
    }
}
