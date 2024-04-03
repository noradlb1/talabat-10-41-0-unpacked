package library.talabat.mvp.listingmenubridge;

import kotlin.Metadata;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Llibrary/talabat/mvp/listingmenubridge/DarkstoresTrackingData;", "", "loadingStartTime", "", "(J)V", "getLoadingStartTime", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresTrackingData {
    private final long loadingStartTime;

    public DarkstoresTrackingData(long j11) {
        this.loadingStartTime = j11;
    }

    public static /* synthetic */ DarkstoresTrackingData copy$default(DarkstoresTrackingData darkstoresTrackingData, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = darkstoresTrackingData.loadingStartTime;
        }
        return darkstoresTrackingData.copy(j11);
    }

    public final long component1() {
        return this.loadingStartTime;
    }

    @NotNull
    public final DarkstoresTrackingData copy(long j11) {
        return new DarkstoresTrackingData(j11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DarkstoresTrackingData) && this.loadingStartTime == ((DarkstoresTrackingData) obj).loadingStartTime;
    }

    public final long getLoadingStartTime() {
        return this.loadingStartTime;
    }

    public int hashCode() {
        return a.a(this.loadingStartTime);
    }

    @NotNull
    public String toString() {
        long j11 = this.loadingStartTime;
        return "DarkstoresTrackingData(loadingStartTime=" + j11 + ")";
    }
}
