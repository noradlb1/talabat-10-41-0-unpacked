package com.talabat.darkstores.feature.product.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.darkstores.R;
import com.talabat.feature.darkstorescart.data.model.ProductExtendedInfo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/feature/product/views/ProductStoreAtFragment;", "Landroidx/fragment/app/Fragment;", "storeAt", "Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$StoredAt;", "(Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$StoredAt;)V", "getStoreAt", "()Lcom/talabat/feature/darkstorescart/data/model/ProductExtendedInfo$StoredAt;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProductStoreAtFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @NotNull
    private final ProductExtendedInfo.StoredAt storeAt;

    public ProductStoreAtFragment(@NotNull ProductExtendedInfo.StoredAt storedAt) {
        Intrinsics.checkNotNullParameter(storedAt, "storeAt");
        this.storeAt = storedAt;
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    @NotNull
    public final ProductExtendedInfo.StoredAt getStoreAt() {
        return this.storeAt;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "ProductStoreAtFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ProductStoreAtFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.product_store_at_view, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…t_view, container, false)");
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        ((TextView) _$_findCachedViewById(R.id.txt_stored_at_description)).setText(this.storeAt.getDescription());
    }
}
