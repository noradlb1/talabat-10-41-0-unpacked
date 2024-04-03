package com.talabat.feature.activecarts.domain.channel;

import com.talabat.feature.activecarts.domain.model.BasketType;
import datamodels.Restaurant;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\fJ&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler;", "", "setUp", "", "engine", "Lio/flutter/embedding/engine/FlutterEngine;", "methodHandlerCallback", "Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler$MethodHandlerCallback;", "basketTypes", "", "Lcom/talabat/feature/activecarts/domain/model/BasketType;", "terminate", "MethodHandlerCallback", "com_talabat_feature_active-carts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ActiveCartsMethodCallHandler {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/activecarts/domain/channel/ActiveCartsMethodCallHandler$MethodHandlerCallback;", "", "navigateToFoodBasket", "", "navigateToQcommerceBasket", "restaurant", "Ldatamodels/Restaurant;", "com_talabat_feature_active-carts_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface MethodHandlerCallback {
        void navigateToFoodBasket();

        void navigateToQcommerceBasket(@NotNull Restaurant restaurant);
    }

    void setUp(@NotNull FlutterEngine flutterEngine, @NotNull MethodHandlerCallback methodHandlerCallback, @NotNull Set<? extends BasketType> set);

    void terminate();
}
