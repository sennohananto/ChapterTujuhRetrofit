package com.binar.chaptertujuhretrofit.add

import com.binar.chaptertujuhretrofit.di.appModule
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.Mockito
import org.mockito.Mockito.mock

class AddPersonPresenterTest : KoinTest {

    private val view: AddPersonPresenter.Listener = mock(AddPersonPresenter.Listener::class.java)
    private val presenter: AddPersonPresenter by inject { parametersOf(view) }

    @Before
    fun before() {
        startKoin {
            modules(appModule)
        }
    }

    @Test
    fun addPerson() {
        presenter.addPerson("Senno","Hananto")
        Mockito.verify(view).onAddPersonSuccess("Success")
    }

    @Test
    fun getListener() {
        Assert.assertNotNull(presenter.listener)
    }

    @Test
    fun getApiService() {
        Assert.assertNotNull(presenter.apiService)
    }
}