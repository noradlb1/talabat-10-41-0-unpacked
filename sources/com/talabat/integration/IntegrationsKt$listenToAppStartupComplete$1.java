package com.talabat.integration;

import android.app.Activity;
import com.talabat.talabatcommon.extentions.ObserverCallbacks;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class IntegrationsKt$listenToAppStartupComplete$1 extends Lambda implements Function1<AutoDisposable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OnAppStartupCompleteListener f60993g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ WeakReference<Activity> f60994h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntegrationsKt$listenToAppStartupComplete$1(OnAppStartupCompleteListener onAppStartupCompleteListener, WeakReference<Activity> weakReference) {
        super(1);
        this.f60993g = onAppStartupCompleteListener;
        this.f60994h = weakReference;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AutoDisposable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AutoDisposable autoDisposable) {
        Intrinsics.checkNotNullParameter(autoDisposable, "$this$withAutoDisposables");
        final WeakReference weakReference = new WeakReference(this.f60993g);
        BehaviorSubject<Boolean> initializationComplete = IntegrationsKt.getInitializationComplete();
        final WeakReference<Activity> weakReference2 = this.f60994h;
        RxKt.invoke(initializationComplete, new Function1<ObserverCallbacks<Boolean, Observable<Boolean>>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ObserverCallbacks<Boolean, Observable<Boolean>>) (ObserverCallbacks) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ObserverCallbacks<Boolean, Observable<Boolean>> observerCallbacks) {
                Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                ObserverCallbacks<Boolean, Observable<Boolean>> on2 = observerCallbacks.getOn();
                final WeakReference<OnAppStartupCompleteListener> weakReference = weakReference;
                final WeakReference<Activity> weakReference2 = weakReference2;
                on2.next(new Function1<Boolean, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Boolean) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Boolean bool) {
                        IntegrationsKt.triggerCallbackAfterOnStart(weakReference, weakReference2);
                    }
                });
                observerCallbacks.getOn().error(AnonymousClass2.INSTANCE);
            }
        });
    }
}
