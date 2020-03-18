package employee.com.mathtictactoe

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import employee.com.mathtictactoe.model.Cell
import employee.com.mathtictactoe.model.Game
import employee.com.mathtictactoe.model.Player
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GameShould {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var game: Game? = null
    private var player: Player? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        game = Game("Bob", "Steve")
        player = game!!.player1
    }

    @Test
    @Throws(Exception::class)
    fun endGameIfHasThreeSameHorizontalCells() {
        val cell = Cell(player)
        game!!.cells!![0][0] = cell
        game!!.cells!![0][1] = cell
        game!!.cells!![0][2] = cell
        val hasGameEnded = game!!.hasGameEnded()
        assertTrue(hasGameEnded)
    }

    @Test
    @Throws(Exception::class)
    fun endGameIfHasThreeSameVerticalCells() {
        val cell = Cell(player)
        game!!.cells!![0][0] = cell
        game!!.cells!![1][0] = cell
        game!!.cells!![2][0] = cell
        val hasGameEnded = game!!.hasGameEnded()
        assertTrue(hasGameEnded)
    }

    @Test
    @Throws(Exception::class)
    fun endGameIfHasThreeSameDiagonalCells() {
        val cell = Cell(player)
        game!!.cells!![0][0] = cell
        game!!.cells!![1][1] = cell
        game!!.cells!![2][2] = cell
        val hasGameEnded = game!!.hasGameEnded()
        assertTrue(hasGameEnded)
    }

    @Test
    @Throws(Exception::class)
    fun endGameIfBoardIsFull() {
        val cell1 = Cell(Player("1", "x"))
        val cell2 = Cell(Player("2", "o"))
        val cell3 = Cell(Player("1", "x"))
        val cell4 = Cell(Player("2", "o"))
        val cell5 = Cell(Player("1", "x"))
        val cell6 = Cell(Player("2", "o"))
        val cell7 = Cell(Player("1", "x"))
        val cell8 = Cell(Player("2", "o"))
        val cell9 = Cell(Player("1", "x"))

        game!!.cells!![0][0] = cell1
        game!!.cells!![0][1] = cell2
        game!!.cells!![0][2] = cell3
        game!!.cells!![1][0] = cell4
        game!!.cells!![1][1] = cell5
        game!!.cells!![1][2] = cell6
        game!!.cells!![2][0] = cell7
        game!!.cells!![2][1] = cell8
        game!!.cells!![2][2] = cell9

        val isBoardFull = game!!.isBoardFull
        assertTrue(isBoardFull)
    }

    @Test
    @Throws(Exception::class)
    fun switchFromPlayer1ToPlayer2() {
        game!!.currentPlayer = game!!.player1
        game!!.switchPlayer()
        assertEquals(game!!.player2, game!!.currentPlayer)
    }
}
