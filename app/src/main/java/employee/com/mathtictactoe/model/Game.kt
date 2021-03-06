package employee.com.mathtictactoe.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import employee.com.mathtictactoe.utilities.StringUtility.isNullOrEmpty

class Game(playerOne: String, playerTwo: String) {

    var player1: Player? = null
    var player2: Player? = null
    var playerDef: Player? = null

    var currentPlayer = player1
    var cells: Array<Array<Cell>>? = null

    var winner: MutableLiveData<Player> = MutableLiveData()

    val isBoardFull: Boolean
        get() {
            for (row in cells!!)
                for (cell in row)
                    if (cell == null || cell.isEmpty)
                        return false
            return true
        }

    init {
        //cells = Array(BOARD_SIZE) { arrayOf(BOARD_SIZE) }
        cells = Array(BOARD_SIZE) { row ->
            Array(BOARD_SIZE) { col ->
               Cell(playerDef)
            }
        }
        player1 = Player(playerOne, "X")
        player2 = Player(playerTwo, "O")
        currentPlayer = player1
    }

    fun hasGameEnded(): Boolean {
        if (hasThreeSameHorizontalCells() || hasThreeSameVerticalCells() || hasThreeSameDiagonalCells()) {
            winner.setValue(currentPlayer)
            return true
        }

        if (isBoardFull) {
            winner.setValue(null)
            return true
        }

        return false
    }

    fun hasThreeSameHorizontalCells(): Boolean {
        try {
            for (i in 0 until BOARD_SIZE)
                if (areEqual(cells!![i][0], cells!![i][1], cells!![i][2]))
                    return true

            return false
        } catch (e: NullPointerException) {
            Log.e(TAG, e.message)
            return false
        }

    }

    fun hasThreeSameVerticalCells(): Boolean {
        try {
            for (i in 0 until BOARD_SIZE)
                if (areEqual(cells!![0][i], cells!![1][i], cells!![2][i]))
                    return true
            return false
        } catch (e: NullPointerException) {
            Log.e(TAG, e.message)
            return false
        }

    }

    fun hasThreeSameDiagonalCells(): Boolean {
        try {
            return areEqual(cells!![0][0], cells!![1][1], cells!![2][2]) || areEqual(
                cells!![0][2],
                cells!![1][1],
                cells!![2][0]
            )
        } catch (e: NullPointerException) {
            Log.e(TAG, e.message)
            return false
        }

    }

    /**
     * 2 cells are equal if:
     * - Both are none null
     * - Both have non null values
     * - both have equal values
     *
     * @param cells: Cells to check if are equal
     * @return
     */
    private fun areEqual(vararg cells: Cell): Boolean {
        if (cells == null || cells.size == 0)
            return false

        for (cell in cells)
            if (cell == null || isNullOrEmpty(cell.player?.value))
                return false

        val comparisonBase = cells[0]
        for (i in 1 until cells.size)
            if (!comparisonBase.player?.value.equals(cells[i].player?.value))
                return false

        return true
    }

    fun switchPlayer() {
        currentPlayer = if (currentPlayer === player1) player2 else player1
    }

    fun reset() {
        player1 = null
        player2 = null
        currentPlayer = null
        cells = null
    }

    companion object {

        private val TAG = Game::class.java.simpleName
        private val BOARD_SIZE = 3
    }
}
