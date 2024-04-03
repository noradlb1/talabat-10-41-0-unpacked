package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.net.HttpHeaders;

final class zzacb {
    @VisibleForTesting
    static final String[] zza = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final /* synthetic */ int zzb = 0;

    @Nullable
    public static zzdc zza(zzfd zzfd) {
        String str;
        String str2;
        String str3;
        int zzc = zzfd.zzc() + zzfd.zze();
        int zze = zzfd.zze();
        int i11 = (zze >> 24) & 255;
        zzdc zzdc = null;
        if (i11 == 169 || i11 == 253) {
            int i12 = zze & 16777215;
            if (i12 == 6516084) {
                int zze2 = zzfd.zze();
                if (zzfd.zze() == 1684108385) {
                    zzfd.zzG(8);
                    String zzw = zzfd.zzw(zze2 - 16);
                    zzdc = new zzzn(C.LANGUAGE_UNDETERMINED, zzw, zzw);
                } else {
                    String zzf = zzabn.zzf(zze);
                    if (zzf.length() != 0) {
                        str = "Failed to parse comment attribute: ".concat(zzf);
                    } else {
                        str = new String("Failed to parse comment attribute: ");
                    }
                    Log.w("MetadataUtil", str);
                }
                zzfd.zzF(zzc);
                return zzdc;
            } else if (i12 == 7233901 || i12 == 7631467) {
                zzaac zze3 = zze(zze, "TIT2", zzfd);
                zzfd.zzF(zzc);
                return zze3;
            } else if (i12 == 6516589 || i12 == 7828084) {
                zzaac zze4 = zze(zze, "TCOM", zzfd);
                zzfd.zzF(zzc);
                return zze4;
            } else if (i12 == 6578553) {
                zzaac zze5 = zze(zze, "TDRC", zzfd);
                zzfd.zzF(zzc);
                return zze5;
            } else if (i12 == 4280916) {
                zzaac zze6 = zze(zze, "TPE1", zzfd);
                zzfd.zzF(zzc);
                return zze6;
            } else if (i12 == 7630703) {
                zzaac zze7 = zze(zze, "TSSE", zzfd);
                zzfd.zzF(zzc);
                return zze7;
            } else if (i12 == 6384738) {
                zzaac zze8 = zze(zze, "TALB", zzfd);
                zzfd.zzF(zzc);
                return zze8;
            } else if (i12 == 7108978) {
                zzaac zze9 = zze(zze, "USLT", zzfd);
                zzfd.zzF(zzc);
                return zze9;
            } else if (i12 == 6776174) {
                zzaac zze10 = zze(zze, "TCON", zzfd);
                zzfd.zzF(zzc);
                return zze10;
            } else if (i12 == 6779504) {
                zzaac zze11 = zze(zze, "TIT1", zzfd);
                zzfd.zzF(zzc);
                return zze11;
            }
        } else if (zze == 1735291493) {
            try {
                int zzb2 = zzb(zzfd);
                if (zzb2 <= 0 || zzb2 > 192) {
                    str3 = null;
                } else {
                    str3 = zza[zzb2 - 1];
                }
                if (str3 != null) {
                    zzdc = new zzaac("TCON", (String) null, str3);
                } else {
                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                }
                return zzdc;
            } finally {
                zzfd.zzF(zzc);
            }
        } else if (zze == 1684632427) {
            zzaac zzd = zzd(1684632427, "TPOS", zzfd);
            zzfd.zzF(zzc);
            return zzd;
        } else if (zze == 1953655662) {
            zzaac zzd2 = zzd(1953655662, "TRCK", zzfd);
            zzfd.zzF(zzc);
            return zzd2;
        } else if (zze == 1953329263) {
            zzzu zzc2 = zzc(1953329263, "TBPM", zzfd, true, false);
            zzfd.zzF(zzc);
            return zzc2;
        } else if (zze == 1668311404) {
            zzzu zzc3 = zzc(1668311404, "TCMP", zzfd, true, true);
            zzfd.zzF(zzc);
            return zzc3;
        } else if (zze == 1668249202) {
            int zze12 = zzfd.zze();
            if (zzfd.zze() == 1684108385) {
                int zze13 = zzfd.zze() & 16777215;
                if (zze13 == 13) {
                    str2 = MimeTypes.IMAGE_JPEG;
                } else if (zze13 == 14) {
                    str2 = "image/png";
                    zze13 = 14;
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    StringBuilder sb2 = new StringBuilder(41);
                    sb2.append("Unrecognized cover art flags: ");
                    sb2.append(zze13);
                    Log.w("MetadataUtil", sb2.toString());
                } else {
                    zzfd.zzG(4);
                    int i13 = zze12 - 16;
                    byte[] bArr = new byte[i13];
                    zzfd.zzB(bArr, 0, i13);
                    zzdc = new zzzf(str2, (String) null, 3, bArr);
                }
            } else {
                Log.w("MetadataUtil", "Failed to parse cover art attribute");
            }
            zzfd.zzF(zzc);
            return zzdc;
        } else if (zze == 1631670868) {
            zzaac zze14 = zze(1631670868, "TPE2", zzfd);
            zzfd.zzF(zzc);
            return zze14;
        } else if (zze == 1936682605) {
            zzaac zze15 = zze(1936682605, "TSOT", zzfd);
            zzfd.zzF(zzc);
            return zze15;
        } else if (zze == 1936679276) {
            zzaac zze16 = zze(1936679276, "TSO2", zzfd);
            zzfd.zzF(zzc);
            return zze16;
        } else if (zze == 1936679282) {
            zzaac zze17 = zze(1936679282, "TSOA", zzfd);
            zzfd.zzF(zzc);
            return zze17;
        } else if (zze == 1936679265) {
            zzaac zze18 = zze(1936679265, "TSOP", zzfd);
            zzfd.zzF(zzc);
            return zze18;
        } else if (zze == 1936679791) {
            zzaac zze19 = zze(1936679791, "TSOC", zzfd);
            zzfd.zzF(zzc);
            return zze19;
        } else if (zze == 1920233063) {
            zzzu zzc4 = zzc(1920233063, "ITUNESADVISORY", zzfd, false, false);
            zzfd.zzF(zzc);
            return zzc4;
        } else if (zze == 1885823344) {
            zzzu zzc5 = zzc(1885823344, "ITUNESGAPLESS", zzfd, false, true);
            zzfd.zzF(zzc);
            return zzc5;
        } else if (zze == 1936683886) {
            zzaac zze20 = zze(1936683886, "TVSHOWSORT", zzfd);
            zzfd.zzF(zzc);
            return zze20;
        } else if (zze == 1953919848) {
            zzaac zze21 = zze(1953919848, "TVSHOW", zzfd);
            zzfd.zzF(zzc);
            return zze21;
        } else if (zze == 757935405) {
            int i14 = -1;
            int i15 = -1;
            String str4 = null;
            String str5 = null;
            while (zzfd.zzc() < zzc) {
                int zzc6 = zzfd.zzc();
                int zze22 = zzfd.zze();
                int zze23 = zzfd.zze();
                zzfd.zzG(4);
                if (zze23 == 1835360622) {
                    str4 = zzfd.zzw(zze22 - 12);
                } else if (zze23 == 1851878757) {
                    str5 = zzfd.zzw(zze22 - 12);
                } else {
                    if (zze23 == 1684108385) {
                        i15 = zze22;
                    }
                    if (zze23 == 1684108385) {
                        i14 = zzc6;
                    }
                    zzfd.zzG(zze22 - 12);
                }
            }
            if (!(str4 == null || str5 == null)) {
                if (i14 != -1) {
                    zzfd.zzF(i14);
                    zzfd.zzG(16);
                    zzdc = new zzzw(str4, str5, zzfd.zzw(i15 - 16));
                }
            }
            zzfd.zzF(zzc);
            return zzdc;
        }
        String zzf2 = zzabn.zzf(zze);
        if (zzf2.length() != 0) {
            "Skipped unknown metadata entry: ".concat(zzf2);
        }
        zzfd.zzF(zzc);
        return null;
    }

    private static int zzb(zzfd zzfd) {
        zzfd.zzG(4);
        if (zzfd.zze() == 1684108385) {
            zzfd.zzG(8);
            return zzfd.zzk();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    @Nullable
    private static zzzu zzc(int i11, String str, zzfd zzfd, boolean z11, boolean z12) {
        String str2;
        int zzb2 = zzb(zzfd);
        if (z12) {
            zzb2 = Math.min(1, zzb2);
        }
        if (zzb2 < 0) {
            String zzf = zzabn.zzf(i11);
            if (zzf.length() != 0) {
                str2 = "Failed to parse uint8 attribute: ".concat(zzf);
            } else {
                str2 = new String("Failed to parse uint8 attribute: ");
            }
            Log.w("MetadataUtil", str2);
            return null;
        } else if (z11) {
            return new zzaac(str, (String) null, Integer.toString(zzb2));
        } else {
            return new zzzn(C.LANGUAGE_UNDETERMINED, str, Integer.toString(zzb2));
        }
    }

    @Nullable
    private static zzaac zzd(int i11, String str, zzfd zzfd) {
        String str2;
        int zze = zzfd.zze();
        if (zzfd.zze() == 1684108385 && zze >= 22) {
            zzfd.zzG(10);
            int zzo = zzfd.zzo();
            if (zzo > 0) {
                StringBuilder sb2 = new StringBuilder(11);
                sb2.append(zzo);
                String sb3 = sb2.toString();
                int zzo2 = zzfd.zzo();
                if (zzo2 > 0) {
                    StringBuilder sb4 = new StringBuilder(sb3.length() + 12);
                    sb4.append(sb3);
                    sb4.append("/");
                    sb4.append(zzo2);
                    sb3 = sb4.toString();
                }
                return new zzaac(str, (String) null, sb3);
            }
        }
        String zzf = zzabn.zzf(i11);
        if (zzf.length() != 0) {
            str2 = "Failed to parse index/count attribute: ".concat(zzf);
        } else {
            str2 = new String("Failed to parse index/count attribute: ");
        }
        Log.w("MetadataUtil", str2);
        return null;
    }

    @Nullable
    private static zzaac zze(int i11, String str, zzfd zzfd) {
        String str2;
        int zze = zzfd.zze();
        if (zzfd.zze() == 1684108385) {
            zzfd.zzG(8);
            return new zzaac(str, (String) null, zzfd.zzw(zze - 16));
        }
        String zzf = zzabn.zzf(i11);
        if (zzf.length() != 0) {
            str2 = "Failed to parse text attribute: ".concat(zzf);
        } else {
            str2 = new String("Failed to parse text attribute: ");
        }
        Log.w("MetadataUtil", str2);
        return null;
    }
}
