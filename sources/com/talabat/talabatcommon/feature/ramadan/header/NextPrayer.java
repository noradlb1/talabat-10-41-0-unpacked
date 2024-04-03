package com.talabat.talabatcommon.feature.ramadan.header;

import com.batoulapps.adhan.Prayer;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/talabatcommon/feature/ramadan/header/NextPrayer;", "", "prayerTime", "Ljava/util/Date;", "prayerName", "Lcom/batoulapps/adhan/Prayer;", "(Ljava/util/Date;Lcom/batoulapps/adhan/Prayer;)V", "getPrayerName", "()Lcom/batoulapps/adhan/Prayer;", "setPrayerName", "(Lcom/batoulapps/adhan/Prayer;)V", "getPrayerTime", "()Ljava/util/Date;", "setPrayerTime", "(Ljava/util/Date;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NextPrayer {
    @NotNull
    private Prayer prayerName;
    @NotNull
    private Date prayerTime;

    public NextPrayer(@NotNull Date date, @NotNull Prayer prayer) {
        Intrinsics.checkNotNullParameter(date, "prayerTime");
        Intrinsics.checkNotNullParameter(prayer, "prayerName");
        this.prayerTime = date;
        this.prayerName = prayer;
    }

    public static /* synthetic */ NextPrayer copy$default(NextPrayer nextPrayer, Date date, Prayer prayer, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            date = nextPrayer.prayerTime;
        }
        if ((i11 & 2) != 0) {
            prayer = nextPrayer.prayerName;
        }
        return nextPrayer.copy(date, prayer);
    }

    @NotNull
    public final Date component1() {
        return this.prayerTime;
    }

    @NotNull
    public final Prayer component2() {
        return this.prayerName;
    }

    @NotNull
    public final NextPrayer copy(@NotNull Date date, @NotNull Prayer prayer) {
        Intrinsics.checkNotNullParameter(date, "prayerTime");
        Intrinsics.checkNotNullParameter(prayer, "prayerName");
        return new NextPrayer(date, prayer);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NextPrayer)) {
            return false;
        }
        NextPrayer nextPrayer = (NextPrayer) obj;
        return Intrinsics.areEqual((Object) this.prayerTime, (Object) nextPrayer.prayerTime) && this.prayerName == nextPrayer.prayerName;
    }

    @NotNull
    public final Prayer getPrayerName() {
        return this.prayerName;
    }

    @NotNull
    public final Date getPrayerTime() {
        return this.prayerTime;
    }

    public int hashCode() {
        return (this.prayerTime.hashCode() * 31) + this.prayerName.hashCode();
    }

    public final void setPrayerName(@NotNull Prayer prayer) {
        Intrinsics.checkNotNullParameter(prayer, "<set-?>");
        this.prayerName = prayer;
    }

    public final void setPrayerTime(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.prayerTime = date;
    }

    @NotNull
    public String toString() {
        Date date = this.prayerTime;
        Prayer prayer = this.prayerName;
        return "NextPrayer(prayerTime=" + date + ", prayerName=" + prayer + ")";
    }
}
