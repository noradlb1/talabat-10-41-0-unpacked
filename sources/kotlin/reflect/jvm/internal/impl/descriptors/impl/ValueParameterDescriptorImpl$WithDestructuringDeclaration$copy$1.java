package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import org.jetbrains.annotations.NotNull;

public final class ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1 extends Lambda implements Function0<List<? extends VariableDescriptor>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ValueParameterDescriptorImpl.WithDestructuringDeclaration f24559g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1(ValueParameterDescriptorImpl.WithDestructuringDeclaration withDestructuringDeclaration) {
        super(0);
        this.f24559g = withDestructuringDeclaration;
    }

    @NotNull
    public final List<VariableDescriptor> invoke() {
        return this.f24559g.getDestructuringVariables();
    }
}
