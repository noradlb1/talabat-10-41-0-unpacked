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
public final class DSEmptyStateKt$DSEmptyState$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f31119g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f31120h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f31121i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31122j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31123k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f31124l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f31125m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSEmptyStateKt$DSEmptyState$1(String str, Modifier modifier, String str2, String str3, Function0<Unit> function0, int i11, int i12) {
        super(2);
        this.f31119g = str;
        this.f31120h = modifier;
        this.f31121i = str2;
        this.f31122j = str3;
        this.f31123k = function0;
        this.f31124l = i11;
        this.f31125m = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSEmptyStateKt.DSEmptyState(this.f31119g, this.f31120h, this.f31121i, this.f31122j, this.f31123k, composer, this.f31124l | 1, this.f31125m);
    }
}
