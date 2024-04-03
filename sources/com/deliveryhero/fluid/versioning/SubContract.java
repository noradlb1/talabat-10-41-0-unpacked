package com.deliveryhero.fluid.versioning;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/fluid/versioning/SubContract;", "", "CreatedOn", "DeprecatedOn", "Version", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SubContract {

    @Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
    @Retention(AnnotationRetention.RUNTIME)
    @java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/deliveryhero/fluid/versioning/SubContract$CreatedOn;", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
    public @interface CreatedOn {
    }

    @Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
    @Retention(AnnotationRetention.RUNTIME)
    @java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/deliveryhero/fluid/versioning/SubContract$DeprecatedOn;", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
    public @interface DeprecatedOn {
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/deliveryhero/fluid/versioning/SubContract$Version;", "", "number", "", "getNumber", "()I", "subcontractName", "", "getSubcontractName", "()Ljava/lang/String;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Version {
        int getNumber();

        @NotNull
        String getSubcontractName();
    }
}
