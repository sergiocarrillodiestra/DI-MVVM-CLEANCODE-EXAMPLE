package com.dscorp.mvvmexample.presentation

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.dscorp.mvvmexample.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class DialogFactory(val applicationContext: Context) {
    private var dialog: AlertDialog? = null

    enum class DialogType {
        message, success, error, load
    }

    fun createDialog(dialogType: DialogType?, message: String?): AlertDialog? {
        if (dialog != null) {
            dialog!!.dismiss()
        }

        when (dialogType) {
            DialogType.message -> dialog = MaterialAlertDialogBuilder(applicationContext)
                .setTitle(R.string.app_name)
                .setIcon(R.mipmap.ic_launcher)
                .setMessage(message)
                .setPositiveButton(R.string.positiveButtonText) { dialog, which -> dialog.dismiss() }
                .create()
            DialogType.load -> dialog = MaterialAlertDialogBuilder(applicationContext)
                .setView(R.layout.loading_dialog)
                .setCancelable(false)
                .create()

            DialogType.success -> dialog = MaterialAlertDialogBuilder(applicationContext)
                .setTitle("Tarea realizada correctamente")
                .setIcon(R.drawable.ic_baseline_check_24)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(R.string.positiveButtonText) { dialog, which -> dialog.dismiss() }
                .create()
            DialogType.error -> dialog = MaterialAlertDialogBuilder(applicationContext)
                .setTitle(R.string.errorDialogTitle)
                .setIcon(R.drawable.ic_baseline_info_24)
                .setMessage(message)
                .setPositiveButton(R.string.positiveButtonText) { dialog, which -> dialog.dismiss() }
                .create()

        }
        return dialog
    }

    fun createconfirmationDialog(
        title: String,
        message: String,
        positiveButtonClickListener: DialogInterface.OnClickListener,
        negativeClickListener: DialogInterface.OnClickListener,
    ): AlertDialog? = MaterialAlertDialogBuilder(applicationContext)
        .setTitle(title)
        .setPositiveButton(
            applicationContext.getString(R.string.positiveButtonText),
            positiveButtonClickListener
        )
        .setIcon(R.drawable.ic_baseline_info_24)
        .setNegativeButton("No", negativeClickListener)
        .setCancelable(false)
        .setMessage(message).create().also { dialog = it }


}