package com.designsystem.ds_image;

import android.graphics.drawable.Drawable;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import com.skydoves.landscapist.coil.CoilImageState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class RatioImageComposablesKt$CrossfadedRatioImage$4 extends Lambda implements Function3<CoilImageState, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Loading, Composer, Integer, Unit> f31317g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f31318h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Failure, Composer, Integer, Unit> f31319i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<CoilImageState.Success, Composer, Integer, Unit> f31320j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ContentScale f31321k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Modifier f31322l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatioImageComposablesKt$CrossfadedRatioImage$4(Function3<? super CoilImageState.Loading, ? super Composer, ? super Integer, Unit> function3, int i11, Function3<? super CoilImageState.Failure, ? super Composer, ? super Integer, Unit> function32, Function3<? super CoilImageState.Success, ? super Composer, ? super Integer, Unit> function33, ContentScale contentScale, Modifier modifier) {
        super(3);
        this.f31317g = function3;
        this.f31318h = i11;
        this.f31319i = function32;
        this.f31320j = function33;
        this.f31321k = contentScale;
        this.f31322l = modifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((CoilImageState) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull CoilImageState coilImageState, @Nullable Composer composer, int i11) {
        Unit unit;
        Intrinsics.checkNotNullParameter(coilImageState, "it");
        if ((i11 & 14) == 0) {
            i11 |= composer.changed((Object) coilImageState) ? 4 : 2;
        }
        if (((i11 & 91) ^ 18) == 0 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else if (coilImageState instanceof CoilImageState.None) {
            composer.startReplaceableGroup(-1600300551);
            composer.endReplaceableGroup();
        } else if (coilImageState instanceof CoilImageState.Loading) {
            composer.startReplaceableGroup(-1600300496);
            Function3<CoilImageState.Loading, Composer, Integer, Unit> function3 = this.f31317g;
            if (function3 == null) {
                composer.startReplaceableGroup(1930292177);
            } else {
                composer.startReplaceableGroup(-1600300496);
                function3.invoke(coilImageState, composer, Integer.valueOf(CoilImageState.Loading.$stable | ((this.f31318h >> 6) & 112)));
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else if (coilImageState instanceof CoilImageState.Failure) {
            composer.startReplaceableGroup(-1600300435);
            Function3<CoilImageState.Failure, Composer, Integer, Unit> function32 = this.f31319i;
            if (function32 == null) {
                composer.startReplaceableGroup(1930294068);
            } else {
                composer.startReplaceableGroup(-1600300435);
                function32.invoke(coilImageState, composer, Integer.valueOf(CoilImageState.Failure.$stable | ((this.f31318h >> 12) & 112)));
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else if (coilImageState instanceof CoilImageState.Success) {
            composer.startReplaceableGroup(-1600300383);
            Function3<CoilImageState.Success, Composer, Integer, Unit> function33 = this.f31320j;
            if (function33 == null) {
                composer.startReplaceableGroup(1930295959);
                composer.endReplaceableGroup();
                unit = null;
            } else {
                composer.startReplaceableGroup(-1600300374);
                function33.invoke(coilImageState, composer, Integer.valueOf(CoilImageState.Success.$stable | ((this.f31318h >> 9) & 112)));
                composer.endReplaceableGroup();
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                composer.startReplaceableGroup(-1600300347);
                Drawable drawable = ((CoilImageState.Success) coilImageState).getDrawable();
                if (drawable == null) {
                    composer.startReplaceableGroup(1930296796);
                } else {
                    composer.startReplaceableGroup(-1600300347);
                    ContentScale contentScale = this.f31321k;
                    Modifier modifier = this.f31322l;
                    int i12 = this.f31318h;
                    RatioImageComposablesKt.RatioImageSuccess(drawable, contentScale, modifier, composer, (i12 & 896) | (i12 & 112) | 8);
                }
                composer.endReplaceableGroup();
            } else {
                composer.startReplaceableGroup(-1600300383);
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-1600300123);
            composer.endReplaceableGroup();
        }
    }
}
