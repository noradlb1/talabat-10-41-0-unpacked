package com.deliveryhero.fluid.versioning;

import com.deliveryhero.fluid.versioning.SubContract;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Target;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/versioning/CoreContract;", "Lcom/deliveryhero/fluid/versioning/SubContract;", "()V", "CreatedOn", "DeprecatedOn", "Version", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CoreContract implements SubContract {

    @SubContract.CreatedOn
    @Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.TYPEALIAS})
    @java.lang.annotation.Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/fluid/versioning/CoreContract$CreatedOn;", "", "version", "Lcom/deliveryhero/fluid/versioning/CoreContract$Version;", "()Lcom/deliveryhero/fluid/versioning/CoreContract$Version;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CreatedOn {
        Version version();
    }

    @SubContract.DeprecatedOn
    @Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.TYPEALIAS})
    @java.lang.annotation.Target({ElementType.TYPE})
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/fluid/versioning/CoreContract$DeprecatedOn;", "", "version", "Lcom/deliveryhero/fluid/versioning/CoreContract$Version;", "()Lcom/deliveryhero/fluid/versioning/CoreContract$Version;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DeprecatedOn {
        Version version();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tXD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/fluid/versioning/CoreContract$Version;", "", "Lcom/deliveryhero/fluid/versioning/SubContract$Version;", "number", "", "(Ljava/lang/String;II)V", "getNumber", "()I", "subcontractName", "", "getSubcontractName", "()Ljava/lang/String;", "V1", "V2", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Version implements SubContract.Version {
        V1(1),
        V2(2);
        
        private final int number;
        @NotNull
        private final String subcontractName;

        private Version(int i11) {
            this.number = i11;
            this.subcontractName = "Core";
        }

        public int getNumber() {
            return this.number;
        }

        @NotNull
        public String getSubcontractName() {
            return this.subcontractName;
        }
    }
}
