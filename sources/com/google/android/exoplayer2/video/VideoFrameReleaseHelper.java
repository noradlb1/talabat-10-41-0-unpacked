package com.google.android.exoplayer2.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import o8.e;

public final class VideoFrameReleaseHelper {
    private static final long MAX_ALLOWED_ADJUSTMENT_NS = 20000000;
    private static final int MINIMUM_FRAMES_WITHOUT_SYNC_TO_CLEAR_SURFACE_FRAME_RATE = 30;
    private static final long MINIMUM_MATCHING_FRAME_DURATION_FOR_HIGH_CONFIDENCE_NS = 5000000000L;
    private static final float MINIMUM_MEDIA_FRAME_RATE_CHANGE_FOR_UPDATE_HIGH_CONFIDENCE = 0.02f;
    private static final float MINIMUM_MEDIA_FRAME_RATE_CHANGE_FOR_UPDATE_LOW_CONFIDENCE = 1.0f;
    private static final String TAG = "VideoFrameReleaseHelper";
    private static final long VSYNC_OFFSET_PERCENTAGE = 80;
    private static final long VSYNC_SAMPLE_UPDATE_PERIOD_MS = 500;
    private int changeFrameRateStrategy;
    @Nullable
    private final DisplayHelper displayHelper;
    private float formatFrameRate;
    private long frameIndex;
    private final FixedFrameRateEstimator frameRateEstimator = new FixedFrameRateEstimator();
    private long lastAdjustedFrameIndex;
    private long lastAdjustedReleaseTimeNs;
    private long pendingLastAdjustedFrameIndex;
    private long pendingLastAdjustedReleaseTimeNs;
    private float playbackSpeed;
    private boolean started;
    @Nullable
    private Surface surface;
    private float surfaceMediaFrameRate;
    private float surfacePlaybackFrameRate;
    private long vsyncDurationNs;
    private long vsyncOffsetNs;
    @Nullable
    private final VSyncSampler vsyncSampler;

    @RequiresApi(30)
    public static final class Api30 {
        private Api30() {
        }

        @DoNotInline
        public static void setSurfaceFrameRate(Surface surface, float f11) {
            int i11;
            if (f11 == 0.0f) {
                i11 = 0;
            } else {
                i11 = 1;
            }
            try {
                surface.setFrameRate(f11, i11);
            } catch (IllegalStateException e11) {
                Log.e(VideoFrameReleaseHelper.TAG, "Failed to call Surface.setFrameRate", e11);
            }
        }
    }

    public interface DisplayHelper {

        public interface Listener {
            void onDefaultDisplayChanged(@Nullable Display display);
        }

        void register(Listener listener);

        void unregister();
    }

    public static final class DisplayHelperV16 implements DisplayHelper {
        private final WindowManager windowManager;

        private DisplayHelperV16(WindowManager windowManager2) {
            this.windowManager = windowManager2;
        }

        @Nullable
        public static DisplayHelper maybeBuildNewInstance(Context context) {
            WindowManager windowManager2 = (WindowManager) context.getSystemService("window");
            if (windowManager2 != null) {
                return new DisplayHelperV16(windowManager2);
            }
            return null;
        }

        public void register(DisplayHelper.Listener listener) {
            listener.onDefaultDisplayChanged(this.windowManager.getDefaultDisplay());
        }

        public void unregister() {
        }
    }

    @RequiresApi(17)
    public static final class DisplayHelperV17 implements DisplayHelper, DisplayManager.DisplayListener {
        private final DisplayManager displayManager;
        @Nullable
        private DisplayHelper.Listener listener;

        private DisplayHelperV17(DisplayManager displayManager2) {
            this.displayManager = displayManager2;
        }

        private Display getDefaultDisplay() {
            return this.displayManager.getDisplay(0);
        }

        @Nullable
        public static DisplayHelper maybeBuildNewInstance(Context context) {
            DisplayManager displayManager2 = (DisplayManager) context.getSystemService("display");
            if (displayManager2 != null) {
                return new DisplayHelperV17(displayManager2);
            }
            return null;
        }

        public void onDisplayAdded(int i11) {
        }

        public void onDisplayChanged(int i11) {
            DisplayHelper.Listener listener2 = this.listener;
            if (listener2 != null && i11 == 0) {
                listener2.onDefaultDisplayChanged(getDefaultDisplay());
            }
        }

        public void onDisplayRemoved(int i11) {
        }

        public void register(DisplayHelper.Listener listener2) {
            this.listener = listener2;
            this.displayManager.registerDisplayListener(this, Util.createHandlerForCurrentLooper());
            listener2.onDefaultDisplayChanged(getDefaultDisplay());
        }

        public void unregister() {
            this.displayManager.unregisterDisplayListener(this);
            this.listener = null;
        }
    }

    public static final class VSyncSampler implements Choreographer.FrameCallback, Handler.Callback {
        private static final int CREATE_CHOREOGRAPHER = 0;
        private static final VSyncSampler INSTANCE = new VSyncSampler();
        private static final int MSG_ADD_OBSERVER = 1;
        private static final int MSG_REMOVE_OBSERVER = 2;
        private Choreographer choreographer;
        private final HandlerThread choreographerOwnerThread;
        private final Handler handler;
        private int observerCount;
        public volatile long sampledVsyncTimeNs = C.TIME_UNSET;

        private VSyncSampler() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.choreographerOwnerThread = handlerThread;
            handlerThread.start();
            Handler createHandler = Util.createHandler(handlerThread.getLooper(), this);
            this.handler = createHandler;
            createHandler.sendEmptyMessage(0);
        }

        private void addObserverInternal() {
            Choreographer choreographer2 = this.choreographer;
            if (choreographer2 != null) {
                int i11 = this.observerCount + 1;
                this.observerCount = i11;
                if (i11 == 1) {
                    choreographer2.postFrameCallback(this);
                }
            }
        }

        private void createChoreographerInstanceInternal() {
            try {
                this.choreographer = Choreographer.getInstance();
            } catch (RuntimeException e11) {
                Log.w(VideoFrameReleaseHelper.TAG, "Vsync sampling disabled due to platform error", e11);
            }
        }

        public static VSyncSampler getInstance() {
            return INSTANCE;
        }

        private void removeObserverInternal() {
            Choreographer choreographer2 = this.choreographer;
            if (choreographer2 != null) {
                int i11 = this.observerCount - 1;
                this.observerCount = i11;
                if (i11 == 0) {
                    choreographer2.removeFrameCallback(this);
                    this.sampledVsyncTimeNs = C.TIME_UNSET;
                }
            }
        }

        public void addObserver() {
            this.handler.sendEmptyMessage(1);
        }

        public void doFrame(long j11) {
            this.sampledVsyncTimeNs = j11;
            ((Choreographer) Assertions.checkNotNull(this.choreographer)).postFrameCallbackDelayed(this, 500);
        }

        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 0) {
                createChoreographerInstanceInternal();
                return true;
            } else if (i11 == 1) {
                addObserverInternal();
                return true;
            } else if (i11 != 2) {
                return false;
            } else {
                removeObserverInternal();
                return true;
            }
        }

        public void removeObserver() {
            this.handler.sendEmptyMessage(2);
        }
    }

    public VideoFrameReleaseHelper(@Nullable Context context) {
        VSyncSampler vSyncSampler;
        DisplayHelper maybeBuildDisplayHelper = maybeBuildDisplayHelper(context);
        this.displayHelper = maybeBuildDisplayHelper;
        if (maybeBuildDisplayHelper != null) {
            vSyncSampler = VSyncSampler.getInstance();
        } else {
            vSyncSampler = null;
        }
        this.vsyncSampler = vSyncSampler;
        this.vsyncDurationNs = C.TIME_UNSET;
        this.vsyncOffsetNs = C.TIME_UNSET;
        this.formatFrameRate = -1.0f;
        this.playbackSpeed = 1.0f;
        this.changeFrameRateStrategy = 0;
    }

    private static boolean adjustmentAllowed(long j11, long j12) {
        return Math.abs(j11 - j12) <= MAX_ALLOWED_ADJUSTMENT_NS;
    }

    private void clearSurfaceFrameRate() {
        Surface surface2;
        if (Util.SDK_INT >= 30 && (surface2 = this.surface) != null && this.changeFrameRateStrategy != Integer.MIN_VALUE && this.surfacePlaybackFrameRate != 0.0f) {
            this.surfacePlaybackFrameRate = 0.0f;
            Api30.setSurfaceFrameRate(surface2, 0.0f);
        }
    }

    private static long closestVsync(long j11, long j12, long j13) {
        long j14;
        long j15 = j12 + (((j11 - j12) / j13) * j13);
        if (j11 <= j15) {
            j14 = j15 - j13;
        } else {
            long j16 = j15;
            j15 = j13 + j15;
            j14 = j16;
        }
        return j15 - j11 < j11 - j14 ? j15 : j14;
    }

    @Nullable
    private static DisplayHelper maybeBuildDisplayHelper(@Nullable Context context) {
        DisplayHelper displayHelper2 = null;
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (Util.SDK_INT >= 17) {
            displayHelper2 = DisplayHelperV17.maybeBuildNewInstance(applicationContext);
        }
        if (displayHelper2 == null) {
            return DisplayHelperV16.maybeBuildNewInstance(applicationContext);
        }
        return displayHelper2;
    }

    private void resetAdjustment() {
        this.frameIndex = 0;
        this.lastAdjustedFrameIndex = -1;
        this.pendingLastAdjustedFrameIndex = -1;
    }

    /* access modifiers changed from: private */
    public void updateDefaultDisplayRefreshRateParams(@Nullable Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.vsyncDurationNs = refreshRate;
            this.vsyncOffsetNs = (refreshRate * VSYNC_OFFSET_PERCENTAGE) / 100;
            return;
        }
        Log.w(TAG, "Unable to query display refresh rate");
        this.vsyncDurationNs = C.TIME_UNSET;
        this.vsyncOffsetNs = C.TIME_UNSET;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (java.lang.Math.abs(r0 - r7.surfaceMediaFrameRate) >= r1) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006a, code lost:
        if (r7.frameRateEstimator.getFramesWithoutSyncCount() >= 30) goto L_0x006c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateSurfaceMediaFrameRate() {
        /*
            r7 = this;
            int r0 = com.google.android.exoplayer2.util.Util.SDK_INT
            r1 = 30
            if (r0 < r1) goto L_0x0073
            android.view.Surface r0 = r7.surface
            if (r0 != 0) goto L_0x000c
            goto L_0x0073
        L_0x000c:
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r0 = r7.frameRateEstimator
            boolean r0 = r0.isSynced()
            if (r0 == 0) goto L_0x001b
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r0 = r7.frameRateEstimator
            float r0 = r0.getFrameRate()
            goto L_0x001d
        L_0x001b:
            float r0 = r7.formatFrameRate
        L_0x001d:
            float r2 = r7.surfaceMediaFrameRate
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0024
            return
        L_0x0024:
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0061
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0061
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r1 = r7.frameRateEstimator
            boolean r1 = r1.isSynced()
            if (r1 == 0) goto L_0x0049
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r1 = r7.frameRateEstimator
            long r1 = r1.getMatchingFrameDurationSumNs()
            r3 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x0049
            r1 = r6
            goto L_0x004a
        L_0x0049:
            r1 = r5
        L_0x004a:
            if (r1 == 0) goto L_0x0050
            r1 = 1017370378(0x3ca3d70a, float:0.02)
            goto L_0x0052
        L_0x0050:
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x0052:
            float r2 = r7.surfaceMediaFrameRate
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x005f
            goto L_0x006c
        L_0x005f:
            r6 = r5
            goto L_0x006c
        L_0x0061:
            if (r4 == 0) goto L_0x0064
            goto L_0x006c
        L_0x0064:
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r2 = r7.frameRateEstimator
            int r2 = r2.getFramesWithoutSyncCount()
            if (r2 < r1) goto L_0x005f
        L_0x006c:
            if (r6 == 0) goto L_0x0073
            r7.surfaceMediaFrameRate = r0
            r7.updateSurfacePlaybackFrameRate(r5)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.VideoFrameReleaseHelper.updateSurfaceMediaFrameRate():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateSurfacePlaybackFrameRate(boolean r4) {
        /*
            r3 = this;
            int r0 = com.google.android.exoplayer2.util.Util.SDK_INT
            r1 = 30
            if (r0 < r1) goto L_0x0030
            android.view.Surface r0 = r3.surface
            if (r0 == 0) goto L_0x0030
            int r1 = r3.changeFrameRateStrategy
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L_0x0011
            goto L_0x0030
        L_0x0011:
            boolean r1 = r3.started
            if (r1 == 0) goto L_0x0021
            float r1 = r3.surfaceMediaFrameRate
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0021
            float r2 = r3.playbackSpeed
            float r1 = r1 * r2
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            if (r4 != 0) goto L_0x002b
            float r4 = r3.surfacePlaybackFrameRate
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 != 0) goto L_0x002b
            return
        L_0x002b:
            r3.surfacePlaybackFrameRate = r1
            com.google.android.exoplayer2.video.VideoFrameReleaseHelper.Api30.setSurfaceFrameRate(r0, r1)
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.VideoFrameReleaseHelper.updateSurfacePlaybackFrameRate(boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long adjustReleaseTime(long r11) {
        /*
            r10 = this;
            long r0 = r10.lastAdjustedFrameIndex
            r2 = -1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x002f
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r0 = r10.frameRateEstimator
            boolean r0 = r0.isSynced()
            if (r0 == 0) goto L_0x002f
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r0 = r10.frameRateEstimator
            long r0 = r0.getFrameDurationNs()
            long r2 = r10.lastAdjustedReleaseTimeNs
            long r4 = r10.frameIndex
            long r6 = r10.lastAdjustedFrameIndex
            long r4 = r4 - r6
            long r0 = r0 * r4
            float r0 = (float) r0
            float r1 = r10.playbackSpeed
            float r0 = r0 / r1
            long r0 = (long) r0
            long r2 = r2 + r0
            boolean r0 = adjustmentAllowed(r11, r2)
            if (r0 == 0) goto L_0x002c
            r4 = r2
            goto L_0x0030
        L_0x002c:
            r10.resetAdjustment()
        L_0x002f:
            r4 = r11
        L_0x0030:
            long r11 = r10.frameIndex
            r10.pendingLastAdjustedFrameIndex = r11
            r10.pendingLastAdjustedReleaseTimeNs = r4
            com.google.android.exoplayer2.video.VideoFrameReleaseHelper$VSyncSampler r11 = r10.vsyncSampler
            if (r11 == 0) goto L_0x0057
            long r0 = r10.vsyncDurationNs
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0046
            goto L_0x0057
        L_0x0046:
            long r6 = r11.sampledVsyncTimeNs
            int r11 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r11 != 0) goto L_0x004d
            return r4
        L_0x004d:
            long r8 = r10.vsyncDurationNs
            long r11 = closestVsync(r4, r6, r8)
            long r0 = r10.vsyncOffsetNs
            long r11 = r11 - r0
            return r11
        L_0x0057:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.VideoFrameReleaseHelper.adjustReleaseTime(long):long");
    }

    public void onFormatChanged(float f11) {
        this.formatFrameRate = f11;
        this.frameRateEstimator.reset();
        updateSurfaceMediaFrameRate();
    }

    public void onNextFrame(long j11) {
        long j12 = this.pendingLastAdjustedFrameIndex;
        if (j12 != -1) {
            this.lastAdjustedFrameIndex = j12;
            this.lastAdjustedReleaseTimeNs = this.pendingLastAdjustedReleaseTimeNs;
        }
        this.frameIndex++;
        this.frameRateEstimator.onNextFrame(j11 * 1000);
        updateSurfaceMediaFrameRate();
    }

    public void onPlaybackSpeed(float f11) {
        this.playbackSpeed = f11;
        resetAdjustment();
        updateSurfacePlaybackFrameRate(false);
    }

    public void onPositionReset() {
        resetAdjustment();
    }

    public void onStarted() {
        this.started = true;
        resetAdjustment();
        if (this.displayHelper != null) {
            ((VSyncSampler) Assertions.checkNotNull(this.vsyncSampler)).addObserver();
            this.displayHelper.register(new e(this));
        }
        updateSurfacePlaybackFrameRate(false);
    }

    public void onStopped() {
        this.started = false;
        DisplayHelper displayHelper2 = this.displayHelper;
        if (displayHelper2 != null) {
            displayHelper2.unregister();
            ((VSyncSampler) Assertions.checkNotNull(this.vsyncSampler)).removeObserver();
        }
        clearSurfaceFrameRate();
    }

    public void onSurfaceChanged(@Nullable Surface surface2) {
        if (surface2 instanceof PlaceholderSurface) {
            surface2 = null;
        }
        if (this.surface != surface2) {
            clearSurfaceFrameRate();
            this.surface = surface2;
            updateSurfacePlaybackFrameRate(true);
        }
    }

    public void setChangeFrameRateStrategy(int i11) {
        if (this.changeFrameRateStrategy != i11) {
            this.changeFrameRateStrategy = i11;
            updateSurfacePlaybackFrameRate(true);
        }
    }
}
