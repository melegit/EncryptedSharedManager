package mobi.mele.encryptedsharedmanager

import android.app.Application
import mobi.mele.encryptedsharedmanager.di.initDi

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initDi()
    }
}