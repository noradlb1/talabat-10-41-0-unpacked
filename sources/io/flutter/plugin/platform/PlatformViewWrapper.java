package io.flutter.plugin.platform;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.util.ViewUtils;
import io.flutter.view.TextureRegistry;
import java.util.concurrent.atomic.AtomicLong;

@TargetApi(23)
class PlatformViewWrapper extends FrameLayout {
    private static final String TAG = "PlatformViewWrapper";
    @VisibleForTesting
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public ViewTreeObserver.OnGlobalFocusChangeListener f14264b;
    private int bufferHeight;
    private int bufferWidth;
    private final TextureRegistry.OnFrameConsumedListener frameConsumedListener;
    private int left;
    /* access modifiers changed from: private */
    public final AtomicLong pendingFramesCount;
    private int prevLeft;
    private int prevTop;
    /* access modifiers changed from: private */
    public boolean shouldRecreateSurfaceForLowMemory;
    private Surface surface;
    private int top;
    private AndroidTouchProcessor touchProcessor;
    private final TextureRegistry.OnTrimMemoryListener trimMemoryListener;

    /* renamed from: tx  reason: collision with root package name */
    private SurfaceTexture f14265tx;

    public PlatformViewWrapper(@NonNull Context context) {
        super(context);
        this.pendingFramesCount = new AtomicLong(0);
        this.frameConsumedListener = new TextureRegistry.OnFrameConsumedListener() {
            public void onFrameConsumed() {
                if (Build.VERSION.SDK_INT == 29) {
                    PlatformViewWrapper.this.pendingFramesCount.decrementAndGet();
                }
            }
        };
        this.shouldRecreateSurfaceForLowMemory = false;
        this.trimMemoryListener = new TextureRegistry.OnTrimMemoryListener() {
            public void onTrimMemory(int i11) {
                if (i11 == 80 && Build.VERSION.SDK_INT >= 29) {
                    boolean unused = PlatformViewWrapper.this.shouldRecreateSurfaceForLowMemory = true;
                }
            }
        };
        setWillNotDraw(false);
    }

    private void onFrameProduced() {
        if (Build.VERSION.SDK_INT == 29) {
            this.pendingFramesCount.incrementAndGet();
        }
    }

    private void recreateSurfaceIfNeeded() {
        if (this.shouldRecreateSurfaceForLowMemory) {
            Surface surface2 = this.surface;
            if (surface2 != null) {
                surface2.release();
            }
            this.surface = c(this.f14265tx);
            this.shouldRecreateSurfaceForLowMemory = false;
        }
    }

    private boolean shouldDrawToSurfaceNow() {
        if (Build.VERSION.SDK_INT != 29 || this.pendingFramesCount.get() <= 0) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    @NonNull
    public Surface c(@NonNull SurfaceTexture surfaceTexture) {
        return new Surface(surfaceTexture);
    }

    @SuppressLint({"NewApi"})
    public void draw(Canvas canvas) {
        Surface surface2 = this.surface;
        if (surface2 == null) {
            super.draw(canvas);
            Log.e(TAG, "Platform view cannot be composed without a surface.");
        } else if (!surface2.isValid()) {
            Log.e(TAG, "Invalid surface. The platform view cannot be displayed.");
        } else {
            SurfaceTexture surfaceTexture = this.f14265tx;
            if (surfaceTexture == null || surfaceTexture.isReleased()) {
                Log.e(TAG, "Invalid texture. The platform view cannot be displayed.");
            } else if (!shouldDrawToSurfaceNow()) {
                invalidate();
            } else {
                recreateSurfaceIfNeeded();
                Canvas lockHardwareCanvas = this.surface.lockHardwareCanvas();
                try {
                    lockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    super.draw(lockHardwareCanvas);
                    onFrameProduced();
                } finally {
                    this.surface.unlockCanvasAndPost(lockHardwareCanvas);
                }
            }
        }
    }

    public int getBufferHeight() {
        return this.bufferHeight;
    }

    public int getBufferWidth() {
        return this.bufferWidth;
    }

    @Nullable
    public SurfaceTexture getTexture() {
        return this.f14265tx;
    }

    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    @SuppressLint({"NewApi"})
    public void onDescendantInvalidated(@NonNull View view, @NonNull View view2) {
        super.onDescendantInvalidated(view, view2);
        invalidate();
    }

    public boolean onInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (this.touchProcessor == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i11 = this.left;
            this.prevLeft = i11;
            int i12 = this.top;
            this.prevTop = i12;
            matrix.postTranslate((float) i11, (float) i12);
        } else if (action != 2) {
            matrix.postTranslate((float) this.left, (float) this.top);
        } else {
            matrix.postTranslate((float) this.prevLeft, (float) this.prevTop);
            this.prevLeft = this.left;
            this.prevTop = this.top;
        }
        return this.touchProcessor.onTouchEvent(motionEvent, matrix);
    }

    public void release() {
        this.f14265tx = null;
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
            this.surface = null;
        }
    }

    public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getImportantForAccessibility() != 4) {
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }
        return false;
    }

    public void setBufferSize(int i11, int i12) {
        this.bufferWidth = i11;
        this.bufferHeight = i12;
        SurfaceTexture surfaceTexture = this.f14265tx;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i11, i12);
        }
    }

    public void setLayoutParams(@NonNull FrameLayout.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.left = layoutParams.leftMargin;
        this.top = layoutParams.topMargin;
    }

    public void setOnDescendantFocusChangeListener(@NonNull final View.OnFocusChangeListener onFocusChangeListener) {
        unsetOnDescendantFocusChangeListener();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.f14264b == null) {
            AnonymousClass3 r12 = new ViewTreeObserver.OnGlobalFocusChangeListener() {
                public void onGlobalFocusChanged(View view, View view2) {
                    View.OnFocusChangeListener onFocusChangeListener = onFocusChangeListener;
                    PlatformViewWrapper platformViewWrapper = PlatformViewWrapper.this;
                    onFocusChangeListener.onFocusChange(platformViewWrapper, ViewUtils.childHasFocus(platformViewWrapper));
                }
            };
            this.f14264b = r12;
            viewTreeObserver.addOnGlobalFocusChangeListener(r12);
        }
    }

    @SuppressLint({"NewApi"})
    public void setTexture(@Nullable SurfaceTexture surfaceTexture) {
        int i11;
        this.f14265tx = surfaceTexture;
        int i12 = this.bufferWidth;
        if (i12 > 0 && (i11 = this.bufferHeight) > 0) {
            surfaceTexture.setDefaultBufferSize(i12, i11);
        }
        Surface surface2 = this.surface;
        if (surface2 != null) {
            surface2.release();
        }
        Surface c11 = c(surfaceTexture);
        this.surface = c11;
        Canvas lockHardwareCanvas = c11.lockHardwareCanvas();
        try {
            lockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            onFrameProduced();
        } finally {
            this.surface.unlockCanvasAndPost(lockHardwareCanvas);
        }
    }

    public void setTouchProcessor(@Nullable AndroidTouchProcessor androidTouchProcessor) {
        this.touchProcessor = androidTouchProcessor;
    }

    public void unsetOnDescendantFocusChangeListener() {
        ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive() && (onGlobalFocusChangeListener = this.f14264b) != null) {
            this.f14264b = null;
            viewTreeObserver.removeOnGlobalFocusChangeListener(onGlobalFocusChangeListener);
        }
    }

    public PlatformViewWrapper(@NonNull Context context, @NonNull TextureRegistry.SurfaceTextureEntry surfaceTextureEntry) {
        this(context);
        surfaceTextureEntry.setOnFrameConsumedListener(this.frameConsumedListener);
        surfaceTextureEntry.setOnTrimMemoryListener(this.trimMemoryListener);
        setTexture(surfaceTextureEntry.surfaceTexture());
    }
}
