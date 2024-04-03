package com.deliveryhero.customerchat.helpers.dateProvider;

import com.huawei.hms.flutter.map.constants.Param;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/customerchat/helpers/dateProvider/DateProviderImpl;", "Lcom/deliveryhero/customerchat/helpers/dateProvider/DateProvider;", "()V", "timeStamp", "", "getTimeStamp", "()J", "formatTime", "", "pattern", "getFormattedDate", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DateProviderImpl implements DateProvider {
    @NotNull
    public String formatTime(long j11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Param.PATTERN);
        String format = new SimpleDateFormat(str, Locale.getDefault()).format(Long.valueOf(j11));
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\n      …      ).format(timeStamp)");
        return format;
    }

    @NotNull
    public String getFormattedDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Param.PATTERN);
        String format = new SimpleDateFormat(str, Locale.getDefault()).format(Long.valueOf(getTimeStamp()));
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\n      …      ).format(timeStamp)");
        return format;
    }

    public long getTimeStamp() {
        return new Date().getTime();
    }
}
