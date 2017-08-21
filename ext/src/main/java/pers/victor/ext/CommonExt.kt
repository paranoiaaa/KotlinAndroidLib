package pers.victor.ext

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.net.Uri
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by Victor on 2017/8/18. (ง •̀_•́)ง
 */

fun findColor(@ColorRes resId: Int) = ContextCompat.getColor(Ext.ctx, resId)

fun findDrawable(@DrawableRes resId: Int): Drawable? = ContextCompat.getDrawable(Ext.ctx, resId)

fun findColorStateList(@ColorRes resId: Int): ColorStateList? = ContextCompat.getColorStateList(Ext.ctx, resId)

fun inflate(@LayoutRes layoutId: Int, parent: ViewGroup?, attachToRoot: Boolean = false) = LayoutInflater.from(Ext.ctx).inflate(layoutId, parent, attachToRoot)!!

fun inflate(@LayoutRes layoutId: Int) = inflate(layoutId, null)

fun dp2px(dp: Number) = (dp.toFloat() * Ext.ctx.resources.displayMetrics.density + 0.5f).toInt()

fun sp2px(sp: Number) = (sp.toFloat() * Ext.ctx.resources.displayMetrics.scaledDensity + 0.5f).toInt()

val screenWidth: Int
    get() = Ext.ctx.resources.displayMetrics.widthPixels

val screenHeight: Int
    get() = Ext.ctx.resources.displayMetrics.heightPixels

val screenDensity: Float
    get() = Ext.ctx.resources.displayMetrics.density

val scaledDensity: Float
    get() = Ext.ctx.resources.displayMetrics.scaledDensity

fun Context.dial(tel: String?) = startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tel)))

fun Context.sms(phone: String?, body: String = "") {
    val smsToUri = Uri.parse("smsto:" + phone)
    val intent = Intent(Intent.ACTION_SENDTO, smsToUri)
    intent.putExtra("sms_body", body)
    startActivity(intent)
}
