package com.talabat.performance_analytics;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u000f"}, d2 = {"Lcom/talabat/performance_analytics/PerformanceAnalyticsApiCodec;", "Lio/flutter/plugin/common/StandardMessageCodec;", "", "type", "Ljava/nio/ByteBuffer;", "buffer", "", "e", "Ljava/io/ByteArrayOutputStream;", "stream", "value", "", "n", "<init>", "()V", "performance_analytics_release"}, k = 1, mv = {1, 7, 1})
final class PerformanceAnalyticsApiCodec extends StandardMessageCodec {
    @NotNull
    public static final PerformanceAnalyticsApiCodec INSTANCE = new PerformanceAnalyticsApiCodec();

    private PerformanceAnalyticsApiCodec() {
    }

    @Nullable
    public Object e(byte b11, @NotNull ByteBuffer byteBuffer) {
        List list;
        List list2;
        List list3;
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        if (b11 == Byte.MIN_VALUE) {
            Object d11 = d(byteBuffer);
            if (d11 instanceof List) {
                list3 = (List) d11;
            } else {
                list3 = null;
            }
            if (list3 != null) {
                return TraceAttributeParams.Companion.fromList(list3);
            }
            return null;
        } else if (b11 == -127) {
            Object d12 = d(byteBuffer);
            if (d12 instanceof List) {
                list2 = (List) d12;
            } else {
                list2 = null;
            }
            if (list2 != null) {
                return TraceCounterParams.Companion.fromList(list2);
            }
            return null;
        } else if (b11 != -126) {
            return super.e(b11, byteBuffer);
        } else {
            Object d13 = d(byteBuffer);
            if (d13 instanceof List) {
                list = (List) d13;
            } else {
                list = null;
            }
            if (list != null) {
                return TraceMetricParams.Companion.fromList(list);
            }
            return null;
        }
    }

    public void n(@NotNull ByteArrayOutputStream byteArrayOutputStream, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(byteArrayOutputStream, "stream");
        if (obj instanceof TraceAttributeParams) {
            byteArrayOutputStream.write(128);
            n(byteArrayOutputStream, ((TraceAttributeParams) obj).toList());
        } else if (obj instanceof TraceCounterParams) {
            byteArrayOutputStream.write(129);
            n(byteArrayOutputStream, ((TraceCounterParams) obj).toList());
        } else if (obj instanceof TraceMetricParams) {
            byteArrayOutputStream.write(130);
            n(byteArrayOutputStream, ((TraceMetricParams) obj).toList());
        } else {
            super.n(byteArrayOutputStream, obj);
        }
    }
}
