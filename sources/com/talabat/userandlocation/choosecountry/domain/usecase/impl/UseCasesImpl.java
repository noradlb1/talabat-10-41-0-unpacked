package com.talabat.userandlocation.choosecountry.domain.usecase.impl;

import com.talabat.userandlocation.choosecountry.domain.UseCases;
import com.talabat.userandlocation.choosecountry.domain.entity.CountryVO;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.GetSupportedCountriesForUserToChooseUseCase;
import com.talabat.userandlocation.choosecountry.domain.usecase.business.SetUserSelectedCountryUseCase;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHAø\u0001\u0000¢\u0006\u0002\u0010\nJ-\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010HAø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/domain/usecase/impl/UseCasesImpl;", "Lcom/talabat/userandlocation/choosecountry/domain/UseCases;", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/GetSupportedCountriesForUserToChooseUseCase;", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase;", "getSupportedCountriesForUserToChooseUseCase", "setUserSelectedCountryUseCase", "(Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/GetSupportedCountriesForUserToChooseUseCase;Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase;)V", "getSupportedCountriesForUserToChoose", "", "Lcom/talabat/userandlocation/choosecountry/domain/entity/CountryVO;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUserSelectedCountry", "Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/SetUserSelectedCountryUseCase$Result;", "countryId", "", "warningAcknowledged", "", "fromLocationWelcome", "(IZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UseCasesImpl implements UseCases, GetSupportedCountriesForUserToChooseUseCase, SetUserSelectedCountryUseCase {
    private final /* synthetic */ GetSupportedCountriesForUserToChooseUseCase $$delegate_0;
    private final /* synthetic */ SetUserSelectedCountryUseCase $$delegate_1;

    public UseCasesImpl(@NotNull GetSupportedCountriesForUserToChooseUseCase getSupportedCountriesForUserToChooseUseCase, @NotNull SetUserSelectedCountryUseCase setUserSelectedCountryUseCase) {
        Intrinsics.checkNotNullParameter(getSupportedCountriesForUserToChooseUseCase, "getSupportedCountriesForUserToChooseUseCase");
        Intrinsics.checkNotNullParameter(setUserSelectedCountryUseCase, "setUserSelectedCountryUseCase");
        this.$$delegate_0 = getSupportedCountriesForUserToChooseUseCase;
        this.$$delegate_1 = setUserSelectedCountryUseCase;
    }

    @Nullable
    public Object getSupportedCountriesForUserToChoose(@NotNull Continuation<? super List<CountryVO>> continuation) {
        return this.$$delegate_0.getSupportedCountriesForUserToChoose(continuation);
    }

    @Nullable
    public Object setUserSelectedCountry(int i11, boolean z11, boolean z12, @NotNull Continuation<? super SetUserSelectedCountryUseCase.Result> continuation) {
        return this.$$delegate_1.setUserSelectedCountry(i11, z11, z12, continuation);
    }
}
