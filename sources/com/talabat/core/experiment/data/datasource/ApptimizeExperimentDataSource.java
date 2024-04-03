package com.talabat.core.experiment.data.datasource;

import com.talabat.apptimize.ApptimizeSdkWrapper;
import com.talabat.core.experiment.data.datasource.IExperimentDataSource;
import com.talabat.core.experiment.domain.FWFAttributes;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/core/experiment/data/datasource/ApptimizeExperimentDataSource;", "Lcom/talabat/core/experiment/data/datasource/IExperimentDataSource;", "apptimizeSdkWrapper", "Lcom/talabat/apptimize/ApptimizeSdkWrapper;", "(Lcom/talabat/apptimize/ApptimizeSdkWrapper;)V", "getBooleanVariant", "", "experimentKey", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "defaultValue", "getDoubleVariant", "", "getIntVariant", "", "getStringVariant", "", "setAttribute", "", "attributeKey", "attributeValue", "com_talabat_core_experiment_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApptimizeExperimentDataSource implements IExperimentDataSource {
    @NotNull
    private final ApptimizeSdkWrapper apptimizeSdkWrapper;

    public ApptimizeExperimentDataSource() {
        this((ApptimizeSdkWrapper) null, 1, (DefaultConstructorMarker) null);
    }

    public ApptimizeExperimentDataSource(@NotNull ApptimizeSdkWrapper apptimizeSdkWrapper2) {
        Intrinsics.checkNotNullParameter(apptimizeSdkWrapper2, "apptimizeSdkWrapper");
        this.apptimizeSdkWrapper = apptimizeSdkWrapper2;
    }

    @Nullable
    public Object getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Continuation<? super Boolean> continuation) {
        return IExperimentDataSource.DefaultImpls.getBooleanVariant((IExperimentDataSource) this, fWFKey, z11, z12, continuation);
    }

    @Nullable
    public Object getDoubleVariant(@NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull Continuation<? super Double> continuation) {
        return IExperimentDataSource.DefaultImpls.getDoubleVariant((IExperimentDataSource) this, fWFKey, d11, z11, continuation);
    }

    @Nullable
    public Object getIntVariant(@NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull Continuation<? super Integer> continuation) {
        return IExperimentDataSource.DefaultImpls.getIntVariant((IExperimentDataSource) this, fWFKey, i11, z11, continuation);
    }

    @Nullable
    public Object getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull Continuation<? super String> continuation) {
        return IExperimentDataSource.DefaultImpls.getStringVariant((IExperimentDataSource) this, fWFKey, str, z11, continuation);
    }

    public void setAttribute(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "attributeKey");
        Intrinsics.checkNotNullParameter(str2, "attributeValue");
        if (Intrinsics.areEqual((Object) str, (Object) FWFAttributes.PILOT_TARGETING_ID.getKey())) {
            this.apptimizeSdkWrapper.setPilotTargetingId(str2);
        } else {
            this.apptimizeSdkWrapper.setAttribute(str, str2);
        }
    }

    public void getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11, boolean z12, @NotNull Function1<? super Boolean, Unit> function1) {
        IExperimentDataSource.DefaultImpls.getBooleanVariant((IExperimentDataSource) this, fWFKey, z11, z12, function1);
    }

    public void getDoubleVariant(@NotNull FWFKey fWFKey, double d11, boolean z11, @NotNull Function1<? super Double, Unit> function1) {
        IExperimentDataSource.DefaultImpls.getDoubleVariant((IExperimentDataSource) this, fWFKey, d11, z11, function1);
    }

    public void getIntVariant(@NotNull FWFKey fWFKey, int i11, boolean z11, @NotNull Function1<? super Integer, Unit> function1) {
        IExperimentDataSource.DefaultImpls.getIntVariant((IExperimentDataSource) this, fWFKey, i11, z11, function1);
    }

    public void getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str, boolean z11, @NotNull Function1<? super String, Unit> function1) {
        IExperimentDataSource.DefaultImpls.getStringVariant((IExperimentDataSource) this, fWFKey, str, z11, function1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ApptimizeExperimentDataSource(ApptimizeSdkWrapper apptimizeSdkWrapper2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? ApptimizeSdkWrapper.INSTANCE : apptimizeSdkWrapper2);
    }

    public boolean getBooleanVariant(@NotNull FWFKey fWFKey, boolean z11) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        return this.apptimizeSdkWrapper.getBooleanVariant(fWFKey.getValue(), z11);
    }

    public double getDoubleVariant(@NotNull FWFKey fWFKey, double d11) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        return this.apptimizeSdkWrapper.getDoubleVariant(fWFKey.getValue(), d11);
    }

    public int getIntVariant(@NotNull FWFKey fWFKey, int i11) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        return this.apptimizeSdkWrapper.getIntVariant(fWFKey.getValue(), i11);
    }

    @NotNull
    public String getStringVariant(@NotNull FWFKey fWFKey, @NotNull String str) {
        Intrinsics.checkNotNullParameter(fWFKey, "experimentKey");
        Intrinsics.checkNotNullParameter(str, "defaultValue");
        return this.apptimizeSdkWrapper.getStringVariant(fWFKey.getValue(), str);
    }
}
