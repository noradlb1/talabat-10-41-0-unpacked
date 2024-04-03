package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class HoverableKt$hoverable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1680g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f1681h;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.HoverableKt$hoverable$2$3", f = "Hoverable.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.HoverableKt$hoverable$2$3  reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f1688h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass3 r02 = new AnonymousClass3(coroutineScope, mutableInteractionSource3, mutableState, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f1688h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineContext context = getContext();
                final CoroutineScope coroutineScope = coroutineScope;
                final MutableInteractionSource mutableInteractionSource = mutableInteractionSource3;
                final MutableState<HoverInteraction.Enter> mutableState = mutableState;
                AnonymousClass1 r32 = new Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    private /* synthetic */ Object L$0;

                    /* renamed from: h  reason: collision with root package name */
                    public int f1692h;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        AnonymousClass1 r02 = 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public HoverableKt$hoverable$2(MutableInteractionSource mutableInteractionSource, boolean z11) {
                            super(3);
                            this.f1680g = mutableInteractionSource;
                            this.f1681h = z11;
                        }

                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public static final java.lang.Object invoke$emitEnter(androidx.compose.foundation.interaction.MutableInteractionSource r4, androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.HoverInteraction.Enter> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
                            /*
                                boolean r0 = r6 instanceof androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1
                                if (r0 == 0) goto L_0x0013
                                r0 = r6
                                androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1 r0 = (androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1) r0
                                int r1 = r0.f1706k
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L_0x0013
                                int r1 = r1 - r2
                                r0.f1706k = r1
                                goto L_0x0018
                            L_0x0013:
                                androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1 r0 = new androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitEnter$1
                                r0.<init>(r6)
                            L_0x0018:
                                java.lang.Object r6 = r0.f1705j
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.f1706k
                                r3 = 1
                                if (r2 == 0) goto L_0x0039
                                if (r2 != r3) goto L_0x0031
                                java.lang.Object r4 = r0.f1704i
                                androidx.compose.foundation.interaction.HoverInteraction$Enter r4 = (androidx.compose.foundation.interaction.HoverInteraction.Enter) r4
                                java.lang.Object r5 = r0.f1703h
                                androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L_0x0055
                            L_0x0031:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L_0x0039:
                                kotlin.ResultKt.throwOnFailure(r6)
                                androidx.compose.foundation.interaction.HoverInteraction$Enter r6 = m224invoke$lambda1(r5)
                                if (r6 != 0) goto L_0x0058
                                androidx.compose.foundation.interaction.HoverInteraction$Enter r6 = new androidx.compose.foundation.interaction.HoverInteraction$Enter
                                r6.<init>()
                                r0.f1703h = r5
                                r0.f1704i = r6
                                r0.f1706k = r3
                                java.lang.Object r4 = r4.emit(r6, r0)
                                if (r4 != r1) goto L_0x0054
                                return r1
                            L_0x0054:
                                r4 = r6
                            L_0x0055:
                                m225invoke$lambda2(r5, r4)
                            L_0x0058:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.HoverableKt$hoverable$2.invoke$emitEnter(androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.MutableState, kotlin.coroutines.Continuation):java.lang.Object");
                        }

                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public static final java.lang.Object invoke$emitExit(androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.HoverInteraction.Enter> r4, androidx.compose.foundation.interaction.MutableInteractionSource r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
                            /*
                                boolean r0 = r6 instanceof androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1
                                if (r0 == 0) goto L_0x0013
                                r0 = r6
                                androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1 r0 = (androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1) r0
                                int r1 = r0.f1709j
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L_0x0013
                                int r1 = r1 - r2
                                r0.f1709j = r1
                                goto L_0x0018
                            L_0x0013:
                                androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1 r0 = new androidx.compose.foundation.HoverableKt$hoverable$2$invoke$emitExit$1
                                r0.<init>(r6)
                            L_0x0018:
                                java.lang.Object r6 = r0.f1708i
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.f1709j
                                r3 = 1
                                if (r2 == 0) goto L_0x0035
                                if (r2 != r3) goto L_0x002d
                                java.lang.Object r4 = r0.f1707h
                                androidx.compose.runtime.MutableState r4 = (androidx.compose.runtime.MutableState) r4
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L_0x004e
                            L_0x002d:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L_0x0035:
                                kotlin.ResultKt.throwOnFailure(r6)
                                androidx.compose.foundation.interaction.HoverInteraction$Enter r6 = m224invoke$lambda1(r4)
                                if (r6 == 0) goto L_0x0052
                                androidx.compose.foundation.interaction.HoverInteraction$Exit r2 = new androidx.compose.foundation.interaction.HoverInteraction$Exit
                                r2.<init>(r6)
                                r0.f1707h = r4
                                r0.f1709j = r3
                                java.lang.Object r5 = r5.emit(r2, r0)
                                if (r5 != r1) goto L_0x004e
                                return r1
                            L_0x004e:
                                r5 = 0
                                m225invoke$lambda2(r4, r5)
                            L_0x0052:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.HoverableKt$hoverable$2.invoke$emitExit(androidx.compose.runtime.MutableState, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.coroutines.Continuation):java.lang.Object");
                        }

                        /* renamed from: invoke$lambda-1  reason: not valid java name */
                        private static final HoverInteraction.Enter m224invoke$lambda1(MutableState<HoverInteraction.Enter> mutableState) {
                            return mutableState.getValue();
                        }

                        /* renamed from: invoke$lambda-2  reason: not valid java name */
                        private static final void m225invoke$lambda2(MutableState<HoverInteraction.Enter> mutableState, HoverInteraction.Enter enter) {
                            mutableState.setValue(enter);
                        }

                        /* access modifiers changed from: private */
                        public static final void invoke$tryEmitExit(MutableState<HoverInteraction.Enter> mutableState, MutableInteractionSource mutableInteractionSource) {
                            HoverInteraction.Enter r02 = m224invoke$lambda1(mutableState);
                            if (r02 != null) {
                                mutableInteractionSource.tryEmit(new HoverInteraction.Exit(r02));
                                m225invoke$lambda2(mutableState, (HoverInteraction.Enter) null);
                            }
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                        }

                        @NotNull
                        @Composable
                        public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
                            Modifier modifier2;
                            Intrinsics.checkNotNullParameter(modifier, "$this$composed");
                            composer.startReplaceableGroup(1294013553);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1294013553, i11, -1, "androidx.compose.foundation.hoverable.<anonymous> (Hoverable.kt:54)");
                            }
                            composer.startReplaceableGroup(773894976);
                            composer.startReplaceableGroup(-492369756);
                            Object rememberedValue = composer.rememberedValue();
                            Composer.Companion companion = Composer.Companion;
                            if (rememberedValue == companion.getEmpty()) {
                                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                rememberedValue = compositionScopedCoroutineScopeCanceller;
                            }
                            composer.endReplaceableGroup();
                            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                            composer.endReplaceableGroup();
                            composer.startReplaceableGroup(-492369756);
                            Object rememberedValue2 = composer.rememberedValue();
                            if (rememberedValue2 == companion.getEmpty()) {
                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                                composer.updateRememberedValue(rememberedValue2);
                            }
                            composer.endReplaceableGroup();
                            final MutableState mutableState = (MutableState) rememberedValue2;
                            MutableInteractionSource mutableInteractionSource = this.f1680g;
                            composer.startReplaceableGroup(511388516);
                            boolean changed = composer.changed((Object) mutableState) | composer.changed((Object) mutableInteractionSource);
                            Object rememberedValue3 = composer.rememberedValue();
                            if (changed || rememberedValue3 == companion.getEmpty()) {
                                rememberedValue3 = new HoverableKt$hoverable$2$1$1(mutableState, mutableInteractionSource);
                                composer.updateRememberedValue(rememberedValue3);
                            }
                            composer.endReplaceableGroup();
                            EffectsKt.DisposableEffect((Object) mutableInteractionSource, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue3, composer, 0);
                            Boolean valueOf = Boolean.valueOf(this.f1681h);
                            Boolean valueOf2 = Boolean.valueOf(this.f1681h);
                            MutableInteractionSource mutableInteractionSource2 = this.f1680g;
                            boolean z11 = this.f1681h;
                            composer.startReplaceableGroup(1618982084);
                            boolean changed2 = composer.changed((Object) valueOf2) | composer.changed((Object) mutableState) | composer.changed((Object) mutableInteractionSource2);
                            Object rememberedValue4 = composer.rememberedValue();
                            if (changed2 || rememberedValue4 == companion.getEmpty()) {
                                rememberedValue4 = new HoverableKt$hoverable$2$2$1(z11, mutableState, mutableInteractionSource2, (Continuation<? super HoverableKt$hoverable$2$2$1>) null);
                                composer.updateRememberedValue(rememberedValue4);
                            }
                            composer.endReplaceableGroup();
                            EffectsKt.LaunchedEffect((Object) valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue4, composer, 64);
                            if (this.f1681h) {
                                Modifier.Companion companion2 = Modifier.Companion;
                                final MutableInteractionSource mutableInteractionSource3 = this.f1680g;
                                modifier2 = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion2, (Object) mutableInteractionSource3, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass3((Continuation<? super AnonymousClass3>) null));
                            } else {
                                modifier2 = Modifier.Companion;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer.endReplaceableGroup();
                            return modifier2;
                        }
                    }
