package com.talabat.darkstores.feature.home;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\f\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\f\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "", "priority", "", "(I)V", "getPriority", "()I", "CategoryGridItem", "HeroBannerItem", "LifeStyleMissionV1Item", "LifestyleMissionV2Item", "PrimaryMissionItem", "ProgressViewItem", "RewardsMissionItem", "SearchViewItem", "SmallBannerItem", "SwimlaneItem", "TproSubscriptionItem", "TproSubscriptionItemV2", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$SmallBannerItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$HeroBannerItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$SwimlaneItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$CategoryGridItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$LifestyleMissionV2Item;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$LifeStyleMissionV1Item;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$PrimaryMissionItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$RewardsMissionItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$SearchViewItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$TproSubscriptionItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$TproSubscriptionItemV2;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$ProgressViewItem;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class HomeRecyclerViewItem {
    private final int priority;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$CategoryGridItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "item", "Lcom/talabat/darkstores/feature/home/CategoryViewHolderData;", "(Lcom/talabat/darkstores/feature/home/CategoryViewHolderData;)V", "getItem", "()Lcom/talabat/darkstores/feature/home/CategoryViewHolderData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CategoryGridItem extends HomeRecyclerViewItem {
        @NotNull
        private final CategoryViewHolderData item;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CategoryGridItem(@NotNull CategoryViewHolderData categoryViewHolderData) {
            super(10, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(categoryViewHolderData, "item");
            this.item = categoryViewHolderData;
        }

        public static /* synthetic */ CategoryGridItem copy$default(CategoryGridItem categoryGridItem, CategoryViewHolderData categoryViewHolderData, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                categoryViewHolderData = categoryGridItem.item;
            }
            return categoryGridItem.copy(categoryViewHolderData);
        }

        @NotNull
        public final CategoryViewHolderData component1() {
            return this.item;
        }

        @NotNull
        public final CategoryGridItem copy(@NotNull CategoryViewHolderData categoryViewHolderData) {
            Intrinsics.checkNotNullParameter(categoryViewHolderData, "item");
            return new CategoryGridItem(categoryViewHolderData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CategoryGridItem) && Intrinsics.areEqual((Object) this.item, (Object) ((CategoryGridItem) obj).item);
        }

        @NotNull
        public final CategoryViewHolderData getItem() {
            return this.item;
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        @NotNull
        public String toString() {
            CategoryViewHolderData categoryViewHolderData = this.item;
            return "CategoryGridItem(item=" + categoryViewHolderData + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$HeroBannerItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "item", "Lcom/talabat/darkstores/feature/home/BannerItemViewHolderData;", "(Lcom/talabat/darkstores/feature/home/BannerItemViewHolderData;)V", "getItem", "()Lcom/talabat/darkstores/feature/home/BannerItemViewHolderData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HeroBannerItem extends HomeRecyclerViewItem {
        @NotNull
        private final BannerItemViewHolderData item;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HeroBannerItem(@NotNull BannerItemViewHolderData bannerItemViewHolderData) {
            super(bannerItemViewHolderData.getItemPriority(), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bannerItemViewHolderData, "item");
            this.item = bannerItemViewHolderData;
        }

        public static /* synthetic */ HeroBannerItem copy$default(HeroBannerItem heroBannerItem, BannerItemViewHolderData bannerItemViewHolderData, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bannerItemViewHolderData = heroBannerItem.item;
            }
            return heroBannerItem.copy(bannerItemViewHolderData);
        }

        @NotNull
        public final BannerItemViewHolderData component1() {
            return this.item;
        }

        @NotNull
        public final HeroBannerItem copy(@NotNull BannerItemViewHolderData bannerItemViewHolderData) {
            Intrinsics.checkNotNullParameter(bannerItemViewHolderData, "item");
            return new HeroBannerItem(bannerItemViewHolderData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HeroBannerItem) && Intrinsics.areEqual((Object) this.item, (Object) ((HeroBannerItem) obj).item);
        }

        @NotNull
        public final BannerItemViewHolderData getItem() {
            return this.item;
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        @NotNull
        public String toString() {
            BannerItemViewHolderData bannerItemViewHolderData = this.item;
            return "HeroBannerItem(item=" + bannerItemViewHolderData + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$LifeStyleMissionV1Item;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "item", "Lcom/talabat/darkstores/feature/home/MissionItemData;", "(Lcom/talabat/darkstores/feature/home/MissionItemData;)V", "getItem", "()Lcom/talabat/darkstores/feature/home/MissionItemData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LifeStyleMissionV1Item extends HomeRecyclerViewItem {
        @NotNull
        private final MissionItemData item;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LifeStyleMissionV1Item(@NotNull MissionItemData missionItemData) {
            super(8, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(missionItemData, "item");
            this.item = missionItemData;
        }

        public static /* synthetic */ LifeStyleMissionV1Item copy$default(LifeStyleMissionV1Item lifeStyleMissionV1Item, MissionItemData missionItemData, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                missionItemData = lifeStyleMissionV1Item.item;
            }
            return lifeStyleMissionV1Item.copy(missionItemData);
        }

        @NotNull
        public final MissionItemData component1() {
            return this.item;
        }

        @NotNull
        public final LifeStyleMissionV1Item copy(@NotNull MissionItemData missionItemData) {
            Intrinsics.checkNotNullParameter(missionItemData, "item");
            return new LifeStyleMissionV1Item(missionItemData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LifeStyleMissionV1Item) && Intrinsics.areEqual((Object) this.item, (Object) ((LifeStyleMissionV1Item) obj).item);
        }

        @NotNull
        public final MissionItemData getItem() {
            return this.item;
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        @NotNull
        public String toString() {
            MissionItemData missionItemData = this.item;
            return "LifeStyleMissionV1Item(item=" + missionItemData + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$LifestyleMissionV2Item;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "item", "Lcom/talabat/darkstores/feature/home/LifestyleMissionV2Data;", "(Lcom/talabat/darkstores/feature/home/LifestyleMissionV2Data;)V", "getItem", "()Lcom/talabat/darkstores/feature/home/LifestyleMissionV2Data;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class LifestyleMissionV2Item extends HomeRecyclerViewItem {
        @NotNull
        private final LifestyleMissionV2Data item;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LifestyleMissionV2Item(@NotNull LifestyleMissionV2Data lifestyleMissionV2Data) {
            super(9, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(lifestyleMissionV2Data, "item");
            this.item = lifestyleMissionV2Data;
        }

        public static /* synthetic */ LifestyleMissionV2Item copy$default(LifestyleMissionV2Item lifestyleMissionV2Item, LifestyleMissionV2Data lifestyleMissionV2Data, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                lifestyleMissionV2Data = lifestyleMissionV2Item.item;
            }
            return lifestyleMissionV2Item.copy(lifestyleMissionV2Data);
        }

        @NotNull
        public final LifestyleMissionV2Data component1() {
            return this.item;
        }

        @NotNull
        public final LifestyleMissionV2Item copy(@NotNull LifestyleMissionV2Data lifestyleMissionV2Data) {
            Intrinsics.checkNotNullParameter(lifestyleMissionV2Data, "item");
            return new LifestyleMissionV2Item(lifestyleMissionV2Data);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LifestyleMissionV2Item) && Intrinsics.areEqual((Object) this.item, (Object) ((LifestyleMissionV2Item) obj).item);
        }

        @NotNull
        public final LifestyleMissionV2Data getItem() {
            return this.item;
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        @NotNull
        public String toString() {
            LifestyleMissionV2Data lifestyleMissionV2Data = this.item;
            return "LifestyleMissionV2Item(item=" + lifestyleMissionV2Data + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$PrimaryMissionItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "item", "Lcom/talabat/darkstores/feature/home/MissionItemData;", "(Lcom/talabat/darkstores/feature/home/MissionItemData;)V", "getItem", "()Lcom/talabat/darkstores/feature/home/MissionItemData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PrimaryMissionItem extends HomeRecyclerViewItem {
        @NotNull
        private final MissionItemData item;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PrimaryMissionItem(@NotNull MissionItemData missionItemData) {
            super(7, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(missionItemData, "item");
            this.item = missionItemData;
        }

        public static /* synthetic */ PrimaryMissionItem copy$default(PrimaryMissionItem primaryMissionItem, MissionItemData missionItemData, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                missionItemData = primaryMissionItem.item;
            }
            return primaryMissionItem.copy(missionItemData);
        }

        @NotNull
        public final MissionItemData component1() {
            return this.item;
        }

        @NotNull
        public final PrimaryMissionItem copy(@NotNull MissionItemData missionItemData) {
            Intrinsics.checkNotNullParameter(missionItemData, "item");
            return new PrimaryMissionItem(missionItemData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PrimaryMissionItem) && Intrinsics.areEqual((Object) this.item, (Object) ((PrimaryMissionItem) obj).item);
        }

        @NotNull
        public final MissionItemData getItem() {
            return this.item;
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        @NotNull
        public String toString() {
            MissionItemData missionItemData = this.item;
            return "PrimaryMissionItem(item=" + missionItemData + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$ProgressViewItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ProgressViewItem extends HomeRecyclerViewItem {
        @NotNull
        public static final ProgressViewItem INSTANCE = new ProgressViewItem();

        private ProgressViewItem() {
            super(4, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$RewardsMissionItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "item", "Lcom/talabat/darkstores/feature/home/RewardsMissionItemData;", "(Lcom/talabat/darkstores/feature/home/RewardsMissionItemData;)V", "getItem", "()Lcom/talabat/darkstores/feature/home/RewardsMissionItemData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RewardsMissionItem extends HomeRecyclerViewItem {
        @NotNull
        private final RewardsMissionItemData item;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RewardsMissionItem(@NotNull RewardsMissionItemData rewardsMissionItemData) {
            super(6, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(rewardsMissionItemData, "item");
            this.item = rewardsMissionItemData;
        }

        public static /* synthetic */ RewardsMissionItem copy$default(RewardsMissionItem rewardsMissionItem, RewardsMissionItemData rewardsMissionItemData, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                rewardsMissionItemData = rewardsMissionItem.item;
            }
            return rewardsMissionItem.copy(rewardsMissionItemData);
        }

        @NotNull
        public final RewardsMissionItemData component1() {
            return this.item;
        }

        @NotNull
        public final RewardsMissionItem copy(@NotNull RewardsMissionItemData rewardsMissionItemData) {
            Intrinsics.checkNotNullParameter(rewardsMissionItemData, "item");
            return new RewardsMissionItem(rewardsMissionItemData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RewardsMissionItem) && Intrinsics.areEqual((Object) this.item, (Object) ((RewardsMissionItem) obj).item);
        }

        @NotNull
        public final RewardsMissionItemData getItem() {
            return this.item;
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        @NotNull
        public String toString() {
            RewardsMissionItemData rewardsMissionItemData = this.item;
            return "RewardsMissionItem(item=" + rewardsMissionItemData + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$SearchViewItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "item", "Lcom/talabat/darkstores/feature/home/SearchViewHolderData;", "(Lcom/talabat/darkstores/feature/home/SearchViewHolderData;)V", "getItem", "()Lcom/talabat/darkstores/feature/home/SearchViewHolderData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SearchViewItem extends HomeRecyclerViewItem {
        @NotNull
        private final SearchViewHolderData item;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SearchViewItem(@NotNull SearchViewHolderData searchViewHolderData) {
            super(1, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(searchViewHolderData, "item");
            this.item = searchViewHolderData;
        }

        public static /* synthetic */ SearchViewItem copy$default(SearchViewItem searchViewItem, SearchViewHolderData searchViewHolderData, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                searchViewHolderData = searchViewItem.item;
            }
            return searchViewItem.copy(searchViewHolderData);
        }

        @NotNull
        public final SearchViewHolderData component1() {
            return this.item;
        }

        @NotNull
        public final SearchViewItem copy(@NotNull SearchViewHolderData searchViewHolderData) {
            Intrinsics.checkNotNullParameter(searchViewHolderData, "item");
            return new SearchViewItem(searchViewHolderData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SearchViewItem) && Intrinsics.areEqual((Object) this.item, (Object) ((SearchViewItem) obj).item);
        }

        @NotNull
        public final SearchViewHolderData getItem() {
            return this.item;
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        @NotNull
        public String toString() {
            SearchViewHolderData searchViewHolderData = this.item;
            return "SearchViewItem(item=" + searchViewHolderData + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$SmallBannerItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "item", "Lcom/talabat/darkstores/feature/home/BannerItemViewHolderData;", "(Lcom/talabat/darkstores/feature/home/BannerItemViewHolderData;)V", "getItem", "()Lcom/talabat/darkstores/feature/home/BannerItemViewHolderData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SmallBannerItem extends HomeRecyclerViewItem {
        @NotNull
        private final BannerItemViewHolderData item;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SmallBannerItem(@NotNull BannerItemViewHolderData bannerItemViewHolderData) {
            super(bannerItemViewHolderData.getItemPriority(), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bannerItemViewHolderData, "item");
            this.item = bannerItemViewHolderData;
        }

        public static /* synthetic */ SmallBannerItem copy$default(SmallBannerItem smallBannerItem, BannerItemViewHolderData bannerItemViewHolderData, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                bannerItemViewHolderData = smallBannerItem.item;
            }
            return smallBannerItem.copy(bannerItemViewHolderData);
        }

        @NotNull
        public final BannerItemViewHolderData component1() {
            return this.item;
        }

        @NotNull
        public final SmallBannerItem copy(@NotNull BannerItemViewHolderData bannerItemViewHolderData) {
            Intrinsics.checkNotNullParameter(bannerItemViewHolderData, "item");
            return new SmallBannerItem(bannerItemViewHolderData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SmallBannerItem) && Intrinsics.areEqual((Object) this.item, (Object) ((SmallBannerItem) obj).item);
        }

        @NotNull
        public final BannerItemViewHolderData getItem() {
            return this.item;
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        @NotNull
        public String toString() {
            BannerItemViewHolderData bannerItemViewHolderData = this.item;
            return "SmallBannerItem(item=" + bannerItemViewHolderData + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$SwimlaneItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "item", "Lcom/talabat/darkstores/feature/home/SwimlaneViewHolderData;", "(Lcom/talabat/darkstores/feature/home/SwimlaneViewHolderData;)V", "getItem", "()Lcom/talabat/darkstores/feature/home/SwimlaneViewHolderData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SwimlaneItem extends HomeRecyclerViewItem {
        @NotNull
        private final SwimlaneViewHolderData item;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SwimlaneItem(@NotNull SwimlaneViewHolderData swimlaneViewHolderData) {
            super(12, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(swimlaneViewHolderData, "item");
            this.item = swimlaneViewHolderData;
        }

        public static /* synthetic */ SwimlaneItem copy$default(SwimlaneItem swimlaneItem, SwimlaneViewHolderData swimlaneViewHolderData, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                swimlaneViewHolderData = swimlaneItem.item;
            }
            return swimlaneItem.copy(swimlaneViewHolderData);
        }

        @NotNull
        public final SwimlaneViewHolderData component1() {
            return this.item;
        }

        @NotNull
        public final SwimlaneItem copy(@NotNull SwimlaneViewHolderData swimlaneViewHolderData) {
            Intrinsics.checkNotNullParameter(swimlaneViewHolderData, "item");
            return new SwimlaneItem(swimlaneViewHolderData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SwimlaneItem) && Intrinsics.areEqual((Object) this.item, (Object) ((SwimlaneItem) obj).item);
        }

        @NotNull
        public final SwimlaneViewHolderData getItem() {
            return this.item;
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        @NotNull
        public String toString() {
            SwimlaneViewHolderData swimlaneViewHolderData = this.item;
            return "SwimlaneItem(item=" + swimlaneViewHolderData + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$TproSubscriptionItem;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "item", "Lcom/talabat/darkstores/feature/home/TproSubscriptionInfoData;", "(Lcom/talabat/darkstores/feature/home/TproSubscriptionInfoData;)V", "getItem", "()Lcom/talabat/darkstores/feature/home/TproSubscriptionInfoData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TproSubscriptionItem extends HomeRecyclerViewItem {
        @NotNull
        private final TproSubscriptionInfoData item;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TproSubscriptionItem(@NotNull TproSubscriptionInfoData tproSubscriptionInfoData) {
            super(2, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(tproSubscriptionInfoData, "item");
            this.item = tproSubscriptionInfoData;
        }

        public static /* synthetic */ TproSubscriptionItem copy$default(TproSubscriptionItem tproSubscriptionItem, TproSubscriptionInfoData tproSubscriptionInfoData, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                tproSubscriptionInfoData = tproSubscriptionItem.item;
            }
            return tproSubscriptionItem.copy(tproSubscriptionInfoData);
        }

        @NotNull
        public final TproSubscriptionInfoData component1() {
            return this.item;
        }

        @NotNull
        public final TproSubscriptionItem copy(@NotNull TproSubscriptionInfoData tproSubscriptionInfoData) {
            Intrinsics.checkNotNullParameter(tproSubscriptionInfoData, "item");
            return new TproSubscriptionItem(tproSubscriptionInfoData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TproSubscriptionItem) && Intrinsics.areEqual((Object) this.item, (Object) ((TproSubscriptionItem) obj).item);
        }

        @NotNull
        public final TproSubscriptionInfoData getItem() {
            return this.item;
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        @NotNull
        public String toString() {
            TproSubscriptionInfoData tproSubscriptionInfoData = this.item;
            return "TproSubscriptionItem(item=" + tproSubscriptionInfoData + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem$TproSubscriptionItemV2;", "Lcom/talabat/darkstores/feature/home/HomeRecyclerViewItem;", "item", "Lcom/talabat/darkstores/feature/home/TproSubscriptionInfoData;", "(Lcom/talabat/darkstores/feature/home/TproSubscriptionInfoData;)V", "getItem", "()Lcom/talabat/darkstores/feature/home/TproSubscriptionInfoData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TproSubscriptionItemV2 extends HomeRecyclerViewItem {
        @NotNull
        private final TproSubscriptionInfoData item;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TproSubscriptionItemV2(@NotNull TproSubscriptionInfoData tproSubscriptionInfoData) {
            super(0, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(tproSubscriptionInfoData, "item");
            this.item = tproSubscriptionInfoData;
        }

        public static /* synthetic */ TproSubscriptionItemV2 copy$default(TproSubscriptionItemV2 tproSubscriptionItemV2, TproSubscriptionInfoData tproSubscriptionInfoData, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                tproSubscriptionInfoData = tproSubscriptionItemV2.item;
            }
            return tproSubscriptionItemV2.copy(tproSubscriptionInfoData);
        }

        @NotNull
        public final TproSubscriptionInfoData component1() {
            return this.item;
        }

        @NotNull
        public final TproSubscriptionItemV2 copy(@NotNull TproSubscriptionInfoData tproSubscriptionInfoData) {
            Intrinsics.checkNotNullParameter(tproSubscriptionInfoData, "item");
            return new TproSubscriptionItemV2(tproSubscriptionInfoData);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TproSubscriptionItemV2) && Intrinsics.areEqual((Object) this.item, (Object) ((TproSubscriptionItemV2) obj).item);
        }

        @NotNull
        public final TproSubscriptionInfoData getItem() {
            return this.item;
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        @NotNull
        public String toString() {
            TproSubscriptionInfoData tproSubscriptionInfoData = this.item;
            return "TproSubscriptionItemV2(item=" + tproSubscriptionInfoData + ")";
        }
    }

    private HomeRecyclerViewItem(int i11) {
        this.priority = i11;
    }

    public /* synthetic */ HomeRecyclerViewItem(int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11);
    }

    public final int getPriority() {
        return this.priority;
    }
}
