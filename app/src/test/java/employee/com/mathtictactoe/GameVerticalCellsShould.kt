package employee.com.mathtictactoe

import employee.com.mathtictactoe.model.Cell
import employee.com.mathtictactoe.model.Game
import employee.com.mathtictactoe.model.Player
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GameVerticalCellsShould {

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
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn1() {
        val cell = Cell(player)
        game!!.cells!![0][0] = cell
        game!!.cells!![1][0] = cell
        game!!.cells!![2][0] = cell
        val hasThreeSameVerticalCells = game!!.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn2() {
        val cell = Cell(player)
        game!!.cells!![0][1] = cell
        game!!.cells!![1][1] = cell
        game!!.cells!![2][1] = cell
        val hasThreeSameVerticalCells = game!!.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn3() {
        val cell = Cell(player)
        game!!.cells!![0][2] = cell
        game!!.cells!![1][2] = cell
        game!!.cells!![2][2] = cell
        val hasThreeSameVerticalCells = game!!.hasThreeSameVerticalCells()
        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameVerticalCells() {
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)
        game!!.cells!![0][0] = cell
        game!!.cells!![1][0] = cell
        game!!.cells!![2][0] = anotherCell
        val hasThreeSameVerticalCells = game!!.hasThreeSameVerticalCells()
        assertFalse(hasThreeSameVerticalCells)
    }
}
