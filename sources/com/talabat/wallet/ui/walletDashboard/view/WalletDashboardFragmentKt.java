package com.talabat.wallet.ui.walletDashboard.view;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n*\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"APP_BAR_DATE_OUTPUT_FORMAT", "", "HEADER_VIEW_TYPE", "", "MAPPER_KEY_DATE_FORMAT", "OUTPUT_DATE_FORMAT_FOR_EXPIRING_DATE", "REQUEST_CODE_VALUE", "USER_PREFERENCES_NAME", "WALLET_SCREEN", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "dataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class WalletDashboardFragmentKt {
    @NotNull
    public static final String APP_BAR_DATE_OUTPUT_FORMAT = "LLLL";
    public static final int HEADER_VIEW_TYPE = 2;
    @NotNull
    public static final String MAPPER_KEY_DATE_FORMAT = "yyyy-MM";
    @NotNull
    public static final String OUTPUT_DATE_FORMAT_FOR_EXPIRING_DATE = "LLLL dd, yyyy";
    public static final int REQUEST_CODE_VALUE = 2;
    @NotNull
    private static final String USER_PREFERENCES_NAME = "user_preferences_wallet";
    @NotNull
    public static final String WALLET_SCREEN = "wallet";

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f12759a = {Reflection.property1(new PropertyReference1Impl(WalletDashboardFragmentKt.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1))};
    @NotNull
    private static final ReadOnlyProperty dataStore$delegate = PreferenceDataStoreDelegateKt.preferencesDataStore$default(USER_PREFERENCES_NAME, (ReplaceFileCorruptionHandler) null, (Function1) null, (CoroutineScope) null, 14, (Object) null);

    /* access modifiers changed from: private */
    public static final DataStore<Preferences> getDataStore(Context context) {
        return (DataStore) dataStore$delegate.getValue(context, f12759a[0]);
    }
}
