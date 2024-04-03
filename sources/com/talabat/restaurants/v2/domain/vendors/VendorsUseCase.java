package com.talabat.restaurants.v2.domain.vendors;

import com.talabat.restaurants.v2.domain.vendors.GetVendorsUseCase;
import datamodels.Restaurant;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001¨\u0006\u0006"}, d2 = {"Lcom/talabat/restaurants/v2/domain/vendors/VendorsUseCase;", "Lkotlin/Function1;", "Lcom/talabat/restaurants/v2/domain/vendors/GetVendorsUseCase$Params;", "Lio/reactivex/Single;", "", "Ldatamodels/Restaurant;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorsUseCase extends Function1<GetVendorsUseCase.Params, Single<List<? extends Restaurant>>> {
}
