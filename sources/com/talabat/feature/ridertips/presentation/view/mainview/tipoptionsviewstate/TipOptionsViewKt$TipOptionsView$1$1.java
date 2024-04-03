package com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.talabat.feature.ridertips.presentation.displaymodel.TipOptionsDetailsDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class TipOptionsViewKt$TipOptionsView$1$1 extends Lambda implements Function1<LazyListScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TipOptionsDetailsDisplayModel f58863g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f58864h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Integer, Boolean, Unit> f58865i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TipOptionsViewKt$TipOptionsView$1$1(TipOptionsDetailsDisplayModel tipOptionsDetailsDisplayModel, boolean z11, Function2<? super Integer, ? super Boolean, Unit> function2) {
        super(1);
        this.f58863g = tipOptionsDetailsDisplayModel;
        this.f58864h = z11;
        this.f58865i = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LazyListScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull LazyListScope lazyListScope) {
        Intrinsics.checkNotNullParameter(lazyListScope, "$this$LazyRow");
        LazyListScope.CC.i(lazyListScope, (Object) null, (Object) null, ComposableSingletons$TipOptionsViewKt.INSTANCE.m10292getLambda1$com_talabat_feature_ridertips_presentation_presentation(), 3, (Object) null);
        int size = this.f58863g.getTipOptions().size();
        final TipOptionsDetailsDisplayModel tipOptionsDetailsDisplayModel = this.f58863g;
        final boolean z11 = this.f58864h;
        final Function2<Integer, Boolean, Unit> function2 = this.f58865i;
        LazyListScope.CC.k(lazyListScope, size, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(1625838965, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: kotlin.jvm.functions.Function0} */
            /* JADX WARNING: Multi-variable type inference failed */
            @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
            @androidx.compose.runtime.Composable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(@org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.LazyItemScope r17, int r18, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r19, int r20) {
                /*
                    r16 = this;
                    r0 = r16
                    r1 = r18
                    r10 = r19
                    java.lang.String r2 = "$this$items"
                    r3 = r17
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
                    r2 = r20 & 112(0x70, float:1.57E-43)
                    if (r2 != 0) goto L_0x001f
                    boolean r2 = r10.changed((int) r1)
                    if (r2 == 0) goto L_0x001a
                    r2 = 32
                    goto L_0x001c
                L_0x001a:
                    r2 = 16
                L_0x001c:
                    r2 = r20 | r2
                    goto L_0x0021
                L_0x001f:
                    r2 = r20
                L_0x0021:
                    r2 = r2 & 721(0x2d1, float:1.01E-42)
                    r3 = 144(0x90, float:2.02E-43)
                    if (r2 != r3) goto L_0x0033
                    boolean r2 = r19.getSkipping()
                    if (r2 != 0) goto L_0x002e
                    goto L_0x0033
                L_0x002e:
                    r19.skipToGroupEnd()
                    goto L_0x00d6
                L_0x0033:
                    com.talabat.feature.ridertips.presentation.displaymodel.TipOptionsDetailsDisplayModel r2 = r1
                    java.util.List r2 = r2.getTipOptions()
                    java.lang.Object r2 = r2.get(r1)
                    com.talabat.feature.ridertips.presentation.displaymodel.TipOptionDisplayModel r2 = (com.talabat.feature.ridertips.presentation.displaymodel.TipOptionDisplayModel) r2
                    androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
                    r4 = 94
                    float r4 = (float) r4
                    float r4 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r4)
                    r5 = 0
                    r6 = 2
                    r7 = 0
                    androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m543defaultMinSizeVpY3zN4$default(r3, r4, r5, r6, r7)
                    java.lang.String r4 = r2.getDisplayTipValue()
                    boolean r5 = r2.getSelected()
                    boolean r8 = r2.isCustomTip()
                    if (r8 == 0) goto L_0x0063
                    int r7 = com.talabat.feature.ridertips.presentation.R.drawable.edit_tip
                    java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                L_0x0063:
                    r8 = 0
                    r9 = 4
                    java.lang.Object[] r11 = new java.lang.Object[r9]
                    boolean r12 = r5
                    java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
                    r13 = 0
                    r11[r13] = r12
                    kotlin.jvm.functions.Function2<java.lang.Integer, java.lang.Boolean, kotlin.Unit> r12 = r6
                    r14 = 1
                    r11[r14] = r12
                    java.lang.Integer r12 = java.lang.Integer.valueOf(r18)
                    r11[r6] = r12
                    r6 = 3
                    r11[r6] = r2
                    boolean r6 = r5
                    kotlin.jvm.functions.Function2<java.lang.Integer, java.lang.Boolean, kotlin.Unit> r12 = r6
                    r14 = -568225417(0xffffffffde219177, float:-2.91055434E18)
                    r10.startReplaceableGroup(r14)
                    r14 = r13
                    r15 = r14
                L_0x008a:
                    if (r14 >= r9) goto L_0x0097
                    r9 = r11[r14]
                    boolean r9 = r10.changed((java.lang.Object) r9)
                    r15 = r15 | r9
                    int r14 = r14 + 1
                    r9 = 4
                    goto L_0x008a
                L_0x0097:
                    java.lang.Object r9 = r19.rememberedValue()
                    if (r15 != 0) goto L_0x00a5
                    androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
                    java.lang.Object r11 = r11.getEmpty()
                    if (r9 != r11) goto L_0x00ad
                L_0x00a5:
                    com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$1$1$1$1$1 r9 = new com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$1$1$1$1$1
                    r9.<init>(r6, r12, r1, r2)
                    r10.updateRememberedValue(r9)
                L_0x00ad:
                    r19.endReplaceableGroup()
                    r6 = r9
                    kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
                    r9 = 48
                    r11 = 4
                    r1 = r4
                    r2 = r3
                    r3 = r8
                    r4 = r7
                    r7 = r19
                    r8 = r9
                    r9 = r11
                    com.designsystem.ds_chip.DSSingleSelectionChipKt.DSSingleSelectionChip(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                    androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
                    com.designsystem.ds_theme.DSTheme r2 = com.designsystem.ds_theme.DSTheme.INSTANCE
                    r3 = 8
                    com.designsystem.ds_theme.DSDimens r2 = r2.getDimens(r10, r3)
                    float r2 = r2.m8842getDsSD9Ej5fM()
                    androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m563width3ABfNKs(r1, r2)
                    androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r10, r13)
                L_0x00d6:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.ridertips.presentation.view.mainview.tipoptionsviewstate.TipOptionsViewKt$TipOptionsView$1$1.AnonymousClass1.invoke(androidx.compose.foundation.lazy.LazyItemScope, int, androidx.compose.runtime.Composer, int):void");
            }
        }), 6, (Object) null);
    }
}
