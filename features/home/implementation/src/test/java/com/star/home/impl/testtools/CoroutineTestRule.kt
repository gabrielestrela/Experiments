package com.star.home.impl.testtools

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

@ExperimentalCoroutinesApi
class CoroutineTestRule(
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()
) : BeforeEachCallback, AfterEachCallback, TestCoroutineScope by TestCoroutineScope(testDispatcher) {

    /**
     * Set TestCoroutine dispatcher as main
     */
    override fun beforeEach(context: ExtensionContext?) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun afterEach(context: ExtensionContext?) {
        Dispatchers.resetMain()
    }
}