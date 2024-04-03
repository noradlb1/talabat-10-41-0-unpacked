package com.talabat.feature.subscriptions.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\nHÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingInfoWidgetModel;", "Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetModel;", "selectedIndex", "", "listItems", "", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingInfoItemModel;", "widgetType", "Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetType;", "trackingId", "", "(ILjava/util/List;Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetType;Ljava/lang/String;)V", "getListItems", "()Ljava/util/List;", "getSelectedIndex", "()I", "getTrackingId", "()Ljava/lang/String;", "getWidgetType", "()Lcom/talabat/feature/subscriptions/domain/model/HeroWidgetType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingInfoWidgetModel extends HeroWidgetModel {
    @NotNull
    private final List<TProOnBoardingInfoItemModel> listItems;
    private final int selectedIndex;
    @NotNull
    private final String trackingId;
    @NotNull
    private final HeroWidgetType widgetType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TProOnBoardingInfoWidgetModel(int i11, @NotNull List<TProOnBoardingInfoItemModel> list, @NotNull HeroWidgetType heroWidgetType, @NotNull String str) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "listItems");
        Intrinsics.checkNotNullParameter(heroWidgetType, "widgetType");
        Intrinsics.checkNotNullParameter(str, "trackingId");
        this.selectedIndex = i11;
        this.listItems = list;
        this.widgetType = heroWidgetType;
        this.trackingId = str;
    }

    public static /* synthetic */ TProOnBoardingInfoWidgetModel copy$default(TProOnBoardingInfoWidgetModel tProOnBoardingInfoWidgetModel, int i11, List<TProOnBoardingInfoItemModel> list, HeroWidgetType heroWidgetType, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = tProOnBoardingInfoWidgetModel.selectedIndex;
        }
        if ((i12 & 2) != 0) {
            list = tProOnBoardingInfoWidgetModel.listItems;
        }
        if ((i12 & 4) != 0) {
            heroWidgetType = tProOnBoardingInfoWidgetModel.getWidgetType();
        }
        if ((i12 & 8) != 0) {
            str = tProOnBoardingInfoWidgetModel.getTrackingId();
        }
        return tProOnBoardingInfoWidgetModel.copy(i11, list, heroWidgetType, str);
    }

    public final int component1() {
        return this.selectedIndex;
    }

    @NotNull
    public final List<TProOnBoardingInfoItemModel> component2() {
        return this.listItems;
    }

    @NotNull
    public final HeroWidgetType component3() {
        return getWidgetType();
    }

    @NotNull
    public final String component4() {
        return getTrackingId();
    }

    @NotNull
    public final TProOnBoardingInfoWidgetModel copy(int i11, @NotNull List<TProOnBoardingInfoItemModel> list, @NotNull HeroWidgetType heroWidgetType, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "listItems");
        Intrinsics.checkNotNullParameter(heroWidgetType, "widgetType");
        Intrinsics.checkNotNullParameter(str, "trackingId");
        return new TProOnBoardingInfoWidgetModel(i11, list, heroWidgetType, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingInfoWidgetModel)) {
            return false;
        }
        TProOnBoardingInfoWidgetModel tProOnBoardingInfoWidgetModel = (TProOnBoardingInfoWidgetModel) obj;
        return this.selectedIndex == tProOnBoardingInfoWidgetModel.selectedIndex && Intrinsics.areEqual((Object) this.listItems, (Object) tProOnBoardingInfoWidgetModel.listItems) && getWidgetType() == tProOnBoardingInfoWidgetModel.getWidgetType() && Intrinsics.areEqual((Object) getTrackingId(), (Object) tProOnBoardingInfoWidgetModel.getTrackingId());
    }

    @NotNull
    public final List<TProOnBoardingInfoItemModel> getListItems() {
        return this.listItems;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
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
        return (((((this.selectedIndex * 31) + this.listItems.hashCode()) * 31) + getWidgetType().hashCode()) * 31) + getTrackingId().hashCode();
    }

    @NotNull
    public String toString() {
        int i11 = this.selectedIndex;
        List<TProOnBoardingInfoItemModel> list = this.listItems;
        HeroWidgetType widgetType2 = getWidgetType();
        String trackingId2 = getTrackingId();
        return "TProOnBoardingInfoWidgetModel(selectedIndex=" + i11 + ", listItems=" + list + ", widgetType=" + widgetType2 + ", trackingId=" + trackingId2 + ")";
    }
}
