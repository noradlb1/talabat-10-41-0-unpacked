package com.talabat.configuration.payment.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/configuration/payment/model/TokenizedBankCardEntityJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/configuration/payment/model/TokenizedBankCardEntity;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableBooleanAdapter", "", "nullableIntAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_core_configuration_remote_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenizedBankCardEntityJsonAdapter extends JsonAdapter<TokenizedBankCardEntity> {
    @Nullable
    private volatile Constructor<TokenizedBankCardEntity> constructorRef;
    @NotNull
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonAdapter<String> nullableStringAdapter;
    @NotNull
    private final JsonReader.Options options;

    public TokenizedBankCardEntityJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("message", "binNumber", "expiredate", "expiremonth", "expireyear", "holdername", "isBinDiscountValid", "isForceCvv", "isValidCard", "cardnumber", LegacyTokenLocalDataSourceImpl.KEY, "cardtype");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"message\", \"binNumber…er\", \"token\", \"cardtype\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "binMessage");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…emptySet(), \"binMessage\")");
        this.nullableStringAdapter = adapter;
        JsonAdapter<Integer> adapter2 = moshi.adapter(Integer.class, SetsKt__SetsKt.emptySet(), CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY);
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Int::class…mptySet(), \"expiryMonth\")");
        this.nullableIntAdapter = adapter2;
        JsonAdapter<Boolean> adapter3 = moshi.adapter(Boolean.class, SetsKt__SetsKt.emptySet(), "isBinDiscountValid");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Boolean::c…(), \"isBinDiscountValid\")");
        this.nullableBooleanAdapter = adapter3;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(45);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("TokenizedBankCardEntity");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public TokenizedBankCardEntity fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i11 = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        Integer num = null;
        Integer num2 = null;
        String str4 = null;
        Boolean bool = null;
        Boolean bool2 = null;
        Boolean bool3 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -2;
                    break;
                case 1:
                    str2 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -3;
                    break;
                case 2:
                    str3 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -5;
                    break;
                case 3:
                    num = this.nullableIntAdapter.fromJson(jsonReader2);
                    i11 &= -9;
                    break;
                case 4:
                    num2 = this.nullableIntAdapter.fromJson(jsonReader2);
                    i11 &= -17;
                    break;
                case 5:
                    str4 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -33;
                    break;
                case 6:
                    bool = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -65;
                    break;
                case 7:
                    bool2 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -129;
                    break;
                case 8:
                    bool3 = this.nullableBooleanAdapter.fromJson(jsonReader2);
                    i11 &= -257;
                    break;
                case 9:
                    str5 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -513;
                    break;
                case 10:
                    str6 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -1025;
                    break;
                case 11:
                    str7 = this.nullableStringAdapter.fromJson(jsonReader2);
                    i11 &= -2049;
                    break;
            }
        }
        jsonReader.endObject();
        if (i11 == -4096) {
            return new TokenizedBankCardEntity(str, str2, str3, num, num2, str4, bool, bool2, bool3, str5, str6, str7);
        }
        Constructor<TokenizedBankCardEntity> constructor = this.constructorRef;
        if (constructor == null) {
            Class<String> cls = String.class;
            Class<Integer> cls2 = Integer.class;
            Class<Boolean> cls3 = Boolean.class;
            constructor = TokenizedBankCardEntity.class.getDeclaredConstructor(new Class[]{cls, cls, cls, cls2, cls2, cls, cls3, cls3, cls3, cls, cls, cls, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "TokenizedBankCardEntity:…his.constructorRef = it }");
        }
        TokenizedBankCardEntity newInstance = constructor.newInstance(new Object[]{str, str2, str3, num, num2, str4, bool, bool2, bool3, str5, str6, str7, Integer.valueOf(i11), null});
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable TokenizedBankCardEntity tokenizedBankCardEntity) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (tokenizedBankCardEntity != null) {
            jsonWriter.beginObject();
            jsonWriter.name("message");
            this.nullableStringAdapter.toJson(jsonWriter, tokenizedBankCardEntity.getBinMessage());
            jsonWriter.name("binNumber");
            this.nullableStringAdapter.toJson(jsonWriter, tokenizedBankCardEntity.getBinNumber());
            jsonWriter.name("expiredate");
            this.nullableStringAdapter.toJson(jsonWriter, tokenizedBankCardEntity.getExpiryDate());
            jsonWriter.name("expiremonth");
            this.nullableIntAdapter.toJson(jsonWriter, tokenizedBankCardEntity.getExpiryMonth());
            jsonWriter.name("expireyear");
            this.nullableIntAdapter.toJson(jsonWriter, tokenizedBankCardEntity.getExpiryYear());
            jsonWriter.name("holdername");
            this.nullableStringAdapter.toJson(jsonWriter, tokenizedBankCardEntity.getHolderName());
            jsonWriter.name("isBinDiscountValid");
            this.nullableBooleanAdapter.toJson(jsonWriter, tokenizedBankCardEntity.isBinDiscountValid());
            jsonWriter.name("isForceCvv");
            this.nullableBooleanAdapter.toJson(jsonWriter, tokenizedBankCardEntity.isForceCvv());
            jsonWriter.name("isValidCard");
            this.nullableBooleanAdapter.toJson(jsonWriter, tokenizedBankCardEntity.isValid());
            jsonWriter.name("cardnumber");
            this.nullableStringAdapter.toJson(jsonWriter, tokenizedBankCardEntity.getNumber());
            jsonWriter.name(LegacyTokenLocalDataSourceImpl.KEY);
            this.nullableStringAdapter.toJson(jsonWriter, tokenizedBankCardEntity.getToken());
            jsonWriter.name("cardtype");
            this.nullableStringAdapter.toJson(jsonWriter, tokenizedBankCardEntity.getType());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
