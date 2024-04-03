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
public final class DSEmptyStateWithIconKt$DSEmptyStateWithIcon$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f31128g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31129h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f31130i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f31131j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f31132k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f31133l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f31134m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f31135n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f31136o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSEmptyStateWithIconKt$DSEmptyStateWithIcon$1(String str, int i11, Modifier modifier, String str2, long j11, String str3, Function0<Unit> function0, int i12, int i13) {
        super(2);
        this.f31128g = str;
        this.f31129h = i11;
        this.f31130i = modifier;
        this.f31131j = str2;
        this.f31132k = j11;
        this.f31133l = str3;
        this.f31134m = function0;
        this.f31135n = i12;
        this.f31136o = i13;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSEmptyStateWithIconKt.m8334DSEmptyStateWithIcon3f6hBDE(this.f31128g, this.f31129h, this.f31130i, this.f31131j, this.f31132k, this.f31133l, this.f31134m, composer, this.f31135n | 1, this.f31136o);
    }
}
