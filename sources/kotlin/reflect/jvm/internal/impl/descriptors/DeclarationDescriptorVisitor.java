package kotlin.reflect.jvm.internal.impl.descriptors;

public interface DeclarationDescriptorVisitor<R, D> {
    R visitClassDescriptor(ClassDescriptor classDescriptor, D d11);

    R visitConstructorDescriptor(ConstructorDescriptor constructorDescriptor, D d11);

    R visitFunctionDescriptor(FunctionDescriptor functionDescriptor, D d11);

    R visitModuleDeclaration(ModuleDescriptor moduleDescriptor, D d11);

    R visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, D d11);

    R visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, D d11);

    R visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, D d11);

    R visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, D d11);

    R visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, D d11);

    R visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, D d11);

    R visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, D d11);

    R visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, D d11);

    R visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, D d11);
}
