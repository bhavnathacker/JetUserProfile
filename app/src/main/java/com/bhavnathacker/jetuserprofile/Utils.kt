package com.bhavnathacker.jetuserprofile

data class ProfileEntry(val name: String, val value: String)

fun getProfileEntries(): List<ProfileEntry> {
    return listOf(ProfileEntry("Twitter", "@bhavnathacker14"),
        ProfileEntry("GitHub", "bhavnathacker"),
        ProfileEntry("YouTube", "LearnAndroid"),
        ProfileEntry("LinkedIn", "bhavna-thacker-64956985"),
        ProfileEntry("Medium", "@bhavnathacker14"))
}