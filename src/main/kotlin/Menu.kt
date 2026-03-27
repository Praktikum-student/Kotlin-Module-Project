import java.util.Scanner

class Menu(private val title: String, private val items: MutableList<MenuItem>) {

    fun show() {
        while (true) {
            println("\n$title")
            items.forEachIndexed { index, item ->
                println("$index. ${item.name}")
            }

            print("Выберите пункт меню: ")
            val input = Scanner(System.`in`).nextLine()

            when {
                !isValidNumber(input) -> {
                    println("Ошибка: введите целое число")
                }
                else -> {
                    val index = input.toInt()
                    if (index in items.indices) {
                        items[index].action()
                        if (items[index].isExit) {
                            break
                        }
                    } else {
                        println("Ошибка: пункта с номером $index не существует")
                    }
                }
            }
        }
    }

    private fun isValidNumber(str: String): Boolean {
        // Проверяем, что строка не пустая и состоит только из цифр
        if (str.isEmpty()) return false
        // Проверяем, что все символы - цифры
        for (c in str) {
            if (!c.isDigit()) return false
        }
        // Проверяем, что число не выходит за пределы Int
        try {
            str.toInt()
            return true
        } catch (e: NumberFormatException) {
            return false
        }
    }
}