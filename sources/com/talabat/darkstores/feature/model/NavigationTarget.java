package com.talabat.darkstores.feature.model;

import com.talabat.feature.darkstores.domain.model.DarkstoreNavigationType;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/feature/model/NavigationTarget;", "", "()V", "Companion", "Deferred", "Immediate", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred;", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Immediate;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class NavigationTarget {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\bH\u0000¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/darkstores/feature/model/NavigationTarget$Companion;", "", "()V", "create", "Lcom/talabat/darkstores/feature/model/NavigationTarget;", "deeplinkType", "", "deeplinkInfo", "", "deeplinkUri", "screenTitle", "eventOrigin", "searchTerm", "create$com_talabat_NewArchi_darkstores_darkstores", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DarkstoreNavigationType.values().length];
                iArr[DarkstoreNavigationType.PRODUCT.ordinal()] = 1;
                iArr[DarkstoreNavigationType.CAMPAIGN.ordinal()] = 2;
                iArr[DarkstoreNavigationType.CATEGORY.ordinal()] = 3;
                iArr[DarkstoreNavigationType.PRODUCT_SKU.ordinal()] = 4;
                iArr[DarkstoreNavigationType.CART.ordinal()] = 5;
                iArr[DarkstoreNavigationType.CART_LEGACY.ordinal()] = 6;
                iArr[DarkstoreNavigationType.LIFESTYLE_MISSION_V2_LEGACY.ordinal()] = 7;
                iArr[DarkstoreNavigationType.LIFESTYLE_MISSION.ordinal()] = 8;
                iArr[DarkstoreNavigationType.PRIMARY_MISSION.ordinal()] = 9;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ NavigationTarget create$com_talabat_NewArchi_darkstores_darkstores$default(Companion companion, int i11, String str, String str2, String str3, String str4, String str5, int i12, Object obj) {
            String str6;
            String str7;
            String str8;
            String str9;
            if ((i12 & 4) != 0) {
                str6 = "";
            } else {
                str6 = str2;
            }
            if ((i12 & 8) != 0) {
                str7 = "";
            } else {
                str7 = str3;
            }
            if ((i12 & 16) != 0) {
                str8 = "";
            } else {
                str8 = str4;
            }
            if ((i12 & 32) != 0) {
                str9 = "";
            } else {
                str9 = str5;
            }
            return companion.create$com_talabat_NewArchi_darkstores_darkstores(i11, str, str6, str7, str8, str9);
        }

        @Nullable
        public final NavigationTarget create$com_talabat_NewArchi_darkstores_darkstores(int i11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5) {
            Intrinsics.checkNotNullParameter(str, "deeplinkInfo");
            Intrinsics.checkNotNullParameter(str2, "deeplinkUri");
            Intrinsics.checkNotNullParameter(str3, "screenTitle");
            Intrinsics.checkNotNullParameter(str4, "eventOrigin");
            Intrinsics.checkNotNullParameter(str5, "searchTerm");
            switch (WhenMappings.$EnumSwitchMapping$0[DarkstoreNavigationType.Companion.fromInt(i11).ordinal()]) {
                case 1:
                    return new Deferred.Product(str, str4, str5);
                case 2:
                    return new Deferred.Campaign(str);
                case 3:
                    return new Deferred.Category(str, str4);
                case 4:
                    return new Deferred.ProductBySku(str, str2, str4);
                case 5:
                case 6:
                    return Deferred.Cart.INSTANCE;
                case 7:
                case 8:
                    return new Deferred.LifeStyleMission(str, str3, str4);
                case 9:
                    return new Immediate.PrimaryMission(str, str3, str4);
                default:
                    return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred;", "Lcom/talabat/darkstores/feature/model/NavigationTarget;", "()V", "Campaign", "Cart", "Category", "LifeStyleMission", "Product", "ProductBySku", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred$Product;", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred$Campaign;", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred$Category;", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred$ProductBySku;", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred$LifeStyleMission;", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred$Cart;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Deferred extends NavigationTarget {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred$Campaign;", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred;", "campaignId", "", "(Ljava/lang/String;)V", "getCampaignId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Campaign extends Deferred {
            @NotNull
            private final String campaignId;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Campaign(@NotNull String str) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "campaignId");
                this.campaignId = str;
            }

            public static /* synthetic */ Campaign copy$default(Campaign campaign, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = campaign.campaignId;
                }
                return campaign.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.campaignId;
            }

            @NotNull
            public final Campaign copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "campaignId");
                return new Campaign(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Campaign) && Intrinsics.areEqual((Object) this.campaignId, (Object) ((Campaign) obj).campaignId);
            }

            @NotNull
            public final String getCampaignId() {
                return this.campaignId;
            }

            public int hashCode() {
                return this.campaignId.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.campaignId;
                return "Campaign(campaignId=" + str + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred$Cart;", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Cart extends Deferred {
            @NotNull
            public static final Cart INSTANCE = new Cart();

            private Cart() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred$Category;", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred;", "categoryId", "", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;)V", "getCategoryId", "()Ljava/lang/String;", "getEventOrigin", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Category extends Deferred {
            @NotNull
            private final String categoryId;
            @NotNull
            private final String eventOrigin;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Category(@NotNull String str, @NotNull String str2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "categoryId");
                Intrinsics.checkNotNullParameter(str2, "eventOrigin");
                this.categoryId = str;
                this.eventOrigin = str2;
            }

            public static /* synthetic */ Category copy$default(Category category, String str, String str2, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = category.categoryId;
                }
                if ((i11 & 2) != 0) {
                    str2 = category.eventOrigin;
                }
                return category.copy(str, str2);
            }

            @NotNull
            public final String component1() {
                return this.categoryId;
            }

            @NotNull
            public final String component2() {
                return this.eventOrigin;
            }

            @NotNull
            public final Category copy(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, "categoryId");
                Intrinsics.checkNotNullParameter(str2, "eventOrigin");
                return new Category(str, str2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Category)) {
                    return false;
                }
                Category category = (Category) obj;
                return Intrinsics.areEqual((Object) this.categoryId, (Object) category.categoryId) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) category.eventOrigin);
            }

            @NotNull
            public final String getCategoryId() {
                return this.categoryId;
            }

            @NotNull
            public final String getEventOrigin() {
                return this.eventOrigin;
            }

            public int hashCode() {
                return (this.categoryId.hashCode() * 31) + this.eventOrigin.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.categoryId;
                String str2 = this.eventOrigin;
                return "Category(categoryId=" + str + ", eventOrigin=" + str2 + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred$LifeStyleMission;", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred;", "code", "", "name", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getEventOrigin", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class LifeStyleMission extends Deferred {
            @NotNull
            private final String code;
            @NotNull
            private final String eventOrigin;
            @NotNull

            /* renamed from: name  reason: collision with root package name */
            private final String f56469name;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public LifeStyleMission(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
                Intrinsics.checkNotNullParameter(str2, "name");
                Intrinsics.checkNotNullParameter(str3, "eventOrigin");
                this.code = str;
                this.f56469name = str2;
                this.eventOrigin = str3;
            }

            public static /* synthetic */ LifeStyleMission copy$default(LifeStyleMission lifeStyleMission, String str, String str2, String str3, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = lifeStyleMission.code;
                }
                if ((i11 & 2) != 0) {
                    str2 = lifeStyleMission.f56469name;
                }
                if ((i11 & 4) != 0) {
                    str3 = lifeStyleMission.eventOrigin;
                }
                return lifeStyleMission.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.code;
            }

            @NotNull
            public final String component2() {
                return this.f56469name;
            }

            @NotNull
            public final String component3() {
                return this.eventOrigin;
            }

            @NotNull
            public final LifeStyleMission copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
                Intrinsics.checkNotNullParameter(str2, "name");
                Intrinsics.checkNotNullParameter(str3, "eventOrigin");
                return new LifeStyleMission(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof LifeStyleMission)) {
                    return false;
                }
                LifeStyleMission lifeStyleMission = (LifeStyleMission) obj;
                return Intrinsics.areEqual((Object) this.code, (Object) lifeStyleMission.code) && Intrinsics.areEqual((Object) this.f56469name, (Object) lifeStyleMission.f56469name) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) lifeStyleMission.eventOrigin);
            }

            @NotNull
            public final String getCode() {
                return this.code;
            }

            @NotNull
            public final String getEventOrigin() {
                return this.eventOrigin;
            }

            @NotNull
            public final String getName() {
                return this.f56469name;
            }

            public int hashCode() {
                return (((this.code.hashCode() * 31) + this.f56469name.hashCode()) * 31) + this.eventOrigin.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.code;
                String str2 = this.f56469name;
                String str3 = this.eventOrigin;
                return "LifeStyleMission(code=" + str + ", name=" + str2 + ", eventOrigin=" + str3 + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred$Product;", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred;", "productId", "", "eventOrigin", "searchTerm", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEventOrigin", "()Ljava/lang/String;", "getProductId", "getSearchTerm", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Product extends Deferred {
            @NotNull
            private final String eventOrigin;
            @NotNull
            private final String productId;
            @NotNull
            private final String searchTerm;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Product(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "productId");
                Intrinsics.checkNotNullParameter(str2, "eventOrigin");
                Intrinsics.checkNotNullParameter(str3, "searchTerm");
                this.productId = str;
                this.eventOrigin = str2;
                this.searchTerm = str3;
            }

            public static /* synthetic */ Product copy$default(Product product, String str, String str2, String str3, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = product.productId;
                }
                if ((i11 & 2) != 0) {
                    str2 = product.eventOrigin;
                }
                if ((i11 & 4) != 0) {
                    str3 = product.searchTerm;
                }
                return product.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.productId;
            }

            @NotNull
            public final String component2() {
                return this.eventOrigin;
            }

            @NotNull
            public final String component3() {
                return this.searchTerm;
            }

            @NotNull
            public final Product copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "productId");
                Intrinsics.checkNotNullParameter(str2, "eventOrigin");
                Intrinsics.checkNotNullParameter(str3, "searchTerm");
                return new Product(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Product)) {
                    return false;
                }
                Product product = (Product) obj;
                return Intrinsics.areEqual((Object) this.productId, (Object) product.productId) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) product.eventOrigin) && Intrinsics.areEqual((Object) this.searchTerm, (Object) product.searchTerm);
            }

            @NotNull
            public final String getEventOrigin() {
                return this.eventOrigin;
            }

            @NotNull
            public final String getProductId() {
                return this.productId;
            }

            @NotNull
            public final String getSearchTerm() {
                return this.searchTerm;
            }

            public int hashCode() {
                return (((this.productId.hashCode() * 31) + this.eventOrigin.hashCode()) * 31) + this.searchTerm.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.productId;
                String str2 = this.eventOrigin;
                String str3 = this.searchTerm;
                return "Product(productId=" + str + ", eventOrigin=" + str2 + ", searchTerm=" + str3 + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred$ProductBySku;", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Deferred;", "productSku", "", "deeplinkUri", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeeplinkUri", "()Ljava/lang/String;", "getEventOrigin", "getProductSku", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class ProductBySku extends Deferred {
            @NotNull
            private final String deeplinkUri;
            @NotNull
            private final String eventOrigin;
            @NotNull
            private final String productSku;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ProductBySku(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "productSku");
                Intrinsics.checkNotNullParameter(str2, "deeplinkUri");
                Intrinsics.checkNotNullParameter(str3, "eventOrigin");
                this.productSku = str;
                this.deeplinkUri = str2;
                this.eventOrigin = str3;
            }

            public static /* synthetic */ ProductBySku copy$default(ProductBySku productBySku, String str, String str2, String str3, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = productBySku.productSku;
                }
                if ((i11 & 2) != 0) {
                    str2 = productBySku.deeplinkUri;
                }
                if ((i11 & 4) != 0) {
                    str3 = productBySku.eventOrigin;
                }
                return productBySku.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.productSku;
            }

            @NotNull
            public final String component2() {
                return this.deeplinkUri;
            }

            @NotNull
            public final String component3() {
                return this.eventOrigin;
            }

            @NotNull
            public final ProductBySku copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "productSku");
                Intrinsics.checkNotNullParameter(str2, "deeplinkUri");
                Intrinsics.checkNotNullParameter(str3, "eventOrigin");
                return new ProductBySku(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ProductBySku)) {
                    return false;
                }
                ProductBySku productBySku = (ProductBySku) obj;
                return Intrinsics.areEqual((Object) this.productSku, (Object) productBySku.productSku) && Intrinsics.areEqual((Object) this.deeplinkUri, (Object) productBySku.deeplinkUri) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) productBySku.eventOrigin);
            }

            @NotNull
            public final String getDeeplinkUri() {
                return this.deeplinkUri;
            }

            @NotNull
            public final String getEventOrigin() {
                return this.eventOrigin;
            }

            @NotNull
            public final String getProductSku() {
                return this.productSku;
            }

            public int hashCode() {
                return (((this.productSku.hashCode() * 31) + this.deeplinkUri.hashCode()) * 31) + this.eventOrigin.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.productSku;
                String str2 = this.deeplinkUri;
                String str3 = this.eventOrigin;
                return "ProductBySku(productSku=" + str + ", deeplinkUri=" + str2 + ", eventOrigin=" + str3 + ")";
            }
        }

        private Deferred() {
            super((DefaultConstructorMarker) null);
        }

        public /* synthetic */ Deferred(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/feature/model/NavigationTarget$Immediate;", "Lcom/talabat/darkstores/feature/model/NavigationTarget;", "()V", "PrimaryMission", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Immediate$PrimaryMission;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class Immediate extends NavigationTarget {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/feature/model/NavigationTarget$Immediate$PrimaryMission;", "Lcom/talabat/darkstores/feature/model/NavigationTarget$Immediate;", "swimlaneId", "", "name", "eventOrigin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEventOrigin", "()Ljava/lang/String;", "getName", "getSwimlaneId", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class PrimaryMission extends Immediate {
            @NotNull
            private final String eventOrigin;
            @NotNull

            /* renamed from: name  reason: collision with root package name */
            private final String f56470name;
            @NotNull
            private final String swimlaneId;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public PrimaryMission(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "swimlaneId");
                Intrinsics.checkNotNullParameter(str2, "name");
                Intrinsics.checkNotNullParameter(str3, "eventOrigin");
                this.swimlaneId = str;
                this.f56470name = str2;
                this.eventOrigin = str3;
            }

            public static /* synthetic */ PrimaryMission copy$default(PrimaryMission primaryMission, String str, String str2, String str3, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = primaryMission.swimlaneId;
                }
                if ((i11 & 2) != 0) {
                    str2 = primaryMission.f56470name;
                }
                if ((i11 & 4) != 0) {
                    str3 = primaryMission.eventOrigin;
                }
                return primaryMission.copy(str, str2, str3);
            }

            @NotNull
            public final String component1() {
                return this.swimlaneId;
            }

            @NotNull
            public final String component2() {
                return this.f56470name;
            }

            @NotNull
            public final String component3() {
                return this.eventOrigin;
            }

            @NotNull
            public final PrimaryMission copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(str, "swimlaneId");
                Intrinsics.checkNotNullParameter(str2, "name");
                Intrinsics.checkNotNullParameter(str3, "eventOrigin");
                return new PrimaryMission(str, str2, str3);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof PrimaryMission)) {
                    return false;
                }
                PrimaryMission primaryMission = (PrimaryMission) obj;
                return Intrinsics.areEqual((Object) this.swimlaneId, (Object) primaryMission.swimlaneId) && Intrinsics.areEqual((Object) this.f56470name, (Object) primaryMission.f56470name) && Intrinsics.areEqual((Object) this.eventOrigin, (Object) primaryMission.eventOrigin);
            }

            @NotNull
            public final String getEventOrigin() {
                return this.eventOrigin;
            }

            @NotNull
            public final String getName() {
                return this.f56470name;
            }

            @NotNull
            public final String getSwimlaneId() {
                return this.swimlaneId;
            }

            public int hashCode() {
                return (((this.swimlaneId.hashCode() * 31) + this.f56470name.hashCode()) * 31) + this.eventOrigin.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.swimlaneId;
                String str2 = this.f56470name;
                String str3 = this.eventOrigin;
                return "PrimaryMission(swimlaneId=" + str + ", name=" + str2 + ", eventOrigin=" + str3 + ")";
            }
        }

        private Immediate() {
            super((DefaultConstructorMarker) null);
        }

        public /* synthetic */ Immediate(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private NavigationTarget() {
    }

    public /* synthetic */ NavigationTarget(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
