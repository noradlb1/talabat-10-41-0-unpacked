package com.skydoves.landscapist;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"com/skydoves/landscapist/ImageLoad__ImageLoadKt"}, k = 4, mv = {1, 5, 1}, xi = 48)
public final class ImageLoad {
    @Composable
    public static final <T> void ImageLoad(@Nullable T t11, @NotNull Function1<? super Continuation<? super Flow<? extends ImageLoadState>>, ? extends Object> function1, @Nullable Modifier modifier, @NotNull Function3<? super ImageLoadState, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i11, int i12) {
        ImageLoad__ImageLoadKt.ImageLoad(t11, function1, modifier, function3, composer, i11, i12);
    }
}
