package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001e\b\u0002\u0010\u0005\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006¢\u0006\u0002\u0010\u0007J\"\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0002¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u0004\u0018\u00018\u00002\b\u0010\u0013\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0014\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0004H\u0016R*\u0010\u0005\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "T", "", "name", "", "mergePolicy", "Lkotlin/Function2;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "getMergePolicy$ui_release", "()Lkotlin/jvm/functions/Function2;", "getName", "()Ljava/lang/String;", "getValue", "thisRef", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "merge", "parentValue", "childValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "setValue", "", "value", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SemanticsPropertyKey<T> {
    public static final int $stable = 0;
    @NotNull
    private final Function2<T, T, T> mergePolicy;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f10124name;

    public SemanticsPropertyKey(@NotNull String str, @NotNull Function2<? super T, ? super T, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, "mergePolicy");
        this.f10124name = str;
        this.mergePolicy = function2;
    }

    @NotNull
    public final Function2<T, T, T> getMergePolicy$ui_release() {
        return this.mergePolicy;
    }

    @NotNull
    public final String getName() {
        return this.f10124name;
    }

    public final T getValue(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return SemanticsPropertiesKt.throwSemanticsGetNotSupported();
    }

    @Nullable
    public final T merge(@Nullable T t11, T t12) {
        return this.mergePolicy.invoke(t11, t12);
    }

    public final void setValue(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull KProperty<?> kProperty, T t11) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        semanticsPropertyReceiver.set(this, t11);
    }

    @NotNull
    public String toString() {
        return "SemanticsPropertyKey: " + this.f10124name;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SemanticsPropertyKey(String str, Function2 function2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? AnonymousClass1.INSTANCE : function2);
    }
}
