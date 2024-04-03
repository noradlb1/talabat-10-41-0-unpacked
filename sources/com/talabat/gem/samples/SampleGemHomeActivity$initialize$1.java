package com.talabat.gem.samples;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.gem.adapters.R;
import com.talabat.talabatcommon.extension.ViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleGemHomeActivity$initialize$1 extends Lambda implements Function1<AppCompatActivity, Unit> {
    public static final SampleGemHomeActivity$initialize$1 INSTANCE = new SampleGemHomeActivity$initialize$1();

    public SampleGemHomeActivity$initialize$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppCompatActivity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$withLayout");
        int i11 = R.id.homeRecyclerView;
        ((RecyclerView) appCompatActivity.findViewById(i11)).setLayoutManager(new LinearLayoutManager(appCompatActivity));
        ((RecyclerView) appCompatActivity.findViewById(i11)).setAdapter(new HomeAdapter(appCompatActivity));
        ((RecyclerView) appCompatActivity.findViewById(i11)).setNestedScrollingEnabled(false);
        Button button = (Button) appCompatActivity.findViewById(R.id.openRestaurantsButton);
        Intrinsics.checkNotNullExpressionValue(button, "openRestaurantsButton");
        ViewKt.invoke(button, new Function1<View, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((View) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "$this$invoke");
                RouterKt.navigate$default(appCompatActivity, Reflection.getOrCreateKotlinClass(SampleGemRestaurantsActivity.class), 0, 0.0d, 4, (Object) null);
            }
        });
    }
}
