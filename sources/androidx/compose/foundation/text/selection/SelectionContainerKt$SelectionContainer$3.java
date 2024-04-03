package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TouchMode_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SelectionContainerKt$SelectionContainer$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SelectionRegistrarImpl f3671g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f3672h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SelectionManager f3673i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3674j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f3675k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionContainerKt$SelectionContainer$3(SelectionRegistrarImpl selectionRegistrarImpl, Modifier modifier, SelectionManager selectionManager, Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f3671g = selectionRegistrarImpl;
        this.f3672h = modifier;
        this.f3673i = selectionManager;
        this.f3674j = function2;
        this.f3675k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-123806316, i11, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous> (SelectionContainer.kt:94)");
            }
            ProvidedValue[] providedValueArr = {SelectionRegistrarKt.getLocalSelectionRegistrar().provides(this.f3671g)};
            final Modifier modifier = this.f3672h;
            final SelectionManager selectionManager = this.f3673i;
            final Function2<Composer, Integer, Unit> function2 = this.f3674j;
            final int i12 = this.f3675k;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, 935424596, true, new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    if ((i11 & 11) != 2 || !composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(935424596, i11, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous> (SelectionContainer.kt:95)");
                        }
                        Modifier then = modifier.then(selectionManager.getModifier());
                        final Function2<Composer, Integer, Unit> function2 = function2;
                        final int i12 = i12;
                        final SelectionManager selectionManager = selectionManager;
                        SimpleLayoutKt.SimpleLayout(then, ComposableLambdaKt.composableLambda(composer, 1375295262, true, new Function2<Composer, Integer, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                            @Composable
                            public final void invoke(@Nullable Composer composer, int i11) {
                                Selection selection;
                                Offset offset;
                                ResolvedTextDirection resolvedTextDirection;
                                Composer composer2 = composer;
                                int i12 = i11;
                                if ((i12 & 11) != 2 || !composer.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1375295262, i12, -1, "androidx.compose.foundation.text.selection.SelectionContainer.<anonymous>.<anonymous>.<anonymous> (SelectionContainer.kt:98)");
                                    }
                                    function2.invoke(composer2, Integer.valueOf((i12 >> 9) & 14));
                                    if (TouchMode_androidKt.isInTouchMode() && selectionManager.getHasFocus() && (selection = selectionManager.getSelection()) != null) {
                                        SelectionManager selectionManager = selectionManager;
                                        List listOf = CollectionsKt__CollectionsKt.listOf(Boolean.TRUE, Boolean.FALSE);
                                        int size = listOf.size();
                                        for (int i13 = 0; i13 < size; i13++) {
                                            boolean booleanValue = ((Boolean) listOf.get(i13)).booleanValue();
                                            Boolean valueOf = Boolean.valueOf(booleanValue);
                                            composer2.startReplaceableGroup(1157296644);
                                            boolean changed = composer2.changed((Object) valueOf);
                                            Object rememberedValue = composer.rememberedValue();
                                            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                                                rememberedValue = selectionManager.handleDragObserver(booleanValue);
                                                composer2.updateRememberedValue(rememberedValue);
                                            }
                                            composer.endReplaceableGroup();
                                            TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
                                            if (booleanValue) {
                                                offset = selectionManager.m1011getStartHandlePosition_m7T9E();
                                            } else {
                                                offset = selectionManager.m1010getEndHandlePosition_m7T9E();
                                            }
                                            if (booleanValue) {
                                                resolvedTextDirection = selection.getStart().getDirection();
                                            } else {
                                                resolvedTextDirection = selection.getEnd().getDirection();
                                            }
                                            if (offset != null) {
                                                AndroidSelectionHandles_androidKt.m944SelectionHandle8fL75g(offset.m2686unboximpl(), booleanValue, resolvedTextDirection, selection.getHandlesCrossed(), SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) textDragObserver, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new SelectionContainerKt$SelectionContainer$3$1$1$1$1$1(textDragObserver, (Continuation<? super SelectionContainerKt$SelectionContainer$3$1$1$1$1$1>) null)), (Function2<? super Composer, ? super Integer, Unit>) null, composer, 196608);
                                            }
                                        }
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer.skipToGroupEnd();
                            }
                        }), composer, 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            }), composer, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
