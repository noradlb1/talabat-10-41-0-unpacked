package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.res.ImageVectorCache;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00150\u0019¢\u0006\u0002\b\u001aH\u0001¢\u0006\u0002\u0010\u001b\u001a\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002\u001a\u001f\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0003¢\u0006\u0002\u0010#\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\"\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0004\"\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0004\"\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0004\"\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0004¨\u0006$"}, d2 = {"LocalConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroid/content/res/Configuration;", "getLocalConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalContext", "Landroid/content/Context;", "getLocalContext", "LocalImageVectorCache", "Landroidx/compose/ui/res/ImageVectorCache;", "getLocalImageVectorCache", "LocalLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getLocalLifecycleOwner", "LocalSavedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "getLocalSavedStateRegistryOwner", "LocalView", "Landroid/view/View;", "getLocalView", "ProvideAndroidCompositionLocals", "", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "noLocalProvidedFor", "", "name", "", "obtainImageVectorCache", "context", "configuration", "(Landroid/content/Context;Landroid/content/res/Configuration;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/res/ImageVectorCache;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidCompositionLocals_androidKt {
    @NotNull
    private static final ProvidableCompositionLocal<Configuration> LocalConfiguration = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.neverEqualPolicy(), AndroidCompositionLocals_androidKt$LocalConfiguration$1.INSTANCE);
    @NotNull
    private static final ProvidableCompositionLocal<Context> LocalContext = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalContext$1.INSTANCE);
    @NotNull
    private static final ProvidableCompositionLocal<ImageVectorCache> LocalImageVectorCache = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalImageVectorCache$1.INSTANCE);
    @NotNull
    private static final ProvidableCompositionLocal<LifecycleOwner> LocalLifecycleOwner = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalLifecycleOwner$1.INSTANCE);
    @NotNull
    private static final ProvidableCompositionLocal<SavedStateRegistryOwner> LocalSavedStateRegistryOwner = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalSavedStateRegistryOwner$1.INSTANCE);
    @NotNull
    private static final ProvidableCompositionLocal<View> LocalView = CompositionLocalKt.staticCompositionLocalOf(AndroidCompositionLocals_androidKt$LocalView$1.INSTANCE);

    @ComposableInferredTarget(scheme = "[0[0]]")
    @Composable
    public static final void ProvideAndroidCompositionLocals(@NotNull AndroidComposeView androidComposeView, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(androidComposeView, "owner");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(1396852028);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1396852028, i11, -1, "androidx.compose.ui.platform.ProvideAndroidCompositionLocals (AndroidCompositionLocals.android.kt:83)");
        }
        Context context = androidComposeView.getContext();
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue = startRestartGroup.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt.mutableStateOf(context.getResources().getConfiguration(), SnapshotStateKt.neverEqualPolicy());
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed((Object) mutableState);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$1$1(mutableState);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        androidComposeView.setConfigurationChangeObserver((Function1) rememberedValue2);
        startRestartGroup.startReplaceableGroup(-492369756);
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            rememberedValue3 = new AndroidUriHandler(context);
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        AndroidUriHandler androidUriHandler = (AndroidUriHandler) rememberedValue3;
        AndroidComposeView.ViewTreeOwners viewTreeOwners = androidComposeView.getViewTreeOwners();
        if (viewTreeOwners != null) {
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = DisposableSaveableStateRegistry_androidKt.DisposableSaveableStateRegistry((View) androidComposeView, viewTreeOwners.getSavedStateRegistryOwner());
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceableGroup();
            DisposableSaveableStateRegistry disposableSaveableStateRegistry = (DisposableSaveableStateRegistry) rememberedValue4;
            EffectsKt.DisposableEffect((Object) Unit.INSTANCE, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$2(disposableSaveableStateRegistry), startRestartGroup, 0);
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ImageVectorCache obtainImageVectorCache = obtainImageVectorCache(context, m4818ProvideAndroidCompositionLocals$lambda1(mutableState), startRestartGroup, 72);
            ProvidableCompositionLocal<Configuration> providableCompositionLocal = LocalConfiguration;
            Configuration r22 = m4818ProvideAndroidCompositionLocals$lambda1(mutableState);
            Intrinsics.checkNotNullExpressionValue(r22, "configuration");
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{providableCompositionLocal.provides(r22), LocalContext.provides(context), LocalLifecycleOwner.provides(viewTreeOwners.getLifecycleOwner()), LocalSavedStateRegistryOwner.provides(viewTreeOwners.getSavedStateRegistryOwner()), SaveableStateRegistryKt.getLocalSaveableStateRegistry().provides(disposableSaveableStateRegistry), LocalView.provides(androidComposeView.getView()), LocalImageVectorCache.provides(obtainImageVectorCache)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 1471621628, true, new AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$3(androidComposeView, androidUriHandler, function2, i11)), startRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new AndroidCompositionLocals_androidKt$ProvideAndroidCompositionLocals$4(androidComposeView, function2, i11));
                return;
            }
            return;
        }
        throw new IllegalStateException("Called when the ViewTreeOwnersAvailability is not yet in Available state");
    }

    /* renamed from: ProvideAndroidCompositionLocals$lambda-1  reason: not valid java name */
    private static final Configuration m4818ProvideAndroidCompositionLocals$lambda1(MutableState<Configuration> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ProvideAndroidCompositionLocals$lambda-2  reason: not valid java name */
    public static final void m4819ProvideAndroidCompositionLocals$lambda2(MutableState<Configuration> mutableState, Configuration configuration) {
        mutableState.setValue(configuration);
    }

    @NotNull
    public static final ProvidableCompositionLocal<Configuration> getLocalConfiguration() {
        return LocalConfiguration;
    }

    @NotNull
    public static final ProvidableCompositionLocal<Context> getLocalContext() {
        return LocalContext;
    }

    @NotNull
    public static final ProvidableCompositionLocal<ImageVectorCache> getLocalImageVectorCache() {
        return LocalImageVectorCache;
    }

    @NotNull
    public static final ProvidableCompositionLocal<LifecycleOwner> getLocalLifecycleOwner() {
        return LocalLifecycleOwner;
    }

    @NotNull
    public static final ProvidableCompositionLocal<SavedStateRegistryOwner> getLocalSavedStateRegistryOwner() {
        return LocalSavedStateRegistryOwner;
    }

    @NotNull
    public static final ProvidableCompositionLocal<View> getLocalView() {
        return LocalView;
    }

    /* access modifiers changed from: private */
    public static final Void noLocalProvidedFor(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }

    @Stable
    @Composable
    private static final ImageVectorCache obtainImageVectorCache(Context context, Configuration configuration, Composer composer, int i11) {
        composer.startReplaceableGroup(-485908294);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-485908294, i11, -1, "androidx.compose.ui.platform.obtainImageVectorCache (AndroidCompositionLocals.android.kt:132)");
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new ImageVectorCache();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        ImageVectorCache imageVectorCache = (ImageVectorCache) rememberedValue;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        Configuration configuration2 = rememberedValue2;
        if (rememberedValue2 == companion.getEmpty()) {
            Configuration configuration3 = new Configuration();
            if (configuration != null) {
                configuration3.setTo(configuration);
            }
            composer.updateRememberedValue(configuration3);
            configuration2 = configuration3;
        }
        composer.endReplaceableGroup();
        Configuration configuration4 = (Configuration) configuration2;
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1(configuration4, imageVectorCache);
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        EffectsKt.DisposableEffect((Object) imageVectorCache, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new AndroidCompositionLocals_androidKt$obtainImageVectorCache$1(context, (AndroidCompositionLocals_androidKt$obtainImageVectorCache$callbacks$1$1) rememberedValue3), composer, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return imageVectorCache;
    }
}
