package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.huawei.hms.flutter.map.constants.Param;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class TypeEnhancementInfo {
    @NotNull
    private final Map<Integer, JavaTypeQualifiers> map;

    public TypeEnhancementInfo(@NotNull Map<Integer, JavaTypeQualifiers> map2) {
        Intrinsics.checkNotNullParameter(map2, Param.MAP);
        this.map = map2;
    }

    @NotNull
    public final Map<Integer, JavaTypeQualifiers> getMap() {
        return this.map;
    }
}
