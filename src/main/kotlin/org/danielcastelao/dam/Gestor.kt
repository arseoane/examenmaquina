package org.danielcastelao.dam

// nivel en el que se encuentra el ascensor
var nivel_actual: Int = 0
// estado actual del ascensor
var estado_actual: Estados = Estados.Idle

/**
 * Gestiona el cambio de estados
 */
fun gestor(nivel_0: Boolean,nivel_1: Boolean,error: Boolean = false): Int {
    when (estado_actual) {
        is Estados.Idle -> {
            if (!nivel_0) {
                nivel_actual = 0
            }
            else if (!nivel_1) {
                nivel_actual = 0
            }
            return nivel_actual
        }
        is Estados.MovingUP -> {
            nivel_actual = if (nivel_1) 2 else 0
            return nivel_actual
        }
        is Estados.MovingDOWN -> {
            nivel_actual = if (nivel_0) 2 else 0
            return nivel_actual
        }
        is Estados.Error -> {
            nivel_actual = if (error) -1 else 0
            return nivel_actual
        }
    }
}
