package com.airbnb.lottie.compose;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0001\u0006\b\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "", "Asset", "ContentProvider", "File", "JsonString", "RawRes", "Url", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$RawRes;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$Url;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$File;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$Asset;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$JsonString;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$ContentProvider;", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface LottieCompositionSpec {

    @JvmInline
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$Asset;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "assetName", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getAssetName", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Asset implements LottieCompositionSpec {
        @NotNull
        private final String assetName;

        private /* synthetic */ Asset(String str) {
            this.assetName = str;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Asset m9147boximpl(String str) {
            return new Asset(str);
        }

        @NotNull
        /* renamed from: constructor-impl  reason: not valid java name */
        public static String m9148constructorimpl(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "assetName");
            return str;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m9149equalsimpl(String str, Object obj) {
            return (obj instanceof Asset) && Intrinsics.areEqual((Object) str, (Object) ((Asset) obj).m9153unboximpl());
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m9150equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual((Object) str, (Object) str2);
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m9151hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m9152toStringimpl(String str) {
            return "Asset(assetName=" + str + ')';
        }

        public boolean equals(Object obj) {
            return m9149equalsimpl(this.assetName, obj);
        }

        @NotNull
        public final String getAssetName() {
            return this.assetName;
        }

        public int hashCode() {
            return m9151hashCodeimpl(this.assetName);
        }

        public String toString() {
            return m9152toStringimpl(this.assetName);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ String m9153unboximpl() {
            return this.assetName;
        }
    }

    @JvmInline
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$ContentProvider;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "uri", "Landroid/net/Uri;", "constructor-impl", "(Landroid/net/Uri;)Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "equals", "", "other", "", "equals-impl", "(Landroid/net/Uri;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroid/net/Uri;)I", "toString", "", "toString-impl", "(Landroid/net/Uri;)Ljava/lang/String;", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ContentProvider implements LottieCompositionSpec {
        @NotNull
        private final Uri uri;

        private /* synthetic */ ContentProvider(Uri uri2) {
            this.uri = uri2;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ ContentProvider m9154boximpl(Uri uri2) {
            return new ContentProvider(uri2);
        }

        @NotNull
        /* renamed from: constructor-impl  reason: not valid java name */
        public static Uri m9155constructorimpl(@NotNull Uri uri2) {
            Intrinsics.checkNotNullParameter(uri2, "uri");
            return uri2;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m9156equalsimpl(Uri uri2, Object obj) {
            return (obj instanceof ContentProvider) && Intrinsics.areEqual((Object) uri2, (Object) ((ContentProvider) obj).m9160unboximpl());
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m9157equalsimpl0(Uri uri2, Uri uri3) {
            return Intrinsics.areEqual((Object) uri2, (Object) uri3);
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m9158hashCodeimpl(Uri uri2) {
            return uri2.hashCode();
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m9159toStringimpl(Uri uri2) {
            return "ContentProvider(uri=" + uri2 + ')';
        }

        public boolean equals(Object obj) {
            return m9156equalsimpl(this.uri, obj);
        }

        @NotNull
        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            return m9158hashCodeimpl(this.uri);
        }

        public String toString() {
            return m9159toStringimpl(this.uri);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ Uri m9160unboximpl() {
            return this.uri;
        }
    }

    @JvmInline
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$File;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "fileName", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getFileName", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class File implements LottieCompositionSpec {
        @NotNull
        private final String fileName;

        private /* synthetic */ File(String str) {
            this.fileName = str;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ File m9161boximpl(String str) {
            return new File(str);
        }

        @NotNull
        /* renamed from: constructor-impl  reason: not valid java name */
        public static String m9162constructorimpl(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "fileName");
            return str;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m9163equalsimpl(String str, Object obj) {
            return (obj instanceof File) && Intrinsics.areEqual((Object) str, (Object) ((File) obj).m9167unboximpl());
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m9164equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual((Object) str, (Object) str2);
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m9165hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m9166toStringimpl(String str) {
            return "File(fileName=" + str + ')';
        }

        public boolean equals(Object obj) {
            return m9163equalsimpl(this.fileName, obj);
        }

        @NotNull
        public final String getFileName() {
            return this.fileName;
        }

        public int hashCode() {
            return m9165hashCodeimpl(this.fileName);
        }

        public String toString() {
            return m9166toStringimpl(this.fileName);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ String m9167unboximpl() {
            return this.fileName;
        }
    }

    @JvmInline
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$JsonString;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "jsonString", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getJsonString", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class JsonString implements LottieCompositionSpec {
        @NotNull
        private final String jsonString;

        private /* synthetic */ JsonString(String str) {
            this.jsonString = str;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ JsonString m9168boximpl(String str) {
            return new JsonString(str);
        }

        @NotNull
        /* renamed from: constructor-impl  reason: not valid java name */
        public static String m9169constructorimpl(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "jsonString");
            return str;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m9170equalsimpl(String str, Object obj) {
            return (obj instanceof JsonString) && Intrinsics.areEqual((Object) str, (Object) ((JsonString) obj).m9174unboximpl());
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m9171equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual((Object) str, (Object) str2);
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m9172hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m9173toStringimpl(String str) {
            return "JsonString(jsonString=" + str + ')';
        }

        public boolean equals(Object obj) {
            return m9170equalsimpl(this.jsonString, obj);
        }

        @NotNull
        public final String getJsonString() {
            return this.jsonString;
        }

        public int hashCode() {
            return m9172hashCodeimpl(this.jsonString);
        }

        public String toString() {
            return m9173toStringimpl(this.jsonString);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ String m9174unboximpl() {
            return this.jsonString;
        }
    }

    @JvmInline
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u0014\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$RawRes;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "resId", "", "constructor-impl", "(I)I", "getResId", "()I", "equals", "", "other", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class RawRes implements LottieCompositionSpec {
        private final int resId;

        private /* synthetic */ RawRes(@androidx.annotation.RawRes int i11) {
            this.resId = i11;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ RawRes m9175boximpl(int i11) {
            return new RawRes(i11);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static int m9176constructorimpl(@androidx.annotation.RawRes int i11) {
            return i11;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m9177equalsimpl(int i11, Object obj) {
            return (obj instanceof RawRes) && i11 == ((RawRes) obj).m9181unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m9178equalsimpl0(int i11, int i12) {
            return i11 == i12;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m9179hashCodeimpl(int i11) {
            return i11;
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m9180toStringimpl(int i11) {
            return "RawRes(resId=" + i11 + ')';
        }

        public boolean equals(Object obj) {
            return m9177equalsimpl(this.resId, obj);
        }

        public final int getResId() {
            return this.resId;
        }

        public int hashCode() {
            return m9179hashCodeimpl(this.resId);
        }

        public String toString() {
            return m9180toStringimpl(this.resId);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ int m9181unboximpl() {
            return this.resId;
        }
    }

    @JvmInline
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$Url;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "url", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "lottie-compose_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Url implements LottieCompositionSpec {
        @NotNull
        private final String url;

        private /* synthetic */ Url(String str) {
            this.url = str;
        }

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ Url m9182boximpl(String str) {
            return new Url(str);
        }

        @NotNull
        /* renamed from: constructor-impl  reason: not valid java name */
        public static String m9183constructorimpl(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return str;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m9184equalsimpl(String str, Object obj) {
            return (obj instanceof Url) && Intrinsics.areEqual((Object) str, (Object) ((Url) obj).m9188unboximpl());
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m9185equalsimpl0(String str, String str2) {
            return Intrinsics.areEqual((Object) str, (Object) str2);
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m9186hashCodeimpl(String str) {
            return str.hashCode();
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m9187toStringimpl(String str) {
            return "Url(url=" + str + ')';
        }

        public boolean equals(Object obj) {
            return m9184equalsimpl(this.url, obj);
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return m9186hashCodeimpl(this.url);
        }

        public String toString() {
            return m9187toStringimpl(this.url);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ String m9188unboximpl() {
            return this.url;
        }
    }
}
