package androidx.compose.ui.input.nestedscroll;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class NestedScrollModifierKt$nestedScroll$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ NestedScrollDispatcher f9759g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ NestedScrollConnection f9760h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedScrollModifierKt$nestedScroll$2(NestedScrollDispatcher nestedScrollDispatcher, NestedScrollConnection nestedScrollConnection) {
        super(3);
        this.f9759g = nestedScrollDispatcher;
        this.f9760h = nestedScrollConnection;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r5, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r6, int r7) {
        /*
            r4 = this;
            java.lang.String r0 = "$this$composed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r5 = 410346167(0x187562b7, float:3.1715346E-24)
            r6.startReplaceableGroup(r5)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0017
            r0 = -1
            java.lang.String r1 = "androidx.compose.ui.input.nestedscroll.nestedScroll.<anonymous> (NestedScrollModifier.kt:335)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r7, r0, r1)
        L_0x0017:
            r5 = 773894976(0x2e20b340, float:3.6538994E-11)
            r6.startReplaceableGroup(r5)
            r5 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r6.startReplaceableGroup(r5)
            java.lang.Object r7 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r0.getEmpty()
            if (r7 != r1) goto L_0x003e
            kotlin.coroutines.EmptyCoroutineContext r7 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r7 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r7, r6)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r7)
            r6.updateRememberedValue(r1)
            r7 = r1
        L_0x003e:
            r6.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r7 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r7
            kotlinx.coroutines.CoroutineScope r7 = r7.getCoroutineScope()
            r6.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r1 = r4.f9759g
            r2 = 100475956(0x5fd2434, float:2.3805305E-35)
            r6.startReplaceableGroup(r2)
            if (r1 != 0) goto L_0x006f
            r6.startReplaceableGroup(r5)
            java.lang.Object r5 = r6.rememberedValue()
            java.lang.Object r1 = r0.getEmpty()
            if (r5 != r1) goto L_0x0069
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r5 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher
            r5.<init>()
            r6.updateRememberedValue(r5)
        L_0x0069:
            r6.endReplaceableGroup()
            r1 = r5
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r1 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r1
        L_0x006f:
            r6.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r5 = r4.f9760h
            r2 = 1618982084(0x607fb4c4, float:7.370227E19)
            r6.startReplaceableGroup(r2)
            boolean r2 = r6.changed((java.lang.Object) r5)
            boolean r3 = r6.changed((java.lang.Object) r1)
            r2 = r2 | r3
            boolean r3 = r6.changed((java.lang.Object) r7)
            r2 = r2 | r3
            java.lang.Object r3 = r6.rememberedValue()
            if (r2 != 0) goto L_0x0094
            java.lang.Object r0 = r0.getEmpty()
            if (r3 != r0) goto L_0x009f
        L_0x0094:
            r1.setOriginNestedScrollScope$ui_release(r7)
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal r3 = new androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal
            r3.<init>(r1, r5)
            r6.updateRememberedValue(r3)
        L_0x009f:
            r6.endReplaceableGroup()
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal r3 = (androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal) r3
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x00ad
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00ad:
            r6.endReplaceableGroup()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt$nestedScroll$2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
