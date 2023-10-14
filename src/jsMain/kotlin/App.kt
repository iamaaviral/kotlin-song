import react.*
import csstype.*
import dom.html.HTMLAudioElement

import emotion.react.css
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.audio
import web.prompts.alert


data class Song(
    val id: Int,
    val name: String,
    val artist: String,
    val album: String,
    val duration: String,
    val image: String,
    val url: String
)

val allSongs = arrayOf(
    Song(0, "Love The Way You Lie (Part 2) ft. Eminem", " Rihanna, Eminem", "Loud", "4:51", "../../../assets/song1.jpg", "../../../songs/song0.mp3"),
    Song(1, "Shape of You", "Ed Sheeran", " ÷", "3:53", "../../../assets/song2.jpg", "../../../songs/song1.mp3"),
    Song(2, "Heart Attack", " Enrique Iglesias", "Sex and Love", "2:50", "../../../assets/song3.jpg", "../../../songs/song2.mp3"),
    Song(3, "Stereo Love", "Edward Maya, Vika Jigulina", "The Stereo Love Show", "4:08", "../../../assets/song4.jpg", "../../../songs/song3.mp3")
)


val App = FC<Props> {
    var selectedSong: Song by useState(allSongs[0])

    div {
        css {
            textAlign = TextAlign.center
        }
        SongList {
            songs = allSongs
            currentSong = selectedSong
            onSelectSong = { song ->
                selectedSong = song
            }
        }
        Player {
            currentSong = selectedSong
            songs = allSongs
        }
    }
}