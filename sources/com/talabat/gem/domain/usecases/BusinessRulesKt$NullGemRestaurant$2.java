package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.Rating;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BusinessRulesKt$NullGemRestaurant$2 extends Lambda implements Function0<GemRestaurant> {
    public static final BusinessRulesKt$NullGemRestaurant$2 INSTANCE = new BusinessRulesKt$NullGemRestaurant$2();

    public BusinessRulesKt$NullGemRestaurant$2() {
        super(0);
    }

    @NotNull
    public final GemRestaurant invoke() {
        return new GemRestaurant(-1, (String) null, (String) null, (Boolean) null, (String) null, (Rating) null, (Float) null, 0, (String) null, (Integer) null, (Double) null, (String) null, (Restaurant) null, (Integer) null, (Double) null, (Integer) null, (Float) null, (String) null, 262142, (DefaultConstructorMarker) null);
    }
}
