package com.talabat.core.flutter.channels.domain.experiment;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J,\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J,\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J,\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/experiment/ExperimentChannelCallback;", "", "getBooleanVariant", "", "experimentName", "", "project", "defaultValue", "strategy", "getDoubleVariant", "", "getIntVariant", "", "getStringVariant", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ExperimentChannelCallback {
    boolean getBooleanVariant(@NotNull String str, @Nullable String str2, boolean z11, @Nullable String str3);

    double getDoubleVariant(@NotNull String str, @Nullable String str2, double d11, @Nullable String str3);

    int getIntVariant(@NotNull String str, @Nullable String str2, int i11, @Nullable String str3);

    @NotNull
    String getStringVariant(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable String str4);
}
