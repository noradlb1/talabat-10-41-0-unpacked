package com.designsystem.ds_tag_v2;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSTag2$Content$5 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSTag2 f33069g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f33070h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSTag2$Content$5(DSTag2 dSTag2, int i11) {
        super(2);
        this.f33069g = dSTag2;
        this.f33070h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f33069g.Content(composer, this.f33070h | 1);
    }
}
