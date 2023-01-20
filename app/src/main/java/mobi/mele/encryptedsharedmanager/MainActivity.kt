package mobi.mele.encryptedsharedmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mobi.mele.encryptedsharedmanager.manager.Auth
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val auth = Auth(
            accessToken = "dummy-access-token",
            refreshToken = "dummy-refresh-token"
        )

        viewModel.writeAuthData(auth)
        viewModel.read()
    }
}