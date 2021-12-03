import kotlin.math.pow
import kotlin.math.sqrt

class Punto(val id: String) {
    var x = 0
    var y = 0

    constructor(id: String, x: Int, y: Int) : this(id) {
        this.x = x
        this.y = y
    }
    override fun toString(): String = "punto $id -> [$x,$y]"
    companion object {
        //Resta dos puntos
        fun componenteDeVector(pa: Punto, pb: Punto): Punto = Punto(pa.id + pb.id, pb.x - pa.x, pb.y - pa.y)
        //Organiza los puntos segun su posición en el eje Y
        fun localizacionGeograficaNS(puntos: Array<Punto>): Map<String, List<Punto>> =
            mapOf("Norte" to puntos.filter { punto -> punto.y >= 0 }, "Sur" to puntos.filter { punto -> punto.y < 0 })
        //Indica la distancia desde un punto a otro
        fun distancia(pa: Punto, pb: Punto): Double = sqrt(
            (pb.x.toDouble() - pa.x.toDouble()).pow(2.0) + (pb.y.toDouble() - pa.y.toDouble()).pow(
                2.0
            )
        )
    }
    //Devuelve las coordenadas de un punto
    fun obtenerCoordenadas(): Pair<Int, Int> = Pair(x, y)
}

fun main() {
    //Programa que resta dos puntos, obteniendo un vector
    println("PROGRAMA 1")
    val pa = Punto("pA", 3, 2)
    val pb = Punto("pB", 1, 3)
    println(pa)
    println(pb)
    println("Componente AB: ${Punto.componenteDeVector(pa, pb)}")
    repeat(221) { print('-') };println()
    println("PROGRAMA 2")
    val p1 = Punto("p1", -1, 0)
    val p2 = Punto("p2", 3, -1)
    val p3 = Punto("p3", -4, 4)
    val p4 = Punto("p4", -3, 2)
    val p5 = Punto("p5", 6, -4)
    val p6 = Punto("p6", -5, 6)
    val p7 = Punto("p7", 10, -8)
    val p8 = Punto("p8", 1, 5)
    val p9 = Punto("p9", 6, -7)
    val listaPuntos = arrayOf(p1, p2, p3, p4, p5, p6, p7, p8, p9)
    println("Lista de puntos:${listaPuntos.forEach { print(" $it") }}")
    println("Localización geografica NS: ${Punto.localizacionGeograficaNS(listaPuntos)}")
}