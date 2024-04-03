package com.talabat.feature.darkstorescart.data.local;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Types;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002 \u0004*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/squareup/moshi/JsonAdapter;", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ProductUrlListTypeConverter$stringListAdapter$2 extends Lambda implements Function0<JsonAdapter<List<? extends String>>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ProductUrlListTypeConverter f58486g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProductUrlListTypeConverter$stringListAdapter$2(ProductUrlListTypeConverter productUrlListTypeConverter) {
        super(0);
        this.f58486g = productUrlListTypeConverter;
    }

    public final JsonAdapter<List<String>> invoke() {
        return this.f58486g.getMoshi().adapter((Type) Types.newParameterizedType(List.class, String.class));
    }
}
