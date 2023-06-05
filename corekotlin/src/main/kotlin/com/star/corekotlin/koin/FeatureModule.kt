package com.star.corekotlin.koin

import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

abstract class FeatureModule {
    private val modules: List<Module>
        get() = presentationModule + domainModule + dataModule + additionalModule + publicModule

    protected open val presentationModule: Module = module {}
    protected open val dataModule: Module = module {}
    protected open val domainModule: Module = module {}
    protected open val additionalModule: Module = module {}
    protected open val publicModule: Module = module {}

    fun load() {
        unloadKoinModules(modules)
        loadKoinModules(modules)
    }

    fun unload() { unloadKoinModules(modules) }
}