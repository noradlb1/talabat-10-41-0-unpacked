package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class CommonListItemComposablesKt$ListItemBackground$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f32156g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32157h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonListItemComposablesKt$ListItemBackground$1(Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f32156g = function2;
        this.f32157h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            this.f32156g.invoke(composer, Integer.valueOf((this.f32157h >> 3) & 14));
        } else {
            composer.skipToGroupEnd();
        }
    }
}
