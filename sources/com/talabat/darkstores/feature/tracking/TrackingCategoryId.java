package com.talabat.darkstores.feature.tracking;

import com.talabat.darkstores.feature.tracking.data.DarkstoresTrackingConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\f\r\u000e\u000f\u0010B\t\b\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\u0001\u0005\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "", "", "b", "()Ljava/lang/String;", "trackingKey", "a", "additionalInfo", "getTrackingName", "trackingName", "<init>", "()V", "Banner", "Category", "CustomCategory", "CustomSwimlane", "Swimlane", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId$Swimlane;", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId$CustomSwimlane;", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId$Category;", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId$CustomCategory;", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId$Banner;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
public abstract class TrackingCategoryId {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0005\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003R\u001a\u0010\u0003\u001a\u00020\u00028\u0014X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00028\u0014XD¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId$Banner;", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "", "additionalInfo", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "trackingKey", "b", "<init>", "(Ljava/lang/String;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
    public static final class Banner extends TrackingCategoryId {
        @NotNull
        private final String additionalInfo;
        @NotNull
        private final String trackingKey = "banner";

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Banner(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "additionalInfo");
            this.additionalInfo = str;
        }

        public static /* synthetic */ Banner copy$default(Banner banner, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = banner.a();
            }
            return banner.copy(str);
        }

        @NotNull
        public String a() {
            return this.additionalInfo;
        }

        @NotNull
        public String b() {
            return this.trackingKey;
        }

        @NotNull
        public final Banner copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "additionalInfo");
            return new Banner(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Banner) && Intrinsics.areEqual((Object) a(), (Object) ((Banner) obj).a());
        }

        public int hashCode() {
            return a().hashCode();
        }

        @NotNull
        public String toString() {
            String a11 = a();
            return "Banner(additionalInfo=" + a11 + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0005\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003R\u001a\u0010\u0003\u001a\u00020\u00028\u0014X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00028\u0014XD¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId$Category;", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "", "additionalInfo", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "trackingKey", "b", "<init>", "(Ljava/lang/String;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
    public static final class Category extends TrackingCategoryId {
        @NotNull
        private final String additionalInfo;
        @NotNull
        private final String trackingKey = "category";

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Category(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "additionalInfo");
            this.additionalInfo = str;
        }

        public static /* synthetic */ Category copy$default(Category category, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = category.a();
            }
            return category.copy(str);
        }

        @NotNull
        public String a() {
            return this.additionalInfo;
        }

        @NotNull
        public String b() {
            return this.trackingKey;
        }

        @NotNull
        public final Category copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "additionalInfo");
            return new Category(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Category) && Intrinsics.areEqual((Object) a(), (Object) ((Category) obj).a());
        }

        public int hashCode() {
            return a().hashCode();
        }

        @NotNull
        public String toString() {
            String a11 = a();
            return "Category(additionalInfo=" + a11 + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0005\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003R\u001a\u0010\u0003\u001a\u00020\u00028\u0014X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00028\u0014XD¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId$CustomCategory;", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "", "additionalInfo", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "trackingKey", "b", "<init>", "(Ljava/lang/String;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
    public static final class CustomCategory extends TrackingCategoryId {
        @NotNull
        private final String additionalInfo;
        @NotNull
        private final String trackingKey = "custom_category";

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CustomCategory(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "additionalInfo");
            this.additionalInfo = str;
        }

        public static /* synthetic */ CustomCategory copy$default(CustomCategory customCategory, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = customCategory.a();
            }
            return customCategory.copy(str);
        }

        @NotNull
        public String a() {
            return this.additionalInfo;
        }

        @NotNull
        public String b() {
            return this.trackingKey;
        }

        @NotNull
        public final CustomCategory copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "additionalInfo");
            return new CustomCategory(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomCategory) && Intrinsics.areEqual((Object) a(), (Object) ((CustomCategory) obj).a());
        }

        public int hashCode() {
            return a().hashCode();
        }

        @NotNull
        public String toString() {
            String a11 = a();
            return "CustomCategory(additionalInfo=" + a11 + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0005\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003R\u001a\u0010\u0003\u001a\u00020\u00028\u0014X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00028\u0014XD¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId$CustomSwimlane;", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "", "additionalInfo", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "trackingKey", "b", "<init>", "(Ljava/lang/String;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
    public static final class CustomSwimlane extends TrackingCategoryId {
        @NotNull
        private final String additionalInfo;
        @NotNull
        private final String trackingKey = DarkstoresTrackingConstantsKt.ORIGIN_TYPE_CUSTOM_SWIMLANE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CustomSwimlane(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "additionalInfo");
            this.additionalInfo = str;
        }

        public static /* synthetic */ CustomSwimlane copy$default(CustomSwimlane customSwimlane, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = customSwimlane.a();
            }
            return customSwimlane.copy(str);
        }

        @NotNull
        public String a() {
            return this.additionalInfo;
        }

        @NotNull
        public String b() {
            return this.trackingKey;
        }

        @NotNull
        public final CustomSwimlane copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "additionalInfo");
            return new CustomSwimlane(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomSwimlane) && Intrinsics.areEqual((Object) a(), (Object) ((CustomSwimlane) obj).a());
        }

        public int hashCode() {
            return a().hashCode();
        }

        @NotNull
        public String toString() {
            String a11 = a();
            return "CustomSwimlane(additionalInfo=" + a11 + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\t\u0010\u0005\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0007\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003R\u001a\u0010\u0003\u001a\u00020\u00028\u0014X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00028\u0014XD¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId$Swimlane;", "Lcom/talabat/darkstores/feature/tracking/TrackingCategoryId;", "", "additionalInfo", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "trackingKey", "b", "<init>", "(Ljava/lang/String;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0})
    public static final class Swimlane extends TrackingCategoryId {
        @NotNull
        private final String additionalInfo;
        @NotNull
        private final String trackingKey = "swimlane";

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Swimlane(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "additionalInfo");
            this.additionalInfo = str;
        }

        public static /* synthetic */ Swimlane copy$default(Swimlane swimlane, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = swimlane.a();
            }
            return swimlane.copy(str);
        }

        @NotNull
        public String a() {
            return this.additionalInfo;
        }

        @NotNull
        public String b() {
            return this.trackingKey;
        }

        @NotNull
        public final Swimlane copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "additionalInfo");
            return new Swimlane(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Swimlane) && Intrinsics.areEqual((Object) a(), (Object) ((Swimlane) obj).a());
        }

        public int hashCode() {
            return a().hashCode();
        }

        @NotNull
        public String toString() {
            String a11 = a();
            return "Swimlane(additionalInfo=" + a11 + ")";
        }
    }

    private TrackingCategoryId() {
    }

    public /* synthetic */ TrackingCategoryId(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract String a();

    @NotNull
    public abstract String b();

    @NotNull
    public final String getTrackingName() {
        String b11 = b();
        String a11 = a();
        return b11 + "," + a11;
    }
}
