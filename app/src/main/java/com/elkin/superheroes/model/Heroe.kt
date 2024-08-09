package com.elkin.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Heroe(@StringRes val nombre: Int, @StringRes val descripcion: Int, @DrawableRes val imagen: Int)
