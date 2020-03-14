package employee.com.mathtictactoe.view

import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import employee.com.mathtictactoe.R

import employee.com.mathtictactoe.model.Player
import employee.com.mathtictactoe.utilities.StringUtility.isNullOrEmpty
import employee.com.mathtictactoe.viewmodel.GameViewModel
import employee.com.mathtictactoe.databinding.ActivityGameBinding


class GameActivity : AppCompatActivity() {
    private var gameViewModel: GameViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        promptForPlayers()
    }

    fun promptForPlayers() {
        val dialog = GameBeginDialog.newInstance(this)
        dialog.isCancelable = false
        dialog.show(supportFragmentManager, GAME_BEGIN_DIALOG_TAG)
    }

    fun onPlayersSet(player1: String, player2: String) {
        initDataBinding(player1, player2)
    }

    private fun initDataBinding(player1: String, player2: String) {
        var activityGameBinding = DataBindingUtil.setContentView<ActivityGameBinding>(this, R.layout.activity_game)
        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        gameViewModel!!.init(player1, player2)
        activityGameBinding.setGameViewModel(gameViewModel)
        setUpOnGameEndListener()
    }

    private fun setUpOnGameEndListener() {
        gameViewModel?.getWinner()?.observe(this@GameActivity, Observer { onGameWinnerChanged(it) })
    }

    @VisibleForTesting
    fun onGameWinnerChanged(winner: Player?) {
        val winnerName =
            if (winner == null || isNullOrEmpty(winner.name)) NO_WINNER else winner.name
        val dialog = GameEndDialog.newInstance(this, winnerName)
        dialog.isCancelable = false
        dialog.show(supportFragmentManager, GAME_END_DIALOG_TAG)
    }

    companion object {

        private val GAME_BEGIN_DIALOG_TAG = "game_dialog_tag"
        private val GAME_END_DIALOG_TAG = "game_end_dialog_tag"
        private val NO_WINNER = "No one"
    }
}

