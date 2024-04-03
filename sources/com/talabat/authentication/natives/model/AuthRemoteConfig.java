package com.talabat.authentication.natives.model;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0015\u0012\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/authentication/natives/model/AuthRemoteConfig;", "", "variations", "", "Lcom/talabat/authentication/natives/model/AuthRemoteConfig$Variation;", "(Ljava/util/List;)V", "getVariations", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Variation", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AuthRemoteConfig {
    @SerializedName("variations")
    @NotNull
    private final List<Variation> variations;

    public AuthRemoteConfig() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public AuthRemoteConfig(@NotNull @Json(name = "variations") List<Variation> list) {
        Intrinsics.checkNotNullParameter(list, "variations");
        this.variations = list;
    }

    public static /* synthetic */ AuthRemoteConfig copy$default(AuthRemoteConfig authRemoteConfig, List<Variation> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = authRemoteConfig.variations;
        }
        return authRemoteConfig.copy(list);
    }

    @NotNull
    public final List<Variation> component1() {
        return this.variations;
    }

    @NotNull
    public final AuthRemoteConfig copy(@NotNull @Json(name = "variations") List<Variation> list) {
        Intrinsics.checkNotNullParameter(list, "variations");
        return new AuthRemoteConfig(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AuthRemoteConfig) && Intrinsics.areEqual((Object) this.variations, (Object) ((AuthRemoteConfig) obj).variations);
    }

    @NotNull
    public final List<Variation> getVariations() {
        return this.variations;
    }

    public int hashCode() {
        return this.variations.hashCode();
    }

    @NotNull
    public String toString() {
        List<Variation> list = this.variations;
        return "AuthRemoteConfig(variations=" + list + ")";
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J#\u0010\r\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/authentication/natives/model/AuthRemoteConfig$Variation;", "", "links", "", "", "name", "(Ljava/util/List;Ljava/lang/String;)V", "getLinks", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Variation {
        @SerializedName("links")
        @NotNull
        private final List<String> links;
        @SerializedName("variation_name")
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f55516name;

        public Variation(@NotNull @Json(name = "links") List<String> list, @NotNull @Json(name = "variation_name") String str) {
            Intrinsics.checkNotNullParameter(list, "links");
            Intrinsics.checkNotNullParameter(str, "name");
            this.links = list;
            this.f55516name = str;
        }

        public static /* synthetic */ Variation copy$default(Variation variation, List<String> list, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = variation.links;
            }
            if ((i11 & 2) != 0) {
                str = variation.f55516name;
            }
            return variation.copy(list, str);
        }

        @NotNull
        public final List<String> component1() {
            return this.links;
        }

        @NotNull
        public final String component2() {
            return this.f55516name;
        }

        @NotNull
        public final Variation copy(@NotNull @Json(name = "links") List<String> list, @NotNull @Json(name = "variation_name") String str) {
            Intrinsics.checkNotNullParameter(list, "links");
            Intrinsics.checkNotNullParameter(str, "name");
            return new Variation(list, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Variation)) {
                return false;
            }
            Variation variation = (Variation) obj;
            return Intrinsics.areEqual((Object) this.links, (Object) variation.links) && Intrinsics.areEqual((Object) this.f55516name, (Object) variation.f55516name);
        }

        @NotNull
        public final List<String> getLinks() {
            return this.links;
        }

        @NotNull
        public final String getName() {
            return this.f55516name;
        }

        public int hashCode() {
            return (this.links.hashCode() * 31) + this.f55516name.hashCode();
        }

        @NotNull
        public String toString() {
            List<String> list = this.links;
            String str = this.f55516name;
            return "Variation(links=" + list + ", name=" + str + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Variation(List list, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, str);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AuthRemoteConfig(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
