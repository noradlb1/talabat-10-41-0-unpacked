package com.designsystem.ds_bottom_navigation_bar;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class BottomNavigationBarComposablesKt$DynamicNavigationBarIcon$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f30544g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f30545h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f30546i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BottomNavigationBarComposablesKt$DynamicNavigationBarIcon$2(int i11, boolean z11, int i12) {
        super(2);
        this.f30544g = i11;
        this.f30545h = z11;
        this.f30546i = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        BottomNavigationBarComposablesKt.DynamicNavigationBarIcon(this.f30544g, this.f30545h, composer, this.f30546i | 1);
    }
}
