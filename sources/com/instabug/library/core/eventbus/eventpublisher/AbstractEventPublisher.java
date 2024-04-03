package com.instabug.library.core.eventbus.eventpublisher;

import com.instabug.library.diagnostics.IBGDiagnostics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractEventPublisher<T> implements EventPublisher<T> {
    /* access modifiers changed from: private */
    @NotNull
    public final List<Subscriber<T>> subscribers = new ArrayList();

    public static final class a extends Lambda implements Function0 {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbstractEventPublisher f34187g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Object f34188h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AbstractEventPublisher abstractEventPublisher, Object obj) {
            super(0);
            this.f34187g = abstractEventPublisher;
            this.f34188h = obj;
        }

        public final void a() {
            List<Subscriber> access$getSubscribers$p = this.f34187g.subscribers;
            Object obj = this.f34188h;
            for (Subscriber onNewEvent : access$getSubscribers$p) {
                onNewEvent.onNewEvent(obj);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0 {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbstractEventPublisher f34189g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Throwable f34190h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AbstractEventPublisher abstractEventPublisher, Throwable th2) {
            super(0);
            this.f34189g = abstractEventPublisher;
            this.f34190h = th2;
        }

        public final void a() {
            List<Subscriber> access$getSubscribers$p = this.f34189g.subscribers;
            Throwable th2 = this.f34190h;
            for (Subscriber onError : access$getSubscribers$p) {
                onError.onError(th2);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0 {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbstractEventPublisher f34191g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Subscriber f34192h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AbstractEventPublisher abstractEventPublisher, Subscriber subscriber) {
            super(0);
            this.f34191g = abstractEventPublisher;
            this.f34192h = subscriber;
        }

        public final void a() {
            this.f34191g.subscribers.add(this.f34192h);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0 {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AbstractEventPublisher f34193g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Subscriber f34194h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(AbstractEventPublisher abstractEventPublisher, Subscriber subscriber) {
            super(0);
            this.f34193g = abstractEventPublisher;
            this.f34194h = subscriber;
        }

        public final void a() {
            AbstractEventPublisher abstractEventPublisher = this.f34193g;
            Subscriber subscriber = this.f34194h;
            synchronized (abstractEventPublisher) {
                abstractEventPublisher.subscribers.remove(subscriber);
                Unit unit = Unit.INSTANCE;
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    private final void failSafely(Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Exception e11) {
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            IBGDiagnostics.reportNonFatal(e11, message);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribe$lambda-0  reason: not valid java name */
    public static final void m9023subscribe$lambda0(AbstractEventPublisher abstractEventPublisher, Subscriber subscriber) {
        Intrinsics.checkNotNullParameter(abstractEventPublisher, "this$0");
        Intrinsics.checkNotNullParameter(subscriber, "$subscriber");
        abstractEventPublisher.failSafely(new d(abstractEventPublisher, subscriber));
    }

    public synchronized void post(T t11) {
        failSafely(new a(this, t11));
    }

    public synchronized void postError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        failSafely(new b(this, th2));
    }

    @NotNull
    public synchronized Unsubscribable subscribe(@NotNull Subscriber<T> subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        failSafely(new c(this, subscriber));
        return new uc.a(this, subscriber);
    }
}
