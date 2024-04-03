package com.talabat.authentication.aaa;

import com.newrelic.agent.android.instrumentation.Instrumented;
import kotlin.Metadata;

@Instrumented
@Metadata(d1 = {"\u0000&\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b¢\u0006\u0002\u0010\u0005\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\f"}, d2 = {"convert", "T", "Lokhttp3/ResponseBody;", "gson", "Lcom/google/gson/Gson;", "(Lokhttp3/ResponseBody;Lcom/google/gson/Gson;)Ljava/lang/Object;", "tryParseGenericErrorBodyOrThrow", "Lcom/talabat/authentication/aaa/GenericErrorBody;", "", "Lretrofit2/HttpException;", "tryParseMigrationExchangeTokenErrorBodyOrThrow", "Lcom/talabat/authentication/aaa/MigrationExchangeTokenErrorBody;", "com_talabat_Authentication_Authentication"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class HttpExceptionExtensionsKt {
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004f, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlin.io.CloseableKt.closeFinally(r3, r4);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0058, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ <T> T convert(okhttp3.ResponseBody r3, com.google.gson.Gson r4) throws java.io.IOException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "gson"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.io.Reader r3 = r3.charStream()
            com.google.gson.stream.JsonReader r3 = r4.newJsonReader(r3)
            java.lang.String r0 = "gson.newJsonReader(charStream())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r0 = 4
            java.lang.String r1 = "T"
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r0, r1)
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            com.google.gson.reflect.TypeToken r0 = com.google.gson.reflect.TypeToken.get(r0)
            com.google.gson.TypeAdapter r4 = r4.getAdapter(r0)
            java.lang.String r0 = "gson.getAdapter(TypeToken.get(T::class.java))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r0 = 1
            java.lang.Object r4 = r4.read(r3)     // Catch:{ all -> 0x004c }
            com.google.gson.stream.JsonToken r1 = r3.peek()     // Catch:{ all -> 0x004c }
            com.google.gson.stream.JsonToken r2 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch:{ all -> 0x004c }
            if (r1 != r2) goto L_0x0044
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            return r4
        L_0x0044:
            com.google.gson.JsonIOException r4 = new com.google.gson.JsonIOException     // Catch:{ all -> 0x004c }
            java.lang.String r1 = "JSON document was not fully consumed."
            r4.<init>((java.lang.String) r1)     // Catch:{ all -> 0x004c }
            throw r4     // Catch:{ all -> 0x004c }
        L_0x004c:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x004e }
        L_0x004e:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r0)
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.aaa.HttpExceptionExtensionsKt.convert(okhttp3.ResponseBody, com.google.gson.Gson):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = (r0 = r0.errorBody()).bytes();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.talabat.authentication.aaa.GenericErrorBody tryParseGenericErrorBodyOrThrow(@org.jetbrains.annotations.NotNull retrofit2.HttpException r3, @org.jetbrains.annotations.NotNull com.google.gson.Gson r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "gson"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            retrofit2.Response r0 = r3.response()
            if (r0 == 0) goto L_0x0021
            okhttp3.ResponseBody r0 = r0.errorBody()
            if (r0 == 0) goto L_0x0021
            byte[] r0 = r0.bytes()
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = kotlin.text.StringsKt__StringsJVMKt.decodeToString(r0)
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 == 0) goto L_0x002d
            int r1 = r0.length()
            if (r1 != 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r1 = 0
            goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            if (r1 != 0) goto L_0x0045
            boolean r1 = r4 instanceof com.google.gson.Gson
            java.lang.Class<com.talabat.authentication.aaa.GenericErrorBody> r2 = com.talabat.authentication.aaa.GenericErrorBody.class
            if (r1 != 0) goto L_0x003b
            java.lang.Object r4 = r4.fromJson((java.lang.String) r0, r2)
            goto L_0x003f
        L_0x003b:
            java.lang.Object r4 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r4, (java.lang.String) r0, r2)
        L_0x003f:
            com.talabat.authentication.aaa.GenericErrorBody r4 = (com.talabat.authentication.aaa.GenericErrorBody) r4
            if (r4 == 0) goto L_0x0044
            return r4
        L_0x0044:
            throw r3
        L_0x0045:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.aaa.HttpExceptionExtensionsKt.tryParseGenericErrorBodyOrThrow(retrofit2.HttpException, com.google.gson.Gson):com.talabat.authentication.aaa.GenericErrorBody");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = (r0 = r0.errorBody()).bytes();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody tryParseMigrationExchangeTokenErrorBodyOrThrow(@org.jetbrains.annotations.NotNull retrofit2.HttpException r3, @org.jetbrains.annotations.NotNull com.google.gson.Gson r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "gson"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            retrofit2.Response r0 = r3.response()
            if (r0 == 0) goto L_0x0021
            okhttp3.ResponseBody r0 = r0.errorBody()
            if (r0 == 0) goto L_0x0021
            byte[] r0 = r0.bytes()
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = kotlin.text.StringsKt__StringsJVMKt.decodeToString(r0)
            goto L_0x0022
        L_0x0021:
            r0 = 0
        L_0x0022:
            if (r0 == 0) goto L_0x002d
            int r1 = r0.length()
            if (r1 != 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r1 = 0
            goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            if (r1 != 0) goto L_0x0045
            boolean r1 = r4 instanceof com.google.gson.Gson
            java.lang.Class<com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody> r2 = com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody.class
            if (r1 != 0) goto L_0x003b
            java.lang.Object r4 = r4.fromJson((java.lang.String) r0, r2)
            goto L_0x003f
        L_0x003b:
            java.lang.Object r4 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r4, (java.lang.String) r0, r2)
        L_0x003f:
            com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody r4 = (com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody) r4
            if (r4 == 0) goto L_0x0044
            return r4
        L_0x0044:
            throw r3
        L_0x0045:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.aaa.HttpExceptionExtensionsKt.tryParseMigrationExchangeTokenErrorBodyOrThrow(retrofit2.HttpException, com.google.gson.Gson):com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        throw r5;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.talabat.authentication.aaa.GenericErrorBody tryParseGenericErrorBodyOrThrow(@org.jetbrains.annotations.NotNull java.lang.Throwable r4, @org.jetbrains.annotations.NotNull com.google.gson.Gson r5) throws com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSourceException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "gson"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r4 instanceof retrofit2.HttpException
            r1 = 0
            if (r0 == 0) goto L_0x0013
            r0 = r4
            retrofit2.HttpException r0 = (retrofit2.HttpException) r0
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            if (r0 == 0) goto L_0x0061
            retrofit2.Response r0 = r0.response()
            if (r0 == 0) goto L_0x0061
            okhttp3.ResponseBody r0 = r0.errorBody()
            if (r0 == 0) goto L_0x0061
            java.io.Reader r0 = r0.charStream()
            com.google.gson.stream.JsonReader r0 = r5.newJsonReader(r0)
            java.lang.String r2 = "gson.newJsonReader(charStream())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.Class<com.talabat.authentication.aaa.GenericErrorBody> r2 = com.talabat.authentication.aaa.GenericErrorBody.class
            com.google.gson.reflect.TypeToken r2 = com.google.gson.reflect.TypeToken.get(r2)
            com.google.gson.TypeAdapter r5 = r5.getAdapter(r2)
            java.lang.String r2 = "gson.getAdapter(TypeToken.get(T::class.java))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            java.lang.Object r5 = r5.read(r0)     // Catch:{ all -> 0x005a }
            com.google.gson.stream.JsonToken r2 = r0.peek()     // Catch:{ all -> 0x005a }
            com.google.gson.stream.JsonToken r3 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch:{ all -> 0x005a }
            if (r2 != r3) goto L_0x0052
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            com.talabat.authentication.aaa.GenericErrorBody r5 = (com.talabat.authentication.aaa.GenericErrorBody) r5
            if (r5 == 0) goto L_0x0061
            return r5
        L_0x0052:
            com.google.gson.JsonIOException r4 = new com.google.gson.JsonIOException     // Catch:{ all -> 0x005a }
            java.lang.String r5 = "JSON document was not fully consumed."
            r4.<init>((java.lang.String) r5)     // Catch:{ all -> 0x005a }
            throw r4     // Catch:{ all -> 0x005a }
        L_0x005a:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x005c }
        L_0x005c:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r4)
            throw r5
        L_0x0061:
            com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSourceException r5 = new com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSourceException
            java.lang.String r0 = "An error occurred while trying to fetch token data"
            r5.<init>(r0, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.aaa.HttpExceptionExtensionsKt.tryParseGenericErrorBodyOrThrow(java.lang.Throwable, com.google.gson.Gson):com.talabat.authentication.aaa.GenericErrorBody");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005d, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        throw r5;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody tryParseMigrationExchangeTokenErrorBodyOrThrow(@org.jetbrains.annotations.NotNull java.lang.Throwable r4, @org.jetbrains.annotations.NotNull com.google.gson.Gson r5) throws com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSourceException {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "gson"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r4 instanceof retrofit2.HttpException
            r1 = 0
            if (r0 == 0) goto L_0x0013
            r0 = r4
            retrofit2.HttpException r0 = (retrofit2.HttpException) r0
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            if (r0 == 0) goto L_0x0061
            retrofit2.Response r0 = r0.response()
            if (r0 == 0) goto L_0x0061
            okhttp3.ResponseBody r0 = r0.errorBody()
            if (r0 == 0) goto L_0x0061
            java.io.Reader r0 = r0.charStream()
            com.google.gson.stream.JsonReader r0 = r5.newJsonReader(r0)
            java.lang.String r2 = "gson.newJsonReader(charStream())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.Class<com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody> r2 = com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody.class
            com.google.gson.reflect.TypeToken r2 = com.google.gson.reflect.TypeToken.get(r2)
            com.google.gson.TypeAdapter r5 = r5.getAdapter(r2)
            java.lang.String r2 = "gson.getAdapter(TypeToken.get(T::class.java))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            java.lang.Object r5 = r5.read(r0)     // Catch:{ all -> 0x005a }
            com.google.gson.stream.JsonToken r2 = r0.peek()     // Catch:{ all -> 0x005a }
            com.google.gson.stream.JsonToken r3 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch:{ all -> 0x005a }
            if (r2 != r3) goto L_0x0052
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody r5 = (com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody) r5
            if (r5 == 0) goto L_0x0061
            return r5
        L_0x0052:
            com.google.gson.JsonIOException r4 = new com.google.gson.JsonIOException     // Catch:{ all -> 0x005a }
            java.lang.String r5 = "JSON document was not fully consumed."
            r4.<init>((java.lang.String) r5)     // Catch:{ all -> 0x005a }
            throw r4     // Catch:{ all -> 0x005a }
        L_0x005a:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x005c }
        L_0x005c:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r4)
            throw r5
        L_0x0061:
            com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSourceException r5 = new com.talabat.authentication.authenticate.data.remote.AuthenticationRemoteDataSourceException
            java.lang.String r0 = "An error occurred while trying to fetch token data"
            r5.<init>(r0, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.authentication.aaa.HttpExceptionExtensionsKt.tryParseMigrationExchangeTokenErrorBodyOrThrow(java.lang.Throwable, com.google.gson.Gson):com.talabat.authentication.aaa.MigrationExchangeTokenErrorBody");
    }
}
