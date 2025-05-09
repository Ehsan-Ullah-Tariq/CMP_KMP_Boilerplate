package com.kmp.multi

import di.initKoin
import org.koin.dsl.module

val iosModules = module {

}

fun initKoinIOS() = initKoin(additionalModules = listOf(iosModules))
