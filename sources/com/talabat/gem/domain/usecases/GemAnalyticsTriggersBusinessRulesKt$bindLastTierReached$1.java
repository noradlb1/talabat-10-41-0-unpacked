package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.ports.analytics.GemAnalyticsTriggersPort;
import com.talabat.gem.ports.data.DataSourcesPort;
import com.talabat.talabatcommon.extentions.ObserverCallbacks;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemAnalyticsTriggersBusinessRulesKt$bindLastTierReached$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemAnalyticsTriggersPort f60349g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemAnalyticsTriggersBusinessRulesKt$bindLastTierReached$1(GemAnalyticsTriggersPort gemAnalyticsTriggersPort) {
        super(0);
        this.f60349g = gemAnalyticsTriggersPort;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<DataSourcesPort> dataSourcesObservable = IntegrationKt.getDataSourcesObservable();
        final GemAnalyticsTriggersPort gemAnalyticsTriggersPort = this.f60349g;
        return RxKt.invoke(dataSourcesObservable, new Function1<ObserverCallbacks<DataSourcesPort, Observable<DataSourcesPort>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<DataSourcesPort, Observable<DataSourcesPort>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<DataSourcesPort, Observable<DataSourcesPort>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                observerCallbacks.getOn().scheduler(gemAnalyticsTriggersPort.getScheduler());
                observerCallbacks.getOn().error(new Function1<Throwable, Unit>(gemAnalyticsTriggersPort.getErrors()) {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Throwable) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull Throwable th2) {
                        Intrinsics.checkNotNullParameter(th2, "p0");
                        ((Subject) this.receiver).onNext(th2);
                    }
                });
                ObserverCallbacks<DataSourcesPort, Observable<DataSourcesPort>> on2 = observerCallbacks.getOn();
                final GemAnalyticsTriggersPort gemAnalyticsTriggersPort = gemAnalyticsTriggersPort;
                on2.next(new Function1<DataSourcesPort, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((DataSourcesPort) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final DataSourcesPort dataSourcesPort) {
                        final GemAnalyticsTriggersPort gemAnalyticsTriggersPort = gemAnalyticsTriggersPort;
                        gemAnalyticsTriggersPort.autoDispose(new Function0<Disposable>() {
                            /* access modifiers changed from: private */
                            /* renamed from: invoke$lambda-0  reason: not valid java name */
                            public static final com.talabat.talabatcommon.extentions.Nullable m10544invoke$lambda0(GemRestaurant gemRestaurant) {
                                Intrinsics.checkNotNullParameter(gemRestaurant, "it");
                                return new com.talabat.talabatcommon.extentions.Nullable(null);
                            }

                            @Nullable
                            public final Disposable invoke() {
                                Observable<R> map = dataSourcesPort.observeOnSelectedGemRestaurant().share().distinctUntilChanged().map(new a());
                                Intrinsics.checkNotNullExpressionValue(map, "dataSources.observeOnSel…Nullable<GemTier>(null) }");
                                AnonymousClass2 r32 = new Function1<Throwable, Unit>(gemAnalyticsTriggersPort.getErrors()) {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Throwable) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull Throwable th2) {
                                        Intrinsics.checkNotNullParameter(th2, "p0");
                                        ((Subject) this.receiver).onNext(th2);
                                    }
                                };
                                final GemAnalyticsTriggersPort gemAnalyticsTriggersPort = gemAnalyticsTriggersPort;
                                return SubscribersKt.subscribeBy$default((Observable) map, (Function1) r32, (Function0) null, (Function1) new Function1<com.talabat.talabatcommon.extentions.Nullable<GemTier>, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((com.talabat.talabatcommon.extentions.Nullable<GemTier>) (com.talabat.talabatcommon.extentions.Nullable) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(com.talabat.talabatcommon.extentions.Nullable<GemTier> nullable) {
                                        RxKt.plusAssign(gemAnalyticsTriggersPort.getLastTierReached(), nullable);
                                        RxKt.plusAssign(gemAnalyticsTriggersPort.getSubTotal(), Double.valueOf(0.0d));
                                    }
                                }, 2, (Object) null);
                            }
                        });
                    }
                });
            }
        });
    }
}
