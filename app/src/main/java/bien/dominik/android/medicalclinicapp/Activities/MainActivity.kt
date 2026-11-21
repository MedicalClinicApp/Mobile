package bien.dominik.android.medicalclinicapp.Activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import bien.dominik.android.medicalclinicapp.screens.LoginScreen
import bien.dominik.android.medicalclinicapp.ui.theme.MedicalClinicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        enableEdgeToEdge()
        setContent {

            MedicalClinicAppTheme(darkTheme = false) {
                LoginScreen()

            }
        }
    }
}