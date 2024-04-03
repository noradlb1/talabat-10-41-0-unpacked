package com.talabat.gem.ports.data;

import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.talabatcommon.extentions.KotlinResultKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J/\u0010\u0004\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\tJ/\u0010\n\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/talabat/gem/ports/data/GemAcceptanceDataSourcesPort;", "", "loadGemOfferAcceptance", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance;", "requestGemOfferAcceptance", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Accepted;", "()Lkotlin/jvm/functions/Function1;", "requestGemOfferRejection", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Rejected;", "updateGemOfferAcceptance", "", "acceptance", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemAcceptanceDataSourcesPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Nullable
        public static GemOfferAcceptance loadGemOfferAcceptance(@NotNull GemAcceptanceDataSourcesPort gemAcceptanceDataSourcesPort) {
            return null;
        }

        @NotNull
        public static Function1<Continuation<? super Result<GemOfferAcceptance.Accepted>>, Object> requestGemOfferAcceptance(@NotNull GemAcceptanceDataSourcesPort gemAcceptanceDataSourcesPort) {
            return KotlinResultKt.Either(new GemAcceptanceDataSourcesPort$requestGemOfferAcceptance$1((Continuation<? super GemAcceptanceDataSourcesPort$requestGemOfferAcceptance$1>) null));
        }

        @NotNull
        public static Function1<Continuation<? super Result<GemOfferAcceptance.Rejected>>, Object> requestGemOfferRejection(@NotNull GemAcceptanceDataSourcesPort gemAcceptanceDataSourcesPort) {
            return KotlinResultKt.Either(new GemAcceptanceDataSourcesPort$requestGemOfferRejection$1((Continuation<? super GemAcceptanceDataSourcesPort$requestGemOfferRejection$1>) null));
        }

        public static void updateGemOfferAcceptance(@NotNull GemAcceptanceDataSourcesPort gemAcceptanceDataSourcesPort, @Nullable GemOfferAcceptance gemOfferAcceptance) {
        }
    }

    @Nullable
    GemOfferAcceptance loadGemOfferAcceptance();

    @NotNull
    Function1<Continuation<? super Result<GemOfferAcceptance.Accepted>>, Object> requestGemOfferAcceptance();

    @NotNull
    Function1<Continuation<? super Result<GemOfferAcceptance.Rejected>>, Object> requestGemOfferRejection();

    void updateGemOfferAcceptance(@Nullable GemOfferAcceptance gemOfferAcceptance);
}
