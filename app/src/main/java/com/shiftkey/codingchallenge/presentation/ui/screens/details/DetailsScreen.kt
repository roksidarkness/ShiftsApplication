package com.shiftkey.codingchallenge.presentation.ui.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shiftkey.codingchallenge.presentation.ui.MainViewModel
import com.shiftkey.codingchallenge.presentation.ui.screens.textResource
import com.shiftkey.codingchallenge.presentation.ui.theme.AppTheme
import com.shiftkey.codingchallenge.R
import com.shiftkey.codingchallenge.utils.HexToJetpackColor

@Composable
fun DetailsScreen(
    selectedShift: String,
    viewModel: MainViewModel
) {

    val item by viewModel.shiftItem.observeAsState()

    item?.let{
            item ->
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Card(
                    shape = RoundedCornerShape(8.dp),
                    elevation = 2.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        TextDetails(
                            label = textResource(id = R.string.label_start_date).toString(),
                            text = item.normalizedStartDateTime,
                            null
                        )
                        TextDetails(
                            label = textResource(id = R.string.label_end_date).toString(),
                            text = item.normalizedEndDateTime,
                            null
                        )
                        CheckBoxDetails(
                            label = textResource(id = R.string.label_premium_rate).toString(),
                            isChecked = item.premiumRate
                        )
                        CheckBoxDetails(
                            label = textResource(id = R.string.label_covid).toString(),
                            isChecked = item.covid
                        )
                        TextDetails(
                            label = textResource(id = R.string.label_shift_kind).toString(),
                            text = item.shiftKind,
                            null
                        )
                        TextDetails(
                            label = textResource(id = R.string.label_within_distance).toString(),
                            text = item.withinDistance.toString(),
                            null
                        )
                        TextDetails(
                            label = textResource(id = R.string.label_facility_type).toString(),
                            text = item.facilityType.name,
                            color = item.facilityType.color
                        )
                        TextDetails(
                            label = textResource(id = R.string.label_skill).toString(),
                            text = item.skill.name,
                            color = item.skill.color
                        )
                        TextDetails(
                            label = textResource(id = R.string.label_specialty).toString(),
                            text = item.localizedSpecialty.specialty.name,
                            color = item.localizedSpecialty.specialty.color
                        )
                    }
                }
            }
        }
    }

}

@Composable
fun TextDetails(
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

@Composable
fun CheckBoxDetails(
    label: String,
    isChecked: Boolean
) {
    Row() {
        Text(
            text = "$label",
            color = AppTheme.colors.subtitleTextColor,
            modifier = Modifier
                .padding(
                    start = 6.dp,
                    end = 2.dp,
                    top = 11.dp,
                    bottom = 6.dp
                ),
            fontSize = 16.sp
        )
        Checkbox(
            checked = isChecked,
            onCheckedChange = { },
            enabled = false,
            modifier = Modifier
                .padding(
                    start = 4.dp,
                    end = 2.dp,
                    bottom = 6.dp
                )
        )
    }
}