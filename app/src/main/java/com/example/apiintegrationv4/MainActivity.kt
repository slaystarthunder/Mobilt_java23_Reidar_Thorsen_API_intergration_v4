package com.example.apiintegrationv4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.apiintegrationv4.navigation.SetupNavGraph
import com.example.apiintegrationv4.ui.theme.APIIntegrationV4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            APIIntegrationV4Theme {
                Scaffold { innerPadding ->
                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
