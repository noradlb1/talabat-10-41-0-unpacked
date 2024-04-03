package com.instabug.library.internal.media;

import android.media.MediaPlayer;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.time.DateUtils;

public class AudioPlayer {
    @Nullable
    private String filePath;
    @Nullable
    private MediaPlayer mediaPlayer;
    @Nullable
    private MediaPlayer.OnCompletionListener onCompletionListener;
    @Nullable
    private e onGetDurationListener;
    @NonNull
    private final Map<String, OnStopListener> onStopListeners = new HashMap();

    public static abstract class OnStopListener {
        private String filePath;

        public OnStopListener(String str) {
            this.filePath = str;
        }

        public String getFilePath() {
            return this.filePath;
        }

        public abstract void onStop();
    }

    public class a implements MediaPlayer.OnPreparedListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f50986b;

        public a(d dVar) {
            this.f50986b = dVar;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            AudioPlayer.this.doAction(this.f50986b);
        }
    }

    public class b implements MediaPlayer.OnCompletionListener {
        public b() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            AudioPlayer.this.notifyOnStopListeners();
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50989a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.instabug.library.internal.media.AudioPlayer$d[] r0 = com.instabug.library.internal.media.AudioPlayer.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f50989a = r0
                com.instabug.library.internal.media.AudioPlayer$d r1 = com.instabug.library.internal.media.AudioPlayer.d.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f50989a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.instabug.library.internal.media.AudioPlayer$d r1 = com.instabug.library.internal.media.AudioPlayer.d.PAUSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f50989a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.instabug.library.internal.media.AudioPlayer$d r1 = com.instabug.library.internal.media.AudioPlayer.d.GET_DURATION     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.media.AudioPlayer.c.<clinit>():void");
        }
    }

    public enum d {
        START,
        PAUSE,
        GET_DURATION
    }

    public interface e {
        void a(int i11);
    }

    /* access modifiers changed from: private */
    public void doAction(d dVar) {
        e eVar;
        MediaPlayer mediaPlayer2;
        int i11 = c.f50989a[dVar.ordinal()];
        if (i11 == 1) {
            MediaPlayer mediaPlayer3 = this.mediaPlayer;
            if (mediaPlayer3 != null && !mediaPlayer3.isPlaying()) {
                this.mediaPlayer.start();
            }
        } else if (i11 == 2) {
            MediaPlayer mediaPlayer4 = this.mediaPlayer;
            if (mediaPlayer4 != null && mediaPlayer4.isPlaying()) {
                this.mediaPlayer.pause();
            }
        } else if (i11 == 3 && (eVar = this.onGetDurationListener) != null && (mediaPlayer2 = this.mediaPlayer) != null) {
            eVar.a(mediaPlayer2.getDuration());
        }
    }

    public static String getFormattedDurationText(long j11) {
        int i11 = (int) (j11 / DateUtils.MILLIS_PER_HOUR);
        int i12 = (int) ((j11 % DateUtils.MILLIS_PER_HOUR) / 60000);
        int i13 = (int) ((j11 % 60000) / 1000);
        if (i11 > 0) {
            return String.format(Locale.getDefault(), "%02d:%02d:%02d", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)});
        }
        return String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Integer.valueOf(i12), Integer.valueOf(i13)});
    }

    /* access modifiers changed from: private */
    public void notifyOnStopListeners() {
        for (OnStopListener onStop : this.onStopListeners.values()) {
            onStop.onStop();
        }
    }

    private void prepare(d dVar) {
        try {
            MediaPlayer mediaPlayer2 = new MediaPlayer();
            this.mediaPlayer = mediaPlayer2;
            String str = this.filePath;
            if (str != null) {
                mediaPlayer2.setDataSource(str);
            }
            this.mediaPlayer.setOnPreparedListener(new a(dVar));
            this.mediaPlayer.prepareAsync();
            MediaPlayer.OnCompletionListener onCompletionListener2 = this.onCompletionListener;
            if (onCompletionListener2 != null) {
                this.mediaPlayer.setOnCompletionListener(onCompletionListener2);
            }
        } catch (IOException e11) {
            InstabugSDKLogger.e("IBG-Core", "Playing audio file failed", e11);
        }
    }

    private void stream(String str, d dVar) {
        if (str == null) {
            InstabugSDKLogger.e("IBG-Core", "Audio file path can not be null");
        } else if (str.equals(this.filePath)) {
            doAction(dVar);
        } else {
            this.filePath = str;
            prepare(dVar);
        }
    }

    public void addOnStopListener(OnStopListener onStopListener) {
        this.onStopListeners.put(onStopListener.getFilePath(), onStopListener);
        if (this.onCompletionListener == null) {
            b bVar = new b();
            this.onCompletionListener = bVar;
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setOnCompletionListener(bVar);
            }
        }
    }

    public void getDurationAsync(String str, e eVar) {
        stream(str, d.GET_DURATION);
        this.onGetDurationListener = eVar;
    }

    public void pause() {
        notifyOnStopListeners();
        doAction(d.PAUSE);
    }

    public void release() {
        this.filePath = null;
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            if (mediaPlayer2.isPlaying()) {
                this.mediaPlayer.stop();
            }
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    public void start(String str) {
        pause();
        stream(str, d.START);
    }
}
