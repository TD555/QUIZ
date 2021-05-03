package com.example.quiz

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class Dialog:DialogFragment()
{
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder=AlertDialog.Builder(it)
            builder.setTitle("EXIT")
                    .setMessage("Do you want to leave?")
                    .setPositiveButton("Yes"){
                        dialog, id -> startActivity(Intent(activity,MainActivity::class.java))
                    }
                    .setNegativeButton("No"){
                        dialog,id->dialog.cancel()
                    }
                    builder.create()
        }?:throw IllegalStateException()
    }
}