package com.designsystem.ds_image;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import coil.request.ImageRequest;
import com.skydoves.landscapist.coil.CoilImageState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class RatioImageComposablesKt$CrossfadedRatioImage$5 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageRequest f31323g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ContentScale f31324h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Modifier f31325i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Loading, Composer, Integer, Unit> f31326j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Success, Composer, Integer, Unit> f31327k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Failure, Composer, Integer, Unit> f31328l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f31329m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f31330n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatioImageComposablesKt$CrossfadedRatioImage$5(ImageRequest imageRequest, ContentScale contentScale, Modifier modifier, Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit> function3, Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function32, Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function33, int i11, int i12) {
        super(2);
        this.f31323g = imageRequest;
        this.f31324h = contentScale;
        this.f31325i = modifier;
        this.f31326j = function3;
        this.f31327k = function32;
        this.f31328l = function33;
        this.f31329m = i11;
        this.f31330n = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        RatioImageComposablesKt.CrossfadedRatioImage(this.f31323g, this.f31324h, this.f31325i, this.f31326j, this.f31327k, this.f31328l, composer, this.f31329m | 1, this.f31330n);
    }
}
