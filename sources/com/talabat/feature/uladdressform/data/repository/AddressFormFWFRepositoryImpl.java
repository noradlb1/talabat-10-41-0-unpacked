package com.talabat.feature.uladdressform.data.repository;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.deafult.DefaultExperimentsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFeatureFlagsKeys;
import com.talabat.feature.uladdressform.domain.repository.AddressFormFWFRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/uladdressform/data/repository/AddressFormFWFRepositoryImpl;", "Lcom/talabat/feature/uladdressform/domain/repository/AddressFormFWFRepository;", "experiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "experimentEnable", "", "featureFlagCart", "featureFlagCheckout", "featureFlagDefault", "featureFlagMultiLayout", "featureFlagUserAccount", "flutterAddressFormEnable", "screenType", "", "flutterAddressFormMultiLayoutEnable", "Companion", "com_talabat_feature_ul-address-form_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressFormFWFRepositoryImpl implements AddressFormFWFRepository {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String control = "Control";
    @NotNull
    private static final String screenTypeCart = "cart";
    @NotNull
    private static final String screenTypeCheckout = "checkout";
    @NotNull
    private static final String screenTypeUserAccount = "user_account";
    @NotNull
    private final ITalabatExperiment experiment;
    @NotNull
    private final ITalabatFeatureFlag featureFlag;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/feature/uladdressform/data/repository/AddressFormFWFRepositoryImpl$Companion;", "", "()V", "control", "", "screenTypeCart", "screenTypeCheckout", "screenTypeUserAccount", "com_talabat_feature_ul-address-form_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public AddressFormFWFRepositoryImpl(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, InstabugDbContract.ExperimentsEntry.COLUMN_EXPERIMENT);
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlag");
        this.experiment = iTalabatExperiment;
        this.featureFlag = iTalabatFeatureFlag;
    }

    private final boolean experimentEnable() {
        return !Intrinsics.areEqual((Object) this.experiment.getStringVariant(DefaultExperimentsKeys.EXP_USER_FLUTTER_ADDRESS_FORM_VERSION, "Control", TalabatExperimentDataSourceStrategy.FWF), (Object) "Control");
    }

    private final boolean featureFlagCart() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlag, UserFeatureFlagsKeys.FF_USER_FLUTTER_ADDRESS_FORM_FROM_CART, false, 2, (Object) null);
    }

    private final boolean featureFlagCheckout() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlag, UserFeatureFlagsKeys.FF_USER_FLUTTER_ADDRESS_FORM_FROM_CHECKOUT, false, 2, (Object) null);
    }

    private final boolean featureFlagDefault() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlag, UserFeatureFlagsKeys.FF_USER_FLUTTER_ADDRESS_FORM_DEFAULT, false, 2, (Object) null);
    }

    private final boolean featureFlagMultiLayout() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlag, UserFeatureFlagsKeys.FF_USER_FLUTTER_ADDRESS_FORM_MULTI_LAYOUT_API, false, 2, (Object) null);
    }

    private final boolean featureFlagUserAccount() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.featureFlag, UserFeatureFlagsKeys.FF_USER_FLUTTER_ADDRESS_FORM_USER_ACCOUNT, false, 2, (Object) null);
    }

    public boolean flutterAddressFormEnable(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenType");
        if (!experimentEnable()) {
            return false;
        }
        int hashCode = str.hashCode();
        if (hashCode != 3046176) {
            if (hashCode != 348332473) {
                if (hashCode == 1536904518 && str.equals("checkout")) {
                    return featureFlagCheckout();
                }
            } else if (str.equals("user_account")) {
                return featureFlagUserAccount();
            }
        } else if (str.equals("cart")) {
            return featureFlagCart();
        }
        return featureFlagDefault();
    }

    public boolean flutterAddressFormMultiLayoutEnable() {
        return featureFlagMultiLayout();
    }
}
