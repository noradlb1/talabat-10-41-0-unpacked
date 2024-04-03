package com.designsystem.ds_radio_button;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSRadioButtonKt$DSRadioButton$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32552g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f32553h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32554i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32555j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f32556k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f32557l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSRadioButtonKt$DSRadioButton$2(Modifier modifier, boolean z11, boolean z12, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f32552g = modifier;
        this.f32553h = z11;
        this.f32554i = z12;
        this.f32555j = function0;
        this.f32556k = i11;
        this.f32557l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSRadioButtonKt.DSRadioButton(this.f32552g, this.f32553h, this.f32554i, this.f32555j, composer, this.f32556k | 1, this.f32557l);
    }
}
