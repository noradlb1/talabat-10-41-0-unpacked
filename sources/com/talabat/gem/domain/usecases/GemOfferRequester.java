package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.talabatcommon.extentions.KotlinResultKt;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@BusinessRules
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0004\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/talabat/gem/domain/usecases/GemOfferRequester;", "Lkotlin/Function0;", "Lio/reactivex/Single;", "Lcom/talabat/gem/domain/entities/GemOffer;", "()V", "Cached", "Existing", "Refresh", "RefreshFlutterHome", "Lcom/talabat/gem/domain/usecases/GemOfferRequester$Refresh;", "Lcom/talabat/gem/domain/usecases/GemOfferRequester$RefreshFlutterHome;", "Lcom/talabat/gem/domain/usecases/GemOfferRequester$Existing;", "Lcom/talabat/gem/domain/usecases/GemOfferRequester$Cached;", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class GemOfferRequester implements Function0<Single<GemOffer>> {

    @BusinessRules
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004H\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/gem/domain/usecases/GemOfferRequester$Cached;", "Lcom/talabat/gem/domain/usecases/GemOfferRequester;", "()V", "invoke", "Lio/reactivex/Single;", "Lcom/talabat/gem/domain/entities/GemOffer;", "kotlin.jvm.PlatformType", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Cached extends GemOfferRequester {
        @NotNull
        public static final Cached INSTANCE = new Cached();

        private Cached() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        public Single<GemOffer> invoke() {
            return KotlinResultKt.toSingle$default(KotlinResultKt.mapError(IntegrationKt.getDataSources().loadGemOffer(), new GemOfferRequester$Cached$invoke$1((Continuation<? super GemOfferRequester$Cached$invoke$1>) null)), (Function1) null, 1, (Object) null);
        }
    }

    @BusinessRules
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004H\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/gem/domain/usecases/GemOfferRequester$Existing;", "Lcom/talabat/gem/domain/usecases/GemOfferRequester;", "()V", "invoke", "Lio/reactivex/Single;", "Lcom/talabat/gem/domain/entities/GemOffer;", "kotlin.jvm.PlatformType", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Existing extends GemOfferRequester {
        @NotNull
        public static final Existing INSTANCE = new Existing();

        private Existing() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        public Single<GemOffer> invoke() {
            return KotlinResultKt.toSingle$default(KotlinResultKt.mapError(GemViewBusinessRulesKt.loadOrRequestOffer$default((Function1) null, 1, (Object) null), new GemOfferRequester$Existing$invoke$1((Continuation<? super GemOfferRequester$Existing$invoke$1>) null)), (Function1) null, 1, (Object) null);
        }
    }

    @BusinessRules
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004H\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/gem/domain/usecases/GemOfferRequester$Refresh;", "Lcom/talabat/gem/domain/usecases/GemOfferRequester;", "()V", "invoke", "Lio/reactivex/Single;", "Lcom/talabat/gem/domain/entities/GemOffer;", "kotlin.jvm.PlatformType", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Refresh extends GemOfferRequester {
        @NotNull
        public static final Refresh INSTANCE = new Refresh();

        private Refresh() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        public Single<GemOffer> invoke() {
            return KotlinResultKt.toSingle$default(KotlinResultKt.mapError(GemViewBusinessRulesKt.refreshOffer(), new GemOfferRequester$Refresh$invoke$1((Continuation<? super GemOfferRequester$Refresh$invoke$1>) null)), (Function1) null, 1, (Object) null);
        }
    }

    @BusinessRules
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004H\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/gem/domain/usecases/GemOfferRequester$RefreshFlutterHome;", "Lcom/talabat/gem/domain/usecases/GemOfferRequester;", "()V", "invoke", "Lio/reactivex/Single;", "Lcom/talabat/gem/domain/entities/GemOffer;", "kotlin.jvm.PlatformType", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RefreshFlutterHome extends GemOfferRequester {
        @NotNull
        public static final RefreshFlutterHome INSTANCE = new RefreshFlutterHome();

        private RefreshFlutterHome() {
            super((DefaultConstructorMarker) null);
        }

        @NotNull
        public Single<GemOffer> invoke() {
            return KotlinResultKt.toSingle$default(KotlinResultKt.mapError(GemViewBusinessRulesKt.refreshFromFlutterHomeOffer(), new GemOfferRequester$RefreshFlutterHome$invoke$1((Continuation<? super GemOfferRequester$RefreshFlutterHome$invoke$1>) null)), (Function1) null, 1, (Object) null);
        }
    }

    private GemOfferRequester() {
    }

    public /* synthetic */ GemOfferRequester(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
