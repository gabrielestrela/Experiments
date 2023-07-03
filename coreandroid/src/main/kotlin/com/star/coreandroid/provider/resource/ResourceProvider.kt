package com.star.coreandroid.provider.resource

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

class ResourceProvider(
    private val context: Context
) {

    fun string(@StringRes res: Int): String = context.getString(res)
    fun string(@StringRes res: Int, vararg args: Any): String = context.getString(res, *args)
    fun string(@PluralsRes res: Int, quantity: Int) =
        context.resources.getQuantityString(res, quantity)
    fun string(@PluralsRes res: Int, quantity: Int, vararg args: Any) =
        context.resources.getQuantityString(res, quantity, *args)
    fun drawable(@DrawableRes res: Int): Drawable? = ContextCompat.getDrawable(context, res)
    fun dimen(@DimenRes res: Int): Int = with(context.resources) {
        (getDimension(res) / displayMetrics.density).toInt()
    }
    fun pixelDimen(@DimenRes res: Int): Int = context.resources.getDimension(res).toInt()
    fun color(@ColorRes res: Int) = ContextCompat.getColor(context, res)

}
