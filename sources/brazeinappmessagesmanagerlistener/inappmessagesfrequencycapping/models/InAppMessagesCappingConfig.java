package brazeinappmessagesmanagerlistener.inappmessagesfrequencycapping.models;

import kotlin.Metadata;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lbrazeinappmessagesmanagerlistener/inappmessagesfrequencycapping/models/InAppMessagesCappingConfig;", "", "timeInSeconds", "", "maxLimitForDisplay", "", "(JI)V", "getMaxLimitForDisplay", "()I", "getTimeInSeconds", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InAppMessagesCappingConfig {
    private final int maxLimitForDisplay;
    private final long timeInSeconds;

    public InAppMessagesCappingConfig(long j11, int i11) {
        this.timeInSeconds = j11;
        this.maxLimitForDisplay = i11;
    }

    public static /* synthetic */ InAppMessagesCappingConfig copy$default(InAppMessagesCappingConfig inAppMessagesCappingConfig, long j11, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            j11 = inAppMessagesCappingConfig.timeInSeconds;
        }
        if ((i12 & 2) != 0) {
            i11 = inAppMessagesCappingConfig.maxLimitForDisplay;
        }
        return inAppMessagesCappingConfig.copy(j11, i11);
    }

    public final long component1() {
        return this.timeInSeconds;
    }

    public final int component2() {
        return this.maxLimitForDisplay;
    }

    @NotNull
    public final InAppMessagesCappingConfig copy(long j11, int i11) {
        return new InAppMessagesCappingConfig(j11, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InAppMessagesCappingConfig)) {
            return false;
        }
        InAppMessagesCappingConfig inAppMessagesCappingConfig = (InAppMessagesCappingConfig) obj;
        return this.timeInSeconds == inAppMessagesCappingConfig.timeInSeconds && this.maxLimitForDisplay == inAppMessagesCappingConfig.maxLimitForDisplay;
    }

    public final int getMaxLimitForDisplay() {
        return this.maxLimitForDisplay;
    }

    public final long getTimeInSeconds() {
        return this.timeInSeconds;
    }

    public int hashCode() {
        return (a.a(this.timeInSeconds) * 31) + this.maxLimitForDisplay;
    }

    @NotNull
    public String toString() {
        long j11 = this.timeInSeconds;
        int i11 = this.maxLimitForDisplay;
        return "InAppMessagesCappingConfig(timeInSeconds=" + j11 + ", maxLimitForDisplay=" + i11 + ")";
    }
}
