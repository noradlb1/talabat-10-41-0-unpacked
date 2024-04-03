package com.talabat.feature.subscriptions.data.remote.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J8\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingInfoWidgetResponseModel;", "Lcom/talabat/feature/subscriptions/data/remote/model/HeroWidgetResponseModel;", "selectedIndex", "", "listItems", "", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingInfoItemResponseModel;", "trackingId", "", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)V", "getListItems", "()Ljava/util/List;", "getSelectedIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTrackingId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingInfoWidgetResponseModel;", "equals", "", "other", "", "hashCode", "toString", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingInfoWidgetResponseModel extends HeroWidgetResponseModel {
    @Nullable
    private final List<TProOnBoardingInfoItemResponseModel> listItems;
    @Nullable
    private final Integer selectedIndex;
    @Nullable
    private final String trackingId;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TProOnBoardingInfoWidgetResponseModel(Integer num, List list, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : list, str);
    }

    public static /* synthetic */ TProOnBoardingInfoWidgetResponseModel copy$default(TProOnBoardingInfoWidgetResponseModel tProOnBoardingInfoWidgetResponseModel, Integer num, List<TProOnBoardingInfoItemResponseModel> list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = tProOnBoardingInfoWidgetResponseModel.selectedIndex;
        }
        if ((i11 & 2) != 0) {
            list = tProOnBoardingInfoWidgetResponseModel.listItems;
        }
        if ((i11 & 4) != 0) {
            str = tProOnBoardingInfoWidgetResponseModel.getTrackingId();
        }
        return tProOnBoardingInfoWidgetResponseModel.copy(num, list, str);
    }

    @Nullable
    public final Integer component1() {
        return this.selectedIndex;
    }

    @Nullable
    public final List<TProOnBoardingInfoItemResponseModel> component2() {
        return this.listItems;
    }

    @Nullable
    public final String component3() {
        return getTrackingId();
    }

    @NotNull
    public final TProOnBoardingInfoWidgetResponseModel copy(@Nullable @Json(name = "selectedIndex") Integer num, @Nullable @Json(name = "listItems") List<TProOnBoardingInfoItemResponseModel> list, @Nullable @Json(name = "trackingId") String str) {
        return new TProOnBoardingInfoWidgetResponseModel(num, list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TProOnBoardingInfoWidgetResponseModel)) {
            return false;
        }
        TProOnBoardingInfoWidgetResponseModel tProOnBoardingInfoWidgetResponseModel = (TProOnBoardingInfoWidgetResponseModel) obj;
        return Intrinsics.areEqual((Object) this.selectedIndex, (Object) tProOnBoardingInfoWidgetResponseModel.selectedIndex) && Intrinsics.areEqual((Object) this.listItems, (Object) tProOnBoardingInfoWidgetResponseModel.listItems) && Intrinsics.areEqual((Object) getTrackingId(), (Object) tProOnBoardingInfoWidgetResponseModel.getTrackingId());
    }

    @Nullable
    public final List<TProOnBoardingInfoItemResponseModel> getListItems() {
        return this.listItems;
    }

    @Nullable
    public final Integer getSelectedIndex() {
        return this.selectedIndex;
    }

    @Nullable
    public String getTrackingId() {
        return this.trackingId;
    }

    public int hashCode() {
        Integer num = this.selectedIndex;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<TProOnBoardingInfoItemResponseModel> list = this.listItems;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        if (getTrackingId() != null) {
            i11 = getTrackingId().hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.selectedIndex;
        List<TProOnBoardingInfoItemResponseModel> list = this.listItems;
        String trackingId2 = getTrackingId();
        return "TProOnBoardingInfoWidgetResponseModel(selectedIndex=" + num + ", listItems=" + list + ", trackingId=" + trackingId2 + ")";
    }

    public TProOnBoardingInfoWidgetResponseModel(@Nullable @Json(name = "selectedIndex") Integer num, @Nullable @Json(name = "listItems") List<TProOnBoardingInfoItemResponseModel> list, @Nullable @Json(name = "trackingId") String str) {
        super(HeroWidgetTypeResponse.infoWidget.name(), str);
        this.selectedIndex = num;
        this.listItems = list;
        this.trackingId = str;
    }
}
