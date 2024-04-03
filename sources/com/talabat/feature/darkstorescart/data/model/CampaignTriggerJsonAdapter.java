package com.talabat.feature.darkstorescart.data.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.feature.darkstorescart.data.model.Campaign;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/CampaignTriggerJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/talabat/feature/darkstorescart/data/model/CampaignTrigger;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "campaignTypeAdapter", "Lcom/talabat/feature/darkstorescart/data/model/Campaign$CampaignType;", "constructorRef", "Ljava/lang/reflect/Constructor;", "floatAdapter", "", "intAdapter", "", "nullableIntAdapter", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "typeAdapter", "Lcom/talabat/feature/darkstorescart/data/model/Campaign$Type;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignTriggerJsonAdapter extends JsonAdapter<CampaignTrigger> {
    @NotNull
    private final JsonAdapter<Boolean> booleanAdapter;
    @NotNull
    private final JsonAdapter<Campaign.CampaignType> campaignTypeAdapter;
    @Nullable
    private volatile Constructor<CampaignTrigger> constructorRef;
    @NotNull
    private final JsonAdapter<Float> floatAdapter;
    @NotNull
    private final JsonAdapter<Integer> intAdapter;
    @NotNull
    private final JsonAdapter<Integer> nullableIntAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<String> stringAdapter;
    @NotNull
    private final JsonAdapter<Campaign.Type> typeAdapter;

    public CampaignTriggerJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of("id", "campaignType", "triggerQty", "benefitQty", "discountType", "discountValue", "usageLimit", "campaignId", "isAutoAddable");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"id\", \"campaignType\",…\",\n      \"isAutoAddable\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), "id");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…, emptySet(),\n      \"id\")");
        this.stringAdapter = adapter;
        JsonAdapter<Campaign.CampaignType> adapter2 = moshi.adapter(Campaign.CampaignType.class, SetsKt__SetsKt.emptySet(), "campaignType");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Campaign.C…ptySet(), \"campaignType\")");
        this.campaignTypeAdapter = adapter2;
        JsonAdapter<Integer> adapter3 = moshi.adapter(Integer.TYPE, SetsKt__SetsKt.emptySet(), "triggerQty");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Int::class…et(),\n      \"triggerQty\")");
        this.intAdapter = adapter3;
        JsonAdapter<Campaign.Type> adapter4 = moshi.adapter(Campaign.Type.class, SetsKt__SetsKt.emptySet(), "discountType");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Campaign.T…ptySet(), \"discountType\")");
        this.typeAdapter = adapter4;
        JsonAdapter<Float> adapter5 = moshi.adapter(Float.TYPE, SetsKt__SetsKt.emptySet(), "discountValue");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Float::cla…),\n      \"discountValue\")");
        this.floatAdapter = adapter5;
        JsonAdapter<Integer> adapter6 = moshi.adapter(Integer.class, SetsKt__SetsKt.emptySet(), "usageLimit");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Int::class…emptySet(), \"usageLimit\")");
        this.nullableIntAdapter = adapter6;
        JsonAdapter<Boolean> adapter7 = moshi.adapter(Boolean.TYPE, SetsKt__SetsKt.emptySet(), "isAutoAddable");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Boolean::c…),\n      \"isAutoAddable\")");
        this.booleanAdapter = adapter7;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CampaignTrigger");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public CampaignTrigger fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        Integer num = 0;
        Float valueOf = Float.valueOf(0.0f);
        Boolean bool = Boolean.FALSE;
        jsonReader.beginObject();
        int i11 = -1;
        String str = null;
        Campaign.CampaignType campaignType = null;
        Campaign.Type type = null;
        Integer num2 = null;
        String str2 = null;
        Boolean bool2 = bool;
        Float f11 = valueOf;
        Integer num3 = num;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(this.options)) {
                case -1:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
                case 0:
                    str = this.stringAdapter.fromJson(jsonReader2);
                    if (str != null) {
                        i11 &= -2;
                        break;
                    } else {
                        JsonDataException unexpectedNull = Util.unexpectedNull("id", "id", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"id\", \"id\", reader)");
                        throw unexpectedNull;
                    }
                case 1:
                    campaignType = this.campaignTypeAdapter.fromJson(jsonReader2);
                    if (campaignType != null) {
                        i11 &= -3;
                        break;
                    } else {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("campaignType", "campaignType", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"campaign…, \"campaignType\", reader)");
                        throw unexpectedNull2;
                    }
                case 2:
                    num = this.intAdapter.fromJson(jsonReader2);
                    if (num != null) {
                        i11 &= -5;
                        break;
                    } else {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("triggerQty", "triggerQty", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"triggerQ…    \"triggerQty\", reader)");
                        throw unexpectedNull3;
                    }
                case 3:
                    num3 = this.intAdapter.fromJson(jsonReader2);
                    if (num3 != null) {
                        i11 &= -9;
                        break;
                    } else {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("benefitQty", "benefitQty", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"benefitQ…    \"benefitQty\", reader)");
                        throw unexpectedNull4;
                    }
                case 4:
                    type = this.typeAdapter.fromJson(jsonReader2);
                    if (type != null) {
                        i11 &= -17;
                        break;
                    } else {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("discountType", "discountType", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"discount…  \"discountType\", reader)");
                        throw unexpectedNull5;
                    }
                case 5:
                    f11 = this.floatAdapter.fromJson(jsonReader2);
                    if (f11 != null) {
                        i11 &= -33;
                        break;
                    } else {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("discountValue", "discountValue", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"discount… \"discountValue\", reader)");
                        throw unexpectedNull6;
                    }
                case 6:
                    num2 = this.nullableIntAdapter.fromJson(jsonReader2);
                    i11 &= -65;
                    break;
                case 7:
                    str2 = this.stringAdapter.fromJson(jsonReader2);
                    if (str2 != null) {
                        i11 &= -129;
                        break;
                    } else {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull("campaignId", "campaignId", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"campaign…    \"campaignId\", reader)");
                        throw unexpectedNull7;
                    }
                case 8:
                    bool2 = this.booleanAdapter.fromJson(jsonReader2);
                    if (bool2 != null) {
                        i11 &= -257;
                        break;
                    } else {
                        JsonDataException unexpectedNull8 = Util.unexpectedNull("isAutoAddable", "isAutoAddable", jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull8, "unexpectedNull(\"isAutoAd… \"isAutoAddable\", reader)");
                        throw unexpectedNull8;
                    }
            }
        }
        jsonReader.endObject();
        if (i11 != -512) {
            Constructor<CampaignTrigger> constructor = this.constructorRef;
            if (constructor == null) {
                Class<String> cls = String.class;
                Class cls2 = Integer.TYPE;
                constructor = CampaignTrigger.class.getDeclaredConstructor(new Class[]{cls, Campaign.CampaignType.class, cls2, cls2, Campaign.Type.class, Float.TYPE, Integer.class, cls, Boolean.TYPE, cls2, Util.DEFAULT_CONSTRUCTOR_MARKER});
                this.constructorRef = constructor;
                Intrinsics.checkNotNullExpressionValue(constructor, "CampaignTrigger::class.j…his.constructorRef = it }");
            }
            CampaignTrigger newInstance = constructor.newInstance(new Object[]{str, campaignType, num, num3, type, f11, num2, str2, bool2, Integer.valueOf(i11), null});
            Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
            return newInstance;
        } else if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } else if (campaignType != null) {
            int intValue = num.intValue();
            int intValue2 = num3.intValue();
            if (type != null) {
                float floatValue = f11.floatValue();
                if (str2 != null) {
                    return new CampaignTrigger(str, campaignType, intValue, intValue2, type, floatValue, num2, str2, bool2.booleanValue());
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.feature.darkstorescart.data.model.Campaign.Type");
        } else {
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.feature.darkstorescart.data.model.Campaign.CampaignType");
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable CampaignTrigger campaignTrigger) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (campaignTrigger != null) {
            jsonWriter.beginObject();
            jsonWriter.name("id");
            this.stringAdapter.toJson(jsonWriter, campaignTrigger.getId());
            jsonWriter.name("campaignType");
            this.campaignTypeAdapter.toJson(jsonWriter, campaignTrigger.getCampaignType());
            jsonWriter.name("triggerQty");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(campaignTrigger.getTriggerQty()));
            jsonWriter.name("benefitQty");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(campaignTrigger.getBenefitQty()));
            jsonWriter.name("discountType");
            this.typeAdapter.toJson(jsonWriter, campaignTrigger.getDiscountType());
            jsonWriter.name("discountValue");
            this.floatAdapter.toJson(jsonWriter, Float.valueOf(campaignTrigger.getDiscountValue()));
            jsonWriter.name("usageLimit");
            this.nullableIntAdapter.toJson(jsonWriter, campaignTrigger.getUsageLimit());
            jsonWriter.name("campaignId");
            this.stringAdapter.toJson(jsonWriter, campaignTrigger.getCampaignId());
            jsonWriter.name("isAutoAddable");
            this.booleanAdapter.toJson(jsonWriter, Boolean.valueOf(campaignTrigger.isAutoAddable()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
