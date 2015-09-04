/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.codegen.context;

import org.jetbrains.kotlin.codegen.OwnerKind;
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor;
import org.jetbrains.kotlin.descriptors.PackageFragmentDescriptor;
import org.jetbrains.org.objectweb.asm.Type;

public class MultifileClassPartContext extends FieldOwnerContext<PackageFragmentDescriptor> {
    private final Type multifileClassType;
    private final Type filePartType;

    public MultifileClassPartContext(
            PackageFragmentDescriptor descriptor,
            CodegenContext parent,
            Type multifileClassType,
            Type filePartType
    ) {
        super(descriptor, OwnerKind.PACKAGE, parent, null, null, null);
        this.multifileClassType = multifileClassType;
        this.filePartType = filePartType;
    }

    public Type getMultifileClassType() {
        return multifileClassType;
    }

    public Type getFilePartType() {
        return filePartType;
    }
}
