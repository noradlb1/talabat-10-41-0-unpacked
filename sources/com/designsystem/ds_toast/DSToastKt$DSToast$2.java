package com.designsystem.ds_toast;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSToastKt$DSToast$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSToastHostState f33241g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f33242h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f33243i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f33244j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f33245k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSToastKt$DSToast$2(DSToastHostState dSToastHostState, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f33241g = dSToastHostState;
        this.f33242h = modifier;
        this.f33243i = function2;
        this.f33244j = i11;
        this.f33245k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSToastKt.DSToast(this.f33241g, this.f33242h, this.f33243i, composer, this.f33244j | 1, this.f33245k);
    }
}
