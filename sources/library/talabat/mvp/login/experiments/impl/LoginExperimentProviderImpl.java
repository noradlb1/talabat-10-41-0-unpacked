package library.talabat.mvp.login.experiments.impl;

import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.squads.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.login.experiments.LoginExperimentProvider;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Llibrary/talabat/mvp/login/experiments/impl/LoginExperimentProviderImpl;", "Llibrary/talabat/mvp/login/experiments/LoginExperimentProvider;", "()V", "canEnableSelectAddressOnHome", "", "getCanEnableSelectAddressOnHome", "()Z", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoginExperimentProviderImpl implements LoginExperimentProvider {
    public boolean getCanEnableSelectAddressOnHome() {
        TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
        TalabatExperimentConstants talabatExperimentConstants = TalabatExperimentConstants.CAN_SELECT_ADDRESS_ON_HOME;
        Boolean bool = BuildConfig.IS_ALPHA;
        Intrinsics.checkNotNullExpressionValue(bool, "IS_ALPHA");
        return talabatExperiment.getBooleanVariant(talabatExperimentConstants, bool.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE);
    }
}
