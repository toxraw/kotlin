// IGNORE_BACKEND: JVM_IR
// FILE: 1.kt

package test

inline fun call(s: () -> String): String {
    return s()
}

open class Base {

    protected open fun method(): String = "O"

    protected open val prop = "K"
}

// FILE: 2.kt

import test.*

class A : Base() {

    override fun method() = "fail method"

    override val prop = "fail property"

    fun test1(): String {
        return call {
            super.method() + super.prop
        }
    }

    fun test2(): String {
        return call {
            call {
                super.method() + super.prop
            }
        }
    }
}

fun box(): String {
    val a = A()
    if (a.test1() != "OK") return "fail 1: ${a.test1()}"
    return a.test2()
}
