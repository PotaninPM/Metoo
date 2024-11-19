package com.mikepm.metoo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.Coil
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.mikepm.metoo.R
import com.mikepm.metoo.core.EventModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen() {

    val events: List<EventModel> = listOf(
        EventModel(
            images = listOf("https://img.ixbt.site/live/images/original/31/96/01/2023/11/28/cc4a5af0af.jpg?w=877", "https://vet-centre.by/wp-content/uploads/2016/11/kot-v-luchah-eti-udivitelnye-kotiki.jpg"),
            latitude = 47.12,
            longitude = 34.12,
            creatorUserName = "MikePotanin",
            eventTitle = "Футбол в тра",
            eventCategory = "Спорт",
            eventDate = "14 December, 2021",
            eventTime = "Tuesday, 4:00PM - 9:00PM",
            eventLocation = "Gala Convention Center",
            regPeopleId = listOf(1, 2)
        ),
        EventModel(
            images = listOf("https://img.ixbt.site/live/images/original/31/96/01/2023/11/28/cc4a5af0af.jpg?w=877", "https://vet-centre.by/wp-content/uploads/2016/11/kot-v-luchah-eti-udivitelnye-kotiki.jpg"),
            latitude = 47.22,
            longitude = 34.15,
            creatorUserName = "MikePotanin",
            eventTitle = "Футбол в страино",
            eventCategory = "Спорт",
            eventDate = "15 December, 2021",
            eventTime = "Wednesday, 4:00PM - 9:00PM",
            eventLocation = "Gala Convention Center",
            regPeopleId = listOf(1, 2)
        )
    )

    val initialPosition = LatLng(47.12, 34.12)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(initialPosition, 10f)
    }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedEvent by remember { mutableStateOf<EventModel?>(null) }

    if (showBottomSheet && selectedEvent != null) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
                selectedEvent = null
            },
            sheetState = sheetState
        ) {
            selectedEvent?.let { event ->
                EventBottomSheet(event)
            }
        }
    }

    GoogleMap(
        modifier = Modifier
            .fillMaxSize()
            .clickable {

            },
        cameraPositionState = cameraPositionState
    ) {
        events.forEach { event ->
            val position = LatLng(event.latitude, event.longitude)
            Marker(
                //icon = BitmapDescriptorFactory.fromResource(R.drawable.friend_marker),
                state = MarkerState(position = position),
                title = event.eventTitle,
                snippet = event.eventCategory,
                onClick = {
                    selectedEvent = event
                    showBottomSheet = true
                    scope.launch {
                        sheetState.show()
                    }
                    true
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventBottomSheet(event: EventModel) {
    val imageModifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .padding(10.dp)
        .clip(RoundedCornerShape(16.dp))

    var state by remember { mutableStateOf(0) }
    val titles = listOf("Information", "Participants")

    Column {

        Image(
            painter = painterResource(id = R.drawable.moscow),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = imageModifier
        )

        PrimaryTabRow(selectedTabIndex = state) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = {

                        Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis)
                    }
                )
            }
        }
        if(state == 2) {
            EventInformation(event)
        } else if(state == 1) {
            EventParticipants()
        } else {
            EventComments()
        }
    }
}

@Composable
fun EventComments() {
    Text("1")
}

@Composable
fun EventParticipants() {
    Text("2")
}

@Composable
fun EventInformation(event: EventModel) {
    Text("3")
}
