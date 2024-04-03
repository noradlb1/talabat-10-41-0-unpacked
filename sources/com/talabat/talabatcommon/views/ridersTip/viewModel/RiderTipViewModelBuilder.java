package com.talabat.talabatcommon.views.ridersTip.viewModel;

import android.content.Context;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.ridersTip.CheckDesignSystemChipsEnabledUseCase;
import com.talabat.talabatcommon.feature.ridersTip.GetRiderTipPaymentUseCase;
import com.talabat.talabatcommon.feature.ridersTip.GetRiderTipSuggestedAmountUseCase;
import com.talabat.talabatcommon.feature.ridersTip.network.RiderTipService;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.TipRiderTrackingImpl;
import com.talabat.talabatcommon.feature.ridersTip.repository.RiderTipRepositoryImpl;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/viewModel/RiderTipViewModelBuilder;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipViewModelBuilder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/viewModel/RiderTipViewModelBuilder$Companion;", "", "()V", "getRiderTipSuggestedAmountViewModel", "Lcom/talabat/talabatcommon/views/ridersTip/viewModel/RiderTipViewModelImpl;", "context", "Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RiderTipViewModelImpl getRiderTipSuggestedAmountViewModel(@NotNull Context context, @NotNull CoroutineScope coroutineScope, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
            Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
            RiderTipRepositoryImpl riderTipRepositoryImpl = new RiderTipRepositoryImpl(new NetworkHandler(context), new RiderTipService(new TalabatAPIBuilder()));
            CoroutineScope coroutineScope2 = coroutineScope;
            return new RiderTipViewModelImpl(new GetRiderTipSuggestedAmountUseCase(riderTipRepositoryImpl, coroutineScope2, Dispatchers.getMain(), (Function1) null, 8, (DefaultConstructorMarker) null), new GetRiderTipPaymentUseCase(riderTipRepositoryImpl, coroutineScope2, Dispatchers.getMain(), (Function1) null, 8, (DefaultConstructorMarker) null), new CheckDesignSystemChipsEnabledUseCase(iTalabatFeatureFlag), new TipRiderTrackingImpl(context));
        }
    }
}
