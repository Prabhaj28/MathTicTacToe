package employee.com.mathtictactoe.model

import employee.com.mathtictactoe.utilities.StringUtility

class Cell(var player: Player?) {

    val isEmpty: Boolean
        get() = player == null || StringUtility.isNullOrEmpty(player!!.value)
}