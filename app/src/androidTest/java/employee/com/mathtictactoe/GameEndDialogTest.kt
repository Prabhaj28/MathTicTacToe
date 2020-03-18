package employee.com.mathtictactoe

import androidx.test.rule.ActivityTestRule
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import employee.com.mathtictactoe.model.Player
import employee.com.mathtictactoe.view.GameActivity
import org.junit.Rule
import org.junit.Test

class GameEndDialogTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<GameActivity> = ActivityTestRule(GameActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun display_winner_when_game_ends() {
        givenGameEnded()

        assertDisplayed(R.id.tv_winner)
    }

    @Test
    @Throws(Exception::class)
    fun display_begin_dialog_when_done_clicked() {
        givenGameEnded()

        clickDialogPositiveButton()

        assertNotExist(R.id.tv_winner)
        assertDisplayed(R.id.et_player1)
    }

    private fun givenGameEnded() {
        activityRule.getActivity().onGameWinnerChanged(Player("Bob", "x"))
    }
}