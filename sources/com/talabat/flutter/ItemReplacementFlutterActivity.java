package com.talabat.flutter;

import android.content.Intent;
import android.view.View;
import com.talabat.core.navigation.domain.screen.itemreplacement.ItemReplacementScreen;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/talabat/flutter/ItemReplacementFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "()V", "getRoute", "", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemReplacementFlutterActivity extends TalabatFlutterFragmentActivity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String EVENT_ORIGIN = "eventOrigin";
    @NotNull
    private static final String ITEM_REPLACEMENT_PATH = "qcommerce/orders/%s/item-replacement";
    @NotNull
    private static final String ITEM_REPLACEMENT_ROUTE = "item-replacement";
    @NotNull
    private static final String ORDERS_ROUTE = "orders";
    @NotNull
    private static final String Q_COMMERCE_ROUTE = "qcommerce";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/flutter/ItemReplacementFlutterActivity$Companion;", "", "()V", "EVENT_ORIGIN", "", "ITEM_REPLACEMENT_PATH", "ITEM_REPLACEMENT_ROUTE", "ORDERS_ROUTE", "Q_COMMERCE_ROUTE", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ItemReplacementFlutterActivity() {
        super((RemoteConfiguration) null, 1, (DefaultConstructorMarker) null);
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

    @NotNull
    public String getRoute() {
        ItemReplacementScreen.ItemReplacementData itemReplacementData;
        Intent intent = getIntent();
        if (!(intent == null || (itemReplacementData = (ItemReplacementScreen.ItemReplacementData) intent.getParcelableExtra("navigatorData")) == null)) {
            StringBuilder sb2 = new StringBuilder();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(ITEM_REPLACEMENT_PATH, Arrays.copyOf(new Object[]{itemReplacementData.getOrderId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            sb2.append(format);
            sb2.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
            sb2.append("eventOrigin=");
            sb2.append(itemReplacementData.getEventOrigin());
            String sb3 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply(builderAction).toString()");
            if (sb3 != null) {
                return sb3;
            }
        }
        throw new IllegalArgumentException("Item replacement data can't be null");
    }
}
