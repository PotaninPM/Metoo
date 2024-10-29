package com.mikepm.metoo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.mikepm.metoo.R
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikepm.metoo.core.EventModel

@Composable
fun EventsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 10.dp)
            .windowInsetsPadding(WindowInsets.systemBars.only(WindowInsetsSides.Top))
    ) {
        //top bar
        TopBar()
        // Search bar with filter icon
        SearchEventBar()
        //Events List
        EventsList()
    }
}

@Composable
fun EventsList() {
    val eventsList: ArrayList<EventModel> = arrayListOf(
        EventModel(
            creatorUserName = "MikePotanin",
            eventTitle = "Футбол в трах трах",
            eventCategory = "Спорт",
            eventDate = "14 December, 2021",
            eventTime = "Tuesday, 4:00PM - 9:00PM",
            eventLocation = "Gala Convention Center",
            regPeopleId = listOf(1, 2)
        ),
        EventModel(
            creatorUserName = "MikePotanin",
            eventTitle = "Футбол в страино",
            eventCategory = "Спорт",
            eventDate = "14 December, 2021",
            eventTime = "Tuesday, 4:00PM - 9:00PM",
            eventLocation = "Gala Convention Center",
            regPeopleId = listOf(1, 2)
        )
    )

    LazyColumn {
        items(eventsList) { event ->
            EventCard(
                userName = event.creatorUserName,
                eventName = event.eventTitle,
                eventCategory = event.eventCategory,
                eventDate = event.eventDate,
                eventTime = event.eventTime,
                eventLocation = event.eventLocation
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchEventBar() {
    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        query = "",
        onQueryChange = {

        },
        onSearch = {},
        active = false,
        onActiveChange = {},
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        }
    ) {

    }
}

@Composable
fun TopBar() {
    val newMessages by rememberSaveable {
        mutableStateOf(10)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .size(35.dp)
                .align(Alignment.CenterVertically),
            painter = painterResource(id = R.drawable.location_img),
            contentDescription = null
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Your location")
            Text(text = "Russia, Moscow", fontWeight = FontWeight.SemiBold)
        }

        BadgedBox(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            badge = {
                if(newMessages != 0) {
                    Badge(
                        modifier = Modifier
                            .offset(x = 8.dp, y = (-8).dp)
                    ) {
                        Text(
                            newMessages.toString()
                        )
                    }
                }
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.notifications),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }

    }
}

@Composable
fun EventCard(
    userName: String,
    eventName: String,
    eventCategory: String,
    eventDate: String,
    eventTime: String,
    eventLocation: String
) {
    OutlinedCard(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(14.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFFD1E3FF), shape = RoundedCornerShape(18.dp))
                ) {
                    Text(
                        text = userName.first().toString(),
                        modifier = Modifier.align(Alignment.Center),
                        color = Color(0xFF3B5998),
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = userName, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = { /* Menu action */ }
                ) {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "Menu")
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(text = eventName, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = eventCategory, color = Color.Gray, fontSize = 14.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Outlined.DateRange, contentDescription = "Date", tint = Color(0xFF3B5998))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "$eventDate • $eventTime", color = Color.Gray, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.LocationOn, contentDescription = "Location", tint = Color(0xFF3B5998))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = eventLocation, color = Color.Gray, fontSize = 14.sp)
            }

            OutlinedButton(
                onClick = {

                }
            ) {
                Text(text = "Отказаться")
            }

            Button(
                onClick = {

                },
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Text(
                    text = "Участвовать",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                )
            }
        }
    }
}

