package com.talabat.gem.adapters.presentation.home;

import android.content.Intent;
import com.talabat.gem.IntegrationKt;
import com.talabat.talabatcommon.extentions.RxKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemSwimlanesViewHolder$registerAnalyticsTrigger$3 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemSwimlanesViewModel f60111g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ GemSwimlanesViewHolder f60112h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemSwimlanesViewHolder$registerAnalyticsTrigger$3(GemSwimlanesViewModel gemSwimlanesViewModel, GemSwimlanesViewHolder gemSwimlanesViewHolder) {
        super(1);
        this.f60111g = gemSwimlanesViewModel;
        this.f60112h = gemSwimlanesViewHolder;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Intent intent) {
        if (Intrinsics.areEqual(RxKt.invoke(this.f60111g.getVisibility()), (Object) Boolean.TRUE)) {
            IntegrationKt.getAnalytics().onGemHomeSwimlaneShown();
            this.f60112h.onCancelledAction.invoke();
        }
    }
}
