package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingDefaultWidgetModel;", "Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetModel;", "widgetType", "Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetType;", "trackingId", "", "(Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetType;Ljava/lang/String;)V", "getTrackingId", "()Ljava/lang/String;", "getWidgetType", "()Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingDefaultWidgetModel extends HeroWidgetModel {
    @NotNull
    private final String trackingId;
    @NotNull
    private final HeroWidgetType widgetType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProOnBoardingDefaultWidgetModel(@NotNull HeroWidgetType heroWidgetType, @NotNull String str) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(heroWidgetType, "widgetType");
        Intrinsics.checkNotNullParameter(str, "trackingId");
        this.widgetType = heroWidgetType;
        this.trackingId = str;
    }

    public static /* synthetic */ TProOnBoardingDefaultWidgetModel copy$default(TProOnBoardingDefaultWidgetModel tProOnBoardingDefaultWidgetModel, HeroWidgetType heroWidgetType, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            heroWidgetType = tProOnBoardingDefaultWidgetModel.getWidgetType();
        }
        if ((i11 & 2) != 0) {
            str = tProOnBoardingDefaultWidgetModel.getTrackingId();
        }
        return tProOnBoardingDefaultWidgetModel.copy(heroWidgetType, str);
    }

    @NotNull
    public final HeroWidgetType component1() {
        return getWidgetType();
    }

    @NotNull
    public final String component2() {
        return getTrackingId();
    }

    @NotNull
    public final TProOnBoardingDefaultWidgetModel copy(@NotNull HeroWidgetType heroWidgetType, @NotNull String str) {
        Intrinsics.checkNotNullParameter(heroWidgetType, "widgetType");
        Intrinsics.checkNotNullParameter(str, "trackingId");
        return new TProOnBoardingDefaultWidgetModel(heroWidgetType, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingDefaultWidgetModel)) {
            return false;
        }
        TProOnBoardingDefaultWidgetModel tProOnBoardingDefaultWidgetModel = (TProOnBoardingDefaultWidgetModel) obj;
        return getWidgetType() == tProOnBoardingDefaultWidgetModel.getWidgetType() && Intrinsics.areEqual((Object) getTrackingId(), (Object) tProOnBoardingDefaultWidgetModel.getTrackingId());
    }

    @NotNull
    public String getTrackingId() {
        return this.trackingId;
    }

    @NotNull
    public HeroWidgetType getWidgetType() {
        return this.widgetType;
    }

    public int hashCode() {
        return (getWidgetType().hashCode() * 31) + getTrackingId().hashCode();
    }

    @NotNull
    public String toString() {
        HeroWidgetType widgetType2 = getWidgetType();
        String trackingId2 = getTrackingId();
        return "TProOnBoardingDefaultWidgetModel(widgetType=" + widgetType2 + ", trackingId=" + trackingId2 + ")";
    }
}
