package com.designsystem.ds_empty_state_v2;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class EmptyStateComposablesKt$EmptyState$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f31164g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f31165h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31166i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EmptyStateIcon f31167j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f31168k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31169l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f31170m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f31171n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f31172o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmptyStateComposablesKt$EmptyState$2(String str, Modifier modifier, String str2, EmptyStateIcon emptyStateIcon, String str3, Function0<Unit> function0, boolean z11, int i11, int i12) {
        super(2);
        this.f31164g = str;
        this.f31165h = modifier;
        this.f31166i = str2;
        this.f31167j = emptyStateIcon;
        this.f31168k = str3;
        this.f31169l = function0;
        this.f31170m = z11;
        this.f31171n = i11;
        this.f31172o = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        EmptyStateComposablesKt.EmptyState(this.f31164g, this.f31165h, this.f31166i, this.f31167j, this.f31168k, this.f31169l, this.f31170m, composer, this.f31171n | 1, this.f31172o);
    }
}
