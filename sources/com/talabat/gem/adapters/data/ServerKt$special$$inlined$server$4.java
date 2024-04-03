package com.talabat.gem.adapters.data;

import JsonModels.GemRejectResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import service.ApiHandler;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00028\u00000\u0001J$\u0010\b\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002¢\u0006\u0002\u0010\fR\u001b\u0010\u0003\u001a\n \u0004*\u0004\u0018\u00018\u00018\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r¸\u0006\u0000"}, d2 = {"gateways/DataSourcesDelegateKt$server$1", "Lkotlin/properties/ReadOnlyProperty;", "", "service", "kotlin.jvm.PlatformType", "getService", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ServerKt$special$$inlined$server$4 implements ReadOnlyProperty<Object, Single<GemRejectResponse>> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f59879a;

    /* renamed from: service  reason: collision with root package name */
    private final GemEndPoints f59880service;

    /* JADX WARNING: type inference failed for: r1v2, types: [com.talabat.gem.adapters.data.GemEndPoints, java.lang.Object] */
    public ServerKt$special$$inlined$server$4(KClass kClass, Function1 function1) {
        this.f59879a = function1;
        this.f59880service = ApiHandler.getInstance().getRetrofit().create(JvmClassMappingKt.getJavaClass(kClass));
    }

    public final GemEndPoints getService() {
        return this.f59880service;
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.Object, io.reactivex.Single<JsonModels.GemRejectResponse>] */
    public Single<GemRejectResponse> getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Function1 function1 = this.f59879a;
        GemEndPoints gemEndPoints = this.f59880service;
        Intrinsics.checkNotNullExpressionValue(gemEndPoints, "service");
        return function1.invoke(gemEndPoints);
    }
}
