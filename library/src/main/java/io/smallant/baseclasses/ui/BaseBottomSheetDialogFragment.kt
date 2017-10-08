package io.smallant.baseclasses.ui

import android.app.Dialog
import android.support.annotation.NonNull
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.support.design.widget.CoordinatorLayout
import android.view.View
import timber.log.Timber


/**
 * Created by Jonathan on 12/08/2017.
 */
abstract class BaseBottomSheetDialogFragment : BottomSheetDialogFragment() {

    private val bottomSheetBehaviorCallback = object : BottomSheetBehavior.BottomSheetCallback() {

        override fun onStateChanged(@NonNull bottomSheet: View, newState: Int) {
            when (newState) {
                BottomSheetBehavior.STATE_COLLAPSED -> {
                    Timber.d("collapsed")
                }
                BottomSheetBehavior.STATE_SETTLING -> {
                    Timber.d("settling")
                }
                BottomSheetBehavior.STATE_EXPANDED -> {
                    Timber.d("expanded")
                }
                BottomSheetBehavior.STATE_HIDDEN -> {
                    Timber.d("hidden")
                    dismiss()
                }
                BottomSheetBehavior.STATE_DRAGGING -> {
                    Timber.d("dragging")
                }
            }
        }

        override fun onSlide(@NonNull bottomSheet: View, slideOffset: Float) {
            Timber.d("sliding " + slideOffset)
        }
    }

    abstract val layoutId: Int
    abstract fun bindView(view: View)

    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        val contentView = View.inflate(context, layoutId, null)
        bindView(contentView)
        dialog.setContentView(contentView)

        val params = (contentView.parent as View).layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior

        if (behavior != null && behavior is BottomSheetBehavior<*>) {
            behavior.setBottomSheetCallback(bottomSheetBehaviorCallback)
        }
    }
}