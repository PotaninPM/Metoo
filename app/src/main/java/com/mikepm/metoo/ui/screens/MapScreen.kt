package com.mikepm.metoo.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.mikepm.metoo.R
import kotlinx.coroutines.launch

data class EventModel(
    val latitude: Double,
    val longitude: Double,
    val creatorUserName: String,
    val eventTitle: String,
    val eventCategory: String,
    val eventDate: String,
    val eventTime: String,
    val eventLocation: String,
    val regPeopleId: List<Long>
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen() {

    val events: List<EventModel> = listOf(
        EventModel(
            latitude = 47.12,
            longitude = 34.12,
            creatorUserName = "MikePotanin",
            eventTitle = "Футбол в трах трах",
            eventCategory = "Спорт",
            eventDate = "14 December, 2021",
            eventTime = "Tuesday, 4:00PM - 9:00PM",
            eventLocation = "Gala Convention Center",
            regPeopleId = listOf(1, 2)
        ),
        EventModel(
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

    val initialPosition = LatLng(1.35, 103.87)
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
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        events.forEach { event ->
            val position = LatLng(event.latitude, event.longitude)
            Marker(
                icon = BitmapDescriptorFactory.fromResource(R.drawable.location_img),
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

@Composable
fun EventBottomSheet(event: EventModel) {

}
