package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.common.net.HttpHeaders;

final class zzast {
    private static final int zzA = zzaxb.zzg("sosn");
    private static final int zzB = zzaxb.zzg("tvsh");
    private static final int zzC = zzaxb.zzg(InternalFrame.ID);
    private static final String[] zzD = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};
    private static final int zza = zzaxb.zzg("nam");
    private static final int zzb = zzaxb.zzg("trk");
    private static final int zzc = zzaxb.zzg("cmt");
    private static final int zzd = zzaxb.zzg("day");
    private static final int zze = zzaxb.zzg("ART");
    private static final int zzf = zzaxb.zzg("too");
    private static final int zzg = zzaxb.zzg("alb");
    private static final int zzh = zzaxb.zzg("com");
    private static final int zzi = zzaxb.zzg("wrt");
    private static final int zzj = zzaxb.zzg("lyr");
    private static final int zzk = zzaxb.zzg("gen");
    private static final int zzl = zzaxb.zzg("covr");
    private static final int zzm = zzaxb.zzg("gnre");
    private static final int zzn = zzaxb.zzg("grp");
    private static final int zzo = zzaxb.zzg("disk");
    private static final int zzp = zzaxb.zzg("trkn");
    private static final int zzq = zzaxb.zzg("tmpo");
    private static final int zzr = zzaxb.zzg("cpil");
    private static final int zzs = zzaxb.zzg("aART");
    private static final int zzt = zzaxb.zzg("sonm");
    private static final int zzu = zzaxb.zzg("soal");
    private static final int zzv = zzaxb.zzg("soar");
    private static final int zzw = zzaxb.zzg("soaa");
    private static final int zzx = zzaxb.zzg("soco");
    private static final int zzy = zzaxb.zzg("rtng");
    private static final int zzz = zzaxb.zzg("pgap");

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035 A[Catch:{ all -> 0x01d6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c A[Catch:{ all -> 0x01d6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzatq zza(com.google.android.gms.internal.ads.zzawu r14) {
        /*
            int r0 = r14.zzc()
            int r1 = r14.zze()
            int r0 = r0 + r1
            int r1 = r14.zze()
            int r2 = r1 >> 24
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 169(0xa9, float:2.37E-43)
            java.lang.String r4 = "und"
            java.lang.String r5 = "TCON"
            java.lang.String r6 = "MetadataUtil"
            r7 = 0
            if (r2 == r3) goto L_0x01d9
            int r2 = zzm     // Catch:{ all -> 0x01d6 }
            r3 = -1
            if (r1 != r2) goto L_0x0045
            int r1 = zzb(r14)     // Catch:{ all -> 0x01d6 }
            if (r1 <= 0) goto L_0x0032
            java.lang.String[] r2 = zzD     // Catch:{ all -> 0x01d6 }
            int r4 = r2.length     // Catch:{ all -> 0x01d6 }
            r4 = 148(0x94, float:2.07E-43)
            if (r1 > r4) goto L_0x0032
            int r1 = r1 + r3
            r1 = r2[r1]     // Catch:{ all -> 0x01d6 }
            goto L_0x0033
        L_0x0032:
            r1 = r7
        L_0x0033:
            if (r1 == 0) goto L_0x003c
            com.google.android.gms.internal.ads.zzatz r2 = new com.google.android.gms.internal.ads.zzatz     // Catch:{ all -> 0x01d6 }
            r2.<init>(r5, r7, r1)     // Catch:{ all -> 0x01d6 }
            r7 = r2
            goto L_0x0041
        L_0x003c:
            java.lang.String r1 = "Failed to parse standard genre code"
            android.util.Log.w(r6, r1)     // Catch:{ all -> 0x01d6 }
        L_0x0041:
            r14.zzv(r0)
            return r7
        L_0x0045:
            int r2 = zzo     // Catch:{ all -> 0x01d6 }
            if (r1 != r2) goto L_0x0053
            java.lang.String r2 = "TPOS"
            com.google.android.gms.internal.ads.zzatz r1 = zzd(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x0053:
            int r2 = zzp     // Catch:{ all -> 0x01d6 }
            if (r1 != r2) goto L_0x0061
            java.lang.String r2 = "TRCK"
            com.google.android.gms.internal.ads.zzatz r1 = zzd(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x0061:
            int r2 = zzq     // Catch:{ all -> 0x01d6 }
            r5 = 1
            r8 = 0
            if (r1 != r2) goto L_0x0071
            java.lang.String r2 = "TBPM"
            com.google.android.gms.internal.ads.zzatx r1 = zzc(r1, r2, r14, r5, r8)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x0071:
            int r2 = zzr     // Catch:{ all -> 0x01d6 }
            if (r1 != r2) goto L_0x007f
            java.lang.String r2 = "TCMP"
            com.google.android.gms.internal.ads.zzatx r1 = zzc(r1, r2, r14, r5, r5)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x007f:
            int r2 = zzl     // Catch:{ all -> 0x01d6 }
            r9 = 4
            if (r1 != r2) goto L_0x00de
            int r1 = r14.zze()     // Catch:{ all -> 0x01d6 }
            int r2 = r14.zze()     // Catch:{ all -> 0x01d6 }
            int r3 = com.google.android.gms.internal.ads.zzasg.zzaH     // Catch:{ all -> 0x01d6 }
            if (r2 != r3) goto L_0x00d5
            int r2 = r14.zze()     // Catch:{ all -> 0x01d6 }
            int r2 = com.google.android.gms.internal.ads.zzasg.zze(r2)     // Catch:{ all -> 0x01d6 }
            r3 = 13
            if (r2 != r3) goto L_0x009f
            java.lang.String r3 = "image/jpeg"
            goto L_0x00aa
        L_0x009f:
            r3 = 14
            if (r2 != r3) goto L_0x00a9
            java.lang.String r2 = "image/png"
            r13 = r3
            r3 = r2
            r2 = r13
            goto L_0x00aa
        L_0x00a9:
            r3 = r7
        L_0x00aa:
            if (r3 != 0) goto L_0x00c3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d6 }
            r3 = 41
            r1.<init>(r3)     // Catch:{ all -> 0x01d6 }
            java.lang.String r3 = "Unrecognized cover art flags: "
            r1.append(r3)     // Catch:{ all -> 0x01d6 }
            r1.append(r2)     // Catch:{ all -> 0x01d6 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d6 }
            android.util.Log.w(r6, r1)     // Catch:{ all -> 0x01d6 }
            goto L_0x00da
        L_0x00c3:
            r14.zzw(r9)     // Catch:{ all -> 0x01d6 }
            int r1 = r1 + -16
            byte[] r2 = new byte[r1]     // Catch:{ all -> 0x01d6 }
            r14.zzq(r2, r8, r1)     // Catch:{ all -> 0x01d6 }
            com.google.android.gms.internal.ads.zzatt r1 = new com.google.android.gms.internal.ads.zzatt     // Catch:{ all -> 0x01d6 }
            r4 = 3
            r1.<init>(r3, r7, r4, r2)     // Catch:{ all -> 0x01d6 }
            r7 = r1
            goto L_0x00da
        L_0x00d5:
            java.lang.String r1 = "Failed to parse cover art attribute"
            android.util.Log.w(r6, r1)     // Catch:{ all -> 0x01d6 }
        L_0x00da:
            r14.zzv(r0)
            return r7
        L_0x00de:
            int r2 = zzs     // Catch:{ all -> 0x01d6 }
            if (r1 != r2) goto L_0x00ec
            java.lang.String r2 = "TPE2"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x00ec:
            int r2 = zzt     // Catch:{ all -> 0x01d6 }
            if (r1 != r2) goto L_0x00fa
            java.lang.String r2 = "TSOT"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x00fa:
            int r2 = zzu     // Catch:{ all -> 0x01d6 }
            if (r1 != r2) goto L_0x0108
            java.lang.String r2 = "TSO2"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x0108:
            int r2 = zzv     // Catch:{ all -> 0x01d6 }
            if (r1 != r2) goto L_0x0116
            java.lang.String r2 = "TSOA"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x0116:
            int r2 = zzw     // Catch:{ all -> 0x01d6 }
            if (r1 != r2) goto L_0x0124
            java.lang.String r2 = "TSOP"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x0124:
            int r2 = zzx     // Catch:{ all -> 0x01d6 }
            if (r1 != r2) goto L_0x0132
            java.lang.String r2 = "TSOC"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x0132:
            int r2 = zzy     // Catch:{ all -> 0x01d6 }
            if (r1 != r2) goto L_0x0140
            java.lang.String r2 = "ITUNESADVISORY"
            com.google.android.gms.internal.ads.zzatx r1 = zzc(r1, r2, r14, r8, r8)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x0140:
            int r2 = zzz     // Catch:{ all -> 0x01d6 }
            if (r1 != r2) goto L_0x014e
            java.lang.String r2 = "ITUNESGAPLESS"
            com.google.android.gms.internal.ads.zzatx r1 = zzc(r1, r2, r14, r8, r5)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x014e:
            int r2 = zzA     // Catch:{ all -> 0x01d6 }
            if (r1 != r2) goto L_0x015c
            java.lang.String r2 = "TVSHOWSORT"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x015c:
            int r2 = zzB     // Catch:{ all -> 0x01d6 }
            if (r1 != r2) goto L_0x016a
            java.lang.String r2 = "TVSHOW"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x016a:
            int r2 = zzC     // Catch:{ all -> 0x01d6 }
            if (r1 != r2) goto L_0x028e
            r5 = r3
            r6 = r5
            r1 = r7
            r2 = r1
        L_0x0172:
            int r8 = r14.zzc()     // Catch:{ all -> 0x01d6 }
            if (r8 >= r0) goto L_0x01ac
            int r8 = r14.zzc()     // Catch:{ all -> 0x01d6 }
            int r10 = r14.zze()     // Catch:{ all -> 0x01d6 }
            int r11 = r14.zze()     // Catch:{ all -> 0x01d6 }
            r14.zzw(r9)     // Catch:{ all -> 0x01d6 }
            int r12 = com.google.android.gms.internal.ads.zzasg.zzaF     // Catch:{ all -> 0x01d6 }
            if (r11 != r12) goto L_0x0192
            int r10 = r10 + -12
            java.lang.String r1 = r14.zzo(r10)     // Catch:{ all -> 0x01d6 }
            goto L_0x0172
        L_0x0192:
            int r12 = com.google.android.gms.internal.ads.zzasg.zzaG     // Catch:{ all -> 0x01d6 }
            if (r11 != r12) goto L_0x019d
            int r10 = r10 + -12
            java.lang.String r2 = r14.zzo(r10)     // Catch:{ all -> 0x01d6 }
            goto L_0x0172
        L_0x019d:
            int r12 = com.google.android.gms.internal.ads.zzasg.zzaH     // Catch:{ all -> 0x01d6 }
            if (r11 != r12) goto L_0x01a2
            r6 = r10
        L_0x01a2:
            if (r11 == r12) goto L_0x01a5
            goto L_0x01a6
        L_0x01a5:
            r5 = r8
        L_0x01a6:
            int r10 = r10 + -12
            r14.zzw(r10)     // Catch:{ all -> 0x01d6 }
            goto L_0x0172
        L_0x01ac:
            java.lang.String r8 = "com.apple.iTunes"
            boolean r1 = r8.equals(r1)     // Catch:{ all -> 0x01d6 }
            if (r1 == 0) goto L_0x01d2
            java.lang.String r1 = "iTunSMPB"
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x01d6 }
            if (r1 == 0) goto L_0x01d2
            if (r5 != r3) goto L_0x01bf
            goto L_0x01d2
        L_0x01bf:
            r14.zzv(r5)     // Catch:{ all -> 0x01d6 }
            r1 = 16
            r14.zzw(r1)     // Catch:{ all -> 0x01d6 }
            int r6 = r6 + -16
            java.lang.String r1 = r14.zzo(r6)     // Catch:{ all -> 0x01d6 }
            com.google.android.gms.internal.ads.zzatv r7 = new com.google.android.gms.internal.ads.zzatv     // Catch:{ all -> 0x01d6 }
            r7.<init>(r4, r2, r1)     // Catch:{ all -> 0x01d6 }
        L_0x01d2:
            r14.zzv(r0)
            return r7
        L_0x01d6:
            r1 = move-exception
            goto L_0x02b5
        L_0x01d9:
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r1
            int r3 = zzc     // Catch:{ all -> 0x01d6 }
            if (r2 != r3) goto L_0x021b
            int r2 = r14.zze()     // Catch:{ all -> 0x01d6 }
            int r3 = r14.zze()     // Catch:{ all -> 0x01d6 }
            int r5 = com.google.android.gms.internal.ads.zzasg.zzaH     // Catch:{ all -> 0x01d6 }
            if (r3 != r5) goto L_0x01fe
            r1 = 8
            r14.zzw(r1)     // Catch:{ all -> 0x01d6 }
            int r2 = r2 + -16
            java.lang.String r1 = r14.zzo(r2)     // Catch:{ all -> 0x01d6 }
            com.google.android.gms.internal.ads.zzatv r7 = new com.google.android.gms.internal.ads.zzatv     // Catch:{ all -> 0x01d6 }
            r7.<init>(r4, r1, r1)     // Catch:{ all -> 0x01d6 }
            goto L_0x0217
        L_0x01fe:
            java.lang.String r2 = "Failed to parse comment attribute: "
            java.lang.String r1 = com.google.android.gms.internal.ads.zzasg.zzg(r1)     // Catch:{ all -> 0x01d6 }
            int r3 = r1.length()     // Catch:{ all -> 0x01d6 }
            if (r3 == 0) goto L_0x020f
            java.lang.String r1 = r2.concat(r1)     // Catch:{ all -> 0x01d6 }
            goto L_0x0214
        L_0x020f:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x01d6 }
            r1.<init>(r2)     // Catch:{ all -> 0x01d6 }
        L_0x0214:
            android.util.Log.w(r6, r1)     // Catch:{ all -> 0x01d6 }
        L_0x0217:
            r14.zzv(r0)
            return r7
        L_0x021b:
            int r3 = zza     // Catch:{ all -> 0x01d6 }
            if (r2 == r3) goto L_0x02ab
            int r3 = zzb     // Catch:{ all -> 0x01d6 }
            if (r2 != r3) goto L_0x0225
            goto L_0x02ab
        L_0x0225:
            int r3 = zzh     // Catch:{ all -> 0x01d6 }
            if (r2 == r3) goto L_0x02a1
            int r3 = zzi     // Catch:{ all -> 0x01d6 }
            if (r2 != r3) goto L_0x022e
            goto L_0x02a1
        L_0x022e:
            int r3 = zzd     // Catch:{ all -> 0x01d6 }
            if (r2 != r3) goto L_0x023c
            java.lang.String r2 = "TDRC"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x023c:
            int r3 = zze     // Catch:{ all -> 0x01d6 }
            if (r2 != r3) goto L_0x024a
            java.lang.String r2 = "TPE1"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x024a:
            int r3 = zzf     // Catch:{ all -> 0x01d6 }
            if (r2 != r3) goto L_0x0258
            java.lang.String r2 = "TSSE"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x0258:
            int r3 = zzg     // Catch:{ all -> 0x01d6 }
            if (r2 != r3) goto L_0x0266
            java.lang.String r2 = "TALB"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x0266:
            int r3 = zzj     // Catch:{ all -> 0x01d6 }
            if (r2 != r3) goto L_0x0274
            java.lang.String r2 = "USLT"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x0274:
            int r3 = zzk     // Catch:{ all -> 0x01d6 }
            if (r2 != r3) goto L_0x0280
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r5, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x0280:
            int r3 = zzn     // Catch:{ all -> 0x01d6 }
            if (r2 != r3) goto L_0x028e
            java.lang.String r2 = "TIT1"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x028e:
            java.lang.String r2 = "Skipped unknown metadata entry: "
            java.lang.String r1 = com.google.android.gms.internal.ads.zzasg.zzg(r1)     // Catch:{ all -> 0x01d6 }
            int r3 = r1.length()     // Catch:{ all -> 0x01d6 }
            if (r3 == 0) goto L_0x029d
            r2.concat(r1)     // Catch:{ all -> 0x01d6 }
        L_0x029d:
            r14.zzv(r0)
            return r7
        L_0x02a1:
            java.lang.String r2 = "TCOM"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x02ab:
            java.lang.String r2 = "TIT2"
            com.google.android.gms.internal.ads.zzatz r1 = zze(r1, r2, r14)     // Catch:{ all -> 0x01d6 }
            r14.zzv(r0)
            return r1
        L_0x02b5:
            r14.zzv(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzast.zza(com.google.android.gms.internal.ads.zzawu):com.google.android.gms.internal.ads.zzatq");
    }

    private static int zzb(zzawu zzawu) {
        zzawu.zzw(4);
        if (zzawu.zze() == zzasg.zzaH) {
            zzawu.zzw(8);
            return zzawu.zzg();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static zzatx zzc(int i11, String str, zzawu zzawu, boolean z11, boolean z12) {
        String str2;
        int zzb2 = zzb(zzawu);
        if (z12) {
            zzb2 = Math.min(1, zzb2);
        }
        if (zzb2 < 0) {
            String zzg2 = zzasg.zzg(i11);
            if (zzg2.length() != 0) {
                str2 = "Failed to parse uint8 attribute: ".concat(zzg2);
            } else {
                str2 = new String("Failed to parse uint8 attribute: ");
            }
            Log.w("MetadataUtil", str2);
            return null;
        } else if (z11) {
            return new zzatz(str, (String) null, Integer.toString(zzb2));
        } else {
            return new zzatv(C.LANGUAGE_UNDETERMINED, str, Integer.toString(zzb2));
        }
    }

    private static zzatz zzd(int i11, String str, zzawu zzawu) {
        String str2;
        int zze2 = zzawu.zze();
        if (zzawu.zze() == zzasg.zzaH && zze2 >= 22) {
            zzawu.zzw(10);
            int zzj2 = zzawu.zzj();
            if (zzj2 > 0) {
                StringBuilder sb2 = new StringBuilder(11);
                sb2.append(zzj2);
                String sb3 = sb2.toString();
                int zzj3 = zzawu.zzj();
                if (zzj3 > 0) {
                    StringBuilder sb4 = new StringBuilder(sb3.length() + 12);
                    sb4.append(sb3);
                    sb4.append("/");
                    sb4.append(zzj3);
                    sb3 = sb4.toString();
                }
                return new zzatz(str, (String) null, sb3);
            }
        }
        String zzg2 = zzasg.zzg(i11);
        if (zzg2.length() != 0) {
            str2 = "Failed to parse index/count attribute: ".concat(zzg2);
        } else {
            str2 = new String("Failed to parse index/count attribute: ");
        }
        Log.w("MetadataUtil", str2);
        return null;
    }

    private static zzatz zze(int i11, String str, zzawu zzawu) {
        String str2;
        int zze2 = zzawu.zze();
        if (zzawu.zze() == zzasg.zzaH) {
            zzawu.zzw(8);
            return new zzatz(str, (String) null, zzawu.zzo(zze2 - 16));
        }
        String zzg2 = zzasg.zzg(i11);
        if (zzg2.length() != 0) {
            str2 = "Failed to parse text attribute: ".concat(zzg2);
        } else {
            str2 = new String("Failed to parse text attribute: ");
        }
        Log.w("MetadataUtil", str2);
        return null;
    }
}
