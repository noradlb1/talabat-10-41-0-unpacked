package androidx.compose.ui.viewinterop;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0007\u001a\u00020\u0003\"\b\b\u0000\u0010\b*\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\b0\u00012\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0007¢\u0006\u0002\u0010\u000e\"\"\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"NoOpUpdate", "Lkotlin/Function1;", "Landroid/view/View;", "", "Lkotlin/ExtensionFunctionType;", "getNoOpUpdate", "()Lkotlin/jvm/functions/Function1;", "AndroidView", "T", "factory", "Landroid/content/Context;", "modifier", "Landroidx/compose/ui/Modifier;", "update", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidView_androidKt {
    @NotNull
    private static final Function1<View, Unit> NoOpUpdate = AndroidView_androidKt$NoOpUpdate$1.INSTANCE;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.UiComposable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends android.view.View> void AndroidView(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.content.Context, ? extends T> r17, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r18, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r19, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r8 = r17
            r9 = r21
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -1783766393(0xffffffff95ade287, float:-7.023154E-26)
            r1 = r20
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            r1 = r22 & 1
            if (r1 == 0) goto L_0x0019
            r1 = r9 | 6
            goto L_0x0029
        L_0x0019:
            r1 = r9 & 14
            if (r1 != 0) goto L_0x0028
            boolean r1 = r10.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x0025
            r1 = 4
            goto L_0x0026
        L_0x0025:
            r1 = 2
        L_0x0026:
            r1 = r1 | r9
            goto L_0x0029
        L_0x0028:
            r1 = r9
        L_0x0029:
            r2 = r22 & 2
            if (r2 == 0) goto L_0x0030
            r1 = r1 | 48
            goto L_0x0043
        L_0x0030:
            r3 = r9 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0043
            r3 = r18
            boolean r4 = r10.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x003f
            r4 = 32
            goto L_0x0041
        L_0x003f:
            r4 = 16
        L_0x0041:
            r1 = r1 | r4
            goto L_0x0045
        L_0x0043:
            r3 = r18
        L_0x0045:
            r4 = r22 & 4
            if (r4 == 0) goto L_0x004c
            r1 = r1 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r5 = r9 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x005f
            r5 = r19
            boolean r6 = r10.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x005b
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r1 = r1 | r6
            goto L_0x0061
        L_0x005f:
            r5 = r19
        L_0x0061:
            r1 = r1 & 731(0x2db, float:1.024E-42)
            r6 = 146(0x92, float:2.05E-43)
            if (r1 != r6) goto L_0x0075
            boolean r1 = r10.getSkipping()
            if (r1 != 0) goto L_0x006e
            goto L_0x0075
        L_0x006e:
            r10.skipToGroupEnd()
            r2 = r3
            r3 = r5
            goto L_0x01dc
        L_0x0075:
            if (r2 == 0) goto L_0x007b
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r11 = r1
            goto L_0x007c
        L_0x007b:
            r11 = r3
        L_0x007c:
            if (r4 == 0) goto L_0x0082
            kotlin.jvm.functions.Function1<android.view.View, kotlin.Unit> r1 = NoOpUpdate
            r12 = r1
            goto L_0x0083
        L_0x0082:
            r12 = r5
        L_0x0083:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x008f
            r1 = -1
            java.lang.String r2 = "androidx.compose.ui.viewinterop.AndroidView (AndroidView.android.kt:81)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r9, r1, r2)
        L_0x008f:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            java.lang.Object r0 = r10.consume(r0)
            r1 = r0
            android.content.Context r1 = (android.content.Context) r1
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            java.lang.Object r2 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r3.getEmpty()
            if (r2 != r4) goto L_0x00b4
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1 r2 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1
            r2.<init>()
            r10.updateRememberedValue(r2)
        L_0x00b4:
            r10.endReplaceableGroup()
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1 r2 = (androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$noOpConnection$1$1) r2
            r10.startReplaceableGroup(r0)
            java.lang.Object r4 = r10.rememberedValue()
            java.lang.Object r5 = r3.getEmpty()
            if (r4 != r5) goto L_0x00ce
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r4 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
            r4.<init>()
            r10.updateRememberedValue(r4)
        L_0x00ce:
            r10.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r4 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r4
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll(r5, r2, r4)
            androidx.compose.ui.Modifier r2 = r11.then(r2)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$modifierWithSemantics$1 r5 = androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$modifierWithSemantics$1.INSTANCE
            r6 = 1
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics(r2, r6, r5)
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.ComposedModifierKt.materialize(r10, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r2 = r10.consume(r2)
            r14 = r2
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r2 = r10.consume(r2)
            r15 = r2
            androidx.compose.ui.unit.LayoutDirection r15 = (androidx.compose.ui.unit.LayoutDirection) r15
            r2 = 0
            androidx.compose.runtime.CompositionContext r5 = androidx.compose.runtime.ComposablesKt.rememberCompositionContext(r10, r2)
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.runtime.saveable.SaveableStateRegistryKt.getLocalSaveableStateRegistry()
            java.lang.Object r6 = r10.consume(r6)
            r7 = r6
            androidx.compose.runtime.saveable.SaveableStateRegistry r7 = (androidx.compose.runtime.saveable.SaveableStateRegistry) r7
            int r2 = androidx.compose.runtime.ComposablesKt.getCurrentCompositeKeyHash(r10, r2)
            java.lang.String r6 = java.lang.String.valueOf(r2)
            r10.startReplaceableGroup(r0)
            java.lang.Object r0 = r10.rememberedValue()
            java.lang.Object r2 = r3.getEmpty()
            if (r0 != r2) goto L_0x012b
            androidx.compose.ui.node.Ref r0 = new androidx.compose.ui.node.Ref
            r0.<init>()
            r10.updateRememberedValue(r0)
        L_0x012b:
            r10.endReplaceableGroup()
            r3 = r0
            androidx.compose.ui.node.Ref r3 = (androidx.compose.ui.node.Ref) r3
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            java.lang.Object r0 = r10.consume(r0)
            r2 = r0
            androidx.lifecycle.LifecycleOwner r2 = (androidx.lifecycle.LifecycleOwner) r2
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner()
            java.lang.Object r0 = r10.consume(r0)
            androidx.savedstate.SavedStateRegistryOwner r0 = (androidx.savedstate.SavedStateRegistryOwner) r0
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1 r8 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1
            r9 = r0
            r0 = r8
            r18 = r11
            r11 = r2
            r2 = r5
            r5 = r3
            r3 = r4
            r4 = r17
            r19 = r5
            r5 = r7
            r20 = r6
            r16 = r7
            r7 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = 1886828752(0x7076b8d0, float:3.0542695E29)
            r10.startReplaceableGroup(r0)
            androidx.compose.runtime.Applier r0 = r10.getApplier()
            boolean r0 = r0 instanceof androidx.compose.ui.node.UiApplier
            if (r0 != 0) goto L_0x016f
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x016f:
            r10.startNode()
            boolean r0 = r10.getInserting()
            if (r0 == 0) goto L_0x0181
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1 r0 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$$inlined$ComposeNode$1
            r0.<init>(r8)
            r10.createNode(r0)
            goto L_0x0184
        L_0x0181:
            r10.useNode()
        L_0x0184:
            androidx.compose.runtime.Composer r0 = androidx.compose.runtime.Updater.m2536constructorimpl(r10)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$1
            r2 = r19
            r1.<init>(r2)
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r13, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$2
            r1.<init>(r2)
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r14, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$3
            r1.<init>(r2)
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r11, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$4 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$4
            r1.<init>(r2)
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r9, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$5 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$5
            r1.<init>(r2)
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r12, r1)
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$6 r1 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$2$6
            r1.<init>(r2)
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r0, r15, r1)
            r10.endNode()
            r10.endReplaceableGroup()
            r6 = r16
            if (r6 == 0) goto L_0x01d0
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3 r0 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$3
            r1 = r20
            r0.<init>(r6, r1, r2)
            r2 = 8
            androidx.compose.runtime.EffectsKt.DisposableEffect(r6, r1, r0, r10, r2)
        L_0x01d0:
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01d9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01d9:
            r2 = r18
            r3 = r12
        L_0x01dc:
            androidx.compose.runtime.ScopeUpdateScope r6 = r10.endRestartGroup()
            if (r6 != 0) goto L_0x01e3
            goto L_0x01f2
        L_0x01e3:
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4 r7 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$4
            r0 = r7
            r1 = r17
            r4 = r21
            r5 = r22
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x01f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    @NotNull
    public static final Function1<View, Unit> getNoOpUpdate() {
        return NoOpUpdate;
    }
}
