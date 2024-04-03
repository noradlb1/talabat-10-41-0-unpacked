package androidx.lifecycle.viewmodel.compose;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\n"}, d2 = {"", "T", "<anonymous parameter 0>", "Lkotlin/reflect/KProperty;", "<anonymous parameter 1>", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class SavedStateHandleSaverKt$saveable$2$provideDelegate$1 implements ReadOnlyProperty<Object, T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ T f36142a;

    public SavedStateHandleSaverKt$saveable$2$provideDelegate$1(T t11) {
        this.f36142a = t11;
    }

    @NotNull
    public final T getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "<anonymous parameter 1>");
        return this.f36142a;
    }
}
