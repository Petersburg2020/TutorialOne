package nx.peter.app.tutorialone.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import nx.peter.app.tutorialone.ui.screen.AddTodoScreen
import nx.peter.app.tutorialone.ui.screen.HomeScreen

@Composable
fun AppNavHost(

    navController: NavHostController,
    startDestination: String = NavigationItem.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(NavigationItem.AddTodo.route) {
            AddTodoScreen(navController = navController)
        }
    }
}
