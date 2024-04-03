package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

public final class ScopesHolderForClass$scopeForOwnerModule$2 extends Lambda implements Function0<T> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ScopesHolderForClass<T> f24490g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScopesHolderForClass$scopeForOwnerModule$2(ScopesHolderForClass<T> scopesHolderForClass) {
        super(0);
        this.f24490g = scopesHolderForClass;
    }

    @NotNull
    public final T invoke() {
        return (MemberScope) this.f24490g.scopeFactory.invoke(this.f24490g.kotlinTypeRefinerForOwnerModule);
    }
}
