package io.flutter.plugin.platform;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugin.platform.SingleViewPresentation;
import io.flutter.view.TextureRegistry;

@TargetApi(20)
class VirtualDisplayController {
    private static String TAG = "VirtualDisplayController";
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public SingleViewPresentation f14274a;
    private final AccessibilityEventsDelegate accessibilityEventsDelegate;
    private int bufferHeight;
    private int bufferWidth;
    private final Context context;
    private final int densityDpi;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Surface surface;
    private final TextureRegistry.SurfaceTextureEntry textureEntry;
    private VirtualDisplay virtualDisplay;

    public static class OneTimeOnDrawListener implements ViewTreeObserver.OnDrawListener {

        /* renamed from: b  reason: collision with root package name */
        public final View f14279b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f14280c;

        public OneTimeOnDrawListener(View view, Runnable runnable) {
            this.f14279b = view;
            this.f14280c = runnable;
        }

        public static void a(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new OneTimeOnDrawListener(view, runnable));
        }

        public void onDraw() {
            Runnable runnable = this.f14280c;
            if (runnable != null) {
                runnable.run();
                this.f14280c = null;
                this.f14279b.post(new Runnable() {
                    public void run() {
                        OneTimeOnDrawListener.this.f14279b.getViewTreeObserver().removeOnDrawListener(OneTimeOnDrawListener.this);
                    }
                });
            }
        }
    }

    private VirtualDisplayController(Context context2, AccessibilityEventsDelegate accessibilityEventsDelegate2, VirtualDisplay virtualDisplay2, PlatformView platformView, Surface surface2, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, View.OnFocusChangeListener onFocusChangeListener, int i11, Object obj) {
        Context context3 = context2;
        this.context = context3;
        AccessibilityEventsDelegate accessibilityEventsDelegate3 = accessibilityEventsDelegate2;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate3;
        this.textureEntry = surfaceTextureEntry;
        View.OnFocusChangeListener onFocusChangeListener2 = onFocusChangeListener;
        this.focusChangeListener = onFocusChangeListener2;
        this.surface = surface2;
        this.virtualDisplay = virtualDisplay2;
        this.densityDpi = context2.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context3, this.virtualDisplay.getDisplay(), platformView, accessibilityEventsDelegate3, i11, onFocusChangeListener2);
        this.f14274a = singleViewPresentation;
        singleViewPresentation.show();
    }

    public static VirtualDisplayController create(Context context2, AccessibilityEventsDelegate accessibilityEventsDelegate2, PlatformView platformView, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, int i11, int i12, int i13, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        int i14 = i11;
        int i15 = i12;
        context2.getResources().getDisplayMetrics();
        if (i14 == 0 || i15 == 0) {
            return null;
        }
        surfaceTextureEntry.surfaceTexture().setDefaultBufferSize(i14, i15);
        Surface surface2 = new Surface(surfaceTextureEntry.surfaceTexture());
        VirtualDisplay createVirtualDisplay = ((DisplayManager) context2.getSystemService("display")).createVirtualDisplay("flutter-vd", i11, i12, context2.getResources().getDisplayMetrics().densityDpi, surface2, 0);
        if (createVirtualDisplay == null) {
            return null;
        }
        VirtualDisplayController virtualDisplayController = new VirtualDisplayController(context2, accessibilityEventsDelegate2, createVirtualDisplay, platformView, surface2, surfaceTextureEntry, onFocusChangeListener, i13, obj);
        virtualDisplayController.bufferWidth = i14;
        virtualDisplayController.bufferHeight = i15;
        return virtualDisplayController;
    }

    public void a(@NonNull View view) {
        SingleViewPresentation singleViewPresentation = this.f14274a;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.f14274a.getView().onFlutterViewAttached(view);
        }
    }

    public void b() {
        SingleViewPresentation singleViewPresentation = this.f14274a;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.f14274a.getView().onInputConnectionLocked();
        }
    }

    public void c() {
        SingleViewPresentation singleViewPresentation = this.f14274a;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.f14274a.getView().onInputConnectionUnlocked();
        }
    }

    public void dispatchTouchEvent(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.f14274a;
        if (singleViewPresentation != null) {
            singleViewPresentation.dispatchTouchEvent(motionEvent);
        }
    }

    public void dispose() {
        this.f14274a.cancel();
        this.f14274a.detachState();
        this.virtualDisplay.release();
        this.textureEntry.release();
    }

    public int getBufferHeight() {
        return this.bufferHeight;
    }

    public int getBufferWidth() {
        return this.bufferWidth;
    }

    public View getView() {
        SingleViewPresentation singleViewPresentation = this.f14274a;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().getView();
    }

    public void resize(int i11, int i12, final Runnable runnable) {
        boolean isFocused = getView().isFocused();
        SingleViewPresentation.PresentationState detachState = this.f14274a.detachState();
        this.virtualDisplay.setSurface((Surface) null);
        this.virtualDisplay.release();
        this.bufferWidth = i11;
        this.bufferHeight = i12;
        this.textureEntry.surfaceTexture().setDefaultBufferSize(i11, i12);
        this.virtualDisplay = ((DisplayManager) this.context.getSystemService("display")).createVirtualDisplay("flutter-vd", i11, i12, this.densityDpi, this.surface, 0);
        final View view = getView();
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
                OneTimeOnDrawListener.a(view, new Runnable() {
                    public void run() {
                        AnonymousClass1 r02 = AnonymousClass1.this;
                        view.postDelayed(runnable, 128);
                    }
                });
                view.removeOnAttachStateChangeListener(this);
            }

            public void onViewDetachedFromWindow(View view) {
            }
        });
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.context, this.virtualDisplay.getDisplay(), this.accessibilityEventsDelegate, detachState, this.focusChangeListener, isFocused);
        singleViewPresentation.show();
        this.f14274a.cancel();
        this.f14274a = singleViewPresentation;
    }
}
