package com.designsystem.ds_fixed_footer;

import androidx.compose.runtime.Composer;
import com.designsystem.ds_button_v2.DSBaseButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSFixedFooterWithButtons$toComposable$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSBaseButton f31205g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSFixedFooterWithButtons$toComposable$1$1(DSBaseButton dSBaseButton) {
        super(2);
        this.f31205g = dSBaseButton;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(@org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r9, int r10) {
        /*
            r8 = this;
            r10 = r10 & 11
            r10 = r10 ^ 2
            if (r10 != 0) goto L_0x0011
            boolean r10 = r9.getSkipping()
            if (r10 != 0) goto L_0x000d
            goto L_0x0011
        L_0x000d:
            r9.skipToGroupEnd()
            goto L_0x0041
        L_0x0011:
            com.designsystem.ds_button_v2.DSBaseButton r10 = r8.f31205g
            r0 = -3686930(0xffffffffffc7bdee, float:NaN)
            r9.startReplaceableGroup(r0)
            boolean r0 = r9.changed((java.lang.Object) r10)
            java.lang.Object r1 = r9.rememberedValue()
            if (r0 != 0) goto L_0x002b
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x0033
        L_0x002b:
            com.designsystem.ds_fixed_footer.DSFixedFooterWithButtons$toComposable$1$1$1$1 r1 = new com.designsystem.ds_fixed_footer.DSFixedFooterWithButtons$toComposable$1$1$1$1
            r1.<init>(r10)
            r9.updateRememberedValue(r1)
        L_0x0033:
            r9.endReplaceableGroup()
            r2 = r1
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r3 = 0
            r4 = 0
            r6 = 0
            r7 = 6
            r5 = r9
            androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(r2, r3, r4, r5, r6, r7)
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_fixed_footer.DSFixedFooterWithButtons$toComposable$1$1.invoke(androidx.compose.runtime.Composer, int):void");
    }
}
