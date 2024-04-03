package com.talabat.filters.navigation;

import android.content.Intent;
import com.talabat.filters.presentation.FiltersScreenKt;
import com.talabat.talabatcommon.views.StartForResultBuilder;
import datamodels.filters.Selectables;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/views/StartForResultBuilder;", "Ldatamodels/filters/Selectables;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RouterKt$startFragmentForResult$1 extends Lambda implements Function1<StartForResultBuilder<Selectables>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f59588g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RouterKt$startFragmentForResult$1(int i11) {
        super(1);
        this.f59588g = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StartForResultBuilder<Selectables>) (StartForResultBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull StartForResultBuilder<Selectables> startForResultBuilder) {
        Intrinsics.checkNotNullParameter(startForResultBuilder, "$this$StartForResultBuilder");
        StartForResultBuilder<Selectables> set = startForResultBuilder.getSet();
        final int i11 = this.f59588g;
        set.startingIntent(new Function0<Intent>() {
            @NotNull
            public final Intent invoke() {
                Intent putExtra = new Intent("talabat.components.filters").putExtra(FiltersScreenKt.EXTRA_TYPE, i11);
                Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(ACTION_OPEN_FILTE…utExtra(EXTRA_TYPE, type)");
                return putExtra;
            }
        });
        startForResultBuilder.getSet().resultRetriever(AnonymousClass2.INSTANCE);
    }
}
