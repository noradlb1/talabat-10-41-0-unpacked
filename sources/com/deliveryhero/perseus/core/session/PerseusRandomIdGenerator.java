package com.deliveryhero.perseus.core.session;

import j$.util.concurrent.ThreadLocalRandom;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002¨\u0006\b"}, d2 = {"Lcom/deliveryhero/perseus/core/session/PerseusRandomIdGenerator;", "", "()V", "createUniqueIdentifier", "", "generateRandomNumber", "", "getAlphaNumericString", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusRandomIdGenerator {
    @NotNull
    public static final PerseusRandomIdGenerator INSTANCE = new PerseusRandomIdGenerator();

    private PerseusRandomIdGenerator() {
    }

    @JvmStatic
    @NotNull
    public static final String createUniqueIdentifier() {
        PerseusRandomIdGenerator perseusRandomIdGenerator = INSTANCE;
        String valueOf = String.valueOf(perseusRandomIdGenerator.generateRandomNumber());
        return Calendar.getInstance().getTimeInMillis() + '.' + valueOf + '.' + perseusRandomIdGenerator.getAlphaNumericString();
    }

    private final long generateRandomNumber() {
        long pow = (long) Math.pow(10.0d, 17.0d);
        return ThreadLocalRandom.current().nextLong(pow, ((long) 10) * pow);
    }

    private final String getAlphaNumericString() {
        boolean z11;
        boolean z12;
        byte[] bArr = new byte[256];
        new Random().nextBytes(bArr);
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
        String str = new String(bArr, forName);
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i11 = 10;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            boolean z13 = true;
            if ('a' > charAt || charAt >= '{') {
                z11 = false;
            } else {
                z11 = true;
            }
            if (!z11) {
                if ('A' > charAt || charAt >= '[') {
                    z12 = false;
                } else {
                    z12 = true;
                }
                if (!z12) {
                    if ('0' > charAt || charAt >= ':') {
                        z13 = false;
                    }
                    if (!z13) {
                    }
                }
            }
            if (i11 > 0) {
                stringBuffer.append(charAt);
                i11--;
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "r.toString()");
        return stringBuffer2;
    }
}
