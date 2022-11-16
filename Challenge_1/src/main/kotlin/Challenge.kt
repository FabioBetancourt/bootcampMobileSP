/*
Developed by: Fabio Esteban Betancourt Camacho
Area: Mobile
 */
fun main() {
    println("the random list generated sorted ascending is: ")
    sortAscendingOrDescending(stringToArrayListInt(randomNumbersString()), "Asc")
    println("\nthe random list generated  descending is: ")
    sortAscendingOrDescending(stringToArrayListInt(randomNumbersString()), "Des")
}

fun randomNumbersString(): String {
    println("Write your type of array 'TipoA' or 'TipoB': ")
    when (readln()) {
        "TipoA" -> {
            var type = "54"
            var count = 1
            while (count <= 8) {
                val numbers = 0..9
                val randomNumbers = numbers.random()
                type += randomNumbers
                count++
            }
            println("The result typeA is: $type\n")
            return type
        }
        "TipoB" -> {
            var type = "08"
            var count = 1
            while (count <= 8) {
                val numbers = 0..9
                val randomNumbers = numbers.random()
                type += randomNumbers
                count++
            }
            println("The result typeB is: $type\n")
            return type
        }
        else -> {
            return "Type not valid"
        }
    }

}
fun sortAscendingOrDescending(listNum: Array<Int>, param: String) {
    when (param) {
        "Asc" -> {
            loopingArray(listNum)
            for (i in (listNum.indices)) {
                if (i == 9) {
                    print(listNum[i])
                    break
                }
                print(listNum[i])
                print(",")
            }
        }
        "Des" -> {
            loopingArray(listNum)
            for (i in listNum.size - 1 downTo 0) {
                print(listNum[i])
                print(",")
                if (i == 1) {
                    print(listNum[i-1])
                    break
                }
            }
        }
    }
}
fun loopingArray(listNum: Array<Int>){
    for (i in (0 until listNum.size - 1)) {
        for (j in (0 until listNum.size - 1)) {
            if (listNum[j] > listNum[j + 1]) {
                val tem = listNum[j]
                listNum[j] = listNum[j + 1]
                listNum[j + 1] = tem
            }
        }
    }
}
fun stringToArrayListInt(strings: String): Array<Int> {
    val stringsFinal: Array<String> = strings.toCharArray().map { it.toString() }.toTypedArray()
    return stringsFinal.map { it.toInt() }.toTypedArray()
}