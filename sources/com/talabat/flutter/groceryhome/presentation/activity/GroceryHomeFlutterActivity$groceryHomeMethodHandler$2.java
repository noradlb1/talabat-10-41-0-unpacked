package com.talabat.flutter.groceryhome.presentation.activity;

import com.talabat.flutter.groceryhome.presentation.handler.GroceryHomeMethodHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandler;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GroceryHomeFlutterActivity$groceryHomeMethodHandler$2 extends Lambda implements Function0<GroceryHomeMethodHandler> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GroceryHomeFlutterActivity f59766g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroceryHomeFlutterActivity$groceryHomeMethodHandler$2(GroceryHomeFlutterActivity groceryHomeFlutterActivity) {
        super(0);
        this.f59766g = groceryHomeFlutterActivity;
    }

    @NotNull
    public final GroceryHomeMethodHandler invoke() {
        return this.f59766g.createGroceryHomeMethodHandler();
    }
}
