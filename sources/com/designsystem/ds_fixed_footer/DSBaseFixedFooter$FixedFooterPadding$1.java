package com.designsystem.ds_fixed_footer;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSBaseFixedFooter$FixedFooterPadding$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSBaseFixedFooter f31182g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f31183h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f31184i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSBaseFixedFooter$FixedFooterPadding$1(DSBaseFixedFooter dSBaseFixedFooter, boolean z11, int i11) {
        super(2);
        this.f31182g = dSBaseFixedFooter;
        this.f31183h = z11;
        this.f31184i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        this.f31182g.FixedFooterPadding$marshmallow_release(this.f31183h, composer, this.f31184i | 1);
    }
}
