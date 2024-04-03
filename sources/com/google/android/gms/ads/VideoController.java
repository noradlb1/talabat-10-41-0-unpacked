package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbiz;
import com.google.android.gms.internal.ads.zzbkp;
import com.google.android.gms.internal.ads.zzciz;
import javax.annotation.concurrent.GuardedBy;

public final class VideoController {
    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;
    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;
    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object zza = new Object();
    @GuardedBy("lock")
    @Nullable
    private zzbiz zzb;
    @GuardedBy("lock")
    @Nullable
    private VideoLifecycleCallbacks zzc;

    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z11) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    @KeepForSdk
    public int getPlaybackState() {
        synchronized (this.zza) {
            zzbiz zzbiz = this.zzb;
            if (zzbiz == null) {
                return 0;
            }
            try {
                int zzh = zzbiz.zzh();
                return zzh;
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call getPlaybackState on video controller.", e11);
                return 0;
            }
        }
    }

    @RecentlyNullable
    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zza) {
            videoLifecycleCallbacks = this.zzc;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z11;
        synchronized (this.zza) {
            if (this.zzb != null) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z11;
    }

    public boolean isClickToExpandEnabled() {
        synchronized (this.zza) {
            zzbiz zzbiz = this.zzb;
            if (zzbiz == null) {
                return false;
            }
            try {
                boolean zzo = zzbiz.zzo();
                return zzo;
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call isClickToExpandEnabled.", e11);
                return false;
            }
        }
    }

    public boolean isCustomControlsEnabled() {
        synchronized (this.zza) {
            zzbiz zzbiz = this.zzb;
            if (zzbiz == null) {
                return false;
            }
            try {
                boolean zzp = zzbiz.zzp();
                return zzp;
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call isUsingCustomPlayerControls.", e11);
                return false;
            }
        }
    }

    public boolean isMuted() {
        synchronized (this.zza) {
            zzbiz zzbiz = this.zzb;
            if (zzbiz == null) {
                return true;
            }
            try {
                boolean zzq = zzbiz.zzq();
                return zzq;
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call isMuted on video controller.", e11);
                return true;
            }
        }
    }

    public void mute(boolean z11) {
        synchronized (this.zza) {
            zzbiz zzbiz = this.zzb;
            if (zzbiz != null) {
                try {
                    zzbiz.zzj(z11);
                } catch (RemoteException e11) {
                    zzciz.zzh("Unable to call mute on video controller.", e11);
                }
            }
        }
    }

    public void pause() {
        synchronized (this.zza) {
            zzbiz zzbiz = this.zzb;
            if (zzbiz != null) {
                try {
                    zzbiz.zzk();
                } catch (RemoteException e11) {
                    zzciz.zzh("Unable to call pause on video controller.", e11);
                }
            }
        }
    }

    public void play() {
        synchronized (this.zza) {
            zzbiz zzbiz = this.zzb;
            if (zzbiz != null) {
                try {
                    zzbiz.zzl();
                } catch (RemoteException e11) {
                    zzciz.zzh("Unable to call play on video controller.", e11);
                }
            }
        }
    }

    public void setVideoLifecycleCallbacks(@Nullable VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzbkp zzbkp;
        synchronized (this.zza) {
            this.zzc = videoLifecycleCallbacks;
            zzbiz zzbiz = this.zzb;
            if (zzbiz != null) {
                if (videoLifecycleCallbacks == null) {
                    zzbkp = null;
                } else {
                    try {
                        zzbkp = new zzbkp(videoLifecycleCallbacks);
                    } catch (RemoteException e11) {
                        zzciz.zzh("Unable to call setVideoLifecycleCallbacks on video controller.", e11);
                        return;
                    }
                }
                zzbiz.zzm(zzbkp);
            }
        }
    }

    public void stop() {
        synchronized (this.zza) {
            zzbiz zzbiz = this.zzb;
            if (zzbiz != null) {
                try {
                    zzbiz.zzn();
                } catch (RemoteException e11) {
                    zzciz.zzh("Unable to call stop on video controller.", e11);
                }
            }
        }
    }

    @Nullable
    public final zzbiz zza() {
        zzbiz zzbiz;
        synchronized (this.zza) {
            zzbiz = this.zzb;
        }
        return zzbiz;
    }

    public final void zzb(@Nullable zzbiz zzbiz) {
        synchronized (this.zza) {
            this.zzb = zzbiz;
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzc;
            if (videoLifecycleCallbacks != null) {
                setVideoLifecycleCallbacks(videoLifecycleCallbacks);
            }
        }
    }
}
