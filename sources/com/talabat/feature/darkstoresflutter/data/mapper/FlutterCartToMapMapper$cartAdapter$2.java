package com.talabat.feature.darkstoresflutter.data.mapper;

import com.squareup.moshi.JsonAdapter;
import com.talabat.feature.darkstoresflutter.data.model.FlutterCart;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstoresflutter/data/model/FlutterCart;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FlutterCartToMapMapper$cartAdapter$2 extends Lambda implements Function0<JsonAdapter<FlutterCart>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FlutterCartToMapMapper f58496g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlutterCartToMapMapper$cartAdapter$2(FlutterCartToMapMapper flutterCartToMapMapper) {
        super(0);
        this.f58496g = flutterCartToMapMapper;
    }

    public final JsonAdapter<FlutterCart> invoke() {
        return this.f58496g.moshi.adapter(FlutterCart.class);
    }
}
