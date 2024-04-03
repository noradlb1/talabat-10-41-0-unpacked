package com.talabat.feature.pickup.presentation.entity;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.feature.pickup.data.events.swimlanes.SwimlanesTracking;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\tHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/pickup/presentation/entity/SwimlaneHeaderView;", "", "title", "", "subTitle", "items", "", "Lcom/talabat/feature/pickup/presentation/entity/SwimlaneView;", "tracking", "Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;)V", "getItems", "()Ljava/util/List;", "getSubTitle", "()Ljava/lang/String;", "getTitle", "getTracking", "()Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneHeaderView {
    @NotNull
    private final List<SwimlaneView> items;
    @NotNull
    private final String subTitle;
    @NotNull
    private final String title;
    @NotNull

    /* renamed from: tracking  reason: collision with root package name */
    private final SwimlanesTracking f58671tracking;

    public SwimlaneHeaderView(@NotNull String str, @NotNull String str2, @NotNull List<SwimlaneView> list, @NotNull SwimlanesTracking swimlanesTracking) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subTitle");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(swimlanesTracking, "tracking");
        this.title = str;
        this.subTitle = str2;
        this.items = list;
        this.f58671tracking = swimlanesTracking;
    }

    public static /* synthetic */ SwimlaneHeaderView copy$default(SwimlaneHeaderView swimlaneHeaderView, String str, String str2, List<SwimlaneView> list, SwimlanesTracking swimlanesTracking, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = swimlaneHeaderView.title;
        }
        if ((i11 & 2) != 0) {
            str2 = swimlaneHeaderView.subTitle;
        }
        if ((i11 & 4) != 0) {
            list = swimlaneHeaderView.items;
        }
        if ((i11 & 8) != 0) {
            swimlanesTracking = swimlaneHeaderView.f58671tracking;
        }
        return swimlaneHeaderView.copy(str, str2, list, swimlanesTracking);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.subTitle;
    }

    @NotNull
    public final List<SwimlaneView> component3() {
        return this.items;
    }

    @NotNull
    public final SwimlanesTracking component4() {
        return this.f58671tracking;
    }

    @NotNull
    public final SwimlaneHeaderView copy(@NotNull String str, @NotNull String str2, @NotNull List<SwimlaneView> list, @NotNull SwimlanesTracking swimlanesTracking) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "subTitle");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(swimlanesTracking, "tracking");
        return new SwimlaneHeaderView(str, str2, list, swimlanesTracking);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlaneHeaderView)) {
            return false;
        }
        SwimlaneHeaderView swimlaneHeaderView = (SwimlaneHeaderView) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) swimlaneHeaderView.title) && Intrinsics.areEqual((Object) this.subTitle, (Object) swimlaneHeaderView.subTitle) && Intrinsics.areEqual((Object) this.items, (Object) swimlaneHeaderView.items) && Intrinsics.areEqual((Object) this.f58671tracking, (Object) swimlaneHeaderView.f58671tracking);
    }

    @NotNull
    public final List<SwimlaneView> getItems() {
        return this.items;
    }

    @NotNull
    public final String getSubTitle() {
        return this.subTitle;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final SwimlanesTracking getTracking() {
        return this.f58671tracking;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.subTitle.hashCode()) * 31) + this.items.hashCode()) * 31) + this.f58671tracking.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.subTitle;
        List<SwimlaneView> list = this.items;
        SwimlanesTracking swimlanesTracking = this.f58671tracking;
        return "SwimlaneHeaderView(title=" + str + ", subTitle=" + str2 + ", items=" + list + ", tracking=" + swimlanesTracking + ")";
    }
}
