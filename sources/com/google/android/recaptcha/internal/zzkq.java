package com.google.android.recaptcha.internal;

import com.talabat.talabatcommon.utils.DateConstants;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

final class zzkq extends ThreadLocal {
    public final /* synthetic */ Object initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateConstants.DEFAULT_UTC_FORMAT, Locale.ENGLISH);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(DesugarTimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
        return simpleDateFormat;
    }
}
