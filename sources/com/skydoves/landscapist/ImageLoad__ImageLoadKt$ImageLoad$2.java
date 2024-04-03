package com.skydoves.landscapist;

import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class ImageLoad__ImageLoadKt$ImageLoad$2 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function3<ImageLoadState, Composer, Integer, Unit> f52950g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f52951h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableState<ImageLoadState> f52952i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageLoad__ImageLoadKt$ImageLoad$2(Function3<? super ImageLoadState, ? super Composer, ? super Integer, Unit> function3, int i11, MutableState<ImageLoadState> mutableState) {
        super(3);
        this.f52950g = function3;
        this.f52951h = i11;
        this.f52952i = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@NotNull BoxWithConstraintsScope boxWithConstraintsScope, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(boxWithConstraintsScope, "$this$BoxWithConstraints");
        if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
            this.f52950g.invoke(ImageLoad__ImageLoadKt.m9395ImageLoad$lambda1$ImageLoad__ImageLoadKt(this.f52952i), composer, Integer.valueOf((this.f52951h >> 6) & 112));
        } else {
            composer.skipToGroupEnd();
        }
    }
}
