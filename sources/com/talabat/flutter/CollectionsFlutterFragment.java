package com.talabat.flutter;

import android.content.Intent;
import android.view.View;
import com.talabat.collectiondetails.ui.quickfilter.QuickFilterRestaurantsActivity;
import com.talabat.collectiondetails.ui.quickfilter.UnsubscribeCollectionActivity;
import com.talabat.core.flutter.channels.domain.MethodChannels;
import com.talabat.flutter.channels.CollectionsMethodCallHandler;
import com.talabat.flutter.channels.ICollectionsMethodCallback;
import com.talabat.flutter.utils.FlutterRoutes;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.engine.PreWarmedEngines;
import com.talabat.fluttercore.presentation.PreWarmedFlutterFragment;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import datamodels.QuickFilter;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/talabat/flutter/CollectionsFlutterFragment;", "Lcom/talabat/fluttercore/presentation/PreWarmedFlutterFragment;", "Lcom/talabat/flutter/channels/ICollectionsMethodCallback;", "()V", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getRoute", "", "openCollectionDetailsScreen", "", "collection", "Ldatamodels/QuickFilter;", "setUpCollectionsChannel", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "setUpExtraChannels", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionsFlutterFragment extends PreWarmedFlutterFragment implements ICollectionsMethodCallback {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    public CollectionsFlutterFragment() {
        super(PreWarmedEngines.ENGINE_FOR_VENDOR_COLLECTIONS, (RemoteConfiguration) null, 2, (DefaultConstructorMarker) null);
    }

    private final void setUpCollectionsChannel(FlutterEngine flutterEngine) {
        MethodChannel methodChannel = new MethodChannel(flutterEngine.getDartExecutor(), MethodChannels.VENDOR_COLLECTIONS_CHANNEL);
        CollectionsMethodCallHandler collectionsMethodCallHandler = new CollectionsMethodCallHandler();
        collectionsMethodCallHandler.setCallback(this);
        methodChannel.setMethodCallHandler(collectionsMethodCallHandler);
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
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.VENDOR_LIST_COLLECTIONS_WIDGET;
    }

    @NotNull
    public String getRoute() {
        return FlutterRoutes.VENDOR_COLLECTIONS;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void openCollectionDetailsScreen(@NotNull QuickFilter quickFilter) {
        Intrinsics.checkNotNullParameter(quickFilter, GemAccessor.COMPONENT_COLLECTION);
        Intent intent = new Intent(getActivity(), UnsubscribeCollectionActivity.class);
        intent.putExtra("ARG_QUICK_FILTER", quickFilter);
        intent.putExtra(QuickFilterRestaurantsActivity.ARG_IS_DIRECTLY_FROM_HOME, false);
        requireActivity().startActivity(intent);
    }

    public void setUpExtraChannels(@NotNull FlutterEngine flutterEngine) {
        Intrinsics.checkNotNullParameter(flutterEngine, "flutterEngine");
        super.setUpExtraChannels(flutterEngine);
        setUpCollectionsChannel(flutterEngine);
    }
}
