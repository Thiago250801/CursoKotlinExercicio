package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CounterScreen(0)
                }
            }
        }
    }
}

@Composable
fun CounterScreen(intialNumber: Int) {
    var count by remember { mutableStateOf(intialNumber) }
    Counter(
        count = count,
        onIncrement = { count++ },
        onDecrement = { if (count > 0) count-- }
    )
}
@Composable
fun Counter(
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(
                onClick = onDecrement,
                modifier = Modifier.semantics { contentDescription = "Botão de decrementar" }
            ) {
                Text("decrementador: $count")
            }

            OutlinedButton(
                onClick = onIncrement,
                modifier = Modifier.semantics { contentDescription = "Botão de incrementar" }
            ) {
                Text("incrementar: $count")
            }
        }
        Text("Contador: $count",
            modifier = Modifier
                .padding(top = 16.dp)
                .semantics { contentDescription = "Contador" }
        )


        if (count > 0 && count % 10 == 0) {
            Text(
                text = "Uau!",
                fontSize = 24.sp,
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun CounterPreview42() {
    CounterScreen(42)
}