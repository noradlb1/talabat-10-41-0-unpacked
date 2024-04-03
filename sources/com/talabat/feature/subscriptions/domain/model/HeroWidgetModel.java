package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetModel;", "", "()V", "trackingId", "", "getTrackingId", "()Ljava/lang/String;", "widgetType", "Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetType;", "getWidgetType", "()Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetType;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingDefaultWidgetModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingExpandableWidgetModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingInfoWidgetModel;", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class HeroWidgetModel {
    private HeroWidgetModel() {
    }

    public /* synthetic */ HeroWidgetModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract String getTrackingId();

    @NotNull
    public abstract HeroWidgetType getWidgetType();
}
