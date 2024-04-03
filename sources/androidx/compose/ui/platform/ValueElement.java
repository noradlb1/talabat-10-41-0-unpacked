package androidx.compose.ui.platform;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/ValueElement;", "", "name", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "getName", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ValueElement {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f10046name;
    @Nullable
    private final Object value;

    public ValueElement(@NotNull String str, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.f10046name = str;
        this.value = obj;
    }

    public static /* synthetic */ ValueElement copy$default(ValueElement valueElement, String str, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            str = valueElement.f10046name;
        }
        if ((i11 & 2) != 0) {
            obj = valueElement.value;
        }
        return valueElement.copy(str, obj);
    }

    @NotNull
    public final String component1() {
        return this.f10046name;
    }

    @Nullable
    public final Object component2() {
        return this.value;
    }

    @NotNull
    public final ValueElement copy(@NotNull String str, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new ValueElement(str, obj);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ValueElement)) {
            return false;
        }
        ValueElement valueElement = (ValueElement) obj;
        return Intrinsics.areEqual((Object) this.f10046name, (Object) valueElement.f10046name) && Intrinsics.areEqual(this.value, valueElement.value);
    }

    @NotNull
    public final String getName() {
        return this.f10046name;
    }

    @Nullable
    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = this.f10046name.hashCode() * 31;
        Object obj = this.value;
        return hashCode + (obj == null ? 0 : obj.hashCode());
    }

    @NotNull
    public String toString() {
        return "ValueElement(name=" + this.f10046name + ", value=" + this.value + ')';
    }
}
