package employee.com.mathtictactoe

import employee.com.mathtictactoe.model.Cell
import employee.com.mathtictactoe.model.Game
import employee.com.mathtictactoe.model.Player
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GameHorizontalCellsShould {

    private var game: Game? = null
    private var player: Player? = null
    private var anotherPlayer: Player? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        game = Game("Bob", "Steve")
        player = game!!.player1
        anotherPlayer = game!!.player2
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow1() {
        val cell = Cell(player)
        game!!.cells!![0][0] = cell
        game!!.cells!![0][1] = cell
        game!!.cells!![0][2] = cell
        val hasThreeSameHorizontalCells = game!!.hasThreeSameHorizontalCells()
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow2() {
        val cell = Cell(player)
        game!!.cells!![1][0] = cell
        game!!.cells!![1][1] = cell
        game!!.cells!![1][2] = cell
        val hasThreeSameHorizontalCells = game!!.hasThreeSameHorizontalCells()
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameHorizontalCellsAtRow3() {
        val cell = Cell(player)
        game!!.cells!![2][0] = cell
        game!!.cells!![2][1] = cell
        game!!.cells!![2][2] = cell
        val hasThreeSameHorizontalCells = game!!.hasThreeSameHorizontalCells()
        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameHorizontalCells() {
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)
        game!!.cells!![0][0] = cell
        game!!.cells!![0][1] = cell
        game!!.cells!![0][2] = anotherCell
        val hasThreeSameHorizontalCells = game!!.hasThreeSameHorizontalCells()
        assertFalse(hasThreeSameHorizontalCells)
    }
}
