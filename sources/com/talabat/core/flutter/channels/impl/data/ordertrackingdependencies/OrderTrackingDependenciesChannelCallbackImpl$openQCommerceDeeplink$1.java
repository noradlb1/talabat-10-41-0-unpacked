package com.talabat.core.flutter.channels.impl.data.ordertrackingdependencies;

import android.content.Intent;
import android.net.Uri;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Typography;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroid/content/Intent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingDependenciesChannelCallbackImpl$openQCommerceDeeplink$1 extends Lambda implements Function1<Intent, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f55924g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderTrackingDependenciesChannelCallbackImpl$openQCommerceDeeplink$1(String str) {
        super(1);
        this.f55924g = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Intent intent) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(intent, "$this$navigateTo");
        String query = Uri.parse(this.f55924g).getQuery();
        if (query == null) {
            query = "";
        }
        char[] cArr = {Typography.amp};
        ArrayList<List> arrayList = new ArrayList<>();
        for (String split$default : StringsKt__StringsKt.split$default((CharSequence) query, cArr, false, 0, 6, (Object) null)) {
            List split$default2 = StringsKt__StringsKt.split$default((CharSequence) split$default, new char[]{SignatureVisitor.INSTANCEOF}, false, 0, 6, (Object) null);
            if (!(split$default2.size() == 2)) {
                split$default2 = null;
            }
            if (split$default2 != null) {
                arrayList.add(split$default2);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (List list : arrayList) {
            Pair pair = TuplesKt.to(list.get(0), list.get(1));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        String str = (String) linkedHashMap.get("t");
        if (!(str == null || (intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str)) == null)) {
            intent.putExtra("deeplinkType", intOrNull.intValue());
        }
        String str2 = (String) linkedHashMap.get("i");
        if (str2 != null) {
            intent.putExtra("deeplinkInfo", str2);
        }
        String str3 = (String) linkedHashMap.get("s");
        if (str3 != null) {
            intent.putExtra("isDarkStore", Intrinsics.areEqual((Object) str3, (Object) "ds"));
            intent.putExtra("isMigrated", Intrinsics.areEqual((Object) str3, (Object) "mv"));
        }
        String str4 = (String) linkedHashMap.get("bid");
        if (str4 != null) {
            intent.putExtra("branchId", str4);
        }
        String str5 = (String) linkedHashMap.get(InstabugDbContract.ExperimentsEntry.COLUMN_EXPERIMENT);
        if (str5 != null) {
            intent.putExtra(InstabugDbContract.ExperimentsEntry.COLUMN_EXPERIMENT, str5);
        }
        intent.putExtra("eventOrigin", "looking_glass");
    }
}
