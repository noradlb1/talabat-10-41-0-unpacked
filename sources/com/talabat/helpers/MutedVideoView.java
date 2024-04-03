package com.talabat.helpers;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Vector;

public class MutedVideoView extends SurfaceView implements MediaController.MediaPlayerControl {
    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    /* access modifiers changed from: private */
    public String TAG = "VideoView";

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer.OnVideoSizeChangedListener f60789b = new MediaPlayer.OnVideoSizeChangedListener() {
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i11, int i12) {
            MutedVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
            MutedVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
            if (MutedVideoView.this.mVideoWidth != 0 && MutedVideoView.this.mVideoHeight != 0) {
                MutedVideoView.this.getHolder().setFixedSize(MutedVideoView.this.mVideoWidth, MutedVideoView.this.mVideoHeight);
                MutedVideoView.this.requestLayout();
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public MediaPlayer.OnPreparedListener f60790c = new MediaPlayer.OnPreparedListener() {
        public void onPrepared(MediaPlayer mediaPlayer) {
            MutedVideoView.this.mCurrentState = 2;
            MutedVideoView mutedVideoView = MutedVideoView.this;
            mutedVideoView.mCanSeekForward = true;
            mutedVideoView.mCanSeekBack = true;
            mutedVideoView.mCanPause = true;
            if (MutedVideoView.this.mOnPreparedListener != null) {
                MutedVideoView.this.mOnPreparedListener.onPrepared(MutedVideoView.this.mMediaPlayer);
            }
            if (MutedVideoView.this.mMediaController != null) {
                MutedVideoView.this.mMediaController.setEnabled(true);
            }
            MutedVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
            MutedVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
            int i11 = MutedVideoView.this.mSeekWhenPrepared;
            if (i11 != 0) {
                MutedVideoView.this.seekTo(i11);
            }
            if (MutedVideoView.this.mVideoWidth != 0 && MutedVideoView.this.mVideoHeight != 0) {
                MutedVideoView.this.getHolder().setFixedSize(MutedVideoView.this.mVideoWidth, MutedVideoView.this.mVideoHeight);
                if (MutedVideoView.this.mSurfaceWidth != MutedVideoView.this.mVideoWidth || MutedVideoView.this.mSurfaceHeight != MutedVideoView.this.mVideoHeight) {
                    return;
                }
                if (MutedVideoView.this.mTargetState == 3) {
                    MutedVideoView.this.start();
                    if (MutedVideoView.this.mMediaController != null) {
                        MutedVideoView.this.mMediaController.show();
                    }
                } else if (MutedVideoView.this.isPlaying()) {
                } else {
                    if ((i11 != 0 || MutedVideoView.this.getCurrentPosition() > 0) && MutedVideoView.this.mMediaController != null) {
                        MutedVideoView.this.mMediaController.show(0);
                    }
                }
            } else if (MutedVideoView.this.mTargetState == 3) {
                MutedVideoView.this.start();
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public SurfaceHolder.Callback f60791d = new SurfaceHolder.Callback() {
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
            boolean z11;
            MutedVideoView.this.mSurfaceWidth = i12;
            MutedVideoView.this.mSurfaceHeight = i13;
            boolean z12 = true;
            if (MutedVideoView.this.mTargetState == 3) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!(MutedVideoView.this.mVideoWidth == i12 && MutedVideoView.this.mVideoHeight == i13)) {
                z12 = false;
            }
            if (MutedVideoView.this.mMediaPlayer != null && z11 && z12) {
                if (MutedVideoView.this.mSeekWhenPrepared != 0) {
                    MutedVideoView mutedVideoView = MutedVideoView.this;
                    mutedVideoView.seekTo(mutedVideoView.mSeekWhenPrepared);
                }
                MutedVideoView.this.start();
            }
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            MutedVideoView.this.mSurfaceHolder = surfaceHolder;
            MutedVideoView mutedVideoView = MutedVideoView.this;
            mutedVideoView.openVideo(Boolean.valueOf(mutedVideoView.mCanLoop));
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            MutedVideoView.this.mSurfaceHolder = null;
            if (MutedVideoView.this.mMediaController != null) {
                MutedVideoView.this.mMediaController.hide();
            }
            MutedVideoView.this.release(true);
        }
    };
    private int mAudioSession;
    private MediaPlayer.OnBufferingUpdateListener mBufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener() {
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i11) {
            MutedVideoView.this.mCurrentBufferPercentage = i11;
        }
    };
    /* access modifiers changed from: private */
    public boolean mCanLoop;
    /* access modifiers changed from: private */
    public boolean mCanPause;
    /* access modifiers changed from: private */
    public boolean mCanSeekBack;
    /* access modifiers changed from: private */
    public boolean mCanSeekForward;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            MutedVideoView.this.mCurrentState = 5;
            MutedVideoView.this.mTargetState = 5;
            if (MutedVideoView.this.mMediaController != null) {
                MutedVideoView.this.mMediaController.hide();
            }
            if (MutedVideoView.this.mOnCompletionListener != null) {
                MutedVideoView.this.mOnCompletionListener.onCompletion(MutedVideoView.this.mMediaPlayer);
            }
        }
    };
    /* access modifiers changed from: private */
    public int mCurrentBufferPercentage;
    /* access modifiers changed from: private */
    public int mCurrentState = 0;
    private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener() {
        public boolean onError(MediaPlayer mediaPlayer, int i11, int i12) {
            String unused = MutedVideoView.this.TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error: ");
            sb2.append(i11);
            sb2.append(",");
            sb2.append(i12);
            MutedVideoView.this.mCurrentState = -1;
            MutedVideoView.this.mTargetState = -1;
            if (MutedVideoView.this.mMediaController != null) {
                MutedVideoView.this.mMediaController.hide();
            }
            if (MutedVideoView.this.mOnErrorListener != null) {
                MutedVideoView.this.mOnErrorListener.onError(MutedVideoView.this.mMediaPlayer, i11, i12);
            }
            return true;
        }
    };
    private Map<String, String> mHeaders;
    private MediaPlayer.OnInfoListener mInfoListener = new MediaPlayer.OnInfoListener() {
        public boolean onInfo(MediaPlayer mediaPlayer, int i11, int i12) {
            if (MutedVideoView.this.mOnInfoListener == null) {
                return true;
            }
            MutedVideoView.this.mOnInfoListener.onInfo(mediaPlayer, i11, i12);
            return true;
        }
    };
    /* access modifiers changed from: private */
    public MediaController mMediaController;
    /* access modifiers changed from: private */
    public MediaPlayer mMediaPlayer = null;
    /* access modifiers changed from: private */
    public MediaPlayer.OnCompletionListener mOnCompletionListener;
    /* access modifiers changed from: private */
    public MediaPlayer.OnErrorListener mOnErrorListener;
    /* access modifiers changed from: private */
    public MediaPlayer.OnInfoListener mOnInfoListener;
    /* access modifiers changed from: private */
    public MediaPlayer.OnPreparedListener mOnPreparedListener;
    private Vector<Pair<InputStream, MediaFormat>> mPendingSubtitleTracks;
    /* access modifiers changed from: private */
    public int mSeekWhenPrepared;
    /* access modifiers changed from: private */
    public int mSurfaceHeight;
    /* access modifiers changed from: private */
    public SurfaceHolder mSurfaceHolder = null;
    /* access modifiers changed from: private */
    public int mSurfaceWidth;
    /* access modifiers changed from: private */
    public int mTargetState = 0;
    private Uri mUri;
    /* access modifiers changed from: private */
    public int mVideoHeight;
    /* access modifiers changed from: private */
    public int mVideoWidth;

    public MutedVideoView(Context context) {
        super(context);
        initVideoView();
    }

    private void attachMediaController() {
        MediaController mediaController;
        View view;
        if (this.mMediaPlayer != null && (mediaController = this.mMediaController) != null) {
            mediaController.setMediaPlayer(this);
            if (getParent() instanceof View) {
                view = (View) getParent();
            } else {
                view = this;
            }
            this.mMediaController.setAnchorView(view);
            this.mMediaController.setEnabled(isInPlaybackState());
        }
    }

    private void initVideoView() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.f60791d);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.mPendingSubtitleTracks = new Vector<>();
        this.mCurrentState = 0;
        this.mTargetState = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.mCurrentState;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isInPlaybackState() {
        /*
            r2 = this;
            android.media.MediaPlayer r0 = r2.mMediaPlayer
            if (r0 == 0) goto L_0x000f
            int r0 = r2.mCurrentState
            r1 = -1
            if (r0 == r1) goto L_0x000f
            if (r0 == 0) goto L_0x000f
            r1 = 1
            if (r0 == r1) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r1 = 0
        L_0x0010:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpers.MutedVideoView.isInPlaybackState():boolean");
    }

    /* access modifiers changed from: private */
    public void openVideo(Boolean bool) {
        if (this.mUri != null && this.mSurfaceHolder != null) {
            release(false);
            try {
                this.mCanLoop = bool.booleanValue();
                this.mMediaPlayer = new MediaPlayer();
                getContext();
                int i11 = this.mAudioSession;
                if (i11 != 0) {
                    this.mMediaPlayer.setAudioSessionId(i11);
                } else {
                    this.mAudioSession = this.mMediaPlayer.getAudioSessionId();
                }
                this.mMediaPlayer.setOnPreparedListener(this.f60790c);
                this.mMediaPlayer.setOnVideoSizeChangedListener(this.f60789b);
                this.mMediaPlayer.setOnCompletionListener(this.mCompletionListener);
                this.mMediaPlayer.setOnErrorListener(this.mErrorListener);
                this.mMediaPlayer.setOnInfoListener(this.mInfoListener);
                this.mMediaPlayer.setOnBufferingUpdateListener(this.mBufferingUpdateListener);
                this.mCurrentBufferPercentage = 0;
                this.mMediaPlayer.setDataSource(getContext(), this.mUri, this.mHeaders);
                this.mMediaPlayer.setDisplay(this.mSurfaceHolder);
                this.mMediaPlayer.setAudioStreamType(3);
                this.mMediaPlayer.setScreenOnWhilePlaying(true);
                this.mMediaPlayer.setLooping(this.mCanLoop);
                this.mMediaPlayer.prepareAsync();
                this.mCurrentState = 1;
                attachMediaController();
                this.mPendingSubtitleTracks.clear();
            } catch (IOException e11) {
                String str = this.TAG;
                Log.w(str, "Unable to open content: " + this.mUri, e11);
                this.mCurrentState = -1;
                this.mTargetState = -1;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
                this.mPendingSubtitleTracks.clear();
            } catch (IllegalArgumentException e12) {
                String str2 = this.TAG;
                Log.w(str2, "Unable to open content: " + this.mUri, e12);
                this.mCurrentState = -1;
                this.mTargetState = -1;
                this.mErrorListener.onError(this.mMediaPlayer, 1, 0);
                this.mPendingSubtitleTracks.clear();
            } catch (Throwable th2) {
                this.mPendingSubtitleTracks.clear();
                throw th2;
            }
        }
    }

    /* access modifiers changed from: private */
    public void release(boolean z11) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
            this.mPendingSubtitleTracks.clear();
            this.mCurrentState = 0;
            if (z11) {
                this.mTargetState = 0;
            }
        }
    }

    private void toggleMediaControlsVisiblity() {
        if (this.mMediaController.isShowing()) {
            this.mMediaController.hide();
        } else {
            this.mMediaController.show();
        }
    }

    public boolean canPause() {
        return this.mCanPause;
    }

    public boolean canSeekBackward() {
        return this.mCanSeekBack;
    }

    public boolean canSeekForward() {
        return this.mCanSeekForward;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public int getAudioSessionId() {
        if (this.mAudioSession == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mAudioSession = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.mAudioSession;
    }

    public int getBufferPercentage() {
        if (this.mMediaPlayer != null) {
            return this.mCurrentBufferPercentage;
        }
        return 0;
    }

    public int getCurrentPosition() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (isInPlaybackState()) {
            return this.mMediaPlayer.getDuration();
        }
        return -1;
    }

    public boolean isPlaying() {
        return isInPlaybackState() && this.mMediaPlayer.isPlaying();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(MutedVideoView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(MutedVideoView.class.getName());
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        boolean z11;
        if (i11 == 4 || i11 == 24 || i11 == 25 || i11 == 164 || i11 == 82 || i11 == 5 || i11 == 6) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (isInPlaybackState() && z11 && this.mMediaController != null) {
            if (i11 == 79 || i11 == 85) {
                if (this.mMediaPlayer.isPlaying()) {
                    pause();
                    this.mMediaController.show();
                } else {
                    start();
                    this.mMediaController.hide();
                }
                return true;
            } else if (i11 == 126) {
                if (!this.mMediaPlayer.isPlaying()) {
                    start();
                    this.mMediaController.hide();
                }
                return true;
            } else if (i11 == 86 || i11 == 127) {
                if (this.mMediaPlayer.isPlaying()) {
                    pause();
                    this.mMediaController.show();
                }
                return true;
            } else {
                toggleMediaControlsVisiblity();
            }
        }
        return super.onKeyDown(i11, keyEvent);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        if (r1 > r6) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.mVideoWidth
            int r0 = android.view.View.getDefaultSize(r0, r6)
            int r1 = r5.mVideoHeight
            int r1 = android.view.View.getDefaultSize(r1, r7)
            int r2 = r5.mVideoWidth
            if (r2 <= 0) goto L_0x007a
            int r2 = r5.mVideoHeight
            if (r2 <= 0) goto L_0x007a
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L_0x0041
            if (r1 != r2) goto L_0x0041
            int r0 = r5.mVideoWidth
            int r1 = r0 * r7
            int r2 = r5.mVideoHeight
            int r3 = r6 * r2
            if (r1 >= r3) goto L_0x0037
            int r0 = r0 * r7
            int r0 = r0 / r2
            goto L_0x0062
        L_0x0037:
            int r1 = r0 * r7
            int r3 = r6 * r2
            if (r1 <= r3) goto L_0x005f
            int r2 = r2 * r6
            int r1 = r2 / r0
            goto L_0x0051
        L_0x0041:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L_0x0053
            int r0 = r5.mVideoHeight
            int r0 = r0 * r6
            int r2 = r5.mVideoWidth
            int r0 = r0 / r2
            if (r1 != r3) goto L_0x0050
            if (r0 <= r7) goto L_0x0050
            goto L_0x005f
        L_0x0050:
            r1 = r0
        L_0x0051:
            r0 = r6
            goto L_0x007a
        L_0x0053:
            if (r1 != r2) goto L_0x0064
            int r1 = r5.mVideoWidth
            int r1 = r1 * r7
            int r2 = r5.mVideoHeight
            int r1 = r1 / r2
            if (r0 != r3) goto L_0x0061
            if (r1 <= r6) goto L_0x0061
        L_0x005f:
            r0 = r6
            goto L_0x0062
        L_0x0061:
            r0 = r1
        L_0x0062:
            r1 = r7
            goto L_0x007a
        L_0x0064:
            int r2 = r5.mVideoWidth
            int r4 = r5.mVideoHeight
            if (r1 != r3) goto L_0x0070
            if (r4 <= r7) goto L_0x0070
            int r1 = r7 * r2
            int r1 = r1 / r4
            goto L_0x0072
        L_0x0070:
            r1 = r2
            r7 = r4
        L_0x0072:
            if (r0 != r3) goto L_0x0061
            if (r1 <= r6) goto L_0x0061
            int r4 = r4 * r6
            int r1 = r4 / r2
            goto L_0x0051
        L_0x007a:
            r5.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.helpers.MutedVideoView.onMeasure(int, int):void");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isInPlaybackState() || this.mMediaController == null) {
            return false;
        }
        toggleMediaControlsVisiblity();
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!isInPlaybackState() || this.mMediaController == null) {
            return false;
        }
        toggleMediaControlsVisiblity();
        return false;
    }

    public void pause() {
        if (isInPlaybackState() && this.mMediaPlayer.isPlaying()) {
            this.mMediaPlayer.pause();
            this.mCurrentState = 4;
        }
        this.mTargetState = 4;
    }

    public void resume() {
        openVideo(Boolean.valueOf(this.mCanLoop));
    }

    public void seekTo(int i11) {
        if (isInPlaybackState()) {
            this.mMediaPlayer.seekTo(i11);
            this.mSeekWhenPrepared = 0;
            return;
        }
        this.mSeekWhenPrepared = i11;
    }

    public void setCanLoop(Boolean bool) {
        this.mCanLoop = bool.booleanValue();
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setVideoURI(Uri uri, boolean z11) {
        setVideoURI(uri, (Map<String, String>) null, Boolean.valueOf(z11));
    }

    public void start() {
        if (isInPlaybackState()) {
            this.mMediaPlayer.start();
            this.mCurrentState = 3;
        }
        this.mTargetState = 3;
    }

    public void setVideoURI(Uri uri, Map<String, String> map, Boolean bool) {
        this.mUri = uri;
        this.mHeaders = map;
        this.mSeekWhenPrepared = 0;
        openVideo(bool);
        requestLayout();
        invalidate();
    }

    public MutedVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        initVideoView();
    }

    public MutedVideoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initVideoView();
    }

    @TargetApi(21)
    public MutedVideoView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        initVideoView();
    }
}
