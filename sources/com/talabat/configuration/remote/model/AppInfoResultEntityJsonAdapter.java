package com.talabat.configuration.remote.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import com.talabat.configuration.location.model.AreaEntity;
import com.talabat.configuration.location.model.CountryEntity;
import com.talabat.configuration.payment.model.TokenizedBankCardEntity;
import com.talabat.domain.address.Address;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010#\u001a\u00020\u0018H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/talabat/configuration/remote/model/AppInfoResultEntityJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/configuration/remote/model/AppInfoResultEntity;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableBooleanAdapter", "", "nullableIntAdapter", "", "nullableListOfAddressAdapter", "", "Lcom/talabat/domain/address/Address;", "nullableListOfAreaEntityAdapter", "Lcom/talabat/configuration/location/model/AreaEntity;", "nullableListOfCountryEntityAdapter", "Lcom/talabat/configuration/location/model/CountryEntity;", "nullableListOfTokenizedBankCardEntityAdapter", "Lcom/talabat/configuration/payment/model/TokenizedBankCardEntity;", "nullableNewAppVersionEntityAdapter", "Lcom/talabat/configuration/remote/model/NewAppVersionEntity;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppInfoResultEntityJsonAdapter extends JsonAdapter<AppInfoResultEntity> {
    @Nullable
    private volatile Constructor<AppInfoResultEntity> constructorRef;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonAdapter<List<Address>> nullableListOfAddressAdapter;
    @NotNull
    private final JsonAdapter<List<AreaEntity>> nullableListOfAreaEntityAdapter;
    @NotNull
    private final JsonAdapter<List<CountryEntity>> nullableListOfCountryEntityAdapter;
    @NotNull
    private final JsonAdapter<List<TokenizedBankCardEntity>> nullableListOfTokenizedBankCardEntityAdapter;
    @NotNull
    private final JsonAdapter<NewAppVersionEntity> nullableNewAppVersionEntityAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public AppInfoResultEntityJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("addresses", "areas", "countryId", "countries", "dversion", "isAddressMicroServiceEnabled", "publicKey", "tokens", "url");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"addresses\", \"areas\",…licKey\", \"tokens\", \"url\")");
        this.options = of2;
        Class<List> cls = List.class;
        JsonAdapter<List<Address>> adapter = moshi.adapter(Types.newParameterizedType(cls, Address.class), SetsKt__SetsKt.emptySet(), "addresses");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…Set(),\n      \"addresses\")");
        this.nullableListOfAddressAdapter = adapter;
        JsonAdapter<List<AreaEntity>> adapter2 = moshi.adapter(Types.newParameterizedType(cls, AreaEntity.class), SetsKt__SetsKt.emptySet(), "areas");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Types.newP…     emptySet(), \"areas\")");
        this.nullableListOfAreaEntityAdapter = adapter2;
        JsonAdapter<Integer> adapter3 = moshi.adapter(Integer.class, SetsKt__SetsKt.emptySet(), "countryId");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Int::class… emptySet(), \"countryId\")");
        this.nullableIntAdapter = adapter3;
        JsonAdapter<List<CountryEntity>> adapter4 = moshi.adapter(Types.newParameterizedType(cls, CountryEntity.class), SetsKt__SetsKt.emptySet(), "countries");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Types.newP… emptySet(), \"countries\")");
        this.nullableListOfCountryEntityAdapter = adapter4;
        JsonAdapter<NewAppVersionEntity> adapter5 = moshi.adapter(NewAppVersionEntity.class, SetsKt__SetsKt.emptySet(), "newAppVersion");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(NewAppVers…tySet(), \"newAppVersion\")");
        this.nullableNewAppVersionEntityAdapter = adapter5;
        JsonAdapter<Boolean> adapter6 = moshi.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "isAddressMicroServiceEnabled");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Boolean::c…ressMicroServiceEnabled\")");
        this.nullableBooleanAdapter = adapter6;
        JsonAdapter<String> adapter7 = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "publicKey");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(String::cl… emptySet(), \"publicKey\")");
        this.nullableStringAdapter = adapter7;
        JsonAdapter<List<TokenizedBankCardEntity>> adapter8 = moshi.adapter(Types.newParameterizedType(cls, TokenizedBankCardEntity.class), SetsKt__SetsKt.emptySet(), "tokenizedBankCards");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(Types.newP…(), \"tokenizedBankCards\")");
        this.nullableListOfTokenizedBankCardEntityAdapter = adapter8;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AppInfoResultEntity");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public AppInfoResultEntity fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i11 = -1;
        List list = null;
        List list2 = null;
        Integer num = null;
        List list3 = null;
        NewAppVersionEntity newAppVersionEntity = null;
        Boolean bool = null;
        String str = null;
        List list4 = null;
        String str2 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    list = this.nullableListOfAddressAdapter.fromJson(jsonReader2);
                    i11 &= -2;
                    break;
                case 1:
                    list2 = this.nullableListOfAreaEntityAdapter.fromJson(jsonReader2);
                    i11 &= -3;
                    break;
                case 2:
                    num = this.nullableIntAdapter.fromJson(jsonReader2);
                    i11 &= -5;
                    break;
                case 3:
                    list3 = this.nullableListOfCountryEntityAdapter.fromJson(jsonReader2);
                    i11 &= -9;
                    break;
                case 4:
                    newAppVersionEntity = this.nullableNewAppVersionEntityAdapter.fromJson(jsonReader2);
                    i11 &= -17;
                    break;
                case 5:
                    bool = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -33;
                    break;
                case 6:
                    str = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -65;
                    break;
                case 7:
                    list4 = this.nullableListOfTokenizedBankCardEntityAdapter.fromJson(jsonReader2);
                    i11 &= -129;
                    break;
                case 8:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -257;
                    break;
            }
        }
        jsonReader.endObject();
        if (i11 == -512) {
            return new AppInfoResultEntity(list, list2, num, list3, newAppVersionEntity, bool, str, list4, str2);
        }
        Constructor<AppInfoResultEntity> constructor = this.constructorRef;
        if (constructor == null) {
            Class<List> cls = List.class;
            Class<String> cls2 = String.class;
            constructor = AppInfoResultEntity.class.getDeclaredConstructor(new Class[]{cls, cls, Integer.class, cls, NewAppVersionEntity.class, Boolean.class, cls2, cls, cls2, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "AppInfoResultEntity::cla…his.constructorRef = it }");
        }
        AppInfoResultEntity newInstance = constructor.newInstance(new Object[]{list, list2, num, list3, newAppVersionEntity, bool, str, list4, str2, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable AppInfoResultEntity appInfoResultEntity) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (appInfoResultEntity != null) {
            jsonWriter.beginObject();
            jsonWriter.name("addresses");
            this.nullableListOfAddressAdapter.toJson(jsonWriter, appInfoResultEntity.getAddresses());
            jsonWriter.name("areas");
            this.nullableListOfAreaEntityAdapter.toJson(jsonWriter, appInfoResultEntity.getAreas());
            jsonWriter.name("countryId");
            this.nullableIntAdapter.toJson(jsonWriter, appInfoResultEntity.getCountryId());
            jsonWriter.name("countries");
            this.nullableListOfCountryEntityAdapter.toJson(jsonWriter, appInfoResultEntity.getCountries());
            jsonWriter.name("dversion");
            this.nullableNewAppVersionEntityAdapter.toJson(jsonWriter, appInfoResultEntity.getNewAppVersion());
            jsonWriter.name("isAddressMicroServiceEnabled");
            this.nullableBooleanAdapter.toJson(jsonWriter, appInfoResultEntity.isAddressMicroServiceEnabled());
            jsonWriter.name("publicKey");
            this.nullableStringAdapter.toJson(jsonWriter, appInfoResultEntity.getPublicKey());
            jsonWriter.name("tokens");
            this.nullableListOfTokenizedBankCardEntityAdapter.toJson(jsonWriter, appInfoResultEntity.getTokenizedBankCards());
            jsonWriter.name("url");
            this.nullableStringAdapter.toJson(jsonWriter, appInfoResultEntity.getUrl());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
