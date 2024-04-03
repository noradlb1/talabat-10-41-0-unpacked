package com.talabat.darkstores.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/domain/model/RecentSearch;", "", "id", "", "query", "", "(JLjava/lang/String;)V", "getId", "()J", "getQuery", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecentSearch {

    /* renamed from: id  reason: collision with root package name */
    private final long f56220id;
    @NotNull
    private final String query;

    public RecentSearch(long j11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        this.f56220id = j11;
        this.query = str;
    }

    public static /* synthetic */ RecentSearch copy$default(RecentSearch recentSearch, long j11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = recentSearch.f56220id;
        }
        if ((i11 & 2) != 0) {
            str = recentSearch.query;
        }
        return recentSearch.copy(j11, str);
    }

    public final long component1() {
        return this.f56220id;
    }

    @NotNull
    public final String component2() {
        return this.query;
    }

    @NotNull
    public final RecentSearch copy(long j11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        return new RecentSearch(j11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecentSearch)) {
            return false;
        }
        RecentSearch recentSearch = (RecentSearch) obj;
        return this.f56220id == recentSearch.f56220id && Intrinsics.areEqual((Object) this.query, (Object) recentSearch.query);
    }

    public final long getId() {
        return this.f56220id;
    }

    @NotNull
    public final String getQuery() {
        return this.query;
    }

    public int hashCode() {
        return (a.a(this.f56220id) * 31) + this.query.hashCode();
    }

    @NotNull
    public String toString() {
        long j11 = this.f56220id;
        String str = this.query;
        return "RecentSearch(id=" + j11 + ", query=" + str + ")";
    }
}
