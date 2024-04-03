package com.google.zxing.client.result;

import androidx.core.net.MailTo;
import java.util.List;

public final class VEventResultParser extends ResultParser {
    private static String matchSingleVCardPrefixedField(CharSequence charSequence, String str, boolean z11) {
        List<String> matchSingleVCardPrefixedField = VCardResultParser.matchSingleVCardPrefixedField(charSequence, str, z11, false);
        if (matchSingleVCardPrefixedField == null || matchSingleVCardPrefixedField.isEmpty()) {
            return null;
        }
        return matchSingleVCardPrefixedField.get(0);
    }

    private static String[] matchVCardPrefixedField(CharSequence charSequence, String str, boolean z11) {
        List<List<String>> matchVCardPrefixedField = VCardResultParser.matchVCardPrefixedField(charSequence, str, z11, false);
        if (matchVCardPrefixedField == null || matchVCardPrefixedField.isEmpty()) {
            return null;
        }
        int size = matchVCardPrefixedField.size();
        String[] strArr = new String[size];
        for (int i11 = 0; i11 < size; i11++) {
            strArr[i11] = (String) matchVCardPrefixedField.get(i11).get(0);
        }
        return strArr;
    }

    private static String stripMailto(String str) {
        if (str == null) {
            return str;
        }
        if (str.startsWith(MailTo.MAILTO_SCHEME) || str.startsWith("MAILTO:")) {
            return str.substring(7);
        }
        return str;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.zxing.client.result.CalendarParsedResult parse(com.google.zxing.Result r18) {
        /*
            r17 = this;
            java.lang.String r0 = com.google.zxing.client.result.ResultParser.getMassagedText(r18)
            java.lang.String r1 = "BEGIN:VEVENT"
            int r1 = r0.indexOf(r1)
            r2 = 0
            if (r1 >= 0) goto L_0x000e
            return r2
        L_0x000e:
            java.lang.String r1 = "SUMMARY"
            r3 = 1
            java.lang.String r5 = matchSingleVCardPrefixedField(r1, r0, r3)
            java.lang.String r1 = "DTSTART"
            java.lang.String r6 = matchSingleVCardPrefixedField(r1, r0, r3)
            if (r6 != 0) goto L_0x001e
            return r2
        L_0x001e:
            java.lang.String r1 = "DTEND"
            java.lang.String r7 = matchSingleVCardPrefixedField(r1, r0, r3)
            java.lang.String r1 = "DURATION"
            java.lang.String r8 = matchSingleVCardPrefixedField(r1, r0, r3)
            java.lang.String r1 = "LOCATION"
            java.lang.String r9 = matchSingleVCardPrefixedField(r1, r0, r3)
            java.lang.String r1 = "ORGANIZER"
            java.lang.String r1 = matchSingleVCardPrefixedField(r1, r0, r3)
            java.lang.String r10 = stripMailto(r1)
            java.lang.String r1 = "ATTENDEE"
            java.lang.String[] r11 = matchVCardPrefixedField(r1, r0, r3)
            r1 = 0
            if (r11 == 0) goto L_0x0052
            r4 = r1
        L_0x0044:
            int r12 = r11.length
            if (r4 >= r12) goto L_0x0052
            r12 = r11[r4]
            java.lang.String r12 = stripMailto(r12)
            r11[r4] = r12
            int r4 = r4 + 1
            goto L_0x0044
        L_0x0052:
            java.lang.String r4 = "DESCRIPTION"
            java.lang.String r12 = matchSingleVCardPrefixedField(r4, r0, r3)
            java.lang.String r4 = "GEO"
            java.lang.String r0 = matchSingleVCardPrefixedField(r4, r0, r3)
            if (r0 != 0) goto L_0x0065
            r0 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r13 = r0
            r15 = r13
            goto L_0x0080
        L_0x0065:
            r4 = 59
            int r4 = r0.indexOf(r4)
            if (r4 >= 0) goto L_0x006e
            return r2
        L_0x006e:
            java.lang.String r1 = r0.substring(r1, r4)     // Catch:{ NumberFormatException -> 0x0087 }
            double r13 = java.lang.Double.parseDouble(r1)     // Catch:{ NumberFormatException -> 0x0087 }
            int r4 = r4 + r3
            java.lang.String r0 = r0.substring(r4)     // Catch:{ NumberFormatException -> 0x0087 }
            double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x0087 }
            r15 = r0
        L_0x0080:
            com.google.zxing.client.result.CalendarParsedResult r0 = new com.google.zxing.client.result.CalendarParsedResult     // Catch:{  }
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r15)     // Catch:{  }
            return r0
        L_0x0087:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.VEventResultParser.parse(com.google.zxing.Result):com.google.zxing.client.result.CalendarParsedResult");
    }
}
