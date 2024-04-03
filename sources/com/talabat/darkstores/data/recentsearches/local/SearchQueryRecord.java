package com.talabat.darkstores.data.recentsearches.local;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001e\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/talabat/darkstores/data/recentsearches/local/SearchQueryRecord;", "", "query", "", "vendorId", "", "timestamp", "", "(Ljava/lang/String;IJ)V", "id", "getId", "()J", "setId", "(J)V", "getQuery", "()Ljava/lang/String;", "getTimestamp", "getVendorId", "()I", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Entity
public final class SearchQueryRecord {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)

    /* renamed from: id  reason: collision with root package name */
    private long f56204id;
    @ColumnInfo(name = "query")
    @NotNull
    private final String query;
    @ColumnInfo(name = "timestamp")
    private final long timestamp;
    @ColumnInfo(name = "vendor_id")
    private final int vendorId;

    public SearchQueryRecord(@NotNull String str, int i11, long j11) {
        Intrinsics.checkNotNullParameter(str, "query");
        this.query = str;
        this.vendorId = i11;
        this.timestamp = j11;
    }

    public final long getId() {
        return this.f56204id;
    }

    @NotNull
    public final String getQuery() {
        return this.query;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getVendorId() {
        return this.vendorId;
    }

    public final void setId(long j11) {
        this.f56204id = j11;
    }
}
