package com.shiftkey.codingchallenge.presentation.ui.screens.shifts

import com.shiftkey.codingchallenge.presentation.ui.MainViewModel
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.shiftkey.codingchallenge.R
import com.shiftkey.codingchallenge.data.model.Shift
import com.shiftkey.codingchallenge.data.model.ShiftItem
import com.shiftkey.codingchallenge.navigation.NavigationTree
import com.shiftkey.codingchallenge.presentation.ui.screens.component.LoadingBar
import com.shiftkey.codingchallenge.presentation.ui.screens.textResource
import com.shiftkey.codingchallenge.presentation.ui.theme.AppTheme
import com.shiftkey.codingchallenge.utils.HexToJetpackColor

@Composable
fun ShiftsScreen(
    viewModel: MainViewModel,
    navController: NavController
) {
                Box {
                    val isLoading by viewModel.isLoading.observeAsState(initial = true)
                    val items by viewModel.shiftItems.observeAsState(
                        initial = emptyList())

                    ShiftList(items = items, viewModel = viewModel) { it ->
                        navController.navigate("${NavigationTree.Details.name}/${it}") {
                            popUpTo(NavigationTree.Details.name)
                        }
                    }
                    if (isLoading) {
                        LoadingBar()
                    }
                }

}


@Composable
fun ShiftList(
    items: List<Shift>,
    viewModel: MainViewModel,
    onItemClicked: (id: String) -> Unit = { }
) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(items) { item ->
            ShiftItemRow(item = item, viewModel = viewModel,
                onItemClicked = onItemClicked)
        }
    }
}

@Composable
fun ShiftItemRow(
    item: Shift,
    viewModel: MainViewModel,
    onItemClicked: (id: String) -> Unit = { }
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .clickable {
                onItemClicked(item.shift_id)
                viewModel.getDetails(item.shift_id)
            }
    ) {
        Column(modifier = Modifier.animateContentSize().padding(16.dp)) {
            Box() {
            }
            ShiftItemDetails(
                label = textResource(id = R.string.label_start_date).toString(),
                text = item.normalizedStartDateTime,
                null
            )
            ShiftItemDetails(
                label = textResource(id = R.string.label_start_date).toString(),
                text = item.localizedSpecialty.specialty.name,
                color = item.localizedSpecialty.specialty.color
            )
        }
    }
}

@Composable
fun ShiftItemDetails(
    label: String,
    text: String,
    color: String?
) {
    Row() {
        Text(
            text = "$label",
            color = AppTheme.colors.subtitleTextColor,
            modifier = Modifier
                .padding(
                    start = 6.dp,
                    end = 4.dp,
                    top = 4.dp,
                    bottom = 6.dp
                ),
            fontSize = 16.sp
        )
        Text(
            text = "$text",
            color = if (color != null) HexToJetpackColor.getColor(color)
            else AppTheme.colors.headerTextColor,
            modifier = Modifier
                .padding(
                    start = 4.dp,
                    end = 4.dp,
                    top = 4.dp,
                    bottom = 6.dp
                ),
            fontSize = 16.sp
        )
    }
}
