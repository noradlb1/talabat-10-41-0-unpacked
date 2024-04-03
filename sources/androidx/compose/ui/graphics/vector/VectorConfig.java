package androidx.compose.ui.graphics.vector;

import g0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u0002H\u0003H\u0016¢\u0006\u0002\u0010\u0007ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorConfig;", "", "getOrDefault", "T", "property", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "defaultValue", "(Landroidx/compose/ui/graphics/vector/VectorProperty;Ljava/lang/Object;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface VectorConfig {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> T getOrDefault(@NotNull VectorConfig vectorConfig, @NotNull VectorProperty<T> vectorProperty, T t11) {
            Intrinsics.checkNotNullParameter(vectorProperty, "property");
            return a.a(vectorConfig, vectorProperty, t11);
        }
    }

    <T> T getOrDefault(@NotNull VectorProperty<T> vectorProperty, T t11);
}
