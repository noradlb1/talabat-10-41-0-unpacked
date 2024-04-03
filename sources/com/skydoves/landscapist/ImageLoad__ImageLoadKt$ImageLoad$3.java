package com.skydoves.landscapist;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ImageLoad__ImageLoadKt$ImageLoad$3 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ T f52953g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super Flow<? extends ImageLoadState>>, Object> f52954h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f52955i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<ImageLoadState, Composer, Integer, Unit> f52956j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f52957k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f52958l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageLoad__ImageLoadKt$ImageLoad$3(T t11, Function1<? super Continuation<? super Flow<? extends ImageLoadState>>, ? extends Object> function1, Modifier modifier, Function3<? super ImageLoadState, ? super Composer, ? super Integer, Unit> function3, int i11, int i12) {
        super(2);
        this.f52953g = t11;
        this.f52954h = function1;
        this.f52955i = modifier;
        this.f52956j = function3;
        this.f52957k = i11;
        this.f52958l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        ImageLoad.ImageLoad(this.f52953g, this.f52954h, this.f52955i, this.f52956j, composer, this.f52957k | 1, this.f52958l);
    }
}
