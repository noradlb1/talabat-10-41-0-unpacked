package com.designsystem.ds_fixed_footer;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class DSFixedFooterWithVerticalButtons$Content$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f31227g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSFixedFooterWithVerticalButtons$Content$1$1(View view) {
        super(2);
        this.f31227g = view;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            final View view = this.f31227g;
            AndroidView_androidKt.AndroidView(new Function1<Context, View>() {
                @NotNull
                public final View invoke(@NotNull Context context) {
                    Intrinsics.checkNotNullParameter(context, "it");
                    return view;
                }
            }, (Modifier) null, (Function1) null, composer, 0, 6);
            return;
        }
        composer.skipToGroupEnd();
    }
}
