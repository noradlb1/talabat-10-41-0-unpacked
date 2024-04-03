package com.talabat.userandlocation.choosecountry.data.impl;

import com.talabat.userandlocation.choosecountry.domain.entity.CountryVO;
import datamodels.Country;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00010\u0004H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\b"}, d2 = {"countriesRepositoryImpl", "", "Lcom/talabat/userandlocation/choosecountry/domain/entity/CountryVO;", "dataSource", "Lkotlin/Function0;", "Ldatamodels/Country;", "dataToDomain", "data", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CountriesRepositoryImplKt {
    @NotNull
    public static final List<CountryVO> countriesRepositoryImpl(@NotNull Function0<? extends List<? extends Country>> function0) {
        Intrinsics.checkNotNullParameter(function0, "dataSource");
        Iterable<Country> iterable = (Iterable) function0.invoke();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Country dataToDomain : iterable) {
            arrayList.add(dataToDomain(dataToDomain));
        }
        return arrayList;
    }

    private static final CountryVO dataToDomain(Country country) {
        int i11 = country.f13845id;
        String str = country.f13846name;
        Intrinsics.checkNotNullExpressionValue(str, "data.name");
        String str2 = country.currencySymbol;
        Intrinsics.checkNotNullExpressionValue(str2, "data.currencySymbol");
        return new CountryVO(i11, str, "", str2, country.numOfDecimalPlaces, false, 32, (DefaultConstructorMarker) null);
    }
}
