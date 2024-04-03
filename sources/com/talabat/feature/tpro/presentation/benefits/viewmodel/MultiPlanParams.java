package com.talabat.feature.tpro.presentation.benefits.viewmodel;

import com.talabat.feature.subscriptions.domain.usecase.GetSubscriptionMultiPlanUseCase;
import com.talabat.feature.tpro.presentation.model.mapper.TProMultiPlanDisplayModelMapper;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/viewmodel/MultiPlanParams;", "", "getSubscriptionMultiPlanUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionMultiPlanUseCase;", "multiPlanMapper", "Lcom/talabat/feature/tpro/presentation/model/mapper/TProMultiPlanDisplayModelMapper;", "multiPlanDurations", "", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionMultiPlanUseCase;Lcom/talabat/feature/tpro/presentation/model/mapper/TProMultiPlanDisplayModelMapper;Ljava/lang/String;)V", "getGetSubscriptionMultiPlanUseCase", "()Lcom/talabat/feature/subscriptions/domain/usecase/GetSubscriptionMultiPlanUseCase;", "getMultiPlanDurations", "()Ljava/lang/String;", "getMultiPlanMapper", "()Lcom/talabat/feature/tpro/presentation/model/mapper/TProMultiPlanDisplayModelMapper;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MultiPlanParams {
    @NotNull
    private final GetSubscriptionMultiPlanUseCase getSubscriptionMultiPlanUseCase;
    @Nullable
    private final String multiPlanDurations;
    @NotNull
    private final TProMultiPlanDisplayModelMapper multiPlanMapper;

    @Inject
    public MultiPlanParams(@NotNull GetSubscriptionMultiPlanUseCase getSubscriptionMultiPlanUseCase2, @NotNull TProMultiPlanDisplayModelMapper tProMultiPlanDisplayModelMapper, @Nullable @Named("tProMultiPlanDurations") String str) {
        Intrinsics.checkNotNullParameter(getSubscriptionMultiPlanUseCase2, "getSubscriptionMultiPlanUseCase");
        Intrinsics.checkNotNullParameter(tProMultiPlanDisplayModelMapper, "multiPlanMapper");
        this.getSubscriptionMultiPlanUseCase = getSubscriptionMultiPlanUseCase2;
        this.multiPlanMapper = tProMultiPlanDisplayModelMapper;
        this.multiPlanDurations = str;
    }

    public static /* synthetic */ MultiPlanParams copy$default(MultiPlanParams multiPlanParams, GetSubscriptionMultiPlanUseCase getSubscriptionMultiPlanUseCase2, TProMultiPlanDisplayModelMapper tProMultiPlanDisplayModelMapper, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            getSubscriptionMultiPlanUseCase2 = multiPlanParams.getSubscriptionMultiPlanUseCase;
        }
        if ((i11 & 2) != 0) {
            tProMultiPlanDisplayModelMapper = multiPlanParams.multiPlanMapper;
        }
        if ((i11 & 4) != 0) {
            str = multiPlanParams.multiPlanDurations;
        }
        return multiPlanParams.copy(getSubscriptionMultiPlanUseCase2, tProMultiPlanDisplayModelMapper, str);
    }

    @NotNull
    public final GetSubscriptionMultiPlanUseCase component1() {
        return this.getSubscriptionMultiPlanUseCase;
    }

    @NotNull
    public final TProMultiPlanDisplayModelMapper component2() {
        return this.multiPlanMapper;
    }

    @Nullable
    public final String component3() {
        return this.multiPlanDurations;
    }

    @NotNull
    public final MultiPlanParams copy(@NotNull GetSubscriptionMultiPlanUseCase getSubscriptionMultiPlanUseCase2, @NotNull TProMultiPlanDisplayModelMapper tProMultiPlanDisplayModelMapper, @Nullable @Named("tProMultiPlanDurations") String str) {
        Intrinsics.checkNotNullParameter(getSubscriptionMultiPlanUseCase2, "getSubscriptionMultiPlanUseCase");
        Intrinsics.checkNotNullParameter(tProMultiPlanDisplayModelMapper, "multiPlanMapper");
        return new MultiPlanParams(getSubscriptionMultiPlanUseCase2, tProMultiPlanDisplayModelMapper, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultiPlanParams)) {
            return false;
        }
        MultiPlanParams multiPlanParams = (MultiPlanParams) obj;
        return Intrinsics.areEqual((Object) this.getSubscriptionMultiPlanUseCase, (Object) multiPlanParams.getSubscriptionMultiPlanUseCase) && Intrinsics.areEqual((Object) this.multiPlanMapper, (Object) multiPlanParams.multiPlanMapper) && Intrinsics.areEqual((Object) this.multiPlanDurations, (Object) multiPlanParams.multiPlanDurations);
    }

    @NotNull
    public final GetSubscriptionMultiPlanUseCase getGetSubscriptionMultiPlanUseCase() {
        return this.getSubscriptionMultiPlanUseCase;
    }

    @Nullable
    public final String getMultiPlanDurations() {
        return this.multiPlanDurations;
    }

    @NotNull
    public final TProMultiPlanDisplayModelMapper getMultiPlanMapper() {
        return this.multiPlanMapper;
    }

    public int hashCode() {
        int hashCode = ((this.getSubscriptionMultiPlanUseCase.hashCode() * 31) + this.multiPlanMapper.hashCode()) * 31;
        String str = this.multiPlanDurations;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        GetSubscriptionMultiPlanUseCase getSubscriptionMultiPlanUseCase2 = this.getSubscriptionMultiPlanUseCase;
        TProMultiPlanDisplayModelMapper tProMultiPlanDisplayModelMapper = this.multiPlanMapper;
        String str = this.multiPlanDurations;
        return "MultiPlanParams(getSubscriptionMultiPlanUseCase=" + getSubscriptionMultiPlanUseCase2 + ", multiPlanMapper=" + tProMultiPlanDisplayModelMapper + ", multiPlanDurations=" + str + ")";
    }
}
