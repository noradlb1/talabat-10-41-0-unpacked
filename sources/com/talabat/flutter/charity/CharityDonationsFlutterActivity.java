package com.talabat.flutter.charity;

import android.view.View;
import com.talabat.flutter.utils.FlutterRoutes;
import com.talabat.fluttercore.data.TalabatFlutterEntryPoints;
import com.talabat.fluttercore.presentation.TalabatFlutterFragmentActivity;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/flutter/charity/CharityDonationsFlutterActivity;", "Lcom/talabat/fluttercore/presentation/TalabatFlutterFragmentActivity;", "()V", "getEntryPoint", "Lcom/talabat/fluttercore/data/TalabatFlutterEntryPoints;", "getRoute", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CharityDonationsFlutterActivity extends TalabatFlutterFragmentActivity {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    public CharityDonationsFlutterActivity() {
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
    public TalabatFlutterEntryPoints getEntryPoint() {
        return TalabatFlutterEntryPoints.DEEPLINK;
    }

    @NotNull
    public String getRoute() {
        return FlutterRoutes.CHARITY_DONATION_ROUTE;
    }
}
