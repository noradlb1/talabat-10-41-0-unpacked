package com.designsystem.ds_bottom_navigation_bar;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class BottomNavigationBarComposablesKt$FixedFontScaleText$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f30547g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TextStyle f30548h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f30549i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationBarComposablesKt$FixedFontScaleText$1(String str, TextStyle textStyle, int i11) {
        super(2);
        this.f30547g = str;
        this.f30548h = textStyle;
        this.f30549i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BottomNavigationBarComposablesKt.FixedFontScaleText(this.f30547g, this.f30548h, composer, this.f30549i | 1);
    }
}
