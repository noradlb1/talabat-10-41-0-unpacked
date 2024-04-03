package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class ScopesHolderForClass$getScope$1 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ScopesHolderForClass<T> f24488g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ KotlinTypeRefiner f24489h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScopesHolderForClass$getScope$1(ScopesHolderForClass<T> scopesHolderForClass, KotlinTypeRefiner kotlinTypeRefiner) {
        super(0);
        this.f24488g = scopesHolderForClass;
        this.f24489h = kotlinTypeRefiner;
    }

    @NotNull
    public final T invoke() {
        return (MemberScope) this.f24488g.scopeFactory.invoke(this.f24489h);
    }
}
