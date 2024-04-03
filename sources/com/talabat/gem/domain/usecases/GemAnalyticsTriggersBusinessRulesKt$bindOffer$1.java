package com.talabat.gem.domain.usecases;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
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
public final class GemAnalyticsTriggersBusinessRulesKt$bindOffer$1 extends Lambda implements Function0<Disposable> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GemAnalyticsTriggersPort f60355g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GemAnalyticsTriggersBusinessRulesKt$bindOffer$1(GemAnalyticsTriggersPort gemAnalyticsTriggersPort) {
        super(0);
        this.f60355g = gemAnalyticsTriggersPort;
    }

    @Nullable
    public final Disposable invoke() {
        BehaviorSubject<DataSourcesPort> dataSourcesObservable = IntegrationKt.getDataSourcesObservable();
        final GemAnalyticsTriggersPort gemAnalyticsTriggersPort = this.f60355g;
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
                            public static final GemOffer m10545invoke$lambda0(Throwable th2) {
                                Intrinsics.checkNotNullParameter(th2, "it");
                                return BusinessRulesKt.getNullGemOffer();
                            }

                            @Nullable
                            public final Disposable invoke() {
                                Observable<GemOffer> onErrorReturn = dataSourcesPort.observeOnGemOffer().share().onErrorReturn(new b());
                                Intrinsics.checkNotNullExpressionValue(onErrorReturn, "dataSources.observeOnGem…orReturn { NullGemOffer }");
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
                                return SubscribersKt.subscribeBy$default((Observable) onErrorReturn, (Function1) r32, (Function0) null, (Function1) new Function1<GemOffer, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((GemOffer) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GemOffer gemOffer) {
                                        RxKt.plusAssign(gemAnalyticsTriggersPort.getOffer(), gemOffer);
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
