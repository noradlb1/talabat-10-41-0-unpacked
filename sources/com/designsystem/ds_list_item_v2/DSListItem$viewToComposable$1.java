package com.designsystem.ds_list_item_v2;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u000b"}, d2 = {"", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class DSListItem$viewToComposable$1 extends Lambda implements Function3<Boolean, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f31984g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DSListItem$viewToComposable$1(View view) {
        super(3);
        this.f31984g = view;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke(((Boolean) obj).booleanValue(), (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(boolean z11, @Nullable Composer composer, int i11) {
        if (((i11 & 81) ^ 16) != 0 || !composer.getSkipping()) {
            final View view = this.f31984g;
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
