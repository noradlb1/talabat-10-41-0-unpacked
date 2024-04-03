package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.saveable.Saver;
import androidx.lifecycle.SavedStateHandle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.PropertyDelegateProvider;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00002\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\n"}, d2 = {"", "T", "Landroidx/compose/runtime/MutableState;", "M", "<anonymous parameter 0>", "Lkotlin/reflect/KProperty;", "property", "Lkotlin/properties/ReadWriteProperty;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class SavedStateHandleSaverKt$saveable$3 implements PropertyDelegateProvider<Object, ReadWriteProperty<? super Object, T>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SavedStateHandle f36143a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Saver<T, ? extends Object> f36144b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function0<M> f36145c;

    public SavedStateHandleSaverKt$saveable$3(SavedStateHandle savedStateHandle, Saver<T, ? extends Object> saver, Function0<? extends M> function0) {
        this.f36143a = savedStateHandle;
        this.f36144b = saver;
        this.f36145c = function0;
    }

    @NotNull
    public final ReadWriteProperty<Object, T> provideDelegate(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return new SavedStateHandleSaverKt$saveable$3$provideDelegate$1(SavedStateHandleSaverKt.saveable(this.f36143a, kProperty.getName(), this.f36144b, this.f36145c));
    }
}
