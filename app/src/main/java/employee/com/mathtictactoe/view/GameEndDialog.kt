package employee.com.mathtictactoe.view

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.fragment.app.DialogFragment
import employee.com.mathtictactoe.R

class GameEndDialog : DialogFragment() {

    private var rootView: View? = null
    private var activity: GameActivity? = null
    private var winnerName: String? = null

    @NonNull
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        initViews()
        val alertDialog = AlertDialog.Builder(getContext())
            .setView(rootView)
            .setCancelable(false)
            .setPositiveButton(R.string.done, { dialog, which -> onNewGame() })
            .create()
        alertDialog.setCanceledOnTouchOutside(false)
        alertDialog.setCancelable(false)
        return alertDialog
    }

    private fun initViews() {
        rootView = LayoutInflater.from(getContext())
            .inflate(R.layout.game_end_dialog, null, false)
        (rootView!!.findViewById(R.id.tv_winner) as TextView).text = winnerName
    }

    private fun onNewGame() {
        dismiss()
        activity!!.promptForPlayers()
    }

    companion object {

        fun newInstance(activity: GameActivity, winnerName: String): GameEndDialog {
            val dialog = GameEndDialog()
            dialog.activity = activity
            dialog.winnerName = winnerName
            return dialog
        }
    }
}
