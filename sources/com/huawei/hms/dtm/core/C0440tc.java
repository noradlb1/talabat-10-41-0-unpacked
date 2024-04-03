package com.huawei.hms.dtm.core;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.dtm.core.safe.SafeString;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.math.BigDecimal;

/* renamed from: com.huawei.hms.dtm.core.tc  reason: case insensitive filesystem */
public class C0440tc extends Dc<Double> {
    public C0440tc(Double d11) {
        super(d11);
    }

    public boolean b() {
        return value() != null && !Double.isNaN(((Double) value()).doubleValue()) && !((Double) value()).equals(Double.valueOf(0.0d)) && !((Double) value()).equals(Double.valueOf(-0.0d));
    }

    public Double c() {
        return (Double) value();
    }

    public String toString() {
        String str;
        BigDecimal bigDecimal;
        String valueOf = String.valueOf(value());
        if (!valueOf.contains(ExifInterface.LONGITUDE_EAST)) {
            return valueOf.endsWith(".0") ? valueOf.equals("-0.0") ? "0" : SafeString.substring(valueOf, 0, valueOf.indexOf(RealDiscoveryConfigurationRepository.VERSION_DELIMETER)) : valueOf;
        }
        try {
            int parseInt = Integer.parseInt(SafeString.substring(valueOf, valueOf.indexOf(ExifInterface.LONGITUDE_EAST) + 1));
            if (parseInt > 0) {
                if (parseInt < 21) {
                    bigDecimal = new BigDecimal(valueOf);
                } else {
                    str = "e+";
                    return valueOf.replace(ExifInterface.LONGITUDE_EAST, str);
                }
            } else if (parseInt > -7) {
                bigDecimal = new BigDecimal(valueOf);
            } else {
                str = "e";
                return valueOf.replace(ExifInterface.LONGITUDE_EAST, str);
            }
            return bigDecimal.toPlainString();
        } catch (NumberFormatException unused) {
            return valueOf;
        }
    }
}
