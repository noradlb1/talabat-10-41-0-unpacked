package com.designsystem.ds_branded_button.composables;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_branded_button.DSBrandedButtonStyle;
import com.designsystem.ds_button_v2.DSButtonTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSBrandedButtonContentKt$DSBrandedButtonContent$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSButtonTheme f30678g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f30679h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f30680i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Integer f30681j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f30682k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f30683l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f30684m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f30685n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ DSBrandedButtonStyle f30686o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f30687p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f30688q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSBrandedButtonContentKt$DSBrandedButtonContent$2(DSButtonTheme dSButtonTheme, String str, Modifier modifier, Integer num, boolean z11, boolean z12, boolean z13, MutableInteractionSource mutableInteractionSource, DSBrandedButtonStyle dSBrandedButtonStyle, Function0<Unit> function0, int i11) {
        super(2);
        this.f30678g = dSButtonTheme;
        this.f30679h = str;
        this.f30680i = modifier;
        this.f30681j = num;
        this.f30682k = z11;
        this.f30683l = z12;
        this.f30684m = z13;
        this.f30685n = mutableInteractionSource;
        this.f30686o = dSBrandedButtonStyle;
        this.f30687p = function0;
        this.f30688q = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSBrandedButtonContentKt.DSBrandedButtonContent(this.f30678g, this.f30679h, this.f30680i, this.f30681j, this.f30682k, this.f30683l, this.f30684m, this.f30685n, this.f30686o, this.f30687p, composer, this.f30688q | 1);
    }
}
