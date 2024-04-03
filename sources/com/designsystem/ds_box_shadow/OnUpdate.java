package com.designsystem.ds_box_shadow;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B=\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\"\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u00032\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002¢\u0006\u0002\u0010\u0017J*\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00032\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001aR\u001c\u0010\n\u001a\u00028\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/designsystem/ds_box_shadow/OnUpdate;", "T", "Lkotlin/properties/ReadWriteProperty;", "Landroid/view/View;", "default", "transformation", "Lkotlin/Function1;", "onUpdate", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "backing", "getBacking", "()Ljava/lang/Object;", "setBacking", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getOnUpdate", "()Lkotlin/jvm/functions/Function1;", "getTransformation", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Landroid/view/View;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "value", "(Landroid/view/View;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class OnUpdate<T> implements ReadWriteProperty<View, T> {
    private T backing;
    @Nullable
    private final Function1<T, Unit> onUpdate;
    @Nullable
    private final Function1<T, T> transformation;

    public OnUpdate(T t11, @Nullable Function1<? super T, ? extends T> function1, @Nullable Function1<? super T, Unit> function12) {
        this.transformation = function1;
        this.onUpdate = function12;
        this.backing = t11;
    }

    public final T getBacking() {
        return this.backing;
    }

    @Nullable
    public final Function1<T, Unit> getOnUpdate() {
        return this.onUpdate;
    }

    @Nullable
    public final Function1<T, T> getTransformation() {
        return this.transformation;
    }

    public final void setBacking(T t11) {
        this.backing = t11;
    }

    public T getValue(@NotNull View view, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(view, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return this.backing;
    }

    public void setValue(@NotNull View view, @NotNull KProperty<?> kProperty, T t11) {
        T t12;
        Intrinsics.checkNotNullParameter(view, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        if (!Intrinsics.areEqual((Object) this.backing, (Object) t11)) {
            Function1<T, T> function1 = this.transformation;
            if (function1 == null || (t12 = function1.invoke(t11)) == null) {
                t12 = t11;
            }
            this.backing = t12;
            Function1<T, Unit> function12 = this.onUpdate;
            if (function12 != null) {
                function12.invoke(t11);
            }
            view.postInvalidate();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnUpdate(Object obj, Function1 function1, Function1 function12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i11 & 2) != 0 ? null : function1, (i11 & 4) != 0 ? null : function12);
    }
}
