package com.talabat.feature.darkstores.vendorlanding.domain.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMission;", "", "items", "", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMissionItem;", "metadata", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMetadata;", "pageInfo", "Lcom/talabat/feature/darkstores/vendorlanding/domain/model/PageInfo;", "(Ljava/util/List;Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMetadata;Lcom/talabat/feature/darkstores/vendorlanding/domain/model/PageInfo;)V", "getItems", "()Ljava/util/List;", "getMetadata", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/model/LifestyleMetadata;", "getPageInfo", "()Lcom/talabat/feature/darkstores/vendorlanding/domain/model/PageInfo;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_darkstores-vendor-landing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifestyleMission {
    @NotNull
    private final List<LifestyleMissionItem> items;
    @Nullable
    private final LifestyleMetadata metadata;
    @NotNull
    private final PageInfo pageInfo;

    public LifestyleMission(@NotNull List<LifestyleMissionItem> list, @Nullable LifestyleMetadata lifestyleMetadata, @NotNull PageInfo pageInfo2) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(pageInfo2, "pageInfo");
        this.items = list;
        this.metadata = lifestyleMetadata;
        this.pageInfo = pageInfo2;
    }

    public static /* synthetic */ LifestyleMission copy$default(LifestyleMission lifestyleMission, List<LifestyleMissionItem> list, LifestyleMetadata lifestyleMetadata, PageInfo pageInfo2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = lifestyleMission.items;
        }
        if ((i11 & 2) != 0) {
            lifestyleMetadata = lifestyleMission.metadata;
        }
        if ((i11 & 4) != 0) {
            pageInfo2 = lifestyleMission.pageInfo;
        }
        return lifestyleMission.copy(list, lifestyleMetadata, pageInfo2);
    }

    @NotNull
    public final List<LifestyleMissionItem> component1() {
        return this.items;
    }

    @Nullable
    public final LifestyleMetadata component2() {
        return this.metadata;
    }

    @NotNull
    public final PageInfo component3() {
        return this.pageInfo;
    }

    @NotNull
    public final LifestyleMission copy(@NotNull List<LifestyleMissionItem> list, @Nullable LifestyleMetadata lifestyleMetadata, @NotNull PageInfo pageInfo2) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(pageInfo2, "pageInfo");
        return new LifestyleMission(list, lifestyleMetadata, pageInfo2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LifestyleMission)) {
            return false;
        }
        LifestyleMission lifestyleMission = (LifestyleMission) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) lifestyleMission.items) && Intrinsics.areEqual((Object) this.metadata, (Object) lifestyleMission.metadata) && Intrinsics.areEqual((Object) this.pageInfo, (Object) lifestyleMission.pageInfo);
    }

    @NotNull
    public final List<LifestyleMissionItem> getItems() {
        return this.items;
    }

    @Nullable
    public final LifestyleMetadata getMetadata() {
        return this.metadata;
    }

    @NotNull
    public final PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public int hashCode() {
        int hashCode = this.items.hashCode() * 31;
        LifestyleMetadata lifestyleMetadata = this.metadata;
        return ((hashCode + (lifestyleMetadata == null ? 0 : lifestyleMetadata.hashCode())) * 31) + this.pageInfo.hashCode();
    }

    @NotNull
    public String toString() {
        List<LifestyleMissionItem> list = this.items;
        LifestyleMetadata lifestyleMetadata = this.metadata;
        PageInfo pageInfo2 = this.pageInfo;
        return "LifestyleMission(items=" + list + ", metadata=" + lifestyleMetadata + ", pageInfo=" + pageInfo2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LifestyleMission(List list, LifestyleMetadata lifestyleMetadata, PageInfo pageInfo2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i11 & 2) != 0 ? null : lifestyleMetadata, pageInfo2);
    }
}
