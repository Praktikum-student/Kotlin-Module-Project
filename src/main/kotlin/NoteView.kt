import java.util.Scanner

class NoteView(private val note: Note) {

    fun show() {
        println("\nЗаметка: ${note.name}")
        println("=".repeat(50))
        println(note.content)
        println("=".repeat(50))
        println("Нажмите Enter, чтобы вернуться...")
        Scanner(System.`in`).nextLine()
    }
}