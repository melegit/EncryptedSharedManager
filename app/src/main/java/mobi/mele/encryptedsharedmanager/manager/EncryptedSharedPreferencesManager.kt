package mobi.mele.encryptedsharedmanager.manager

import com.google.gson.Gson
import mobi.mele.encryptedsharedmanager.preferences.AuthEncryptedPreferences


class AuthEncryptedSharedPreferencesManager(
    private val authEncryptedPreferences: AuthEncryptedPreferences
) : EncryptedSharedPreferences<Auth> {

    override suspend fun write(data: Auth) {
        authEncryptedPreferences.authEncryptedData = Gson().toJson(data)
    }

    override suspend fun read(): Auth? {
        return authEncryptedPreferences.authEncryptedData?.let {
             Gson().fromJson(it, Auth::class.java)
        }
    }

    override suspend fun reset() {
        authEncryptedPreferences.authEncryptedData = null
    }
}

interface EncryptedSharedPreferences<T> {

    suspend fun write(data: T)

    suspend fun read(): T?

    suspend fun reset()
}

data class Auth(
    val accessToken: String,
    val refreshToken: String
)