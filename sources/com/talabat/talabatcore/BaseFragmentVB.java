package com.talabat.talabatcore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005B1\u0012*\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00010\u0007j\b\u0012\u0004\u0012\u00028\u0001`\u000b¢\u0006\u0002\u0010\fJ$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0012\u0010\r\u001a\u0004\u0018\u00018\u0001X\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0011\u0010\u000f\u001a\u00028\u00018F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R2\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00010\u0007j\b\u0012\u0004\u0012\u00028\u0001`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/talabat/talabatcore/BaseFragmentVB;", "VM", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/talabat/talabatcore/BaseFragment;", "inflate", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "Lcom/talabat/talabatcore/Inflate;", "(Lkotlin/jvm/functions/Function3;)V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "onCreateView", "Landroid/view/View;", "inflater", "container", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseFragmentVB extends BaseFragment {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    private ViewBinding _binding;
    @NotNull
    private final Function3<LayoutInflater, ViewGroup, Boolean, ViewBinding> inflate;

    public BaseFragmentVB(@NotNull Function3<? super LayoutInflater, ? super ViewGroup, ? super Boolean, ViewBinding> function3) {
        Intrinsics.checkNotNullParameter(function3, "inflate");
        this.inflate = function3;
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
    public final ViewBinding getBinding() {
        ViewBinding viewBinding = this._binding;
        Intrinsics.checkNotNull(viewBinding);
        return viewBinding;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = this.inflate.invoke(layoutInflater, viewGroup, Boolean.FALSE);
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
        _$_clearFindViewByIdCache();
    }
}
