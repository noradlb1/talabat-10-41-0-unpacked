package com.talabat.talabatlife.ui.cuisine;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.talabat.talabatcore.BaseActivity;
import com.talabat.talabatcore.R;
import com.talabat.talabatlife.ui.cuisine.CuisineFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\n"}, d2 = {"Lcom/talabat/talabatlife/ui/cuisine/CuisineActivity;", "Lcom/talabat/talabatcore/BaseActivity;", "()V", "fragment", "Lcom/talabat/talabatlife/ui/cuisine/CuisineFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CuisineActivity extends BaseActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static ICuisineRepository cuisineRepository;
    /* access modifiers changed from: private */
    @Nullable
    public static CuisineDisplayModel selectedCuisine;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatlife/ui/cuisine/CuisineActivity$Companion;", "", "()V", "cuisineRepository", "Lcom/talabat/talabatlife/ui/cuisine/ICuisineRepository;", "selectedCuisine", "Lcom/talabat/talabatlife/ui/cuisine/CuisineDisplayModel;", "startActivity", "", "context", "Landroid/content/Context;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void startActivity$default(Companion companion, Context context, CuisineDisplayModel cuisineDisplayModel, ICuisineRepository iCuisineRepository, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                cuisineDisplayModel = null;
            }
            companion.startActivity(context, cuisineDisplayModel, iCuisineRepository);
        }

        public final void startActivity(@NotNull Context context, @Nullable CuisineDisplayModel cuisineDisplayModel, @NotNull ICuisineRepository iCuisineRepository) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(iCuisineRepository, "cuisineRepository");
            CuisineActivity.selectedCuisine = cuisineDisplayModel;
            CuisineActivity.cuisineRepository = iCuisineRepository;
            context.startActivity(new Intent(context, CuisineActivity.class));
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setLayout(-1, -1);
        ((FrameLayout) findViewById(R.id.fragmentContainer)).setBackgroundColor(getResources().getColor(17170445));
    }

    @NotNull
    public CuisineFragment fragment() {
        CuisineFragment.Companion companion = CuisineFragment.Companion;
        CuisineDisplayModel cuisineDisplayModel = selectedCuisine;
        ICuisineRepository iCuisineRepository = cuisineRepository;
        if (iCuisineRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cuisineRepository");
            iCuisineRepository = null;
        }
        return companion.getInstance(cuisineDisplayModel, iCuisineRepository);
    }
}
