package com.designsystem.ds_toast;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import com.designsystem.ds_toast.DSToastHostState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSToastHostStateKt$FadeInFadeOutWithScale$2$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<DSToastHostState.ToastData, Composer, Integer, Unit> f33196g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DSToastHostState.ToastData f33197h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f33198i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSToastHostStateKt$FadeInFadeOutWithScale$2$1$1(Function3<? super DSToastHostState.ToastData, ? super Composer, ? super Integer, Unit> function3, DSToastHostState.ToastData toastData, int i11) {
        super(2);
        this.f33196g = function3;
        this.f33197h = toastData;
        this.f33198i = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Function3<DSToastHostState.ToastData, Composer, Integer, Unit> function3 = this.f33196g;
            DSToastHostState.ToastData toastData = this.f33197h;
            Intrinsics.checkNotNull(toastData);
            function3.invoke(toastData, composer, Integer.valueOf((this.f33198i >> 3) & 112));
            return;
        }
        composer.skipToGroupEnd();
    }
}
