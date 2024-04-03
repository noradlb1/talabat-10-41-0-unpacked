package com.talabat.gem.samples;

import com.talabat.gem.domain.entities.GemRestaurant;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleDataSourcesAdapter$selectedGemRestaurant$2 extends Lambda implements Function0<BehaviorSubject<GemRestaurant>> {
    public static final SampleDataSourcesAdapter$selectedGemRestaurant$2 INSTANCE = new SampleDataSourcesAdapter$selectedGemRestaurant$2();

    public SampleDataSourcesAdapter$selectedGemRestaurant$2() {
        super(0);
    }

    @NotNull
    public final BehaviorSubject<GemRestaurant> invoke() {
        return BehaviorSubject.create();
    }
}
