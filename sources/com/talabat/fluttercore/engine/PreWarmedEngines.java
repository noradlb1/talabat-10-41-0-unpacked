package com.talabat.fluttercore.engine;

import android.content.Context;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0004J\u0014\u0010\u0015\u001a\u00020\u000f*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/fluttercore/engine/PreWarmedEngines;", "", "()V", "ENGINE_FOR_ADDRESS_FORM", "", "ENGINE_FOR_BNPL_CHECKOUT", "ENGINE_FOR_BNPL_DASHBOARD", "ENGINE_FOR_HOME_OF_OFFERS", "ENGINE_FOR_SEARCH", "ENGINE_FOR_VENDOR_COLLECTIONS", "ENGINE_FOR_WALLET_ADD_CARD", "ENGINE_FOR_WALLET_DASHBOARD", "ENGINE_GROCERY_HOME", "ENGINE_QCOMMERCE", "getWarmedUpEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "context", "Landroid/content/Context;", "engineId", "removeWarmedUpEngine", "", "createAndCacheEngineFor", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreWarmedEngines {
    @NotNull
    public static final String ENGINE_FOR_ADDRESS_FORM = "engine_for_address_form";
    @NotNull
    public static final String ENGINE_FOR_BNPL_CHECKOUT = "engine_for_bnpl_checkout";
    @NotNull
    public static final String ENGINE_FOR_BNPL_DASHBOARD = "engine_for_bnpl_dashboard";
    @NotNull
    public static final String ENGINE_FOR_HOME_OF_OFFERS = "engine_for_home_of_offers";
    @NotNull
    public static final String ENGINE_FOR_SEARCH = "engine_for_search";
    @NotNull
    public static final String ENGINE_FOR_VENDOR_COLLECTIONS = "engine_for_vendor_collections";
    @NotNull
    public static final String ENGINE_FOR_WALLET_ADD_CARD = "engine_for_wallet_add_card";
    @NotNull
    public static final String ENGINE_FOR_WALLET_DASHBOARD = "engine_for_wallet_dashboard";
    @NotNull
    public static final String ENGINE_GROCERY_HOME = "engine_for_grocery_home";
    @NotNull
    public static final String ENGINE_QCOMMERCE = "engine_for_qcommerce";
    @NotNull
    public static final PreWarmedEngines INSTANCE = new PreWarmedEngines();

    private PreWarmedEngines() {
    }

    private final FlutterEngine createAndCacheEngineFor(Context context, String str) {
        FlutterEngine flutterEngine = new FlutterEngine(context);
        FlutterEngineCache.getInstance().put(str, flutterEngine);
        return flutterEngine;
    }

    @NotNull
    public final FlutterEngine getWarmedUpEngine(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "engineId");
        FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get(str);
        if (flutterEngine == null) {
            return createAndCacheEngineFor(context, str);
        }
        return flutterEngine;
    }

    public final void removeWarmedUpEngine(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "engineId");
        FlutterEngineCache.getInstance().remove(str);
    }
}
