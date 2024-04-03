package com.talabat.cuisines.presentation;

import androidx.lifecycle.MutableLiveData;
import com.talabat.cuisines.domain.SelectableCuisine;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CuisinesViewModelKt$initialize$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CuisinesViewModel f56068g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CuisinesViewModelKt$initialize$2(CuisinesViewModel cuisinesViewModel) {
        super(0);
        this.f56068g = cuisinesViewModel;
    }

    public final void invoke() {
        MutableLiveData<List<SelectableCuisine>> cuisines = this.f56068g.getCuisines();
        List invoke = this.f56068g.getRequestCuisinesUseCase().invoke();
        if (invoke == null) {
            invoke = CollectionsKt__CollectionsKt.emptyList();
        }
        cuisines.setValue(invoke);
    }
}
