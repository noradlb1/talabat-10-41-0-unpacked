package com.talabat.filters.navigation;

import android.widget.TextView;
import android.widget.Toast;
import com.talabat.filters.R;
import com.talabat.talabatcommon.views.StartForResultCallbacks;
import datamodels.filters.Selectables;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lcom/talabat/talabatcommon/views/StartForResultCallbacks;", "Ldatamodels/filters/Selectables;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleFiltersActivity$onCreate$3 extends Lambda implements Function1<StartForResultCallbacks<Selectables>, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SampleFiltersActivity f59593g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SampleFiltersActivity$onCreate$3(SampleFiltersActivity sampleFiltersActivity) {
        super(1);
        this.f59593g = sampleFiltersActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StartForResultCallbacks<Selectables>) (StartForResultCallbacks) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull StartForResultCallbacks<Selectables> startForResultCallbacks) {
        Intrinsics.checkNotNullParameter(startForResultCallbacks, "$this$invoke");
        StartForResultCallbacks<Selectables> on2 = startForResultCallbacks.getOn();
        final SampleFiltersActivity sampleFiltersActivity = this.f59593g;
        on2.success(new Function1<Selectables, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Selectables) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Selectables selectables) {
                ((TextView) sampleFiltersActivity._$_findCachedViewById(R.id.colectionsSelectionTextView)).setText(sampleFiltersActivity.selectionText(selectables));
            }
        });
        StartForResultCallbacks<Selectables> on3 = startForResultCallbacks.getOn();
        final SampleFiltersActivity sampleFiltersActivity2 = this.f59593g;
        on3.cancelled(new Function0<Unit>() {
            public final void invoke() {
                Toast.makeText(sampleFiltersActivity2.getApplicationContext(), "collections filter cancelled", 1).show();
            }
        });
    }
}
