package com.deliveryhero.performance.core.screenmetric;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012¨\u0006-"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/ScreenMetricTime;", "Lcom/deliveryhero/performance/core/screenmetric/ScreenMetricParent;", "destinationScreenSimpleName", "", "timeToFirstLayout", "", "frameTotalMillis", "frameInputHandlingMillis", "frameAnimationMillis", "frameLayoutMeasureMillis", "frameDrawMillis", "frameSyncMillis", "frameCommandIssueMillis", "frameSwapBuffersMillis", "(Ljava/lang/String;JJJJJJJJJ)V", "getDestinationScreenSimpleName", "()Ljava/lang/String;", "getFrameAnimationMillis", "()J", "getFrameCommandIssueMillis", "getFrameDrawMillis", "getFrameInputHandlingMillis", "getFrameLayoutMeasureMillis", "getFrameSwapBuffersMillis", "getFrameSyncMillis", "getFrameTotalMillis", "getTimeToFirstLayout", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScreenMetricTime extends ScreenMetricParent {
    @NotNull
    private final String destinationScreenSimpleName;
    private final long frameAnimationMillis;
    private final long frameCommandIssueMillis;
    private final long frameDrawMillis;
    private final long frameInputHandlingMillis;
    private final long frameLayoutMeasureMillis;
    private final long frameSwapBuffersMillis;
    private final long frameSyncMillis;
    private final long frameTotalMillis;
    private final long timeToFirstLayout;

    public ScreenMetricTime(@NotNull String str, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19) {
        Intrinsics.checkNotNullParameter(str, "destinationScreenSimpleName");
        this.destinationScreenSimpleName = str;
        this.timeToFirstLayout = j11;
        this.frameTotalMillis = j12;
        this.frameInputHandlingMillis = j13;
        this.frameAnimationMillis = j14;
        this.frameLayoutMeasureMillis = j15;
        this.frameDrawMillis = j16;
        this.frameSyncMillis = j17;
        this.frameCommandIssueMillis = j18;
        this.frameSwapBuffersMillis = j19;
    }

    public static /* synthetic */ ScreenMetricTime copy$default(ScreenMetricTime screenMetricTime, String str, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, int i11, Object obj) {
        ScreenMetricTime screenMetricTime2 = screenMetricTime;
        int i12 = i11;
        return screenMetricTime.copy((i12 & 1) != 0 ? screenMetricTime2.destinationScreenSimpleName : str, (i12 & 2) != 0 ? screenMetricTime2.timeToFirstLayout : j11, (i12 & 4) != 0 ? screenMetricTime2.frameTotalMillis : j12, (i12 & 8) != 0 ? screenMetricTime2.frameInputHandlingMillis : j13, (i12 & 16) != 0 ? screenMetricTime2.frameAnimationMillis : j14, (i12 & 32) != 0 ? screenMetricTime2.frameLayoutMeasureMillis : j15, (i12 & 64) != 0 ? screenMetricTime2.frameDrawMillis : j16, (i12 & 128) != 0 ? screenMetricTime2.frameSyncMillis : j17, (i12 & 256) != 0 ? screenMetricTime2.frameCommandIssueMillis : j18, (i12 & 512) != 0 ? screenMetricTime2.frameSwapBuffersMillis : j19);
    }

    @NotNull
    public final String component1() {
        return this.destinationScreenSimpleName;
    }

    public final long component10() {
        return this.frameSwapBuffersMillis;
    }

    public final long component2() {
        return this.timeToFirstLayout;
    }

    public final long component3() {
        return this.frameTotalMillis;
    }

    public final long component4() {
        return this.frameInputHandlingMillis;
    }

    public final long component5() {
        return this.frameAnimationMillis;
    }

    public final long component6() {
        return this.frameLayoutMeasureMillis;
    }

    public final long component7() {
        return this.frameDrawMillis;
    }

    public final long component8() {
        return this.frameSyncMillis;
    }

    public final long component9() {
        return this.frameCommandIssueMillis;
    }

    @NotNull
    public final ScreenMetricTime copy(@NotNull String str, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19) {
        String str2 = str;
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str2, "destinationScreenSimpleName");
        return new ScreenMetricTime(str2, j11, j12, j13, j14, j15, j16, j17, j18, j19);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScreenMetricTime)) {
            return false;
        }
        ScreenMetricTime screenMetricTime = (ScreenMetricTime) obj;
        return Intrinsics.areEqual((Object) this.destinationScreenSimpleName, (Object) screenMetricTime.destinationScreenSimpleName) && this.timeToFirstLayout == screenMetricTime.timeToFirstLayout && this.frameTotalMillis == screenMetricTime.frameTotalMillis && this.frameInputHandlingMillis == screenMetricTime.frameInputHandlingMillis && this.frameAnimationMillis == screenMetricTime.frameAnimationMillis && this.frameLayoutMeasureMillis == screenMetricTime.frameLayoutMeasureMillis && this.frameDrawMillis == screenMetricTime.frameDrawMillis && this.frameSyncMillis == screenMetricTime.frameSyncMillis && this.frameCommandIssueMillis == screenMetricTime.frameCommandIssueMillis && this.frameSwapBuffersMillis == screenMetricTime.frameSwapBuffersMillis;
    }

    @NotNull
    public final String getDestinationScreenSimpleName() {
        return this.destinationScreenSimpleName;
    }

    public final long getFrameAnimationMillis() {
        return this.frameAnimationMillis;
    }

    public final long getFrameCommandIssueMillis() {
        return this.frameCommandIssueMillis;
    }

    public final long getFrameDrawMillis() {
        return this.frameDrawMillis;
    }

    public final long getFrameInputHandlingMillis() {
        return this.frameInputHandlingMillis;
    }

    public final long getFrameLayoutMeasureMillis() {
        return this.frameLayoutMeasureMillis;
    }

    public final long getFrameSwapBuffersMillis() {
        return this.frameSwapBuffersMillis;
    }

    public final long getFrameSyncMillis() {
        return this.frameSyncMillis;
    }

    public final long getFrameTotalMillis() {
        return this.frameTotalMillis;
    }

    public final long getTimeToFirstLayout() {
        return this.timeToFirstLayout;
    }

    public int hashCode() {
        return (((((((((((((((((this.destinationScreenSimpleName.hashCode() * 31) + a.a(this.timeToFirstLayout)) * 31) + a.a(this.frameTotalMillis)) * 31) + a.a(this.frameInputHandlingMillis)) * 31) + a.a(this.frameAnimationMillis)) * 31) + a.a(this.frameLayoutMeasureMillis)) * 31) + a.a(this.frameDrawMillis)) * 31) + a.a(this.frameSyncMillis)) * 31) + a.a(this.frameCommandIssueMillis)) * 31) + a.a(this.frameSwapBuffersMillis);
    }

    @NotNull
    public String toString() {
        return "ScreenMetricTime(destinationScreenSimpleName=" + this.destinationScreenSimpleName + ", timeToFirstLayout=" + this.timeToFirstLayout + ", frameTotalMillis=" + this.frameTotalMillis + ", frameInputHandlingMillis=" + this.frameInputHandlingMillis + ", frameAnimationMillis=" + this.frameAnimationMillis + ", frameLayoutMeasureMillis=" + this.frameLayoutMeasureMillis + ", frameDrawMillis=" + this.frameDrawMillis + ", frameSyncMillis=" + this.frameSyncMillis + ", frameCommandIssueMillis=" + this.frameCommandIssueMillis + ", frameSwapBuffersMillis=" + this.frameSwapBuffersMillis + ')';
    }
}
