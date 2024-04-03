package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLoadingKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import org.jetbrains.annotations.NotNull;

public final class ClassDeclaredMemberIndex$methodFilter$1 extends Lambda implements Function1<JavaMethod, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ClassDeclaredMemberIndex f24594g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClassDeclaredMemberIndex$methodFilter$1(ClassDeclaredMemberIndex classDeclaredMemberIndex) {
        super(1);
        this.f24594g = classDeclaredMemberIndex;
    }

    @NotNull
    public final Boolean invoke(@NotNull JavaMethod javaMethod) {
        Intrinsics.checkNotNullParameter(javaMethod, "m");
        return Boolean.valueOf(((Boolean) this.f24594g.memberFilter.invoke(javaMethod)).booleanValue() && !JavaLoadingKt.isObjectMethodInInterface(javaMethod));
    }
}
