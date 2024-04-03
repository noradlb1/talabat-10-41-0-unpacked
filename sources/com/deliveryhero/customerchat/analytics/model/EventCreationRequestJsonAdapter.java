package com.deliveryhero.customerchat.analytics.model;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import com.talabat.core.fwf.data.FunWithFlagsConstants;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "eventAdapter", "Lcom/deliveryhero/customerchat/analytics/model/Event;", "nullableContactAdapter", "Lcom/deliveryhero/customerchat/analytics/model/Contact;", "nullableFinancialAdapter", "Lcom/deliveryhero/customerchat/analytics/model/Financial;", "nullableOrderAdapter", "Lcom/deliveryhero/customerchat/analytics/model/Order;", "nullableScreenAdapter", "Lcom/deliveryhero/customerchat/analytics/model/Screen;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "productAdapter", "Lcom/deliveryhero/customerchat/analytics/model/Product;", "stringAdapter", "", "userAdapter", "Lcom/deliveryhero/customerchat/analytics/model/User;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EventCreationRequestJsonAdapter extends JsonAdapter<EventCreationRequest> {
    @Nullable
    private volatile Constructor<EventCreationRequest> constructorRef;
    @NotNull
    private final JsonAdapter<Event> eventAdapter;
    @NotNull
    private final JsonAdapter<Contact> nullableContactAdapter;
    @NotNull
    private final JsonAdapter<Financial> nullableFinancialAdapter;
    @NotNull
    private final JsonAdapter<Order> nullableOrderAdapter;
    @NotNull
    private final JsonAdapter<Screen> nullableScreenAdapter;
    @NotNull
    private final JsonReader.Options options;
    @NotNull
    private final JsonAdapter<Product> productAdapter;
    @NotNull
    private final JsonAdapter<String> stringAdapter;
    @NotNull
    private final JsonAdapter<User> userAdapter;

    public EventCreationRequestJsonAdapter(@NotNull Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of2 = JsonReader.Options.of(FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID, "timestamp", "event", "product", "user", "order", "contact", "screen", "financial");
        Intrinsics.checkNotNullExpressionValue(of2, "of(\"globalEntityId\", \"ti…\", \"screen\", \"financial\")");
        this.options = of2;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt__SetsKt.emptySet(), FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…,\n      \"globalEntityId\")");
        this.stringAdapter = adapter;
        JsonAdapter<Event> adapter2 = moshi.adapter(Event.class, SetsKt__SetsKt.emptySet(), "event");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Event::cla…mptySet(),\n      \"event\")");
        this.eventAdapter = adapter2;
        JsonAdapter<Product> adapter3 = moshi.adapter(Product.class, SetsKt__SetsKt.emptySet(), "product");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Product::c…tySet(),\n      \"product\")");
        this.productAdapter = adapter3;
        JsonAdapter<User> adapter4 = moshi.adapter(User.class, SetsKt__SetsKt.emptySet(), "user");
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(User::clas…java, emptySet(), \"user\")");
        this.userAdapter = adapter4;
        JsonAdapter<Order> adapter5 = moshi.adapter(Order.class, SetsKt__SetsKt.emptySet(), "order");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Order::cla…     emptySet(), \"order\")");
        this.nullableOrderAdapter = adapter5;
        JsonAdapter<Contact> adapter6 = moshi.adapter(Contact.class, SetsKt__SetsKt.emptySet(), "contact");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Contact::c…   emptySet(), \"contact\")");
        this.nullableContactAdapter = adapter6;
        JsonAdapter<Screen> adapter7 = moshi.adapter(Screen.class, SetsKt__SetsKt.emptySet(), "screen");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Screen::cl…    emptySet(), \"screen\")");
        this.nullableScreenAdapter = adapter7;
        JsonAdapter<Financial> adapter8 = moshi.adapter(Financial.class, SetsKt__SetsKt.emptySet(), "financial");
        Intrinsics.checkNotNullExpressionValue(adapter8, "moshi.adapter(Financial:… emptySet(), \"financial\")");
        this.nullableFinancialAdapter = adapter8;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(42);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("EventCreationRequest");
        sb2.append(')');
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    @NotNull
    public EventCreationRequest fromJson(@NotNull JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Intrinsics.checkNotNullParameter(jsonReader2, "reader");
        jsonReader.beginObject();
        int i11 = -1;
        String str = null;
        String str2 = null;
        Event event = null;
        Product product = null;
        User user = null;
        Order order = null;
        Contact contact = null;
        Screen screen = null;
        Financial financial = null;
        while (true) {
            Financial financial2 = financial;
            Screen screen2 = screen;
            if (jsonReader.hasNext()) {
                switch (jsonReader2.selectName(this.options)) {
                    case -1:
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        break;
                    case 0:
                        str = this.stringAdapter.fromJson(jsonReader2);
                        if (str == null) {
                            JsonDataException unexpectedNull = Util.unexpectedNull(FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID, jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"globalEn…\"globalEntityId\", reader)");
                            throw unexpectedNull;
                        }
                        break;
                    case 1:
                        str2 = this.stringAdapter.fromJson(jsonReader2);
                        if (str2 == null) {
                            JsonDataException unexpectedNull2 = Util.unexpectedNull("timestamp", "timestamp", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"timestam…     \"timestamp\", reader)");
                            throw unexpectedNull2;
                        }
                        break;
                    case 2:
                        event = this.eventAdapter.fromJson(jsonReader2);
                        if (event == null) {
                            JsonDataException unexpectedNull3 = Util.unexpectedNull("event", "event", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"event\", …ent\",\n            reader)");
                            throw unexpectedNull3;
                        }
                        break;
                    case 3:
                        product = this.productAdapter.fromJson(jsonReader2);
                        if (product == null) {
                            JsonDataException unexpectedNull4 = Util.unexpectedNull("product", "product", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"product\"…       \"product\", reader)");
                            throw unexpectedNull4;
                        }
                        break;
                    case 4:
                        user = this.userAdapter.fromJson(jsonReader2);
                        if (user == null) {
                            JsonDataException unexpectedNull5 = Util.unexpectedNull("user", "user", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"user\", \"user\",\n            reader)");
                            throw unexpectedNull5;
                        }
                        break;
                    case 5:
                        order = this.nullableOrderAdapter.fromJson(jsonReader2);
                        i11 &= -33;
                        break;
                    case 6:
                        contact = this.nullableContactAdapter.fromJson(jsonReader2);
                        i11 &= -65;
                        break;
                    case 7:
                        screen = this.nullableScreenAdapter.fromJson(jsonReader2);
                        i11 &= -129;
                        financial = financial2;
                        continue;
                    case 8:
                        financial = this.nullableFinancialAdapter.fromJson(jsonReader2);
                        i11 &= -257;
                        break;
                }
                financial = financial2;
                screen = screen2;
            } else {
                jsonReader.endObject();
                String str3 = FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID;
                String str4 = "missingProperty(\"globalE…\"globalEntityId\", reader)";
                if (i11 != -481) {
                    String str5 = "missingProperty(\"timestamp\", \"timestamp\", reader)";
                    Constructor<EventCreationRequest> constructor = this.constructorRef;
                    String str6 = "timestamp";
                    int i12 = 11;
                    if (constructor == null) {
                        Class<String> cls = String.class;
                        constructor = EventCreationRequest.class.getDeclaredConstructor(new Class[]{cls, cls, Event.class, Product.class, User.class, Order.class, Contact.class, Screen.class, Financial.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER});
                        this.constructorRef = constructor;
                        Intrinsics.checkNotNullExpressionValue(constructor, "EventCreationRequest::cl…his.constructorRef = it }");
                        i12 = 11;
                    }
                    Object[] objArr = new Object[i12];
                    if (str != null) {
                        objArr[0] = str;
                        if (str2 != null) {
                            objArr[1] = str2;
                            if (event != null) {
                                objArr[2] = event;
                                if (product != null) {
                                    objArr[3] = product;
                                    if (user != null) {
                                        objArr[4] = user;
                                        objArr[5] = order;
                                        objArr[6] = contact;
                                        objArr[7] = screen2;
                                        objArr[8] = financial2;
                                        objArr[9] = Integer.valueOf(i11);
                                        objArr[10] = null;
                                        EventCreationRequest newInstance = constructor.newInstance(objArr);
                                        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                                        return newInstance;
                                    }
                                    JsonDataException missingProperty = Util.missingProperty("user", "user", jsonReader2);
                                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"user\", \"user\", reader)");
                                    throw missingProperty;
                                }
                                JsonDataException missingProperty2 = Util.missingProperty("product", "product", jsonReader2);
                                Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"product\", \"product\", reader)");
                                throw missingProperty2;
                            }
                            JsonDataException missingProperty3 = Util.missingProperty("event", "event", jsonReader2);
                            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"event\", \"event\", reader)");
                            throw missingProperty3;
                        }
                        String str7 = str6;
                        JsonDataException missingProperty4 = Util.missingProperty(str7, str7, jsonReader2);
                        Intrinsics.checkNotNullExpressionValue(missingProperty4, str5);
                        throw missingProperty4;
                    }
                    String str8 = str3;
                    JsonDataException missingProperty5 = Util.missingProperty(str8, str8, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, str4);
                    throw missingProperty5;
                } else if (str == null) {
                    String str9 = str3;
                    JsonDataException missingProperty6 = Util.missingProperty(str9, str9, jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, str4);
                    throw missingProperty6;
                } else if (str2 == null) {
                    JsonDataException missingProperty7 = Util.missingProperty("timestamp", "timestamp", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"timestamp\", \"timestamp\", reader)");
                    throw missingProperty7;
                } else if (event == null) {
                    JsonDataException missingProperty8 = Util.missingProperty("event", "event", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty8, "missingProperty(\"event\", \"event\", reader)");
                    throw missingProperty8;
                } else if (product == null) {
                    JsonDataException missingProperty9 = Util.missingProperty("product", "product", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty9, "missingProperty(\"product\", \"product\", reader)");
                    throw missingProperty9;
                } else if (user != null) {
                    return new EventCreationRequest(str, str2, event, product, user, order, contact, screen2, financial2);
                } else {
                    JsonDataException missingProperty10 = Util.missingProperty("user", "user", jsonReader2);
                    Intrinsics.checkNotNullExpressionValue(missingProperty10, "missingProperty(\"user\", \"user\", reader)");
                    throw missingProperty10;
                }
            }
        }
    }

    public void toJson(@NotNull JsonWriter jsonWriter, @Nullable EventCreationRequest eventCreationRequest) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (eventCreationRequest != null) {
            jsonWriter.beginObject();
            jsonWriter.name(FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
            this.stringAdapter.toJson(jsonWriter, eventCreationRequest.getGlobalEntityId());
            jsonWriter.name("timestamp");
            this.stringAdapter.toJson(jsonWriter, eventCreationRequest.getTimestamp());
            jsonWriter.name("event");
            this.eventAdapter.toJson(jsonWriter, eventCreationRequest.getEvent());
            jsonWriter.name("product");
            this.productAdapter.toJson(jsonWriter, eventCreationRequest.getProduct());
            jsonWriter.name("user");
            this.userAdapter.toJson(jsonWriter, eventCreationRequest.getUser());
            jsonWriter.name("order");
            this.nullableOrderAdapter.toJson(jsonWriter, eventCreationRequest.getOrder());
            jsonWriter.name("contact");
            this.nullableContactAdapter.toJson(jsonWriter, eventCreationRequest.getContact());
            jsonWriter.name("screen");
            this.nullableScreenAdapter.toJson(jsonWriter, eventCreationRequest.getScreen());
            jsonWriter.name("financial");
            this.nullableFinancialAdapter.toJson(jsonWriter, eventCreationRequest.getFinancial());
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
