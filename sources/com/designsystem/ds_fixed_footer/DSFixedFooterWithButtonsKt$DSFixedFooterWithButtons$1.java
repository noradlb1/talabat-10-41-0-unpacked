package com.designsystem.ds_fixed_footer;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSFixedFooterWithButtonsKt$DSFixedFooterWithButtons$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<Function2<Composer, Integer, Unit>> f31207g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function3<List<? extends Function2<? super Composer, ? super Integer, Unit>>, Composer, Integer, Unit> f31208h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31209i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSFixedFooterWithButtonsKt$DSFixedFooterWithButtons$1(List<? extends Function2<? super Composer, ? super Integer, Unit>> list, Function3<? super List<? extends Function2<? super Composer, ? super Integer, Unit>>, ? super Composer, ? super Integer, Unit> function3, int i11) {
        super(2);
        this.f31207g = list;
        this.f31208h = function3;
        this.f31209i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            int size = this.f31207g.size();
            this.f31208h.invoke(this.f31207g, composer, Integer.valueOf(((this.f31209i >> 9) & 112) | 8));
            return;
        }
        composer.skipToGroupEnd();
    }
}
