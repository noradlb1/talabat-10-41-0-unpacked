package com.talabat.feature.tokenization.domain.usecase;

import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/feature/tokenization/domain/usecase/ObserveTokenizationSuccessUseCase;", "", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "invoke", "", "Companion", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ObserveTokenizationSuccessUseCase {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    private static final String EVENT_NAME = "token_generated_successfully";
    @NotNull
    @Deprecated
    private static final String EVENT_TYPE = "new_checkout_sdk_tokenization";
    @NotNull
    private final IObservabilityManager observabilityManager;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/feature/tokenization/domain/usecase/ObserveTokenizationSuccessUseCase$Companion;", "", "()V", "EVENT_NAME", "", "EVENT_TYPE", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ObserveTokenizationSuccessUseCase(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.observabilityManager = iObservabilityManager;
    }

    public final void invoke() {
        IObservabilityManager.DefaultImpls.trackEvent$default(this.observabilityManager, EVENT_NAME, EVENT_TYPE, (Map) null, 4, (Object) null);
    }
}
