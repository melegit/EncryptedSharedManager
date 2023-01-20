package mobi.mele.encryptedsharedmanager.di

import android.app.Application
import mobi.mele.encryptedsharedmanager.MainActivityViewModel
import mobi.mele.encryptedsharedmanager.manager.AuthEncryptedSharedPreferencesManager
import mobi.mele.encryptedsharedmanager.preferences.AuthEncryptedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

fun Application.initDi() {
    startKoin {
        androidLogger(Level.ERROR)
        androidContext(this@initDi)
        modules(appModule)
    }
}

private val appModule = module {
    factory { AuthEncryptedPreferences(get()) }
    factory { AuthEncryptedSharedPreferencesManager(get()) }
    viewModel { MainActivityViewModel(get()) }
}