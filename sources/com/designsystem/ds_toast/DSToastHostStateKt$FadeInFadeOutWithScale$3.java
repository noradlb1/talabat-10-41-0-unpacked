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
public final class DSToastHostStateKt$FadeInFadeOutWithScale$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSToastHostState.ToastData f33199g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f33200h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<DSToastHostState.ToastData, Composer, Integer, Unit> f33201i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f33202j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f33203k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSToastHostStateKt$FadeInFadeOutWithScale$3(DSToastHostState.ToastData toastData, Modifier modifier, Function3<? super DSToastHostState.ToastData, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f33199g = toastData;
        this.f33200h = modifier;
        this.f33201i = function3;
        this.f33202j = i11;
        this.f33203k = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        DSToastHostStateKt.FadeInFadeOutWithScale(this.f33199g, this.f33200h, this.f33201i, composer, this.f33202j | 1, this.f33203k);
    }
}
