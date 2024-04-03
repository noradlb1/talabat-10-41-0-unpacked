package com.talabat.userandlocation.choosecountry.domain.usecase.business;

import com.talabat.userandlocation.choosecountry.domain.entity.CountryVO;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/domain/usecase/business/GetSupportedCountriesForUserToChooseUseCase;", "", "getSupportedCountriesForUserToChoose", "", "Lcom/talabat/userandlocation/choosecountry/domain/entity/CountryVO;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GetSupportedCountriesForUserToChooseUseCase {
    @Nullable
    Object getSupportedCountriesForUserToChoose(@NotNull Continuation<? super List<CountryVO>> continuation);
}
