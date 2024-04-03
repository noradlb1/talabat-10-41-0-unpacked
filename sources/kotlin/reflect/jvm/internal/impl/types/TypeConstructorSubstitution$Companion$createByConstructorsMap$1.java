package kotlin.reflect.jvm.internal.impl.types;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeConstructorSubstitution$Companion$createByConstructorsMap$1 extends TypeConstructorSubstitution {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map<TypeConstructor, TypeProjection> f24958a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f24959b;

    public TypeConstructorSubstitution$Companion$createByConstructorsMap$1(Map<TypeConstructor, ? extends TypeProjection> map, boolean z11) {
        this.f24958a = map;
        this.f24959b = z11;
    }

    public boolean approximateCapturedTypes() {
        return this.f24959b;
    }

    @Nullable
    public TypeProjection get(@NotNull TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "key");
        return this.f24958a.get(typeConstructor);
    }

    public boolean isEmpty() {
        return this.f24958a.isEmpty();
    }
}
