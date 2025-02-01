import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CashRow(
    startCash: String,
    endCash: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 18.dp, vertical = 18.dp), // Added horizontal padding
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Red text (Left-aligned)
        Text(
            text = startCash,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Red,
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp), // Add some space between red text and divider
            textAlign = TextAlign.Start
        )

        // Divider (Centered)
        VerticalDivider(
            modifier = Modifier
                .fillMaxHeight(), // Fixed width to avoid stretching
            color = Color.Black,
            thickness = 1.dp
        )

        // Green text (Right-aligned)
        Text(
            text = endCash,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.Green,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp), // Add some space between divider and green text
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

    Scaffold(
        modifier = modifier,
        floatingActionButton = {

            FloatingActionButton(
                onClick = {},
            ) {
                Row(
                    modifier = Modifier
                        .width(IntrinsicSize.Max)
                        .padding(18.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.AddCircle,
                        contentDescription = "Add",
                        modifier = Modifier.size(18.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Add Customer",
                        fontSize = 18.sp
                    )
                }

            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(width = 1.dp, color = Color.Black)
            ) {
                CashRow(startCash = "$ 4759", endCash = "$ 7337")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(modifier = Modifier)
}