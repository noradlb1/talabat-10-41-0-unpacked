package com.talabat.core.tracking.domain;

import com.talabat.core.di.Api;
import com.talabat.core.tracking.domain.adjust.AdjustTracker;
import com.talabat.core.tracking.domain.migration.FlutterMigrationTools;
import com.talabat.core.tracking.domain.perseus.PerseusEventTools;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/tracking/domain/TrackingCoreLibApi;", "Lcom/talabat/core/di/Api;", "adjustTracker", "Lcom/talabat/core/tracking/domain/adjust/AdjustTracker;", "getAdjustTracker", "()Lcom/talabat/core/tracking/domain/adjust/AdjustTracker;", "analyticsType", "Lcom/talabat/core/tracking/domain/AnalyticsType;", "getAnalyticsType", "()Lcom/talabat/core/tracking/domain/AnalyticsType;", "flutterMigrationTools", "Lcom/talabat/core/tracking/domain/migration/FlutterMigrationTools;", "getFlutterMigrationTools", "()Lcom/talabat/core/tracking/domain/migration/FlutterMigrationTools;", "perseusEventTools", "Lcom/talabat/core/tracking/domain/perseus/PerseusEventTools;", "getPerseusEventTools", "()Lcom/talabat/core/tracking/domain/perseus/PerseusEventTools;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTalabatTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "com_talabat_core_tracking_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TrackingCoreLibApi extends Api {
    @NotNull
    AdjustTracker getAdjustTracker();

    @NotNull
    AnalyticsType getAnalyticsType();

    @NotNull
    FlutterMigrationTools getFlutterMigrationTools();

    @NotNull
    PerseusEventTools getPerseusEventTools();

    @NotNull
    TalabatTracker getTalabatTracker();
}
