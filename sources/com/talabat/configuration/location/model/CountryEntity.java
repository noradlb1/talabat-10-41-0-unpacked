package com.talabat.configuration.location.model;

import com.google.android.exoplayer2.C;
import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b_\b\b\u0018\u00002\u00020\u0001Bó\u0002\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\n\u0012\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010%J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010BJ\u0010\u0010I\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010J\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010K\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010L\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010M\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010N\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010O\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010P\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010Q\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010R\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010BJ\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010Z\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010[\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010]\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010BJ\u0010\u0010b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,J\u0011\u0010c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010,Jü\u0002\u0010f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0003\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010gJ\u0013\u0010h\u001a\u00020\n2\b\u0010i\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010j\u001a\u00020\u0003HÖ\u0001J\t\u0010k\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010'\u001a\u0004\b(\u0010)R \u0010\u001d\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0010\n\u0002\u0010-\u0012\u0004\b*\u0010'\u001a\u0004\b+\u0010,R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010'\u001a\u0004\b/\u0010)R \u0010\u001f\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0010\n\u0002\u0010-\u0012\u0004\b0\u0010'\u001a\u0004\b1\u0010,R \u0010 \u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0010\n\u0002\u0010-\u0012\u0004\b2\u0010'\u001a\u0004\b3\u0010,R \u0010!\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0010\n\u0002\u0010-\u0012\u0004\b4\u0010'\u001a\u0004\b5\u0010,R\u001e\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010'\u001a\u0004\b7\u0010)R \u0010#\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0010\n\u0002\u0010-\u0012\u0004\b8\u0010'\u001a\u0004\b9\u0010,R\u001e\u0010$\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010'\u001a\u0004\b;\u0010)R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b<\u0010,R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010)R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010)R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010C\u001a\u0004\bA\u0010BR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b\u000f\u0010,R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b\u0010\u0010,R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b\u0011\u0010,R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b\u0012\u0010,R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b\u0013\u0010,R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b\u0014\u0010,R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b\u0015\u0010,R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b\u0016\u0010,R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b\u0017\u0010,R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b\u0018\u0010,R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b\u0019\u0010,R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b\u001a\u0010,R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010)R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010C\u001a\u0004\bE\u0010BR\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010C\u001a\u0004\bF\u0010BR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010)¨\u0006l"}, d2 = {"Lcom/talabat/configuration/location/model/CountryEntity;", "", "id", "", "name", "", "twoLetterCode", "currencyCode", "numberOfDecimalPlaces", "canShowCollectionWidget", "", "cities", "", "Lcom/talabat/configuration/location/model/CityEntity;", "flagResId", "isAmexAvailable", "isCity", "isComplianceEnabled", "isContactlessPaymentEnabled", "isDefault", "isGoGreen", "isI18nSupported", "isMapEnabled", "isTalabatCreditEnabled", "isTalabatPayEnabled", "isTokenizationEnabled", "isVisaCheckoutAvailable", "tokenizationProvider", "_aico", "_apa", "_appTheme", "_bco", "_isCheckoutMigrationEnabled", "_isCountryEnabled", "_sl", "_uniTrac", "_url", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "get_aico$annotations", "()V", "get_aico", "()Ljava/lang/String;", "get_apa$annotations", "get_apa", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "get_appTheme$annotations", "get_appTheme", "get_bco$annotations", "get_bco", "get_isCheckoutMigrationEnabled$annotations", "get_isCheckoutMigrationEnabled", "get_isCountryEnabled$annotations", "get_isCountryEnabled", "get_sl$annotations", "get_sl", "get_uniTrac$annotations", "get_uniTrac", "get_url$annotations", "get_url", "getCanShowCollectionWidget", "getCities", "()Ljava/util/List;", "getCurrencyCode", "getFlagResId", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "getNumberOfDecimalPlaces", "getTokenizationProvider", "getTwoLetterCode", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/talabat/configuration/location/model/CountryEntity;", "equals", "other", "hashCode", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CountryEntity {
    @SerializedName("aico")
    @Nullable
    private final String _aico;
    @SerializedName("apa")
    @Nullable
    private final Boolean _apa;
    @SerializedName("apptheme")
    @Nullable
    private final String _appTheme;
    @SerializedName("bco")
    @Nullable
    private final Boolean _bco;
    @SerializedName("isCheckoutMigrationEnabled")
    @Nullable
    private final Boolean _isCheckoutMigrationEnabled;
    @SerializedName("iscountryenabled")
    @Nullable
    private final Boolean _isCountryEnabled;
    @SerializedName("sl")
    @Nullable
    private final String _sl;
    @SerializedName("uniTrac")
    @Nullable
    private final Boolean _uniTrac;
    @SerializedName("url")
    @Nullable
    private final String _url;
    @SerializedName("cwa")
    @Nullable
    private final Boolean canShowCollectionWidget;
    @SerializedName("cities")
    @Nullable
    private final List<CityEntity> cities;
    @SerializedName("curs")
    @Nullable
    private final String currencyCode;
    @SerializedName("flag")
    @Nullable
    private final String flagResId;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f55776id;
    @SerializedName("amexAvail")
    @Nullable
    private final Boolean isAmexAvailable;
    @SerializedName("iscity")
    @Nullable
    private final Boolean isCity;
    @SerializedName("iscompliance")
    @Nullable
    private final Boolean isComplianceEnabled;
    @SerializedName("irc")
    @Nullable
    private final Boolean isContactlessPaymentEnabled;
    @SerializedName("issel")
    @Nullable
    private final Boolean isDefault;
    @SerializedName("isGoGreen")
    @Nullable
    private final Boolean isGoGreen;
    @SerializedName("icc")
    @Nullable
    private final Boolean isI18nSupported;
    @SerializedName("im")
    @Nullable
    private final Boolean isMapEnabled;
    @SerializedName("itce")
    @Nullable
    private final Boolean isTalabatCreditEnabled;
    @SerializedName("tpay")
    @Nullable
    private final Boolean isTalabatPayEnabled;
    @SerializedName("ht")
    @Nullable
    private final Boolean isTokenizationEnabled;
    @SerializedName("vca")
    @Nullable
    private final Boolean isVisaCheckoutAvailable;
    @SerializedName("na")
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f55777name;
    @SerializedName("dno")
    @Nullable
    private final Integer numberOfDecimalPlaces;
    @SerializedName("tp")
    @Nullable
    private final Integer tokenizationProvider;
    @SerializedName("cd")
    @Nullable
    private final String twoLetterCode;

    public CountryEntity() {
        this((Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Boolean) null, (List) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, (String) null, (Boolean) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (Boolean) null, (String) null, 1073741823, (DefaultConstructorMarker) null);
    }

    public CountryEntity(@Nullable @Json(name = "id") Integer num, @Nullable @Json(name = "na") String str, @Nullable @Json(name = "cd") String str2, @Nullable @Json(name = "curs") String str3, @Nullable @Json(name = "dno") Integer num2, @Nullable @Json(name = "cwa") Boolean bool, @Nullable @Json(name = "cities") List<CityEntity> list, @Nullable @Json(name = "flag") String str4, @Nullable @Json(name = "amexAvail") Boolean bool2, @Nullable @Json(name = "iscity") Boolean bool3, @Nullable @Json(name = "iscompliance") Boolean bool4, @Nullable @Json(name = "irc") Boolean bool5, @Nullable @Json(name = "issel") Boolean bool6, @Nullable @Json(name = "isGoGreen") Boolean bool7, @Nullable @Json(name = "icc") Boolean bool8, @Nullable @Json(name = "im") Boolean bool9, @Nullable @Json(name = "itce") Boolean bool10, @Nullable @Json(name = "tpay") Boolean bool11, @Nullable @Json(name = "ht") Boolean bool12, @Nullable @Json(name = "vca") Boolean bool13, @Nullable @Json(name = "tp") Integer num3, @Nullable @Json(name = "aico") String str5, @Nullable @Json(name = "apa") Boolean bool14, @Nullable @Json(name = "apptheme") String str6, @Nullable @Json(name = "bco") Boolean bool15, @Nullable @Json(name = "isCheckoutMigrationEnabled") Boolean bool16, @Nullable @Json(name = "iscountryenabled") Boolean bool17, @Nullable @Json(name = "sl") String str7, @Nullable @Json(name = "uniTrac") Boolean bool18, @Nullable @Json(name = "url") String str8) {
        this.f55776id = num;
        this.f55777name = str;
        this.twoLetterCode = str2;
        this.currencyCode = str3;
        this.numberOfDecimalPlaces = num2;
        this.canShowCollectionWidget = bool;
        this.cities = list;
        this.flagResId = str4;
        this.isAmexAvailable = bool2;
        this.isCity = bool3;
        this.isComplianceEnabled = bool4;
        this.isContactlessPaymentEnabled = bool5;
        this.isDefault = bool6;
        this.isGoGreen = bool7;
        this.isI18nSupported = bool8;
        this.isMapEnabled = bool9;
        this.isTalabatCreditEnabled = bool10;
        this.isTalabatPayEnabled = bool11;
        this.isTokenizationEnabled = bool12;
        this.isVisaCheckoutAvailable = bool13;
        this.tokenizationProvider = num3;
        this._aico = str5;
        this._apa = bool14;
        this._appTheme = str6;
        this._bco = bool15;
        this._isCheckoutMigrationEnabled = bool16;
        this._isCountryEnabled = bool17;
        this._sl = str7;
        this._uniTrac = bool18;
        this._url = str8;
    }

    public static /* synthetic */ CountryEntity copy$default(CountryEntity countryEntity, Integer num, String str, String str2, String str3, Integer num2, Boolean bool, List list, String str4, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Boolean bool11, Boolean bool12, Boolean bool13, Integer num3, String str5, Boolean bool14, String str6, Boolean bool15, Boolean bool16, Boolean bool17, String str7, Boolean bool18, String str8, int i11, Object obj) {
        CountryEntity countryEntity2 = countryEntity;
        int i12 = i11;
        return countryEntity.copy((i12 & 1) != 0 ? countryEntity2.f55776id : num, (i12 & 2) != 0 ? countryEntity2.f55777name : str, (i12 & 4) != 0 ? countryEntity2.twoLetterCode : str2, (i12 & 8) != 0 ? countryEntity2.currencyCode : str3, (i12 & 16) != 0 ? countryEntity2.numberOfDecimalPlaces : num2, (i12 & 32) != 0 ? countryEntity2.canShowCollectionWidget : bool, (i12 & 64) != 0 ? countryEntity2.cities : list, (i12 & 128) != 0 ? countryEntity2.flagResId : str4, (i12 & 256) != 0 ? countryEntity2.isAmexAvailable : bool2, (i12 & 512) != 0 ? countryEntity2.isCity : bool3, (i12 & 1024) != 0 ? countryEntity2.isComplianceEnabled : bool4, (i12 & 2048) != 0 ? countryEntity2.isContactlessPaymentEnabled : bool5, (i12 & 4096) != 0 ? countryEntity2.isDefault : bool6, (i12 & 8192) != 0 ? countryEntity2.isGoGreen : bool7, (i12 & 16384) != 0 ? countryEntity2.isI18nSupported : bool8, (i12 & 32768) != 0 ? countryEntity2.isMapEnabled : bool9, (i12 & 65536) != 0 ? countryEntity2.isTalabatCreditEnabled : bool10, (i12 & 131072) != 0 ? countryEntity2.isTalabatPayEnabled : bool11, (i12 & 262144) != 0 ? countryEntity2.isTokenizationEnabled : bool12, (i12 & 524288) != 0 ? countryEntity2.isVisaCheckoutAvailable : bool13, (i12 & 1048576) != 0 ? countryEntity2.tokenizationProvider : num3, (i12 & 2097152) != 0 ? countryEntity2._aico : str5, (i12 & 4194304) != 0 ? countryEntity2._apa : bool14, (i12 & 8388608) != 0 ? countryEntity2._appTheme : str6, (i12 & 16777216) != 0 ? countryEntity2._bco : bool15, (i12 & 33554432) != 0 ? countryEntity2._isCheckoutMigrationEnabled : bool16, (i12 & 67108864) != 0 ? countryEntity2._isCountryEnabled : bool17, (i12 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? countryEntity2._sl : str7, (i12 & 268435456) != 0 ? countryEntity2._uniTrac : bool18, (i12 & 536870912) != 0 ? countryEntity2._url : str8);
    }

    @Deprecated(message = "unclassified")
    public static /* synthetic */ void get_aico$annotations() {
    }

    @Deprecated(message = "unclassified")
    public static /* synthetic */ void get_apa$annotations() {
    }

    @Deprecated(message = "unclassified")
    public static /* synthetic */ void get_appTheme$annotations() {
    }

    @Deprecated(message = "unclassified")
    public static /* synthetic */ void get_bco$annotations() {
    }

    @Deprecated(message = "unclassified")
    public static /* synthetic */ void get_isCheckoutMigrationEnabled$annotations() {
    }

    @Deprecated(message = "unclassified")
    public static /* synthetic */ void get_isCountryEnabled$annotations() {
    }

    @Deprecated(message = "unclassified")
    public static /* synthetic */ void get_sl$annotations() {
    }

    @Deprecated(message = "unclassified")
    public static /* synthetic */ void get_uniTrac$annotations() {
    }

    @Deprecated(message = "unclassified")
    public static /* synthetic */ void get_url$annotations() {
    }

    @Nullable
    public final Integer component1() {
        return this.f55776id;
    }

    @Nullable
    public final Boolean component10() {
        return this.isCity;
    }

    @Nullable
    public final Boolean component11() {
        return this.isComplianceEnabled;
    }

    @Nullable
    public final Boolean component12() {
        return this.isContactlessPaymentEnabled;
    }

    @Nullable
    public final Boolean component13() {
        return this.isDefault;
    }

    @Nullable
    public final Boolean component14() {
        return this.isGoGreen;
    }

    @Nullable
    public final Boolean component15() {
        return this.isI18nSupported;
    }

    @Nullable
    public final Boolean component16() {
        return this.isMapEnabled;
    }

    @Nullable
    public final Boolean component17() {
        return this.isTalabatCreditEnabled;
    }

    @Nullable
    public final Boolean component18() {
        return this.isTalabatPayEnabled;
    }

    @Nullable
    public final Boolean component19() {
        return this.isTokenizationEnabled;
    }

    @Nullable
    public final String component2() {
        return this.f55777name;
    }

    @Nullable
    public final Boolean component20() {
        return this.isVisaCheckoutAvailable;
    }

    @Nullable
    public final Integer component21() {
        return this.tokenizationProvider;
    }

    @Nullable
    public final String component22() {
        return this._aico;
    }

    @Nullable
    public final Boolean component23() {
        return this._apa;
    }

    @Nullable
    public final String component24() {
        return this._appTheme;
    }

    @Nullable
    public final Boolean component25() {
        return this._bco;
    }

    @Nullable
    public final Boolean component26() {
        return this._isCheckoutMigrationEnabled;
    }

    @Nullable
    public final Boolean component27() {
        return this._isCountryEnabled;
    }

    @Nullable
    public final String component28() {
        return this._sl;
    }

    @Nullable
    public final Boolean component29() {
        return this._uniTrac;
    }

    @Nullable
    public final String component3() {
        return this.twoLetterCode;
    }

    @Nullable
    public final String component30() {
        return this._url;
    }

    @Nullable
    public final String component4() {
        return this.currencyCode;
    }

    @Nullable
    public final Integer component5() {
        return this.numberOfDecimalPlaces;
    }

    @Nullable
    public final Boolean component6() {
        return this.canShowCollectionWidget;
    }

    @Nullable
    public final List<CityEntity> component7() {
        return this.cities;
    }

    @Nullable
    public final String component8() {
        return this.flagResId;
    }

    @Nullable
    public final Boolean component9() {
        return this.isAmexAvailable;
    }

    @NotNull
    public final CountryEntity copy(@Nullable @Json(name = "id") Integer num, @Nullable @Json(name = "na") String str, @Nullable @Json(name = "cd") String str2, @Nullable @Json(name = "curs") String str3, @Nullable @Json(name = "dno") Integer num2, @Nullable @Json(name = "cwa") Boolean bool, @Nullable @Json(name = "cities") List<CityEntity> list, @Nullable @Json(name = "flag") String str4, @Nullable @Json(name = "amexAvail") Boolean bool2, @Nullable @Json(name = "iscity") Boolean bool3, @Nullable @Json(name = "iscompliance") Boolean bool4, @Nullable @Json(name = "irc") Boolean bool5, @Nullable @Json(name = "issel") Boolean bool6, @Nullable @Json(name = "isGoGreen") Boolean bool7, @Nullable @Json(name = "icc") Boolean bool8, @Nullable @Json(name = "im") Boolean bool9, @Nullable @Json(name = "itce") Boolean bool10, @Nullable @Json(name = "tpay") Boolean bool11, @Nullable @Json(name = "ht") Boolean bool12, @Nullable @Json(name = "vca") Boolean bool13, @Nullable @Json(name = "tp") Integer num3, @Nullable @Json(name = "aico") String str5, @Nullable @Json(name = "apa") Boolean bool14, @Nullable @Json(name = "apptheme") String str6, @Nullable @Json(name = "bco") Boolean bool15, @Nullable @Json(name = "isCheckoutMigrationEnabled") Boolean bool16, @Nullable @Json(name = "iscountryenabled") Boolean bool17, @Nullable @Json(name = "sl") String str7, @Nullable @Json(name = "uniTrac") Boolean bool18, @Nullable @Json(name = "url") String str8) {
        return new CountryEntity(num, str, str2, str3, num2, bool, list, str4, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, num3, str5, bool14, str6, bool15, bool16, bool17, str7, bool18, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountryEntity)) {
            return false;
        }
        CountryEntity countryEntity = (CountryEntity) obj;
        return Intrinsics.areEqual((Object) this.f55776id, (Object) countryEntity.f55776id) && Intrinsics.areEqual((Object) this.f55777name, (Object) countryEntity.f55777name) && Intrinsics.areEqual((Object) this.twoLetterCode, (Object) countryEntity.twoLetterCode) && Intrinsics.areEqual((Object) this.currencyCode, (Object) countryEntity.currencyCode) && Intrinsics.areEqual((Object) this.numberOfDecimalPlaces, (Object) countryEntity.numberOfDecimalPlaces) && Intrinsics.areEqual((Object) this.canShowCollectionWidget, (Object) countryEntity.canShowCollectionWidget) && Intrinsics.areEqual((Object) this.cities, (Object) countryEntity.cities) && Intrinsics.areEqual((Object) this.flagResId, (Object) countryEntity.flagResId) && Intrinsics.areEqual((Object) this.isAmexAvailable, (Object) countryEntity.isAmexAvailable) && Intrinsics.areEqual((Object) this.isCity, (Object) countryEntity.isCity) && Intrinsics.areEqual((Object) this.isComplianceEnabled, (Object) countryEntity.isComplianceEnabled) && Intrinsics.areEqual((Object) this.isContactlessPaymentEnabled, (Object) countryEntity.isContactlessPaymentEnabled) && Intrinsics.areEqual((Object) this.isDefault, (Object) countryEntity.isDefault) && Intrinsics.areEqual((Object) this.isGoGreen, (Object) countryEntity.isGoGreen) && Intrinsics.areEqual((Object) this.isI18nSupported, (Object) countryEntity.isI18nSupported) && Intrinsics.areEqual((Object) this.isMapEnabled, (Object) countryEntity.isMapEnabled) && Intrinsics.areEqual((Object) this.isTalabatCreditEnabled, (Object) countryEntity.isTalabatCreditEnabled) && Intrinsics.areEqual((Object) this.isTalabatPayEnabled, (Object) countryEntity.isTalabatPayEnabled) && Intrinsics.areEqual((Object) this.isTokenizationEnabled, (Object) countryEntity.isTokenizationEnabled) && Intrinsics.areEqual((Object) this.isVisaCheckoutAvailable, (Object) countryEntity.isVisaCheckoutAvailable) && Intrinsics.areEqual((Object) this.tokenizationProvider, (Object) countryEntity.tokenizationProvider) && Intrinsics.areEqual((Object) this._aico, (Object) countryEntity._aico) && Intrinsics.areEqual((Object) this._apa, (Object) countryEntity._apa) && Intrinsics.areEqual((Object) this._appTheme, (Object) countryEntity._appTheme) && Intrinsics.areEqual((Object) this._bco, (Object) countryEntity._bco) && Intrinsics.areEqual((Object) this._isCheckoutMigrationEnabled, (Object) countryEntity._isCheckoutMigrationEnabled) && Intrinsics.areEqual((Object) this._isCountryEnabled, (Object) countryEntity._isCountryEnabled) && Intrinsics.areEqual((Object) this._sl, (Object) countryEntity._sl) && Intrinsics.areEqual((Object) this._uniTrac, (Object) countryEntity._uniTrac) && Intrinsics.areEqual((Object) this._url, (Object) countryEntity._url);
    }

    @Nullable
    public final Boolean getCanShowCollectionWidget() {
        return this.canShowCollectionWidget;
    }

    @Nullable
    public final List<CityEntity> getCities() {
        return this.cities;
    }

    @Nullable
    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    @Nullable
    public final String getFlagResId() {
        return this.flagResId;
    }

    @Nullable
    public final Integer getId() {
        return this.f55776id;
    }

    @Nullable
    public final String getName() {
        return this.f55777name;
    }

    @Nullable
    public final Integer getNumberOfDecimalPlaces() {
        return this.numberOfDecimalPlaces;
    }

    @Nullable
    public final Integer getTokenizationProvider() {
        return this.tokenizationProvider;
    }

    @Nullable
    public final String getTwoLetterCode() {
        return this.twoLetterCode;
    }

    @Nullable
    public final String get_aico() {
        return this._aico;
    }

    @Nullable
    public final Boolean get_apa() {
        return this._apa;
    }

    @Nullable
    public final String get_appTheme() {
        return this._appTheme;
    }

    @Nullable
    public final Boolean get_bco() {
        return this._bco;
    }

    @Nullable
    public final Boolean get_isCheckoutMigrationEnabled() {
        return this._isCheckoutMigrationEnabled;
    }

    @Nullable
    public final Boolean get_isCountryEnabled() {
        return this._isCountryEnabled;
    }

    @Nullable
    public final String get_sl() {
        return this._sl;
    }

    @Nullable
    public final Boolean get_uniTrac() {
        return this._uniTrac;
    }

    @Nullable
    public final String get_url() {
        return this._url;
    }

    public int hashCode() {
        Integer num = this.f55776id;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.f55777name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.twoLetterCode;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.currencyCode;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.numberOfDecimalPlaces;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.canShowCollectionWidget;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<CityEntity> list = this.cities;
        int hashCode7 = (hashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.flagResId;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool2 = this.isAmexAvailable;
        int hashCode9 = (hashCode8 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isCity;
        int hashCode10 = (hashCode9 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.isComplianceEnabled;
        int hashCode11 = (hashCode10 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.isContactlessPaymentEnabled;
        int hashCode12 = (hashCode11 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.isDefault;
        int hashCode13 = (hashCode12 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.isGoGreen;
        int hashCode14 = (hashCode13 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Boolean bool8 = this.isI18nSupported;
        int hashCode15 = (hashCode14 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        Boolean bool9 = this.isMapEnabled;
        int hashCode16 = (hashCode15 + (bool9 == null ? 0 : bool9.hashCode())) * 31;
        Boolean bool10 = this.isTalabatCreditEnabled;
        int hashCode17 = (hashCode16 + (bool10 == null ? 0 : bool10.hashCode())) * 31;
        Boolean bool11 = this.isTalabatPayEnabled;
        int hashCode18 = (hashCode17 + (bool11 == null ? 0 : bool11.hashCode())) * 31;
        Boolean bool12 = this.isTokenizationEnabled;
        int hashCode19 = (hashCode18 + (bool12 == null ? 0 : bool12.hashCode())) * 31;
        Boolean bool13 = this.isVisaCheckoutAvailable;
        int hashCode20 = (hashCode19 + (bool13 == null ? 0 : bool13.hashCode())) * 31;
        Integer num3 = this.tokenizationProvider;
        int hashCode21 = (hashCode20 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str5 = this._aico;
        int hashCode22 = (hashCode21 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Boolean bool14 = this._apa;
        int hashCode23 = (hashCode22 + (bool14 == null ? 0 : bool14.hashCode())) * 31;
        String str6 = this._appTheme;
        int hashCode24 = (hashCode23 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool15 = this._bco;
        int hashCode25 = (hashCode24 + (bool15 == null ? 0 : bool15.hashCode())) * 31;
        Boolean bool16 = this._isCheckoutMigrationEnabled;
        int hashCode26 = (hashCode25 + (bool16 == null ? 0 : bool16.hashCode())) * 31;
        Boolean bool17 = this._isCountryEnabled;
        int hashCode27 = (hashCode26 + (bool17 == null ? 0 : bool17.hashCode())) * 31;
        String str7 = this._sl;
        int hashCode28 = (hashCode27 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool18 = this._uniTrac;
        int hashCode29 = (hashCode28 + (bool18 == null ? 0 : bool18.hashCode())) * 31;
        String str8 = this._url;
        if (str8 != null) {
            i11 = str8.hashCode();
        }
        return hashCode29 + i11;
    }

    @Nullable
    public final Boolean isAmexAvailable() {
        return this.isAmexAvailable;
    }

    @Nullable
    public final Boolean isCity() {
        return this.isCity;
    }

    @Nullable
    public final Boolean isComplianceEnabled() {
        return this.isComplianceEnabled;
    }

    @Nullable
    public final Boolean isContactlessPaymentEnabled() {
        return this.isContactlessPaymentEnabled;
    }

    @Nullable
    public final Boolean isDefault() {
        return this.isDefault;
    }

    @Nullable
    public final Boolean isGoGreen() {
        return this.isGoGreen;
    }

    @Nullable
    public final Boolean isI18nSupported() {
        return this.isI18nSupported;
    }

    @Nullable
    public final Boolean isMapEnabled() {
        return this.isMapEnabled;
    }

    @Nullable
    public final Boolean isTalabatCreditEnabled() {
        return this.isTalabatCreditEnabled;
    }

    @Nullable
    public final Boolean isTalabatPayEnabled() {
        return this.isTalabatPayEnabled;
    }

    @Nullable
    public final Boolean isTokenizationEnabled() {
        return this.isTokenizationEnabled;
    }

    @Nullable
    public final Boolean isVisaCheckoutAvailable() {
        return this.isVisaCheckoutAvailable;
    }

    @NotNull
    public String toString() {
        Integer num = this.f55776id;
        String str = this.f55777name;
        String str2 = this.twoLetterCode;
        String str3 = this.currencyCode;
        Integer num2 = this.numberOfDecimalPlaces;
        Boolean bool = this.canShowCollectionWidget;
        List<CityEntity> list = this.cities;
        String str4 = this.flagResId;
        Boolean bool2 = this.isAmexAvailable;
        Boolean bool3 = this.isCity;
        Boolean bool4 = this.isComplianceEnabled;
        Boolean bool5 = this.isContactlessPaymentEnabled;
        Boolean bool6 = this.isDefault;
        Boolean bool7 = this.isGoGreen;
        Boolean bool8 = this.isI18nSupported;
        Boolean bool9 = this.isMapEnabled;
        Boolean bool10 = this.isTalabatCreditEnabled;
        Boolean bool11 = this.isTalabatPayEnabled;
        Boolean bool12 = this.isTokenizationEnabled;
        Boolean bool13 = this.isVisaCheckoutAvailable;
        Integer num3 = this.tokenizationProvider;
        String str5 = this._aico;
        Boolean bool14 = this._apa;
        String str6 = this._appTheme;
        Boolean bool15 = this._bco;
        Boolean bool16 = this._isCheckoutMigrationEnabled;
        Boolean bool17 = this._isCountryEnabled;
        String str7 = this._sl;
        Boolean bool18 = this._uniTrac;
        String str8 = this._url;
        return "CountryEntity(id=" + num + ", name=" + str + ", twoLetterCode=" + str2 + ", currencyCode=" + str3 + ", numberOfDecimalPlaces=" + num2 + ", canShowCollectionWidget=" + bool + ", cities=" + list + ", flagResId=" + str4 + ", isAmexAvailable=" + bool2 + ", isCity=" + bool3 + ", isComplianceEnabled=" + bool4 + ", isContactlessPaymentEnabled=" + bool5 + ", isDefault=" + bool6 + ", isGoGreen=" + bool7 + ", isI18nSupported=" + bool8 + ", isMapEnabled=" + bool9 + ", isTalabatCreditEnabled=" + bool10 + ", isTalabatPayEnabled=" + bool11 + ", isTokenizationEnabled=" + bool12 + ", isVisaCheckoutAvailable=" + bool13 + ", tokenizationProvider=" + num3 + ", _aico=" + str5 + ", _apa=" + bool14 + ", _appTheme=" + str6 + ", _bco=" + bool15 + ", _isCheckoutMigrationEnabled=" + bool16 + ", _isCountryEnabled=" + bool17 + ", _sl=" + str7 + ", _uniTrac=" + bool18 + ", _url=" + str8 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CountryEntity(java.lang.Integer r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.Integer r36, java.lang.Boolean r37, java.util.List r38, java.lang.String r39, java.lang.Boolean r40, java.lang.Boolean r41, java.lang.Boolean r42, java.lang.Boolean r43, java.lang.Boolean r44, java.lang.Boolean r45, java.lang.Boolean r46, java.lang.Boolean r47, java.lang.Boolean r48, java.lang.Boolean r49, java.lang.Boolean r50, java.lang.Boolean r51, java.lang.Integer r52, java.lang.String r53, java.lang.Boolean r54, java.lang.String r55, java.lang.Boolean r56, java.lang.Boolean r57, java.lang.Boolean r58, java.lang.String r59, java.lang.Boolean r60, java.lang.String r61, int r62, kotlin.jvm.internal.DefaultConstructorMarker r63) {
        /*
            r31 = this;
            r0 = r62
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r32
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r33
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r34
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r35
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r36
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r37
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r38
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r39
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r40
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r41
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r42
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r43
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r44
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r45
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r46
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r47
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r48
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r49
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00a5
            r19 = 0
            goto L_0x00a7
        L_0x00a5:
            r19 = r50
        L_0x00a7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b0
            r20 = 0
            goto L_0x00b2
        L_0x00b0:
            r20 = r51
        L_0x00b2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00bb
            r21 = 0
            goto L_0x00bd
        L_0x00bb:
            r21 = r52
        L_0x00bd:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00c6
            r22 = 0
            goto L_0x00c8
        L_0x00c6:
            r22 = r53
        L_0x00c8:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00d1
            r23 = 0
            goto L_0x00d3
        L_0x00d1:
            r23 = r54
        L_0x00d3:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00dc
            r24 = 0
            goto L_0x00de
        L_0x00dc:
            r24 = r55
        L_0x00de:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e7
            r25 = 0
            goto L_0x00e9
        L_0x00e7:
            r25 = r56
        L_0x00e9:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00f2
            r26 = 0
            goto L_0x00f4
        L_0x00f2:
            r26 = r57
        L_0x00f4:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00fd
            r27 = 0
            goto L_0x00ff
        L_0x00fd:
            r27 = r58
        L_0x00ff:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0108
            r28 = 0
            goto L_0x010a
        L_0x0108:
            r28 = r59
        L_0x010a:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x0113
            r29 = 0
            goto L_0x0115
        L_0x0113:
            r29 = r60
        L_0x0115:
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r30
            if (r0 == 0) goto L_0x011d
            r0 = 0
            goto L_0x011f
        L_0x011d:
            r0 = r61
        L_0x011f:
            r32 = r31
            r33 = r1
            r34 = r3
            r35 = r4
            r36 = r5
            r37 = r6
            r38 = r7
            r39 = r8
            r40 = r9
            r41 = r10
            r42 = r11
            r43 = r12
            r44 = r13
            r45 = r14
            r46 = r15
            r47 = r2
            r48 = r16
            r49 = r17
            r50 = r18
            r51 = r19
            r52 = r20
            r53 = r21
            r54 = r22
            r55 = r23
            r56 = r24
            r57 = r25
            r58 = r26
            r59 = r27
            r60 = r28
            r61 = r29
            r62 = r0
            r32.<init>(r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.configuration.location.model.CountryEntity.<init>(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Boolean, java.util.List, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
