package androidx.compose.material3;

import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f7021g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Unit> f7022h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f7023i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FocusRequester f7024j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Ref<LayoutCoordinates> f7025k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ View f7026l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f7027m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f7028n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f7029o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2(boolean z11, Function1<? super Boolean, Unit> function1, int i11, FocusRequester focusRequester, Ref<LayoutCoordinates> ref, View view, int i12, MutableState<Integer> mutableState, MutableState<Integer> mutableState2) {
        super(3);
        this.f7021g = z11;
        this.f7022h = function1;
        this.f7023i = i11;
        this.f7024j = focusRequester;
        this.f7025k = ref;
        this.f7026l = view;
        this.f7027m = i12;
        this.f7028n = mutableState;
        this.f7029o = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.Modifier invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r18, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r10 = r19
            java.lang.String r2 = "$this$composed"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = 1714866713(0x6636ca19, float:2.1579969E23)
            r10.startReplaceableGroup(r2)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x001f
            r3 = -1
            java.lang.String r4 = "androidx.compose.material3.ExposedDropdownMenuBox.<anonymous>.<no name provided>.menuAnchor.<anonymous> (ExposedDropdownMenu.kt:120)"
            r5 = r20
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r5, r3, r4)
        L_0x001f:
            androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2$1 r2 = new androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2$1
            androidx.compose.ui.node.Ref<androidx.compose.ui.layout.LayoutCoordinates> r12 = r0.f7025k
            android.view.View r13 = r0.f7026l
            int r14 = r0.f7027m
            androidx.compose.runtime.MutableState<java.lang.Integer> r15 = r0.f7028n
            androidx.compose.runtime.MutableState<java.lang.Integer> r3 = r0.f7029o
            r11 = r2
            r16 = r3
            r11.<init>(r12, r13, r14, r15, r16)
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.layout.OnGloballyPositionedModifierKt.onGloballyPositioned(r1, r2)
            boolean r2 = r0.f7021g
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r3 = r0.f7022h
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r5 = r0.f7022h
            boolean r6 = r0.f7021g
            r7 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10.startReplaceableGroup(r7)
            boolean r3 = r10.changed((java.lang.Object) r3)
            boolean r4 = r10.changed((java.lang.Object) r4)
            r3 = r3 | r4
            java.lang.Object r4 = r19.rememberedValue()
            if (r3 != 0) goto L_0x005e
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x0066
        L_0x005e:
            androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2$2$1 r4 = new androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2$2$1
            r4.<init>(r5, r6)
            r10.updateRememberedValue(r4)
        L_0x0066:
            r19.endReplaceableGroup()
            r3 = r4
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r4 = 0
            r5 = 0
            r6 = 0
            int r7 = r0.f7023i
            int r7 = r7 << 3
            r8 = r7 & 112(0x70, float:1.57E-43)
            r9 = 28
            r7 = r19
            androidx.compose.ui.Modifier r1 = androidx.compose.material3.ExposedDropdownMenuKt.expandable(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            androidx.compose.ui.focus.FocusRequester r2 = r0.f7024j
            androidx.compose.ui.Modifier r1 = androidx.compose.ui.focus.FocusRequesterModifierKt.focusRequester(r1, r2)
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x008c
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x008c:
            r19.endReplaceableGroup()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ExposedDropdownMenuKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2.invoke(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int):androidx.compose.ui.Modifier");
    }
}
