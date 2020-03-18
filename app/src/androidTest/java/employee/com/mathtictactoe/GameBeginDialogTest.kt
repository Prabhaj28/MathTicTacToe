package employee.com.mathtictactoe

import androidx.test.rule.ActivityTestRule
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import employee.com.mathtictactoe.view.GameActivity
import org.junit.Rule
import org.junit.Test

class GameBeginDialogTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<GameActivity> = ActivityTestRule(GameActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun display_empty_names_message_if_names_empty() {
        writeTo(R.id.et_player1, "")
        writeTo(R.id.et_player2, "")

        clickDialogPositiveButton()

        assertDisplayed(R.string.game_dialog_empty_name)
    }

    @Test
    @Throws(Exception::class)
    fun display_same_names_message_if_names_same() {
        writeTo(R.id.et_player1, "Bob")
        writeTo(R.id.et_player2, "Bob")

        clickDialogPositiveButton()

        assertDisplayed(R.string.game_dialog_same_names)
    }

    @Test
    @Throws(Exception::class)
    fun display_empty_name_message_if_one_name_empty() {
        writeTo(R.id.et_player1, "")
        writeTo(R.id.et_player2, "Bob")

        clickDialogPositiveButton()

        assertDisplayed(R.string.game_dialog_empty_name)
    }

    @Test
    @Throws(Exception::class)
    fun close_dialog_after_names_valid() {
        writeTo(R.id.et_player1, "Bob 1")
        writeTo(R.id.et_player2, "Bob 2")

        clickDialogPositiveButton()

        assertNotExist(R.id.layout_player1)
    }
}
