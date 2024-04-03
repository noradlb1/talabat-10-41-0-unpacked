package io.flutter.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.UiThread;
import g00.b;
import io.flutter.Log;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.android.AndroidTouchProcessor;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.common.ActivityLifecycleListener;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.mouse.MouseCursorPlugin;
import io.flutter.plugin.platform.PlatformPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.util.ViewUtils;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import uz.a;

@Deprecated
public class FlutterView extends SurfaceView implements BinaryMessenger, TextureRegistry, MouseCursorPlugin.MouseCursorViewDelegate, KeyboardManager.ViewDelegate {
    private static final String TAG = "FlutterView";
    private final AndroidTouchProcessor androidTouchProcessor;
    private final DartExecutor dartExecutor;
    private boolean didRenderFirstFrame;
    private final FlutterRenderer flutterRenderer;
    private final LifecycleChannel lifecycleChannel;
    private final LocalizationChannel localizationChannel;
    private AccessibilityBridge mAccessibilityNodeProvider;
    private final List<ActivityLifecycleListener> mActivityLifecycleListeners;
    private final List<FirstFrameListener> mFirstFrameListeners;
    private final InputMethodManager mImm;
    private boolean mIsSoftwareRenderingEnabled;
    private final KeyboardManager mKeyboardManager;
    private final LocalizationPlugin mLocalizationPlugin;
    private final ViewportMetrics mMetrics;
    private final MouseCursorPlugin mMouseCursorPlugin;
    /* access modifiers changed from: private */
    public FlutterNativeView mNativeView;
    private final SurfaceHolder.Callback mSurfaceCallback;
    private final TextInputPlugin mTextInputPlugin;
    private final NavigationChannel navigationChannel;
    private final AtomicLong nextTextureId;
    private final AccessibilityBridge.OnAccessibilityChangeListener onAccessibilityChangeListener;
    private final PlatformChannel platformChannel;
    private final SettingsChannel settingsChannel;
    private final SystemChannel systemChannel;

    public interface FirstFrameListener {
        void onFirstFrame();
    }

    public interface Provider {
        FlutterView getFlutterView();
    }

    public final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry {
        /* access modifiers changed from: private */

        /* renamed from: id  reason: collision with root package name */
        public final long f14453id;
        private SurfaceTexture.OnFrameAvailableListener onFrameListener = new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                if (!SurfaceTextureRegistryEntry.this.released && FlutterView.this.mNativeView != null) {
                    FlutterView.this.mNativeView.getFlutterJNI().markTextureFrameAvailable(SurfaceTextureRegistryEntry.this.f14453id);
                }
            }
        };
        /* access modifiers changed from: private */
        public boolean released;
        private final SurfaceTextureWrapper textureWrapper;

        public SurfaceTextureRegistryEntry(long j11, SurfaceTexture surfaceTexture) {
            this.f14453id = j11;
            this.textureWrapper = new SurfaceTextureWrapper(surfaceTexture);
            surfaceTexture().setOnFrameAvailableListener(this.onFrameListener, new Handler());
        }

        public long id() {
            return this.f14453id;
        }

        public void release() {
            if (!this.released) {
                this.released = true;
                surfaceTexture().setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
                this.textureWrapper.release();
                FlutterView.this.mNativeView.getFlutterJNI().unregisterTexture(this.f14453id);
            }
        }

        public /* synthetic */ void setOnFrameConsumedListener(TextureRegistry.OnFrameConsumedListener onFrameConsumedListener) {
            b.a(this, onFrameConsumedListener);
        }

        public /* synthetic */ void setOnTrimMemoryListener(TextureRegistry.OnTrimMemoryListener onTrimMemoryListener) {
            b.b(this, onTrimMemoryListener);
        }

        public SurfaceTexture surfaceTexture() {
            return this.textureWrapper.surfaceTexture();
        }

        public SurfaceTextureWrapper textureWrapper() {
            return this.textureWrapper;
        }
    }

    public static final class ViewportMetrics {

        /* renamed from: a  reason: collision with root package name */
        public float f14455a = 1.0f;

        /* renamed from: b  reason: collision with root package name */
        public int f14456b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f14457c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f14458d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f14459e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f14460f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f14461g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f14462h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f14463i = 0;

        /* renamed from: j  reason: collision with root package name */
        public int f14464j = 0;

        /* renamed from: k  reason: collision with root package name */
        public int f14465k = 0;

        /* renamed from: l  reason: collision with root package name */
        public int f14466l = 0;

        /* renamed from: m  reason: collision with root package name */
        public int f14467m = 0;

        /* renamed from: n  reason: collision with root package name */
        public int f14468n = 0;

        /* renamed from: o  reason: collision with root package name */
        public int f14469o = 0;

        /* renamed from: p  reason: collision with root package name */
        public int f14470p = -1;
    }

    public enum ZeroSides {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    public FlutterView(Context context) {
        this(context, (AttributeSet) null);
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

    @RequiresApi(20)
    @TargetApi(20)
    private int guessBottomKeyboardInset(WindowInsets windowInsets) {
        if (((double) windowInsets.getSystemWindowInsetBottom()) < ((double) getRootView().getHeight()) * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    private boolean isAttached() {
        FlutterNativeView flutterNativeView = this.mNativeView;
        return flutterNativeView != null && flutterNativeView.isAttached();
    }

    private void postRun() {
    }

    private void preRun() {
        d();
    }

    private void releaseAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.mAccessibilityNodeProvider;
        if (accessibilityBridge != null) {
            accessibilityBridge.release();
            this.mAccessibilityNodeProvider = null;
        }
    }

    /* access modifiers changed from: private */
    public void resetWillNotDraw(boolean z11, boolean z12) {
        boolean z13 = false;
        if (!this.mIsSoftwareRenderingEnabled) {
            if (!z11 && !z12) {
                z13 = true;
            }
            setWillNotDraw(z13);
            return;
        }
        setWillNotDraw(false);
    }

    private void sendUserPlatformSettingsToDart() {
        boolean z11;
        SettingsChannel.PlatformBrightness platformBrightness;
        if ((getResources().getConfiguration().uiMode & 48) == 32) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            platformBrightness = SettingsChannel.PlatformBrightness.dark;
        } else {
            platformBrightness = SettingsChannel.PlatformBrightness.light;
        }
        this.settingsChannel.startMessage().setTextScaleFactor(getResources().getConfiguration().fontScale).setUse24HourFormat(DateFormat.is24HourFormat(getContext())).setPlatformBrightness(platformBrightness).send();
    }

    private void updateViewportMetrics() {
        if (isAttached()) {
            FlutterJNI flutterJNI = this.mNativeView.getFlutterJNI();
            ViewportMetrics viewportMetrics = this.mMetrics;
            flutterJNI.setViewportMetrics(viewportMetrics.f14455a, viewportMetrics.f14456b, viewportMetrics.f14457c, viewportMetrics.f14458d, viewportMetrics.f14459e, viewportMetrics.f14460f, viewportMetrics.f14461g, viewportMetrics.f14462h, viewportMetrics.f14463i, viewportMetrics.f14464j, viewportMetrics.f14465k, viewportMetrics.f14466l, viewportMetrics.f14467m, viewportMetrics.f14468n, viewportMetrics.f14469o, viewportMetrics.f14470p, new int[0], new int[0], new int[0]);
        }
    }

    public void addActivityLifecycleListener(ActivityLifecycleListener activityLifecycleListener) {
        this.mActivityLifecycleListeners.add(activityLifecycleListener);
    }

    public void addFirstFrameListener(FirstFrameListener firstFrameListener) {
        this.mFirstFrameListeners.add(firstFrameListener);
    }

    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.mTextInputPlugin.autofill(sparseArray);
    }

    public void c() {
        if (!isAttached()) {
            throw new AssertionError("Platform view is not attached");
        }
    }

    public boolean checkInputConnectionProxy(View view) {
        return this.mNativeView.getPluginRegistry().getPlatformViewsController().checkInputConnectionProxy(view);
    }

    @NonNull
    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        return registerSurfaceTexture(new SurfaceTexture(0));
    }

    public void d() {
        AccessibilityBridge accessibilityBridge = this.mAccessibilityNodeProvider;
        if (accessibilityBridge != null) {
            accessibilityBridge.reset();
        }
    }

    public void destroy() {
        if (isAttached()) {
            getHolder().removeCallback(this.mSurfaceCallback);
            releaseAccessibilityNodeProvider();
            this.mNativeView.destroy();
            this.mNativeView = null;
        }
    }

    public FlutterNativeView detach() {
        if (!isAttached()) {
            return null;
        }
        getHolder().removeCallback(this.mSurfaceCallback);
        this.mNativeView.detachFromFlutterView();
        FlutterNativeView flutterNativeView = this.mNativeView;
        this.mNativeView = null;
        return flutterNativeView;
    }

    public void disableBufferingIncomingMessages() {
    }

    public void disableTransparentBackground() {
        setZOrderOnTop(false);
        getHolder().setFormat(-1);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Log.e(TAG, "dispatchKeyEvent: " + keyEvent.toString());
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        if ((!isAttached() || !this.mKeyboardManager.handleEvent(keyEvent)) && !super.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public void enableBufferingIncomingMessages() {
    }

    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        AccessibilityBridge accessibilityBridge = this.mAccessibilityNodeProvider;
        if (accessibilityBridge == null || !accessibilityBridge.isAccessibilityEnabled()) {
            return null;
        }
        return this.mAccessibilityNodeProvider;
    }

    public BinaryMessenger getBinaryMessenger() {
        return this;
    }

    public Bitmap getBitmap() {
        c();
        return this.mNativeView.getFlutterJNI().getBitmap();
    }

    @NonNull
    public DartExecutor getDartExecutor() {
        return this.dartExecutor;
    }

    public float getDevicePixelRatio() {
        return this.mMetrics.f14455a;
    }

    public FlutterNativeView getFlutterNativeView() {
        return this.mNativeView;
    }

    public String getLookupKeyForAsset(String str) {
        return FlutterMain.getLookupKeyForAsset(str);
    }

    public FlutterPluginRegistry getPluginRegistry() {
        return this.mNativeView.getPluginRegistry();
    }

    @RequiresApi(24)
    @TargetApi(24)
    @NonNull
    public PointerIcon getSystemPointerIcon(int i11) {
        return PointerIcon.getSystemIcon(getContext(), i11);
    }

    public boolean hasRenderedFirstFrame() {
        return this.didRenderFirstFrame;
    }

    public /* synthetic */ BinaryMessenger.TaskQueue makeBackgroundTaskQueue() {
        return a.c(this);
    }

    @UiThread
    public BinaryMessenger.TaskQueue makeBackgroundTaskQueue(BinaryMessenger.TaskQueueOptions taskQueueOptions) {
        return null;
    }

    @RequiresApi(20)
    @SuppressLint({"InlinedApi", "NewApi"})
    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        boolean z11;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = Build.VERSION.SDK_INT;
        if (i15 == 29) {
            Insets a11 = windowInsets.getSystemGestureInsets();
            this.mMetrics.f14466l = a11.top;
            this.mMetrics.f14467m = a11.right;
            this.mMetrics.f14468n = a11.bottom;
            this.mMetrics.f14469o = a11.left;
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
            this.mMetrics.f14458d = a12.top;
            this.mMetrics.f14459e = a12.right;
            this.mMetrics.f14460f = a12.bottom;
            this.mMetrics.f14461g = a12.left;
            Insets a13 = windowInsets.getInsets(WindowInsets.Type.ime());
            this.mMetrics.f14462h = a13.top;
            this.mMetrics.f14463i = a13.right;
            this.mMetrics.f14464j = a13.bottom;
            this.mMetrics.f14465k = a13.left;
            Insets a14 = windowInsets.getInsets(WindowInsets.Type.systemGestures());
            this.mMetrics.f14466l = a14.top;
            this.mMetrics.f14467m = a14.right;
            this.mMetrics.f14468n = a14.bottom;
            this.mMetrics.f14469o = a14.left;
            DisplayCutout a15 = windowInsets.getDisplayCutout();
            if (a15 != null) {
                Insets a16 = a15.getWaterfallInsets();
                ViewportMetrics viewportMetrics = this.mMetrics;
                viewportMetrics.f14458d = Math.max(Math.max(viewportMetrics.f14458d, a16.top), a15.getSafeInsetTop());
                ViewportMetrics viewportMetrics2 = this.mMetrics;
                viewportMetrics2.f14459e = Math.max(Math.max(viewportMetrics2.f14459e, a16.right), a15.getSafeInsetRight());
                ViewportMetrics viewportMetrics3 = this.mMetrics;
                viewportMetrics3.f14460f = Math.max(Math.max(viewportMetrics3.f14460f, a16.bottom), a15.getSafeInsetBottom());
                ViewportMetrics viewportMetrics4 = this.mMetrics;
                viewportMetrics4.f14461g = Math.max(Math.max(viewportMetrics4.f14461g, a16.left), a15.getSafeInsetLeft());
            }
        } else {
            ZeroSides zeroSides = ZeroSides.NONE;
            if (!z12) {
                zeroSides = calculateShouldZeroSides();
            }
            ViewportMetrics viewportMetrics5 = this.mMetrics;
            if (z11) {
                i11 = windowInsets.getSystemWindowInsetTop();
            } else {
                i11 = 0;
            }
            viewportMetrics5.f14458d = i11;
            ViewportMetrics viewportMetrics6 = this.mMetrics;
            if (zeroSides == ZeroSides.RIGHT || zeroSides == ZeroSides.BOTH) {
                i12 = 0;
            } else {
                i12 = windowInsets.getSystemWindowInsetRight();
            }
            viewportMetrics6.f14459e = i12;
            ViewportMetrics viewportMetrics7 = this.mMetrics;
            if (!z12 || guessBottomKeyboardInset(windowInsets) != 0) {
                i13 = 0;
            } else {
                i13 = windowInsets.getSystemWindowInsetBottom();
            }
            viewportMetrics7.f14460f = i13;
            ViewportMetrics viewportMetrics8 = this.mMetrics;
            if (zeroSides == ZeroSides.LEFT || zeroSides == ZeroSides.BOTH) {
                i14 = 0;
            } else {
                i14 = windowInsets.getSystemWindowInsetLeft();
            }
            viewportMetrics8.f14461g = i14;
            ViewportMetrics viewportMetrics9 = this.mMetrics;
            viewportMetrics9.f14462h = 0;
            viewportMetrics9.f14463i = 0;
            viewportMetrics9.f14464j = guessBottomKeyboardInset(windowInsets);
            this.mMetrics.f14465k = 0;
        }
        updateViewportMetrics();
        return super.onApplyWindowInsets(windowInsets);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AccessibilityBridge accessibilityBridge = new AccessibilityBridge(this, new AccessibilityChannel(this.dartExecutor, getFlutterNativeView().getFlutterJNI()), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), getPluginRegistry().getPlatformViewsController());
        this.mAccessibilityNodeProvider = accessibilityBridge;
        accessibilityBridge.setOnAccessibilityChangeListener(this.onAccessibilityChangeListener);
        resetWillNotDraw(this.mAccessibilityNodeProvider.isAccessibilityEnabled(), this.mAccessibilityNodeProvider.isTouchExplorationEnabled());
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mLocalizationPlugin.sendLocalesToFlutter(configuration);
        sendUserPlatformSettingsToDart();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.mTextInputPlugin.createInputConnection(this, this.mKeyboardManager, editorInfo);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        releaseAccessibilityNodeProvider();
    }

    public void onFirstFrame() {
        this.didRenderFirstFrame = true;
        for (FirstFrameListener onFirstFrame : new ArrayList(this.mFirstFrameListeners)) {
            onFirstFrame.onFirstFrame();
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        boolean z11;
        if (!isAttached() || !this.androidTouchProcessor.onGenericMotionEvent(motionEvent)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (!isAttached()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.mAccessibilityNodeProvider.onAccessibilityHoverEvent(motionEvent);
    }

    public void onMemoryPressure() {
        this.mNativeView.getFlutterJNI().notifyLowMemoryWarning();
        this.systemChannel.sendMemoryPressureWarning();
    }

    public void onPause() {
        this.lifecycleChannel.appIsInactive();
    }

    public void onPostResume() {
        for (ActivityLifecycleListener onPostResume : this.mActivityLifecycleListeners) {
            onPostResume.onPostResume();
        }
        this.lifecycleChannel.appIsResumed();
    }

    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i11) {
        super.onProvideAutofillVirtualStructure(viewStructure, i11);
        this.mTextInputPlugin.onProvideAutofillVirtualStructure(viewStructure, i11);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        ViewportMetrics viewportMetrics = this.mMetrics;
        viewportMetrics.f14456b = i11;
        viewportMetrics.f14457c = i12;
        updateViewportMetrics();
        super.onSizeChanged(i11, i12, i13, i14);
    }

    public void onStart() {
        this.lifecycleChannel.appIsInactive();
    }

    public void onStop() {
        this.lifecycleChannel.appIsPaused();
    }

    public boolean onTextInputKeyEvent(@NonNull KeyEvent keyEvent) {
        return this.mTextInputPlugin.handleKeyEvent(keyEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isAttached()) {
            return super.onTouchEvent(motionEvent);
        }
        requestUnbufferedDispatch(motionEvent);
        return this.androidTouchProcessor.onTouchEvent(motionEvent);
    }

    public /* synthetic */ void onTrimMemory(int i11) {
        g00.a.a(this, i11);
    }

    public void popRoute() {
        this.navigationChannel.popRoute();
    }

    public void pushRoute(String str) {
        this.navigationChannel.pushRoute(str);
    }

    public void redispatch(@NonNull KeyEvent keyEvent) {
        getRootView().dispatchKeyEvent(keyEvent);
    }

    @NonNull
    public TextureRegistry.SurfaceTextureEntry registerSurfaceTexture(@NonNull SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry surfaceTextureRegistryEntry = new SurfaceTextureRegistryEntry(this.nextTextureId.getAndIncrement(), surfaceTexture);
        this.mNativeView.getFlutterJNI().registerTexture(surfaceTextureRegistryEntry.id(), surfaceTextureRegistryEntry.textureWrapper());
        return surfaceTextureRegistryEntry;
    }

    public void removeFirstFrameListener(FirstFrameListener firstFrameListener) {
        this.mFirstFrameListeners.remove(firstFrameListener);
    }

    public void runFromBundle(FlutterRunArguments flutterRunArguments) {
        c();
        preRun();
        this.mNativeView.runFromBundle(flutterRunArguments);
        postRun();
    }

    @UiThread
    public void send(String str, ByteBuffer byteBuffer) {
        send(str, byteBuffer, (BinaryMessenger.BinaryReply) null);
    }

    public void setInitialRoute(String str) {
        this.navigationChannel.setInitialRoute(str);
    }

    @UiThread
    public void setMessageHandler(@NonNull String str, @NonNull BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        this.mNativeView.setMessageHandler(str, binaryMessageHandler);
    }

    public FlutterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (FlutterNativeView) null);
    }

    public String getLookupKeyForAsset(String str, String str2) {
        return FlutterMain.getLookupKeyForAsset(str, str2);
    }

    @UiThread
    public void send(String str, ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
        if (!isAttached()) {
            Log.d(TAG, "FlutterView.send called on a detached view, channel=" + str);
            return;
        }
        this.mNativeView.send(str, byteBuffer, binaryReply);
    }

    @UiThread
    public void setMessageHandler(@NonNull String str, @NonNull BinaryMessenger.BinaryMessageHandler binaryMessageHandler, @NonNull BinaryMessenger.TaskQueue taskQueue) {
        this.mNativeView.setMessageHandler(str, binaryMessageHandler, taskQueue);
    }

    public FlutterView(Context context, AttributeSet attributeSet, FlutterNativeView flutterNativeView) {
        super(context, attributeSet);
        this.nextTextureId = new AtomicLong(0);
        this.mIsSoftwareRenderingEnabled = false;
        this.didRenderFirstFrame = false;
        this.onAccessibilityChangeListener = new AccessibilityBridge.OnAccessibilityChangeListener() {
            public void onAccessibilityChanged(boolean z11, boolean z12) {
                FlutterView.this.resetWillNotDraw(z11, z12);
            }
        };
        Activity activity = ViewUtils.getActivity(getContext());
        if (activity != null) {
            if (flutterNativeView == null) {
                this.mNativeView = new FlutterNativeView(activity.getApplicationContext());
            } else {
                this.mNativeView = flutterNativeView;
            }
            DartExecutor dartExecutor2 = this.mNativeView.getDartExecutor();
            this.dartExecutor = dartExecutor2;
            FlutterRenderer flutterRenderer2 = new FlutterRenderer(this.mNativeView.getFlutterJNI());
            this.flutterRenderer = flutterRenderer2;
            this.mIsSoftwareRenderingEnabled = this.mNativeView.getFlutterJNI().getIsSoftwareRenderingEnabled();
            ViewportMetrics viewportMetrics = new ViewportMetrics();
            this.mMetrics = viewportMetrics;
            viewportMetrics.f14455a = context.getResources().getDisplayMetrics().density;
            viewportMetrics.f14470p = ViewConfiguration.get(context).getScaledTouchSlop();
            setFocusable(true);
            setFocusableInTouchMode(true);
            this.mNativeView.attachViewAndActivity(this, activity);
            AnonymousClass2 r22 = new SurfaceHolder.Callback() {
                public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
                    FlutterView.this.c();
                    FlutterView.this.mNativeView.getFlutterJNI().onSurfaceChanged(i12, i13);
                }

                public void surfaceCreated(SurfaceHolder surfaceHolder) {
                    FlutterView.this.c();
                    FlutterView.this.mNativeView.getFlutterJNI().onSurfaceCreated(surfaceHolder.getSurface());
                }

                public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                    FlutterView.this.c();
                    FlutterView.this.mNativeView.getFlutterJNI().onSurfaceDestroyed();
                }
            };
            this.mSurfaceCallback = r22;
            getHolder().addCallback(r22);
            this.mActivityLifecycleListeners = new ArrayList();
            this.mFirstFrameListeners = new ArrayList();
            this.navigationChannel = new NavigationChannel(dartExecutor2);
            this.lifecycleChannel = new LifecycleChannel(dartExecutor2);
            LocalizationChannel localizationChannel2 = new LocalizationChannel(dartExecutor2);
            this.localizationChannel = localizationChannel2;
            PlatformChannel platformChannel2 = new PlatformChannel(dartExecutor2);
            this.platformChannel = platformChannel2;
            this.systemChannel = new SystemChannel(dartExecutor2);
            this.settingsChannel = new SettingsChannel(dartExecutor2);
            final PlatformPlugin platformPlugin = new PlatformPlugin(activity, platformChannel2);
            addActivityLifecycleListener(new ActivityLifecycleListener() {
                public void onPostResume() {
                    platformPlugin.updateSystemUiOverlays();
                }
            });
            this.mImm = (InputMethodManager) getContext().getSystemService("input_method");
            PlatformViewsController platformViewsController = this.mNativeView.getPluginRegistry().getPlatformViewsController();
            TextInputPlugin textInputPlugin = new TextInputPlugin(this, new TextInputChannel(dartExecutor2), platformViewsController);
            this.mTextInputPlugin = textInputPlugin;
            this.mKeyboardManager = new KeyboardManager(this);
            if (Build.VERSION.SDK_INT >= 24) {
                this.mMouseCursorPlugin = new MouseCursorPlugin(this, new MouseCursorChannel(dartExecutor2));
            } else {
                this.mMouseCursorPlugin = null;
            }
            LocalizationPlugin localizationPlugin = new LocalizationPlugin(context, localizationChannel2);
            this.mLocalizationPlugin = localizationPlugin;
            this.androidTouchProcessor = new AndroidTouchProcessor(flutterRenderer2, false);
            platformViewsController.attachToFlutterRenderer(flutterRenderer2);
            this.mNativeView.getPluginRegistry().getPlatformViewsController().attachTextInputPlugin(textInputPlugin);
            this.mNativeView.getFlutterJNI().setLocalizationPlugin(localizationPlugin);
            localizationPlugin.sendLocalesToFlutter(getResources().getConfiguration());
            sendUserPlatformSettingsToDart();
            return;
        }
        throw new IllegalArgumentException("Bad context");
    }
}
