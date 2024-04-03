package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.compose.material3.TextFieldImplKt;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

final class zzyu {
    private static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    @Nullable
    public static zzyq zza(String str) throws IOException {
        long j11;
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            newPullParser.next();
            if (zzfo.zzc(newPullParser, "x:xmpmeta")) {
                zzfss<zzyp> zzo = zzfss.zzo();
                long j12 = -9223372036854775807L;
                do {
                    newPullParser.next();
                    if (zzfo.zzc(newPullParser, "rdf:Description")) {
                        String[] strArr = zza;
                        int i11 = 0;
                        int i12 = 0;
                        while (i12 < 4) {
                            String zza2 = zzfo.zza(newPullParser, strArr[i12]);
                            if (zza2 == null) {
                                i12++;
                            } else if (Integer.parseInt(zza2) != 1) {
                                return null;
                            } else {
                                String[] strArr2 = zzb;
                                int i13 = 0;
                                while (true) {
                                    if (i13 >= 4) {
                                        break;
                                    }
                                    String zza3 = zzfo.zza(newPullParser, strArr2[i13]);
                                    if (zza3 != null) {
                                        j11 = Long.parseLong(zza3);
                                        if (j11 == -1) {
                                        }
                                    } else {
                                        i13++;
                                    }
                                }
                                j11 = -9223372036854775807L;
                                String[] strArr3 = zzc;
                                while (true) {
                                    if (i11 >= 2) {
                                        zzo = zzfss.zzo();
                                        break;
                                    }
                                    String zza4 = zzfo.zza(newPullParser, strArr3[i11]);
                                    if (zza4 != null) {
                                        zzo = zzfss.zzq(new zzyp(MimeTypes.IMAGE_JPEG, "Primary", 0, 0), new zzyp(MimeTypes.VIDEO_MP4, "MotionPhoto", Long.parseLong(zza4), 0));
                                        break;
                                    }
                                    i11++;
                                }
                                j12 = j11;
                            }
                        }
                        return null;
                    } else if (zzfo.zzc(newPullParser, "Container:Directory")) {
                        zzo = zzb(newPullParser, TextFieldImplKt.ContainerId, "Item");
                    } else if (zzfo.zzc(newPullParser, "GContainer:Directory")) {
                        zzo = zzb(newPullParser, "GContainer", "GContainerItem");
                    }
                } while (!zzfo.zzb(newPullParser, "x:xmpmeta"));
                if (zzo.isEmpty()) {
                    return null;
                }
                return new zzyq(j12, zzo);
            }
            throw zzbj.zza("Couldn't find xmp metadata", (Throwable) null);
        } catch (zzbj | NumberFormatException | XmlPullParserException unused) {
            Log.w("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static zzfss<zzyp> zzb(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        long j11;
        long j12;
        zzfsp zzi = zzfss.zzi();
        String concat = str.concat(":Item");
        String concat2 = str.concat(":Directory");
        do {
            xmlPullParser.next();
            if (zzfo.zzc(xmlPullParser, concat)) {
                String concat3 = str2.concat(":Mime");
                String concat4 = str2.concat(":Semantic");
                String concat5 = str2.concat(":Length");
                String concat6 = str2.concat(":Padding");
                String zza2 = zzfo.zza(xmlPullParser, concat3);
                String zza3 = zzfo.zza(xmlPullParser, concat4);
                String zza4 = zzfo.zza(xmlPullParser, concat5);
                String zza5 = zzfo.zza(xmlPullParser, concat6);
                if (zza2 == null || zza3 == null) {
                    return zzfss.zzo();
                }
                if (zza4 != null) {
                    j11 = Long.parseLong(zza4);
                } else {
                    j11 = 0;
                }
                if (zza5 != null) {
                    j12 = Long.parseLong(zza5);
                } else {
                    j12 = 0;
                }
                zzi.zze(new zzyp(zza2, zza3, j11, j12));
            }
        } while (!zzfo.zzb(xmlPullParser, concat2));
        return zzi.zzf();
    }
}
