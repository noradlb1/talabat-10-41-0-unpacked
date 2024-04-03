package com.deliveryhero.performance.core.tapresponse;

import com.deliveryhero.performance.core.screenmetric.ScreenMetricParent;
import com.deliveryhero.performance.core.screenmetric.ScreenMetricTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003JQ\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006&"}, d2 = {"Lcom/deliveryhero/performance/core/tapresponse/TapResponseTime;", "Lcom/deliveryhero/performance/core/screenmetric/ScreenMetricParent;", "screenMetricTime", "Lcom/deliveryhero/performance/core/screenmetric/ScreenMetricTime;", "sourceScreenChosenName", "", "navigationToScreen", "", "totalMillis", "touchDispatchMillis", "actionDispatchMillis", "frameDispatchMillis", "(Lcom/deliveryhero/performance/core/screenmetric/ScreenMetricTime;Ljava/lang/String;JJJJJ)V", "getActionDispatchMillis", "()J", "getFrameDispatchMillis", "getNavigationToScreen", "getScreenMetricTime", "()Lcom/deliveryhero/performance/core/screenmetric/ScreenMetricTime;", "getSourceScreenChosenName", "()Ljava/lang/String;", "getTotalMillis", "getTouchDispatchMillis", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TapResponseTime extends ScreenMetricParent {
    private final long actionDispatchMillis;
    private final long frameDispatchMillis;
    private final long navigationToScreen;
    @NotNull
    private final ScreenMetricTime screenMetricTime;
    @Nullable
    private final String sourceScreenChosenName;
    private final long totalMillis;
    private final long touchDispatchMillis;

    public TapResponseTime(@NotNull ScreenMetricTime screenMetricTime2, @Nullable String str, long j11, long j12, long j13, long j14, long j15) {
        Intrinsics.checkNotNullParameter(screenMetricTime2, "screenMetricTime");
        this.screenMetricTime = screenMetricTime2;
        this.sourceScreenChosenName = str;
        this.navigationToScreen = j11;
        this.totalMillis = j12;
        this.touchDispatchMillis = j13;
        this.actionDispatchMillis = j14;
        this.frameDispatchMillis = j15;
    }

    public static /* synthetic */ TapResponseTime copy$default(TapResponseTime tapResponseTime, ScreenMetricTime screenMetricTime2, String str, long j11, long j12, long j13, long j14, long j15, int i11, Object obj) {
        TapResponseTime tapResponseTime2 = tapResponseTime;
        return tapResponseTime.copy((i11 & 1) != 0 ? tapResponseTime2.screenMetricTime : screenMetricTime2, (i11 & 2) != 0 ? tapResponseTime2.sourceScreenChosenName : str, (i11 & 4) != 0 ? tapResponseTime2.navigationToScreen : j11, (i11 & 8) != 0 ? tapResponseTime2.totalMillis : j12, (i11 & 16) != 0 ? tapResponseTime2.touchDispatchMillis : j13, (i11 & 32) != 0 ? tapResponseTime2.actionDispatchMillis : j14, (i11 & 64) != 0 ? tapResponseTime2.frameDispatchMillis : j15);
    }

    @NotNull
    public final ScreenMetricTime component1() {
        return this.screenMetricTime;
    }

    @Nullable
    public final String component2() {
        return this.sourceScreenChosenName;
    }

    public final long component3() {
        return this.navigationToScreen;
    }

    public final long component4() {
        return this.totalMillis;
    }

    public final long component5() {
        return this.touchDispatchMillis;
    }

    public final long component6() {
        return this.actionDispatchMillis;
    }

    public final long component7() {
        return this.frameDispatchMillis;
    }

    @NotNull
    public final TapResponseTime copy(@NotNull ScreenMetricTime screenMetricTime2, @Nullable String str, long j11, long j12, long j13, long j14, long j15) {
        Intrinsics.checkNotNullParameter(screenMetricTime2, "screenMetricTime");
        return new TapResponseTime(screenMetricTime2, str, j11, j12, j13, j14, j15);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TapResponseTime)) {
            return false;
        }
        TapResponseTime tapResponseTime = (TapResponseTime) obj;
        return Intrinsics.areEqual((Object) this.screenMetricTime, (Object) tapResponseTime.screenMetricTime) && Intrinsics.areEqual((Object) this.sourceScreenChosenName, (Object) tapResponseTime.sourceScreenChosenName) && this.navigationToScreen == tapResponseTime.navigationToScreen && this.totalMillis == tapResponseTime.totalMillis && this.touchDispatchMillis == tapResponseTime.touchDispatchMillis && this.actionDispatchMillis == tapResponseTime.actionDispatchMillis && this.frameDispatchMillis == tapResponseTime.frameDispatchMillis;
    }

    public final long getActionDispatchMillis() {
        return this.actionDispatchMillis;
    }

    public final long getFrameDispatchMillis() {
        return this.frameDispatchMillis;
    }

    public final long getNavigationToScreen() {
        return this.navigationToScreen;
    }

    @NotNull
    public final ScreenMetricTime getScreenMetricTime() {
        return this.screenMetricTime;
    }

    @Nullable
    public final String getSourceScreenChosenName() {
        return this.sourceScreenChosenName;
    }

    public final long getTotalMillis() {
        return this.totalMillis;
    }

    public final long getTouchDispatchMillis() {
        return this.touchDispatchMillis;
    }

    public int hashCode() {
        int hashCode = this.screenMetricTime.hashCode() * 31;
        String str = this.sourceScreenChosenName;
        return ((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + a.a(this.navigationToScreen)) * 31) + a.a(this.totalMillis)) * 31) + a.a(this.touchDispatchMillis)) * 31) + a.a(this.actionDispatchMillis)) * 31) + a.a(this.frameDispatchMillis);
    }

    @NotNull
    public String toString() {
        return "TapResponseTime(screenMetricTime=" + this.screenMetricTime + ", sourceScreenChosenName=" + this.sourceScreenChosenName + ", navigationToScreen=" + this.navigationToScreen + ", totalMillis=" + this.totalMillis + ", touchDispatchMillis=" + this.touchDispatchMillis + ", actionDispatchMillis=" + this.actionDispatchMillis + ", frameDispatchMillis=" + this.frameDispatchMillis + ')';
    }
}
