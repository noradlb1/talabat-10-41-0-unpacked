package com.huawei.hms.push.utils;

import com.huawei.hms.support.log.HMSLog;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateUtil {
    private DateUtil() {
    }

    public static String parseMilliSecondToString(Long l11) {
        if (l11 == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(l11);
        } catch (Exception e11) {
            HMSLog.e("DateUtil", "parseMilliSecondToString Exception.", (Throwable) e11);
            return null;
        }
    }

    public static long parseUtcToMillisecond(String str) throws ParseException, StringIndexOutOfBoundsException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        String substring = str.substring(0, str.indexOf(RealDiscoveryConfigurationRepository.VERSION_DELIMETER));
        String substring2 = str.substring(str.indexOf(RealDiscoveryConfigurationRepository.VERSION_DELIMETER));
        return simpleDateFormat.parse(substring + (substring2.substring(0, 4) + "Z")).getTime();
    }
}
