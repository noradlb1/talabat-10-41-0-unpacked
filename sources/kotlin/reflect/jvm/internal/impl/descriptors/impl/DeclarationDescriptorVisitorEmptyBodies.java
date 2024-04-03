package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;

public class DeclarationDescriptorVisitorEmptyBodies<R, D> implements DeclarationDescriptorVisitor<R, D> {
    public R visitClassDescriptor(ClassDescriptor classDescriptor, D d11) {
        return visitDeclarationDescriptor(classDescriptor, d11);
    }

    public R visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, D d11) {
        return visitFunctionDescriptor(constructorDescriptor, d11);
    }

    public R visitDeclarationDescriptor(DeclarationDescriptor declarationDescriptor, D d11) {
        return null;
    }

    public R visitFunctionDescriptor(FunctionDescriptor functionDescriptor, D d11) {
        return visitDeclarationDescriptor(functionDescriptor, d11);
    }

    public R visitModuleDeclaration(ModuleDescriptor moduleDescriptor, D d11) {
        return visitDeclarationDescriptor(moduleDescriptor, d11);
    }

    public R visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, D d11) {
        return visitDeclarationDescriptor(packageFragmentDescriptor, d11);
    }

    public R visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, D d11) {
        return visitDeclarationDescriptor(packageViewDescriptor, d11);
    }

    public R visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, D d11) {
        return visitVariableDescriptor(propertyDescriptor, d11);
    }

    public R visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, D d11) {
        return visitFunctionDescriptor(propertyGetterDescriptor, d11);
    }

    public R visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, D d11) {
        return visitFunctionDescriptor(propertySetterDescriptor, d11);
    }

    public R visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, D d11) {
        return visitDeclarationDescriptor(receiverParameterDescriptor, d11);
    }

    public R visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, D d11) {
        return visitDeclarationDescriptor(typeAliasDescriptor, d11);
    }

    public R visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, D d11) {
        return visitDeclarationDescriptor(typeParameterDescriptor, d11);
    }

    public R visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, D d11) {
        return visitVariableDescriptor(valueParameterDescriptor, d11);
    }

    public R visitVariableDescriptor(VariableDescriptor variableDescriptor, D d11) {
        return visitDeclarationDescriptor(variableDescriptor, d11);
    }
}
