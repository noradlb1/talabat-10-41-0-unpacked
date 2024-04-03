package com.deliveryhero.performance.core.screenmetric;

import android.view.FrameMetrics;
import androidx.annotation.RequiresApi;
import com.deliveryhero.performance.core.tapresponse.TapResponseTime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/ScreenMetricParent;", "", "()V", "Builder", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ScreenMetricParent {

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003JV\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000e¨\u0006&"}, d2 = {"Lcom/deliveryhero/performance/core/screenmetric/ScreenMetricParent$Builder;", "", "tapUptimeMillis", "", "dispatchedUptimeMillis", "triggeringActionUptimeMillis", "screenCreationTime", "destinationScreenSimpleName", "", "sourceScreenChosenName", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getDestinationScreenSimpleName", "()Ljava/lang/String;", "getDispatchedUptimeMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getScreenCreationTime", "getSourceScreenChosenName", "getTapUptimeMillis", "getTriggeringActionUptimeMillis", "build", "Lcom/deliveryhero/performance/core/screenmetric/ScreenMetricParent;", "frameMetrics", "Landroid/view/FrameMetrics;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/deliveryhero/performance/core/screenmetric/ScreenMetricParent$Builder;", "equals", "", "other", "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        @Nullable
        private final String destinationScreenSimpleName;
        @Nullable
        private final Long dispatchedUptimeMillis;
        @Nullable
        private final Long screenCreationTime;
        @Nullable
        private final String sourceScreenChosenName;
        @Nullable
        private final Long tapUptimeMillis;
        @Nullable
        private final Long triggeringActionUptimeMillis;

        public Builder() {
            this((Long) null, (Long) null, (Long) null, (Long) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
        }

        public Builder(@Nullable Long l11, @Nullable Long l12, @Nullable Long l13, @Nullable Long l14, @Nullable String str, @Nullable String str2) {
            this.tapUptimeMillis = l11;
            this.dispatchedUptimeMillis = l12;
            this.triggeringActionUptimeMillis = l13;
            this.screenCreationTime = l14;
            this.destinationScreenSimpleName = str;
            this.sourceScreenChosenName = str2;
        }

        public static /* synthetic */ Builder copy$default(Builder builder, Long l11, Long l12, Long l13, Long l14, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                l11 = builder.tapUptimeMillis;
            }
            if ((i11 & 2) != 0) {
                l12 = builder.dispatchedUptimeMillis;
            }
            Long l15 = l12;
            if ((i11 & 4) != 0) {
                l13 = builder.triggeringActionUptimeMillis;
            }
            Long l16 = l13;
            if ((i11 & 8) != 0) {
                l14 = builder.screenCreationTime;
            }
            Long l17 = l14;
            if ((i11 & 16) != 0) {
                str = builder.destinationScreenSimpleName;
            }
            String str3 = str;
            if ((i11 & 32) != 0) {
                str2 = builder.sourceScreenChosenName;
            }
            return builder.copy(l11, l15, l16, l17, str3, str2);
        }

        @RequiresApi(26)
        @NotNull
        public final ScreenMetricParent build(@NotNull FrameMetrics frameMetrics) {
            FrameMetrics frameMetrics2 = frameMetrics;
            Intrinsics.checkNotNullParameter(frameMetrics2, "frameMetrics");
            long j11 = (long) 1000000;
            long a11 = frameMetrics2.getMetric(11) / j11;
            long a12 = frameMetrics2.getMetric(8) / j11;
            long a13 = (frameMetrics2.getMetric(10) / j11) + a12;
            String str = this.destinationScreenSimpleName;
            String str2 = str;
            Intrinsics.checkNotNull(str);
            Long l11 = this.screenCreationTime;
            Intrinsics.checkNotNull(l11);
            ScreenMetricTime screenMetricTime = new ScreenMetricTime(str2, a13 - l11.longValue(), a12, frameMetrics2.getMetric(1) / j11, frameMetrics2.getMetric(2) / j11, frameMetrics2.getMetric(3) / j11, frameMetrics2.getMetric(4) / j11, frameMetrics2.getMetric(5) / j11, frameMetrics2.getMetric(6) / j11, frameMetrics2.getMetric(7) / j11);
            if (this.tapUptimeMillis == null || this.dispatchedUptimeMillis == null) {
                return screenMetricTime;
            }
            String str3 = this.sourceScreenChosenName;
            long longValue = this.screenCreationTime.longValue() - this.tapUptimeMillis.longValue();
            long longValue2 = a13 - this.tapUptimeMillis.longValue();
            long longValue3 = this.dispatchedUptimeMillis.longValue() - this.tapUptimeMillis.longValue();
            Long l12 = this.triggeringActionUptimeMillis;
            Intrinsics.checkNotNull(l12);
            return new TapResponseTime(screenMetricTime, str3, longValue, longValue2, longValue3, l12.longValue() - this.dispatchedUptimeMillis.longValue(), a11 - this.triggeringActionUptimeMillis.longValue());
        }

        @Nullable
        public final Long component1() {
            return this.tapUptimeMillis;
        }

        @Nullable
        public final Long component2() {
            return this.dispatchedUptimeMillis;
        }

        @Nullable
        public final Long component3() {
            return this.triggeringActionUptimeMillis;
        }

        @Nullable
        public final Long component4() {
            return this.screenCreationTime;
        }

        @Nullable
        public final String component5() {
            return this.destinationScreenSimpleName;
        }

        @Nullable
        public final String component6() {
            return this.sourceScreenChosenName;
        }

        @NotNull
        public final Builder copy(@Nullable Long l11, @Nullable Long l12, @Nullable Long l13, @Nullable Long l14, @Nullable String str, @Nullable String str2) {
            return new Builder(l11, l12, l13, l14, str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Builder)) {
                return false;
            }
            Builder builder = (Builder) obj;
            return Intrinsics.areEqual((Object) this.tapUptimeMillis, (Object) builder.tapUptimeMillis) && Intrinsics.areEqual((Object) this.dispatchedUptimeMillis, (Object) builder.dispatchedUptimeMillis) && Intrinsics.areEqual((Object) this.triggeringActionUptimeMillis, (Object) builder.triggeringActionUptimeMillis) && Intrinsics.areEqual((Object) this.screenCreationTime, (Object) builder.screenCreationTime) && Intrinsics.areEqual((Object) this.destinationScreenSimpleName, (Object) builder.destinationScreenSimpleName) && Intrinsics.areEqual((Object) this.sourceScreenChosenName, (Object) builder.sourceScreenChosenName);
        }

        @Nullable
        public final String getDestinationScreenSimpleName() {
            return this.destinationScreenSimpleName;
        }

        @Nullable
        public final Long getDispatchedUptimeMillis() {
            return this.dispatchedUptimeMillis;
        }

        @Nullable
        public final Long getScreenCreationTime() {
            return this.screenCreationTime;
        }

        @Nullable
        public final String getSourceScreenChosenName() {
            return this.sourceScreenChosenName;
        }

        @Nullable
        public final Long getTapUptimeMillis() {
            return this.tapUptimeMillis;
        }

        @Nullable
        public final Long getTriggeringActionUptimeMillis() {
            return this.triggeringActionUptimeMillis;
        }

        public int hashCode() {
            Long l11 = this.tapUptimeMillis;
            int i11 = 0;
            int hashCode = (l11 == null ? 0 : l11.hashCode()) * 31;
            Long l12 = this.dispatchedUptimeMillis;
            int hashCode2 = (hashCode + (l12 == null ? 0 : l12.hashCode())) * 31;
            Long l13 = this.triggeringActionUptimeMillis;
            int hashCode3 = (hashCode2 + (l13 == null ? 0 : l13.hashCode())) * 31;
            Long l14 = this.screenCreationTime;
            int hashCode4 = (hashCode3 + (l14 == null ? 0 : l14.hashCode())) * 31;
            String str = this.destinationScreenSimpleName;
            int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.sourceScreenChosenName;
            if (str2 != null) {
                i11 = str2.hashCode();
            }
            return hashCode5 + i11;
        }

        @NotNull
        public String toString() {
            return "Builder(tapUptimeMillis=" + this.tapUptimeMillis + ", dispatchedUptimeMillis=" + this.dispatchedUptimeMillis + ", triggeringActionUptimeMillis=" + this.triggeringActionUptimeMillis + ", screenCreationTime=" + this.screenCreationTime + ", destinationScreenSimpleName=" + this.destinationScreenSimpleName + ", sourceScreenChosenName=" + this.sourceScreenChosenName + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Builder(java.lang.Long r6, java.lang.Long r7, java.lang.Long r8, java.lang.Long r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
            /*
                r5 = this;
                r13 = r12 & 1
                r0 = 0
                if (r13 == 0) goto L_0x0007
                r13 = r0
                goto L_0x0008
            L_0x0007:
                r13 = r6
            L_0x0008:
                r6 = r12 & 2
                if (r6 == 0) goto L_0x000e
                r1 = r0
                goto L_0x000f
            L_0x000e:
                r1 = r7
            L_0x000f:
                r6 = r12 & 4
                if (r6 == 0) goto L_0x0015
                r2 = r0
                goto L_0x0016
            L_0x0015:
                r2 = r8
            L_0x0016:
                r6 = r12 & 8
                if (r6 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r9
            L_0x001d:
                r6 = r12 & 16
                if (r6 == 0) goto L_0x0023
                r4 = r0
                goto L_0x0024
            L_0x0023:
                r4 = r10
            L_0x0024:
                r6 = r12 & 32
                if (r6 == 0) goto L_0x002a
                r12 = r0
                goto L_0x002b
            L_0x002a:
                r12 = r11
            L_0x002b:
                r6 = r5
                r7 = r13
                r8 = r1
                r9 = r2
                r10 = r3
                r11 = r4
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.performance.core.screenmetric.ScreenMetricParent.Builder.<init>(java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
