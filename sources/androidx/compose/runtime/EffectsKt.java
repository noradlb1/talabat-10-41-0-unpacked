package androidx.compose.runtime;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001a0\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000e\u001a:\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0010\u001aD\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0012\u001a>\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0014\"\u0004\u0018\u00010\r2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u0015\u001aW\u0010\u0016\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001aM\u0010\u0016\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001aC\u0010\u0016\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001aQ\u0010\u0016\u001a\u00020\u00062\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\u0014\"\u0004\u0018\u00010\r2'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a9\u0010\u0016\u001a\u00020\u00062'\u0010\u0017\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0018¢\u0006\u0002\b\nH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a\u001b\u0010 \u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060!H\u0007¢\u0006\u0002\u0010\"\u001a\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001\u001a&\u0010(\u001a\u00020\u00192\u0013\b\u0006\u0010)\u001a\r\u0012\u0004\u0012\u00020%0!¢\u0006\u0002\b*H\bø\u0001\u0001¢\u0006\u0002\u0010+\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006,"}, d2 = {"DisposableEffectNoParamError", "", "InternalDisposableEffectScope", "Landroidx/compose/runtime/DisposableEffectScope;", "LaunchedEffectNoParamError", "DisposableEffect", "", "effect", "Lkotlin/Function1;", "Landroidx/compose/runtime/DisposableEffectResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key1", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key2", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "key3", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "keys", "", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LaunchedEffect", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SideEffect", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "createCompositionCoroutineScope", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "composer", "Landroidx/compose/runtime/Composer;", "rememberCoroutineScope", "getContext", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlinx/coroutines/CoroutineScope;", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class EffectsKt {
    @NotNull
    private static final String DisposableEffectNoParamError = "DisposableEffect must provide one or more 'key' parameters that define the identity of the DisposableEffect and determine when its previous effect should be disposed and a new effect started for the new key.";
    /* access modifiers changed from: private */
    @NotNull
    public static final DisposableEffectScope InternalDisposableEffectScope = new DisposableEffectScope();
    @NotNull
    private static final String LaunchedEffectNoParamError = "LaunchedEffect must provide one or more 'key' parameters that define the identity of the LaunchedEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.";

    @Deprecated(level = DeprecationLevel.ERROR, message = "DisposableEffect must provide one or more 'key' parameters that define the identity of the DisposableEffect and determine when its previous effect should be disposed and a new effect started for the new key.")
    @Composable
    public static final void DisposableEffect(@NotNull Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> function1, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(function1, "effect");
        composer.startReplaceableGroup(-904483903);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-904483903, i11, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:115)");
        }
        throw new IllegalStateException(DisposableEffectNoParamError.toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "LaunchedEffect must provide one or more 'key' parameters that define the identity of the LaunchedEffect and determine when its previous effect coroutine should be cancelled and a new effect launched for the new key.")
    @Composable
    public static final void LaunchedEffect(@NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(function2, "block");
        Composer startRestartGroup = composer.startRestartGroup(-805415771);
        if ((i11 & 1) != 0 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-805415771, i11, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:313)");
            }
            throw new IllegalStateException(LaunchedEffectNoParamError.toString());
        }
        startRestartGroup.skipToGroupEnd();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new EffectsKt$LaunchedEffect$1(function2, i11));
        }
    }

    @Composable
    public static final void SideEffect(@NotNull Function0<Unit> function0, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(function0, "effect");
        composer.startReplaceableGroup(-1288466761);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1288466761, i11, -1, "androidx.compose.runtime.SideEffect (Effects.kt:44)");
        }
        composer.recordSideEffect(function0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @NotNull
    @PublishedApi
    public static final CoroutineScope createCompositionCoroutineScope(@NotNull CoroutineContext coroutineContext, @NotNull Composer composer) {
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(composer, "composer");
        Job.Key key = Job.Key;
        if (coroutineContext.get(key) != null) {
            CompletableJob Job$default = JobKt.Job$default((Job) null, 1, (Object) null);
            Job$default.completeExceptionally(new IllegalArgumentException("CoroutineContext supplied to rememberCoroutineScope may not include a parent job"));
            return CoroutineScopeKt.CoroutineScope(Job$default);
        }
        CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
        return CoroutineScopeKt.CoroutineScope(applyCoroutineContext.plus(JobKt.Job((Job) applyCoroutineContext.get(key))).plus(coroutineContext));
    }

    @NotNull
    @Composable
    public static final CoroutineScope rememberCoroutineScope(@Nullable Function0<? extends CoroutineContext> function0, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(773894976);
        if ((i12 & 1) != 0) {
            function0 = EffectsKt$rememberCoroutineScope$1.INSTANCE;
        }
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new CompositionScopedCoroutineScopeCanceller(createCompositionCoroutineScope((CoroutineContext) function0.invoke(), composer));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        return coroutineScope;
    }

    @Composable
    public static final void DisposableEffect(@Nullable Object obj, @NotNull Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> function1, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(function1, "effect");
        composer.startReplaceableGroup(-1371986847);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1371986847, i11, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:150)");
        }
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new DisposableEffectImpl(function1));
        }
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void LaunchedEffect(@Nullable Object obj, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(function2, "block");
        composer.startReplaceableGroup(1179185413);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1179185413, i11, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:331)");
        }
        CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(obj);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, function2));
        }
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void DisposableEffect(@Nullable Object obj, @Nullable Object obj2, @NotNull Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> function1, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(function1, "effect");
        composer.startReplaceableGroup(1429097729);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1429097729, i11, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:189)");
        }
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(obj) | composer.changed(obj2);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new DisposableEffectImpl(function1));
        }
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void LaunchedEffect(@Nullable Object obj, @Nullable Object obj2, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(function2, "block");
        composer.startReplaceableGroup(590241125);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(590241125, i11, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:353)");
        }
        CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(obj) | composer.changed(obj2);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, function2));
        }
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void DisposableEffect(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> function1, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(function1, "effect");
        composer.startReplaceableGroup(-1239538271);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1239538271, i11, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:229)");
        }
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(obj) | composer.changed(obj2) | composer.changed(obj3);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new DisposableEffectImpl(function1));
        }
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void LaunchedEffect(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(function2, "block");
        composer.startReplaceableGroup(-54093371);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-54093371, i11, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:376)");
        }
        CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(obj) | composer.changed(obj2) | composer.changed(obj3);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, function2));
        }
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void DisposableEffect(@NotNull Object[] objArr, @NotNull Function1<? super DisposableEffectScope, ? extends DisposableEffectResult> function1, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(objArr, UserMetadata.KEYDATA_FILENAME);
        Intrinsics.checkNotNullParameter(function1, "effect");
        composer.startReplaceableGroup(-1307627122);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1307627122, i11, -1, "androidx.compose.runtime.DisposableEffect (Effects.kt:271)");
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        composer.startReplaceableGroup(-568225417);
        boolean z11 = false;
        for (Object changed : copyOf) {
            z11 |= composer.changed(changed);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z11 || rememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new DisposableEffectImpl(function1));
        }
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void LaunchedEffect(@NotNull Object[] objArr, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(objArr, UserMetadata.KEYDATA_FILENAME);
        Intrinsics.checkNotNullParameter(function2, "block");
        composer.startReplaceableGroup(-139560008);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-139560008, i11, -1, "androidx.compose.runtime.LaunchedEffect (Effects.kt:401)");
        }
        CoroutineContext applyCoroutineContext = composer.getApplyCoroutineContext();
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        composer.startReplaceableGroup(-568225417);
        boolean z11 = false;
        for (Object changed : copyOf) {
            z11 |= composer.changed(changed);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z11 || rememberedValue == Composer.Companion.getEmpty()) {
            composer.updateRememberedValue(new LaunchedEffectImpl(applyCoroutineContext, function2));
        }
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
