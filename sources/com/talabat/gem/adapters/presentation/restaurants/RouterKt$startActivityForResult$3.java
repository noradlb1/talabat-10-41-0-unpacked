package com.talabat.gem.adapters.presentation.restaurants;

import android.content.Context;
import android.content.Intent;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.talabatcommon.views.StartForResultBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/views/StartForResultBuilder;", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class RouterKt$startActivityForResult$3 extends Lambda implements Function1<StartForResultBuilder<GemRestaurant>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f60324g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Class<?> f60325h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RouterKt$startActivityForResult$3(Context context, Class<?> cls) {
        super(1);
        this.f60324g = context;
        this.f60325h = cls;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StartForResultBuilder<GemRestaurant>) (StartForResultBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull StartForResultBuilder<GemRestaurant> startForResultBuilder) {
        Intrinsics.checkNotNullParameter(startForResultBuilder, "$this$StartForResultBuilder");
        StartForResultBuilder<GemRestaurant> set = startForResultBuilder.getSet();
        final Context context = this.f60324g;
        final Class<?> cls = this.f60325h;
        set.startingIntent(new Function0<Intent>() {
            @NotNull
            public final Intent invoke() {
                return new Intent(context, cls);
            }
        });
        startForResultBuilder.getSet().resultRetriever(AnonymousClass2.INSTANCE);
    }
}
