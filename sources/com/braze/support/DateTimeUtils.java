package com.braze.support;

import com.braze.enums.BrazeDateFormat;
import com.braze.support.BrazeLogger;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a>\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\bH\u0007\u001a\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0006\u0010\u0012\u001a\u00020\u0001\u001a\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u0006\u0010\u0014\u001a\u00020\u0015\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0001\u001a\u001e\u0010\u0016\u001a\u00020\u000f*\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u0003H\u0007\u001a\n\u0010\u0018\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u0019\u001a\u00020\u001a*\u00020\u000f\u001a\u0012\u0010\u001b\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"MSECS_IN_SEC", "", "UTC_TIME_ZONE", "Ljava/util/TimeZone;", "kotlin.jvm.PlatformType", "createDate", "Ljava/util/Date;", "year", "", "month", "day", "hours", "minutes", "seconds", "formatDateNow", "", "dateFormat", "Lcom/braze/enums/BrazeDateFormat;", "nowInMilliseconds", "nowInSeconds", "nowInSecondsPrecise", "", "formatDate", "timeZone", "getTimeFromEpochInSeconds", "isValidTimeZone", "", "parseDate", "android-sdk-base_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DateTimeUtils {
    private static final long MSECS_IN_SEC = 1000;
    private static final TimeZone UTC_TIME_ZONE = DesugarTimeZone.getTimeZone("UTC");

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43940g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(0);
            this.f43940g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception parsing date " + this.f43940g + ". Returning null";
        }
    }

    public static final Date createDate(int i11, int i12, int i13) {
        return createDate$default(i11, i12, i13, 0, 0, 0, 56, (Object) null);
    }

    public static final Date createDate(int i11, int i12, int i13, int i14) {
        return createDate$default(i11, i12, i13, i14, 0, 0, 48, (Object) null);
    }

    public static final Date createDate(int i11, int i12, int i13, int i14, int i15) {
        return createDate$default(i11, i12, i13, i14, i15, 0, 32, (Object) null);
    }

    public static final Date createDate(int i11, int i12, int i13, int i14, int i15, int i16) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(i11, i12, i13, i14, i15, i16);
        gregorianCalendar.setTimeZone(UTC_TIME_ZONE);
        Date time = gregorianCalendar.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
        return time;
    }

    public static /* synthetic */ Date createDate$default(int i11, int i12, int i13, int i14, int i15, int i16, int i17, Object obj) {
        return createDate(i11, i12, i13, (i17 & 8) != 0 ? 0 : i14, (i17 & 16) != 0 ? 0 : i15, (i17 & 32) != 0 ? 0 : i16);
    }

    public static final String formatDate(Date date, BrazeDateFormat brazeDateFormat) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(brazeDateFormat, "dateFormat");
        return formatDate$default(date, brazeDateFormat, (TimeZone) null, 2, (Object) null);
    }

    public static final String formatDate(Date date, BrazeDateFormat brazeDateFormat, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(brazeDateFormat, "dateFormat");
        Intrinsics.checkNotNullParameter(timeZone, RemoteConfigConstants.RequestFieldKey.TIME_ZONE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(brazeDateFormat.getFormat(), Locale.US);
        simpleDateFormat.setTimeZone(timeZone);
        String format = simpleDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(format, "simpleDateFormat.format(this)");
        return format;
    }

    public static /* synthetic */ String formatDate$default(Date date, BrazeDateFormat brazeDateFormat, TimeZone timeZone, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            timeZone = UTC_TIME_ZONE;
            Intrinsics.checkNotNullExpressionValue(timeZone, "UTC_TIME_ZONE");
        }
        return formatDate(date, brazeDateFormat, timeZone);
    }

    public static final String formatDateNow(BrazeDateFormat brazeDateFormat) {
        Intrinsics.checkNotNullParameter(brazeDateFormat, "dateFormat");
        Date createDate = createDate(nowInSeconds());
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault()");
        return formatDate(createDate, brazeDateFormat, timeZone);
    }

    public static final long getTimeFromEpochInSeconds(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return TimeUnit.MILLISECONDS.toSeconds(date.getTime());
    }

    public static final boolean isValidTimeZone(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String[] availableIDs = TimeZone.getAvailableIDs();
        Intrinsics.checkNotNullExpressionValue(availableIDs, "getAvailableIDs()");
        return ArraysKt___ArraysKt.contains((T[]) availableIDs, str);
    }

    public static final long nowInMilliseconds() {
        return System.currentTimeMillis();
    }

    public static final long nowInSeconds() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    public static final double nowInSecondsPrecise() {
        return ((double) System.currentTimeMillis()) / 1000.0d;
    }

    public static final Date parseDate(String str, BrazeDateFormat brazeDateFormat) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(brazeDateFormat, "dateFormat");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(brazeDateFormat.getFormat(), Locale.US);
        simpleDateFormat.setTimeZone(UTC_TIME_ZONE);
        try {
            Date parse = simpleDateFormat.parse(str);
            Intrinsics.checkNotNull(parse);
            return parse;
        } catch (Exception e11) {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, brazeLogger.getBrazeLogTag("DateTimeUtils"), BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new a(str), 8, (Object) null);
            throw e11;
        }
    }

    public static final Date createDate(long j11) {
        return new Date(j11 * 1000);
    }
}
