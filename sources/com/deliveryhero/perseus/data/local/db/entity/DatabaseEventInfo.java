package com.deliveryhero.perseus.data.local.db.entity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/perseus/data/local/db/entity/DatabaseEventInfo;", "", "oldestMessageTimestamp", "", "backlogSize", "", "(JI)V", "getBacklogSize", "()I", "getOldestMessageTimestamp", "()J", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DatabaseEventInfo {
    private final int backlogSize;
    private final long oldestMessageTimestamp;

    public DatabaseEventInfo(long j11, int i11) {
        this.oldestMessageTimestamp = j11;
        this.backlogSize = i11;
    }

    public final int getBacklogSize() {
        return this.backlogSize;
    }

    public final long getOldestMessageTimestamp() {
        return this.oldestMessageTimestamp;
    }
}
