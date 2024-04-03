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
public final class DSSingleSelectionChipKt$DSSingleSelectionChip$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f30955g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30956h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30957i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f30958j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Integer f30959k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f30960l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Integer f30961m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSSingleSelectionChipKt$DSSingleSelectionChip$2(Modifier modifier, boolean z11, Function0<Unit> function0, int i11, Integer num, String str, Integer num2) {
        super(2);
        this.f30955g = modifier;
        this.f30956h = z11;
        this.f30957i = function0;
        this.f30958j = i11;
        this.f30959k = num;
        this.f30960l = str;
        this.f30961m = num2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f30955g;
            boolean z11 = this.f30956h;
            Function0<Unit> function0 = this.f30957i;
            final Integer num = this.f30959k;
            final int i12 = this.f30958j;
            final String str = this.f30960l;
            final Integer num2 = this.f30961m;
            final boolean z12 = z11;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -819892573, true, new Function3<RowScope, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@NotNull RowScope rowScope, @Nullable Composer composer, int i11) {
                    Intrinsics.checkNotNullParameter(rowScope, "$this$ChipSurface");
                    if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
                        Integer num = num;
                        boolean z11 = z12;
                        int i12 = i12;
                        ChipComposablesKt.ChipLeadingIcon(num, z11, composer, ((i12 >> 9) & 112) | ((i12 >> 6) & 14));
                        String str = str;
                        boolean z12 = z12;
                        int i13 = i12;
                        ChipComposablesKt.ChipText(str, z12, composer, ((i13 >> 9) & 112) | (i13 & 14));
                        Integer num2 = num2;
                        boolean z13 = z12;
                        int i14 = i12;
                        ChipComposablesKt.ChipTrailingIcon(num2, z13, composer, ((i14 >> 9) & 112) | ((i14 >> 9) & 14));
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            int i13 = this.f30958j;
            ChipComposablesKt.ChipSurface(modifier, z11, function0, composableLambda, composer, ((i13 >> 3) & 14) | KfsConstant.KFS_RSA_KEY_LEN_3072 | ((i13 >> 9) & 112) | ((i13 >> 9) & 896), 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
