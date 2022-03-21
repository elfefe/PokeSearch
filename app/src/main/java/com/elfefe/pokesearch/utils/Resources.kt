package com.elfefe.pokesearch.utils

import com.elfefe.pokesearch.BaseApplication

val app = BaseApplication.instance

fun resString(id: Int, vararg format: Any) =
    if (format.isNotEmpty()) app.resources.getString(id, *format)
    else app.resources.getString(id)

fun resNameColor(name: String) = app.resources.getColor(
    app.resources.getIdentifier(
        name,
        "color",
        app.packageName
    ), null
)