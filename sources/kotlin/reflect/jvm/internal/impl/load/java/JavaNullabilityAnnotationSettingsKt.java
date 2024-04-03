package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JavaNullabilityAnnotationsStatus;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaNullabilityAnnotationSettingsKt {
    @NotNull
    private static final FqName CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE;
    @NotNull
    private static final FqName JSPECIFY_ANNOTATIONS_PACKAGE;
    @NotNull
    private static final JavaNullabilityAnnotationsStatus JSR_305_DEFAULT_SETTINGS;
    @NotNull
    private static final NullabilityAnnotationStates<JavaNullabilityAnnotationsStatus> NULLABILITY_ANNOTATION_SETTINGS;

    static {
        FqName fqName = new FqName("org.jspecify.nullness");
        JSPECIFY_ANNOTATIONS_PACKAGE = fqName;
        FqName fqName2 = new FqName("org.checkerframework.checker.nullness.compatqual");
        CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE = fqName2;
        FqName fqName3 = new FqName("org.jetbrains.annotations");
        JavaNullabilityAnnotationsStatus.Companion companion = JavaNullabilityAnnotationsStatus.Companion;
        FqName fqName4 = new FqName("androidx.annotation.RecentlyNullable");
        ReportLevel reportLevel = ReportLevel.WARN;
        ReportLevel reportLevel2 = reportLevel;
        KotlinVersion kotlinVersion = new KotlinVersion(1, 8);
        ReportLevel reportLevel3 = ReportLevel.STRICT;
        NULLABILITY_ANNOTATION_SETTINGS = new NullabilityAnnotationStatesImpl(MapsKt__MapsKt.mapOf(TuplesKt.to(fqName3, companion.getDEFAULT()), TuplesKt.to(new FqName("androidx.annotation"), companion.getDEFAULT()), TuplesKt.to(new FqName("android.support.annotation"), companion.getDEFAULT()), TuplesKt.to(new FqName("android.annotation"), companion.getDEFAULT()), TuplesKt.to(new FqName("com.android.annotations"), companion.getDEFAULT()), TuplesKt.to(new FqName("org.eclipse.jdt.annotation"), companion.getDEFAULT()), TuplesKt.to(new FqName("org.checkerframework.checker.nullness.qual"), companion.getDEFAULT()), TuplesKt.to(fqName2, companion.getDEFAULT()), TuplesKt.to(new FqName("javax.annotation"), companion.getDEFAULT()), TuplesKt.to(new FqName("edu.umd.cs.findbugs.annotations"), companion.getDEFAULT()), TuplesKt.to(new FqName("io.reactivex.annotations"), companion.getDEFAULT()), TuplesKt.to(fqName4, new JavaNullabilityAnnotationsStatus(reportLevel2, (KotlinVersion) null, (ReportLevel) null, 4, (DefaultConstructorMarker) null)), TuplesKt.to(new FqName("androidx.annotation.RecentlyNonNull"), new JavaNullabilityAnnotationsStatus(reportLevel2, (KotlinVersion) null, (ReportLevel) null, 4, (DefaultConstructorMarker) null)), TuplesKt.to(new FqName("lombok"), companion.getDEFAULT()), TuplesKt.to(fqName, new JavaNullabilityAnnotationsStatus(reportLevel, kotlinVersion, reportLevel3)), TuplesKt.to(new FqName("io.reactivex.rxjava3.annotations"), new JavaNullabilityAnnotationsStatus(reportLevel, new KotlinVersion(1, 8), reportLevel3))));
        JSR_305_DEFAULT_SETTINGS = new JavaNullabilityAnnotationsStatus(reportLevel2, (KotlinVersion) null, (ReportLevel) null, 4, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final Jsr305Settings getDefaultJsr305Settings(@NotNull KotlinVersion kotlinVersion) {
        ReportLevel reportLevel;
        Intrinsics.checkNotNullParameter(kotlinVersion, "configuredKotlinVersion");
        JavaNullabilityAnnotationsStatus javaNullabilityAnnotationsStatus = JSR_305_DEFAULT_SETTINGS;
        if (javaNullabilityAnnotationsStatus.getSinceVersion() == null || javaNullabilityAnnotationsStatus.getSinceVersion().compareTo(kotlinVersion) > 0) {
            reportLevel = javaNullabilityAnnotationsStatus.getReportLevelBefore();
        } else {
            reportLevel = javaNullabilityAnnotationsStatus.getReportLevelAfter();
        }
        ReportLevel reportLevel2 = reportLevel;
        return new Jsr305Settings(reportLevel2, getDefaultMigrationJsr305ReportLevelForGivenGlobal(reportLevel2), (Map) null, 4, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Jsr305Settings getDefaultJsr305Settings$default(KotlinVersion kotlinVersion, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            kotlinVersion = KotlinVersion.CURRENT;
        }
        return getDefaultJsr305Settings(kotlinVersion);
    }

    @Nullable
    public static final ReportLevel getDefaultMigrationJsr305ReportLevelForGivenGlobal(@NotNull ReportLevel reportLevel) {
        Intrinsics.checkNotNullParameter(reportLevel, "globalReportLevel");
        if (reportLevel == ReportLevel.WARN) {
            return null;
        }
        return reportLevel;
    }

    @NotNull
    public static final ReportLevel getDefaultReportLevelForAnnotation(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "annotationFqName");
        return getReportLevelForAnnotation$default(fqName, NullabilityAnnotationStates.Companion.getEMPTY(), (KotlinVersion) null, 4, (Object) null);
    }

    @NotNull
    public static final FqName getJSPECIFY_ANNOTATIONS_PACKAGE() {
        return JSPECIFY_ANNOTATIONS_PACKAGE;
    }

    @NotNull
    public static final ReportLevel getReportLevelForAnnotation(@NotNull FqName fqName, @NotNull NullabilityAnnotationStates<? extends ReportLevel> nullabilityAnnotationStates, @NotNull KotlinVersion kotlinVersion) {
        Intrinsics.checkNotNullParameter(fqName, "annotation");
        Intrinsics.checkNotNullParameter(nullabilityAnnotationStates, "configuredReportLevels");
        Intrinsics.checkNotNullParameter(kotlinVersion, "configuredKotlinVersion");
        ReportLevel reportLevel = (ReportLevel) nullabilityAnnotationStates.get(fqName);
        if (reportLevel != null) {
            return reportLevel;
        }
        JavaNullabilityAnnotationsStatus javaNullabilityAnnotationsStatus = NULLABILITY_ANNOTATION_SETTINGS.get(fqName);
        if (javaNullabilityAnnotationsStatus == null) {
            return ReportLevel.IGNORE;
        }
        if (javaNullabilityAnnotationsStatus.getSinceVersion() == null || javaNullabilityAnnotationsStatus.getSinceVersion().compareTo(kotlinVersion) > 0) {
            return javaNullabilityAnnotationsStatus.getReportLevelBefore();
        }
        return javaNullabilityAnnotationsStatus.getReportLevelAfter();
    }

    public static /* synthetic */ ReportLevel getReportLevelForAnnotation$default(FqName fqName, NullabilityAnnotationStates nullabilityAnnotationStates, KotlinVersion kotlinVersion, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            kotlinVersion = new KotlinVersion(1, 7, 0);
        }
        return getReportLevelForAnnotation(fqName, nullabilityAnnotationStates, kotlinVersion);
    }
}
