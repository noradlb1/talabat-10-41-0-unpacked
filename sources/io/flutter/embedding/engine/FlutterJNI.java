package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.PlatformMessageHandler;
import io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.localization.LocalizationPlugin;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.util.Preconditions;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.FlutterCallbackInformation;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import qz.a;

@Keep
public class FlutterJNI {
    private static final String TAG = "FlutterJNI";
    @Nullable
    private static AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = null;
    private static boolean initCalled = false;
    private static boolean loadLibraryCalled = false;
    @Nullable
    private static String observatoryUri = null;
    private static boolean prefetchDefaultFontManagerCalled = false;
    private static float refreshRateFPS = 60.0f;
    @Nullable
    private AccessibilityDelegate accessibilityDelegate;
    @Nullable
    private DeferredComponentManager deferredComponentManager;
    @NonNull
    private final Set<FlutterEngine.EngineLifecycleListener> engineLifecycleListeners = new CopyOnWriteArraySet();
    @NonNull
    private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners = new CopyOnWriteArraySet();
    @Nullable
    private LocalizationPlugin localizationPlugin;
    @NonNull
    private final Looper mainLooper = Looper.getMainLooper();
    @Nullable
    private Long nativeShellHolderId;
    @Nullable
    private PlatformMessageHandler platformMessageHandler;
    @Nullable
    private PlatformViewsController platformViewsController;
    private ReentrantReadWriteLock shellHolderLock = new ReentrantReadWriteLock();

    public interface AccessibilityDelegate {
        void updateCustomAccessibilityActions(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr);

        void updateSemantics(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr, @NonNull ByteBuffer[] byteBufferArr);
    }

    public interface AsyncWaitForVsyncDelegate {
        void asyncWaitForVsync(long j11);
    }

    public static class Factory {
        public FlutterJNI provideFlutterJNI() {
            return new FlutterJNI();
        }
    }

    private static void asyncWaitForVsync(long j11) {
        AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2 = asyncWaitForVsyncDelegate;
        if (asyncWaitForVsyncDelegate2 != null) {
            asyncWaitForVsyncDelegate2.asyncWaitForVsync(j11);
            return;
        }
        throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
    }

    @VisibleForTesting
    @Nullable
    public static Bitmap decodeImage(@NonNull ByteBuffer byteBuffer, long j11) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return ImageDecoder.decodeBitmap(ImageDecoder.createSource(byteBuffer), new a(j11));
            } catch (IOException e11) {
                Log.e(TAG, "Failed to decode image", e11);
            }
        }
        return null;
    }

    private void ensureAttachedToNative() {
        if (this.nativeShellHolderId == null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    private void ensureNotAttachedToNative() {
        if (this.nativeShellHolderId != null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() != this.mainLooper) {
            throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
        }
    }

    @Nullable
    public static String getObservatoryUri() {
        return observatoryUri;
    }

    private void handlePlatformMessageResponse(int i11, ByteBuffer byteBuffer) {
        PlatformMessageHandler platformMessageHandler2 = this.platformMessageHandler;
        if (platformMessageHandler2 != null) {
            platformMessageHandler2.handlePlatformMessageResponse(i11, byteBuffer);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$decodeImage$0(long j11, ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
        imageDecoder.setAllocator(1);
        Size a11 = imageInfo.getSize();
        nativeImageHeaderCallback(j11, a11.getWidth(), a11.getHeight());
    }

    private native long nativeAttach(@NonNull FlutterJNI flutterJNI);

    private native void nativeCleanupMessageData(long j11);

    private native void nativeDeferredComponentInstallFailure(int i11, @NonNull String str, boolean z11);

    private native void nativeDestroy(long j11);

    private native void nativeDispatchEmptyPlatformMessage(long j11, @NonNull String str, int i11);

    private native void nativeDispatchPlatformMessage(long j11, @NonNull String str, @Nullable ByteBuffer byteBuffer, int i11, int i12);

    private native void nativeDispatchPointerDataPacket(long j11, @NonNull ByteBuffer byteBuffer, int i11);

    private native void nativeDispatchSemanticsAction(long j11, int i11, int i12, @Nullable ByteBuffer byteBuffer, int i13);

    private native boolean nativeFlutterTextUtilsIsEmoji(int i11);

    private native boolean nativeFlutterTextUtilsIsEmojiModifier(int i11);

    private native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int i11);

    private native boolean nativeFlutterTextUtilsIsRegionalIndicator(int i11);

    private native boolean nativeFlutterTextUtilsIsVariationSelector(int i11);

    private native Bitmap nativeGetBitmap(long j11);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    public static native void nativeImageHeaderCallback(long j11, int i11, int i12);

    private static native void nativeInit(@NonNull Context context, @NonNull String[] strArr, @Nullable String str, @NonNull String str2, @NonNull String str3, long j11);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j11, int i11);

    private native void nativeInvokePlatformMessageResponseCallback(long j11, int i11, @Nullable ByteBuffer byteBuffer, int i12);

    private native void nativeLoadDartDeferredLibrary(long j11, int i11, @NonNull String[] strArr);

    @NonNull
    @Deprecated
    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j11);

    private native void nativeMarkTextureFrameAvailable(long j11, long j12);

    private native void nativeNotifyLowMemoryWarning(long j11);

    private native void nativeOnVsync(long j11, long j12, long j13);

    private static native void nativePrefetchDefaultFontManager();

    private native void nativeRegisterTexture(long j11, long j12, @NonNull WeakReference<SurfaceTextureWrapper> weakReference);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j11, @NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull AssetManager assetManager, @Nullable List<String> list);

    private native void nativeSetAccessibilityFeatures(long j11, int i11);

    private native void nativeSetSemanticsEnabled(long j11, boolean z11);

    private native void nativeSetViewportMetrics(long j11, float f11, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, int i24, int i25, int i26, int[] iArr, int[] iArr2, int[] iArr3);

    private native FlutterJNI nativeSpawn(long j11, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<String> list);

    private native void nativeSurfaceChanged(long j11, int i11, int i12);

    private native void nativeSurfaceCreated(long j11, @NonNull Surface surface);

    private native void nativeSurfaceDestroyed(long j11);

    private native void nativeSurfaceWindowChanged(long j11, @NonNull Surface surface);

    private native void nativeUnregisterTexture(long j11, long j12);

    private native void nativeUpdateJavaAssetManager(long j11, @NonNull AssetManager assetManager, @NonNull String str);

    private native void nativeUpdateRefreshRate(float f11);

    private void onPreEngineRestart() {
        for (FlutterEngine.EngineLifecycleListener onPreEngineRestart : this.engineLifecycleListeners) {
            onPreEngineRestart.onPreEngineRestart();
        }
    }

    @UiThread
    private void updateCustomAccessibilityActions(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
        ensureRunningOnMainThread();
        AccessibilityDelegate accessibilityDelegate2 = this.accessibilityDelegate;
        if (accessibilityDelegate2 != null) {
            accessibilityDelegate2.updateCustomAccessibilityActions(byteBuffer, strArr);
        }
    }

    @UiThread
    private void updateSemantics(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr, @NonNull ByteBuffer[] byteBufferArr) {
        ensureRunningOnMainThread();
        AccessibilityDelegate accessibilityDelegate2 = this.accessibilityDelegate;
        if (accessibilityDelegate2 != null) {
            accessibilityDelegate2.updateSemantics(byteBuffer, strArr, byteBufferArr);
        }
    }

    @UiThread
    public void addEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(engineLifecycleListener);
    }

    @UiThread
    public void addIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(flutterUiDisplayListener);
    }

    @UiThread
    public void attachToNative() {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            this.nativeShellHolderId = Long.valueOf(performNativeAttach(this));
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void cleanupMessageData(long j11) {
        nativeCleanupMessageData(j11);
    }

    @VisibleForTesting
    public String[] computePlatformResolvedLocale(@NonNull String[] strArr) {
        if (this.localizationPlugin == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < strArr.length; i11 += 3) {
            String str = strArr[i11 + 0];
            String str2 = strArr[i11 + 1];
            String str3 = strArr[i11 + 2];
            Locale.Builder builder = new Locale.Builder();
            if (!str.isEmpty()) {
                builder.setLanguage(str);
            }
            if (!str2.isEmpty()) {
                builder.setRegion(str2);
            }
            if (!str3.isEmpty()) {
                builder.setScript(str3);
            }
            arrayList.add(builder.build());
        }
        Locale resolveNativeLocale = this.localizationPlugin.resolveNativeLocale(arrayList);
        if (resolveNativeLocale == null) {
            return new String[0];
        }
        return new String[]{resolveNativeLocale.getLanguage(), resolveNativeLocale.getCountry(), resolveNativeLocale.getScript()};
    }

    @UiThread
    public FlutterOverlaySurface createOverlaySurface() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            return platformViewsController2.createOverlaySurface();
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    @UiThread
    public void deferredComponentInstallFailure(int i11, @NonNull String str, boolean z11) {
        ensureRunningOnMainThread();
        nativeDeferredComponentInstallFailure(i11, str, z11);
    }

    @UiThread
    public void destroyOverlaySurfaces() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.destroyOverlaySurfaces();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
    }

    @UiThread
    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            nativeDestroy(this.nativeShellHolderId.longValue());
            this.nativeShellHolderId = null;
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    @UiThread
    public void dispatchEmptyPlatformMessage(@NonNull String str, int i11) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchEmptyPlatformMessage(this.nativeShellHolderId.longValue(), str, i11);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i11);
    }

    @UiThread
    public void dispatchPlatformMessage(@NonNull String str, @Nullable ByteBuffer byteBuffer, int i11, int i12) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchPlatformMessage(this.nativeShellHolderId.longValue(), str, byteBuffer, i11, i12);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i12);
    }

    @UiThread
    public void dispatchPointerDataPacket(@NonNull ByteBuffer byteBuffer, int i11) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), byteBuffer, i11);
    }

    public void dispatchSemanticsAction(int i11, @NonNull AccessibilityBridge.Action action) {
        dispatchSemanticsAction(i11, action, (Object) null);
    }

    @UiThread
    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativeShellHolderId.longValue());
    }

    @UiThread
    public boolean getIsSoftwareRenderingEnabled() {
        return nativeGetIsSoftwareRenderingEnabled();
    }

    @VisibleForTesting
    public void handlePlatformMessage(@NonNull String str, ByteBuffer byteBuffer, int i11, long j11) {
        PlatformMessageHandler platformMessageHandler2 = this.platformMessageHandler;
        if (platformMessageHandler2 != null) {
            platformMessageHandler2.handleMessageFromDart(str, byteBuffer, i11, j11);
        } else {
            nativeCleanupMessageData(j11);
        }
    }

    public void init(@NonNull Context context, @NonNull String[] strArr, @Nullable String str, @NonNull String str2, @NonNull String str3, long j11) {
        if (initCalled) {
            Log.w(TAG, "FlutterJNI.init called more than once");
        }
        nativeInit(context, strArr, str, str2, str3, j11);
        initCalled = true;
    }

    public void invokePlatformMessageEmptyResponseCallback(int i11) {
        this.shellHolderLock.readLock().lock();
        try {
            if (isAttached()) {
                nativeInvokePlatformMessageEmptyResponseCallback(this.nativeShellHolderId.longValue(), i11);
            } else {
                Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i11);
            }
        } finally {
            this.shellHolderLock.readLock().unlock();
        }
    }

    public void invokePlatformMessageResponseCallback(int i11, @NonNull ByteBuffer byteBuffer, int i12) {
        if (byteBuffer.isDirect()) {
            this.shellHolderLock.readLock().lock();
            try {
                if (isAttached()) {
                    nativeInvokePlatformMessageResponseCallback(this.nativeShellHolderId.longValue(), i11, byteBuffer, i12);
                } else {
                    Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i11);
                }
            } finally {
                this.shellHolderLock.readLock().unlock();
            }
        } else {
            throw new IllegalArgumentException("Expected a direct ByteBuffer.");
        }
    }

    public boolean isAttached() {
        return this.nativeShellHolderId != null;
    }

    public boolean isCodePointEmoji(int i11) {
        return nativeFlutterTextUtilsIsEmoji(i11);
    }

    public boolean isCodePointEmojiModifier(int i11) {
        return nativeFlutterTextUtilsIsEmojiModifier(i11);
    }

    public boolean isCodePointEmojiModifierBase(int i11) {
        return nativeFlutterTextUtilsIsEmojiModifierBase(i11);
    }

    public boolean isCodePointRegionalIndicator(int i11) {
        return nativeFlutterTextUtilsIsRegionalIndicator(i11);
    }

    public boolean isCodePointVariantSelector(int i11) {
        return nativeFlutterTextUtilsIsVariationSelector(i11);
    }

    @UiThread
    public void loadDartDeferredLibrary(int i11, @NonNull String[] strArr) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeLoadDartDeferredLibrary(this.nativeShellHolderId.longValue(), i11, strArr);
    }

    public void loadLibrary() {
        if (loadLibraryCalled) {
            Log.w(TAG, "FlutterJNI.loadLibrary called more than once");
        }
        System.loadLibrary("flutter");
        loadLibraryCalled = true;
    }

    @UiThread
    public void markTextureFrameAvailable(long j11) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeMarkTextureFrameAvailable(this.nativeShellHolderId.longValue(), j11);
    }

    @UiThread
    public void notifyLowMemoryWarning() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    }

    @UiThread
    public void onBeginFrame() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onBeginFrame();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
    }

    @UiThread
    public void onDisplayOverlaySurface(int i11, int i12, int i13, int i14, int i15) {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onDisplayOverlaySurface(i11, i12, i13, i14, i15);
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    @UiThread
    public void onDisplayPlatformView(int i11, int i12, int i13, int i14, int i15, int i16, int i17, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onDisplayPlatformView(i11, i12, i13, i14, i15, i16, i17, flutterMutatorsStack);
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
    }

    @UiThread
    public void onEndFrame() {
        ensureRunningOnMainThread();
        PlatformViewsController platformViewsController2 = this.platformViewsController;
        if (platformViewsController2 != null) {
            platformViewsController2.onEndFrame();
            return;
        }
        throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
    }

    @UiThread
    @VisibleForTesting
    public void onFirstFrame() {
        ensureRunningOnMainThread();
        for (FlutterUiDisplayListener onFlutterUiDisplayed : this.flutterUiDisplayListeners) {
            onFlutterUiDisplayed.onFlutterUiDisplayed();
        }
    }

    @UiThread
    @VisibleForTesting
    public void onRenderingStopped() {
        ensureRunningOnMainThread();
        for (FlutterUiDisplayListener onFlutterUiNoLongerDisplayed : this.flutterUiDisplayListeners) {
            onFlutterUiNoLongerDisplayed.onFlutterUiNoLongerDisplayed();
        }
    }

    @UiThread
    public void onSurfaceChanged(int i11, int i12) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativeShellHolderId.longValue(), i11, i12);
    }

    @UiThread
    public void onSurfaceCreated(@NonNull Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativeShellHolderId.longValue(), surface);
    }

    @UiThread
    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    @UiThread
    public void onSurfaceWindowChanged(@NonNull Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), surface);
    }

    public void onVsync(long j11, long j12, long j13) {
        nativeOnVsync(j11, j12, j13);
    }

    @VisibleForTesting
    public long performNativeAttach(@NonNull FlutterJNI flutterJNI) {
        return nativeAttach(flutterJNI);
    }

    public void prefetchDefaultFontManager() {
        if (prefetchDefaultFontManagerCalled) {
            Log.w(TAG, "FlutterJNI.prefetchDefaultFontManager called more than once");
        }
        nativePrefetchDefaultFontManager();
        prefetchDefaultFontManagerCalled = true;
    }

    @UiThread
    public void registerTexture(long j11, @NonNull SurfaceTextureWrapper surfaceTextureWrapper) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterTexture(this.nativeShellHolderId.longValue(), j11, new WeakReference(surfaceTextureWrapper));
    }

    @UiThread
    public void removeEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener engineLifecycleListener) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(engineLifecycleListener);
    }

    @UiThread
    public void removeIsDisplayingFlutterUiListener(@NonNull FlutterUiDisplayListener flutterUiDisplayListener) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(flutterUiDisplayListener);
    }

    @UiThread
    public void requestDartDeferredLibrary(int i11) {
        DeferredComponentManager deferredComponentManager2 = this.deferredComponentManager;
        if (deferredComponentManager2 != null) {
            deferredComponentManager2.installDeferredComponent(i11, (String) null);
        } else {
            Log.e(TAG, "No DeferredComponentManager found. Android setup must be completed before using split AOT deferred components.");
        }
    }

    @UiThread
    public void runBundleAndSnapshotFromLibrary(@NonNull String str, @Nullable String str2, @Nullable String str3, @NonNull AssetManager assetManager, @Nullable List<String> list) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRunBundleAndSnapshotFromLibrary(this.nativeShellHolderId.longValue(), str, str2, str3, assetManager, list);
    }

    @UiThread
    public void setAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate2) {
        ensureRunningOnMainThread();
        this.accessibilityDelegate = accessibilityDelegate2;
    }

    @UiThread
    public void setAccessibilityFeatures(int i11) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetAccessibilityFeatures(this.nativeShellHolderId.longValue(), i11);
    }

    public void setAsyncWaitForVsyncDelegate(@Nullable AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate2) {
        asyncWaitForVsyncDelegate = asyncWaitForVsyncDelegate2;
    }

    @UiThread
    public void setDeferredComponentManager(@Nullable DeferredComponentManager deferredComponentManager2) {
        ensureRunningOnMainThread();
        this.deferredComponentManager = deferredComponentManager2;
        if (deferredComponentManager2 != null) {
            deferredComponentManager2.setJNI(this);
        }
    }

    @UiThread
    public void setLocalizationPlugin(@Nullable LocalizationPlugin localizationPlugin2) {
        ensureRunningOnMainThread();
        this.localizationPlugin = localizationPlugin2;
    }

    @UiThread
    public void setPlatformMessageHandler(@Nullable PlatformMessageHandler platformMessageHandler2) {
        ensureRunningOnMainThread();
        this.platformMessageHandler = platformMessageHandler2;
    }

    @UiThread
    public void setPlatformViewsController(@NonNull PlatformViewsController platformViewsController2) {
        ensureRunningOnMainThread();
        this.platformViewsController = platformViewsController2;
    }

    public void setRefreshRateFPS(float f11) {
        refreshRateFPS = f11;
        updateRefreshRate();
    }

    @UiThread
    public void setSemanticsEnabled(boolean z11) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetSemanticsEnabled(this.nativeShellHolderId.longValue(), z11);
    }

    @UiThread
    public void setViewportMetrics(float f11, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, int i24, int i25, int i26, int[] iArr, int[] iArr2, int[] iArr3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), f11, i11, i12, i13, i14, i15, i16, i17, i18, i19, i21, i22, i23, i24, i25, i26, iArr, iArr2, iArr3);
    }

    @UiThread
    @NonNull
    public FlutterJNI spawn(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable List<String> list) {
        boolean z11;
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        FlutterJNI nativeSpawn = nativeSpawn(this.nativeShellHolderId.longValue(), str, str2, str3, list);
        Long l11 = nativeSpawn.nativeShellHolderId;
        if (l11 == null || l11.longValue() == 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        Preconditions.checkState(z11, "Failed to spawn new JNI connected shell from existing shell.");
        return nativeSpawn;
    }

    @UiThread
    public void unregisterTexture(long j11) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUnregisterTexture(this.nativeShellHolderId.longValue(), j11);
    }

    @UiThread
    public void updateJavaAssetManager(@NonNull AssetManager assetManager, @NonNull String str) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUpdateJavaAssetManager(this.nativeShellHolderId.longValue(), assetManager, str);
    }

    public void updateRefreshRate() {
        if (loadLibraryCalled) {
            nativeUpdateRefreshRate(refreshRateFPS);
        }
    }

    public void dispatchSemanticsAction(int i11, @NonNull AccessibilityBridge.Action action, @Nullable Object obj) {
        ByteBuffer byteBuffer;
        int i12;
        ensureAttachedToNative();
        if (obj != null) {
            byteBuffer = StandardMessageCodec.INSTANCE.encodeMessage(obj);
            i12 = byteBuffer.position();
        } else {
            byteBuffer = null;
            i12 = 0;
        }
        dispatchSemanticsAction(i11, action.value, byteBuffer, i12);
    }

    @UiThread
    public void dispatchSemanticsAction(int i11, int i12, @Nullable ByteBuffer byteBuffer, int i13) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchSemanticsAction(this.nativeShellHolderId.longValue(), i11, i12, byteBuffer, i13);
    }
}
