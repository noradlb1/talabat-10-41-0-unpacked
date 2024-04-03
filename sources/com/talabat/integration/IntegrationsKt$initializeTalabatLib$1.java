package com.talabat.integration;

import com.talabat.helpers.TalabatApplication;
import com.talabat.lib.Integration;
import com.talabat.lib.TalabatLibIntegrator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/helpers/TalabatApplication;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class IntegrationsKt$initializeTalabatLib$1 extends Lambda implements Function1<TalabatApplication, Unit> {
    public static final IntegrationsKt$initializeTalabatLib$1 INSTANCE = new IntegrationsKt$initializeTalabatLib$1();

    public IntegrationsKt$initializeTalabatLib$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TalabatApplication) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final TalabatApplication talabatApplication) {
        Intrinsics.checkNotNullParameter(talabatApplication, "$this$$receiver");
        Integration.TalabatLibIntegration(talabatApplication, new Function1<TalabatLibIntegrator, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TalabatLibIntegrator) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull TalabatLibIntegrator talabatLibIntegrator) {
                Intrinsics.checkNotNullParameter(talabatLibIntegrator, "$this$TalabatLibIntegration");
                Integration.isGemActive(Integration.getSet(talabatLibIntegrator), new Function0<Boolean>(talabatApplication) {
                    @NotNull
                    public final Boolean invoke() {
                        return Boolean.valueOf(((TalabatApplication) this.receiver).isGemActive());
                    }
                });
                Integration.isFirebaseAnalyticsActive(Integration.getSet(talabatLibIntegrator), AnonymousClass2.INSTANCE);
                Integration.firebaseAnalyticsKey(Integration.getSet(talabatLibIntegrator), AnonymousClass3.INSTANCE);
                TalabatLibIntegrator set = Integration.getSet(talabatLibIntegrator);
                final TalabatApplication talabatApplication = talabatApplication;
                Integration.gemComponentStateRetriever(set, new Function0<Map<String, ? extends String>>() {
                    @NotNull
                    public final Map<String, String> invoke() {
                        Map<String, String> gemComponentState = talabatApplication.getGemComponentState();
                        Intrinsics.checkNotNullExpressionValue(gemComponentState, "gemComponentState");
                        return gemComponentState;
                    }
                });
                Integration.isSponsoredSortingActive(Integration.getSet(talabatLibIntegrator), AnonymousClass5.INSTANCE);
            }
        });
    }
}
