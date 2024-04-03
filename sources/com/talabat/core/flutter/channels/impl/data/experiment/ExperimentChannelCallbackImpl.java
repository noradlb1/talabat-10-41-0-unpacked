package com.talabat.core.flutter.channels.impl.data.experiment;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.flutter.channels.domain.experiment.ExperimentChannelCallback;
import com.talabat.core.fwfprojectskeys.domain.FWFKeyObject;
import com.talabat.fluttercore.mappers.FWFProjectNameMapper;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/experiment/ExperimentChannelCallbackImpl;", "Lcom/talabat/core/flutter/channels/domain/experiment/ExperimentChannelCallback;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "getBooleanVariant", "", "experimentName", "", "project", "defaultValue", "strategy", "getDoubleVariant", "", "getIntVariant", "", "getStringVariant", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExperimentChannelCallbackImpl implements ExperimentChannelCallback {
    @NotNull
    private final ITalabatExperiment talabatExperiment;

    @Inject
    public ExperimentChannelCallbackImpl(@NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "talabatExperiment");
        this.talabatExperiment = iTalabatExperiment;
    }

    public boolean getBooleanVariant(@NotNull String str, @Nullable String str2, boolean z11, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "experimentName");
        if (str3 == null) {
            return z11;
        }
        FWFKeyObject fWFKeyObject = new FWFKeyObject(str, FWFProjectNameMapper.INSTANCE.getFwfProjectFromProjectName(str2));
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
        String upperCase = str3.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return this.talabatExperiment.getBooleanVariant(fWFKeyObject, z11, TalabatExperimentDataSourceStrategy.valueOf(upperCase));
    }

    public double getDoubleVariant(@NotNull String str, @Nullable String str2, double d11, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "experimentName");
        if (str3 == null) {
            return d11;
        }
        FWFKeyObject fWFKeyObject = new FWFKeyObject(str, FWFProjectNameMapper.INSTANCE.getFwfProjectFromProjectName(str2));
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
        String upperCase = str3.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return this.talabatExperiment.getDoubleVariant(fWFKeyObject, d11, TalabatExperimentDataSourceStrategy.valueOf(upperCase));
    }

    public int getIntVariant(@NotNull String str, @Nullable String str2, int i11, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "experimentName");
        if (str3 == null) {
            return i11;
        }
        FWFKeyObject fWFKeyObject = new FWFKeyObject(str, FWFProjectNameMapper.INSTANCE.getFwfProjectFromProjectName(str2));
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
        String upperCase = str3.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return this.talabatExperiment.getIntVariant(fWFKeyObject, i11, TalabatExperimentDataSourceStrategy.valueOf(upperCase));
    }

    @NotNull
    public String getStringVariant(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "experimentName");
        Intrinsics.checkNotNullParameter(str3, "defaultValue");
        if (str4 == null) {
            return str3;
        }
        FWFKeyObject fWFKeyObject = new FWFKeyObject(str, FWFProjectNameMapper.INSTANCE.getFwfProjectFromProjectName(str2));
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
        String upperCase = str4.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        String stringVariant = this.talabatExperiment.getStringVariant(fWFKeyObject, str3, TalabatExperimentDataSourceStrategy.valueOf(upperCase));
        if (stringVariant == null) {
            return str3;
        }
        return stringVariant;
    }
}
