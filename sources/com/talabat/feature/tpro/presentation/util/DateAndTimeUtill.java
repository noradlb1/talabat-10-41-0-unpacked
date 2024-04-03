package com.talabat.feature.tpro.presentation.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\n"}, d2 = {"Lcom/talabat/feature/tpro/presentation/util/DateAndTimeUtill;", "", "()V", "getPassedDaysFromDate", "", "date", "Lorg/threeten/bp/LocalDateTime;", "getRemainingDaysForDate", "getSubscriptionDisplayDate", "", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DateAndTimeUtill {
    @NotNull
    public static final DateAndTimeUtill INSTANCE = new DateAndTimeUtill();

    private DateAndTimeUtill() {
    }

    public final int getPassedDaysFromDate(@Nullable LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return -1;
        }
        Date parse = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).parse(localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        return (int) TimeUnit.DAYS.convert(new Date().getTime() - parse.getTime(), TimeUnit.MILLISECONDS);
    }

    public final int getRemainingDaysForDate(@Nullable LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return -1;
        }
        return (int) TimeUnit.DAYS.convert(new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).parse(localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))).getTime() - new Date().getTime(), TimeUnit.MILLISECONDS);
    }

    @NotNull
    public final String getSubscriptionDisplayDate(@Nullable LocalDateTime localDateTime) {
        String str;
        if (localDateTime != null) {
            str = localDateTime.format(DateTimeFormatter.ofPattern("dd LLLL yyyy"));
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
