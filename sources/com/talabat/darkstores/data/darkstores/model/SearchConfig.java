package com.talabat.darkstores.data.darkstores.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/darkstores/data/darkstores/model/SearchConfig;", "", "searchConfiguration", "", "(Ljava/lang/String;)V", "getSearchConfiguration", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SearchConfig {
    @NotNull
    private final String searchConfiguration;

    public SearchConfig() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public SearchConfig(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "searchConfiguration");
        this.searchConfiguration = str;
    }

    public static /* synthetic */ SearchConfig copy$default(SearchConfig searchConfig, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = searchConfig.searchConfiguration;
        }
        return searchConfig.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.searchConfiguration;
    }

    @NotNull
    public final SearchConfig copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "searchConfiguration");
        return new SearchConfig(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SearchConfig) && Intrinsics.areEqual((Object) this.searchConfiguration, (Object) ((SearchConfig) obj).searchConfiguration);
    }

    @NotNull
    public final String getSearchConfiguration() {
        return this.searchConfiguration;
    }

    public int hashCode() {
        return this.searchConfiguration.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.searchConfiguration;
        return "SearchConfig(searchConfiguration=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchConfig(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str);
    }
}
