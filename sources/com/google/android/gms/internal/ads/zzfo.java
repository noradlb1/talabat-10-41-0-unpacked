package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class zzfo {
    @Nullable
    public static String zza(XmlPullParser xmlPullParser, String str) {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i11 = 0; i11 < attributeCount; i11++) {
            if (xmlPullParser.getAttributeName(i11).equals(str)) {
                return xmlPullParser.getAttributeValue(i11);
            }
        }
        return null;
    }

    public static boolean zzb(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        if (xmlPullParser.getEventType() != 3 || !xmlPullParser.getName().equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean zzc(XmlPullParser xmlPullParser, String str) throws XmlPullParserException {
        if (xmlPullParser.getEventType() != 2 || !xmlPullParser.getName().equals(str)) {
            return false;
        }
        return true;
    }
}
