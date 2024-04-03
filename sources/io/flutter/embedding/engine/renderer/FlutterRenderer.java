package io.flutter.embedding.engine.renderer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public class FlutterRenderer implements TextureRegistry {
    private static final String TAG = "FlutterRenderer";
    /* access modifiers changed from: private */
    @NonNull
    public final FlutterJNI flutterJNI;
    @NonNull
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public boolean isDisplayingFlutterUi = false;
    @NonNull
    private final AtomicLong nextTextureId = new AtomicLong(0);
    @NonNull
    private final Set<WeakReference<TextureRegistry.OnTrimMemoryListener>> onTrimMemoryListeners = new HashSet();
    @Nullable
    private Surface surface;

    public enum DisplayFeatureState {
        UNKNOWN(0),
        POSTURE_FLAT(1),
        POSTURE_HALF_OPENED(2);
        
        public final int encodedValue;

        private DisplayFeatureState(int i11) {
            this.encodedValue = i11;
        }
    }

    public enum DisplayFeatureType {
        UNKNOWN(0),
        FOLD(1),
        HINGE(2),
        CUTOUT(3);
        
        public final int encodedValue;

        private DisplayFeatureType(int i11) {
            this.encodedValue = i11;
        }
    }

    public static final class SurfaceTextureFinalizerRunnable implements Runnable {
        private final FlutterJNI flutterJNI;

        /* renamed from: id  reason: collision with root package name */
        private final long f14202id;

        public SurfaceTextureFinalizerRunnable(long j11, @NonNull FlutterJNI flutterJNI2) {
            this.f14202id = j11;
            this.flutterJNI = flutterJNI2;
        }

        public void run() {
            if (this.flutterJNI.isAttached()) {
                Log.v(FlutterRenderer.TAG, "Releasing a SurfaceTexture (" + this.f14202id + ").");
                this.flutterJNI.unregisterTexture(this.f14202id);
            }
        }
    }

    public final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry, TextureRegistry.OnTrimMemoryListener {
        /* access modifiers changed from: private */
        @Nullable
        public TextureRegistry.OnFrameConsumedListener frameConsumedListener;
        /* access modifiers changed from: private */

        /* renamed from: id  reason: collision with root package name */
        public final long f14204id;
        private final Runnable onFrameConsumed;
        private SurfaceTexture.OnFrameAvailableListener onFrameListener = new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(@NonNull SurfaceTexture surfaceTexture) {
                if (!SurfaceTextureRegistryEntry.this.released && FlutterRenderer.this.flutterJNI.isAttached()) {
                    SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = SurfaceTextureRegistryEntry.this;
                    FlutterRenderer.this.markTextureFrameAvailable(surfaceTextureRegistryEntry.f14204id);
                }
            }
        };
        /* access modifiers changed from: private */
        public boolean released;
        @NonNull
        private final SurfaceTextureWrapper textureWrapper;
        @Nullable
        private TextureRegistry.OnTrimMemoryListener trimMemoryListener;

        public SurfaceTextureRegistryEntry(long j11, @NonNull SurfaceTexture surfaceTexture) {
            AnonymousClass1 r22 = new Runnable() {
                public void run() {
                    if (SurfaceTextureRegistryEntry.this.frameConsumedListener != null) {
                        SurfaceTextureRegistryEntry.this.frameConsumedListener.onFrameConsumed();
                    }
                }
            };
            this.onFrameConsumed = r22;
            this.f14204id = j11;
            this.textureWrapper = new SurfaceTextureWrapper(surfaceTexture, r22);
            surfaceTexture().setOnFrameAvailableListener(this.onFrameListener, new Handler());
        }

        private void removeListener() {
            FlutterRenderer.this.g(this);
        }

        public void finalize() throws Throwable {
            try {
                if (!this.released) {
                    FlutterRenderer.this.handler.post(new SurfaceTextureFinalizerRunnable(this.f14204id, FlutterRenderer.this.flutterJNI));
                    super.finalize();
                }
            } finally {
                super.finalize();
            }
        }

        public long id() {
            return this.f14204id;
        }

        public void onTrimMemory(int i11) {
            TextureRegistry.OnTrimMemoryListener onTrimMemoryListener = this.trimMemoryListener;
            if (onTrimMemoryListener != null) {
                onTrimMemoryListener.onTrimMemory(i11);
            }
        }

        public void release() {
            if (!this.released) {
                Log.v(FlutterRenderer.TAG, "Releasing a SurfaceTexture (" + this.f14204id + ").");
                this.textureWrapper.release();
                FlutterRenderer.this.unregisterTexture(this.f14204id);
                removeListener();
                this.released = true;
            }
        }

        public void setOnFrameConsumedListener(@Nullable TextureRegistry.OnFrameConsumedListener onFrameConsumedListener) {
            this.frameConsumedListener = onFrameConsumedListener;
        }

        public void setOnTrimMemoryListener(@Nullable TextureRegistry.OnTrimMemoryListener onTrimMemoryListener) {
            this.trimMemoryListener = onTrimMemoryListener;
        }

        @NonNull
        public SurfaceTexture surfaceTexture() {
            return this.textureWrapper.surfaceTexture();
        }

        @NonNull
        public SurfaceTextureWrapper textureWrapper() {
            return this.textureWrapper;
        }
    }

    public static final class ViewportMetrics {
        public static final int unsetValue = -1;
        public float devicePixelRatio = 1.0f;
        public List<DisplayFeature> displayFeatures = new ArrayList();
        public int height = 0;
        public int physicalTouchSlop = -1;
        public int systemGestureInsetBottom = 0;
        public int systemGestureInsetLeft = 0;
        public int systemGestureInsetRight = 0;
        public int systemGestureInsetTop = 0;
        public int viewInsetBottom = 0;
        public int viewInsetLeft = 0;
        public int viewInsetRight = 0;
        public int viewInsetTop = 0;
        public int viewPaddingBottom = 0;
        public int viewPaddingLeft = 0;
        public int viewPaddingRight = 0;
        public int viewPaddingTop = 0;
        public int width = 0;

        public boolean a() {
            return this.width > 0 && this.height > 0 && this.devicePixelRatio > 0.0f;
        }
    }

    public FlutterRenderer(@NonNull FlutterJNI flutterJNI2) {
        AnonymousClass1 r02 = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterRenderer.this.isDisplayingFlutterUi = true;
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterRenderer.this.isDisplayingFlutterUi = false;
            }
        };
        this.flutterUiDisplayListener = r02;
        this.flutterJNI = flutterJNI2;
        flutterJNI2.addIsDisplayingFlutterUiListener(r02);
    }

    private void clearDeadListeners() {
        Iterator<WeakReference<TextureRegistry.OnTrimMemoryListener>> it = this.onTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            if (((TextureRegistry.OnTrimMemoryListener) it.next().get()) == null) {
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    public void markTextureFrameAvailable(long j11) {
        this.flutterJNI.markTextureFrameAvailable(j11);
    }

    private void registerTexture(long j11, @NonNull SurfaceTextureWrapper surfaceTextureWrapper) {
        this.flutterJNI.registerTexture(j11, surfaceTextureWrapper);
    }

    /* access modifiers changed from: private */
    public void unregisterTexture(long j11) {
        this.flutterJNI.unregisterTexture(j11);
    }

    public void addIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener2) {
        this.flutterJNI.addIsDisplayingFlutterUiListener(flutterUiDisplayListener2);
        if (this.isDisplayingFlutterUi) {
            flutterUiDisplayListener2.onFlutterUiDisplayed();
        }
    }

    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        Log.v(TAG, "Creating a SurfaceTexture.");
        return registerSurfaceTexture(new SurfaceTexture(0));
    }

    public void dispatchPointerDataPacket(@NonNull ByteBuffer byteBuffer, int i11) {
        this.flutterJNI.dispatchPointerDataPacket(byteBuffer, i11);
    }

    public void dispatchSemanticsAction(int i11, int i12, @Nullable ByteBuffer byteBuffer, int i13) {
        this.flutterJNI.dispatchSemanticsAction(i11, i12, byteBuffer, i13);
    }

    @VisibleForTesting
    public void f(@NonNull TextureRegistry.OnTrimMemoryListener onTrimMemoryListener) {
        clearDeadListeners();
        this.onTrimMemoryListeners.add(new WeakReference(onTrimMemoryListener));
    }

    @VisibleForTesting
    public void g(@NonNull TextureRegistry.OnTrimMemoryListener onTrimMemoryListener) {
        for (WeakReference next : this.onTrimMemoryListeners) {
            if (next.get() == onTrimMemoryListener) {
                this.onTrimMemoryListeners.remove(next);
                return;
            }
        }
    }

    public Bitmap getBitmap() {
        return this.flutterJNI.getBitmap();
    }

    public boolean isDisplayingFlutterUi() {
        return this.isDisplayingFlutterUi;
    }

    public boolean isSoftwareRenderingEnabled() {
        return this.flutterJNI.getIsSoftwareRenderingEnabled();
    }

    public void onTrimMemory(int i11) {
        Iterator<WeakReference<TextureRegistry.OnTrimMemoryListener>> it = this.onTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            TextureRegistry.OnTrimMemoryListener onTrimMemoryListener = (TextureRegistry.OnTrimMemoryListener) it.next().get();
            if (onTrimMemoryListener != null) {
                onTrimMemoryListener.onTrimMemory(i11);
            } else {
                it.remove();
            }
        }
    }

    public TextureRegistry.SurfaceTextureEntry registerSurfaceTexture(@NonNull SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this.nextTextureId.getAndIncrement(), surfaceTexture);
        Log.v(TAG, "New SurfaceTexture ID: " + surfaceTextureRegistryEntry.id());
        registerTexture(surfaceTextureRegistryEntry.id(), surfaceTextureRegistryEntry.textureWrapper());
        f(surfaceTextureRegistryEntry);
        return surfaceTextureRegistryEntry;
    }

    public void removeIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener2) {
        this.flutterJNI.removeIsDisplayingFlutterUiListener(flutterUiDisplayListener2);
    }

    public void setAccessibilityFeatures(int i11) {
        this.flutterJNI.setAccessibilityFeatures(i11);
    }

    public void setSemanticsEnabled(boolean z11) {
        this.flutterJNI.setSemanticsEnabled(z11);
    }

    public void setViewportMetrics(@NonNull ViewportMetrics viewportMetrics) {
        ViewportMetrics viewportMetrics2 = viewportMetrics;
        if (viewportMetrics.a()) {
            Log.v(TAG, "Setting viewport metrics\nSize: " + viewportMetrics2.width + " x " + viewportMetrics2.height + "\nPadding - L: " + viewportMetrics2.viewPaddingLeft + ", T: " + viewportMetrics2.viewPaddingTop + ", R: " + viewportMetrics2.viewPaddingRight + ", B: " + viewportMetrics2.viewPaddingBottom + "\nInsets - L: " + viewportMetrics2.viewInsetLeft + ", T: " + viewportMetrics2.viewInsetTop + ", R: " + viewportMetrics2.viewInsetRight + ", B: " + viewportMetrics2.viewInsetBottom + "\nSystem Gesture Insets - L: " + viewportMetrics2.systemGestureInsetLeft + ", T: " + viewportMetrics2.systemGestureInsetTop + ", R: " + viewportMetrics2.systemGestureInsetRight + ", B: " + viewportMetrics2.systemGestureInsetRight + "\nDisplay Features: " + viewportMetrics2.displayFeatures.size());
            int[] iArr = new int[(viewportMetrics2.displayFeatures.size() * 4)];
            int[] iArr2 = new int[viewportMetrics2.displayFeatures.size()];
            int[] iArr3 = new int[viewportMetrics2.displayFeatures.size()];
            for (int i11 = 0; i11 < viewportMetrics2.displayFeatures.size(); i11++) {
                DisplayFeature displayFeature = viewportMetrics2.displayFeatures.get(i11);
                int i12 = i11 * 4;
                Rect rect = displayFeature.bounds;
                iArr[i12] = rect.left;
                iArr[i12 + 1] = rect.top;
                iArr[i12 + 2] = rect.right;
                iArr[i12 + 3] = rect.bottom;
                iArr2[i11] = displayFeature.type.encodedValue;
                iArr3[i11] = displayFeature.state.encodedValue;
            }
            int[] iArr4 = iArr3;
            FlutterJNI flutterJNI2 = this.flutterJNI;
            flutterJNI2.setViewportMetrics(viewportMetrics2.devicePixelRatio, viewportMetrics2.width, viewportMetrics2.height, viewportMetrics2.viewPaddingTop, viewportMetrics2.viewPaddingRight, viewportMetrics2.viewPaddingBottom, viewportMetrics2.viewPaddingLeft, viewportMetrics2.viewInsetTop, viewportMetrics2.viewInsetRight, viewportMetrics2.viewInsetBottom, viewportMetrics2.viewInsetLeft, viewportMetrics2.systemGestureInsetTop, viewportMetrics2.systemGestureInsetRight, viewportMetrics2.systemGestureInsetBottom, viewportMetrics2.systemGestureInsetLeft, viewportMetrics2.physicalTouchSlop, iArr, iArr2, iArr4);
        }
    }

    public void startRenderingToSurface(@NonNull Surface surface2, boolean z11) {
        if (this.surface != null && !z11) {
            stopRenderingToSurface();
        }
        this.surface = surface2;
        this.flutterJNI.onSurfaceCreated(surface2);
    }

    public void stopRenderingToSurface() {
        this.flutterJNI.onSurfaceDestroyed();
        this.surface = null;
        if (this.isDisplayingFlutterUi) {
            this.flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
        }
        this.isDisplayingFlutterUi = false;
    }

    public void surfaceChanged(int i11, int i12) {
        this.flutterJNI.onSurfaceChanged(i11, i12);
    }

    public void swapSurface(@NonNull Surface surface2) {
        this.surface = surface2;
        this.flutterJNI.onSurfaceWindowChanged(surface2);
    }

    public static final class DisplayFeature {
        public final Rect bounds;
        public final DisplayFeatureState state;
        public final DisplayFeatureType type;

        public DisplayFeature(Rect rect, DisplayFeatureType displayFeatureType, DisplayFeatureState displayFeatureState) {
            this.bounds = rect;
            this.type = displayFeatureType;
            this.state = displayFeatureState;
        }

        public DisplayFeature(Rect rect, DisplayFeatureType displayFeatureType) {
            this.bounds = rect;
            this.type = displayFeatureType;
            this.state = DisplayFeatureState.UNKNOWN;
        }
    }
}
