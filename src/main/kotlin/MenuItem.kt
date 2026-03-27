class MenuItem(
    val name: String,
    val action: () -> Unit,
    val isExit: Boolean = false
)