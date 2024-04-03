package com.google.android.gms.internal.gtm;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.internal.gtm.zzbn;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

class zzbo<T extends zzbn> extends zzam {
    private zzbp<T> zzyn;

    public zzbo(zzap zzap, zzbp<T> zzbp) {
        super(zzap);
        this.zzyn = zzbp;
    }

    private final T zza(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.US);
                    if (lowerCase.equals(ViewHierarchyConstants.SCREEN_NAME_KEY)) {
                        String attributeValue = xmlResourceParser.getAttributeValue((String) null, "name");
                        String trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(trim)) {
                            this.zzyn.zzb(attributeValue, trim);
                        }
                    } else if (lowerCase.equals(TypedValues.Custom.S_STRING)) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue((String) null, "name");
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && trim2 != null) {
                            this.zzyn.zzc(attributeValue2, trim2);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue((String) null, "name");
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(trim3)) {
                            try {
                                this.zzyn.zza(attributeValue3, Boolean.parseBoolean(trim3));
                            } catch (NumberFormatException e11) {
                                zzc("Error parsing bool configuration value", trim3, e11);
                            }
                        }
                    } else if (lowerCase.equals(TypedValues.Custom.S_INT)) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue((String) null, "name");
                        String trim4 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(trim4)) {
                            try {
                                this.zzyn.zzb(attributeValue4, Integer.parseInt(trim4));
                            } catch (NumberFormatException e12) {
                                zzc("Error parsing int configuration value", trim4, e12);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException | XmlPullParserException e13) {
            zze("Error parsing tracker configuration file", e13);
        }
        return this.zzyn.zzel();
    }

    public T zzq(int i11) {
        try {
            return zza(zzcm().zzdc().getResources().getXml(i11));
        } catch (Resources.NotFoundException e11) {
            zzd("inflate() called with unknown resourceId", e11);
            return null;
        }
    }
}
