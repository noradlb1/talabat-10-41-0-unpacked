package com.talabat.feature.darkstorescarrierbag.presentation.di;

import com.talabat.feature.darkstorescarrierbag.domain.usecase.SendDarkstoresCarrierBagEvent;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.SendDarkstoresCarrierBagEventImpl;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.SetDarkstoresCarrierBagFakeDoorTestShown;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.SetDarkstoresCarrierBagFakeDoorTestShownImpl;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.ShouldShowDarkstoresCarrierBagFakeDoorTest;
import com.talabat.feature.darkstorescarrierbag.domain.usecase.ShouldShowDarkstoresCarrierBagFakeDoorTestImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'¨\u0006\f"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/presentation/di/DarkstoresCarrierBagUseCaseModule;", "", "bindSendDarkstoresCarrierBagEvent", "Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/SendDarkstoresCarrierBagEvent;", "impl", "Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/SendDarkstoresCarrierBagEventImpl;", "bindSetDarkstoresCarrierBagFakeDoorTestShown", "Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/SetDarkstoresCarrierBagFakeDoorTestShown;", "Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/SetDarkstoresCarrierBagFakeDoorTestShownImpl;", "bindShouldShowDarkstoresCarrierBagFakeDoorTest", "Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/ShouldShowDarkstoresCarrierBagFakeDoorTest;", "Lcom/talabat/feature/darkstorescarrierbag/domain/usecase/ShouldShowDarkstoresCarrierBagFakeDoorTestImpl;", "com_talabat_feature_darkstores-carrier-bag_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface DarkstoresCarrierBagUseCaseModule {
    @NotNull
    @Binds
    @Reusable
    SendDarkstoresCarrierBagEvent bindSendDarkstoresCarrierBagEvent(@NotNull SendDarkstoresCarrierBagEventImpl sendDarkstoresCarrierBagEventImpl);

    @NotNull
    @Binds
    @Reusable
    SetDarkstoresCarrierBagFakeDoorTestShown bindSetDarkstoresCarrierBagFakeDoorTestShown(@NotNull SetDarkstoresCarrierBagFakeDoorTestShownImpl setDarkstoresCarrierBagFakeDoorTestShownImpl);

    @NotNull
    @Binds
    @Reusable
    ShouldShowDarkstoresCarrierBagFakeDoorTest bindShouldShowDarkstoresCarrierBagFakeDoorTest(@NotNull ShouldShowDarkstoresCarrierBagFakeDoorTestImpl shouldShowDarkstoresCarrierBagFakeDoorTestImpl);
}
