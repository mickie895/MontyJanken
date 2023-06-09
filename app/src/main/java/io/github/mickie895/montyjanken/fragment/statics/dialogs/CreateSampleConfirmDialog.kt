package io.github.mickie895.montyjanken.fragment.statics.dialogs

import android.app.Dialog
import android.content.DialogInterface.OnClickListener
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
class CreateSampleConfirmDialog : DialogFragment() {
    private val viewModel: CreateSampleConfirmDialogViewModel by viewModels()

    private val sampleCount = 1000 / 2

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
            .setMessage(R.string.create_sample_confirm)
            .setPositiveButton(R.string.create, onCreateSampleNeeded)
            .setNegativeButton(R.string.cansel, emptyEventListener)

        return builder.create()
    }

    private val onCreateSampleNeeded = OnClickListener { _, _ ->
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.createSample(sampleCount)
        }
    }
}
