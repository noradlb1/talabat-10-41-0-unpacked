package com.talabat.userandlocation.choosecountry.domain.usecase.business.impl;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.userandlocation.choosecountry.domain.entity.CountryVO;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.GetSupportedCountriesForUserToChooseUseCase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/impl/GetSupportedCountriesForUserToChooseUseCaseImpl;", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/GetSupportedCountriesForUserToChooseUseCase;", "countriesRepository", "Lkotlin/Function0;", "", "Lcom/talabat/userandlocation/choosecountry/domain/entity/CountryVO;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lkotlin/jvm/functions/Function0;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "getSupportedCountriesForUserToChoose", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetSupportedCountriesForUserToChooseUseCaseImpl implements GetSupportedCountriesForUserToChooseUseCase {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final Function0<List<CountryVO>> countriesRepository;

    public GetSupportedCountriesForUserToChooseUseCaseImpl(@NotNull Function0<? extends List<CountryVO>> function0, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(function0, "countriesRepository");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.countriesRepository = function0;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @Nullable
    public Object getSupportedCountriesForUserToChoose(@NotNull Continuation<? super List<CountryVO>> continuation) {
        int countryId = this.configurationLocalRepository.selectedCountry().getCountryId();
        Iterable<CountryVO> invoke = this.countriesRepository.invoke();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(invoke, 10));
        for (CountryVO countryVO : invoke) {
            if (countryVO.getId() == countryId) {
                countryVO = CountryVO.copy$default(countryVO, 0, (String) null, (String) null, (String) null, 0, true, 31, (Object) null);
            }
            arrayList.add(countryVO);
        }
        return arrayList;
    }
}
