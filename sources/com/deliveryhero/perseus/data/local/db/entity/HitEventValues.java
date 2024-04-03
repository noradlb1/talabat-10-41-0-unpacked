package com.deliveryhero.perseus.data.local.db.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/deliveryhero/perseus/data/local/db/entity/HitEventValues;", "", "timestampId", "", "timestamp", "key", "", "value", "id", "", "(JJLjava/lang/String;Ljava/lang/String;I)V", "getId", "()I", "getKey", "()Ljava/lang/String;", "getTimestamp", "()J", "getTimestampId", "getValue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Entity
public final class HitEventValues {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String TABLE_NAME = "HitEventValues";
    @PrimaryKey(autoGenerate = true)

    /* renamed from: id  reason: collision with root package name */
    private final int f30398id;
    @NotNull
    private final String key;
    private final long timestamp;
    private final long timestampId;
    @NotNull
    private final String value;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/perseus/data/local/db/entity/HitEventValues$Companion;", "", "()V", "TABLE_NAME", "", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HitEventValues(long j11, long j12, @NotNull String str, @NotNull String str2, int i11) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        this.timestampId = j11;
        this.timestamp = j12;
        this.key = str;
        this.value = str2;
        this.f30398id = i11;
    }

    public static /* synthetic */ HitEventValues copy$default(HitEventValues hitEventValues, long j11, long j12, String str, String str2, int i11, int i12, Object obj) {
        HitEventValues hitEventValues2 = hitEventValues;
        return hitEventValues.copy((i12 & 1) != 0 ? hitEventValues2.timestampId : j11, (i12 & 2) != 0 ? hitEventValues2.timestamp : j12, (i12 & 4) != 0 ? hitEventValues2.key : str, (i12 & 8) != 0 ? hitEventValues2.value : str2, (i12 & 16) != 0 ? hitEventValues2.f30398id : i11);
    }

    public final long component1() {
        return this.timestampId;
    }

    public final long component2() {
        return this.timestamp;
    }

    @NotNull
    public final String component3() {
        return this.key;
    }

    @NotNull
    public final String component4() {
        return this.value;
    }

    public final int component5() {
        return this.f30398id;
    }

    @NotNull
    public final HitEventValues copy(long j11, long j12, @NotNull String str, @NotNull String str2, int i11) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        return new HitEventValues(j11, j12, str, str2, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HitEventValues)) {
            return false;
        }
        HitEventValues hitEventValues = (HitEventValues) obj;
        return this.timestampId == hitEventValues.timestampId && this.timestamp == hitEventValues.timestamp && Intrinsics.areEqual((Object) this.key, (Object) hitEventValues.key) && Intrinsics.areEqual((Object) this.value, (Object) hitEventValues.value) && this.f30398id == hitEventValues.f30398id;
    }

    public final int getId() {
        return this.f30398id;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final long getTimestampId() {
        return this.timestampId;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((((((a.a(this.timestampId) * 31) + a.a(this.timestamp)) * 31) + this.key.hashCode()) * 31) + this.value.hashCode()) * 31) + this.f30398id;
    }

    @NotNull
    public String toString() {
        return "HitEventValues(timestampId=" + this.timestampId + ", timestamp=" + this.timestamp + ", key=" + this.key + ", value=" + this.value + ", id=" + this.f30398id + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HitEventValues(long j11, long j12, String str, String str2, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, str, str2, (i12 & 16) != 0 ? 0 : i11);
    }
}
