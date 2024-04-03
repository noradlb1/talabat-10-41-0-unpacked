package com.designsystem.ds_image;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import com.skydoves.landscapist.coil.CoilImageState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class RatioImageComposablesKt$CrossfadedRatioImage$3 extends Lambda implements Function3<CoilImageState.Failure, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutableState<CoilImageState> f31316g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RatioImageComposablesKt$CrossfadedRatioImage$3(MutableState<CoilImageState> mutableState) {
        super(3);
        this.f31316g = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((CoilImageState.Failure) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull CoilImageState.Failure failure, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(failure, "it");
        if ((i11 & 14) == 0) {
            i11 |= composer.changed((Object) failure) ? 4 : 2;
        }
        if (((i11 & 91) ^ 18) != 0 || !composer.getSkipping()) {
            RatioImageComposablesKt.m8363CrossfadedRatioImage$lambda2(this.f31316g, failure);
        } else {
            composer.skipToGroupEnd();
        }
    }
}
