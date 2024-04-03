package com.talabat.core.deeplink.data.handler.ordertracking;

import android.content.Intent;
import com.talabat.OrderDetailsScreen;
import com.talabat.core.deeplink.data.ParsedLinkModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailsHandler$handle$1 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ParsedLinkModel f55819g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderDetailsHandler$handle$1(ParsedLinkModel parsedLinkModel) {
        super(1);
        this.f55819g = parsedLinkModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "$this$navigateTo");
        intent.putExtra(OrderDetailsScreen.ENCRYPTED_ORDER_ID_KEY, this.f55819g.getData().get("i"));
    }
}
