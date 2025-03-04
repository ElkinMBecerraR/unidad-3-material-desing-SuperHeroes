package com.elkin.superheroes


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.elkin.superheroes.data.Heroes
import com.elkin.superheroes.ui.theme.SuperHeroesTheme
import com.elkin.superheroes.vistas.ListHeroes


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) { SuperHeroes() }
            }
        }
    }
}

@Composable
fun SuperHeroes() {
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar() }) {
        val heroes = Heroes.listaHeroes
        ListHeroes(heroes = heroes, contentPadding = it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.displayLarge
        )
    }, modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun PreviewHeroes() {
    SuperHeroesTheme {
        SuperHeroes()
    }
}
