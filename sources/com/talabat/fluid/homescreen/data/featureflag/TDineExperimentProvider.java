package com.talabat.fluid.homescreen.data.featureflag;

import android.content.Context;
import buisnessmodels.Customer;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/fluid/homescreen/data/featureflag/TDineExperimentProvider;", "", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "customerProvider", "Lkotlin/Function0;", "Lbuisnessmodels/Customer;", "context", "Landroid/content/Context;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/configuration/ConfigurationLocalRepository;Lkotlin/jvm/functions/Function0;Landroid/content/Context;)V", "isTDineEnabled", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TDineExperimentProvider {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final Context context;
    @NotNull
    private final Function0<Customer> customerProvider;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public TDineExperimentProvider(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull Function0<? extends Customer> function0, @NotNull Context context2) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(function0, "customerProvider");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.customerProvider = function0;
        this.context = context2;
    }

    public final boolean isTDineEnabled() {
        return false;
    }
}
