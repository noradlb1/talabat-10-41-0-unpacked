package com.designsystem.ds_list_item_v2;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSDivider$Content$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSDivider f31975g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31976h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSDivider$Content$1(DSDivider dSDivider, int i11) {
        super(2);
        this.f31975g = dSDivider;
        this.f31976h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f31975g.Content(composer, this.f31976h | 1);
    }
}
