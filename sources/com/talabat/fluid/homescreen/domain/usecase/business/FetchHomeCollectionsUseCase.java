package com.talabat.fluid.homescreen.domain.usecase.business;

import com.deliveryhero.fluid.widgets.collections.list.ListCell;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase;", "", "fetchHomeCollections", "Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "HomeCollectionResult", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FetchHomeCollectionsUseCase {

    @kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult;", "", "collectionData", "", "Lcom/deliveryhero/fluid/widgets/collections/list/ListCell;", "configuration", "Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult$Configuration;", "metadata", "Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult$Metadata;", "(Ljava/util/List;Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult$Configuration;Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult$Metadata;)V", "getCollectionData", "()Ljava/util/List;", "getConfiguration", "()Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult$Configuration;", "getMetadata", "()Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult$Metadata;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Configuration", "Metadata", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HomeCollectionResult {
        @NotNull
        private final List<ListCell> collectionData;
        @Nullable
        private final Configuration configuration;
        @Nullable
        private final Metadata metadata;

        @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult$Configuration;", "", "navigationBarColor", "", "locationHintColor", "locationTitleColor", "locationArrowTintColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLocationArrowTintColor", "()Ljava/lang/String;", "getLocationHintColor", "getLocationTitleColor", "getNavigationBarColor", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Configuration {
            @NotNull
            private final String locationArrowTintColor;
            @NotNull
            private final String locationHintColor;
            @NotNull
            private final String locationTitleColor;
            @NotNull
            private final String navigationBarColor;

            public Configuration(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
                Intrinsics.checkNotNullParameter(str, "navigationBarColor");
                Intrinsics.checkNotNullParameter(str2, "locationHintColor");
                Intrinsics.checkNotNullParameter(str3, "locationTitleColor");
                Intrinsics.checkNotNullParameter(str4, "locationArrowTintColor");
                this.navigationBarColor = str;
                this.locationHintColor = str2;
                this.locationTitleColor = str3;
                this.locationArrowTintColor = str4;
            }

            public static /* synthetic */ Configuration copy$default(Configuration configuration, String str, String str2, String str3, String str4, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = configuration.navigationBarColor;
                }
                if ((i11 & 2) != 0) {
                    str2 = configuration.locationHintColor;
                }
                if ((i11 & 4) != 0) {
                    str3 = configuration.locationTitleColor;
                }
                if ((i11 & 8) != 0) {
                    str4 = configuration.locationArrowTintColor;
                }
                return configuration.copy(str, str2, str3, str4);
            }

            @NotNull
            public final String component1() {
                return this.navigationBarColor;
            }

            @NotNull
            public final String component2() {
                return this.locationHintColor;
            }

            @NotNull
            public final String component3() {
                return this.locationTitleColor;
            }

            @NotNull
            public final String component4() {
                return this.locationArrowTintColor;
            }

            @NotNull
            public final Configuration copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
                Intrinsics.checkNotNullParameter(str, "navigationBarColor");
                Intrinsics.checkNotNullParameter(str2, "locationHintColor");
                Intrinsics.checkNotNullParameter(str3, "locationTitleColor");
                Intrinsics.checkNotNullParameter(str4, "locationArrowTintColor");
                return new Configuration(str, str2, str3, str4);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Configuration)) {
                    return false;
                }
                Configuration configuration = (Configuration) obj;
                return Intrinsics.areEqual((Object) this.navigationBarColor, (Object) configuration.navigationBarColor) && Intrinsics.areEqual((Object) this.locationHintColor, (Object) configuration.locationHintColor) && Intrinsics.areEqual((Object) this.locationTitleColor, (Object) configuration.locationTitleColor) && Intrinsics.areEqual((Object) this.locationArrowTintColor, (Object) configuration.locationArrowTintColor);
            }

            @NotNull
            public final String getLocationArrowTintColor() {
                return this.locationArrowTintColor;
            }

            @NotNull
            public final String getLocationHintColor() {
                return this.locationHintColor;
            }

            @NotNull
            public final String getLocationTitleColor() {
                return this.locationTitleColor;
            }

            @NotNull
            public final String getNavigationBarColor() {
                return this.navigationBarColor;
            }

            public int hashCode() {
                return (((((this.navigationBarColor.hashCode() * 31) + this.locationHintColor.hashCode()) * 31) + this.locationTitleColor.hashCode()) * 31) + this.locationArrowTintColor.hashCode();
            }

            @NotNull
            public String toString() {
                String str = this.navigationBarColor;
                String str2 = this.locationHintColor;
                String str3 = this.locationTitleColor;
                String str4 = this.locationArrowTintColor;
                return "Configuration(navigationBarColor=" + str + ", locationHintColor=" + str2 + ", locationTitleColor=" + str3 + ", locationArrowTintColor=" + str4 + ")";
            }
        }

        @kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/FetchHomeCollectionsUseCase$HomeCollectionResult$Metadata;", "", "clearVoucherCache", "", "(Z)V", "getClearVoucherCache", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Metadata {
            private final boolean clearVoucherCache;

            public Metadata(boolean z11) {
                this.clearVoucherCache = z11;
            }

            public static /* synthetic */ Metadata copy$default(Metadata metadata, boolean z11, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    z11 = metadata.clearVoucherCache;
                }
                return metadata.copy(z11);
            }

            public final boolean component1() {
                return this.clearVoucherCache;
            }

            @NotNull
            public final Metadata copy(boolean z11) {
                return new Metadata(z11);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Metadata) && this.clearVoucherCache == ((Metadata) obj).clearVoucherCache;
            }

            public final boolean getClearVoucherCache() {
                return this.clearVoucherCache;
            }

            public int hashCode() {
                boolean z11 = this.clearVoucherCache;
                if (z11) {
                    return 1;
                }
                return z11 ? 1 : 0;
            }

            @NotNull
            public String toString() {
                boolean z11 = this.clearVoucherCache;
                return "Metadata(clearVoucherCache=" + z11 + ")";
            }
        }

        public HomeCollectionResult(@NotNull List<ListCell> list, @Nullable Configuration configuration2, @Nullable Metadata metadata2) {
            Intrinsics.checkNotNullParameter(list, "collectionData");
            this.collectionData = list;
            this.configuration = configuration2;
            this.metadata = metadata2;
        }

        public static /* synthetic */ HomeCollectionResult copy$default(HomeCollectionResult homeCollectionResult, List<ListCell> list, Configuration configuration2, Metadata metadata2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = homeCollectionResult.collectionData;
            }
            if ((i11 & 2) != 0) {
                configuration2 = homeCollectionResult.configuration;
            }
            if ((i11 & 4) != 0) {
                metadata2 = homeCollectionResult.metadata;
            }
            return homeCollectionResult.copy(list, configuration2, metadata2);
        }

        @NotNull
        public final List<ListCell> component1() {
            return this.collectionData;
        }

        @Nullable
        public final Configuration component2() {
            return this.configuration;
        }

        @Nullable
        public final Metadata component3() {
            return this.metadata;
        }

        @NotNull
        public final HomeCollectionResult copy(@NotNull List<ListCell> list, @Nullable Configuration configuration2, @Nullable Metadata metadata2) {
            Intrinsics.checkNotNullParameter(list, "collectionData");
            return new HomeCollectionResult(list, configuration2, metadata2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof HomeCollectionResult)) {
                return false;
            }
            HomeCollectionResult homeCollectionResult = (HomeCollectionResult) obj;
            return Intrinsics.areEqual((Object) this.collectionData, (Object) homeCollectionResult.collectionData) && Intrinsics.areEqual((Object) this.configuration, (Object) homeCollectionResult.configuration) && Intrinsics.areEqual((Object) this.metadata, (Object) homeCollectionResult.metadata);
        }

        @NotNull
        public final List<ListCell> getCollectionData() {
            return this.collectionData;
        }

        @Nullable
        public final Configuration getConfiguration() {
            return this.configuration;
        }

        @Nullable
        public final Metadata getMetadata() {
            return this.metadata;
        }

        public int hashCode() {
            int hashCode = this.collectionData.hashCode() * 31;
            Configuration configuration2 = this.configuration;
            int i11 = 0;
            int hashCode2 = (hashCode + (configuration2 == null ? 0 : configuration2.hashCode())) * 31;
            Metadata metadata2 = this.metadata;
            if (metadata2 != null) {
                i11 = metadata2.hashCode();
            }
            return hashCode2 + i11;
        }

        @NotNull
        public String toString() {
            List<ListCell> list = this.collectionData;
            Configuration configuration2 = this.configuration;
            Metadata metadata2 = this.metadata;
            return "HomeCollectionResult(collectionData=" + list + ", configuration=" + configuration2 + ", metadata=" + metadata2 + ")";
        }
    }

    @Nullable
    Object fetchHomeCollections(@NotNull Continuation<? super HomeCollectionResult> continuation);
}
