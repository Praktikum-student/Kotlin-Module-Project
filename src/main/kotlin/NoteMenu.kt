import java.util.Scanner

class NoteMenu(private val archive: Archive) {

    fun show() {
        val menuItems = mutableListOf<MenuItem>()

        menuItems.add(
            MenuItem(
            name = "Создать заметку",
            action = {
                createNote()
                show()
            }
        ))

        archive.notes.forEach { note ->
            menuItems.add(
                MenuItem(
                name = note.name,
                action = {
                    NoteView(note).show()
                    show()
                }
            ))
        }

        menuItems.add(
            MenuItem(
                name = "Назад",
                action = { },
                isExit = true
            )
        )

        Menu("Архив: ${archive.name}", menuItems).show()
    }

    private fun createNote() {
        println("Введите название заметки:")
        val name = readNonEmptyString()

        println("Введите текст заметки:")
        val content = readNonEmptyString()

        archive.notes.add(Note(name, content))
        println("Заметка '$name' успешно создана!")
    }

    private fun readNonEmptyString(): String {
        while (true) {
            val input = Scanner(System.`in`).nextLine()
            if (input.isNotBlank()) {
                return input
            }
            println("Ошибка: поле не может быть пустым. Попробуйте снова:")
        }
    }
}