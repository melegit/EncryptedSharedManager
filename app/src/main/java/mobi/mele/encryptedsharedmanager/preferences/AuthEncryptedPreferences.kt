package mobi.mele.encryptedsharedmanager.preferences

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import mobi.mele.encryptedsharedmanager.manager.Auth


class AuthEncryptedPreferences(val context: Context) {

    private val prefsFileName = "PREFS_AUTH"
    private val authEncryptedDataKey = "AUTH_ENCRYPTED_DATA"

    var masterKeyAlias: String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    var encryptedPreferences = EncryptedSharedPreferences.create(
        prefsFileName,
        masterKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    var authEncryptedData: String?
        get() = encryptedPreferences.getString(authEncryptedDataKey, null)
        set(value) = encryptedPreferences.edit().putString(authEncryptedDataKey, value).apply()

    fun clearPreferences(){
        encryptedPreferences.edit().clear().apply()
    }
}