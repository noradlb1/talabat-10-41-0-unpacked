package com.designsystem.ds_tabs;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¨\u0006\u0004"}, d2 = {"T", "", "index", "", "androidx/compose/foundation/lazy/LazyDslKt$items$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class TabBarMenuFragment$Menu$1$invoke$$inlined$items$default$1 extends Lambda implements Function1<Integer, Object> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1 f33049g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List f33050h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TabBarMenuFragment$Menu$1$invoke$$inlined$items$default$1(Function1 function1, List list) {
        super(1);
        this.f33049g = function1;
        this.f33050h = list;
    }

    @NotNull
    public final Object invoke(int i11) {
        return this.f33049g.invoke(this.f33050h.get(i11));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
