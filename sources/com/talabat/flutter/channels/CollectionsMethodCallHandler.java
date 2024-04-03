package com.talabat.flutter.channels;

import com.talabat.flutter.VendorListSearchFlutterActivity;
import com.talabat.flutter.domain.vendorcollections.VendorCollection;
import com.talabat.flutter.domain.vendorcollections.VendorCollectionKt;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extentions.StringUtils;
import datamodels.QuickFilter;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J(\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/flutter/channels/CollectionsMethodCallHandler;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "callback", "Lcom/talabat/flutter/channels/ICollectionsMethodCallback;", "handleGetVendorCollection", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "quickFilters", "Ljava/util/ArrayList;", "Ldatamodels/QuickFilter;", "handleVendorCollectionSelected", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "onMethodCall", "setCallback", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionsMethodCallHandler implements MethodChannel.MethodCallHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String GET_VENDOR_COLLECTION = "getVendorCollections";
    @NotNull
    public static final String VENDOR_COLLECTIONS_SELECTED = "vendorCollectionsSelected";
    private ICollectionsMethodCallback callback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/flutter/channels/CollectionsMethodCallHandler$Companion;", "", "()V", "GET_VENDOR_COLLECTION", "", "VENDOR_COLLECTIONS_SELECTED", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void a(CollectionsMethodCallHandler collectionsMethodCallHandler, MethodChannel.Result result, ArrayList<QuickFilter> arrayList, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            arrayList = GlobalDataModel.collections;
            Intrinsics.checkNotNullExpressionValue(arrayList, "collections");
        }
        collectionsMethodCallHandler.handleGetVendorCollection(result, arrayList);
    }

    public static /* synthetic */ void b(CollectionsMethodCallHandler collectionsMethodCallHandler, MethodCall methodCall, MethodChannel.Result result, ArrayList<QuickFilter> arrayList, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            arrayList = GlobalDataModel.collections;
            Intrinsics.checkNotNullExpressionValue(arrayList, "collections");
        }
        collectionsMethodCallHandler.handleVendorCollectionSelected(methodCall, result, arrayList);
    }

    private final void handleGetVendorCollection(MethodChannel.Result result, ArrayList<QuickFilter> arrayList) {
        int i11;
        ArrayList<QuickFilter> arrayList2 = new ArrayList<>();
        Iterator<T> it = arrayList.iterator();
        while (true) {
            boolean z11 = false;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (((QuickFilter) next).getId() != null) {
                z11 = true;
            }
            if (z11) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
        for (QuickFilter quickFilter : arrayList2) {
            Integer id2 = quickFilter.getId();
            if (id2 != null) {
                i11 = id2.intValue();
            } else {
                i11 = 0;
            }
            String widgetName = quickFilter.getWidgetName();
            String str = "";
            if (widgetName == null) {
                widgetName = str;
            }
            String vendorImage = StringUtils.vendorImage(quickFilter.getSmallIcon());
            String colorCode = quickFilter.getColorCode();
            if (colorCode != null) {
                str = colorCode;
            }
            arrayList3.add(VendorCollectionKt.toFlutterMap(new VendorCollection(i11, widgetName, vendorImage, str)));
        }
        result.success(MapsKt__MapsJVMKt.mapOf(TuplesKt.to("collections", arrayList3)));
    }

    private final void handleVendorCollectionSelected(MethodCall methodCall, MethodChannel.Result result, ArrayList<QuickFilter> arrayList) {
        ICollectionsMethodCallback iCollectionsMethodCallback;
        T t11;
        boolean z11;
        Object obj = methodCall.arguments;
        if (obj != null) {
            HashMap hashMap = (HashMap) obj;
            if (hashMap.containsKey(VendorListSearchFlutterActivity.COLLECTION_ID_KEY)) {
                Object obj2 = hashMap.get(VendorListSearchFlutterActivity.COLLECTION_ID_KEY);
                if (obj2 != null) {
                    int intValue = ((Integer) obj2).intValue();
                    Iterator<T> it = arrayList.iterator();
                    while (true) {
                        iCollectionsMethodCallback = null;
                        if (!it.hasNext()) {
                            t11 = null;
                            break;
                        }
                        t11 = it.next();
                        Integer id2 = ((QuickFilter) t11).getId();
                        if (id2 != null && id2.intValue() == intValue) {
                            z11 = true;
                            continue;
                        } else {
                            z11 = false;
                            continue;
                        }
                        if (z11) {
                            break;
                        }
                    }
                    QuickFilter quickFilter = (QuickFilter) t11;
                    if (quickFilter != null) {
                        ICollectionsMethodCallback iCollectionsMethodCallback2 = this.callback;
                        if (iCollectionsMethodCallback2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("callback");
                        } else {
                            iCollectionsMethodCallback = iCollectionsMethodCallback2;
                        }
                        iCollectionsMethodCallback.openCollectionDetailsScreen(quickFilter);
                        result.success(Unit.INSTANCE);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, "methodCall");
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) GET_VENDOR_COLLECTION)) {
            a(this, result, (ArrayList) null, 2, (Object) null);
        } else if (Intrinsics.areEqual((Object) str, (Object) VENDOR_COLLECTIONS_SELECTED)) {
            b(this, methodCall, result, (ArrayList) null, 4, (Object) null);
        }
    }

    public final void setCallback(@NotNull ICollectionsMethodCallback iCollectionsMethodCallback) {
        Intrinsics.checkNotNullParameter(iCollectionsMethodCallback, "callback");
        this.callback = iCollectionsMethodCallback;
    }
}
