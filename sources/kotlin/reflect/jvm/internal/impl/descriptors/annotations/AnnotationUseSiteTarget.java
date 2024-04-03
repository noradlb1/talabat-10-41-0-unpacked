package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;

public enum AnnotationUseSiteTarget {
    FIELD((String) null, 1, (String) null),
    FILE((String) null, 1, (String) null),
    PROPERTY((String) null, 1, (String) null),
    PROPERTY_GETTER("get"),
    PROPERTY_SETTER("set"),
    RECEIVER((String) null, 1, (String) null),
    CONSTRUCTOR_PARAMETER(RemoteMessageConst.MessageBody.PARAM),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD(MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
    
    @NotNull
    private final String renderName;

    private AnnotationUseSiteTarget(String str) {
        this.renderName = str == null ? CapitalizeDecapitalizeKt.toLowerCaseAsciiOnly(name()) : str;
    }

    @NotNull
    public final String getRenderName() {
        return this.renderName;
    }
}
