package io.github.mickie895.montyjanken.fragment.statics.dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import io.github.mickie895.montyjanken.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ClearHistoryDialog : DialogFragment() {
    private val viewModel: ClearHistoryDialogViewModel by viewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
            .setMessage(R.string.clear_history_confirm)
            .setPositiveButton(R.string.delete, onClearNeeded)
            .setNegativeButton(R.string.cansel, emptyEventListener)

        return builder.create()
    }

    private val onClearNeeded = DialogInterface.OnClickListener { _, _ ->
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.clearHistory()
        }
    }
}