package com.designsystem.ds_input_field;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¨\u0006\u0004"}, d2 = {"T", "", "index", "", "androidx/compose/foundation/lazy/LazyDslKt$itemsIndexed$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class PhoneInputCountriesFragment$CountryPicker$2$1$invoke$$inlined$itemsIndexed$default$1 extends Lambda implements Function1<Integer, Object> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2 f31863g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List f31864h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhoneInputCountriesFragment$CountryPicker$2$1$invoke$$inlined$itemsIndexed$default$1(Function2 function2, List list) {
        super(1);
        this.f31863g = function2;
        this.f31864h = list;
    }

    @NotNull
    public final Object invoke(int i11) {
        return this.f31863g.invoke(Integer.valueOf(i11), this.f31864h.get(i11));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
