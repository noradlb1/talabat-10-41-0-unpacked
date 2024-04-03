package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ListItemComposablesKt$ListItem$1$1$2$1$2$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<Boolean, Composer, Integer, Unit> f32223g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32224h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f32225i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListItemComposablesKt$ListItem$1$1$2$1$2$1$1(Function3<? super Boolean, ? super Composer, ? super Integer, Unit> function3, boolean z11, int i11) {
        super(2);
        this.f32223g = function3;
        this.f32224h = z11;
        this.f32225i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Function3<Boolean, Composer, Integer, Unit> function3 = this.f32223g;
            Boolean valueOf = Boolean.valueOf(this.f32224h);
            int i12 = this.f32225i;
            function3.invoke(valueOf, composer, Integer.valueOf(((i12 << 3) & 112) | ((i12 >> 3) & 14)));
            return;
        }
        composer.skipToGroupEnd();
    }
}
