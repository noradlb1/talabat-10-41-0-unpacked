package com.google.android.gms.internal.p002firebaseauthapi;

import com.talabat.talabatcommon.utils.DateConstants;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakd  reason: invalid package */
final class zzakd extends ThreadLocal {
    public final /* synthetic */ Object initialValue() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateConstants.DEFAULT_UTC_FORMAT, Locale.ENGLISH);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(DesugarTimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
        return simpleDateFormat;
    }
}
