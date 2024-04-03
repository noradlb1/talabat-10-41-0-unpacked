package com.talabat.filters.presentation;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Button;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.filters.R;
import com.talabat.talabatcommon.views.twolinesbutton.TwoLinesButton;
import datamodels.filters.SelectableFilter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Ldatamodels/filters/SelectableFilter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FiltersFragment$observeFilters$1$1 extends Lambda implements Function1<List<? extends SelectableFilter>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FiltersFragment f59615g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FiltersViewModel f59616h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FiltersFragment$observeFilters$1$1(FiltersFragment filtersFragment, FiltersViewModel filtersViewModel) {
        super(1);
        this.f59615g = filtersFragment;
        this.f59616h = filtersViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<SelectableFilter>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable List<SelectableFilter> list) {
        int i11;
        String str;
        Resources resources;
        if (ITalabatExperiment.DefaultImpls.getBooleanVariant$default(TalabatExperiment.INSTANCE, TalabatExperimentConstants.COUNTERS_AND_NEW_DESIGN_FILTERS_CUISINES, false, (TalabatExperimentDataSourceStrategy) null, 4, (Object) null)) {
            Button button = (Button) this.f59615g._$_findCachedViewById(R.id.doneBtn);
            if (button != null) {
                TwoLinesButton twoLinesButton = (TwoLinesButton) button;
                List value = this.f59616h.getFilters().getValue();
                if (value != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Object next : value) {
                        if (((SelectableFilter) next).isOn()) {
                            arrayList.add(next);
                        }
                    }
                    i11 = arrayList.size();
                } else {
                    i11 = 0;
                }
                String str2 = "";
                if (i11 > 0) {
                    Context context = this.f59615g.getContext();
                    if (context == null || (resources = context.getResources()) == null) {
                        str = null;
                    } else {
                        str = resources.getQuantityString(com.talabat.localization.R.plurals.numberOfFiltersSelected, i11, new Object[]{Integer.valueOf(i11)});
                    }
                    if (str != null) {
                        str2 = str;
                    }
                    twoLinesButton.setSecondLineText(str2);
                    return;
                }
                twoLinesButton.setSecondLineText(str2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.talabatcommon.views.twolinesbutton.TwoLinesButton");
        }
    }
}
