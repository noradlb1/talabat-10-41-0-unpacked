package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.huawei.hms.analytics.instance.CallBack;
import com.huawei.hms.flutter.map.constants.Param;
import com.newrelic.agent.android.harvest.type.HarvestErrorCodes;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public final class zzckm extends zzcko implements TextureView.SurfaceTextureListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {
    private static final Map<Integer, String> zzc;
    private final zzclh zzd;
    private final zzcli zze;
    private final boolean zzf;
    private int zzg = 0;
    private int zzh = 0;
    private MediaPlayer zzi;
    private Uri zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private zzclf zzp;
    private final boolean zzq;
    private int zzr;
    /* access modifiers changed from: private */
    public zzckn zzs;
    /* access modifiers changed from: private */
    public boolean zzt = false;
    private Integer zzu = null;

    static {
        HashMap hashMap = new HashMap();
        zzc = hashMap;
        hashMap.put(Integer.valueOf(HarvestErrorCodes.NSURLErrorCannotConnectToHost), "MEDIA_ERROR_IO");
        hashMap.put(-1007, "MEDIA_ERROR_MALFORMED");
        hashMap.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        hashMap.put(Integer.valueOf(CallBack.ANALYTICS_CLOSED), "MEDIA_ERROR_TIMED_OUT");
        hashMap.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        hashMap.put(100, "MEDIA_ERROR_SERVER_DIED");
        hashMap.put(1, "MEDIA_ERROR_UNKNOWN");
        hashMap.put(1, "MEDIA_INFO_UNKNOWN");
        hashMap.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        hashMap.put(Integer.valueOf(TypedValues.TransitionType.TYPE_FROM), "MEDIA_INFO_BUFFERING_START");
        hashMap.put(Integer.valueOf(TypedValues.TransitionType.TYPE_TO), "MEDIA_INFO_BUFFERING_END");
        hashMap.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        hashMap.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        hashMap.put(802, "MEDIA_INFO_METADATA_UPDATE");
        hashMap.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        hashMap.put(Integer.valueOf(TypedValues.Custom.TYPE_COLOR), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzckm(Context context, zzclh zzclh, boolean z11, boolean z12, zzclg zzclg, zzcli zzcli) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzd = zzclh;
        this.zze = zzcli;
        this.zzq = z11;
        this.zzf = z12;
        zzcli.zza(this);
    }

    private final void zzC() {
        zze.zza("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzj != null && surfaceTexture != null) {
            zzE(false);
            try {
                zzt.zzk();
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.zzi = mediaPlayer;
                mediaPlayer.setOnBufferingUpdateListener(this);
                this.zzi.setOnCompletionListener(this);
                this.zzi.setOnErrorListener(this);
                this.zzi.setOnInfoListener(this);
                this.zzi.setOnPreparedListener(this);
                this.zzi.setOnVideoSizeChangedListener(this);
                this.zzm = 0;
                if (this.zzq) {
                    zzclf zzclf = new zzclf(getContext());
                    this.zzp = zzclf;
                    zzclf.zzd(surfaceTexture, getWidth(), getHeight());
                    this.zzp.start();
                    SurfaceTexture zzb = this.zzp.zzb();
                    if (zzb != null) {
                        surfaceTexture = zzb;
                    } else {
                        this.zzp.zze();
                        this.zzp = null;
                    }
                }
                this.zzi.setDataSource(getContext(), this.zzj);
                zzt.zzl();
                this.zzi.setSurface(new Surface(surfaceTexture));
                this.zzi.setAudioStreamType(3);
                this.zzi.setScreenOnWhilePlaying(true);
                this.zzi.prepareAsync();
                zzF(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e11) {
                zzciz.zzk("Failed to initialize MediaPlayer at ".concat(String.valueOf(this.zzj)), e11);
                onError(this.zzi, 1, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034 A[LOOP:0: B:10:0x0034->B:15:0x004f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzD() {
        /*
            r7 = this;
            boolean r0 = r7.zzf
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r7.zzH()
            if (r0 == 0) goto L_0x0059
            android.media.MediaPlayer r0 = r7.zzi
            int r0 = r0.getCurrentPosition()
            if (r0 <= 0) goto L_0x0059
            int r0 = r7.zzh
            r1 = 3
            if (r0 == r1) goto L_0x0059
            java.lang.String r0 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            r0 = 0
            r7.zzG(r0)
            android.media.MediaPlayer r0 = r7.zzi
            r0.start()
            android.media.MediaPlayer r0 = r7.zzi
            int r0 = r0.getCurrentPosition()
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzt.zzA()
            long r1 = r1.currentTimeMillis()
        L_0x0034:
            boolean r3 = r7.zzH()
            if (r3 == 0) goto L_0x0051
            android.media.MediaPlayer r3 = r7.zzi
            int r3 = r3.getCurrentPosition()
            if (r3 != r0) goto L_0x0051
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzt.zzA()
            long r3 = r3.currentTimeMillis()
            long r3 = r3 - r1
            r5 = 250(0xfa, double:1.235E-321)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0034
        L_0x0051:
            android.media.MediaPlayer r0 = r7.zzi
            r0.pause()
            r7.zzn()
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckm.zzD():void");
    }

    private final void zzE(boolean z11) {
        zze.zza("AdMediaPlayerView release");
        zzclf zzclf = this.zzp;
        if (zzclf != null) {
            zzclf.zze();
            this.zzp = null;
        }
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzi.release();
            this.zzi = null;
            zzF(0);
            if (z11) {
                this.zzh = 0;
            }
        }
    }

    private final void zzF(int i11) {
        if (i11 == 3) {
            this.zze.zzc();
            this.zzb.zzb();
        } else if (this.zzg == 3) {
            this.zze.zze();
            this.zzb.zzc();
        }
        this.zzg = i11;
    }

    private final void zzG(float f11) {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f11, f11);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzciz.zzj("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.zzg;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzH() {
        /*
            r2 = this;
            android.media.MediaPlayer r0 = r2.zzi
            if (r0 == 0) goto L_0x000f
            int r0 = r2.zzg
            r1 = -1
            if (r0 == r1) goto L_0x000f
            if (r0 == 0) goto L_0x000f
            r1 = 1
            if (r0 == r1) goto L_0x000f
            return r1
        L_0x000f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckm.zzH():boolean");
    }

    public static /* bridge */ /* synthetic */ void zzl(zzckm zzckm, MediaPlayer mediaPlayer) {
        MediaPlayer.TrackInfo[] trackInfo;
        MediaFormat format;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue() && zzckm.zzd != null && mediaPlayer != null && (trackInfo = mediaPlayer.getTrackInfo()) != null) {
            HashMap hashMap = new HashMap();
            for (MediaPlayer.TrackInfo trackInfo2 : trackInfo) {
                if (trackInfo2 != null) {
                    int trackType = trackInfo2.getTrackType();
                    if (trackType == 1) {
                        MediaFormat format2 = trackInfo2.getFormat();
                        if (format2 != null) {
                            if (format2.containsKey("frame-rate")) {
                                try {
                                    hashMap.put("frameRate", String.valueOf(format2.getFloat("frame-rate")));
                                } catch (ClassCastException unused) {
                                    hashMap.put("frameRate", String.valueOf(format2.getInteger("frame-rate")));
                                }
                            }
                            if (format2.containsKey("bitrate")) {
                                Integer valueOf = Integer.valueOf(format2.getInteger("bitrate"));
                                zzckm.zzu = valueOf;
                                hashMap.put("bitRate", String.valueOf(valueOf));
                            }
                            if (format2.containsKey("width") && format2.containsKey("height")) {
                                int integer = format2.getInteger("width");
                                int integer2 = format2.getInteger("height");
                                StringBuilder sb2 = new StringBuilder(23);
                                sb2.append(integer);
                                sb2.append(Param.X);
                                sb2.append(integer2);
                                hashMap.put("resolution", sb2.toString());
                            }
                            if (format2.containsKey("mime")) {
                                hashMap.put("videoMime", format2.getString("mime"));
                            }
                            if (Build.VERSION.SDK_INT >= 30 && format2.containsKey("codecs-string")) {
                                hashMap.put("videoCodec", format2.getString("codecs-string"));
                            }
                        }
                    } else if (trackType == 2 && (format = trackInfo2.getFormat()) != null) {
                        if (format.containsKey("mime")) {
                            hashMap.put("audioMime", format.getString("mime"));
                        }
                        if (Build.VERSION.SDK_INT >= 30 && format.containsKey("codecs-string")) {
                            hashMap.put("audioCodec", format.getString("codecs-string"));
                        }
                    }
                }
            }
            if (!hashMap.isEmpty()) {
                zzckm.zzd.zzd("onMetadataEvent", hashMap);
            }
        }
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i11) {
        this.zzm = i11;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        zze.zza("AdMediaPlayerView completion");
        zzF(5);
        this.zzh = 5;
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzckf(this));
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i11, int i12) {
        Map<Integer, String> map = zzc;
        String str = map.get(Integer.valueOf(i11));
        String str2 = map.get(Integer.valueOf(i12));
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb2.append("AdMediaPlayerView MediaPlayer error: ");
        sb2.append(str);
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(str2);
        zzciz.zzj(sb2.toString());
        zzF(-1);
        this.zzh = -1;
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzckg(this, str, str2));
        return true;
    }

    public final boolean onInfo(MediaPlayer mediaPlayer, int i11, int i12) {
        Map<Integer, String> map = zzc;
        String str = map.get(Integer.valueOf(i11));
        String str2 = map.get(Integer.valueOf(i12));
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb2.append("AdMediaPlayerView MediaPlayer info: ");
        sb2.append(str);
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(str2);
        zze.zza(sb2.toString());
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005e, code lost:
        if (r1 > r6) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.zzk
            int r0 = android.view.View.getDefaultSize(r0, r6)
            int r1 = r5.zzl
            int r1 = android.view.View.getDefaultSize(r1, r7)
            int r2 = r5.zzk
            if (r2 <= 0) goto L_0x007a
            int r2 = r5.zzl
            if (r2 <= 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzclf r2 = r5.zzp
            if (r2 != 0) goto L_0x007a
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L_0x0042
            if (r1 != r2) goto L_0x0041
            int r0 = r5.zzk
            int r1 = r0 * r7
            int r2 = r5.zzl
            int r3 = r6 * r2
            if (r1 >= r3) goto L_0x003c
            int r0 = r1 / r2
        L_0x003a:
            r1 = r7
            goto L_0x007a
        L_0x003c:
            if (r1 <= r3) goto L_0x0060
            int r1 = r3 / r0
            goto L_0x0052
        L_0x0041:
            r0 = r2
        L_0x0042:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L_0x0054
            int r0 = r5.zzl
            int r0 = r0 * r6
            int r2 = r5.zzk
            int r0 = r0 / r2
            if (r1 != r3) goto L_0x0051
            if (r0 <= r7) goto L_0x0051
            goto L_0x0060
        L_0x0051:
            r1 = r0
        L_0x0052:
            r0 = r6
            goto L_0x007a
        L_0x0054:
            if (r1 != r2) goto L_0x0064
            int r1 = r5.zzk
            int r1 = r1 * r7
            int r2 = r5.zzl
            int r1 = r1 / r2
            if (r0 != r3) goto L_0x0062
            if (r1 <= r6) goto L_0x0062
        L_0x0060:
            r0 = r6
            goto L_0x003a
        L_0x0062:
            r0 = r1
            goto L_0x003a
        L_0x0064:
            int r2 = r5.zzk
            int r4 = r5.zzl
            if (r1 != r3) goto L_0x0070
            if (r4 <= r7) goto L_0x0070
            int r1 = r7 * r2
            int r1 = r1 / r4
            goto L_0x0072
        L_0x0070:
            r1 = r2
            r7 = r4
        L_0x0072:
            if (r0 != r3) goto L_0x0062
            if (r1 <= r6) goto L_0x0062
            int r4 = r4 * r6
            int r1 = r4 / r2
            goto L_0x0052
        L_0x007a:
            r5.setMeasuredDimension(r0, r1)
            com.google.android.gms.internal.ads.zzclf r6 = r5.zzp
            if (r6 == 0) goto L_0x0084
            r6.zzc(r0, r1)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzckm.onMeasure(int, int):void");
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        zze.zza("AdMediaPlayerView prepared");
        zzF(2);
        this.zze.zzb();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcke(this, mediaPlayer));
        this.zzk = mediaPlayer.getVideoWidth();
        this.zzl = mediaPlayer.getVideoHeight();
        int i11 = this.zzr;
        if (i11 != 0) {
            zzq(i11);
        }
        zzD();
        int i12 = this.zzk;
        int i13 = this.zzl;
        StringBuilder sb2 = new StringBuilder(62);
        sb2.append("AdMediaPlayerView stream dimensions: ");
        sb2.append(i12);
        sb2.append(" x ");
        sb2.append(i13);
        zzciz.zzi(sb2.toString());
        if (this.zzh == 3) {
            zzp();
        }
        zzn();
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
        zze.zza("AdMediaPlayerView surface created");
        zzC();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzckh(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zze.zza("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null && this.zzr == 0) {
            this.zzr = mediaPlayer.getCurrentPosition();
        }
        zzclf zzclf = this.zzp;
        if (zzclf != null) {
            zzclf.zze();
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzckj(this));
        zzE(true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
        zze.zza("AdMediaPlayerView surface changed");
        int i13 = this.zzh;
        boolean z11 = false;
        if (this.zzk == i11 && this.zzl == i12) {
            z11 = true;
        }
        if (this.zzi != null && i13 == 3 && z11) {
            int i14 = this.zzr;
            if (i14 != 0) {
                zzq(i14);
            }
            zzp();
        }
        zzclf zzclf = this.zzp;
        if (zzclf != null) {
            zzclf.zzc(i11, i12);
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcki(this, i11, i12));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zze.zzf(this);
        this.zza.zza(surfaceTexture, this.zzs);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i11, int i12) {
        StringBuilder sb2 = new StringBuilder(57);
        sb2.append("AdMediaPlayerView size changed: ");
        sb2.append(i11);
        sb2.append(" x ");
        sb2.append(i12);
        zze.zza(sb2.toString());
        this.zzk = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.zzl = videoHeight;
        if (this.zzk != 0 && videoHeight != 0) {
            requestLayout();
        }
    }

    public final void onWindowVisibilityChanged(int i11) {
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("AdMediaPlayerView window visibility changed to ");
        sb2.append(i11);
        zze.zza(sb2.toString());
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzckd(this, i11));
        super.onWindowVisibilityChanged(i11);
    }

    public final String toString() {
        String name2 = zzckm.class.getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb2 = new StringBuilder(name2.length() + 1 + String.valueOf(hexString).length());
        sb2.append(name2);
        sb2.append("@");
        sb2.append(hexString);
        return sb2.toString();
    }

    public final int zza() {
        if (zzH()) {
            return this.zzi.getCurrentPosition();
        }
        return 0;
    }

    public final int zzb() {
        if (Build.VERSION.SDK_INT < 26 || !zzH()) {
            return -1;
        }
        return this.zzi.getMetrics().getInt("android.media.mediaplayer.dropped");
    }

    public final int zzc() {
        if (zzH()) {
            return this.zzi.getDuration();
        }
        return -1;
    }

    public final int zzd() {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    public final int zze() {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    public final long zzf() {
        return 0;
    }

    public final long zzg() {
        if (this.zzu != null) {
            return (zzh() * ((long) this.zzm)) / 100;
        }
        return -1;
    }

    public final long zzh() {
        if (this.zzu != null) {
            return ((long) zzc()) * ((long) this.zzu.intValue());
        }
        return -1;
    }

    public final String zzj() {
        String str = true != this.zzq ? "" : " spherical";
        return str.length() != 0 ? "MediaPlayer".concat(str) : new String("MediaPlayer");
    }

    public final /* synthetic */ void zzm(int i11) {
        zzckn zzckn = this.zzs;
        if (zzckn != null) {
            zzckn.onWindowVisibilityChanged(i11);
        }
    }

    public final void zzn() {
        zzG(this.zzb.zza());
    }

    public final void zzo() {
        zze.zza("AdMediaPlayerView pause");
        if (zzH() && this.zzi.isPlaying()) {
            this.zzi.pause();
            zzF(4);
            com.google.android.gms.ads.internal.util.zzt.zza.post(new zzckl(this));
        }
        this.zzh = 4;
    }

    public final void zzp() {
        zze.zza("AdMediaPlayerView play");
        if (zzH()) {
            this.zzi.start();
            zzF(3);
            this.zza.zzb();
            com.google.android.gms.ads.internal.util.zzt.zza.post(new zzckk(this));
        }
        this.zzh = 3;
    }

    public final void zzq(int i11) {
        StringBuilder sb2 = new StringBuilder(34);
        sb2.append("AdMediaPlayerView seek ");
        sb2.append(i11);
        zze.zza(sb2.toString());
        if (zzH()) {
            this.zzi.seekTo(i11);
            this.zzr = 0;
            return;
        }
        this.zzr = i11;
    }

    public final void zzr(zzckn zzckn) {
        this.zzs = zzckn;
    }

    public final void zzs(String str) {
        Uri parse = Uri.parse(str);
        zzbak zza = zzbak.zza(parse);
        if (zza == null || zza.zza != null) {
            if (zza != null) {
                parse = Uri.parse(zza.zza);
            }
            this.zzj = parse;
            this.zzr = 0;
            zzC();
            requestLayout();
            invalidate();
        }
    }

    public final void zzt() {
        zze.zza("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzi.release();
            this.zzi = null;
            zzF(0);
            this.zzh = 0;
        }
        this.zze.zzd();
    }

    public final void zzu(float f11, float f12) {
        zzclf zzclf = this.zzp;
        if (zzclf != null) {
            zzclf.zzf(f11, f12);
        }
    }
}
