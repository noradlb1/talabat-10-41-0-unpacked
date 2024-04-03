package com.talabat.core.deeplink.data;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "", "()V", "data", "", "", "getData", "()Ljava/util/Map;", "screenName", "getScreenName", "()Ljava/lang/String;", "AppLink", "DeepLink", "Lcom/talabat/core/deeplink/data/ParsedLinkModel$DeepLink;", "Lcom/talabat/core/deeplink/data/ParsedLinkModel$AppLink;", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ParsedLinkModel {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J?\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/talabat/core/deeplink/data/ParsedLinkModel$AppLink;", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "screenName", "", "data", "", "paths", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "getPaths", "getScreenName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AppLink extends ParsedLinkModel {
        @NotNull
        private final Map<String, String> data;
        @NotNull
        private final Map<Integer, String> paths;
        @NotNull
        private final String screenName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AppLink(@NotNull String str, @NotNull Map<String, String> map, @NotNull Map<Integer, String> map2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(map, "data");
            Intrinsics.checkNotNullParameter(map2, "paths");
            this.screenName = str;
            this.data = map;
            this.paths = map2;
        }

        public static /* synthetic */ AppLink copy$default(AppLink appLink, String str, Map<String, String> map, Map<Integer, String> map2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = appLink.getScreenName();
            }
            if ((i11 & 2) != 0) {
                map = appLink.getData();
            }
            if ((i11 & 4) != 0) {
                map2 = appLink.paths;
            }
            return appLink.copy(str, map, map2);
        }

        @NotNull
        public final String component1() {
            return getScreenName();
        }

        @NotNull
        public final Map<String, String> component2() {
            return getData();
        }

        @NotNull
        public final Map<Integer, String> component3() {
            return this.paths;
        }

        @NotNull
        public final AppLink copy(@NotNull String str, @NotNull Map<String, String> map, @NotNull Map<Integer, String> map2) {
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(map, "data");
            Intrinsics.checkNotNullParameter(map2, "paths");
            return new AppLink(str, map, map2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AppLink)) {
                return false;
            }
            AppLink appLink = (AppLink) obj;
            return Intrinsics.areEqual((Object) getScreenName(), (Object) appLink.getScreenName()) && Intrinsics.areEqual((Object) getData(), (Object) appLink.getData()) && Intrinsics.areEqual((Object) this.paths, (Object) appLink.paths);
        }

        @NotNull
        public Map<String, String> getData() {
            return this.data;
        }

        @NotNull
        public final Map<Integer, String> getPaths() {
            return this.paths;
        }

        @NotNull
        public String getScreenName() {
            return this.screenName;
        }

        public int hashCode() {
            return (((getScreenName().hashCode() * 31) + getData().hashCode()) * 31) + this.paths.hashCode();
        }

        @NotNull
        public String toString() {
            String screenName2 = getScreenName();
            Map<String, String> data2 = getData();
            Map<Integer, String> map = this.paths;
            return "AppLink(screenName=" + screenName2 + ", data=" + data2 + ", paths=" + map + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J)\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/deeplink/data/ParsedLinkModel$DeepLink;", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "screenName", "", "data", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "getScreenName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_core_deeplink_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DeepLink extends ParsedLinkModel {
        @NotNull
        private final Map<String, String> data;
        @NotNull
        private final String screenName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeepLink(@NotNull String str, @NotNull Map<String, String> map) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(map, "data");
            this.screenName = str;
            this.data = map;
        }

        public static /* synthetic */ DeepLink copy$default(DeepLink deepLink, String str, Map<String, String> map, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = deepLink.getScreenName();
            }
            if ((i11 & 2) != 0) {
                map = deepLink.getData();
            }
            return deepLink.copy(str, map);
        }

        @NotNull
        public final String component1() {
            return getScreenName();
        }

        @NotNull
        public final Map<String, String> component2() {
            return getData();
        }

        @NotNull
        public final DeepLink copy(@NotNull String str, @NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(map, "data");
            return new DeepLink(str, map);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DeepLink)) {
                return false;
            }
            DeepLink deepLink = (DeepLink) obj;
            return Intrinsics.areEqual((Object) getScreenName(), (Object) deepLink.getScreenName()) && Intrinsics.areEqual((Object) getData(), (Object) deepLink.getData());
        }

        @NotNull
        public Map<String, String> getData() {
            return this.data;
        }

        @NotNull
        public String getScreenName() {
            return this.screenName;
        }

        public int hashCode() {
            return (getScreenName().hashCode() * 31) + getData().hashCode();
        }

        @NotNull
        public String toString() {
            String screenName2 = getScreenName();
            Map<String, String> data2 = getData();
            return "DeepLink(screenName=" + screenName2 + ", data=" + data2 + ")";
        }
    }

    private ParsedLinkModel() {
    }

    public /* synthetic */ ParsedLinkModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract Map<String, String> getData();

    @NotNull
    public abstract String getScreenName();
}
