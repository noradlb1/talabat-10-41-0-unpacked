package com.talabat.talabatcommon.utils;

import android.util.Log;
import com.huawei.hms.flutter.map.constants.Param;
import com.integration.IntegrationGlobalDataModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/talabatcommon/utils/DateUtils;", "", "()V", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DateUtils {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EMPTY_STRING = "";
    @NotNull
    public static final String TAG = "DateUtils";

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0018\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/utils/DateUtils$Companion;", "", "()V", "EMPTY_STRING", "", "TAG", "convertFromDateToString", "date", "Ljava/util/Date;", "pattern", "convertFromStringToDate", "dtString", "getFormattedDateString", "dateString", "datePattern", "getLocalizedFormattedDateAfterDurationDays", "durationDays", "", "getLocalizedFormattedDateString", "outputFormat", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String convertFromDateToString(@NotNull Date date, @NotNull String str) {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(str, Param.PATTERN);
            try {
                String format = new SimpleDateFormat(str, Locale.getDefault()).format(date);
                Intrinsics.checkNotNullExpressionValue(format, "{\n                Simple…ormat(date)\n            }");
                return format;
            } catch (ParseException e11) {
                Log.e(DateUtils.TAG, Log.getStackTraceString(e11));
                return "";
            }
        }

        @Nullable
        public final Date convertFromStringToDate(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "dtString");
            Intrinsics.checkNotNullParameter(str2, Param.PATTERN);
            try {
                return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
            } catch (Throwable unused) {
                return null;
            }
        }

        @NotNull
        public final String getFormattedDateString(@NotNull String str, @NotNull String str2) {
            String convertFromDateToString;
            Intrinsics.checkNotNullParameter(str, "dateString");
            Intrinsics.checkNotNullParameter(str2, "datePattern");
            Date convertFromStringToDate = convertFromStringToDate(str, DateConstants.DEFAULT_UTC_FORMAT);
            if (convertFromStringToDate == null || (convertFromDateToString = DateUtils.Companion.convertFromDateToString(convertFromStringToDate, str2)) == null) {
                return str;
            }
            return convertFromDateToString;
        }

        @NotNull
        public final String getLocalizedFormattedDateAfterDurationDays(int i11) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
            String format = simpleDateFormat.format(new Date());
            Calendar instance = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
            instance.setTime(simpleDateFormat.parse(format));
            instance.add(5, i11);
            String format2 = simpleDateFormat.format(new Date(instance.getTimeInMillis()));
            Intrinsics.checkNotNullExpressionValue(format2, "sdf.format(resultDate)");
            return format2;
        }

        @NotNull
        public final String getLocalizedFormattedDateString(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "date");
            Intrinsics.checkNotNullParameter(str2, "outputFormat");
            try {
                Date parse = new SimpleDateFormat(DateConstants.DEFAULT_UTC_FORMAT, Locale.ENGLISH).parse(str);
                Calendar instance = Calendar.getInstance();
                instance.setTime(parse);
                if (IntegrationGlobalDataModel.Companion.isArabic()) {
                    String format = new SimpleDateFormat(str2, new Locale(ArchiveStreamFactory.AR)).format(instance.getTime());
                    Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(outputF…e(\"ar\")).format(cal.time)");
                    return format;
                }
                String format2 = new SimpleDateFormat(str2, new Locale("en")).format(instance.getTime());
                Intrinsics.checkNotNullExpressionValue(format2, "SimpleDateFormat(outputF…e(\"en\")).format(cal.time)");
                return format2;
            } catch (Exception unused) {
                return "";
            }
        }
    }
}
