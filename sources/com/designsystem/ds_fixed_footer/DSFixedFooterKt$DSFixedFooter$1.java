package com.designsystem.ds_fixed_footer;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSFixedFooterKt$DSFixedFooter$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f31191g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31192h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31193i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f31194j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f31195k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSFixedFooterKt$DSFixedFooter$1(Modifier modifier, boolean z11, Function2<? super Composer, ? super Integer, Unit> function2, int i11, Function2<? super Composer, ? super Integer, Unit> function22) {
        super(2);
        this.f31191g = modifier;
        this.f31192h = z11;
        this.f31193i = function2;
        this.f31194j = i11;
        this.f31195k = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f31191g;
            boolean z11 = this.f31192h;
            final Function2<Composer, Integer, Unit> function2 = this.f31193i;
            boolean z12 = function2 != null;
            final int i12 = this.f31194j;
            final Function2<Composer, Integer, Unit> function22 = this.f31195k;
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -819895918, true, new Function3<ColumnScope, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((ColumnScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@NotNull ColumnScope columnScope, @Nullable Composer composer, int i11) {
                    Intrinsics.checkNotNullParameter(columnScope, "$this$FixedFooterCard");
                    if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
                        FixedFooterComposablesKt.FixedFooterTopContent(function2, composer, (i12 >> 6) & 14);
                        function22.invoke(composer, Integer.valueOf((i12 >> 9) & 14));
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            });
            int i13 = this.f31194j;
            FixedFooterComposablesKt.FixedFooterCard(modifier, z11, z12, composableLambda, composer, (i13 & 14) | KfsConstant.KFS_RSA_KEY_LEN_3072 | (i13 & 112));
            return;
        }
        composer.skipToGroupEnd();
    }
}
