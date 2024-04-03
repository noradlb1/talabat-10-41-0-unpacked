package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textservice.TextServicesManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import io.flutter.Log;
import io.flutter.embedding.android.FlutterImageView;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.RenderSurface;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.editing.SpellCheckPlugin;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.util.ViewUtils;
import io.flutter.view.AccessibilityBridge;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlutterView extends FrameLayout implements MouseCursorPlugin.MouseCursorViewDelegate, KeyboardManager.ViewDelegate {
    private static final String TAG = "FlutterView";
    @Nullable
    private AccessibilityBridge accessibilityBridge;
    @Nullable
    private AndroidTouchProcessor androidTouchProcessor;
    @VisibleForTesting
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public RenderSurface f14141b;
    /* access modifiers changed from: private */
    @Nullable
    public FlutterEngine flutterEngine;
    @NonNull
    private final Set<FlutterEngineAttachmentListener> flutterEngineAttachmentListeners;
    /* access modifiers changed from: private */
    @Nullable
    public FlutterImageView flutterImageView;
    @Nullable
    private FlutterSurfaceView flutterSurfaceView;
    @Nullable
    private FlutterTextureView flutterTextureView;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    /* access modifiers changed from: private */
    public final Set<FlutterUiDisplayListener> flutterUiDisplayListeners;
    /* access modifiers changed from: private */
    public boolean isFlutterUiDisplayed;
    @Nullable
    private KeyboardManager keyboardManager;
    @Nullable
    private LocalizationPlugin localizationPlugin;
    @Nullable
    private MouseCursorPlugin mouseCursorPlugin;
    private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    @Nullable
    private RenderSurface previousRenderSurface;
    @Nullable
    private SpellCheckPlugin spellCheckPlugin;
    private final ContentObserver systemSettingsObserver;
    @Nullable
    private TextInputPlugin textInputPlugin;
    @Nullable
    private TextServicesManager textServicesManager;
    private final FlutterRenderer.ViewportMetrics viewportMetrics;
    private final Consumer<WindowLayoutInfo> windowInfoListener;
    @Nullable
    private WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepo;

    @VisibleForTesting
    public interface FlutterEngineAttachmentListener {
        void onFlutterEngineAttachedToFlutterView(@NonNull FlutterEngine flutterEngine);

        void onFlutterEngineDetachedFromFlutterView();
    }

    public enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public FlutterView(@NonNull Context context) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context));
    }

    private ZeroSides calculateShouldZeroSides() {
        Context context = getContext();
        int i11 = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i11 == 2) {
            if (rotation == 1) {
                return ZeroSides.RIGHT;
            }
            if (rotation == 3) {
                return ZeroSides.LEFT;
            }
            if (rotation == 0 || rotation == 2) {
                return ZeroSides.BOTH;
            }
        }
        return ZeroSides.NONE;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @android.annotation.SuppressLint({"DiscouragedPrivateApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View findViewByAccessibilityIdRootedAtCurrentView(int r6, android.view.View r7) {
        /*
            r5 = this;
            r0 = 0
            java.lang.Class<android.view.View> r1 = android.view.View.class
            java.lang.String r2 = "getAccessibilityViewId"
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r4)     // Catch:{  }
            r2 = 1
            r1.setAccessible(r2)
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x003c }
            java.lang.Object r1 = r1.invoke(r7, r2)     // Catch:{ NoSuchMethodException -> 0x003c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)     // Catch:{ NoSuchMethodException -> 0x003c }
            boolean r1 = r1.equals(r2)     // Catch:{ NoSuchMethodException -> 0x003c }
            if (r1 == 0) goto L_0x0021
            return r7
        L_0x0021:
            boolean r1 = r7 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x003c
        L_0x0025:
            r1 = r7
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            int r2 = r1.getChildCount()
            if (r3 >= r2) goto L_0x003c
            android.view.View r1 = r1.getChildAt(r3)
            android.view.View r1 = r5.findViewByAccessibilityIdRootedAtCurrentView(r6, r1)
            if (r1 == 0) goto L_0x0039
            return r1
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0025
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterView.findViewByAccessibilityIdRootedAtCurrentView(int, android.view.View):android.view.View");
    }

    @RequiresApi(20)
    @TargetApi(20)
    private int guessBottomKeyboardInset(WindowInsets windowInsets) {
        if (((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    private void init() {
        Log.v(TAG, "Initializing FlutterView");
        if (this.flutterSurfaceView != null) {
            Log.v(TAG, "Internally using a FlutterSurfaceView.");
            addView(this.flutterSurfaceView);
        } else if (this.flutterTextureView != null) {
            Log.v(TAG, "Internally using a FlutterTextureView.");
            addView(this.flutterTextureView);
        } else {
            Log.v(TAG, "Internally using a FlutterImageView.");
            addView(this.flutterImageView);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(4);
        }
    }

    /* access modifiers changed from: private */
    public void resetWillNotDraw(boolean z11, boolean z12) {
        boolean z13 = false;
        if (!this.flutterEngine.getRenderer().isSoftwareRenderingEnabled()) {
            if (!z11 && !z12) {
                z13 = true;
            }
            setWillNotDraw(z13);
            return;
        }
        setWillNotDraw(false);
    }

    private void sendViewportMetricsToFlutter() {
        if (!isAttachedToFlutterEngine()) {
            Log.w(TAG, "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.viewportMetrics.devicePixelRatio = getResources().getDisplayMetrics().density;
        this.viewportMetrics.physicalTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.flutterEngine.getRenderer().setViewportMetrics(this.viewportMetrics);
    }

    public boolean acquireLatestImageViewFrame() {
        FlutterImageView flutterImageView2 = this.flutterImageView;
        if (flutterImageView2 != null) {
            return flutterImageView2.acquireLatestImage();
        }
        return false;
    }

    @VisibleForTesting
    public void addFlutterEngineAttachmentListener(@NonNull FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.flutterEngineAttachmentListeners.add(flutterEngineAttachmentListener);
    }

    public void addOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener2) {
        this.flutterUiDisplayListeners.add(flutterUiDisplayListener2);
    }

    public void attachOverlaySurfaceToRender(@NonNull FlutterImageView flutterImageView2) {
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 != null) {
            flutterImageView2.attachToRenderer(flutterEngine2.getRenderer());
        }
    }

    public void attachToFlutterEngine(@NonNull FlutterEngine flutterEngine2) {
        Log.v(TAG, "Attaching to a FlutterEngine: " + flutterEngine2);
        if (isAttachedToFlutterEngine()) {
            if (flutterEngine2 == this.flutterEngine) {
                Log.v(TAG, "Already attached to this engine. Doing nothing.");
                return;
            } else {
                Log.v(TAG, "Currently attached to a different engine. Detaching and then attaching to new engine.");
                detachFromFlutterEngine();
            }
        }
        this.flutterEngine = flutterEngine2;
        FlutterRenderer renderer = flutterEngine2.getRenderer();
        this.isFlutterUiDisplayed = renderer.isDisplayingFlutterUi();
        this.f14141b.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        if (Build.VERSION.SDK_INT >= 24) {
            this.mouseCursorPlugin = new MouseCursorPlugin(this, this.flutterEngine.getMouseCursorChannel());
        }
        this.textInputPlugin = new TextInputPlugin(this, this.flutterEngine.getTextInputChannel(), this.flutterEngine.getPlatformViewsController());
        try {
            TextServicesManager textServicesManager2 = (TextServicesManager) getContext().getSystemService("textservices");
            this.textServicesManager = textServicesManager2;
            this.spellCheckPlugin = new SpellCheckPlugin(textServicesManager2, this.flutterEngine.getSpellCheckChannel());
        } catch (Exception unused) {
            Log.e(TAG, "TextServicesManager not supported by device, spell check disabled.");
        }
        this.localizationPlugin = this.flutterEngine.getLocalizationPlugin();
        this.keyboardManager = new KeyboardManager(this);
        this.androidTouchProcessor = new AndroidTouchProcessor(this.flutterEngine.getRenderer(), false);
        AccessibilityBridge accessibilityBridge2 = new AccessibilityBridge(this, flutterEngine2.getAccessibilityChannel(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.flutterEngine.getPlatformViewsController());
        this.accessibilityBridge = accessibilityBridge2;
        accessibilityBridge2.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
        resetWillNotDraw(this.accessibilityBridge.isAccessibilityEnabled(), this.accessibilityBridge.isTouchExplorationEnabled());
        this.flutterEngine.getPlatformViewsController().attachAccessibilityBridge(this.accessibilityBridge);
        this.flutterEngine.getPlatformViewsController().attachToFlutterRenderer(this.flutterEngine.getRenderer());
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        h();
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("show_password"), false, this.systemSettingsObserver);
        sendViewportMetricsToFlutter();
        flutterEngine2.getPlatformViewsController().attachToView(this);
        for (FlutterEngineAttachmentListener onFlutterEngineAttachedToFlutterView : this.flutterEngineAttachmentListeners) {
            onFlutterEngineAttachedToFlutterView.onFlutterEngineAttachedToFlutterView(flutterEngine2);
        }
        if (this.isFlutterUiDisplayed) {
            this.flutterUiDisplayListener.onFlutterUiDisplayed();
        }
    }

    public void autofill(@NonNull SparseArray<AutofillValue> sparseArray) {
        this.textInputPlugin.autofill(sparseArray);
    }

    public boolean checkInputConnectionProxy(View view) {
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 != null) {
            return flutterEngine2.getPlatformViewsController().checkInputConnectionProxy(view);
        }
        return super.checkInputConnectionProxy(view);
    }

    public void convertToImageView() {
        this.f14141b.pause();
        FlutterImageView flutterImageView2 = this.flutterImageView;
        if (flutterImageView2 == null) {
            FlutterImageView createImageView = createImageView();
            this.flutterImageView = createImageView;
            addView(createImageView);
        } else {
            flutterImageView2.resizeIfNeeded(getWidth(), getHeight());
        }
        this.previousRenderSurface = this.f14141b;
        FlutterImageView flutterImageView3 = this.flutterImageView;
        this.f14141b = flutterImageView3;
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 != null) {
            flutterImageView3.attachToRenderer(flutterEngine2.getRenderer());
        }
    }

    @VisibleForTesting
    @NonNull
    public FlutterImageView createImageView() {
        return new FlutterImageView(getContext(), getWidth(), getHeight(), FlutterImageView.SurfaceKind.background);
    }

    public void detachFromFlutterEngine() {
        Log.v(TAG, "Detaching from a FlutterEngine: " + this.flutterEngine);
        if (!isAttachedToFlutterEngine()) {
            Log.v(TAG, "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        for (FlutterEngineAttachmentListener onFlutterEngineDetachedFromFlutterView : this.flutterEngineAttachmentListeners) {
            onFlutterEngineDetachedFromFlutterView.onFlutterEngineDetachedFromFlutterView();
        }
        getContext().getContentResolver().unregisterContentObserver(this.systemSettingsObserver);
        this.flutterEngine.getPlatformViewsController().detachFromView();
        this.flutterEngine.getPlatformViewsController().detachAccessibilityBridge();
        this.accessibilityBridge.release();
        this.accessibilityBridge = null;
        this.textInputPlugin.getInputMethodManager().restartInput(this);
        this.textInputPlugin.destroy();
        this.keyboardManager.destroy();
        SpellCheckPlugin spellCheckPlugin2 = this.spellCheckPlugin;
        if (spellCheckPlugin2 != null) {
            spellCheckPlugin2.destroy();
        }
        MouseCursorPlugin mouseCursorPlugin2 = this.mouseCursorPlugin;
        if (mouseCursorPlugin2 != null) {
            mouseCursorPlugin2.destroy();
        }
        FlutterRenderer renderer = this.flutterEngine.getRenderer();
        this.isFlutterUiDisplayed = false;
        renderer.removeIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
        renderer.stopRenderingToSurface();
        renderer.setSemanticsEnabled(false);
        RenderSurface renderSurface = this.previousRenderSurface;
        if (renderSurface != null && this.f14141b == this.flutterImageView) {
            this.f14141b = renderSurface;
        }
        this.f14141b.detachFromRenderer();
        FlutterImageView flutterImageView2 = this.flutterImageView;
        if (flutterImageView2 != null) {
            flutterImageView2.closeImageReader();
            removeView(this.flutterImageView);
            this.flutterImageView = null;
        }
        this.previousRenderSurface = null;
        this.flutterEngine = null;
    }

    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        if ((!isAttachedToFlutterEngine() || !this.keyboardManager.handleEvent(keyEvent)) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @android.annotation.SuppressLint({"SoonBlockedPrivateApi"})
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View findViewByAccessibilityIdTraversal(int r8) {
        /*
            r7 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L_0x000b
            android.view.View r8 = r7.findViewByAccessibilityIdRootedAtCurrentView(r8, r7)
            return r8
        L_0x000b:
            r0 = 0
            java.lang.Class<android.view.View> r1 = android.view.View.class
            java.lang.String r2 = "findViewByAccessibilityIdTraversal"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{  }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{  }
            r6 = 0
            r4[r6] = r5     // Catch:{  }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r4)     // Catch:{  }
            r1.setAccessible(r3)
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x002e }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NoSuchMethodException -> 0x002e }
            r2[r6] = r8     // Catch:{ NoSuchMethodException -> 0x002e }
            java.lang.Object r8 = r1.invoke(r7, r2)     // Catch:{ NoSuchMethodException -> 0x002e }
            android.view.View r8 = (android.view.View) r8     // Catch:{ NoSuchMethodException -> 0x002e }
            return r8
        L_0x002e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterView.findViewByAccessibilityIdTraversal(int):android.view.View");
    }

    public boolean fitSystemWindows(@NonNull Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @VisibleForTesting
    public WindowInfoRepositoryCallbackAdapterWrapper g() {
        try {
            return new WindowInfoRepositoryCallbackAdapterWrapper(new WindowInfoTrackerCallbackAdapter(WindowInfoTracker.Companion.getOrCreate(getContext())));
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    @Nullable
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge2 = this.accessibilityBridge;
        if (accessibilityBridge2 == null || !accessibilityBridge2.isAccessibilityEnabled()) {
            return null;
        }
        return this.accessibilityBridge;
    }

    @VisibleForTesting
    @Nullable
    public FlutterEngine getAttachedFlutterEngine() {
        return this.flutterEngine;
    }

    public BinaryMessenger getBinaryMessenger() {
        return this.flutterEngine.getDartExecutor();
    }

    @VisibleForTesting
    public FlutterImageView getCurrentImageSurface() {
        return this.flutterImageView;
    }

    @RequiresApi(24)
    @TargetApi(24)
    @NonNull
    public PointerIcon getSystemPointerIcon(int i11) {
        return PointerIcon.getSystemIcon(getContext(), i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003f, code lost:
        if (r1 != false) goto L_0x0041;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070  */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h() {
        /*
            r6 = this;
            android.content.res.Resources r0 = r6.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.uiMode
            r0 = r0 & 48
            r1 = 32
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L_0x0014
            r0 = r3
            goto L_0x0015
        L_0x0014:
            r0 = r2
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            io.flutter.embedding.engine.systemchannels.SettingsChannel$PlatformBrightness r0 = io.flutter.embedding.engine.systemchannels.SettingsChannel.PlatformBrightness.dark
            goto L_0x001c
        L_0x001a:
            io.flutter.embedding.engine.systemchannels.SettingsChannel$PlatformBrightness r0 = io.flutter.embedding.engine.systemchannels.SettingsChannel.PlatformBrightness.light
        L_0x001c:
            android.view.textservice.TextServicesManager r1 = r6.textServicesManager
            if (r1 == 0) goto L_0x0043
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 31
            if (r4 < r5) goto L_0x0041
            java.util.List r1 = r1.getEnabledSpellCheckerInfos()
            j$.util.stream.Stream r1 = j$.util.Collection.EL.stream(r1)
            pz.g r4 = new pz.g
            r4.<init>()
            boolean r1 = r1.anyMatch(r4)
            android.view.textservice.TextServicesManager r4 = r6.textServicesManager
            boolean r4 = r4.isSpellCheckerEnabled()
            if (r4 == 0) goto L_0x0043
            if (r1 == 0) goto L_0x0043
        L_0x0041:
            r1 = r3
            goto L_0x0044
        L_0x0043:
            r1 = r2
        L_0x0044:
            io.flutter.embedding.engine.FlutterEngine r4 = r6.flutterEngine
            io.flutter.embedding.engine.systemchannels.SettingsChannel r4 = r4.getSettingsChannel()
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r4 = r4.startMessage()
            android.content.res.Resources r5 = r6.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            float r5 = r5.fontScale
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r4 = r4.setTextScaleFactor(r5)
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r1 = r4.setNativeSpellCheckServiceDefined(r1)
            android.content.Context r4 = r6.getContext()
            android.content.ContentResolver r4 = r4.getContentResolver()
            java.lang.String r5 = "show_password"
            int r4 = android.provider.Settings.System.getInt(r4, r5, r3)
            if (r4 != r3) goto L_0x0071
            r2 = r3
        L_0x0071:
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r1 = r1.setBrieflyShowPassword(r2)
            android.content.Context r2 = r6.getContext()
            boolean r2 = android.text.format.DateFormat.is24HourFormat(r2)
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r1 = r1.setUse24HourFormat(r2)
            io.flutter.embedding.engine.systemchannels.SettingsChannel$MessageBuilder r0 = r1.setPlatformBrightness(r0)
            r0.send()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.FlutterView.h():void");
    }

    public boolean hasRenderedFirstFrame() {
        return this.isFlutterUiDisplayed;
    }

    @VisibleForTesting
    public boolean isAttachedToFlutterEngine() {
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 == null || flutterEngine2.getRenderer() != this.f14141b.getAttachedRenderer()) {
            return false;
        }
        return true;
    }

    @RequiresApi(20)
    @SuppressLint({"InlinedApi", "NewApi"})
    @TargetApi(20)
    @NonNull
    public final WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        boolean z11;
        int i11;
        int i12;
        int i13;
        int i14;
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        int i15 = Build.VERSION.SDK_INT;
        if (i15 == 29) {
            Insets a11 = windowInsets.getSystemGestureInsets();
            this.viewportMetrics.systemGestureInsetTop = a11.top;
            this.viewportMetrics.systemGestureInsetRight = a11.right;
            this.viewportMetrics.systemGestureInsetBottom = a11.bottom;
            this.viewportMetrics.systemGestureInsetLeft = a11.left;
        }
        boolean z12 = true;
        int i16 = 0;
        if ((getWindowSystemUiVisibility() & 4) == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((getWindowSystemUiVisibility() & 2) != 0) {
            z12 = false;
        }
        if (i15 >= 30) {
            if (z12) {
                i16 = 0 | WindowInsets.Type.navigationBars();
            }
            if (z11) {
                i16 |= WindowInsets.Type.statusBars();
            }
            Insets a12 = windowInsets.getInsets(i16);
            this.viewportMetrics.viewPaddingTop = a12.top;
            this.viewportMetrics.viewPaddingRight = a12.right;
            this.viewportMetrics.viewPaddingBottom = a12.bottom;
            this.viewportMetrics.viewPaddingLeft = a12.left;
            Insets a13 = windowInsets.getInsets(WindowInsets.Type.ime());
            this.viewportMetrics.viewInsetTop = a13.top;
            this.viewportMetrics.viewInsetRight = a13.right;
            this.viewportMetrics.viewInsetBottom = a13.bottom;
            this.viewportMetrics.viewInsetLeft = a13.left;
            Insets a14 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            this.viewportMetrics.systemGestureInsetTop = a14.top;
            this.viewportMetrics.systemGestureInsetRight = a14.right;
            this.viewportMetrics.systemGestureInsetBottom = a14.bottom;
            this.viewportMetrics.systemGestureInsetLeft = a14.left;
            DisplayCutout a15 = windowInsets.getDisplayCutout();
            if (a15 != null) {
                Insets a16 = a15.getWaterfallInsets();
                FlutterRenderer.ViewportMetrics viewportMetrics2 = this.viewportMetrics;
                viewportMetrics2.viewPaddingTop = Math.max(Math.max(viewportMetrics2.viewPaddingTop, a16.top), a15.getSafeInsetTop());
                FlutterRenderer.ViewportMetrics viewportMetrics3 = this.viewportMetrics;
                viewportMetrics3.viewPaddingRight = Math.max(Math.max(viewportMetrics3.viewPaddingRight, a16.right), a15.getSafeInsetRight());
                FlutterRenderer.ViewportMetrics viewportMetrics4 = this.viewportMetrics;
                viewportMetrics4.viewPaddingBottom = Math.max(Math.max(viewportMetrics4.viewPaddingBottom, a16.bottom), a15.getSafeInsetBottom());
                FlutterRenderer.ViewportMetrics viewportMetrics5 = this.viewportMetrics;
                viewportMetrics5.viewPaddingLeft = Math.max(Math.max(viewportMetrics5.viewPaddingLeft, a16.left), a15.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z12) {
                zeroSides = calculateShouldZeroSides();
            }
            FlutterRenderer.ViewportMetrics viewportMetrics6 = this.viewportMetrics;
            if (z11) {
                i11 = windowInsets.getSystemWindowInsetTop();
            } else {
                i11 = 0;
            }
            viewportMetrics6.viewPaddingTop = i11;
            FlutterRenderer.ViewportMetrics viewportMetrics7 = this.viewportMetrics;
            if (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) {
                i12 = 0;
            } else {
                i12 = windowInsets.getSystemWindowInsetRight();
            }
            viewportMetrics7.viewPaddingRight = i12;
            FlutterRenderer.ViewportMetrics viewportMetrics8 = this.viewportMetrics;
            if (!z12 || guessBottomKeyboardInset(windowInsets) != 0) {
                i13 = 0;
            } else {
                i13 = windowInsets.getSystemWindowInsetBottom();
            }
            viewportMetrics8.viewPaddingBottom = i13;
            FlutterRenderer.ViewportMetrics viewportMetrics9 = this.viewportMetrics;
            if (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) {
                i14 = 0;
            } else {
                i14 = windowInsets.getSystemWindowInsetLeft();
            }
            viewportMetrics9.viewPaddingLeft = i14;
            FlutterRenderer.ViewportMetrics viewportMetrics10 = this.viewportMetrics;
            viewportMetrics10.viewInsetTop = 0;
            viewportMetrics10.viewInsetRight = 0;
            viewportMetrics10.viewInsetBottom = guessBottomKeyboardInset(windowInsets);
            this.viewportMetrics.viewInsetLeft = 0;
        }
        Log.v(TAG, "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.viewportMetrics.viewPaddingTop + ", Left: " + this.viewportMetrics.viewPaddingLeft + ", Right: " + this.viewportMetrics.viewPaddingRight + "\nKeyboard insets: Bottom: " + this.viewportMetrics.viewInsetBottom + ", Left: " + this.viewportMetrics.viewInsetLeft + ", Right: " + this.viewportMetrics.viewInsetRight + "System Gesture Insets - Left: " + this.viewportMetrics.systemGestureInsetLeft + ", Top: " + this.viewportMetrics.systemGestureInsetTop + ", Right: " + this.viewportMetrics.systemGestureInsetRight + ", Bottom: " + this.viewportMetrics.viewInsetBottom);
        sendViewportMetricsToFlutter();
        return onApplyWindowInsets;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.windowInfoRepo = g();
        Activity activity = ViewUtils.getActivity(getContext());
        WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepositoryCallbackAdapterWrapper = this.windowInfoRepo;
        if (windowInfoRepositoryCallbackAdapterWrapper != null && activity != null) {
            windowInfoRepositoryCallbackAdapterWrapper.addWindowLayoutInfoListener(activity, ContextCompat.getMainExecutor(getContext()), this.windowInfoListener);
        }
    }

    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.flutterEngine != null) {
            Log.v(TAG, "Configuration changed. Sending locales and user settings to Flutter.");
            this.localizationPlugin.sendLocalesToFlutter(configuration);
            h();
        }
    }

    @Nullable
    public InputConnection onCreateInputConnection(@NonNull EditorInfo editorInfo) {
        if (!isAttachedToFlutterEngine()) {
            return super.onCreateInputConnection(editorInfo);
        }
        return this.textInputPlugin.createInputConnection(this, this.keyboardManager, editorInfo);
    }

    public void onDetachedFromWindow() {
        WindowInfoRepositoryCallbackAdapterWrapper windowInfoRepositoryCallbackAdapterWrapper = this.windowInfoRepo;
        if (windowInfoRepositoryCallbackAdapterWrapper != null) {
            windowInfoRepositoryCallbackAdapterWrapper.removeWindowLayoutInfoListener(this.windowInfoListener);
        }
        this.windowInfoRepo = null;
        super.onDetachedFromWindow();
    }

    public boolean onGenericMotionEvent(@NonNull MotionEvent motionEvent) {
        boolean z11;
        if (!isAttachedToFlutterEngine() || !this.androidTouchProcessor.onGenericMotionEvent(motionEvent)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public boolean onHoverEvent(@NonNull MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.accessibilityBridge.onAccessibilityHoverEvent(motionEvent);
    }

    public void onProvideAutofillVirtualStructure(@NonNull ViewStructure viewStructure, int i11) {
        super.onProvideAutofillVirtualStructure(viewStructure, i11);
        this.textInputPlugin.onProvideAutofillVirtualStructure(viewStructure, i11);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        Log.v(TAG, "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i13 + " x " + i14 + ", it is now " + i11 + " x " + i12);
        FlutterRenderer.ViewportMetrics viewportMetrics2 = this.viewportMetrics;
        viewportMetrics2.width = i11;
        viewportMetrics2.height = i12;
        sendViewportMetricsToFlutter();
    }

    public boolean onTextInputKeyEvent(@NonNull KeyEvent keyEvent) {
        return this.textInputPlugin.handleKeyEvent(keyEvent);
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!isAttachedToFlutterEngine()) {
            return super.onTouchEvent(motionEvent);
        }
        requestUnbufferedDispatch(motionEvent);
        return this.androidTouchProcessor.onTouchEvent(motionEvent);
    }

    public void redispatch(@NonNull KeyEvent keyEvent) {
        getRootView().dispatchKeyEvent(keyEvent);
    }

    @VisibleForTesting
    public void removeFlutterEngineAttachmentListener(@NonNull FlutterEngineAttachmentListener flutterEngineAttachmentListener) {
        this.flutterEngineAttachmentListeners.remove(flutterEngineAttachmentListener);
    }

    public void removeOnFirstFrameRenderedListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener2) {
        this.flutterUiDisplayListeners.remove(flutterUiDisplayListener2);
    }

    public void revertImageView(@NonNull final Runnable runnable) {
        FlutterImageView flutterImageView2 = this.flutterImageView;
        if (flutterImageView2 == null) {
            Log.v(TAG, "Tried to revert the image view, but no image view is used.");
            return;
        }
        RenderSurface renderSurface = this.previousRenderSurface;
        if (renderSurface == null) {
            Log.v(TAG, "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.f14141b = renderSurface;
        this.previousRenderSurface = null;
        FlutterEngine flutterEngine2 = this.flutterEngine;
        if (flutterEngine2 == null) {
            flutterImageView2.detachFromRenderer();
            runnable.run();
            return;
        }
        final FlutterRenderer renderer = flutterEngine2.getRenderer();
        if (renderer == null) {
            this.flutterImageView.detachFromRenderer();
            runnable.run();
            return;
        }
        this.f14141b.attachToRenderer(renderer);
        renderer.addIsDisplayingFlutterUiListener(new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                renderer.removeIsDisplayingFlutterUiListener(this);
                runnable.run();
                FlutterView flutterView = FlutterView.this;
                if (!(flutterView.f14141b instanceof FlutterImageView) && flutterView.flutterImageView != null) {
                    FlutterView.this.flutterImageView.detachFromRenderer();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
            }
        });
    }

    public void setVisibility(int i11) {
        super.setVisibility(i11);
        RenderSurface renderSurface = this.f14141b;
        if (renderSurface instanceof FlutterSurfaceView) {
            ((FlutterSurfaceView) renderSurface).setVisibility(i11);
        }
    }

    @TargetApi(28)
    public void setWindowInfoListenerDisplayFeatures(WindowLayoutInfo windowLayoutInfo) {
        WindowInsets rootWindowInsets;
        DisplayCutout a11;
        FlutterRenderer.DisplayFeatureType displayFeatureType;
        FlutterRenderer.DisplayFeatureState displayFeatureState;
        List<DisplayFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        ArrayList arrayList = new ArrayList();
        for (DisplayFeature next : displayFeatures) {
            Log.v(TAG, "WindowInfoTracker Display Feature reported with bounds = " + next.getBounds().toString() + " and type = " + next.getClass().getSimpleName());
            if (next instanceof FoldingFeature) {
                FoldingFeature foldingFeature = (FoldingFeature) next;
                if (foldingFeature.getOcclusionType() == FoldingFeature.OcclusionType.FULL) {
                    displayFeatureType = FlutterRenderer.DisplayFeatureType.HINGE;
                } else {
                    displayFeatureType = FlutterRenderer.DisplayFeatureType.FOLD;
                }
                if (foldingFeature.getState() == FoldingFeature.State.FLAT) {
                    displayFeatureState = FlutterRenderer.DisplayFeatureState.POSTURE_FLAT;
                } else if (foldingFeature.getState() == FoldingFeature.State.HALF_OPENED) {
                    displayFeatureState = FlutterRenderer.DisplayFeatureState.POSTURE_HALF_OPENED;
                } else {
                    displayFeatureState = FlutterRenderer.DisplayFeatureState.UNKNOWN;
                }
                arrayList.add(new FlutterRenderer.DisplayFeature(next.getBounds(), displayFeatureType, displayFeatureState));
            } else {
                arrayList.add(new FlutterRenderer.DisplayFeature(next.getBounds(), FlutterRenderer.DisplayFeatureType.UNKNOWN, FlutterRenderer.DisplayFeatureState.UNKNOWN));
            }
        }
        if (!(Build.VERSION.SDK_INT < 28 || (rootWindowInsets = getRootWindowInsets()) == null || (a11 = rootWindowInsets.getDisplayCutout()) == null)) {
            for (Rect rect : a11.getBoundingRects()) {
                Log.v(TAG, "DisplayCutout area reported with bounds = " + rect.toString());
                arrayList.add(new FlutterRenderer.DisplayFeature(rect, FlutterRenderer.DisplayFeatureType.CUTOUT));
            }
        }
        this.viewportMetrics.displayFeatures = arrayList;
        sendViewportMetricsToFlutter();
    }

    @Deprecated
    public FlutterView(@NonNull Context context, @NonNull RenderMode renderMode) {
        super(context, (AttributeSet) null);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z11, boolean z12) {
                FlutterView.this.resetWillNotDraw(z11, z12);
            }
        };
        this.systemSettingsObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
            public boolean deliverSelfNotifications() {
                return true;
            }

            public void onChange(boolean z11) {
                super.onChange(z11);
                if (FlutterView.this.flutterEngine != null) {
                    Log.v(FlutterView.TAG, "System settings changed. Sending user settings to Flutter.");
                    FlutterView.this.h();
                }
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.windowInfoListener = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView2 = new FlutterSurfaceView(context);
            this.flutterSurfaceView = flutterSurfaceView2;
            this.f14141b = flutterSurfaceView2;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView2 = new FlutterTextureView(context);
            this.flutterTextureView = flutterTextureView2;
            this.f14141b = flutterTextureView2;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        init();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public FlutterView(@NonNull Context context, @NonNull TransparencyMode transparencyMode) {
        this(context, (AttributeSet) null, new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent));
    }

    public FlutterView(@NonNull Context context, @NonNull FlutterSurfaceView flutterSurfaceView2) {
        this(context, (AttributeSet) null, flutterSurfaceView2);
    }

    public FlutterView(@NonNull Context context, @NonNull FlutterTextureView flutterTextureView2) {
        this(context, (AttributeSet) null, flutterTextureView2);
    }

    @TargetApi(19)
    public FlutterView(@NonNull Context context, @NonNull FlutterImageView flutterImageView2) {
        this(context, (AttributeSet) null, flutterImageView2);
    }

    public FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, new FlutterSurfaceView(context));
    }

    @Deprecated
    public FlutterView(@NonNull Context context, @NonNull RenderMode renderMode, @NonNull TransparencyMode transparencyMode) {
        super(context, (AttributeSet) null);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z11, boolean z12) {
                FlutterView.this.resetWillNotDraw(z11, z12);
            }
        };
        this.systemSettingsObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
            public boolean deliverSelfNotifications() {
                return true;
            }

            public void onChange(boolean z11) {
                super.onChange(z11);
                if (FlutterView.this.flutterEngine != null) {
                    Log.v(FlutterView.TAG, "System settings changed. Sending user settings to Flutter.");
                    FlutterView.this.h();
                }
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.windowInfoListener = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        boolean z11 = false;
        if (renderMode == RenderMode.surface) {
            FlutterSurfaceView flutterSurfaceView2 = new FlutterSurfaceView(context, transparencyMode == TransparencyMode.transparent ? true : z11);
            this.flutterSurfaceView = flutterSurfaceView2;
            this.f14141b = flutterSurfaceView2;
        } else if (renderMode == RenderMode.texture) {
            FlutterTextureView flutterTextureView2 = new FlutterTextureView(context);
            this.flutterTextureView = flutterTextureView2;
            this.f14141b = flutterTextureView2;
        } else {
            throw new IllegalArgumentException(String.format("RenderMode not supported with this constructor: %s", new Object[]{renderMode}));
        }
        init();
    }

    private FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @NonNull FlutterSurfaceView flutterSurfaceView2) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z11, boolean z12) {
                FlutterView.this.resetWillNotDraw(z11, z12);
            }
        };
        this.systemSettingsObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
            public boolean deliverSelfNotifications() {
                return true;
            }

            public void onChange(boolean z11) {
                super.onChange(z11);
                if (FlutterView.this.flutterEngine != null) {
                    Log.v(FlutterView.TAG, "System settings changed. Sending user settings to Flutter.");
                    FlutterView.this.h();
                }
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.windowInfoListener = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.flutterSurfaceView = flutterSurfaceView2;
        this.f14141b = flutterSurfaceView2;
        init();
    }

    private FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @NonNull FlutterTextureView flutterTextureView2) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z11, boolean z12) {
                FlutterView.this.resetWillNotDraw(z11, z12);
            }
        };
        this.systemSettingsObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
            public boolean deliverSelfNotifications() {
                return true;
            }

            public void onChange(boolean z11) {
                super.onChange(z11);
                if (FlutterView.this.flutterEngine != null) {
                    Log.v(FlutterView.TAG, "System settings changed. Sending user settings to Flutter.");
                    FlutterView.this.h();
                }
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.windowInfoListener = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.flutterTextureView = flutterTextureView2;
        this.f14141b = flutterTextureView2;
        init();
    }

    @TargetApi(19)
    private FlutterView(@NonNull Context context, @Nullable AttributeSet attributeSet, @NonNull FlutterImageView flutterImageView2) {
        super(context, attributeSet);
        this.flutterUiDisplayListeners = new HashSet();
        this.flutterEngineAttachmentListeners = new HashSet();
        this.viewportMetrics = new FlutterRenderer.ViewportMetrics();
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z11, boolean z12) {
                FlutterView.this.resetWillNotDraw(z11, z12);
            }
        };
        this.systemSettingsObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
            public boolean deliverSelfNotifications() {
                return true;
            }

            public void onChange(boolean z11) {
                super.onChange(z11);
                if (FlutterView.this.flutterEngine != null) {
                    Log.v(FlutterView.TAG, "System settings changed. Sending user settings to Flutter.");
                    FlutterView.this.h();
                }
            }
        };
        this.flutterUiDisplayListener = new FlutterUiDisplayListener() {
            public void onFlutterUiDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = true;
                for (FlutterUiDisplayListener onFlutterUiDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiDisplayed.onFlutterUiDisplayed();
                }
            }

            public void onFlutterUiNoLongerDisplayed() {
                boolean unused = FlutterView.this.isFlutterUiDisplayed = false;
                for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : FlutterView.this.flutterUiDisplayListeners) {
                    onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
                }
            }
        };
        this.windowInfoListener = new Consumer<WindowLayoutInfo>() {
            public void accept(WindowLayoutInfo windowLayoutInfo) {
                FlutterView.this.setWindowInfoListenerDisplayFeatures(windowLayoutInfo);
            }
        };
        this.flutterImageView = flutterImageView2;
        this.f14141b = flutterImageView2;
        init();
    }
}
