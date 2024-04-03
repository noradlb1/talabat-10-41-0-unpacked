package com.talabat.talabatcommon.adapters.special.item;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.extentions.Nullable;
import com.talabat.talabatcommon.extentions.ObserverCallbacks;
import com.talabat.talabatcommon.extentions.RxDelegatesKt;
import com.talabat.talabatcommon.extentions.RxKt;
import com.talabat.talabatcommon.lifecycle.AutoDisposable;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEvents;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEventsKt;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/lifecycle/AutoDisposable;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SpecialItemRecyclerViewExtensionKt$withSpecialItem$1 extends Lambda implements Function1<AutoDisposable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f46844g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f46845h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function2<Context, ViewGroup, RecyclerView.ViewHolder> f46846i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SpecialItemRecyclerViewExtensionKt$withSpecialItem$1(RecyclerView recyclerView, int i11, Function2<? super Context, ? super ViewGroup, ? extends RecyclerView.ViewHolder> function2) {
        super(1);
        this.f46844g = recyclerView;
        this.f46845h = i11;
        this.f46846i = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AutoDisposable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final AutoDisposable autoDisposable) {
        Intrinsics.checkNotNullParameter(autoDisposable, "$this$null");
        Context context = this.f46844g.getContext();
        final RecyclerView recyclerView = this.f46844g;
        final int i11 = this.f46845h;
        final Function2<Context, ViewGroup, RecyclerView.ViewHolder> function2 = this.f46846i;
        ContextLifecycleEventsKt.withLifecycleEvents(context, new Function1<ContextLifecycleEvents, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContextLifecycleEvents) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ContextLifecycleEvents contextLifecycleEvents) {
                Intrinsics.checkNotNullParameter(contextLifecycleEvents, "$this$null");
                ContextLifecycleEvents on2 = contextLifecycleEvents.getOn();
                final AutoDisposable autoDisposable = autoDisposable;
                final RecyclerView recyclerView = recyclerView;
                final int i11 = i11;
                final Function2<Context, ViewGroup, RecyclerView.ViewHolder> function2 = function2;
                final ContextLifecycleEvents contextLifecycleEvents2 = contextLifecycleEvents;
                on2.create(new Function0<Unit>() {

                    /* renamed from: l  reason: collision with root package name */
                    public static final /* synthetic */ KProperty<Object>[] f46851l = {Reflection.property0(new PropertyReference0Impl(SpecialItemRecyclerViewExtensionKt.class, "adaptersStream", "<v#0>", 1))};

                    /* access modifiers changed from: private */
                    /* renamed from: invoke$lambda-0  reason: not valid java name */
                    public static final BehaviorSubject<Nullable<RecyclerView.Adapter<?>>> m9346invoke$lambda0(ReadOnlyProperty<Object, BehaviorSubject<Nullable<RecyclerView.Adapter<?>>>> readOnlyProperty) {
                        return readOnlyProperty.getValue(null, f46851l[0]);
                    }

                    public final void invoke() {
                        final ReadOnlyProperty observe$default = RxDelegatesKt.observe$default(Delegates.INSTANCE, (Scheduler) null, new SpecialItemRecyclerViewExtensionKt$withSpecialItem$1$1$1$adaptersStream$2(recyclerView), 1, (Object) null);
                        AutoDisposable autoDisposable = autoDisposable;
                        final RecyclerView recyclerView = recyclerView;
                        final int i11 = i11;
                        final Function2<Context, ViewGroup, RecyclerView.ViewHolder> function2 = function2;
                        autoDisposable.autoDispose(new Function0<Disposable>() {
                            @org.jetbrains.annotations.Nullable
                            public final Disposable invoke() {
                                BehaviorSubject r02 = AnonymousClass1.m9346invoke$lambda0(observe$default);
                                final RecyclerView recyclerView = recyclerView;
                                final int i11 = i11;
                                final Function2<Context, ViewGroup, RecyclerView.ViewHolder> function2 = function2;
                                return RxKt.invoke(r02, new Function1<ObserverCallbacks<Nullable<RecyclerView.Adapter<?>>, Observable<Nullable<RecyclerView.Adapter<?>>>>, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((ObserverCallbacks<Nullable<RecyclerView.Adapter<?>>, Observable<Nullable<RecyclerView.Adapter<?>>>>) (ObserverCallbacks) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(@NotNull ObserverCallbacks<Nullable<RecyclerView.Adapter<?>>, Observable<Nullable<RecyclerView.Adapter<?>>>> observerCallbacks) {
                                        Intrinsics.checkNotNullParameter(observerCallbacks, "$this$invoke");
                                        observerCallbacks.transform(AnonymousClass1.INSTANCE);
                                        ObserverCallbacks<Nullable<RecyclerView.Adapter<?>>, Observable<Nullable<RecyclerView.Adapter<?>>>> on2 = observerCallbacks.getOn();
                                        final RecyclerView recyclerView = recyclerView;
                                        final int i11 = i11;
                                        final Function2<Context, ViewGroup, RecyclerView.ViewHolder> function2 = function2;
                                        on2.next(new Function1<Nullable<RecyclerView.Adapter<?>>, Unit>() {
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Nullable<RecyclerView.Adapter<?>>) (Nullable) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Nullable<RecyclerView.Adapter<?>> nullable) {
                                                RecyclerView recyclerView = recyclerView;
                                                RecyclerView.Adapter value = nullable.getValue();
                                                if (value != null) {
                                                    SpecialItemRecyclerViewExtensionKt.switchAdapters(recyclerView, value, i11, function2);
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                        });
                        contextLifecycleEvents2.getOn().destroy(new Function0<Unit>() {
                            public final void invoke() {
                                AnonymousClass1.m9346invoke$lambda0(observe$default).onComplete();
                            }
                        });
                    }
                });
            }
        });
    }
}
