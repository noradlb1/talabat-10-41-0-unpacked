package com.talabat.language_selector;

import JsonModels.parser.UniversalGson;
import android.app.Activity;
import android.app.Dialog;
import android.content.res.AssetManager;
import androidx.navigation.compose.DialogNavigator;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.helpers.GlobalDataModel;
import com.tekartik.sqflite.Constant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fH\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\u00020\n*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/language_selector/SupportedLanguagesProvider;", "", "activity", "Landroid/app/Activity;", "dialog", "Landroid/app/Dialog;", "languageSelectorDialogClickListener", "Lcom/talabat/language_selector/LanguageSelectorDialogClickListener;", "(Landroid/app/Activity;Landroid/app/Dialog;Lcom/talabat/language_selector/LanguageSelectorDialogClickListener;)V", "getLanguageFileName", "", "getSupportedLanguage", "Lcom/talabat/language_selector/SupportedLanguagesProvider$AppLanguages;", "kotlin.jvm.PlatformType", "getSupportedLanguages", "", "Lcom/talabat/language_selector/LanguageViewEntity;", "mapToLanguageViewEntity", "it", "Lcom/talabat/language_selector/SupportedLanguagesProvider$SupportedLanguage;", "readAssetsFile", "Landroid/content/res/AssetManager;", "fileName", "AppLanguages", "SupportedLanguage", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SupportedLanguagesProvider {
    @NotNull
    private final Activity activity;
    @NotNull
    private final Dialog dialog;
    @NotNull
    private final LanguageSelectorDialogClickListener languageSelectorDialogClickListener;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/language_selector/SupportedLanguagesProvider$AppLanguages;", "", "languages", "", "Lcom/talabat/language_selector/SupportedLanguagesProvider$SupportedLanguage;", "(Ljava/util/List;)V", "getLanguages", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AppLanguages {
        @NotNull
        private final List<SupportedLanguage> languages;

        public AppLanguages(@NotNull List<SupportedLanguage> list) {
            Intrinsics.checkNotNullParameter(list, "languages");
            this.languages = list;
        }

        public static /* synthetic */ AppLanguages copy$default(AppLanguages appLanguages, List<SupportedLanguage> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = appLanguages.languages;
            }
            return appLanguages.copy(list);
        }

        @NotNull
        public final List<SupportedLanguage> component1() {
            return this.languages;
        }

        @NotNull
        public final AppLanguages copy(@NotNull List<SupportedLanguage> list) {
            Intrinsics.checkNotNullParameter(list, "languages");
            return new AppLanguages(list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AppLanguages) && Intrinsics.areEqual((Object) this.languages, (Object) ((AppLanguages) obj).languages);
        }

        @NotNull
        public final List<SupportedLanguage> getLanguages() {
            return this.languages;
        }

        public int hashCode() {
            return this.languages.hashCode();
        }

        @NotNull
        public String toString() {
            List<SupportedLanguage> list = this.languages;
            return "AppLanguages(languages=" + list + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/language_selector/SupportedLanguagesProvider$SupportedLanguage;", "", "name", "", "code", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SupportedLanguage {
        @NotNull
        private final String code;
        @NotNull

        /* renamed from: name  reason: collision with root package name */
        private final String f61004name;

        public SupportedLanguage(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, Constant.PARAM_ERROR_CODE);
            this.f61004name = str;
            this.code = str2;
        }

        public static /* synthetic */ SupportedLanguage copy$default(SupportedLanguage supportedLanguage, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = supportedLanguage.f61004name;
            }
            if ((i11 & 2) != 0) {
                str2 = supportedLanguage.code;
            }
            return supportedLanguage.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.f61004name;
        }

        @NotNull
        public final String component2() {
            return this.code;
        }

        @NotNull
        public final SupportedLanguage copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, Constant.PARAM_ERROR_CODE);
            return new SupportedLanguage(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SupportedLanguage)) {
                return false;
            }
            SupportedLanguage supportedLanguage = (SupportedLanguage) obj;
            return Intrinsics.areEqual((Object) this.f61004name, (Object) supportedLanguage.f61004name) && Intrinsics.areEqual((Object) this.code, (Object) supportedLanguage.code);
        }

        @NotNull
        public final String getCode() {
            return this.code;
        }

        @NotNull
        public final String getName() {
            return this.f61004name;
        }

        public int hashCode() {
            return (this.f61004name.hashCode() * 31) + this.code.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.f61004name;
            String str2 = this.code;
            return "SupportedLanguage(name=" + str + ", code=" + str2 + ")";
        }
    }

    public SupportedLanguagesProvider(@NotNull Activity activity2, @NotNull Dialog dialog2, @NotNull LanguageSelectorDialogClickListener languageSelectorDialogClickListener2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(dialog2, DialogNavigator.NAME);
        Intrinsics.checkNotNullParameter(languageSelectorDialogClickListener2, "languageSelectorDialogClickListener");
        this.activity = activity2;
        this.dialog = dialog2;
        this.languageSelectorDialogClickListener = languageSelectorDialogClickListener2;
    }

    private final String getLanguageFileName() {
        return GlobalDataModel.SelectedCountryId == 10 ? "language_kurdish.json" : "language.json";
    }

    private final AppLanguages getSupportedLanguage() {
        Object obj;
        Gson gson = UniversalGson.INSTANCE.gson;
        AssetManager assets = this.activity.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "activity.assets");
        String readAssetsFile = readAssetsFile(assets, getLanguageFileName());
        Class cls = AppLanguages.class;
        if (!(gson instanceof Gson)) {
            obj = gson.fromJson(readAssetsFile, cls);
        } else {
            obj = GsonInstrumentation.fromJson(gson, readAssetsFile, cls);
        }
        return (AppLanguages) obj;
    }

    private final LanguageViewEntity mapToLanguageViewEntity(SupportedLanguage supportedLanguage) {
        return new LanguageViewEntity(supportedLanguage.getName(), Intrinsics.areEqual((Object) GlobalDataModel.SelectedLanguage, (Object) supportedLanguage.getCode()), this.dialog, supportedLanguage.getCode(), this.languageSelectorDialogClickListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String readAssetsFile(android.content.res.AssetManager r2, java.lang.String r3) {
        /*
            r1 = this;
            java.io.InputStream r2 = r2.open(r3)
            java.lang.String r3 = "open(fileName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.nio.charset.Charset r3 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r2, r3)
            boolean r2 = r0 instanceof java.io.BufferedReader
            if (r2 == 0) goto L_0x0017
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0
            goto L_0x001f
        L_0x0017:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            r3 = 8192(0x2000, float:1.14794E-41)
            r2.<init>(r0, r3)
            r0 = r2
        L_0x001f:
            java.lang.String r2 = kotlin.io.TextStreamsKt.readText(r0)     // Catch:{ all -> 0x0028 }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            return r2
        L_0x0028:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x002a }
        L_0x002a:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.language_selector.SupportedLanguagesProvider.readAssetsFile(android.content.res.AssetManager, java.lang.String):java.lang.String");
    }

    @NotNull
    public final List<LanguageViewEntity> getSupportedLanguages() {
        Iterable<SupportedLanguage> languages = getSupportedLanguage().getLanguages();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(languages, 10));
        for (SupportedLanguage mapToLanguageViewEntity : languages) {
            arrayList.add(mapToLanguageViewEntity(mapToLanguageViewEntity));
        }
        return arrayList;
    }
}
