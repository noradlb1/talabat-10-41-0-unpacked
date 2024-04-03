package com.talabat.darkstores.data.discovery.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0010\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0004\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/darkstores/data/discovery/model/NetworkSortOption;", "", "displayName", "", "isApplied", "", "key", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getKey", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/talabat/darkstores/data/discovery/model/NetworkSortOption;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkSortOption {
    @Nullable
    private final String displayName;
    @Nullable
    private final Boolean isApplied;
    @Nullable
    private final String key;

    public NetworkSortOption() {
        this((String) null, (Boolean) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public NetworkSortOption(@Nullable @Json(name = "display_name") String str, @Nullable @Json(name = "is_applied") Boolean bool, @Nullable @Json(name = "key") String str2) {
        this.displayName = str;
        this.isApplied = bool;
        this.key = str2;
    }

    public static /* synthetic */ NetworkSortOption copy$default(NetworkSortOption networkSortOption, String str, Boolean bool, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = networkSortOption.displayName;
        }
        if ((i11 & 2) != 0) {
            bool = networkSortOption.isApplied;
        }
        if ((i11 & 4) != 0) {
            str2 = networkSortOption.key;
        }
        return networkSortOption.copy(str, bool, str2);
    }

    @Nullable
    public final String component1() {
        return this.displayName;
    }

    @Nullable
    public final Boolean component2() {
        return this.isApplied;
    }

    @Nullable
    public final String component3() {
        return this.key;
    }

    @NotNull
    public final NetworkSortOption copy(@Nullable @Json(name = "display_name") String str, @Nullable @Json(name = "is_applied") Boolean bool, @Nullable @Json(name = "key") String str2) {
        return new NetworkSortOption(str, bool, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkSortOption)) {
            return false;
        }
        NetworkSortOption networkSortOption = (NetworkSortOption) obj;
        return Intrinsics.areEqual((Object) this.displayName, (Object) networkSortOption.displayName) && Intrinsics.areEqual((Object) this.isApplied, (Object) networkSortOption.isApplied) && Intrinsics.areEqual((Object) this.key, (Object) networkSortOption.key);
    }

    @Nullable
    public final String getDisplayName() {
        return this.displayName;
    }

    @Nullable
    public final String getKey() {
        return this.key;
    }

    public int hashCode() {
        String str = this.displayName;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isApplied;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.key;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @Nullable
    public final Boolean isApplied() {
        return this.isApplied;
    }

    @NotNull
    public String toString() {
        String str = this.displayName;
        Boolean bool = this.isApplied;
        String str2 = this.key;
        return "NetworkSortOption(displayName=" + str + ", isApplied=" + bool + ", key=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkSortOption(String str, Boolean bool, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : bool, (i11 & 4) != 0 ? null : str2);
    }
}
