import java.util.Scanner

class ArchiveMenu(private val archives: MutableList<Archive>) {

    fun show() {
        val menuItems = mutableListOf<MenuItem>()

        menuItems.add(MenuItem(
            name = "Создать архив",
            action = {
                createArchive()
                show()
            }
        ))

        archives.forEach { archive ->
            menuItems.add(MenuItem(
                name = archive.name,
                action = {
                    NoteMenu(archive).show()
                    show()
                }
            ))
        }

        menuItems.add(MenuItem(
            name = "Выход",
            action = { },
            isExit = true
        ))

        Menu("Список архивов:", menuItems).show()
    }

    private fun createArchive() {
        println("Введите название архива:")
        val name = readNonEmptyString()
        archives.add(Archive(name))
        println("Архив '$name' успешно создан!")
    }

    private fun readNonEmptyString(): String {
        while (true) {
            val input = Scanner(System.`in`).nextLine()
            if (input.isNotBlank()) {
                return input
            }
            println("Ошибка: название не может быть пустым. Попробуйте снова:")
        }
    }
}