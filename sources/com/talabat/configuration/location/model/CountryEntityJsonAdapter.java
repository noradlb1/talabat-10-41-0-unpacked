package com.talabat.configuration.location.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/configuration/location/model/CountryEntityJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/configuration/location/model/CountryEntity;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableBooleanAdapter", "", "nullableIntAdapter", "", "nullableListOfCityEntityAdapter", "", "Lcom/talabat/configuration/location/model/CityEntity;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CountryEntityJsonAdapter extends JsonAdapter<CountryEntity> {
    @Nullable
    private volatile Constructor<CountryEntity> constructorRef;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonAdapter<List<CityEntity>> nullableListOfCityEntityAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public CountryEntityJsonAdapter(@NotNull Moshi moshi) {
        Moshi moshi2 = moshi;
        Intrinsics.checkNotNullParameter(moshi2, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("id", "na", "cd", "curs", "dno", "cwa", "cities", "flag", "amexAvail", "iscity", "iscompliance", "irc", "issel", "isGoGreen", "icc", "im", "itce", "tpay", "ht", "vca", "tp", "aico", "apa", "apptheme", "bco", "isCheckoutMigrationEnabled", "iscountryenabled", "sl", "uniTrac", "url");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"id\", \"na\", \"cd\", \"cu…, \"sl\", \"uniTrac\", \"url\")");
        this.options = of2;
        JsonAdapter<Integer> adapter = moshi2.adapter(Integer.class, SetsKt__SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Int::class…,\n      emptySet(), \"id\")");
        this.nullableIntAdapter = adapter;
        JsonAdapter<String> adapter2 = moshi2.adapter(String.class, SetsKt__SetsKt.emptySet(), "name");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(String::cl…      emptySet(), \"name\")");
        this.nullableStringAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi2.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "canShowCollectionWidget");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…canShowCollectionWidget\")");
        this.nullableBooleanAdapter = adapter3;
        JsonAdapter<List<CityEntity>> adapter4 = moshi2.adapter(Types.newParameterizedType(List.class, CityEntity.class), SetsKt__SetsKt.emptySet(), "cities");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP…    emptySet(), \"cities\")");
        this.nullableListOfCityEntityAdapter = adapter4;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CountryEntity");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public CountryEntity fromJson(@NotNull JsonReader jsonReader) {
        int i11;
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i12 = -1;
        Integer num = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        Integer num2 = null;
        Boolean bool = null;
        List list = null;
        String str4 = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        Boolean bool4 = null;
        Boolean bool5 = null;
        Boolean bool6 = null;
        Boolean bool7 = null;
        Boolean bool8 = null;
        Boolean bool9 = null;
        Boolean bool10 = null;
        Boolean bool11 = null;
        Boolean bool12 = null;
        Boolean bool13 = null;
        Integer num3 = null;
        String str5 = null;
        Boolean bool14 = null;
        String str6 = null;
        Boolean bool15 = null;
        Boolean bool16 = null;
        Boolean bool17 = null;
        String str7 = null;
        Boolean bool18 = null;
        String str8 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
                case 0:
                    num = this.nullableIntAdapter.fromJson(jsonReader2);
                    i12 &= -2;
                    continue;
                case 1:
                    str = this.nullableStringAdapter.fromJson(jsonReader2);
                    i12 &= -3;
                    continue;
                case 2:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i12 &= -5;
                    continue;
                case 3:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i12 &= -9;
                    continue;
                case 4:
                    num2 = this.nullableIntAdapter.fromJson(jsonReader2);
                    i12 &= -17;
                    continue;
                case 5:
                    bool = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i12 &= -33;
                    continue;
                case 6:
                    list = this.nullableListOfCityEntityAdapter.fromJson(jsonReader2);
                    i12 &= -65;
                    continue;
                case 7:
                    str4 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i12 &= -129;
                    continue;
                case 8:
                    bool2 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i12 &= -257;
                    continue;
                case 9:
                    bool3 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i12 &= -513;
                    continue;
                case 10:
                    bool4 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i12 &= -1025;
                    continue;
                case 11:
                    bool5 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i12 &= -2049;
                    continue;
                case 12:
                    bool6 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i12 &= -4097;
                    continue;
                case 13:
                    bool7 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i12 &= -8193;
                    continue;
                case 14:
                    bool8 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i12 &= -16385;
                    continue;
                case 15:
                    bool9 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 = -32769;
                    break;
                case 16:
                    bool10 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 = -65537;
                    break;
                case 17:
                    bool11 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 = -131073;
                    break;
                case 18:
                    bool12 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 = -262145;
                    break;
                case 19:
                    bool13 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 = -524289;
                    break;
                case 20:
                    num3 = this.nullableIntAdapter.fromJson(jsonReader2);
                    i11 = -1048577;
                    break;
                case 21:
                    str5 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 = -2097153;
                    break;
                case 22:
                    bool14 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 = -4194305;
                    break;
                case 23:
                    str6 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 = -8388609;
                    break;
                case 24:
                    bool15 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 = -16777217;
                    break;
                case 25:
                    bool16 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 = -33554433;
                    break;
                case 26:
                    bool17 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 = -67108865;
                    break;
                case 27:
                    str7 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 = -134217729;
                    break;
                case 28:
                    bool18 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 = -268435457;
                    break;
                case 29:
                    str8 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 = -536870913;
                    break;
            }
            i12 &= i11;
        }
        jsonReader.endObject();
        if (i12 == -1073741824) {
            return new CountryEntity(num, str, str2, str3, num2, bool, list, str4, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, num3, str5, bool14, str6, bool15, bool16, bool17, str7, bool18, str8);
        }
        Constructor<CountryEntity> constructor = this.constructorRef;
        if (constructor == null) {
            Class<Integer> cls = Integer.class;
            Class<String> cls2 = String.class;
            Class<Boolean> cls3 = Boolean.class;
            constructor = CountryEntity.class.getDeclaredConstructor(new Class[]{cls, cls2, cls2, cls2, cls, cls3, List.class, cls2, cls3, cls3, cls3, cls3, cls3, cls3, cls3, cls3, cls3, cls3, cls3, cls3, cls, cls2, cls3, cls2, cls3, cls3, cls3, cls2, cls3, cls2, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Unit unit = Unit.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(constructor, "CountryEntity::class.jav…his.constructorRef = it }");
        }
        CountryEntity newInstance = constructor.newInstance(new Object[]{num, str, str2, str3, num2, bool, list, str4, bool2, bool3, bool4, bool5, bool6, bool7, bool8, bool9, bool10, bool11, bool12, bool13, num3, str5, bool14, str6, bool15, bool16, bool17, str7, bool18, str8, Integer.valueOf(i12), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable CountryEntity countryEntity) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (countryEntity != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.nullableIntAdapter.toJson(jsonWriter, countryEntity.getId());
            jsonWriter.name("na");
            this.nullableStringAdapter.toJson(jsonWriter, countryEntity.getName());
            jsonWriter.name("cd");
            this.nullableStringAdapter.toJson(jsonWriter, countryEntity.getTwoLetterCode());
            jsonWriter.name("curs");
            this.nullableStringAdapter.toJson(jsonWriter, countryEntity.getCurrencyCode());
            jsonWriter.name("dno");
            this.nullableIntAdapter.toJson(jsonWriter, countryEntity.getNumberOfDecimalPlaces());
            jsonWriter.name("cwa");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.getCanShowCollectionWidget());
            jsonWriter.name("cities");
            this.nullableListOfCityEntityAdapter.toJson(jsonWriter, countryEntity.getCities());
            jsonWriter.name("flag");
            this.nullableStringAdapter.toJson(jsonWriter, countryEntity.getFlagResId());
            jsonWriter.name("amexAvail");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.isAmexAvailable());
            jsonWriter.name("iscity");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.isCity());
            jsonWriter.name("iscompliance");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.isComplianceEnabled());
            jsonWriter.name("irc");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.isContactlessPaymentEnabled());
            jsonWriter.name("issel");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.isDefault());
            jsonWriter.name("isGoGreen");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.isGoGreen());
            jsonWriter.name("icc");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.isI18nSupported());
            jsonWriter.name("im");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.isMapEnabled());
            jsonWriter.name("itce");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.isTalabatCreditEnabled());
            jsonWriter.name("tpay");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.isTalabatPayEnabled());
            jsonWriter.name("ht");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.isTokenizationEnabled());
            jsonWriter.name("vca");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.isVisaCheckoutAvailable());
            jsonWriter.name("tp");
            this.nullableIntAdapter.toJson(jsonWriter, countryEntity.getTokenizationProvider());
            jsonWriter.name("aico");
            this.nullableStringAdapter.toJson(jsonWriter, countryEntity.get_aico());
            jsonWriter.name("apa");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.get_apa());
            jsonWriter.name("apptheme");
            this.nullableStringAdapter.toJson(jsonWriter, countryEntity.get_appTheme());
            jsonWriter.name("bco");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.get_bco());
            jsonWriter.name("isCheckoutMigrationEnabled");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.get_isCheckoutMigrationEnabled());
            jsonWriter.name("iscountryenabled");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.get_isCountryEnabled());
            jsonWriter.name("sl");
            this.nullableStringAdapter.toJson(jsonWriter, countryEntity.get_sl());
            jsonWriter.name("uniTrac");
            this.nullableBooleanAdapter.toJson(jsonWriter, countryEntity.get_uniTrac());
            jsonWriter.name("url");
            this.nullableStringAdapter.toJson(jsonWriter, countryEntity.get_url());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
