package com.talabat.cuisines.navigation;

import android.content.Intent;
import com.talabat.cuisines.presentation.CuisinesScreenKt;
import com.talabat.talabatcommon.views.StartForResultBuilder;
import datamodels.Cuisine;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001*\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/views/StartForResultBuilder;", "Lkotlin/Pair;", "Ldatamodels/Cuisine;", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RouterKt$startFragmentForResult$1 extends Lambda implements Function1<StartForResultBuilder<Pair<? extends Cuisine, ? extends String>>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f56045g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f56046h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RouterKt$startFragmentForResult$1(boolean z11, boolean z12) {
        super(1);
        this.f56045g = z11;
        this.f56046h = z12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StartForResultBuilder<Pair<Cuisine, String>>) (StartForResultBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull StartForResultBuilder<Pair<Cuisine, String>> startForResultBuilder) {
        Intrinsics.checkNotNullParameter(startForResultBuilder, "$this$StartForResultBuilder");
        StartForResultBuilder<Pair<Cuisine, String>> set = startForResultBuilder.getSet();
        final boolean z11 = this.f56045g;
        final boolean z12 = this.f56046h;
        set.startingIntent(new Function0<Intent>() {
            @NotNull
            public final Intent invoke() {
                Intent putExtra = new Intent("talabat.components.cuisines").putExtra(CuisinesScreenKt.EXTRA_IS_COLLECTION, z11).putExtra(CuisinesScreenKt.EXTRA_IS_PICKUP, z12);
                Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(ACTION_OPEN_CUISI…XTRA_IS_PICKUP, isPickup)");
                return putExtra;
            }
        });
        startForResultBuilder.getSet().resultRetriever(AnonymousClass2.INSTANCE);
    }
}
