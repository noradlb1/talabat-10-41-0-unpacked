package com.talabat.talabatcommon.extentions;

import io.reactivex.Scheduler;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0001J-\u0010\b\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00018\u00008\u00000\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002R\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00018\u00008\u00000\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"com/talabat/talabatcommon/extentions/RxDelegatesKt$observeDistinct$1", "Lkotlin/properties/ReadOnlyProperty;", "", "Lio/reactivex/subjects/BehaviorSubject;", "data", "kotlin.jvm.PlatformType", "getData", "()Lio/reactivex/subjects/BehaviorSubject;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RxDelegatesKt$observeDistinct$1 implements ReadOnlyProperty<Object, BehaviorSubject<T>> {
    @NotNull
    private final BehaviorSubject<T> data;

    public RxDelegatesKt$observeDistinct$1(final Function0<? extends T> function0, final Scheduler scheduler) {
        BehaviorSubject<T> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<T>()");
        this.data = create;
        RxDelegatesKt.OnDistinctValueChangeListener(new Function1<OnValueChangeListener<T>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((OnValueChangeListener) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull OnValueChangeListener<T> onValueChangeListener) {
                Intrinsics.checkNotNullParameter(onValueChangeListener, "$this$OnDistinctValueChangeListener");
                onValueChangeListener.getWith().provider(function0);
                onValueChangeListener.getWith().scheduler(scheduler);
                onValueChangeListener.getOn().scheduler(scheduler);
                onValueChangeListener.getOn().next(new Function1<T, Unit>(this.getData()) {
                    public final void invoke(T t11) {
                        ((BehaviorSubject) this.receiver).onNext(t11);
                    }
                });
                onValueChangeListener.getOn().error(new Function1<Throwable, Unit>(this.getData()) {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Throwable) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull Throwable th2) {
                        Intrinsics.checkNotNullParameter(th2, "p0");
                        ((BehaviorSubject) this.receiver).onError(th2);
                    }
                });
                onValueChangeListener.getOn().complete(new Function0<Unit>(this.getData()) {
                    public final void invoke() {
                        ((BehaviorSubject) this.receiver).onComplete();
                    }
                });
            }
        });
    }

    @NotNull
    public final BehaviorSubject<T> getData() {
        return this.data;
    }

    @NotNull
    public BehaviorSubject<T> getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return this.data;
    }
}
