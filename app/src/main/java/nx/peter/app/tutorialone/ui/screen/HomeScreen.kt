package nx.peter.app.tutorialone.ui.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import nx.peter.app.tutorialone.ui.nav.NavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(route = NavigationItem.AddTodo.route)
            }) {
                Icon(Icons.Default.Add, null)
            }
        },
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = { Text("Todo") }, actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Search, null)
                    }
                }
            )
        }
    ) { innerPadding ->
        // TODO: Make the column to scroll
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(state = ScrollState(5))
        ) {

            // TODO: Build a list of todo items here
            todoList.forEach { item ->
                ListItem(
                    headlineContent = {
                        Column {
                            Text(
                                item.title,
                                color = Color.Black,
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Black,
                                    fontStyle = FontStyle.Normal
                                )
                            )
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(10.dp)
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Text(
                                    item.content,
                                    modifier = Modifier.weight(1.0f),
                                    color = Color.Black,
                                    softWrap = true,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1,
                                    style = TextStyle(
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Medium,
                                    )
                                )
                                Icon(
                                    if (item.isComplete) Icons.Default.Check else Icons.Default.Close,
                                    null,
                                    tint = if (item.isComplete) Color.Green else Color.Red
                                )
                            }
                        }
                    }
                )
            }
        }

    }

}


// TODO: Add more todos to the list
val todoList = mutableListOf(
    Todo(
        id = 0, title = "Exercise",
        content = "Walk 5km per day", isComplete = false
    ),
    Todo(
        id = 1, title = "Cook",
        content = "Cook rice and stew on Sunday", isComplete = true
    ),
    Todo(
        id = 2, title = "Read a Book",
        content = "Read 2 Chapters of Code With Jordan daily", isComplete = false
    ),
    Todo(
        id = 3, title = "Code",
        content = "Practice Coding from Android Codelabs at least 2hrs daily", isComplete = true
    ),
    Todo(
        id = 4, title = "Visitation",
        content = "Visit Augustine on Saturday", isComplete = false
    ),
    Todo(
        id = 5, title = "Drink Water",
        content = "Drink at least 10litres of water daily", isComplete = false
    ),
    Todo(
        id = 6, title = "Play FIFA",
        content = "Play FIFA '24 with Tunde on Saturday by 3pm", isComplete = true
    ),
    Todo(
        id = 7, title = "Repair Bike",
        content = "Take Busola's Bicycle for repairs on Wednesday", isComplete = true
    ),
    Todo(
        id = 8, title = "Financial Analysis",
        content = "Complete POS financial analysis before closing on Tuesday", isComplete = false
    ),
    Todo(
        id = 9, title = "Submit Assignment",
        content = "Submit this TODO assignment by 10am on Sunday", isComplete = true
    ),
    Todo(
        id = 1,
        title = "Update Code",
        content = "Update the existing code on Github with the newest solutions before submission",
        isComplete = false
    ),
    Todo(
        id = 1, title = "Remind Chika",
        content = "Remind Chika to come along with the Software files by weekend", isComplete = true
    ),
    Todo(
        id = 0, title = "Complete Report",
        content = "Complete all official reports before Monday", isComplete = false
    ),
    Todo(
        id = 1, title = "Eat Early",
        content = "Ensure to eat at least 3 times daily", isComplete = false
    ),
    Todo(
        id = 1, title = "Socialize",
        content = "Join the team for social meetings every Friday by 7pm", isComplete = false
    )
)

data class Todo(
    val id: Int,
    val title: String,
    val content: String,
    val isComplete: Boolean
)
