package employee.com.mathtictactoe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.databinding.ObservableArrayMap
import employee.com.mathtictactoe.model.Cell
import employee.com.mathtictactoe.model.Game
import employee.com.mathtictactoe.model.Player
import employee.com.mathtictactoe.utilities.StringUtility.stringFromNumbers

class GameViewModel : ViewModel() {

    lateinit var cells: ObservableArrayMap<String, String>
    private var game: Game? = null


    fun init(player1: String, player2: String) {
        game = Game(player1, player2)
        cells = ObservableArrayMap()
    }

    //called each time a cell is clicked on
    fun onClickedCellAt(row: Int, column: Int) {
        if (game?.cells!![row][column] != null) {
            game?.cells!![row][column] = Cell(game!!.currentPlayer)
            cells.put(stringFromNumbers(row, column), game!!.currentPlayer?.value)
            if (game!!.hasGameEnded())
                game!!.reset()
            else
                game!!.switchPlayer()
        }
    }

    fun getWinner(): LiveData<Player> {
        return game?.winner!!
    }
}
