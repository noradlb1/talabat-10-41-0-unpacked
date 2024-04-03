package com.designsystem.ds_chip;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSMultiSelectionChipKt$DSMultiSelectionChip$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f30933g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f30934h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30935i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f30936j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Integer f30937k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f30938l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Integer f30939m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSMultiSelectionChipKt$DSMultiSelectionChip$2(Modifier modifier, int i11, Function0<Unit> function0, int i12, Integer num, String str, Integer num2) {
        super(2);
        this.f30933g = modifier;
        this.f30934h = i11;
        this.f30935i = function0;
        this.f30936j = i12;
        this.f30937k = num;
        this.f30938l = str;
        this.f30939m = num2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f30933g;
            final int i12 = this.f30934h;
            boolean z11 = i12 > 0;
            Function0<Unit> function0 = this.f30935i;
            final Integer num = this.f30937k;
            final int i13 = this.f30936j;
            final String str = this.f30938l;
            final Integer num2 = this.f30939m;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -819892348, true, new Function3<RowScope, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer, int i11) {
                    Intrinsics.checkNotNullParameter(rowScope, "$this$ChipSurface");
                    if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
                        boolean z11 = true;
                        ChipComposablesKt.ChipLeadingIcon(num, i12 > 0, composer, (i13 >> 6) & 14);
                        ChipComposablesKt.ChipText(str, i12 > 0, composer, i13 & 14);
                        if (i12 > 0) {
                            composer.startReplaceableGroup(-1588355142);
                            ChipComposablesKt.ChipCounter(i12, composer, (i13 >> 12) & 14);
                            composer.endReplaceableGroup();
                            return;
                        }
                        composer.startReplaceableGroup(-1588355078);
                        Integer num = num2;
                        if (i12 <= 0) {
                            z11 = false;
                        }
                        ChipComposablesKt.ChipTrailingIcon(num, z11, composer, (i13 >> 9) & 14);
                        composer.endReplaceableGroup();
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            int i14 = this.f30936j;
            ChipComposablesKt.ChipSurface(modifier, z11, function0, composableLambda, composer, ((i14 >> 3) & 14) | KfsConstant.KFS_RSA_KEY_LEN_3072 | ((i14 >> 9) & 896), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
