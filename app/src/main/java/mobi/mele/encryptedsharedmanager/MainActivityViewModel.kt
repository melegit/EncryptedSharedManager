package mobi.mele.encryptedsharedmanager

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import mobi.mele.encryptedsharedmanager.manager.Auth
import mobi.mele.encryptedsharedmanager.manager.AuthEncryptedSharedPreferencesManager

class MainActivityViewModel(
    private val authEncryptedSharedPreferencesManager: AuthEncryptedSharedPreferencesManager
) : ViewModel() {

    val auth = Auth(
        accessToken = "dummy-access-token",
        refreshToken = "dummy-refresh-token"
    )

    init {
        viewModelScope.launch {
            //writeAuthData(auth)
            delay(500)
            Log.d("AUTH DATA", ":${readAuthData()}")
        }
    }

    fun writeAuthData(auth: Auth) {
        viewModelScope.launch {
            authEncryptedSharedPreferencesManager.write(auth)
        }
    }

    fun read(){
        viewModelScope.launch {
            Log.d("AUTH DATA", ":${readAuthData()}")
        }
    }
    suspend fun readAuthData(): Auth? = withContext(Dispatchers.IO) {
        authEncryptedSharedPreferencesManager.read()
    }

    fun resetAuthData() {
        viewModelScope.launch {
            authEncryptedSharedPreferencesManager.reset()
        }
    }

}