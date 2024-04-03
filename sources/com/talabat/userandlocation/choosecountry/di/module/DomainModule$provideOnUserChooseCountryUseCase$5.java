package com.talabat.userandlocation.choosecountry.di.module;

import buisnessmodels.TalabatFormatter;
import com.talabat.userandlocation.choosecountry.domain.entity.CountryVO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/userandlocation/choosecountry/domain/entity/CountryVO;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DomainModule$provideOnUserChooseCountryUseCase$5 extends Lambda implements Function1<CountryVO, Unit> {
    public static final DomainModule$provideOnUserChooseCountryUseCase$5 INSTANCE = new DomainModule$provideOnUserChooseCountryUseCase$5();

    public DomainModule$provideOnUserChooseCountryUseCase$5() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CountryVO) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull CountryVO countryVO) {
        Intrinsics.checkNotNullParameter(countryVO, "it");
        TalabatFormatter.getInstance().setFormat(countryVO.getCurrencySymbol(), countryVO.getNumberOfDecimalPlaces(), countryVO.getId());
    }
}
