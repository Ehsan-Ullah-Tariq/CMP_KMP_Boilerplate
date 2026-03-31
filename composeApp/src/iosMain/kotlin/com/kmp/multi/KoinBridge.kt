package com.kmp.multi

import di.initKoin
import org.koin.dsl.module

private val iosModule = module {}

fun initializeKoin() {
    initKoin(additionalModules = listOf(iosModule))
}
