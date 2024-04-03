package com.talabat.feature.darkstoresflutter.data.mapper;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.talabat.feature.darkstoresflutter.data.model.FlutterCart;
import com.talabat.mapper.ModelMapper;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R?\u0010\t\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00020\u0002 \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/darkstoresflutter/data/mapper/FlutterCartToMapMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCart;", "", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "cartAdapter", "Lcom/squareup/moshi/JsonAdapter;", "kotlin.jvm.PlatformType", "getCartAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "cartAdapter$delegate", "Lkotlin/Lazy;", "apply", "source", "com_talabat_feature_darkstores-flutter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterCartToMapMapper implements ModelMapper<FlutterCart, Map<String, ? extends Object>> {
    @NotNull
    private final Lazy cartAdapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new FlutterCartToMapMapper$cartAdapter$2(this));
    /* access modifiers changed from: private */
    @NotNull
    public final Moshi moshi;

    @Inject
    public FlutterCartToMapMapper(@NotNull Moshi moshi2) {
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        this.moshi = moshi2;
    }

    private final JsonAdapter<FlutterCart> getCartAdapter() {
        return (JsonAdapter) this.cartAdapter$delegate.getValue();
    }

    @NotNull
    public Map<String, Object> apply(@NotNull FlutterCart flutterCart) {
        Intrinsics.checkNotNullParameter(flutterCart, "source");
        Object jsonValue = getCartAdapter().toJsonValue(flutterCart);
        if (jsonValue != null) {
            return (Map) jsonValue;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
    }
}
