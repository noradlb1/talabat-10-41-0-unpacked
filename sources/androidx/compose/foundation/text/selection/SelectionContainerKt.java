package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.TouchMode_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import com.google.android.exoplayer2.RendererCapabilities;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a*\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0002\u0010\t\u001aJ\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00010\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"DisableSelection", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionContainer", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "onSelectionChange", "Lkotlin/Function1;", "children", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/Selection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SelectionContainerKt {
    @ComposableInferredTarget(scheme = "[0[0]]")
    @Composable
    public static final void DisableSelection(@NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(336063542);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if ((i12 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(336063542, i12, -1, "androidx.compose.foundation.text.selection.DisableSelection (SelectionContainer.kt:60)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{SelectionRegistrarKt.getLocalSelectionRegistrar().provides(null)}, function2, startRestartGroup, ((i12 << 3) & 112) | 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SelectionContainerKt$DisableSelection$1(function2, i11));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void SelectionContainer(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r8, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r9, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r10, int r11, int r12) {
        /*
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = -1075498320(0xffffffffbfe532b0, float:-1.7906094)
            androidx.compose.runtime.Composer r10 = r10.startRestartGroup(r0)
            r1 = r12 & 1
            r2 = 2
            if (r1 == 0) goto L_0x0014
            r3 = r11 | 6
            goto L_0x0024
        L_0x0014:
            r3 = r11 & 14
            if (r3 != 0) goto L_0x0023
            boolean r3 = r10.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x0020
            r3 = 4
            goto L_0x0021
        L_0x0020:
            r3 = r2
        L_0x0021:
            r3 = r3 | r11
            goto L_0x0024
        L_0x0023:
            r3 = r11
        L_0x0024:
            r4 = r12 & 2
            if (r4 == 0) goto L_0x002b
            r3 = r3 | 48
            goto L_0x003b
        L_0x002b:
            r4 = r11 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x003b
            boolean r4 = r10.changed((java.lang.Object) r9)
            if (r4 == 0) goto L_0x0038
            r4 = 32
            goto L_0x003a
        L_0x0038:
            r4 = 16
        L_0x003a:
            r3 = r3 | r4
        L_0x003b:
            r4 = r3 & 91
            r5 = 18
            if (r4 != r5) goto L_0x004d
            boolean r4 = r10.getSkipping()
            if (r4 != 0) goto L_0x0048
            goto L_0x004d
        L_0x0048:
            r10.skipToGroupEnd()
            goto L_0x00bd
        L_0x004d:
            if (r1 == 0) goto L_0x0051
            androidx.compose.ui.Modifier$Companion r8 = androidx.compose.ui.Modifier.Companion
        L_0x0051:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x005d
            r1 = -1
            java.lang.String r4 = "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:41)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r1, r4)
        L_0x005d:
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            java.lang.Object r0 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r1.getEmpty()
            if (r0 != r4) goto L_0x0077
            r0 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r0, r2, r0)
            r10.updateRememberedValue(r0)
        L_0x0077:
            r10.endReplaceableGroup()
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            androidx.compose.foundation.text.selection.Selection r2 = m975SelectionContainer$lambda1(r0)
            r4 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r4)
            boolean r4 = r10.changed((java.lang.Object) r0)
            java.lang.Object r5 = r10.rememberedValue()
            if (r4 != 0) goto L_0x0096
            java.lang.Object r1 = r1.getEmpty()
            if (r5 != r1) goto L_0x009e
        L_0x0096:
            androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$1$1 r5 = new androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$1$1
            r5.<init>(r0)
            r10.updateRememberedValue(r5)
        L_0x009e:
            r10.endReplaceableGroup()
            r0 = r5
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r1 = r3 & 14
            int r3 = r3 << 6
            r3 = r3 & 7168(0x1c00, float:1.0045E-41)
            r6 = r1 | r3
            r7 = 0
            r1 = r8
            r3 = r0
            r4 = r9
            r5 = r10
            SelectionContainer(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x00bd
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00bd:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto L_0x00c4
            goto L_0x00cc
        L_0x00c4:
            androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$2 r0 = new androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$2
            r0.<init>(r8, r9, r11, r12)
            r10.updateScope(r0)
        L_0x00cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionContainerKt.SelectionContainer(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: SelectionContainer$lambda-1  reason: not valid java name */
    private static final Selection m975SelectionContainer$lambda1(MutableState<Selection> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: SelectionContainer$lambda-2  reason: not valid java name */
    public static final void m976SelectionContainer$lambda2(MutableState<Selection> mutableState, Selection selection) {
        mutableState.setValue(selection);
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void SelectionContainer(@Nullable Modifier modifier, @Nullable Selection selection, @NotNull Function1<? super Selection, Unit> function1, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11, int i12) {
        int i13;
        Intrinsics.checkNotNullParameter(function1, "onSelectionChange");
        Intrinsics.checkNotNullParameter(function2, "children");
        Composer startRestartGroup = composer.startRestartGroup(2078139907);
        int i14 = i12 & 1;
        if (i14 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            i13 = (startRestartGroup.changed((Object) modifier) ? 4 : 2) | i11;
        } else {
            i13 = i11;
        }
        if ((i12 & 2) != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            i13 |= startRestartGroup.changed((Object) selection) ? 32 : 16;
        }
        if ((i12 & 4) != 0) {
            i13 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i11 & 896) == 0) {
            i13 |= startRestartGroup.changed((Object) function1) ? 256 : 128;
        }
        if ((i12 & 8) != 0) {
            i13 |= KfsConstant.KFS_RSA_KEY_LEN_3072;
        } else if ((i11 & 7168) == 0) {
            i13 |= startRestartGroup.changed((Object) function2) ? 2048 : 1024;
        }
        int i15 = i13;
        if ((i15 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            if (i14 != 0) {
                modifier = Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2078139907, i15, -1, "androidx.compose.foundation.text.selection.SelectionContainer (SelectionContainer.kt:75)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = new SelectionRegistrarImpl();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SelectionRegistrarImpl selectionRegistrarImpl = (SelectionRegistrarImpl) rememberedValue;
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new SelectionManager(selectionRegistrarImpl);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            SelectionManager selectionManager = (SelectionManager) rememberedValue2;
            selectionManager.setHapticFeedBack((HapticFeedback) startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
            selectionManager.setClipboardManager((ClipboardManager) startRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
            selectionManager.setTextToolbar((TextToolbar) startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
            selectionManager.setOnSelectionChange(function1);
            selectionManager.setSelection(selection);
            selectionManager.setTouchMode(TouchMode_androidKt.isInTouchMode());
            ContextMenu_androidKt.ContextMenuArea(selectionManager, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -123806316, true, new SelectionContainerKt$SelectionContainer$3(selectionRegistrarImpl, modifier, selectionManager, function2, i15)), startRestartGroup, 56);
            EffectsKt.DisposableEffect((Object) selectionManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new SelectionContainerKt$SelectionContainer$4(selectionManager), startRestartGroup, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        Modifier modifier2 = modifier;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new SelectionContainerKt$SelectionContainer$5(modifier2, selection, function1, function2, i11, i12));
        }
    }
}
