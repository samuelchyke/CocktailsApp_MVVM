package com.itc.cocktailapp.ui

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.itc.cocktailapp.cache.CocktailDatabase
import com.itc.cocktailapp.cache.CocktailsDAO
import com.itc.cocktailapp.repository.mocks.FakeCacheRepo
import com.itc.cocktailapp.repository.mocks.FakeNetworkRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class MainViewModelTest{

    private lateinit var viewModel: MainViewModel
    private lateinit var db: CocktailDatabase
    private lateinit var cocktailsDao: CocktailsDAO
    private lateinit var fakeCacheRepo: FakeCacheRepo
    private lateinit var fakeNetworkRepo: FakeNetworkRepo

    @Before
    fun setUp() {

        fakeNetworkRepo = FakeNetworkRepo()
        fakeCacheRepo = FakeCacheRepo()

        val context = ApplicationProvider.getApplicationContext<Context>()

        db = Room.inMemoryDatabaseBuilder(context, CocktailDatabase::class.java)
            .allowMainThreadQueries().build()

        cocktailsDao = db.cocktailsDAO()

        viewModel = MainViewModel(FakeNetworkRepo(), FakeCacheRepo(), context)

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        db.close()
    }

    @Test
    fun searchForCocktailsInNetwork() {

        val a = viewModel.searchCocktails("A")

        viewModel.cocktails.observeForever{
            assertThat(it).isEqualTo(a)
        }

    }

    @Test
    fun `get cocktails from database _ not null`() = runTest {

        val dataFromDB = viewModel.getCocktailsFromDB("")

        dataFromDB.observeForever {
            assertThat(it).isNotNull()
        }

    }

}