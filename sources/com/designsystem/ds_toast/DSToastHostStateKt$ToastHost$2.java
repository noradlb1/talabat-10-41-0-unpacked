package com.designsystem.ds_toast;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.designsystem.ds_toast.DSToastHostState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSToastHostStateKt$ToastHost$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSToastHostState f33206g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f33207h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<DSToastHostState.ToastData, Composer, Integer, Unit> f33208i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f33209j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f33210k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSToastHostStateKt$ToastHost$2(DSToastHostState dSToastHostState, Modifier modifier, Function3<? super DSToastHostState.ToastData, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f33206g = dSToastHostState;
        this.f33207h = modifier;
        this.f33208i = function3;
        this.f33209j = i11;
        this.f33210k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSToastHostStateKt.ToastHost(this.f33206g, this.f33207h, this.f33208i, composer, this.f33209j | 1, this.f33210k);
    }
}
