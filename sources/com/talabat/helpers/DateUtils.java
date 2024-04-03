package com.talabat.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/helpers/DateUtils;", "", "()V", "currentTimeInMillis", "", "getDateFromString", "Ljava/util/Date;", "stringDate", "", "format", "getStringFromDate", "date", "isDateInBetween", "", "start", "end", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DateUtils {
    public final long currentTimeInMillis() {
        return System.currentTimeMillis();
    }

    @NotNull
    public final Date getDateFromString(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "stringDate");
        Intrinsics.checkNotNullParameter(str2, "format");
        Date parse = new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
        Intrinsics.checkNotNull(parse);
        return parse;
    }

    @NotNull
    public final String getStringFromDate(@NotNull Date date, @NotNull String str) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(str, "format");
        String format = new SimpleDateFormat(str, Locale.getDefault()).format(date);
        Intrinsics.checkNotNull(format);
        return format;
    }

    public final boolean isDateInBetween(@NotNull Date date, @NotNull Date date2, @NotNull Date date3) {
        Intrinsics.checkNotNullParameter(date, "start");
        Intrinsics.checkNotNullParameter(date2, TtmlNode.END);
        Intrinsics.checkNotNullParameter(date3, "date");
        if (!date3.after(date) || !date3.before(date2)) {
            return false;
        }
        return true;
    }
}
