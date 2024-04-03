package com.talabat.flutter.groceryhome.presentation.handler;

import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/flutter/groceryhome/presentation/handler/FWFParams;", "", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getTalabatExperiment", "()Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "getTalabatFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FWFParams {
    @NotNull
    private final ITalabatExperiment talabatExperiment;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public FWFParams(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        this.talabatExperiment = iTalabatExperiment;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public static /* synthetic */ FWFParams copy$default(FWFParams fWFParams, ITalabatExperiment iTalabatExperiment, ITalabatFeatureFlag iTalabatFeatureFlag, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            iTalabatExperiment = fWFParams.talabatExperiment;
        }
        if ((i11 & 2) != 0) {
            iTalabatFeatureFlag = fWFParams.talabatFeatureFlag;
        }
        return fWFParams.copy(iTalabatExperiment, iTalabatFeatureFlag);
    }

    @NotNull
    public final ITalabatExperiment component1() {
        return this.talabatExperiment;
    }

    @NotNull
    public final ITalabatFeatureFlag component2() {
        return this.talabatFeatureFlag;
    }

    @NotNull
    public final FWFParams copy(@NotNull ITalabatExperiment iTalabatExperiment, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        return new FWFParams(iTalabatExperiment, iTalabatFeatureFlag);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FWFParams)) {
            return false;
        }
        FWFParams fWFParams = (FWFParams) obj;
        return Intrinsics.areEqual((Object) this.talabatExperiment, (Object) fWFParams.talabatExperiment) && Intrinsics.areEqual((Object) this.talabatFeatureFlag, (Object) fWFParams.talabatFeatureFlag);
    }

    @NotNull
    public final ITalabatExperiment getTalabatExperiment() {
        return this.talabatExperiment;
    }

    @NotNull
    public final ITalabatFeatureFlag getTalabatFeatureFlag() {
        return this.talabatFeatureFlag;
    }

    public int hashCode() {
        return (this.talabatExperiment.hashCode() * 31) + this.talabatFeatureFlag.hashCode();
    }

    @NotNull
    public String toString() {
        ITalabatExperiment iTalabatExperiment = this.talabatExperiment;
        ITalabatFeatureFlag iTalabatFeatureFlag = this.talabatFeatureFlag;
        return "FWFParams(talabatExperiment=" + iTalabatExperiment + ", talabatFeatureFlag=" + iTalabatFeatureFlag + ")";
    }
}
