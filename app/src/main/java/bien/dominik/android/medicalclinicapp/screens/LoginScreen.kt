package bien.dominik.android.medicalclinicapp.screens

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bien.dominik.android.medicalclinicapp.Activities.MainActivity
import bien.dominik.android.medicalclinicapp.Activities.PatientActivity
import bien.dominik.android.medicalclinicapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
        Scaffold(
            modifier = Modifier.background(Color.Red)
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                TopBar()
                LoginView()


            }


        }
    }

    @Composable
    fun TopBar() {
        Box(
            modifier = Modifier.fillMaxWidth().height(100.dp).background(Color(0xFF2196F3))
        )
    }

    @Composable
    fun LoginView() {
        val context = LocalContext.current
        val intent: Intent = Intent(context, PatientActivity::class.java)
        intent.putExtra("patient_welcome", "I have from mainActivity :) ")
        var usernameText by remember { mutableStateOf("") }
        var passwordText by remember { mutableStateOf("") }


        Image(
            painter = painterResource(id = R.drawable.medicicon),
            contentDescription = "Medical Clinic Icon",
            modifier = Modifier.size(350.dp).padding(bottom = 10.dp, top = 20.dp),


            )
        Text(
            text = "Twoje zdrowie",
            fontSize = 46.sp,
            modifier = Modifier.padding(30.dp)

        )

        TextField(
            value = usernameText, onValueChange = {
                usernameText = it
            },
            placeholder = { Text(text = "Nazwa Uzytkownika") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "User icon"
                )
            },
            modifier = Modifier.padding(20.dp)

        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = passwordText, onValueChange = {
                passwordText = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            placeholder = { Text(text = "Hasło") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password icon"
                )
            },
            modifier = Modifier.padding(20.dp)

        )

        Button(
            onClick = {
                Toast.makeText(context, "$usernameText\n$passwordText", Toast.LENGTH_LONG).show()
                context.startActivity(intent)
            },
            modifier = Modifier.width(250.dp).height(100.dp).padding(top = 30.dp)


        ) {
            Text(text = "Zaloguj Się")
        }

    }
