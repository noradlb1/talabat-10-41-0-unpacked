package com.newrelic.agent.android.instrumentation;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class GsonInstrumentation {
    private static final ArrayList<String> categoryParams = new ArrayList<>(Arrays.asList(new String[]{"category", MetricCategory.class.getName(), "JSON"}));

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static <T> T fromJson(Gson gson, String str, Class<T> cls) throws JsonSyntaxException {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        T fromJson = gson.fromJson(str, cls);
        TraceMachine.exitMethod();
        return fromJson;
    }

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static String toJson(Gson gson, Object obj) {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        String json = gson.toJson(obj);
        TraceMachine.exitMethod();
        return json;
    }

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static <T> T fromJson(Gson gson, String str, Type type) throws JsonSyntaxException {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        T fromJson = gson.fromJson(str, type);
        TraceMachine.exitMethod();
        return fromJson;
    }

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static String toJson(Gson gson, Object obj, Type type) {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        String json = gson.toJson(obj, type);
        TraceMachine.exitMethod();
        return json;
    }

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static <T> T fromJson(Gson gson, Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        T fromJson = gson.fromJson(reader, cls);
        TraceMachine.exitMethod();
        return fromJson;
    }

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static void toJson(Gson gson, Object obj, Appendable appendable) throws JsonIOException {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(obj, appendable);
        TraceMachine.exitMethod();
    }

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static <T> T fromJson(Gson gson, Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        T fromJson = gson.fromJson(reader, type);
        TraceMachine.exitMethod();
        return fromJson;
    }

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static void toJson(Gson gson, Object obj, Type type, Appendable appendable) throws JsonIOException {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(obj, type, appendable);
        TraceMachine.exitMethod();
    }

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static <T> T fromJson(Gson gson, JsonReader jsonReader, Type type) throws JsonIOException, JsonSyntaxException {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        T fromJson = gson.fromJson(jsonReader, type);
        TraceMachine.exitMethod();
        return fromJson;
    }

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static void toJson(Gson gson, Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(obj, type, jsonWriter);
        TraceMachine.exitMethod();
    }

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static <T> T fromJson(Gson gson, JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        T fromJson = gson.fromJson(jsonElement, cls);
        TraceMachine.exitMethod();
        return fromJson;
    }

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static String toJson(Gson gson, JsonElement jsonElement) {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        String json = gson.toJson(jsonElement);
        TraceMachine.exitMethod();
        return json;
    }

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static <T> T fromJson(Gson gson, JsonElement jsonElement, Type type) throws JsonSyntaxException {
        TraceMachine.enterMethod("Gson#fromJson", categoryParams);
        T fromJson = gson.fromJson(jsonElement, type);
        TraceMachine.exitMethod();
        return fromJson;
    }

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static void toJson(Gson gson, JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(jsonElement, appendable);
        TraceMachine.exitMethod();
    }

    @ReplaceCallSite(scope = "com.google.gson.Gson")
    public static void toJson(Gson gson, JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        TraceMachine.enterMethod("Gson#toJson", categoryParams);
        gson.toJson(jsonElement, jsonWriter);
        TraceMachine.exitMethod();
    }
}
