package com.talabat.darkstores.feature.main.usecase;

import com.talabat.darkstores.data.ConfigurationParameters;
import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/main/usecase/GenerateVoucherUseCaseImpl;", "Lcom/talabat/darkstores/feature/main/usecase/GenerateVoucherUseCase;", "darkstoresRepo", "Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;", "configurationParameters", "Lcom/talabat/darkstores/data/ConfigurationParameters;", "(Lcom/talabat/darkstores/data/darkstores/DarkstoresRepo;Lcom/talabat/darkstores/data/ConfigurationParameters;)V", "invoke", "Lio/reactivex/Completable;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GenerateVoucherUseCaseImpl implements GenerateVoucherUseCase {
    @NotNull
    private final ConfigurationParameters configurationParameters;
    @NotNull
    private final DarkstoresRepo darkstoresRepo;

    @Inject
    public GenerateVoucherUseCaseImpl(@NotNull DarkstoresRepo darkstoresRepo2, @NotNull ConfigurationParameters configurationParameters2) {
        Intrinsics.checkNotNullParameter(darkstoresRepo2, "darkstoresRepo");
        Intrinsics.checkNotNullParameter(configurationParameters2, "configurationParameters");
        this.darkstoresRepo = darkstoresRepo2;
        this.configurationParameters = configurationParameters2;
    }

    @NotNull
    public Completable invoke() {
        String eventOrigin = this.configurationParameters.getEventOrigin();
        String experimentKey = this.configurationParameters.getExperimentKey();
        if (Intrinsics.areEqual((Object) eventOrigin, (Object) "looking_glass") && Intrinsics.areEqual((Object) experimentKey, (Object) "poh-looking-glass-delivery-fee-incentive")) {
            return this.darkstoresRepo.generateVoucher();
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "{\n            Completable.complete()\n        }");
        return complete;
    }
}
