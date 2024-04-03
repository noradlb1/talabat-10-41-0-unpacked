package com.talabat.fluid.homescreen.data.impl;

import com.deliveryhero.fluid.template.Template;
import com.deliveryhero.fluid.template.TemplateBuilder;
import com.deliveryhero.fluid.template.sources.ReadableTemplateSource;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "", "Lcom/deliveryhero/fluid/template/TemplateId;", "Lcom/deliveryhero/fluid/template/Template;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.fluid.homescreen.data.impl.HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$templates$1", f = "HomeConfigurationRepositoryImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$templates$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends Template>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f59683h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ HomeConfigurationRepositoryImpl f59684i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$templates$1(HomeConfigurationRepositoryImpl homeConfigurationRepositoryImpl, Continuation<? super HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$templates$1> continuation) {
        super(2, continuation);
        this.f59684i = homeConfigurationRepositoryImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$templates$1(this.f59684i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Map<String, Template>> continuation) {
        return ((HomeConfigurationRepositoryImpl$fetchComponentsAndTemplatesInParallel$2$templates$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f59683h == 0) {
            ResultKt.throwOnFailure(obj);
            Map<String, TemplateBuilder> map = this.f59684i.readableTemplateSource.get((Set<ReadableTemplateSource.Request>) SetsKt__SetsKt.emptySet());
            HomeConfigurationRepositoryImpl homeConfigurationRepositoryImpl = this.f59684i;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), ((TemplateBuilder) entry.getValue()).build(homeConfigurationRepositoryImpl.parseConfig));
            }
            return linkedHashMap;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
