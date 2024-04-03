package com.talabat.helpers;

import android.content.Context;
import com.talabat.components.CuisinesLogger;
import com.talabat.components.CuisinesRepositoryImplementer;
import com.talabat.cuisines.CuisinesIntegrator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/cuisines/CuisinesIntegrator;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$onCreate$3 extends Lambda implements Function1<CuisinesIntegrator, Unit> {
    final /* synthetic */ TalabatApplication this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TalabatApplication$onCreate$3(TalabatApplication talabatApplication) {
        super(1);
        this.this$0 = talabatApplication;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CuisinesIntegrator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull CuisinesIntegrator cuisinesIntegrator) {
        Intrinsics.checkNotNullParameter(cuisinesIntegrator, "$this$CuisinesIntegration");
        cuisinesIntegrator.getSet().repository(CuisinesRepositoryImplementer.INSTANCE);
        CuisinesIntegrator set = cuisinesIntegrator.getSet();
        Context applicationContext = this.this$0.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        set.logger(new CuisinesLogger(applicationContext));
    }
}
