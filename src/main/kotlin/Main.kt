import java.awt.*
import java.awt.event.*
import java.util.*
import kotlin.math.*
import kotlin.system.*

const val period = 1000L * 60L
const val delay = 1

val robot = Robot()
val timer = Timer()

fun shakeCursor() {
    /// Дрыгать мышкой
    val location = MouseInfo.getPointerInfo().location
    val y = location.y
    val x1 = abs(location.x - 10) + 1
    val x2 = location.x
    robot.mouseMove(x1, y)
    robot.delay(delay)
    robot.mouseMove(x2, y)
}

fun main() {
    /// Окошечко
    val frame = Frame()
    frame.setSize(200, 50)
    frame.title = "ShakeCursor"
    frame.addWindowListener(object : WindowAdapter() {
        override fun windowClosing(e: WindowEvent) {
            exitProcess(0)
        }
    })
    frame.isResizable = false
    frame.isVisible = true

    /// Таймер
    val task = object : TimerTask() {
        override fun run() {
            shakeCursor()
        }
    }
    timer.schedule(task, period, period);
}