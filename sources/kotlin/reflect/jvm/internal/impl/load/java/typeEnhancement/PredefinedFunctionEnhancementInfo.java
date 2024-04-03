package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PredefinedFunctionEnhancementInfo {
    @NotNull
    private final List<TypeEnhancementInfo> parametersInfo;
    @Nullable
    private final TypeEnhancementInfo returnTypeInfo;

    public PredefinedFunctionEnhancementInfo() {
        this((TypeEnhancementInfo) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public PredefinedFunctionEnhancementInfo(@Nullable TypeEnhancementInfo typeEnhancementInfo, @NotNull List<TypeEnhancementInfo> list) {
        Intrinsics.checkNotNullParameter(list, "parametersInfo");
        this.returnTypeInfo = typeEnhancementInfo;
        this.parametersInfo = list;
    }

    @NotNull
    public final List<TypeEnhancementInfo> getParametersInfo() {
        return this.parametersInfo;
    }

    @Nullable
    public final TypeEnhancementInfo getReturnTypeInfo() {
        return this.returnTypeInfo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PredefinedFunctionEnhancementInfo(TypeEnhancementInfo typeEnhancementInfo, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : typeEnhancementInfo, (i11 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }
}
