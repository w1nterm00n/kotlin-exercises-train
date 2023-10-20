fun main(args: Array<String>) {

    val cities = arrayOf(
        "Москва", "Новосибирск", "Астана", "Омск", "Тверь",
        "Тула", "Калининград", "Сочи", "Челябинск", "Екатеринбург",
        "Санкт-Петербург", "Минск", "Мурманск", "Хельсинки", "Хандыга"
    )



    class Train(val totalPassangersAmount: Int) {
        var vagons = arrayOf<Int>() //пустой массив интегеров (тут будет число вместительности)
        var totalCapacity = 0

        fun GetVagons(){
            while (totalCapacity <= totalPassangersAmount) {
                var vagon = (Math.random() * 21).toInt()+5  //сколько людей туда поместятся
                totalCapacity += vagon
                vagons = vagons.plus(vagon)
            }
        }
    }


        class Route() {
            fun GetCity(otherCity: String): String{
                var num = (Math.random() * 15).toInt() //рандом число от 0 до 14
                var city = cities[num]

                //если города одинаковые, он сгенерирует новый город
                while (city == otherCity){
                    num = (Math.random() * 15).toInt()+1
                    city = cities[num]
                }
                return city
            }

            val cityA = this.GetCity("")
            var cityB = this.GetCity(cityA)
            var passangersAmount = (Math.random() * 197).toInt() + 5
            var train = Train(passangersAmount)

            init {
                train.GetVagons()
            }

            fun printVagons(): String {
                var result = ""
                for (i in 0 until train.vagons.size) {
                    result = result + "вагон ${i} вместимостью ${train.vagons[i]} человек \n"
                }
                println(result)
                return result
            }

            fun printRoute(): String {
                var result = "поезд из города ${cityA} направляющийся в город ${cityB},\n состоящий из ${train.vagons.size} вагонов отправлен,\n количество купленных билетов: ${passangersAmount}"
                println(result)
                printVagons()
                return result
            }
        }
        


        fun creationProcess(){
            var choice = 1
            while (choice == 1) {
                println("нажмите 1 чтобы составить поезд, или 0 чтобы закончить: ")
                choice = readLine()?.toIntOrNull() ?: 0
                if (choice == 1){
                    var route1 = Route()
                    route1.printRoute()
                } else {
                    println("до свидания")
                }
            }
        }

        creationProcess()
}