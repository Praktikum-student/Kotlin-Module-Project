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
                !isNumber(input) -> {
                    println("Ошибка: введите число")
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

    private fun isNumber(str: String): Boolean {
        return str.matches(Regex("\\d+"))
    }
}