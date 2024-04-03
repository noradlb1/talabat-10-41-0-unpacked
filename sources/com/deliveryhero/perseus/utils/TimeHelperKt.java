package com.deliveryhero.perseus.utils;

import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"createTimeStamp", "", "date", "Ljava/util/Calendar;", "Ljava/util/Date;", "timeZone", "Ljava/util/TimeZone;", "perseus_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TimeHelperKt {
    @NotNull
    public static final String createTimeStamp(@NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "date");
        Date time = calendar.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "date.time");
        TimeZone timeZone = calendar.getTimeZone();
        Intrinsics.checkNotNullExpressionValue(timeZone, "date.timeZone");
        return createTimeStamp(time, timeZone);
    }

    public static /* synthetic */ String createTimeStamp$default(Date date, TimeZone timeZone, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            timeZone = DesugarTimeZone.getTimeZone("UTC");
            Intrinsics.checkNotNullExpressionValue(timeZone, "getTimeZone(\"UTC\")");
        }
        return createTimeStamp(date, timeZone);
    }

    @NotNull
    public static final String createTimeStamp(@NotNull Date date, @NotNull TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(timeZone, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.'SSSSSSZ", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(timeZone);
        String format = simpleDateFormat.format(date);
        String sb2 = new StringBuilder(format).insert(format.length() - 2, CertificateUtil.DELIMITER).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(output).in…ngth - 2, \":\").toString()");
        return sb2;
    }
}
