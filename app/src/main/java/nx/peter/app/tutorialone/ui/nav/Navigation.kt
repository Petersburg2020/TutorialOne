package nx.peter.app.tutorialone.ui.nav


enum class Screen {
    HOME,
    ADD_TODO,
}

open class NavigationItem(val route: String) {
    data object Home : NavigationItem(Screen.HOME.name)
    data object AddTodo : NavigationItem(Screen.ADD_TODO.name)
}